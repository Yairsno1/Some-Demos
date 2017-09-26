/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ychessblocks.game;

import ychessblocks.board.*;
import ychessblocks.move.*;
import ychessblocks.position.*;

/**
 *
 * @author Yair
 */
public interface IGame 
{
  public IMoveTree getCurrMove();
  public IMoveTree getStart();
  public void makeMove(ISquare from, ISquare to) throws IllegalMoveException;  
}
