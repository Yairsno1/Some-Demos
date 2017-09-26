/*
 * DefaultPriceRangeItem.java
 *
 * Created on 13 מרץ 2006, 21:20
 */

package StrategyExplorer.TA25Stat;

/**
 *
 * @author  Yair
 */

public class DefaultPriceRangeItem implements IPriceRangeItem
{
  private double m_bottom;
  private double m_top;
  private long m_count;
  
  public DefaultPriceRangeItem(double p_bottom, double p_spread) 
  {
    m_bottom = p_bottom;
    m_top = m_bottom + p_spread;
    m_count = 0;
  }
    
  public double bottom() 
  {
    return m_bottom;    
  }
  
  public long count() 
  {
    return m_count;    
  }
  
  public double normal()
  {
    return m_bottom + (.5 * (m_top - m_bottom));    
  }
  
  public double top() 
  {
    return m_top;    
  }
  
  public boolean increaseCount(double p_price)
  {
    return increaseCount(p_price,1);
  }

  public boolean increaseCount(double p_price, long p_count)
  {
    boolean rv  = false;
    
    if (withinRange(p_price))
    {
      rv = true;  
      m_count += p_count;      
    }
    
    return rv;
  }
  
  public boolean withinRange(double p_price)
  {
    return (p_price >= m_bottom && p_price <= m_top);    
  }
  
}
