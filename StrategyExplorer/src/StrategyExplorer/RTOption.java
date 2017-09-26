/*
 * RTOption.java
 *
 * Created on 7 אפריל 2006, 11:46
 */

package StrategyExplorer;

/**
 *
 * @author  Yair
 */
public class RTOption 
{
  private IOptionInf m_opt;
  private OptionMonth m_month;
  private double m_price;
  
  public RTOption(IOptionInf p_optionInf, OptionMonth p_month, double p_price)
  {
    m_opt =  p_optionInf;
    m_month = p_month;
    m_price = p_price;
  }
    
  public IOptionInf getOpt()
  {
    return m_opt;    
  }
  
  public OptionMonth month()
  {
    return m_month;    
  }
  
  public double price()
  {
    return m_price;    
  }
    
}
