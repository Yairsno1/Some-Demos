/*
 * BizportalTA25OptionsReader.java
 *
 * Created on 25 מרץ 2006, 20:29
 */

package StrategyExplorer.web;

/**
 *
 * @author  Yair
 */

public class BizportalTA25OptionsReader implements IHTMLReaderListener
{
  private final String M_URL_ADDRESS = "http://www.bizportal.co.il/shukhahon/bizfview.shtml";
  
  private IWebReader m_reader;
  
  public BizportalTA25OptionsReader() 
  {
    m_reader = new DefaultWebReader();
  }
    
  public void readPage()
  {
    m_reader.setListener(this);  
    m_reader.getPage(M_URL_ADDRESS);
  }
  
  public void htmlReadCompleted(HTMLReadCompletedEvent p_eventObj) 
  {
    String  searchString;

    searchString="bizmadad.shtml?p_id=198"; //דף מדד ת"א 25"
    
    System.out.println("Completed successfuly");   
    int xx = p_eventObj.getHTML().indexOf(searchString,0);
    if (xx >= 0)
    {
      System.out.println(searchString.toString() + ": (" + xx + ")");   
    }
  }
  
  public void htmlReadFailed(HTMLReadFailedEvent p_eventObj) 
  {
    System.out.println("Failed [Error Code = " + p_eventObj.getError() + "]");         
  }
  
}
