/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ychessblocks.position;

import ychessblocks.board.ChessColor;
import ychessblocks.board.IColor;
import ychessblocks.board.IRank;
import ychessblocks.board.ISquare;
import ychessblocks.piece.IPiece;

/**
 *
 * @author Yair
 */
public class Puzzle extends Position implements IPuzzle 
{

  public Puzzle()
  {
    super();
  }
  
  @Override
  public void set(ISquarePiece[] p_piecePlacement,
                  IColor p_activeColor,
                  boolean p_white00,
                  boolean p_white000,
                  boolean p_black00,
                  boolean p_black000,
                  ISquare enPassant,
                  int p_halfMoveClock,
                  int p_fullMoveNumber) throws IllegalKingException, IllegalPawnException, IllegalTurnException, IllegalArgumentException 
  {
    //Castling rights are taken "as is" and not tested for validity.
    
    int i;
    IPiece p;
    ISquare sq;
    
    clear();
    
    if (p_piecePlacement != null)
    {
      for (i=0; i<p_piecePlacement.length; i++)
      {
        sq = p_piecePlacement[i].getSquare();
        p = p_piecePlacement[i].getPiece();
        if (p == null || sq == null)
        {
          clear();
          throw new IllegalArgumentException("Piece or Square is null");
        }
        putPiece(sq, p);
        
        if (p.getKind() == IPiece.PieceKind.PAWN)
        {
          if (sq.getRank().getVal() == IRank.ChessboardRank.RANK1 ||
              sq.getRank().getVal() == IRank.ChessboardRank.RANK8)
          {
            clear();
            throw new IllegalPawnException("Pawns can't be placed on the first or 8th ranks");
          }
        }
      }
      
      if (countKings(ChessColor.getInstance().getWhite()) != 1 ||
          countKings(ChessColor.getInstance().getBlack()) != 1)
      {
        clear();
        throw new IllegalKingException("Position has to contain exactly one white king and one black king");
      }
    }
    else
    {
      clear();
      throw new IllegalArgumentException("Piece list is null");
    }
            
    setColor(p_activeColor); 
    setCastles(p_white00,p_white000,p_black00,p_black000);  
    setEnpassant(enPassant);
    if (p_halfMoveClock >= 0 && p_halfMoveClock < 50)
    {
      setHalfMoveClock(p_halfMoveClock);
    }
    else
    {
      clear();
      throw new IllegalArgumentException("Half move clock must be in the range 0..49");
    }
    
    if (isCheck(this,
                p_activeColor.getColor().equals(IColor.ChessColor.WHITE) ? 
                   ChessColor.getInstance().getBlack() :
                   ChessColor.getInstance().getWhite()))
    {
      clear();
      throw new IllegalTurnException("In turn color checking the opposing king");
    }
  }

 
}
