/*
 * AbsWebReader.java
 *
 * Created on 28 מרץ 2006, 11:34
 */

package StrategyExplorer.web;

/**
 *
 * @author  Yair
 */

public abstract class AbsWebReader implements IWebReader 
{
  private IHTMLReaderListener m_listener;
  
  public AbsWebReader() 
  {
    m_listener = null;    
  }
  
  public void setListener(IHTMLReaderListener p_listener)
  {
    m_listener = p_listener;    
  }
  
  public void removeListener()
  {
    m_listener = null;    
  }
  
  protected IHTMLReaderListener getListener()
  {
    return m_listener;    
  }
  
  protected void fireCompleted(String p_html)
  {
    if (m_listener != null)
    {
      m_listener.htmlReadCompleted(new HTMLReadCompletedEvent(this,p_html)); 
    }
  }

  protected void fireFailed(int p_error)
  {
    if (m_listener != null)
    {
      m_listener.htmlReadFailed(new HTMLReadFailedEvent(this,p_error)); 
    }
  }
  
}
