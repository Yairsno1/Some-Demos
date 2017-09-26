/*
 * Bar.java
 *
 * Created on 10 מרץ 2006, 23:14
 */

package StrategyExplorer.TA25Stat;

/**
 *
 * @author  Yair
 */

import java.util.Calendar;

public class Bar implements IBar 
{
  private Calendar m_date;
  private double m_open;
  private double m_high;
  private double m_low;
  private double m_close;
  private double m_volume;
  
  public Bar(Calendar p_date,
                 double p_open,
                 double p_high,
                 double p_low,
                 double p_close,
                 double p_volume) 
  {
    m_date = p_date;
    m_open = p_open;
    m_high = p_high;
    m_low = p_low;
    m_close = p_close;
    m_volume = p_volume;      
  }
    
  public double close() 
  {
    return m_close;
  }
  
  public Calendar date()
  {
    return m_date;    
  }
  
  public double high()
  {
    return m_high;    
  }
  
  public double low()
  {
    return m_low;    
  }
  
  public double open()
  {
    return m_open;    
  }
  
  public double volume()
  {
    return m_volume;    
  }
  
}
