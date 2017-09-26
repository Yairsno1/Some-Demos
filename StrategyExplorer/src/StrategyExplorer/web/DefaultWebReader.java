/*
 * DefaultWebReader.java
 *
 * Created on 25 מרץ 2006, 19:44
 */

package StrategyExplorer.web;

/**
 *
 * @author  Yair
 */

import java.io.*;
import java.net.*;
import java.util.*;

public class DefaultWebReader extends AbsWebReader
{
  private final int M_DEFAULT_TIMEOUT = 60;
  
  private int m_timeout;
  
  public DefaultWebReader() 
  {
    m_timeout = M_DEFAULT_TIMEOUT;    
  }
    
  public int getTimeout()
  {
    return m_timeout;    
  }
  
  public void setTimeout(int p_timeout)
  {
    m_timeout = p_timeout;    
  }

  public void restoreDefaultTimeout()
  {
    m_timeout = M_DEFAULT_TIMEOUT;
  }
  
  public void getPage(String p_URL) 
  {
    if (getListener() != null)
    {
      Thread readThrd = new ReadThread(p_URL,"Default HTML Reader");  
      readThrd.start();
    }
  }
  
  private class ReadThread extends Thread
  {
    private String m_URL;
    private Timer m_TO;
    
    private boolean m_timeExpired;
    
    public ReadThread(String p_URL, String p_name)
    {
      super(p_name);    
      m_URL = p_URL;
      m_timeExpired = false;
    }
    
    public void run()
    {
      StringBuffer html = null;
      int errCode = HTML_READ_OK;
      URL urlSource = null;
      InputStream urlStream = null;
      BufferedReader bf = null;
      String line = null;
      TimeoutTask TOTask = null;
      
      m_timeExpired = false;
      html = new StringBuffer("");
        
      try
      {
        urlSource = new URL(m_URL);
      } catch (MalformedURLException mue)
        {
          errCode = HTML_READ_ERROR_MALFORMED_URL;          
        }
      
      if (!isError(errCode))
      {
        try
        {
          urlStream = urlSource.openStream();    
        }  catch (IOException ioe)
          {
            errCode = HTML_READ_ERROR_IO;  
          }            
      }
      
      if (!isError(errCode))
      {
        TOTask = new TimeoutTask();
        m_TO = new Timer();
        m_TO.schedule(TOTask, getTimeout()*1000);
        
        bf = new BufferedReader(new InputStreamReader(urlStream));    
        try
        {
          while ((line = bf.readLine()) != null && !m_timeExpired)
          {
            html.append(line);  
          }
        } catch (IOException ioe)
          {
            errCode = HTML_READ_ERROR_IO;
          }
      }
      
      //Cleanup ...
      if (!m_timeExpired)
      {
        if (TOTask != null)
        {
          TOTask.cancel();
          m_TO.cancel();
        }
      }
      else
      {
        errCode = HTML_READ_ERROR_TIMEOUT;    
      }
      if (urlStream != null)
      {
        try
        {
        urlStream.close();    
        }  catch (IOException ioe)
          {
            errCode = HTML_READ_ERROR_IO;
          }        
      }
      if (bf != null)
      {
        try
        {
          bf.close();    
        } catch (IOException ioe)
          {
            errCode = HTML_READ_ERROR_IO;
          }
      }
      
      if (isError(errCode))
      {
        fireFailed(errCode);    
      }
      else
      {
        fireCompleted(html.toString());    
      }
    }
    
    private boolean isError(int p_errorCode)
    {
      return (p_errorCode != HTML_READ_OK);    
    }
    
      //--------------------------------------------------
     //Timer thread for timeout implementation whitin
     // ReadThread
     //---------------------------------------------------
      class TimeoutTask extends TimerTask 
      {
        public void run() 
        {
          m_timeExpired = true;      
          m_TO.cancel();
        }
      }

  }
  
  
}
