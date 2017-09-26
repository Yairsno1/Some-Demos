/*
 * Calculations.java
 *
 * Created on 24 פברואר 2006, 10:27
 */

package StrategyExplorer.MathLib;

/**
 *
 * @author  Yair
 */

import java.lang.Math.*;

import StrategyExplorer.IOptionInf;

public class Calculations
{
  private final static float DAYS_IN_YEAR = 365.0F;
  
  public static double internalValue(IOptionInf pOpt, double pSpot, int pMultiplier)
  {
    double rv = 0;
    
    if (IOptionInf.OPTION_KIND_CALL == pOpt.kind())
    {
      rv = Math.max((double)0,pSpot-(double)pOpt.strike());
    }
    else if(IOptionInf.OPTION_KIND_PUT == pOpt.kind())
    {
      rv = Math.max((double)0,(double)pOpt.strike()-pSpot);
    }
    
    return  pMultiplier * rv;     
  }

  public static double callBandS(double s, 
                                             double x, 
                                             double r, 
                                             double sigma,
                                             double daysT)
  {
    double rv = 0.0;
    double t = 0.0;
    double xd1 = 0.0;
    double xd2 = 0.0;
    
    t = daysT / DAYS_IN_YEAR;
    xd1 = d1(s,x,r,sigma,t); 
    xd2 = d2(xd1,sigma,t); 
    rv = (s * stdNormale(xd1)) - (x * Math.exp(-r * t) * stdNormale(xd2));
    
    return rv;
  }
  
  public static double putBandS(double s, 
                                             double x, 
                                             double r, 
                                             double sigma,
                                             double daysT)
  {
    double rv = 0.0;
    double t = 0.0;
    double xd1 = 0.0;
    double xd2 = 0.0;
    
    t = daysT / DAYS_IN_YEAR;
    xd1 = d1(s,x,r,sigma,t); 
    xd2 = d2(xd1,sigma,t); 
      
    rv = (x * Math.exp(-r * t) * stdNormale(-xd2)) -(s * stdNormale(-xd1));
    
    return rv;
  }
 
  public static double avrg(double[] p_vals, int p_count)
  {
    double rv = 0.;  
    int i = 0;      
    
    for (i=0; i<p_count; i++)
    {
      rv += p_vals[i];    
    }
    rv /= p_count;
    
    return rv;
  }

  public static double stdDev(double[] p_vals, int p_count)
  {
    double rv = 0.;  
    double avg = 0.;
    int i = 0;      
    
    avg = avrg(p_vals,p_count);
    for (i=0; i<p_count; i++)
    {
      rv += (p_vals[i] - avg) * (p_vals[i] - avg);    
    }
    rv /= p_count;
    rv = Math.sqrt(rv);
    
    return rv;
  }
  
  private static double d1(double s,
                                     double x,
                                     double r,
                                     double sigma,
                                     double t)
  {
    double rv = 0.0;
    
    double x1 = (sigma*sigma)/2;
    double x2 = (r+(x1))*t;
    double x3 = Math.log(s/x);
    double x4 = sigma*Math.sqrt(t);
    rv = (x2+x3) / x4;
    
    return rv;
  }
  
  private static double d2(double d1,
                                     double sigma,
                                     double t)
  {
    double rv = 0.0;
    rv = d1 - (sigma*Math.sqrt(t));
    
    return rv;
  }
  
  private static double stdNormale(double d)
  {
    double rv = 0.0;
    double xmin = -5.;
    double step = 0.0001;
    
    for(double ld = xmin; ld <= d; ld += step)
    {
      rv += Math.exp(-ld * ld / 2) * step;      
    }
    rv = rv / Math.sqrt(2 * Math.PI);
    
    return rv;
  }
 
}
