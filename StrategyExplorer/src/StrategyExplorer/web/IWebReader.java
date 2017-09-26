/*
 * IWebReader.java
 *
 * Created on 25 מרץ 2006, 19:32
 */

package StrategyExplorer.web;

/**
 *
 * @author  Yair
 */

public interface IWebReader
{
  public static final int HTML_READ_OK = 0;  
  public static final int HTML_READ_ERROR_IO = 1;
  public static final int HTML_READ_ERROR_TIMEOUT = 2;
  public static final int HTML_READ_ERROR_MALFORMED_URL = 3;
  
  public void getPage(String p_URL);  
  public void setListener(IHTMLReaderListener p_listener);
  public void removeListener();  
}
