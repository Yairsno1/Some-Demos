/*
 * DefaultOptMonth.java
 *
 * Created on 11 מרץ 2006, 00:26
 */

package StrategyExplorer.TA25Stat;

/**
 *
 * @author  Yair
 */

import java.lang.Math;
import java.util.Calendar;

public class DefaultOptMonth implements IOptMonth
{
  private double m_pivot;
  private DefaultMonthBars m_bars;
  private double m_lowestPrice;
  private int m_lowestBar;
  private double m_highestPrice;
  private int m_highestBar;
  private double m_expPrice;
  private int m_expBar;
  
  public DefaultOptMonth() 
  {
    m_pivot = 0.;    
    m_bars = new DefaultMonthBars();
    m_lowestPrice = Double.MAX_VALUE;
    m_lowestBar = -1;
    m_highestPrice = Double.NEGATIVE_INFINITY;
    m_highestBar = -1;
    m_expPrice = 0.;
    m_expBar = -1;
  }
  
  public void open(double p_pivot)
  {
    m_pivot = p_pivot;    
  }
  
  public void addBar(IBar p_bar)
  {
    m_bars.add(p_bar);    
    if (m_pivot < 1.)
    {
      if (1 == m_bars.barCount()) 
      {
        m_pivot = Math.round(m_bars.bar(0).close());    
      }
    }
    
    //Do not include expiretion bars in extremes calculations
    if (p_bar.high() >= m_highestPrice && p_bar.volume() < 1.)
    {
      m_highestPrice = p_bar.high();
      m_highestBar = (int)(m_bars.barCount()-1);
    }
    if (p_bar.low() <= m_lowestPrice && p_bar.volume() < 1.)
    {
      m_lowestPrice = p_bar.low();
      m_lowestBar = (int)(m_bars.barCount()-1);
    }    
  }
  
  public void close(double p_expPrice)
  {
    m_expPrice = p_expPrice;     
    m_expBar = (int)(m_bars.barCount()-1);
  }

  public void setPivot(double p_pivot)
  {
    m_pivot = p_pivot;    
  }
  
  public IMonthBars bars() 
  {
    return m_bars;    
  }
  
  public IBar expBar() 
  {
    return m_bars.bar(m_expBar);    
  }
  
  public Calendar expDate() 
  {
    return expBar().date();    
  }
  
  public double expPrice() 
  {
    return m_expPrice;    
  }
  
  public int highestBar()
  {
    return m_highestBar;    
  }
  
  public double highestPrice()
  {
    return m_highestPrice;        
  }
  
  public int lowestBar() 
  {
    return m_lowestBar;        
  }
  
  public double lowestPrice() 
  {
    return m_lowestPrice;            
  }
  
  public String month() 
  {
    String rv = null;
    String mm = null;
    String yyyy = null;
    Calendar date = null;
   
    date = expDate();
    mm = Integer.toString(1+date.get(Calendar.MONTH));
    yyyy =Integer.toString(date.get(Calendar.YEAR));
    rv = new String(mm + "/" + yyyy);
    
    return rv;    
  }
  
  public double pivot()
  {
    return m_pivot;    
  }
  
}
