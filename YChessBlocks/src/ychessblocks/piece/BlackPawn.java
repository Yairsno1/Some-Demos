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
public class BlackPawn extends Pawn
{
  private ArrayList<ISquare> m_slidesFromSquare;
  
  public BlackPawn()
  {
    super(ChessColor.getInstance().getBlack());
    m_slidesFromSquare = new ArrayList<>();
  } 
  
  @Override
  public boolean isWhite()
  {
    return false;    
  }

  @Override
  public boolean isBlack() 
  {
    return true;
  }
  
  @Override
  public ISquare[] generateSlides(ISquare p_from, IPosition p_position)
  {
    ISquare[] rv;
    IBoard board;
    IFile f;
    IRank r;
    ISquare to;
    ISquare tmpFrom;
    
    m_slidesFromSquare.clear();
    board = Board.getInstance();
    
    try
    {
      r = board.decRank(p_from.getRank());
      f = p_from.getFile();
      to = board.getSquare(f, r);
      if (this.trySlide(p_from, to, p_position))
      {
        m_slidesFromSquare.add(to);
      }
      
      if (p_from.getRank().getVal().equals(IRank.ChessboardRank.RANK7))
      {
        r = board.getRank(IRank.ChessboardRank.RANK5);
        f = p_from.getFile();        
        to = board.getSquare(f, r);
        if (this.trySlide(p_from, to, p_position))
        {
          m_slidesFromSquare.add(to);
        }        
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
      f = board.decFile(p_from.getFile());
      to = board.getSquare(f, r);
      if (this.trySlide(p_from, to, p_position))
      {
        m_slidesFromSquare.add(to);
      }
    }
    catch (Exception excp) {}
    
    rv = new ISquare[m_slidesFromSquare.size()];
   
    return m_slidesFromSquare.toArray(rv);   
  }
  
  @Override
  public boolean trySlide(ISquare p_from, ISquare p_to, IPosition p_position)
  {    
    boolean rv = false;
    ArrayList<ISquare> inb = new ArrayList<>();
    IPiece anyPiece;
    
    if (p_from == null || p_to == null || p_position == null)
    {
      rv = false;
    }
    else if (Slide.south(p_from, p_to, inb))
    {
      if ((p_from.getRank().getVal().equals(IRank.ChessboardRank.RANK7) && inb.size() <= 1) || 
          inb.isEmpty())
      {
        if (p_position.getPiece(p_to) == null)
        {
          rv = true;
          if (inb.size() == 1)
          {
            rv = (p_position.getPiece(inb.get(0)) == null);
          }
        }
      }
    }
    else if (Slide.southEast(p_from, p_to, inb))
    {
      if (inb.isEmpty())
      {
        anyPiece = p_position.getPiece(p_to);
        if (anyPiece != null)
        {
          rv = anyPiece.isWhite();
        }
        else if (p_to.equals(p_position.getEnpassant()))
        {
          rv = true;
        }       
      }
    }
    else if (Slide.southWest(p_from, p_to, inb))
    {
      if (inb.isEmpty())
      {
        anyPiece = p_position.getPiece(p_to);
        if (anyPiece != null)
        {
          rv = anyPiece.isWhite();
        }
        else if (p_to.equals(p_position.getEnpassant()))
        {
          rv = true;
        }       
      }
    }
      
    return rv;
  }
  
}
