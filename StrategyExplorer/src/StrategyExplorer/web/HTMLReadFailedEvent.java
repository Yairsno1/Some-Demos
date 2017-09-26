/*
 * HTMLReadCompletedEvent.java
 *
 * Created on 28 מרץ 2006, 10:15
 */

package StrategyExplorer.web;

/**
 *
 * @author  Yair
 */

import java.util.*;

public class HTMLReadFailedEvent extends EventObject
{
  int m_error;
  
  public HTMLReadFailedEvent(Object p_src, int p_error) 
  {
    super(p_src);    
    m_error = p_error;
  }
    
  public int getError()
  {
    return m_error;    
  }
  
}
