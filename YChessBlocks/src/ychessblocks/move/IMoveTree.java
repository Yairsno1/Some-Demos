/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ychessblocks.move;

import ychessblocks.board.ISquare;
import ychessblocks.position.IPosition;
import ychessblocks.position.IllegalMoveException;

/**
 *
 * @author Yair
 */
public interface IMoveTree 
{    
  public IMoveItem getMainMove(); 
  public int getMoveNumber();
  public IPosition getPosition();
  public IMoveTree getPrev();  
  public IMoveItem[] getVariations();
    
  public IMoveItem addMove(ISquare p_from, ISquare p_to) throws IllegalMoveException;
  public boolean isMoveExist(ISquare from, ISquare to);
}
