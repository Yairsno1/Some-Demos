/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ychessblocks.board;

/**
 *
 * @author Yair
 */
public class ChessColor
{
  private IColor m_white;
  private IColor m_black;
  
  private static ChessColor m_instance = new ChessColor();
  
  private ChessColor()
  {    
    m_white = new Color(IColor.ChessColor.WHITE);
    m_black = new Color(IColor.ChessColor.BLACK);
  }
  
  public static ChessColor getInstance()
  {
    return m_instance;  
  }
  
  public IColor getWhite()
  {
    return m_white;
  }

  public IColor getBlack()
  {
    return m_black;
  }
  
  
  private class Color implements IColor
  {
    private ChessColor m_color;
    
    public Color(ChessColor p_color)
    {
      m_color = p_color;
    }
    
    @Override
    public ChessColor getColor()
    {
      return m_color;
    }
    
    @Override
    public boolean equals(Object obj)
    {
      boolean rv;      
      
      if (obj == this)
      {
        rv = true;
      }
      else if((obj == null) || (obj.getClass() != this.getClass()))
      {
        rv = false;
      }
      else
      {
        rv = (((Color)obj).m_color == this.m_color);
      }
      
      return rv;
    }
    
    @Override
    public int hashCode()
    {
      return m_color == ChessColor.WHITE ? 1 : 2;
    }
  }
}
