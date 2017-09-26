/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ychessblocks.move;

import ychessblocks.board.*;
import ychessblocks.position.*;

/**
 *
 * @author Yair
 */
public interface IMoveList
{
  public IPosition getPosition();
  public int getMoveNumber();
  public ISquare getFrom();
  public ISquare getTo();
  public IMoveList getNext();
  public IMoveList getPrev();
  
  public IMoveList execute(ISquare from, ISquare to) throws IllegalMoveException,
                                                            IllegalArgumentException,
                                                            IllegalAccessException;
}
