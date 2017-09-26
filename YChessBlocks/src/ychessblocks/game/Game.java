/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ychessblocks.game;

import ychessblocks.board.ISquare;
import ychessblocks.move.*;
import ychessblocks.position.*;

/**
 *
 * @author Yair
 */
public class Game implements IGame
{
  private MoveTree m_moves;
  private MoveTree m_start;
  
  public Game()
  {
    Position pos = new Position();
    pos.set();
    
    m_start = (MoveTree)(MoveTree.createTreeStart(pos, 1));
    m_moves = m_start;
  }
  
  @Override
  public IMoveTree getCurrMove()
  {
    return m_moves;
  }

  @Override
  public IMoveTree getStart()
  {
    return m_start;
  }

  @Override
  public void makeMove(ISquare p_from, ISquare p_to) throws IllegalMoveException 
  {
    try
    {
      m_moves.addMove(p_from, p_to);
      m_moves = (MoveTree)(m_moves.getMainMove().getNext());
    }
    catch (IllegalMoveException excp)
    {
      throw excp;
    }
  }
  
}
