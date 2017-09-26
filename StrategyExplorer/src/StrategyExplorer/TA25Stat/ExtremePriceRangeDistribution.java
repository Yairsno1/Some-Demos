/*
 * ExtremePriceRangeDistribution.java
 *
 * Created on 17 מרץ 2006, 17:04
 */

package StrategyExplorer.TA25Stat;

/**
 *
 * @author  Yair
 */
public class ExtremePriceRangeDistribution extends AbstractPriceRangeDistribution
{
    
  public ExtremePriceRangeDistribution(TA25ExpBook p_expBook, double p_range)
  {
    super(p_expBook,p_range);    
  }
    
  protected double doPullPrice(IOptMonth p_optMonth)
  {
    double rv = 0.;
    double h;
    double l;
    
    h = Math.abs(p_optMonth.highestPrice() - p_optMonth.pivot());
    l = Math.abs(p_optMonth.lowestPrice() - p_optMonth.pivot());
    rv = Math.max(h,l);
    
    return rv;
  }
  
}
