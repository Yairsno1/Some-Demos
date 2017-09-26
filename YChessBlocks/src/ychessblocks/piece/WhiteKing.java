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
public class WhiteKing extends King
{
  IColor m_colBlack;
  
  public WhiteKing()
  {
    super(ChessColor.getInstance().getWhite());
    m_colBlack = ChessColor.getInstance().getBlack(); 
  }
  
  @Override
  public boolean isWhite()
  {
    return true;    
  }

  @Override
  public boolean isBlack() 
  {
    return false;
  }
 
  @Override
  protected boolean canCapture(ISquare p_to, IPosition p_position)
  {
    boolean rv = false;
    IPiece p;
    
    p = p_position.getPiece(p_to);
    if (p == null)
    {
      rv = true;
    }
    else if (p.isBlack())
    {
      rv = true;
    }
    
    return rv;
  }
  
  @Override
  protected boolean canCastle(ISquare p_from, 
                              ISquare p_to,
                              IPosition p_position)
  {
    return tryCastleShort(p_from,p_to,p_position) || 
           tryCastleLong(p_from,p_to,p_position);
  }

  @Override
  protected void genetrateCastleSlide(ISquare p_from,
                                      IPosition p_position,
                                      ArrayList<ISquare> p_slides)
  {
    Board board = Board.getInstance();
    ISquare e1 = board.getSquare(board.getFile(IFile.ChessboardFile.FILEe),
                                 board.getRank(IRank.ChessboardRank.RANK1));
    ISquare g1 = board.getSquare(board.getFile(IFile.ChessboardFile.FILEg),
                                 board.getRank(IRank.ChessboardRank.RANK1));
    ISquare c1 = board.getSquare(board.getFile(IFile.ChessboardFile.FILEc),
                                 board.getRank(IRank.ChessboardRank.RANK1));
    
    if (p_from.equals(e1))
    {
      if (this.trySlide(p_from, g1, p_position))
      {
        p_slides.add(g1);
      }
      if (this.trySlide(p_from, c1, p_position))
      {
        p_slides.add(c1);
      }     
    }
  }
  
  private boolean tryCastleShort(ISquare p_from, 
                                 ISquare p_to,
                                 IPosition p_position)
  {
    boolean rv = false;
    IBoard board = Board.getInstance();
    ISquare e1 = board.getSquare(board.getFile(IFile.ChessboardFile.FILEe),
                                 board.getRank(IRank.ChessboardRank.RANK1));
    ISquare f1 = board.getSquare(board.getFile(IFile.ChessboardFile.FILEf),
                                 board.getRank(IRank.ChessboardRank.RANK1));
    ISquare g1 = board.getSquare(board.getFile(IFile.ChessboardFile.FILEg),
                                 board.getRank(IRank.ChessboardRank.RANK1));
    ISquare h1 = board.getSquare(board.getFile(IFile.ChessboardFile.FILEh),
                                 board.getRank(IRank.ChessboardRank.RANK1));
    
    if (p_from.equals(e1) && p_to.equals(g1))
    {
      if (p_position.isWhite00())
      {
        IPiece tmpWhiteRook = PieceBox.getInstance().createWhiteRook();
        if (tmpWhiteRook.equals(p_position.getPiece(h1)))
        {
          if (p_position.getPiece(f1) == null && p_position.getPiece(g1) == null)
          {
            ISquare[] e1CrossOn;
            ISquare[] f1CrossOn;
            ISquare[] g1CrossOn;
            e1CrossOn = p_position.isSquareRayed(e1, m_colBlack);
            f1CrossOn = p_position.isSquareRayed(f1, m_colBlack);
            g1CrossOn = p_position.isSquareRayed(g1, m_colBlack);
            if (e1CrossOn.length==0 && f1CrossOn.length==0 && g1CrossOn.length==0)
            {
              rv = true;
            }
          }
        }
      }
    }
    
    return rv;
  }

  private boolean tryCastleLong(ISquare p_from, 
                                ISquare p_to,
                                IPosition p_position)
  {
    boolean rv = false;
    IBoard board = Board.getInstance();
    ISquare e1 = board.getSquare(board.getFile(IFile.ChessboardFile.FILEe),
                                 board.getRank(IRank.ChessboardRank.RANK1));
    ISquare d1 = board.getSquare(board.getFile(IFile.ChessboardFile.FILEd),
                                 board.getRank(IRank.ChessboardRank.RANK1));
    ISquare c1 = board.getSquare(board.getFile(IFile.ChessboardFile.FILEc),
                                 board.getRank(IRank.ChessboardRank.RANK1));
    ISquare a1 = board.getSquare(board.getFile(IFile.ChessboardFile.FILEa),
                                 board.getRank(IRank.ChessboardRank.RANK1));
    ISquare b1 = board.getSquare(board.getFile(IFile.ChessboardFile.FILEb),
                                 board.getRank(IRank.ChessboardRank.RANK1));
    
    if (p_from.equals(e1) && p_to.equals(c1))
    {
      if (p_position.isWhite000())
      {
        IPiece tmpWhiteRook = PieceBox.getInstance().createWhiteRook();
        if (tmpWhiteRook.equals(p_position.getPiece(a1)))
        {
          if (p_position.getPiece(d1) == null && 
              p_position.getPiece(c1) == null &&
              p_position.getPiece(b1) == null)
          {
            ISquare[] e1CrossOn;
            ISquare[] d1CrossOn;
            ISquare[] c1CrossOn;
            e1CrossOn = p_position.isSquareRayed(e1, m_colBlack);
            d1CrossOn = p_position.isSquareRayed(d1, m_colBlack);
            c1CrossOn = p_position.isSquareRayed(c1, m_colBlack);
            if (e1CrossOn.length==0 && d1CrossOn.length==0 && c1CrossOn.length==0)
            {
              rv = true;
            }
          }
        }
      }
    }
    
    return rv;
  }
  
}
