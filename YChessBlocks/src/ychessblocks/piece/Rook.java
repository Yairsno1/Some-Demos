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
public abstract class Rook extends AbsPiece
{
  private ArrayList<ISquare> m_inb;
  private ArrayList<ISquare> m_slidesFromSquare;
  
  protected Rook(IColor p_color)
  {
    super(PieceKind.ROOK,p_color);
    m_inb = new ArrayList<>();
    m_slidesFromSquare = new ArrayList<>();
  }
  
  @Override
  public ISquare[] generateSlides(ISquare p_from, IPosition p_position)
  {
    ISquare[] rv;
    boolean done;
    IBoard board;
    IFile f;
    IRank r;
    ISquare to;
    ISquare tmpFrom;
    
    m_slidesFromSquare.clear();
    board = Board.getInstance();
    
    done = false;
    tmpFrom = p_from;
    do
    {
      try
      {
        r = board.incRank(tmpFrom.getRank());
        f = tmpFrom.getFile();
        to = board.getSquare(f, r);
        if (this.trySlide(p_from, to, p_position))
        {
          m_slidesFromSquare.add(to);
        }
        else
        {
          done = true;
        }
        tmpFrom = to;
      }
      catch (Exception excp) { done = true; }
    } while (!done); 
    
    done = false;
    tmpFrom = p_from;
    do
    {
      try
      {
        r = board.decRank(tmpFrom.getRank());
        f = tmpFrom.getFile();
        to = board.getSquare(f, r);
        if (this.trySlide(p_from, to, p_position))
        {
          m_slidesFromSquare.add(to);
        }
        else
        {
          done = true;
        }
        tmpFrom = to;
      }
      catch (Exception excp) {done=true;}
    } while (!done);
    
    done = false;
    tmpFrom = p_from;
    do
    {
      try
      {
        r = tmpFrom.getRank();
        f = board.decFile(tmpFrom.getFile());
        to = board.getSquare(f, r);
        if (this.trySlide(p_from, to, p_position))
        {
          m_slidesFromSquare.add(to);
        }
        else
        {
          done = true;
        }
        tmpFrom = to;
      }
      catch (Exception excp) {done=true;}
    } while (!done);

    done = false;
    tmpFrom = p_from;
    do
    {
      try
      {
        r = tmpFrom.getRank();
        f = board.incFile(tmpFrom.getFile());
        to = board.getSquare(f, r);
        if (this.trySlide(p_from, to, p_position))
        {
          m_slidesFromSquare.add(to);
        }
        else
        {
          done = true;
        }
        tmpFrom = to;
      }
      catch (Exception excp) {done=true;}
    } while (!done);
    
    rv = new ISquare[m_slidesFromSquare.size()];
   
    return m_slidesFromSquare.toArray(rv);
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
    else if (Slide.east(p_from, p_to, m_inb))
    {
      slideFound = true;
    }
    else if (Slide.south(p_from, p_to, m_inb))
    {
      slideFound = true;
    }
    else if (Slide.west(p_from, p_to, m_inb))
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
