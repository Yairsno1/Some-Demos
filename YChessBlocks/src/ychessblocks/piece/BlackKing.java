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
public class BlackKing  extends King
{
  IColor m_colWhite;
  
  public BlackKing()
  {
    super(ChessColor.getInstance().getBlack());
    m_colWhite = ChessColor.getInstance().getWhite(); 
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
  protected boolean canCapture(ISquare p_to, IPosition p_position)
  {
    boolean rv = false;
    IPiece p;
    
    p = p_position.getPiece(p_to);
    if (p == null)
    {
      rv = true;
    }
    else if (p.isWhite())
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
    ISquare e8 = board.getSquare(board.getFile(IFile.ChessboardFile.FILEe),
                                 board.getRank(IRank.ChessboardRank.RANK8));
    ISquare g8 = board.getSquare(board.getFile(IFile.ChessboardFile.FILEg),
                                 board.getRank(IRank.ChessboardRank.RANK8));
    ISquare c8 = board.getSquare(board.getFile(IFile.ChessboardFile.FILEc),
                                 board.getRank(IRank.ChessboardRank.RANK8));
    
    if (p_from.equals(e8))
    {
      if (this.trySlide(p_from, g8, p_position))
      {
        p_slides.add(g8);
      }
      if (this.trySlide(p_from, c8, p_position))
      {
        p_slides.add(c8);
      }     
    }
  }
  
  private boolean tryCastleShort(ISquare p_from, 
                                 ISquare p_to,
                                 IPosition p_position)
  {
    boolean rv = false;
    IBoard board = Board.getInstance();
    ISquare e8 = board.getSquare(board.getFile(IFile.ChessboardFile.FILEe),
                                 board.getRank(IRank.ChessboardRank.RANK8));
    ISquare f8 = board.getSquare(board.getFile(IFile.ChessboardFile.FILEf),
                                 board.getRank(IRank.ChessboardRank.RANK8));
    ISquare g8 = board.getSquare(board.getFile(IFile.ChessboardFile.FILEg),
                                 board.getRank(IRank.ChessboardRank.RANK8));
    ISquare h8 = board.getSquare(board.getFile(IFile.ChessboardFile.FILEh),
                                 board.getRank(IRank.ChessboardRank.RANK8));
    
    if (p_from.equals(e8) && p_to.equals(g8))
    {
      if (p_position.isBlack00())
      {
        IPiece tmpBlackRook = PieceBox.getInstance().createBlackRook();
        if (tmpBlackRook.equals(p_position.getPiece(h8)))
        {
          if (p_position.getPiece(f8) == null && p_position.getPiece(g8) == null)
          {
            ISquare[] e8CrossOn;
            ISquare[] f8CrossOn;
            ISquare[] g8CrossOn;
            e8CrossOn = p_position.isSquareRayed(e8, m_colWhite);
            f8CrossOn = p_position.isSquareRayed(f8, m_colWhite);
            g8CrossOn = p_position.isSquareRayed(g8, m_colWhite);
            if (e8CrossOn.length==0 && f8CrossOn.length==0 && g8CrossOn.length==0)
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
    ISquare e8 = board.getSquare(board.getFile(IFile.ChessboardFile.FILEe),
                                 board.getRank(IRank.ChessboardRank.RANK8));
    ISquare d8 = board.getSquare(board.getFile(IFile.ChessboardFile.FILEd),
                                 board.getRank(IRank.ChessboardRank.RANK8));
    ISquare c8 = board.getSquare(board.getFile(IFile.ChessboardFile.FILEc),
                                 board.getRank(IRank.ChessboardRank.RANK8));
    ISquare a8 = board.getSquare(board.getFile(IFile.ChessboardFile.FILEa),
                                 board.getRank(IRank.ChessboardRank.RANK8));
    ISquare b8 = board.getSquare(board.getFile(IFile.ChessboardFile.FILEb),
                                 board.getRank(IRank.ChessboardRank.RANK8));
    
    if (p_from.equals(e8) && p_to.equals(c8))
    {
      if (p_position.isBlack000())
      {
        IPiece tmpBlackRook = PieceBox.getInstance().createBlackRook();
        if (tmpBlackRook.equals(p_position.getPiece(a8)))
        {
          if (p_position.getPiece(d8) == null && 
              p_position.getPiece(c8) == null && 
              p_position.getPiece(b8) == null)
          {
            ISquare[] e8CrossOn;
            ISquare[] d8CrossOn;
            ISquare[] c8CrossOn;
            e8CrossOn = p_position.isSquareRayed(e8, m_colWhite);
            d8CrossOn = p_position.isSquareRayed(d8, m_colWhite);
            c8CrossOn = p_position.isSquareRayed(c8, m_colWhite);
            if (e8CrossOn.length==0 && d8CrossOn.length==0 && c8CrossOn.length==0)
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
