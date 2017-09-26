/*
 * SortedPriceRangeDistribution.java
 *
 * Created on 17 מרץ 2006, 12:40
 */

package StrategyExplorer.TA25Stat;

/**
 *
 * @author  Yair
 */

import java.util.Iterator;
import java.util.LinkedList;

public class SortedPriceRangeDistribution implements IPriceRangeDistribution
{    
  private LinkedList m_rangeItems;
  private IPriceRangeDistribution m_src;
  
  public SortedPriceRangeDistribution(IPriceRangeDistribution p_srcDistribution) 
  {      
    m_rangeItems = new LinkedList();    
    m_src = p_srcDistribution;
  }
    
  public long calc() 
  {
    long rv = 0;  
    int i = 0;
    long sz = 0;
    IPriceRangeItem item = null;
    
    m_src.calc();
    sz = m_src.itemCount();
    for (i=0; i<sz; i++)
    {
      item = m_src.item(i);      
      rv += item.count();
      insert(item);
    }
    
    return rv;
  }
    
  public IPriceRangeItem item(int p_idx) 
  {
    return (IPriceRangeItem)m_rangeItems.get(p_idx);    
  }
    
  public long itemCount() 
  {
    return m_rangeItems.size();    
  }
    
  public java.util.Iterator iterator() 
  {
    return m_rangeItems.listIterator();    
  }
    
  private void insert(IPriceRangeItem p_item)
  {
    final int PREV_NOT_FOUND = -1;
    
    int i = 0;
    long sz = 0;
    IPriceRangeItem tmpItem = null;    
    int prev = PREV_NOT_FOUND;
    
    sz = itemCount();
    while (i<sz && PREV_NOT_FOUND == prev)
    {
      tmpItem = item(i);  
      if (p_item.normal() <= tmpItem.normal())
      {
        prev = i;    
      }
      ++i;    
    }
    if (PREV_NOT_FOUND == prev)
    {
      m_rangeItems.add(p_item);          
    }
    else
    {
      m_rangeItems.add(prev,p_item);    
    }    
  }
  
  public double avrg() 
  {
    return m_src.avrg();    
  }
  
  public double stdDev()
  {
    return m_src.stdDev();    
  }
  
}
