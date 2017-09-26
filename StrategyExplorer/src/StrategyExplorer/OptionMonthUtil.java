/*
 * OptionMonthUtil.java
 *
 * Created on 7 אפריל 2006, 12:02
 */

package StrategyExplorer;

/**
 *
 * @author  Yair
 */

import java.util.*;

public class OptionMonthUtil 
{
  private static OptionMonthUtil m_instance = null;
  private HashMap m_months;
  
  protected OptionMonthUtil() 
  {
    Iterator it = null;
    String month;
    
    m_months = new HashMap();
    it = OptionMonth.monthsIterator();
    while (it.hasNext())
    {
      month = (String)it.next();    
      m_months.put(month,new OptionMonth(month));        
    }
  }
  
  public static OptionMonthUtil getInstance()
  {
    synchronized(m_instance)
    {
      if (null == m_instance)
      {
        m_instance = new OptionMonthUtil();    
      }
    }
    
    return m_instance;
  }
  
  public OptionMonth getMonthObj(String p_monthStr)
  {
    return (OptionMonth)m_months.get(p_monthStr);    
  }
  
}
