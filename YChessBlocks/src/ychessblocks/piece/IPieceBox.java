/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ychessblocks.piece;

import ychessblocks.board.IColor;

/**
 *
 * @author Yair
 */
public interface IPieceBox 
{
  public IPiece createWhiteRook();
  public IPiece createBlackRook();

  public IPiece createWhiteKnight();
  public IPiece createBlackKnight();
  
  public IPiece createWhiteBishop();
  public IPiece createBlackBishop();

  public IPiece createWhiteQueen();
  public IPiece createBlackQueen();

  public IPiece createWhiteKing();
  public IPiece createBlackKing();
  
  public IPiece createWhitePawn();
  public IPiece createBlackPawn();
  
  public IPiece createPiece(IPiece.PieceKind pieceKind, IColor color) 
                         throws IllegalArgumentException ;
}
