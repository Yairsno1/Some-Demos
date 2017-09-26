/*
 * Decimal2Spinner.java
 *
 * Created on 4 מרץ 2006, 11:53
 */

package StrategyExplorer.ui.infrastructure;

/**
 *
 * @author  Yair
 */

import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

public class Decimal2Spinner extends JSpinner
{
      
   public Decimal2Spinner() 
   {
     super();
     init();
   }
   
   public Decimal2Spinner(SpinnerModel model)
   {
     this();       
   }

   public void setMax(double p_max)
   {
     ((SpinnerNumberModel)((JSpinner.NumberEditor)getEditor()).getModel()).setMaximum(new Double(p_max));
   }
   
   public void setMin(double p_min)
   {
     ((SpinnerNumberModel)((JSpinner.NumberEditor)getEditor()).getModel()).setMinimum(new Double(p_min));
   }
   
   public void setStep(double p_step)
   {
     ((SpinnerNumberModel)((JSpinner.NumberEditor)getEditor()).getModel()).setStepSize(new Double(p_step));
   }
   
   private void init()
   {
     setModel(new SpinnerNumberModel(0.0,Double.NEGATIVE_INFINITY,Double.POSITIVE_INFINITY,1.0));  
     setEditor(new JSpinner.NumberEditor(this,"0.00"));
   }   
   
   
}
