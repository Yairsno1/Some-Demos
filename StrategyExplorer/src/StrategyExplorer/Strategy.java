/*
 * Strategy.java
 *
 * Created on 24 פברואר 2006, 10:43
 */

package StrategyExplorer;

/**
 *
 * @author  Yair
 */

import java.util.HashMap;
import java.util.Iterator;
import StrategyExplorer.MathLib.Calculations;

public class Strategy
{
  private HashMap mOptions;
  private double mCost;
  
  public Strategy() 
  {
    mOptions = new HashMap();
    mCost = 0;
  }
  
  public void add(OptionPosition pOpt)
  {
    String id;
    OptionPosition newQtyPos;
    OptionPosition currQtyPos;
    
    id = optId(pOpt.getOpt());
    if (mOptions.containsKey(id))
    {
      currQtyPos = (OptionPosition)(mOptions.get(id));
      newQtyPos = new OptionPosition(pOpt.getOpt(),pOpt.getQty()+currQtyPos.getQty());
      mOptions.remove(id);
      if (newQtyPos.getQty() != 0)
      {
        mOptions.put(id,newQtyPos);
      }
    }
    else
    {
      mOptions.put(id,pOpt);    
    }
  }
  
  public void reset()
  {
    mOptions.clear();    
    mCost = 0;
  }
  
  public double expirationValue(double pSpot)
  {
    double rv = 0;   
    Iterator valsIt;
    OptionPosition currOpt;
    
    valsIt = mOptions.values().iterator();
    while (valsIt.hasNext())
    {
      currOpt = (OptionPosition)(valsIt.next());
      rv += currOpt.getQty() * Calculations.internalValue(currOpt.getOpt(), pSpot, 100); //TBC(Yair) - parametric
    }
    rv += mCost;
    
    return rv;
  }

  public double BandSPrice(double p_spot, double p_r, double p_sigma, double p_daysT)
  {
    double rv = 0;   
    Iterator valsIt;
    OptionPosition currOpt;
    double price = 0.0;
    double strike = 0.;
    
    valsIt = mOptions.values().iterator();
    while (valsIt.hasNext())
    {
      price = 0.0;  
      currOpt = (OptionPosition)(valsIt.next());
      strike = currOpt.getOpt().strike();
      if (IOptionInf.OPTION_KIND_CALL == currOpt.getOpt().kind())
      {
        price = Calculations.callBandS(p_spot, strike, p_r, p_sigma, p_daysT);      
      }
      else if (IOptionInf.OPTION_KIND_PUT == currOpt.getOpt().kind())
      {
        price = Calculations.putBandS(p_spot, strike, p_r, p_sigma, p_daysT);          
      }
      rv += 100. * (double)currOpt.getQty() * price; //TBC(Yair) - parametric
    }
    rv += mCost;
    
    return rv;
  }
  
  public double getCost()
  {
    return mCost;
  }
  
  public void setCost(double pCost)
  {
    mCost = pCost;
  }
  
  private String optId(IOptionInf pOpt)
  {    
    StringBuffer id;
    
    id = new StringBuffer("");
    
    if (IOptionInf.OPTION_KIND_CALL == pOpt.kind())
    {
      id.append("C");  
    }
    else if(IOptionInf.OPTION_KIND_PUT == pOpt.kind())
    {
      id.append("P");  
    }
   id.append((long)(100*pOpt.strike()));
    
    return id.toString();    
  }
  
}
