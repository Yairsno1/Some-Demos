/*
 * Decimal2TextWraper.java
 *
 * Created on 5 מרץ 2006, 20:51
 */

package StrategyExplorer.ui.infrastructure;

/**
 *
 * @author  Yair
 */

import java.text.DecimalFormat;
import javax.swing.JFormattedTextField;

public class Decimal2TextWraper 
{
  private JFormattedTextField m_ftf;
  
  public Decimal2TextWraper() 
  {
    m_ftf = new JFormattedTextField(new DecimalFormat("0.00"));
    m_ftf.setValue(new Double(0.0F));
  }
    
  public JFormattedTextField getTextField()
  {
    return m_ftf;    
  }
}
