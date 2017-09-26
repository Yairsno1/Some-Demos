/*
 * CustomStrategyForm.java
 *
 * Created on 24 פברואר 2006, 17:33
 */

package StrategyExplorer.ui;

/**
 *
 * @author  Yair
 */

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.ButtonGroup;
import java.awt.GridLayout;
import java.lang.Long;
import java.util.Vector;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.table.*;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardLegend;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.LineAndShapeRenderer;
import org.jfree.data.CategoryDataset;
import org.jfree.data.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import StrategyExplorer.*;
import StrategyExplorer.ui.infrastructure.StraddleView;
import StrategyExplorer.ui.infrastructure.RangeSpinners;
import StrategyExplorer.ui.infrastructure.MultiSelector;

import ybaselib.ui.MdiChild;

public class CustomStrategyForm extends MdiChild
{    
  private static final String PREFIX_CALL = "C";
  private static final String PREFIX_PUT = "P";
    
  private StraddleView m_positionGrid;
  private DefaultTableModel m_positionGridModel;
  private JTable m_tblView;
  private DefaultTableModel m_tableViewModel;
  private JFreeChart m_chart;
  private DefaultCategoryDataset m_graphDataset;
  private RangeSpinners m_rngView;
  private MultiSelector m_msPreExpVal;
  
  public CustomStrategyForm() 
  {
    super("Custom Strategy Simulator",true,true,true,true);
    init();          
  }
    
  private void init()
  {
    JPanel pnlMain;
    
    pnlMain = new JPanel();
    pnlMain.setLayout(new BorderLayout());
    
    pnlMain.add(createViewPanel(),BorderLayout.CENTER);    
    pnlMain.add(createInputPanel(),BorderLayout.WEST);    
    
    getContentPane().add(pnlMain);
    pack();
  }
  
  private JPanel createViewPanel()
  {
    JPanel rv;
    Vector gridHdr;    
    
    rv = new JPanel();
    rv.setLayout(new BorderLayout());
   
    m_rngView = new RangeSpinners(RangeSpinners.CTRL_ORIENTATION_HORZ);
    m_rngView.getLowLabel().setText("From Strike:");
    m_rngView.getLowLabel().setHorizontalAlignment(SwingConstants.RIGHT);
    m_rngView.getHighLabel().setText("To Strike:");
    m_rngView.getHighLabel().setHorizontalAlignment(SwingConstants.RIGHT);
    m_rngView.getStepLabel().setHorizontalAlignment(SwingConstants.RIGHT);
    m_rngView.setHigh(900.);
    m_rngView.setLow(700.);
    m_rngView.setStep(10.);
    rv.add(m_rngView.getPanel(),BorderLayout.NORTH);    

    createChart();
    final ChartPanel chartPanel = new ChartPanel(m_chart);
    chartPanel.setPreferredSize(new Dimension(540,480));
    rv.add(chartPanel,BorderLayout.CENTER); 

    JPanel pnlTableView = new JPanel();
    pnlTableView.setLayout(new BorderLayout());    
    int[] days = {21,15,8,3};
    m_msPreExpVal = new MultiSelector(days);
    pnlTableView.add(m_msPreExpVal.getPanel(),BorderLayout.NORTH); 
    m_tableViewModel = new DefaultTableModel();
    gridHdr = new Vector();
    gridHdr.add(new String("Spot"));
    gridHdr.add(new String("Cash Flow"));
    gridHdr.add(new String("Cost"));
    gridHdr.add(new String("Value"));
    m_tableViewModel.setColumnIdentifiers(gridHdr);
    buildTableRows();
    m_tblView = new JTable(m_tableViewModel);    
    JScrollPane scrlPane = new JScrollPane(m_tblView);
    m_tblView.setPreferredScrollableViewportSize(new Dimension(200,200));        
    pnlTableView.add(scrlPane,BorderLayout.CENTER); 
    JButton btnRun = new JButton("Run!");
     btnRun.addActionListener(new ActionListener()
     {
       public void actionPerformed(ActionEvent p_ae)
       {
         btnRunActionPerformed(p_ae);
       }
     });
     pnlTableView.add(btnRun,BorderLayout.SOUTH); 
    rv.add(pnlTableView,BorderLayout.EAST); 
    
    return rv;
  }
  
  private JPanel createInputPanel()
  {
    JPanel rv = null;
    
    m_positionGrid = new StraddleView(730.00F,890.0F,10.00F);                
    m_positionGrid.setPrefferdSize(new Dimension(200,200));
    rv = m_positionGrid.getPanel();
    return rv;
  }
  
