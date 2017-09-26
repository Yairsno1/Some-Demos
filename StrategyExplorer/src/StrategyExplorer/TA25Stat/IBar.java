/*
 * IBar.java
 *
 * Created on 10 מרץ 2006, 23:09
 */

package StrategyExplorer.TA25Stat;

/**
 *
 * @author  Yair
 */

import java.util.Calendar;

public interface IBar
{
  public Calendar date();
  public double open();
  public double high();
  public double low();
  public double close();
  public double volume();
}
