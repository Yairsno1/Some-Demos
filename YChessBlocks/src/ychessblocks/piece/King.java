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
public abstract class King extends AbsPiece
{
  private ArrayList<ISquare> m_inb;
  private ArrayList<ISquare> m_slidesFromSquare;
  
  protected King(IColor p_color) 
  {
    super(PieceKind.KING,p_color);
    m_inb = new ArrayList<>();
    m_slidesFromSquare = new ArrayList<>();
  }  
  
  @Override
  public ISquare[] generateSlides(ISquare p_from, IPosition p_position)
  {
    ISquare[] rv;
    IBoard board;
    IFile f;
    IRank r;
    ISquare to;
    
    m_slidesFromSquare.clear();
    board = Board.getInstance();
    
    try
    {
      r = board.incRank(p_from.getRank());
      f = p_from.getFile();
      to = board.getSquare(f, r);
      if (this.trySlide(p_from, to, p_position))
      {
        m_slidesFromSquare.add(to);
      }
    }
    catch (Exception excp) {}

    try
    {
      r = board.incRank(p_from.getRank());
      f = board.incFile(p_from.getFile());
      to = board.getSquare(f, r);
      if (this.trySlide(p_from, to, p_position))
      {
        m_slidesFromSquare.add(to);
      }
    }
    catch (Exception excp) {}

    try
    {
      r = p_from.getRank();
      f = board.incFile(p_from.getFile());
      to = board.getSquare(f, r);
      if (this.trySlide(p_from, to, p_position))
      {
        m_slidesFromSquare.add(to);
      }
    }
    catch (Exception excp) {}
    
    try
    {
      r = board.decRank(p_from.getRank());
      f = board.incFile(p_from.getFile());
      to = board.getSquare(f, r);
      if (this.trySlide(p_from, to, p_position))
      {
        m_slidesFromSquare.add(to);
      }
    }
    catch (Exception excp) {}

    try
    {
      r = board.decRank(p_from.getRank());
      f = p_from.getFile();
      to = board.getSquare(f, r);
      if (this.trySlide(p_from, to, p_position))
      {
        m_slidesFromSquare.add(to);
      }
    }
    catch (Exception excp) {}

    try
    {
      r = board.decRank(p_from.getRank());
      f = board.decFile(p_from.getFile());
      to = board.getSquare(f, r);
      if (this.trySlide(p_from, to, p_position))
      {
        m_slidesFromSquare.add(to);
      }
    }
    catch (Exception excp) {}

    try
    {
      r = p_from.getRank();
      f = board.decFile(p_from.getFile());
      to = board.getSquare(f, r);
      if (this.trySlide(p_from, to, p_position))
      {
        m_slidesFromSquare.add(to);
      }
    }
    catch (Exception excp) {}

    try
    {
      r = board.incRank(p_from.getRank());
      f = board.decFile(p_from.getFile());
      to = board.getSquare(f, r);
      if (this.trySlide(p_from, to, p_position))
      {
        m_slidesFromSquare.add(to);
      }
    }
    catch (Exception excp) {}
    
    this.genetrateCastleSlide(p_from, p_position, m_slidesFromSquare);
    
    rv = new ISquare[m_slidesFromSquare.size()];
   
    return m_slidesFromSquare.toArray(rv);
  }
  
  @Override
  public boolean trySlide(ISquare p_from, ISquare p_to, IPosition p_position)
  {    
    boolean rv; 
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

    if (slideFound && m_inb.isEmpty())
    {
      rv = canCapture(p_to,p_position);
    }
    else
    {
      m_inb.clear();
      rv = canCastle(p_from,p_to,p_position);
    }
    
    return rv;
  }  
  
  protected abstract boolean canCapture(ISquare p_to, IPosition p_position);
  protected abstract boolean canCastle(ISquare p_from, 
                                       ISquare p_to,
                                       IPosition p_position);
  protected abstract void genetrateCastleSlide(ISquare p_from,
                                               IPosition p_position,
                                               ArrayList<ISquare> p_slides); 
}
