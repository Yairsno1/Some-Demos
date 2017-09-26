/*
 * MainWin.java
 *
 * Created on 24 פברואר 2006, 16:38
 */

package StrategyExplorer.ui;

/**
 *
 * @author  Yair
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.WindowConstants;

public class MainWin extends JFrame
{    
  private JDesktopPane m_desktopPane;
  private JMenuBar m_mainMenu;  
  
  public MainWin()
  {
    super("Options Strategy Explorer v0.2");
     init();
  }
   
  private void init()
  {
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);    
    addWindowListener(new WindowAdapter() 
    {
      public void windowClosing(WindowEvent p_we)
      {
        winClosingEvent(p_we);
      }
    });       
    
    m_desktopPane = new JDesktopPane();
    setContentPane(m_desktopPane);
    m_desktopPane.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);     
  
    buildMenu();
    
    pack();
  }
  
  private void buildMenu()
  {
    JMenu mnuSimu = null;  
      JMenuItem mnuiCustomSimu;
      JMenuItem mnuiCompare;
    JMenu mnuAnalysis = null;  
      JMenuItem mnuiTA25RangeAnalysis;
      
    m_mainMenu = new JMenuBar();  
    
    //Simulator Menu
    mnuSimu = new JMenu("Simulator");
    
    mnuiCustomSimu = new JMenuItem("Custom");
    mnuiCustomSimu.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent p_ae)
      {
        customSimuMIActionPerformed(p_ae);
      }
    });
    mnuSimu.add(mnuiCustomSimu);    
    mnuiCompare = new JMenuItem("Compare");
    mnuiCompare.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent p_ae)
      {
        compareMIActionPerformed(p_ae);
      }
    });
    mnuSimu.add(mnuiCompare);    
    
    //Analysis Menu
    mnuAnalysis = new JMenu("Analysis");
    
    mnuiTA25RangeAnalysis = new JMenuItem("TA25 Expiration Range");
    mnuiTA25RangeAnalysis.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent p_ae)
      {
        TA25RangeAnalysisMIActionPerformed(p_ae);
      }
    });
    mnuAnalysis.add(mnuiTA25RangeAnalysis);    
    
    m_mainMenu.add(mnuSimu);
    m_mainMenu.add(mnuAnalysis);
    
    setJMenuBar(m_mainMenu);
  }

  //------------------------------------------------------------
  //-------------------Events' Callbacks ---------------------
  private void winClosingEvent(WindowEvent p_winEvent)
  {
    exitWin();
  }
  
  private void customSimuMIActionPerformed(ActionEvent p_ae)
  {
    CustomStrategyForm frmCustom = new CustomStrategyForm();
    getContentPane().add(frmCustom);
    frmCustom.setVisible(true);    
  }

  private void compareMIActionPerformed(ActionEvent p_ae)
  {
    StrategyCompareForm frmCompare = new StrategyCompareForm();
    getContentPane().add(frmCompare);
    frmCompare.setVisible(true);    
  }
  
  private void TA25RangeAnalysisMIActionPerformed(ActionEvent p_ae)
  {
    TA25ExpRangeForm frmTA25ExpRange = new TA25ExpRangeForm();
    getContentPane().add(frmTA25ExpRange);
    frmTA25ExpRange.setVisible(true);          
  }
  //------------------------------------------------------------
  
  private void exitWin()
  {
    System.exit(0);
  }
   
  
    //------------------------------------------
    //-------- This is main!! ------------------
    public static void main(String args[])
    {
      new MainWin().show();
    }
    //------------------------------------------

}
