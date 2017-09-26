/*
 * IPriceRangeDistribution.java
 *
 * Created on 13 ��� 2006, 21:00
 */

package StrategyExplorer.TA25Stat;

/**
 *
 * @author  Yair
 */

import java.util.Iterator;

public interface IPriceRangeDistribution 
{
  public long calc();  
  public long itemCount();    
  public IPriceRangeItem item(int p_idx);
  public Iterator iterator();
  public double avrg();
  public double stdDev();
}
