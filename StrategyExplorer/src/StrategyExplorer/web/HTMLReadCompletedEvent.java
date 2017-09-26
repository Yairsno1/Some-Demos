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

public class HTMLReadCompletedEvent extends EventObject
{
  private String m_html;
  
  public HTMLReadCompletedEvent(Object p_src, String p_html) 
  {
    super(p_src);    
    m_html = p_html;
  }
    
  public String getHTML()
  {
    return m_html;
  }
  
}
