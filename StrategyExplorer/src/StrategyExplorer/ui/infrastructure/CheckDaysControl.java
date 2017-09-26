/*
 * CheckDaysControl.java
 *
 * Created on 22 מרץ 2006, 23:35
 */

package StrategyExplorer.ui.infrastructure;

/**
 *
 * @author  Yair
 */

import java.awt.*;
import javax.swing.*;

public class CheckDaysControl 
{
    private JPanel m_pnl;
    private JCheckBox m_cbSelected;
    private JSpinner m_spnDays;
    
    public CheckDaysControl() 
    {
      createUI();    
    }
    
    public CheckDaysControl(boolean p_selected, int p_days) 
    {
      this();    
      setSelected(p_selected);
      setDays(p_days);
    }
    
    public JPanel getPanel()
    {
      return m_pnl;    
    }
    
    public boolean isSelected()
    {
      return  m_cbSelected.isSelected();   
    }
    
    public int getDays()
    {
      return ((Integer)(m_spnDays.getValue())).intValue();    
    }
    
    public void setSelected(boolean p_selected)
    {
      m_cbSelected.setSelected(p_selected);  
    }
    
    public void setDays(int p_days)
    {
      m_spnDays.setValue(new Integer(p_days));    
    }
    
    public String toString()
    {
      return new String(getDays() + "Days");    
    }
    
    private void createUI()
    {
      m_pnl = new JPanel();
      
      GridBagLayout gbLayout = new GridBagLayout();
      GridBagConstraints gbConstr = new GridBagConstraints();
      m_pnl.setLayout(gbLayout);
      gbConstr.fill = GridBagConstraints.HORIZONTAL; 
      
      m_cbSelected = new JCheckBox();
      gbLayout.setConstraints(m_cbSelected,gbConstr);
      m_pnl.add(m_cbSelected);
      
      m_spnDays = new JSpinner();
      gbLayout.setConstraints(m_spnDays,gbConstr);
      m_pnl.add(m_spnDays);

      JLabel lblTail = new JLabel("Days");
      gbLayout.setConstraints(lblTail,gbConstr);
      m_pnl.add(lblTail);      
    }
        
}
