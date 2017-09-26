/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ychessblocks.move;

import ychessblocks.board.ISquare;
import ychessblocks.position.*;

/**
 *
 * @author Yair
 */
public class MoveList implements IMoveList
{

  private MoveTree m_context;
  private IMoveList m_prev;
  private IMoveList m_next;
  
  private MoveList(MoveTree p_context, IMoveList p_prev)
  {
    m_context = p_context;
    m_prev = p_prev;
    m_next = null;
  }
  
  public static IMoveList CreateListStart()
  {
    IPosition pos = new Position();
    pos.set();
    
    return new MoveList((MoveTree)(MoveTree.createTreeStart(pos, 1)),null);
  }
  
  @Override
  public IPosition getPosition() 
  {
    return m_context.getPosition();
  }

  @Override
  public int getMoveNumber() 
  {
    return m_context.getMoveNumber();
  }

  @Override
  public ISquare getFrom() 
  {
    ISquare rv = null;
    
    if (m_context.getMainMove() != null)
    {
      rv = m_context.getMainMove().getFrom();
    }
    
    return rv;
  }

  @Override
  public ISquare getTo() 
  {
    ISquare rv = null;
    
    if (m_context.getMainMove() != null)
    {
      rv = m_context.getMainMove().getTo();
    }
    
    return rv;

  }

  @Override
  public IMoveList getNext() 
  {
    return m_next;
  }

  @Override
  public IMoveList getPrev() 
  {
    return m_prev;
  }

  @Override
  public IMoveList execute(ISquare p_from, ISquare p_to) throws IllegalMoveException,
                                                                IllegalArgumentException,
                                                                IllegalAccessException
  {
    IMoveTree mt;
    IMoveItem mi;
    
    if (m_context.getMainMove() == null)
    {
      try
      {
        mi     = m_context.addMove(p_from, p_to);
        mt     = mi.getNext();
        m_next = new MoveList((MoveTree)mt,this);
      }
      catch(IllegalMoveException | IllegalArgumentException excp)
      {
        throw excp;
      }
    }
    else
    {
      throw new IllegalAccessException();
    }
    
    return m_next;
  }
  
}
