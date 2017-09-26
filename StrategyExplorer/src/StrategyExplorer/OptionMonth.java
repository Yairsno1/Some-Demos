/*
 * OptionMonth.java
 *
 * Created on 7 אפריל 2006, 11:51
 */

package StrategyExplorer;

/**
 *
 * @author  Yair
 */

import java.util.*;

public class OptionMonth 
{
  public static final String OPT_MONTH_JAN = "JAN";
  public static final String OPT_MONTH_FEB = "FEB";
  public static final String OPT_MONTH_MAR = "MAR";
  public static final String OPT_MONTH_APR = "APR";
  public static final String OPT_MONTH_MAY = "MAY";
  public static final String OPT_MONTH_JUN = "JUN";
  public static final String OPT_MONTH_JUL = "JUL";
  public static final String OPT_MONTH_AUG = "AUG";
  public static final String OPT_MONTH_SEP = "SEP";
  public static final String OPT_MONTH_OCT = "OCT";
  public static final String OPT_MONTH_NOV = "NOV";
  public static final String OPT_MONTH_DEC = "DEC";
  
  private static ArrayList m_allMonths = null;                                                         
  private String m_id;
  
  public OptionMonth(String p_month) 
  {
    m_id = p_month;     
  }
  
  public String getMonth()
  {
    return m_id;    
  }
    
  public String toString()
  {
    return m_id;    
  }
  
  public static Iterator monthsIterator()
  {
     String[] allMonthsArr = {OPT_MONTH_JAN,OPT_MONTH_FEB,OPT_MONTH_MAR,
                                        OPT_MONTH_APR,OPT_MONTH_MAY,OPT_MONTH_JUN,
                                        OPT_MONTH_JUL,OPT_MONTH_AUG,OPT_MONTH_SEP,
                                        OPT_MONTH_OCT,OPT_MONTH_NOV,OPT_MONTH_DEC}; 
    int len = 0;                                        
    int i = 0;
    
    if (null == m_allMonths)
    {
      m_allMonths = new ArrayList();  
      len = allMonthsArr.length;
      for (i=0; i<len; i++)
      {
        m_allMonths.add(allMonthsArr[i]);        
      }
    }
    
    return m_allMonths.iterator();
  }
  
  public boolean equals(Object p_obj)
  {
    boolean rv = false;
    
    if (p_obj != null) 
    {
      rv = m_id.equals(((OptionMonth)p_obj).getMonth());    
    }
    
    return rv;
  }
  
}
