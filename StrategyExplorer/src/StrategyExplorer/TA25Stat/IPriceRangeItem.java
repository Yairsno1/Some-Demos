/*
 * IPriceRangeItem.java
 *
 * Created on 13 מרץ 2006, 21:01
 */

package StrategyExplorer.TA25Stat;

/**
 *
 * @author  Yair
 */

public interface IPriceRangeItem
{
  public double bottom();
  public double top();
  public double normal();
  public long count();
}
