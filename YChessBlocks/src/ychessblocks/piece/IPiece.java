/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ychessblocks.piece;

import ychessblocks.board.*;

import ychessblocks.position.*;

/**
 *
 * @author Yair
 */
public interface IPiece 
{
  public enum PieceKind
  {
    KING,
    QUEEN,
    ROOK,
    KNIGHT,
    BISHOP,
    PAWN
  }

  public PieceKind getKind();
  public IColor getColor();
  public boolean isWhite();
  public boolean isBlack();
  
  public ISquare[] generateSlides(ISquare from, IPosition position);
  public boolean trySlide(ISquare from, ISquare to, IPosition position);  
}
