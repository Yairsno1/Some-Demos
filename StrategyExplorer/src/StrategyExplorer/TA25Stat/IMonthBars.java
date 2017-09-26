/*
 * IMonthBars.java
 *
 * Created on 10 מרץ 2006, 23:48
 */

package StrategyExplorer.TA25Stat;

/**
 *
 * @author  Yair
 */

import java.util.Iterator;

public interface IMonthBars
{
  public int barCount();
  public IBar bar(int p_idx);
  public Iterator iterator();
  public boolean isEmpty();
}
