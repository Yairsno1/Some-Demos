/*
 * IOptionInf.java
 *
 * Created on 24 פברואר 2006, 10:00
 */

package StrategyExplorer;

/**
 *
 * @author  Yair
 */
public interface IOptionInf
{
  public static final int OPTION_KIND_CALL = 1;
  public static final int OPTION_KIND_PUT = 2;
  
  public long kind();    
  public double strike();
}
