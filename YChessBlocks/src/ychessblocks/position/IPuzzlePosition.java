/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ychessblocks.position;

import ychessblocks.board.IColor;
import ychessblocks.board.ISquare;

/**
 *
 * @author Yair
 */
public interface IPuzzlePosition extends IPosition
{
  public void set(ISquarePiece[] piecePlacement,
                  IColor activeColor,
                  boolean white00,
                  boolean white000,
                  boolean black00,
                  boolean black000,
                  ISquare enPassant,
                  int halfMoveClock,
                  int fullMoveNumber) throws IllegalKingException,
                                             IllegalPawnException,
                                             IllegalTurnException,
                                             IllegalArgumentException;  
  
}
