/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ychessblocks.move;

import java.util.ArrayList;
import ychessblocks.board.ChessColor;
import ychessblocks.board.IColor;
import ychessblocks.board.ISquare;
import ychessblocks.position.*;
/**
 *
 * @author Yair
 */
public abstract class AbsMoveTree implements IMoveTree
{
  private IPosition m_position;
  private IMoveTree m_prev;
  private ArrayList<IMoveItem> m_moves;
  private int m_mainMovePtr;
  private int m_moveNumber;
  
  protected AbsMoveTree(IPosition p_position, IMoveTree p_prev)
  {
    m_position = p_position;
    m_prev = p_prev;
    m_moves = new ArrayList<>(); 
    m_mainMovePtr = 0;
    calcMoveNumber();
  }

  protected AbsMoveTree(IPosition p_position,
                        IMoveTree p_prev,
                        int p_moveNumber)
  {
    this(p_position,p_prev);
    m_moveNumber = p_moveNumber;
  }
  
  @Override
  public IMoveItem getMainMove() 
  {
    return m_moves.isEmpty() ? null : m_moves.get(m_mainMovePtr);
  }

  @Override
  public int getMoveNumber()
  {
    return m_moveNumber;
  }
  
  @Override
  public IPosition getPosition() 
  {
    return m_position;
  }

  @Override
  public IMoveTree getPrev() 
  {
    return m_prev;
  }

  @Override
  public IMoveItem[] getVariations() 
  {
    IMoveItem[] rv;
    int i;
    int j = 0;
    
    if (m_moves.size() > 0)
    {
      rv = new IMoveItem[m_moves.size()-1];
      for (i=0; i<m_moves.size(); i++)
      {
        if (i != m_mainMovePtr)
        {
          rv[j++] = m_moves.get(i);
        }
      }      
    }
    else
    {
      rv = new IMoveItem[0];
    }
        
    return rv;
  }

  @Override
  public IMoveItem addMove(ISquare p_from, ISquare p_to) throws IllegalMoveException 
  {
    IMoveItem rv;
    IPosition nextPos;
    IMoveTree next;
    
    if (p_from == null || p_to == null)
    {
      throw new IllegalArgumentException("Source/target square(s) are null");
    }
    else if (m_position == null)
    {
      throw new IllegalArgumentException("Position is missing");
    }
    else
    {
      rv = findMove(p_from, p_to);
      if (rv == null)
      {
        try
        {
          nextPos = m_position.move(p_from, p_to);
          next = doCreateMoveTree(nextPos,this);
          
          rv = new MoveItem(this,p_from, p_to,next);
          m_moves.add(rv);
        }
        catch (IllegalMoveException | IllegalArgumentException excp)
        {
          throw excp;
        }
      }
    }
    
    return rv;    
  }

  @Override
  public boolean isMoveExist(ISquare p_from, ISquare p_to) 
  {
    boolean rv = false;
            
    if (p_from != null && p_to != null)
    {
      rv = (findMove(p_from, p_to) != null);
    }
    
    return rv;
  }
  
  protected abstract AbsMoveTree doCreateMoveTree(IPosition p_position, IMoveTree p_prev);
  
  private IMoveItem findMove(ISquare p_from, ISquare p_to)
  {
    IMoveItem rv = null;
    int i;    
    IMoveItem tmpMove;
    
    for (i=0; i<m_moves.size(); i++)
    {
      tmpMove = m_moves.get(i);
      if (tmpMove.getFrom().equals(p_from) && tmpMove.getTo().equals(p_to))
      {
        rv = tmpMove;
        break;
      }
    }
    
    return rv;
  }
  
  private void calcMoveNumber()
  {
    if (m_position != null && m_prev != null)
    {
      IColor black = ChessColor.getInstance().getBlack();
      IColor activeColor = m_position.getActiveColor();
      m_moveNumber = activeColor.equals(black) ? m_prev.getMoveNumber() : 
                                                 1 + m_prev.getMoveNumber();
    }
  }
  
}

