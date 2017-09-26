/*
 * PctPriceRangeDistribution.java
 *
 * Created on 17 מרץ 2006, 18:49
 */

package StrategyExplorer.TA25Stat;

/**
 *
 * @author  Yair
 */

public class PctPriceRangeDistribution extends AbstractPriceRangeDistribution
{
  private AbstractPriceRangeDistribution m_priceRangeDistr; 
  public PctPriceRangeDistribution(AbstractPriceRangeDistribution p_priceRangeDistr) 
  {
    super(p_priceRangeDistr.getExpBook(),p_priceRangeDistr.getRange());    
    m_priceRangeDistr = p_priceRangeDistr;
  }
    
  protected double doPullPrice(IOptMonth p_optMonth) 
  {
    return  (m_priceRangeDistr.doPullPrice(p_optMonth) / p_optMonth.pivot()) * 100;
  }
  
}
