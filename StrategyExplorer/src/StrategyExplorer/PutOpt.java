/*
 * PutOpt.java
 *
 * Created on 24 פברואר 2006, 10:12
 */

package StrategyExplorer;

/**
 *
 * @author  Yair
 */
public class PutOpt implements IOptionInf
{ 
  private double mStrike;
  
  public PutOpt(double pStrike) 
  {
    mStrike = pStrike;
  }
    
  public long kind() 
  {
    return IOptionInf.OPTION_KIND_PUT;    
  }
    
  public double strike() 
  {
    return mStrike;    
  }
   
  public boolean equals(Object p_obj)  
  {
    boolean rv = false;
    PutOpt RHS = null;
    
    if (p_obj != null)
    {
      RHS = (PutOpt)p_obj;
      rv = (kind() == RHS.kind() && mStrike == RHS.strike());
    }
    
    return rv;
  }
  
  public String toString()
  {
    return "P";    
  }
  
}
