/*
 * AbstractPriceRangeDistribution.java
 *
 * Created on 13 מרץ 2006, 22:42
 */

package StrategyExplorer.TA25Stat;

/**
 *
 * @author  Yair
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.lang.Math;

import StrategyExplorer.MathLib.Calculations;

public abstract class AbstractPriceRangeDistribution implements IPriceRangeDistribution 
{
  private final int ITEM_NOT_FOUND = -1;
  
  private double m_range;
  private TA25ExpBook m_expBook;
  private ArrayList m_rangeItems;
  private double m_avg;
  private double m_sd;
  
  public AbstractPriceRangeDistribution(TA25ExpBook p_expBook, double p_range)
  {
    m_expBook =  p_expBook;
    m_range = p_range;
    m_rangeItems = new ArrayList();
    m_avg = 0.;
    m_sd = 0.;    
  }
  
  /**
   * Return value: Number of months in book, this is for consistency validation
   */
  public long calc()
  {
     long rv = 0;     
    Iterator it = null;
    IOptMonth iMonth = null;
    double priceChange;
    DefaultPriceRangeItem rangeItem = null;
    int vIdx = 0;
    double[] vals;
    
    vals = new double[m_expBook.monthsCount()];
    m_rangeItems.clear(); 
    it = m_expBook.iterator();
    while (it.hasNext())
    {
      iMonth = (IOptMonth)it.next();    
      priceChange = doPullPrice(iMonth);      
      rangeItem = findRangeItem(priceChange); 
      if (null == rangeItem)
      {
        rangeItem = createRangeItem(priceChange); 
        m_rangeItems.add(rangeItem);
      }
      rangeItem.increaseCount(priceChange);    
      vals[vIdx++] = priceChange;
      
      ++rv;
    }
    m_avg = Calculations.avrg(vals,m_expBook.monthsCount());
    m_sd = Calculations.stdDev(vals,m_expBook.monthsCount());
    
    return rv;
  }
  
  public long calc(double p_range)
  {
     m_range = p_range;
     return calc();
  }

  public void setRange(double p_range)
  {
     m_range = p_range;
  }

  public IPriceRangeItem item(int p_idx)
  {
    return (IPriceRangeItem)m_rangeItems.get(p_idx);            
  }
  
  public long itemCount() 
  {
    return m_rangeItems.size();                
  }
  
  public Iterator iterator() 
  {
    return m_rangeItems.iterator();
  }
  
  protected TA25ExpBook getExpBook()
  {
    return m_expBook;    
  }

  protected double getRange()
  {
    return m_range;    
  }
  
  protected abstract double doPullPrice(IOptMonth p_optMonth);
  
  private DefaultPriceRangeItem findRangeItem(double p_price)
  {
    DefaultPriceRangeItem rv = null;
    DefaultPriceRangeItem rangeItem = null;
    int sz = 0;
    int i = 0;
    
    sz = m_rangeItems.size();
    while (i < sz && null == rv)
    {
     rangeItem = (DefaultPriceRangeItem)m_rangeItems.get(i);        
     if (rangeItem.withinRange(p_price))
     {
       rv = (DefaultPriceRangeItem)m_rangeItems.get(i);    
     }
      ++i;    
    }
    
    return rv;
  }
  
  private DefaultPriceRangeItem createRangeItem(double p_price)
  {
    DefaultPriceRangeItem rv = null;
    double bottom = 0.;
    double top = m_range;
    
    while (null == rv)
    {
      if (p_price >= bottom && p_price <= top)
      {
        rv = new DefaultPriceRangeItem(bottom,m_range);    
      }
      else
      {
        bottom = top;     
        top += m_range;
      }
    }
    
    return rv;
  }
  
  public double avrg() 
  {
    return m_avg;    
  }
  
  public double stdDev()
  {
    return m_sd;    
  }
  
}
