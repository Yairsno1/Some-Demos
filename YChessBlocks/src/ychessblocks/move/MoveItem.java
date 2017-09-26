/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ychessblocks.move;

import ychessblocks.board.ISquare;
import ychessblocks.piece.IPiece;

/**
 *
 * @author Yair
 */
public class MoveItem implements IMoveItem
{
  private IMoveTree m_owner;
  private ISquare m_from;
  private ISquare m_to;
  private IMoveTree m_next;
  
  public MoveItem(IMoveTree p_owner,
                  ISquare p_from, ISquare p_to,
                  IMoveTree p_next)
  {
    m_owner = p_owner;
    m_from = p_from;
    m_to = p_to;
    m_next = p_next;
  }
  
  @Override
  public IPiece getPiece()
  {
    return m_owner.getPosition().getPiece(m_from);
  }

  @Override
  public ISquare getFrom()
  {
    return m_from;
  }

  @Override
  public ISquare getTo()
  {
    return m_to;
  }

  @Override
  public IMoveTree getNext() 
  {
    return m_next;
  }

  @Override
  public IMoveTree getOwner() 
  {
    return m_owner;
  }
  
}
