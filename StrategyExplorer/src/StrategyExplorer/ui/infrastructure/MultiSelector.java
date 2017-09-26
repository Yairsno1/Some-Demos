/*
 * MultiSelector.java
 *
 * Created on 24 מרץ 2006, 23:54
 */

package StrategyExplorer.ui.infrastructure;

/**
 *
 * @author  Yair
 */

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class MultiSelector
{
  private final double M_DEFAULT_IV = 20.;  
  private JPanel m_pnl;  
  private Decimal2TextWraper m_d2twIV;
  private ArrayList m_dayControls;
  
  public MultiSelector(int[] p_days) 
  {
    m_dayControls = new ArrayList();  
    createUI(p_days);    
  }

  public JPanel getPanel()
  {
    return m_pnl;    
  }
  
  public int[] getSelected()
  {
    int[] rv = null;    
    int sz = 0;
    CheckDaysControl dayCtrl = null;
    Iterator it = null;
    int i = 0;
    
    sz = getSelectedCount();
    if (sz > 0)
    {
      rv = new int[sz];
      it = m_dayControls.iterator();
      while (it.hasNext())
      {
        dayCtrl = (CheckDaysControl)it.next();          
        if (dayCtrl.isSelected())
        {
           rv[i++] = dayCtrl.getDays();     
        }
      }
    }    
    
    return rv;
  }
  
  public double getIV()
  {
    return Double.parseDouble(m_d2twIV.getTextField().getValue().toString());
  }
  
  public void setIV(double p_IV)
  {
    m_d2twIV.getTextField().setValue(new Double(p_IV));    
  }
  
  private void createUI(int[] p_days)
  {
    int i = 0;
    int sz = 0;
    CheckDaysControl dayCtrl;
    
    m_pnl = new JPanel();
    m_pnl.setLayout(new BorderLayout());
    
    JPanel pnlIV = new JPanel();
    pnlIV.setLayout(new FlowLayout());
    JLabel lblIV = new JLabel("IV:");
    lblIV.setHorizontalAlignment(SwingConstants.RIGHT);
    pnlIV.add(lblIV);
    m_d2twIV = new Decimal2TextWraper();
    setIV(M_DEFAULT_IV);
    pnlIV.add(m_d2twIV.getTextField());
    m_pnl.add(pnlIV,BorderLayout.NORTH);
    
    JPanel pnlDays = new JPanel();
    pnlDays.setLayout(new GridLayout(0,1));
    sz = p_days.length;
    for(i=0; i<sz; i++)
    {
      dayCtrl = new CheckDaysControl(false,p_days[i]);
      m_dayControls.add(dayCtrl);
      pnlDays.add(dayCtrl.getPanel());
    }
    m_pnl.add(pnlDays,BorderLayout.CENTER);
    
    JPanel pnlSelection = new JPanel();
    pnlSelection.setLayout(new GridLayout(1,0));
    JButton btnSelectAll = new JButton("Select All");
     btnSelectAll.addActionListener(new ActionListener()
     {
       public void actionPerformed(ActionEvent p_ae)
       {
         btnSelectAllActionPerformed(p_ae);
       }
     });    
    pnlSelection.add(btnSelectAll);
    JButton btnUnSelectAll = new JButton("Unselect All");
     btnUnSelectAll.addActionListener(new ActionListener()
     {
       public void actionPerformed(ActionEvent p_ae)
       {
         btnUnSelectAllActionPerformed(p_ae);
       }
     });    
    pnlSelection.add(btnUnSelectAll);
    m_pnl.add(pnlSelection,BorderLayout.SOUTH);
    
  }
    
  private void selectAll(boolean p_select)
  {
    CheckDaysControl dayCtrl = null;
    Iterator it = null;
    
    it = m_dayControls.iterator();
    while (it.hasNext())
    {
      dayCtrl = (CheckDaysControl)it.next();    
      dayCtrl.setSelected(p_select);
    }
  }

  public int getSelectedCount()
  {
    int rv = 0;    
    CheckDaysControl dayCtrl = null;
    Iterator it = null;
    
    it = m_dayControls.iterator();
    while (it.hasNext())
    {
      dayCtrl = (CheckDaysControl)it.next();          
      if (dayCtrl.isSelected())
      {
         ++rv;     
      }
    }
    
    return rv;
  }
  
  //------------------------------------------------------------
  //-------------------Events' Callbacks ---------------------
  private void btnSelectAllActionPerformed(ActionEvent p_ae)
  {
    selectAll(true);
  }

  private void btnUnSelectAllActionPerformed(ActionEvent p_ae)
  {
    selectAll(false);
  }
  
}
