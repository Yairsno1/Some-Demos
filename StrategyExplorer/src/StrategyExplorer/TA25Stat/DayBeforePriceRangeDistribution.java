/*
 * DayBeforePriceRangeDistribution.java
 *
 * Created on 17 מרץ 2006, 14:20
 */

package StrategyExplorer.TA25Stat;

/**
 *
 * @author  Yair
 */
public class DayBeforePriceRangeDistribution extends AbstractPriceRangeDistribution
{
    
  public DayBeforePriceRangeDistribution(TA25ExpBook p_expBook, double p_range) 
  {
    super(p_expBook,p_range);    
  }
    
  protected double doPullPrice(IOptMonth p_optMonth) 
  {
     double rv = 0.;
     
    IMonthBars bars;
    int dayBeforeBar = 0;
    IBar bar = null;
    
    bars = p_optMonth.bars();
    dayBeforeBar = (bars.barCount()-1)-1;
    if (dayBeforeBar >= 0)
    {
      bar = bars.bar(dayBeforeBar);    
      rv = Math.abs((.5 * (bar.high()+bar.low())) - p_optMonth.pivot());
    }
    
    return rv;
  }
  
}
