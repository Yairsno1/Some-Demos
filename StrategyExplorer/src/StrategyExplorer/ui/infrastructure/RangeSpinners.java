/*
 * RangeSpinners.java
 *
 * Created on 6 מרץ 2006, 22:12
 */

package StrategyExplorer.ui.infrastructure;

/**
 *
 * @author  Yair
 */

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.GridLayout; 
import javax.swing.JLabel;
import javax.swing.JPanel;

public class RangeSpinners 
{
  public final static long CTRL_ORIENTATION_HORZ = 1;
  public final static long CTRL_ORIENTATION_VERT = 2;
  
  private final static String FROM_DEFAULT_LABEL = "From:";
  private final static String TO_DEFAULT_LABEL = "To:";
  private final static String STEP_DEFAULT_LABEL = "Step:";
  
  private JPanel m_pnl;
  private Decimal2Spinner spnFrom;
  private JLabel lblFrom;
  private Decimal2Spinner spnTo;
  private JLabel lblTo;
  private Decimal2Spinner spnStep;
  private JLabel lblStep;
  
  
  public RangeSpinners(long p_orientation) 
  {
    init(p_orientation);    
  }
  
  public JPanel getPanel()
  {
    return m_pnl;    
  }

  public double getLow()
  {
    return (new Double(spnFrom.getValue().toString())).doubleValue();
  }

  public double getHigh()
  {
    return (new Double(spnTo.getValue().toString())).doubleValue();
  }

  public double getStep()
  {
    return (new Double(spnStep.getValue().toString())).doubleValue();
  }
  
  public JLabel getLowLabel()
  {
    return lblFrom;
  }

  public JLabel getHighLabel()
  {
    return lblTo;
  }

  public JLabel getStepLabel()
  {
    return lblStep;
  }
  
  public void setLow(double p_val)
  {
    spnFrom.setValue(new Double(p_val));    
  }

  public void setHigh(double p_val)
  {
    spnTo.setValue(new Double(p_val));    
  }
  
  public void setStep(double p_step)
  {
    if (p_step != getStep())  
    {
      spnStep.setValue(new Double(p_step));      
    }
    spnFrom.setStep(p_step);
    spnTo.setStep(p_step);      
  }
  
  private void init(long p_orientation)
  {
    m_pnl = new JPanel();   
    if (CTRL_ORIENTATION_HORZ == p_orientation)
    {
      m_pnl.setLayout(new GridLayout(1,0));    
    }
    else
    {
      m_pnl.setLayout(new GridLayout(3,3));        
    }
    lblFrom = new JLabel(FROM_DEFAULT_LABEL);
    spnFrom = new Decimal2Spinner();
    spnFrom.addChangeListener(new ChangeListener()
    {
      public void stateChanged(ChangeEvent p_ce)
      {
        fromStateChanged(p_ce);
      }
    });        
    lblTo = new JLabel(TO_DEFAULT_LABEL);
    spnTo = new Decimal2Spinner();   
    spnTo.addChangeListener(new ChangeListener()
    {
      public void stateChanged(ChangeEvent p_ce)
      {
        toStateChanged(p_ce);
      }
    });                
    lblStep = new JLabel(STEP_DEFAULT_LABEL);
    spnStep = new Decimal2Spinner();   
    spnStep.addChangeListener(new ChangeListener()
    {
      public void stateChanged(ChangeEvent p_ce)
      {
        stepStateChanged(p_ce);
      }
    });                
    m_pnl.add(lblFrom);
    m_pnl.add(spnFrom);
    m_pnl.add(lblTo);
    m_pnl.add(spnTo);    
    m_pnl.add(lblStep);
    m_pnl.add(spnStep);        
  }
  
  private void fromStateChanged(ChangeEvent p_ce)
  {
    double low;
    double high;
    
    low = getLow();
    high = getHigh();
    if (low > high)
    {
      setLow(high);      
    }
  }
  
  private void toStateChanged(ChangeEvent p_ce)
  {
    double low;
    double high;
    
    low = getLow();
    high = getHigh();
    if (high < low)
    {
      setHigh(low);      
    }
  }

  private void stepStateChanged(ChangeEvent p_ce)
  {
    setStep(getStep());  
  }
  
}
