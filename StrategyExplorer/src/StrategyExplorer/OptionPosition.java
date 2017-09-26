/*
 * OptionPosition.java
 *
 * Created on 24 פברואר 2006, 10:20
 */

package StrategyExplorer;

/**
 *
 * @author  Yair
 */
public class OptionPosition 
{
  private IOptionInf mOpt;
  private long mQty;
  
  public OptionPosition(IOptionInf pOpt, long pQty) 
  {
    mOpt = pOpt;
    mQty = pQty;
  }
    
  public IOptionInf getOpt()
  {
    return mOpt;
  }
  
  public long getQty()
  {
    return mQty;    
  }
  
}
