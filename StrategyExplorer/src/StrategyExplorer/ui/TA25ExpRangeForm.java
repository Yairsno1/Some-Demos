/*
 * TA25ExpRangeForm.java
 *
 * Created on 11 מרץ 2006, 23:49
 */

package StrategyExplorer.ui;

/**
 *
 * @author  Yair
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.text.DecimalFormat;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.BarRenderer;
import org.jfree.data.CategoryDataset;
import org.jfree.data.DefaultCategoryDataset;
import org.jfree.ui.RefineryUtilities;

import StrategyExplorer.TA25Stat.AbstractPriceRangeDistribution;
import StrategyExplorer.TA25Stat.DayBeforePriceRangeDistribution;
import StrategyExplorer.TA25Stat.ExpirationPriceRangeDistribution;
import StrategyExplorer.TA25Stat.ExtremePriceRangeDistribution;
import StrategyExplorer.TA25Stat.PctPriceRangeDistribution;
import StrategyExplorer.TA25Stat.SortedPriceRangeDistribution;
import StrategyExplorer.TA25Stat.IPriceRangeDistribution;
import StrategyExplorer.TA25Stat.IPriceRangeItem;
import StrategyExplorer.TA25Stat.TA25ExpBook;
import StrategyExplorer.TA25Stat.TA25ExpPaeser;
//import StrategyExplorer.ui.infrastructure.MdiChild;

import ybaselib.ui.MdiChild;

public class TA25ExpRangeForm extends MdiChild
{
  private final static double M_DEFAULT_RANGE = 5.;
  private final static double M_DEFAULT_RANGE_PCT = 1.;
  
  private TA25ExpBook m_expBook;
  private JFreeChart m_chart;
  private DefaultCategoryDataset m_graphDataset;
  private IPriceRangeDistribution m_activeRangeDistr;
  private JLabel lblAvg;
  private JLabel lblStdDev;
  private JLabel lblRange1;
  private JLabel lblRange2;
  
  public TA25ExpRangeForm() 
  {
    super("TA25 Expiration Range Analysis",true,true,true,true);
    
    m_activeRangeDistr = null;
    createExpBook();
    if (m_expBook != null)
    {
      m_activeRangeDistr =  new ExpirationPriceRangeDistribution(m_expBook, M_DEFAULT_RANGE);
    }    
    
    init();
  }
    
  private void init()
  {
    JPanel pnlMain;
    
    pnlMain = new JPanel();
    pnlMain.setLayout(new BorderLayout());

    createChart();
    ChartPanel chartPanel = new ChartPanel(m_chart);
    chartPanel.setPreferredSize(new Dimension(480,360));
    pnlMain.add(chartPanel,BorderLayout.CENTER); 
    
    pnlMain.add(createInputPanel(),BorderLayout.WEST); 
    pnlMain.add(createStatPanel(),BorderLayout.EAST); 

    getContentPane().add(pnlMain);
    pack();
  }
    
  private JPanel createInputPanel()
  {
    JPanel rv = null;
    
    rv = new JPanel();
    rv.setLayout(new GridLayout(0,1));
    
    JRadioButton radExp = new JRadioButton("At expiration");
     radExp.addActionListener(new ActionListener()
     {
       public void actionPerformed(ActionEvent p_ae)
       {
         radExpActionPerformed(p_ae,0);
       }
     });    
    radExp.setSelected(true);
    rv.add(radExp);
    JRadioButton radExpPct = new JRadioButton("At expiration (%)");
     radExpPct.addActionListener(new ActionListener()
     {
       public void actionPerformed(ActionEvent p_ae)
       {
         radExpActionPerformed(p_ae,1);
       }
     });    
    rv.add(radExpPct);    
    JRadioButton radDayBefore = new JRadioButton("Day before");
     radDayBefore.addActionListener(new ActionListener()
     {
       public void actionPerformed(ActionEvent p_ae)
       {
         radDayBeforeActionPerformed(p_ae,0);
       }
     });        
    rv.add(radDayBefore);    
    JRadioButton radDayBeforePct = new JRadioButton("Day before(%)");
     radDayBeforePct.addActionListener(new ActionListener()
     {
       public void actionPerformed(ActionEvent p_ae)
       {
         radDayBeforeActionPerformed(p_ae,1);
       }
     });        
    rv.add(radDayBeforePct);        
    JRadioButton radExtreme = new JRadioButton("Extremes");
     radExtreme.addActionListener(new ActionListener()
     {
       public void actionPerformed(ActionEvent p_ae)
       {
         radExtremeActionPerformed(p_ae,0);
       }
     });        
     rv.add(radExtreme);
    JRadioButton radExtremePct = new JRadioButton("Extremes(%)");
     radExtremePct.addActionListener(new ActionListener()
     {
       public void actionPerformed(ActionEvent p_ae)
       {
         radExtremeActionPerformed(p_ae,1);
       }
     });             
    rv.add(radExtremePct);
    ButtonGroup bgrpGroup = new ButtonGroup();
    bgrpGroup.add(radExp);
    bgrpGroup.add(radExpPct);
    bgrpGroup.add(radDayBefore);
    bgrpGroup.add(radDayBeforePct);
    bgrpGroup.add(radExtreme);
    bgrpGroup.add(radExtremePct);
        
    JButton btnRefresh = new JButton("Refresh");
     btnRefresh.addActionListener(new ActionListener()
     {
       public void actionPerformed(ActionEvent p_ae)
       {
         btnRefreshActionPerformed(p_ae);
       }
     });
    rv.add(btnRefresh);
    
    return rv;
  }
  
  private void createChart()
  {
    m_graphDataset = new DefaultCategoryDataset();        
    
    m_chart = ChartFactory.createBarChart(
      "Expiration Range Distribution",         // chart title
      "Range",               // domain axis label
      "Count",                  // range axis label
      m_graphDataset,                  // data
      PlotOrientation.VERTICAL, // orientation
      true,                     // include legend
      true,                     // tooltips?
      false                     // URLs?
    );

    // NOW DO SOME OPTIONAL CUSTOMISATION OF THE CHART...

    // set the background color for the chart...
    m_chart.setBackgroundPaint(Color.white);

    // get a reference to the plot for further customisation...
    final CategoryPlot plot = m_chart.getCategoryPlot();
    plot.setBackgroundPaint(Color.lightGray);
    plot.setDomainGridlinePaint(Color.white);
    plot.setRangeGridlinePaint(Color.white);

    // set the range axis to display integers only...
    final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
    rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

    // disable bar outlines...
    final BarRenderer renderer = (BarRenderer) plot.getRenderer();
    renderer.setDrawBarOutline(false);
        
    // set up gradient paints for series...
    final GradientPaint gp0 = new GradientPaint(
             0.0f, 0.0f, Color.blue, 
             0.0f, 0.0f, Color.lightGray
          );
    renderer.setSeriesPaint(0, gp0);

    final CategoryAxis domainAxis = plot.getDomainAxis();
    domainAxis.setCategoryLabelPositions(
       CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 6.0) );
        // OPTIONAL CUSTOMISATION COMPLETED.           
  }

  private JPanel createStatPanel()
  {
    JPanel rv = null;
    
    rv = new JPanel();
    rv.setLayout(new GridLayout(0,1));

    lblAvg = new JLabel("E = ?????");
    rv.add(lblAvg);
    lblStdDev = new JLabel("SD = ?????");
    rv.add(lblStdDev);
    lblRange1 = new JLabel("-SD .. +SD = ????? .. ?????");
    rv.add(lblRange1);
    lblRange2 = new JLabel("-2SD .. +2SD = ????? .. ?????");
    rv.add(lblRange2);
    
    return rv;
  }  
  
  private void createExpBook()
  {
    TA25ExpPaeser parser = null;
    
    if (null == m_expBook)
    {
      parser = new TA25ExpPaeser("c:/bursa/dev/strategyexplorer/data/Book_Exp.csv");    
      m_expBook = parser.getExpBook();
    } 
  }
  
  private void refreshStat()
  {
    double avg;
    double sd;
    DecimalFormat formatter = null;
    
    formatter = new DecimalFormat("#.##");
    avg = m_activeRangeDistr.avrg();
    sd = m_activeRangeDistr.stdDev();

    lblAvg.setText("E =  " + formatter.format(avg));
    lblStdDev.setText("SD = " + formatter.format(sd));    
    lblRange1.setText("-SD .. +SD(" + 
                              formatter.format(avg - sd) +
                              " .. " +
                              formatter.format(avg + sd) +
                              ")");
    lblRange2.setText("-2SD .. +2SD(" + 
                              formatter.format(avg - (2.*sd)) +
                              " .. " +
                              formatter.format(avg + (2.*sd)) +
                              ")");    
  }
   //------------------------------------------------------------
  //-------------------Events' Callbacks ---------------------
  public void btnRefreshActionPerformed(ActionEvent p_ae)
  {
    long sz = 0;  
    int i = 0;
    IPriceRangeItem item = null;
    String col = null;
    IPriceRangeDistribution sortedRangeDistr = null;
    
    m_graphDataset.clear();  
    if (m_activeRangeDistr != null)
    {            
      sortedRangeDistr = new SortedPriceRangeDistribution(m_activeRangeDistr);  
      sortedRangeDistr.calc();

      sz = sortedRangeDistr.itemCount();
      for(i=0; i<sz; i++)
      {
        item = sortedRangeDistr.item(i);
        col = Double.toString(item.normal());
        m_graphDataset.addValue(item.count(),"ExpDist",col);
      }
      refreshStat();
    }
  }

  public void radExpActionPerformed(ActionEvent p_ae, int p_kind)
  {
    ExpirationPriceRangeDistribution expRangeDistr = null;
    
    if (m_expBook != null)
    {
      expRangeDistr = new ExpirationPriceRangeDistribution(m_expBook, M_DEFAULT_RANGE);
      m_activeRangeDistr = expRangeDistr;
      if (1 == p_kind)
      {
        expRangeDistr.setRange(M_DEFAULT_RANGE_PCT);  
        m_activeRangeDistr =  new PctPriceRangeDistribution(expRangeDistr);        
      }
    }    
  }

  public void radDayBeforeActionPerformed(ActionEvent p_ae, int p_kind)
  {
    DayBeforePriceRangeDistribution dayBeforeRangeDistr = null;
    
    if (m_expBook != null)
    {
      dayBeforeRangeDistr = new DayBeforePriceRangeDistribution(m_expBook, M_DEFAULT_RANGE);
      m_activeRangeDistr = dayBeforeRangeDistr;
      if (1 == p_kind)
      {
        dayBeforeRangeDistr.setRange(M_DEFAULT_RANGE_PCT);  
        m_activeRangeDistr =  new PctPriceRangeDistribution(dayBeforeRangeDistr);        
      }
    }    
  }

  public void radExtremeActionPerformed(ActionEvent p_ae, int p_kind)
  {
    if (m_expBook != null)
    {
      m_activeRangeDistr =  new ExtremePriceRangeDistribution(m_expBook, M_DEFAULT_RANGE);
    }    
    ExtremePriceRangeDistribution extRangeDistr = null;
    
    if (m_expBook != null)
    {
      extRangeDistr = new ExtremePriceRangeDistribution(m_expBook, M_DEFAULT_RANGE);
      m_activeRangeDistr = extRangeDistr;
      if (1 == p_kind)
      {
        extRangeDistr.setRange(M_DEFAULT_RANGE_PCT);  
        m_activeRangeDistr =  new PctPriceRangeDistribution(extRangeDistr);        
      }
    }        
  }
  
}
