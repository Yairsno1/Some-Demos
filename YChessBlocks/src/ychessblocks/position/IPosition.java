/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ychessblocks.position;

import ychessblocks.board.*;
import ychessblocks.piece.*;
        
/**
 *
 * @author Yair
 */
public interface IPosition 
{
  public IColor getActiveColor(); 
  public ISquare getEnpassant();
  public int getHalfMoveCount();
  public IPiece getPiece(ISquare square);
  public boolean isBlack00();
  public boolean isBlack000();
  public boolean isWhite00();
  public boolean isWhite000();
  public boolean isThreefoldRepetition();
  
  public void clearPromotionListener();
  public boolean isMate();
  public ISquare[] isSquareRayed(ISquare square, IColor attackingColor) 
                throws IllegalArgumentException;
  public boolean isStalemate();
  public IPosition move(ISquare from, ISquare to) throws IllegalMoveException,
                                                         IllegalArgumentException;
  public void set();
  public void setPromotionListener(IPromotionListener promotionListener);
}
