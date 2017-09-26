/*
 * DefaultMonthBars.java
 *
 * Created on 10 מרץ 2006, 23:54
 */

package StrategyExplorer.TA25Stat;

/**
 *
 * @author  Yair
 */

import java.util.ArrayList;
import java.util.Iterator;

public class DefaultMonthBars implements IMonthBars
{
  private ArrayList m_bars;      

  public DefaultMonthBars() 
  {
    m_bars = new ArrayList();    
  }
    
  public void add(IBar p_bar)
  {
    m_bars.add(p_bar);    
  }
  
  public IBar bar(int p_idx) 
  {
    return (IBar)m_bars.get(p_idx);    
  }
  
  public int barCount()
  {
    return m_bars.size();    
  }
  
  public Iterator iterator()
  {
    return m_bars.iterator();    
  }
  
  public boolean isEmpty() 
  {
    return m_bars.isEmpty();    
  }
  
}