  private void createChart()
  {
    m_graphDataset = new DefaultCategoryDataset();    
    m_chart = ChartFactory.createLineChart
    (
      "Expiration Graph",       // chart title
      "Spot",                    // domain axis label
      "Value",                   // range axis label
      m_graphDataset,                   // data
      PlotOrientation.VERTICAL,  // orientation
      true,                      // include legend
      true,                      // tooltips
      false                      // urls
    );

    // NOW DO SOME OPTIONAL CUSTOMISATION OF THE CHART...
    final StandardLegend legend = (StandardLegend)m_chart.getLegend();
    legend.setDisplaySeriesShapes(true);
    legend.setShapeScaleX(1.5);
    legend.setShapeScaleY(1.5);
    legend.setDisplaySeriesLines(true);
    
    m_chart.setBackgroundPaint(Color.white);

    final CategoryPlot plot = (CategoryPlot)m_chart.getPlot();
    plot.setBackgroundPaint(Color.lightGray);
    plot.setRangeGridlinePaint(Color.white);

    // customise the range axis...
    final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
    rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
    rangeAxis.setAutoRangeIncludesZero(true);
    
    // customise the renderer...
    final LineAndShapeRenderer renderer = (LineAndShapeRenderer)( plot.getRenderer());
    renderer.setDrawShapes(true);

    renderer.setSeriesStroke(0,
                                         new BasicStroke(2.0f,
                                                                  BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND,
                                                                  1.0f,
                                                                  new float[] {10.0f, 6.0f},
                                                                 0.0f ));
  }
  
  private void buildTableRows()
  {
    Vector row;
    
    m_tableViewModel.setRowCount(0);
    for (double i = m_rngView.getLow(); i <= m_rngView.getHigh(); i+=m_rngView.getStep())
    {
      row = new Vector();

      row.add(new Double(i));
      row.add(new Double(0));
      row.add(new Double(0));
      row.add(new Double(0));
      m_tableViewModel.addRow(row);
    }          
  }
  
   //------------------------------------------------------------
  //-------------------Events' Callbacks ---------------------
    
  public void btnRunActionPerformed(ActionEvent p_ae)
  {
    int i = 0;  
    int sz = 0;
    PositionGridRow pgr = null;
    OptionPosition optPos = null;
    Strategy strtgy = null;
    double val = 0.0;
    double val1 = 0.0;
    double cost;
   
    buildTableRows();
    m_graphDataset.clear();
    
    strtgy = m_positionGrid.getStrategy();
    cost = strtgy.getCost();
    
    for (double strike = m_rngView.getLow(); strike <= m_rngView.getHigh(); strike+=m_rngView.getStep())
    {
      val = strtgy.expirationValue(strike);  
      
      m_tableViewModel.setValueAt(new Double(val-strtgy.getCost()),i,1);
      m_tableViewModel.setValueAt(new Double(strtgy.getCost()),i,2);
      m_tableViewModel.setValueAt(new Double(val),i,3);
      
      m_graphDataset.addValue(val,"ExpGraph",new Double(strike).toString());
      int[] selected = m_msPreExpVal.getSelected();
      if (selected != null)
      {
        for(int j=0; j<selected.length; j++)
        {
          val1 = strtgy.BandSPrice(strike,
                                             5/100.,
                                             m_msPreExpVal.getIV()/100.,
                                             selected[j]);      
          m_graphDataset.addValue(val1,
                                 selected[j] + "Days",
                                 new Double(strike).toString());    
        }
      }
      
      ++i;
    }
  }
  
  //------------------------------------------------------------

  //------------------------------------------------------------
  //-------------------- Inner Classes -----------------------
  private class PositionGridRow implements Comparable
  {
    private String mPrefix;
    private IOptionInf mOpt;
    private long mQty;
        
    public PositionGridRow(String pOptPrefix, long pStrike)
    {
      mPrefix =  pOptPrefix;          
      if (mPrefix.equals(PREFIX_CALL))
      {
        mOpt = new CallOpt(pStrike);      
      }
      else
      {
        mOpt = new PutOpt(pStrike);          
      }
      mQty = 0;      
    }
    
    public PositionGridRow(String pOptPrefix, long pStrike, long pQty)
    {
      this(pOptPrefix,pStrike);    
      mQty = pQty;
    }
    
    public IOptionInf getOption()
    {
      return mOpt;
    }
    
    public long getQty()
    {
      return mQty;    
    }

    public void setQty( long pQty)
    {
      mQty = pQty;
    }
    
    public String toString()
    {
      return new String(mPrefix + mOpt.strike());    
    }    
    
    public int compareTo(Object o)
    {
      int rv = 0;
      PositionGridRow RHS;
      
      RHS = (PositionGridRow)o;
      if (this.toString().equals(RHS.toString())) 
      {
        rv = 0;    
      }
      else if (this.getOption().strike() < RHS.getOption().strike())
      {
        rv = -1;    
      }
      else if (this.getOption().strike() > RHS.getOption().strike())
      {
        rv = 1;    
      }
      else
      {
        rv = mPrefix.equals(PREFIX_CALL) ? 1 : -1;  
      }
      
      return rv;
    }
    
  } //End Class PositionGridRow
  
}
