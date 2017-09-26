/*
 * CallOpt.java
 *
 * Created on 24 פברואר 2006, 10:07
 */

package StrategyExplorer;

/**
 *
 * @author  Yair
 */
public class CallOpt implements IOptionInf
{
  private double mStrike;
    
  public CallOpt(double pStrike) 
  {
    mStrike = pStrike;
  }
    
  public long kind() 
  {
    return IOptionInf.OPTION_KIND_CALL;
  }
    
  public double strike() 
  {
    return mStrike;    
  }

  public boolean equals(Object p_obj)  
  {
    boolean rv = false;
    CallOpt RHS = null;
    
    if (p_obj != null)
    {
      RHS = (CallOpt)p_obj;
      rv = (kind() == RHS.kind() && mStrike == RHS.strike());
    }
    
    return rv;
  }
  
  public String toString()
  {
    return "C";    
  }
  
}
