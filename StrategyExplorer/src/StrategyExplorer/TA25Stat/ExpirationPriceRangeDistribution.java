/*
 * ExpirationPriceRangeDistribution.java
 *
 * Created on 13 מרץ 2006, 23:43
 */

package StrategyExplorer.TA25Stat;

/**
 *
 * @author  Yair
 */

public class ExpirationPriceRangeDistribution extends AbstractPriceRangeDistribution
{
    
  public ExpirationPriceRangeDistribution(TA25ExpBook p_expBook, double p_range)  
  {
    super(p_expBook,p_range);    
  }
  
  protected double doPullPrice(IOptMonth p_optMonth) 
  {
    return Math.abs(p_optMonth.expPrice() - p_optMonth.pivot());    
  }  
}
