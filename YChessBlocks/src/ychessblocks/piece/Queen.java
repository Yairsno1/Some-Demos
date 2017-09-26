/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ychessblocks.piece;

import java.util.ArrayList;
import ychessblocks.board.*;
import ychessblocks.position.IPosition;

/**
 *
 * @author Yair
 */
public abstract class Queen extends AbsPiece
{
  private ArrayList<ISquare> m_inb;
  
  protected Queen(IColor p_color) 
  {
    super(PieceKind.QUEEN,p_color);
    m_inb = new ArrayList<>();
  }  
   
  @Override
  public boolean trySlide(ISquare p_from, ISquare p_to, IPosition p_position)
  {    
    boolean rv = false; 
    boolean slideFound = false;
    
    m_inb.clear();
    if (p_from == null || p_to == null || p_position == null)
    {
      slideFound = false;
    }
    else if (Slide.north(p_from, p_to, m_inb))
    {
      slideFound = true;
    }
    else if (Slide.northEast(p_from, p_to, m_inb))
    {
      slideFound = true;
    }   
    else if (Slide.east(p_from, p_to, m_inb))
    {
      slideFound = true;
    }
    else if (Slide.southEast(p_from, p_to, m_inb))
    {
      slideFound = true;
    }       
    else if (Slide.south(p_from, p_to, m_inb))
    {
      slideFound = true;
    }
    else if (Slide.southWest(p_from, p_to, m_inb))
    {
      slideFound = true;
    }      
    else if (Slide.west(p_from, p_to, m_inb))
    {
      slideFound = true;
    }
    else if (Slide.northWest(p_from, p_to, m_inb))
    {
      slideFound = true;
    }   

    if (slideFound)
    {
      if (isSquaresEmpty(m_inb, p_position))
      {
        rv = canCapture(p_to,p_position);
      }
    }
    
    return rv;
  }  
  
  protected abstract boolean canCapture(ISquare p_to, IPosition p_position);
}
