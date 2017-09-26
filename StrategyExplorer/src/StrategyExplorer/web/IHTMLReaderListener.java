/*
 * IHTMLReaderListener.java
 *
 * Created on 28 מרץ 2006, 10:48
 */

package StrategyExplorer.web;

/**
 *
 * @author  Yair
 */

import java.util.*;

public interface IHTMLReaderListener extends EventListener
{
  public void htmlReadCompleted(HTMLReadCompletedEvent p_eventObj);    
  public void htmlReadFailed(HTMLReadFailedEvent p_eventObj);    
}
