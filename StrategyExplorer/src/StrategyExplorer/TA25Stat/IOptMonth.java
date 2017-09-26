/*
 * IOptMonth.java
 *
 * Created on 11 מרץ 2006, 00:04
 */

package StrategyExplorer.TA25Stat;

/**
 *
 * @author  Yair
 */

import java.util.Calendar;

public interface IOptMonth 
{
  public IMonthBars bars();
  public double pivot();
  public IBar expBar();
  public double expPrice();
  public Calendar expDate();
  public double lowestPrice();
  public int lowestBar();
  public double highestPrice();
  public int highestBar();  
  public String month();
}
