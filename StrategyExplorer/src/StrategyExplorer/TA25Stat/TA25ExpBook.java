/*
 * TA25ExpBook.java
 *
 * Created on 11 מרץ 2006, 11:15
 */

package StrategyExplorer.TA25Stat;

/**
 *
 * @author  Yair
 */

import java.util.HashMap;
import java.util.Iterator;

public class TA25ExpBook 
{
  private HashMap m_months;
  
  public TA25ExpBook() 
  {
    m_months = new HashMap();    
  }

  public void insert(IOptMonth p_month)
  {
    m_months.put(p_month.month(),p_month);    
  }
  
  public void delete(String p_month)
  {
    m_months.remove(p_month);    
  }

  public void delete(IOptMonth p_month)
  {
    m_months.remove(p_month.month());    
  }
  
  public void clear()
  {
    m_months.clear();    
  }
  
  public int monthsCount()
  {
    return m_months.size();    
  }
 
  public boolean isEmpty()
  {
    return m_months.isEmpty();    
  }
  
  public IOptMonth optMonth(String p_month)
  {
    return (IOptMonth)m_months.get(p_month);    
  }

  public IOptMonth optMonth(int p_idx)
  {
    Object[] monthArr;
    
    monthArr = m_months.values().toArray();
    
    return (IOptMonth)monthArr[p_idx];
  }
  
  public Iterator iterator()
  {
    return m_months.values().iterator();    
  }
  
}
