/*
 * StrategyCompareForm.java
 *
 * Created on 25 מרץ 2006, 09:30
 */

package StrategyExplorer.ui;

/**
 *
 * @author  Yair
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

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
import StrategyExplorer.ui.infrastructure.Decimal2TextWraper;
import StrategyExplorer.ui.infrastructure.RangeSpinners;
import StrategyExplorer.ui.infrastructure.StraddleView;
import StrategyExplorer.web.*;

import ybaselib.ui.MdiChild;

public class StrategyCompareForm  extends MdiChild
{
  private final String M_STRATEGY1_TEXT = "Strategy #1";
  private final String M_STRATEGY2_TEXT = "Strategy #2";
  
  private JFreeChart m_chart;
  private DefaultCategoryDataset m_graphDataset;
  private RangeSpinners m_rngView;
  private StraddleView m_strgyGrid1;
  private StraddleView m_strgyGrid2;
  private boolean m_atExp;
  private JSpinner m_days2Exp;
  private Decimal2TextWraper m_d2twIV;
  
  public StrategyCompareForm() 
  {
    super("Compare Strategies",true,true,true,true);    
    m_atExp = false;
    init();
    pack();
  }
    
  private void init()
  {
    JPanel pnlMain;
    
    pnlMain = new JPanel();
    pnlMain.setLayout(new BorderLayout());
    
    pnlMain.add(createChart(),BorderLayout.CENTER);    
    pnlMain.add(createStrategyGrids(),BorderLayout.WEST);    
    pnlMain.add(createCompareAtPanel(),BorderLayout.EAST);    
    
    getContentPane().add(pnlMain);      
  }

  private JPanel createCompareAtPanel()
  {
    JPanel rv = null;
    
    rv = new JPanel();
    rv.setLayout(new GridLayout(0,1));
    
    JRadioButton radExp = new JRadioButton("At Expiration");
     radExp.addActionListener(new ActionListener()
     {
       public void actionPerformed(ActionEvent p_ae)
       {
         radExpActionPerformed(p_ae);
       }
     });
    rv.add(radExp);

    JPanel pnlBefore = new JPanel();
    GridBagLayout gbLayout = new GridBagLayout();
    GridBagConstraints gbConstr = new GridBagConstraints();
    pnlBefore.setLayout(gbLayout);
    gbConstr.fill = GridBagConstraints.HORIZONTAL;     
    JRadioButton radBefore = new JRadioButton("");
    radBefore.setSelected(true);
    radBefore.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent p_ae)
      {
        radBeforeActionPerformed(p_ae);
      }
    });
    gbLayout.setConstraints(radBefore,gbConstr);
    pnlBefore.add(radBefore);
    ButtonGroup grp = new ButtonGroup();
    grp.add(radExp);
    grp.add(radBefore);     
    m_days2Exp = new JSpinner();
    m_days2Exp.setValue(new Integer(16));
    gbLayout.setConstraints(m_days2Exp,gbConstr);
    pnlBefore.add(m_days2Exp);
    JLabel lblDays = new JLabel(" Day(s) to ..");
    gbLayout.setConstraints(lblDays,gbConstr);
    pnlBefore.add(lblDays);
    rv.add(pnlBefore);

    JPanel pnlIV = new JPanel();
    pnlIV.setLayout(new FlowLayout());
    JLabel lblIV = new JLabel("IV:");
    lblIV.setHorizontalAlignment(SwingConstants.RIGHT);
    pnlIV.add(lblIV);
    m_d2twIV = new Decimal2TextWraper();
    m_d2twIV.getTextField().setValue(new Integer(20));
    pnlIV.add(m_d2twIV.getTextField());
    rv.add(pnlIV);
    
    JButton btnCompare = new JButton("Compare");
    btnCompare.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent p_ae)
      {
        btnCompareActionPerformed(p_ae);
      }
    });    
    rv.add(btnCompare);
    
    
    JButton btnBizportal = new JButton("Bizportal");
    //btnBizportal.setEnabled(false);
    btnBizportal.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent p_ae)
      {
        btnBizportalActionPerformed(p_ae);
      }
    });    
    rv.add(btnBizportal);
    
    return rv;
  }
  
  private JPanel createStrategyGrids()
  {
    JPanel rv = null;
    
    rv = new JPanel();
    rv.setLayout(new GridLayout(0,1));
    
    m_strgyGrid1 = new StraddleView(730.00F,890.0F,10.00F);                
    m_strgyGrid1.setPrefferdSize(new Dimension(200,120));
    TitledBorder border1 = BorderFactory.createTitledBorder(M_STRATEGY1_TEXT);
    m_strgyGrid1.getPanel().setBorder(border1); 
    rv.add(m_strgyGrid1.getPanel());

    m_strgyGrid2 = new StraddleView(730.00F,890.0F,10.00F);                
    m_strgyGrid2.setPrefferdSize(new Dimension(200,120));
    TitledBorder border2 = BorderFactory.createTitledBorder(M_STRATEGY2_TEXT);
    m_strgyGrid2.getPanel().setBorder(border2);     
    rv.add(m_strgyGrid2.getPanel());
    
    return rv;
  }
  
  private JPanel createChart()
  {
    JPanel rv = null;
    
    rv = new JPanel();
    rv.setLayout(new BorderLayout());

    m_graphDataset = new DefaultCategoryDataset();    
    m_chart = ChartFactory.createLineChart
    (
      "Compare Graph",       // chart title
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
    final ChartPanel chartPanel = new ChartPanel(m_chart);
    chartPanel.setPreferredSize(new Dimension(640,480));
    rv.add(chartPanel,BorderLayout.CENTER); 

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
    
    return rv;
  }

  private int getDays()
  {
    return ((Integer)m_days2Exp.getValue()).intValue();
  }
  
  private double getIV()
  {
    return Double.parseDouble(m_d2twIV.getTextField().getValue().toString());
  }
  
   //------------------------------------------------------------
  //-------------------Events' Callbacks ---------------------
  private void radExpActionPerformed(ActionEvent p_ae)
  {
    m_atExp = true;
    m_days2Exp.setEnabled(false);
    m_d2twIV.getTextField().setEnabled(false);    
  }
  
  private void radBeforeActionPerformed(ActionEvent p_ae)
  {
    m_atExp = false;  
    m_days2Exp.setEnabled(true);
    m_d2twIV.getTextField().setEnabled(true);
  }

  private void btnCompareActionPerformed(ActionEvent p_ae)
  {
    int i = 0;  
    int sz = 0;
    Strategy strtgy1 = null;
    Strategy strtgy2 = null;
    double cost1;
    double cost2;
    double val1 = 0.0;
    double val2 = 0.0;
    double IV = 20.;
    double days = 17;
    
    m_graphDataset.clear();
    
    IV = getIV();
    days = getDays();
    strtgy1 = m_strgyGrid1.getStrategy();
    cost1 = strtgy1.getCost();
    strtgy2 = m_strgyGrid2.getStrategy();
    cost2 = strtgy2.getCost();
    
    for (double strike = m_rngView.getLow(); strike <= m_rngView.getHigh(); strike+=m_rngView.getStep())
    {
      if (m_atExp)
      {
        val1 = strtgy1.expirationValue(strike);      
        val2 = strtgy2.expirationValue(strike);      
      }
      else
      {
        val1 = strtgy1.BandSPrice(strike,
                                             5/100.,
                                             IV/100.,
                                             days);      
        val2 = strtgy2.BandSPrice(strike,
                                             5/100.,
                                             IV/100.,
                                             days);                
      }
                  
      m_graphDataset.addValue(val1,M_STRATEGY1_TEXT,new Double(strike).toString());
      m_graphDataset.addValue(val2,M_STRATEGY2_TEXT,new Double(strike).toString());
      
      ++i;
    }
  }

  private void btnBizportalActionPerformed(ActionEvent p_ae)
  {
     BizportalTA25OptionsReader biz = new BizportalTA25OptionsReader();
     biz.readPage();
  }
  
}
