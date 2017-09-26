/*
 * OptionsPrice.java
 *
 * Created on 22 אפריל 2006, 12:17
 */

package StrategyExplorer;

/**
 *
 * @author  Yair
 */

import java.util.*;

public class OptionSeriesPrices implements IOptionsSeriesPrices
{
  private OptionMonth m_month;
  private HashMap m_options;
  private double m_lowsetStrike;
  private double m_highsetStrike;
  
  public OptionSeriesPrices(OptionMonth p_expirationMonth) 
  {
    m_month = p_expirationMonth;
    m_options = new HashMap();
    m_lowsetStrike = Double.POSITIVE_INFINITY;
    m_highsetStrike = Double.NEGATIVE_INFINITY;
  }
    
  public boolean addOption(RTOption p_option)
  {
    boolean rv = false;
    double strike = 0.0;
    IOptionInf optInf = null;
    
    if (m_month.equals(p_option.month()))
    {
      optInf = p_option.getOpt();
      strike = optInf.strike();
      
      m_options.put(optInf, p_option);
      m_lowsetStrike = Math.min(m_lowsetStrike, strike);  
      m_highsetStrike = Math.max(m_highsetStrike,strike);  
      
      rv = true;
    }
    
    return rv;
  }
  
  public int count() 
  {
    return m_options.size();     
  }
  
  public OptionMonth getExpirationMonth() 
  {
    return m_month;    
  }
  
  public double getHighestStrike()
  {
    return m_highsetStrike;
  }
  
  public double getLowestStrike()
  {
    return m_lowsetStrike;    
  }
  
  public RTOption getOption(int p_index) 
  {
    RTOption rv = null;  
    Iterator it = null;
    boolean found = false;
    int currIndex = 0;
    
    it = m_options.values().iterator();
    while (it.hasNext() && !found)
    {
      rv = (RTOption)it.next();  
      if (p_index == currIndex)
      {
        found = true;        
      }
      ++currIndex;
    }
    rv = found ? rv : null;
    
    return rv;
  }
  
  public RTOption getOption(IOptionInf p_optionInf) 
  {
    return (RTOption)m_options.get(p_optionInf);    
  }
  
  //Returns True if both Call and Put options with equal strike exist
  public boolean isStrikeExist(double p_strike) 
  {
    boolean rv = false;  
    CallOpt call = null;
    PutOpt put = null;
    
    call = new CallOpt(p_strike);
    put = new PutOpt(p_strike);
    
    rv = (getOption(call) != null && getOption(put) != null);
    
    return rv;  
  }
  
  public java.util.Iterator iterator()
  {
    return m_options.values().iterator();    
  }
  
}
