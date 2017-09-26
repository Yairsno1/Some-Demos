/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ychessblocks.piece;

import java.util.ArrayList;
import ychessblocks.board.Board;
import ychessblocks.board.IBoard;
import ychessblocks.board.IColor;
import ychessblocks.board.IFile;
import ychessblocks.board.IRank;
import ychessblocks.board.ISquare;
import ychessblocks.position.IPosition;

/**
 *
 * @author Yair
 */
public abstract class Knight extends AbsPiece
{
  private ArrayList<ISquare> m_slidesFromSquare;
  
  protected Knight(IColor p_color) 
  {
    super(IPiece.PieceKind.KNIGHT,p_color);
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
      r = board.incRank(r);
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
      r = board.incRank(p_from.getRank());
      r = board.incRank(r);
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
      r = board.decRank(p_from.getRank());
      r = board.decRank(r);
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
      r = board.decRank(r);
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
      f = board.incFile(p_from.getFile());
      f = board.incFile(f);
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
      f = board.incFile(f);
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
      f = board.decFile(f);
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
      f = board.decFile(f);
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
    int fileDiff;
    int rankDiff;
    
    if (p_from == null || p_to == null || p_position == null)
    {
      rv = false;  
    }
    else
    {
      fileDiff = p_to.getFile().getVal().getOrdinal() - 
                 p_from.getFile().getVal().getOrdinal();
      fileDiff = Math.abs(fileDiff);
      rankDiff = p_to.getRank().getVal().getOrdinal() - 
                 p_from.getRank().getVal().getOrdinal();
      rankDiff = Math.abs(rankDiff);

      if ((fileDiff == 2 && rankDiff == 1) ||
          (fileDiff == 1 && rankDiff == 2))
      {
        rv = canCapture(p_to, p_position);
      }
    }
    
    return rv;
  }  
  
  protected abstract boolean canCapture(ISquare p_to, IPosition p_position);
}
