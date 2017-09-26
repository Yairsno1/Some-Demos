/*
 * RedGreenSpinner.java
 *
 * Created on 3 מרץ 2006, 16:21
 */

package StrategyExplorer.ui.infrastructure;

/**
 *
 * @author  Yair
 */

import java.awt.Color;
import javax.swing.JComponent;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

public class RedGreenSpinner extends JSpinner
{
  Color m_defaultBkg;
  
  /** Creates a new instance of RedGreenSpinner */
  public RedGreenSpinner() 
  {
    super();    
    init();
  }
  
  public RedGreenSpinner(SpinnerModel p_model)
  {
    super(p_model); 
    init();
  }
    
  private void init()
  {    
    JFormattedTextField currTxt = null;
    
     setModel(new SpinnerNumberModel());  
     getModel().setValue(new Long(0));
     setEditor(new JSpinner.NumberEditor(this));
    
    currTxt = currTextField();
    m_defaultBkg = (null == currTxt) ? getBackground() : currTxt.getBackground();
    addChangeListener(new ChangeListener()
    {
      public void stateChanged(ChangeEvent p_ce)
      {
        myStateChanged(p_ce);
      }
    });    
  }
  
  private void myStateChanged(ChangeEvent p_ce)
  {
    long newVal = 0;
    JFormattedTextField currTxt = null;
    
    currTxt = currTextField();
    if (currTxt != null)
    {
      newVal = (new Long(getValue().toString())).longValue();
      if (newVal > 0)
      {
         currTxt.setBackground(Color.green);  
      }
      else if (0 == newVal)
      {
        currTxt.setBackground(m_defaultBkg);      
      }
      else if (newVal < 0)
      {
        currTxt.setBackground(Color.red);      
      }
    }
  }
  
  private JFormattedTextField currTextField()
  {
    JFormattedTextField rv = null;
    JComponent thisEditor = null;
    JSpinner.DefaultEditor defEditor = null;
   
    thisEditor = getEditor();
    if (thisEditor instanceof JSpinner.DefaultEditor)
    {
      defEditor = (JSpinner.DefaultEditor) thisEditor;
      rv = defEditor.getTextField();
      rv.setOpaque(true);
    }
   
   return rv;
  }
  
}
