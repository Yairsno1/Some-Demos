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
public interface IMoveItem 
{
  public IPiece getPiece();
  public ISquare getFrom();
  public ISquare getTo();
  
  public IMoveTree getNext();
  public IMoveTree getOwner();
}
