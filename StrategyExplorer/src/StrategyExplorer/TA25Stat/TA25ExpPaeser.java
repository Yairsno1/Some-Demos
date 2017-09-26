/*
 * TA25ExpPaeser.java
 *
 * Created on 11 מרץ 2006, 21:42
 */

package StrategyExplorer.TA25Stat;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.Date;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;

/**
 *
 * @author  Yair
 */
public class TA25ExpPaeser
{
  private final String ATTR_DELIMITER = ",";
  private final String DATE_ATTR_PATTERN = "dd/MM/yyyy";
    
  String m_filePath;
  TA25ExpBook m_expBook;
  
  public TA25ExpPaeser(String p_filePath)
  {
    m_filePath = p_filePath;    
    m_expBook = null;
  }
  
  public TA25ExpBook getExpBook()
  {
    if (null == m_expBook)
    {     
      parseFile();  
    }
    
    return m_expBook;
  }
  
  private boolean parseFile()
  {
    boolean rv = true;  
    BufferedReader csvFile = null;    
    String lineData;
    DefaultOptMonth optMonth = null;
    IBar currBar = null;
    
    try
    {
      csvFile = new BufferedReader(new InputStreamReader(new FileInputStream(m_filePath)));
    } catch (IOException p_ioe)
      {
        rv = false;
      }
    
    if (rv)
    {
      m_expBook = new TA25ExpBook();      
      try
      {
        lineData = csvFile.readLine();
        if (null == lineData)
        {
          rv = false;    
        }
        else
        {
          optMonth = new DefaultOptMonth();
          optMonth.open(0.);
          while (lineData != null && rv)
          {
            currBar = createBar(lineData);  
            if (null == currBar)
            {
              rv = false;    
            }
            else
            {
              optMonth.addBar(currBar);
              if (currBar.volume() > 1.) 
              {
                optMonth.close(currBar.open());      
                m_expBook.insert(optMonth);
                optMonth.month();
                optMonth = new DefaultOptMonth();
                optMonth.open(currBar.volume());
              }
            }
            lineData = csvFile.readLine();  
          }
        }
      } catch (IOException p_ioe)
        {
          rv = false;
        }
      
    }
    
    if (!rv)
    {
        m_expBook = null;        
    }
    
    return rv;
  }
  
  private IBar createBar(String p_line)
  {
    Bar rv = null;
    Calendar date = null;
    Double open = null;
    Double close = null;
    Double low = null;
    Double high = null;
    Double vol = null;    
    
    String[] attr;  //Bar attributes
    int currAttr = 0;
    
    ParsePosition pos = null;
    SimpleDateFormat dateParser = null;
    
    attr = p_line.split(ATTR_DELIMITER);    
    currAttr = 0;
    
    dateParser = new SimpleDateFormat(DATE_ATTR_PATTERN);                        
    date = dateParser.getCalendar();
    pos = new ParsePosition(0);
    date.setTime(dateParser.parse(attr[currAttr],pos));
    ++currAttr;

    open = new Double(attr[currAttr]);
    ++currAttr;

    high = new Double(attr[currAttr]);
    ++currAttr;

    low = new Double(attr[currAttr]);
    ++currAttr;

    close = new Double(attr[currAttr]);
    ++currAttr;

    vol = new Double(attr[currAttr]);
    //TBC: Handle IV field
    //++currAttr;
    rv = new Bar(date,
                       open.doubleValue(),
                       low.doubleValue(),
                       high.doubleValue(),
                       close.doubleValue(),
                       vol.doubleValue());
    
    return rv;
  }
    
}
