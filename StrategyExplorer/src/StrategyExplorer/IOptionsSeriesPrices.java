/*
 * IOptionsSeriesPrices.java
 *
 * Created on 22 אפריל 2006, 12:22
 */

package StrategyExplorer;

/**
 *
 * @author  Yair
 */

import java.util.*;

public interface IOptionsSeriesPrices
{
  public int count();  
  public OptionMonth getExpirationMonth();
  public double getLowestStrike();
  public double getHighestStrike();
  public RTOption getOption(int p_index);
  public RTOption getOption(IOptionInf p_optionInf);
  public boolean isStrikeExist(double p_strike);
  public Iterator iterator();
}
