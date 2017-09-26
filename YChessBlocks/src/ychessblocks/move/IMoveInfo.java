/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ychessblocks.move;

import ychessblocks.board.*;
import ychessblocks.piece.*;
import ychessblocks.position.*;

/**
 *
 * @author Yair
 */

public interface IMoveInfo 
{
  public IColor getColor();
  public ISquare getFrom();
  public IPiece getPiece();
  public IPosition getPosition();
  public ISquare getTo();
  
  public IMoveInfo getNext();
  public IMoveInfo getPrev();
  public IMoveInfo[] getVariations();
  
  public IMoveInfo findMoveInNextList(ISquare from, ISquare to);
}
