/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ychessblocks.move;

import ychessblocks.board.IColor;
import ychessblocks.board.ISquare;
import ychessblocks.piece.IPiece;
import ychessblocks.position.IPosition;
import ychessblocks.position.IllegalMoveException;
import java.util.*;

/**
 *
 * @author Yair
 */
public class MoveInfo implements IMoveInfo
{ 
  private IPosition m_position;
  private int m_nextMove;
  private IMoveInfo m_prevMove;
  private ISquare m_from;
  private ISquare m_to;
  private ArrayList<IMoveInfo> m_nextList;
  
  public MoveInfo(IPosition p_position, IMoveInfo p_prevMove)
  {
    m_position = p_position;
    m_nextMove = -1;
    m_prevMove = p_prevMove;
    m_from     = null;
    m_to       = null;    
    m_nextList = new ArrayList<>();
  }
  

  public IMoveInfo addVariant(ISquare p_from, ISquare p_to) throws IllegalMoveException,
                                                                   IllegalArgumentException,
                                                                   NoMainlineException
  {
    IMoveInfo rv;
    IMoveInfo existingMove;
    IMoveInfo variant;
    
    existingMove = findMoveInNextList(p_from, p_to);
    if (m_position == null)
    {
      throw new IllegalArgumentException("Position is missing");
    }
    else if (p_from == null || p_to == null)
    {
      throw new IllegalArgumentException("Source/target square(s) are null");
    }
    else if (m_from == null)
    {
      throw new NoMainlineException("You can't add a variation before setting main continuation");
    }
    else if (existingMove != null)
    {
      rv = existingMove.getNext();
    }    
    else
    {
      try
      {
        variant = new MoveInfo(m_nextList.get(m_nextMove).getPosition(),this);
        ((MoveInfo)variant).execute(p_from, p_to);
        m_nextList.add(variant);
        
        rv = variant.getNext();
      }
      catch (IllegalMoveException | IllegalArgumentException excp)
      {
        throw excp;
      }
    }
    
    return rv;
  }
  
  
  public IMoveInfo execute(ISquare p_from, ISquare p_to) throws IllegalMoveException,
                                                                IllegalArgumentException
  {
    IMoveInfo rv;
    IPosition nextMovePosition;
    
    if (m_position == null)
    {
      throw new IllegalArgumentException("Position is missing");
    }
    else if (p_from == null || p_to == null)
    {
      throw new IllegalArgumentException("Source/target square(s) are null");
    }
    else if (m_from != null)
    {
      throw new IllegalArgumentException("Move is existing");
    }
    else
    {
      try
      {
        nextMovePosition = m_position.move(p_from, p_to);
        m_from = p_from;
        m_to = p_to;
        m_nextList.add(new MoveInfo(nextMovePosition,this));
        m_nextMove = 0;
        
        rv = m_nextList.get(m_nextMove);
      }
      catch (IllegalMoveException excp)
      {
        throw excp;  
      }      
    }
    
    return rv;
  }
  
  @Override
  public IColor getColor()
  {
    return m_position.getActiveColor();
  }

  @Override
  public ISquare getFrom() 
  {
    return m_from;
  }

  @Override
  public IMoveInfo getNext() 
  {
    return m_nextMove == -1 ? null : m_nextList.get(m_nextMove);
  }
  
  @Override
  public IPiece getPiece() 
  {
    return  m_from==null ? null : m_position.getPiece(m_from);
  }

  @Override
  public IPosition getPosition() 
  {
    return m_position;
  }

  @Override
  public ISquare getTo() 
  {
    return m_to;
  }

  @Override
  public IMoveInfo[] getVariations() 
  {
    IMoveInfo[] rv;
    int i;
    int j = 0;
    
    if (m_nextList.size() > 0)
    {
      rv = new IMoveInfo[m_nextList.size()-1];
      for (i=0; i<m_nextList.size(); i++)
      {
        if (i != m_nextMove)
        {
          rv[j++] = m_nextList.get(i);
        }
      }      
    }
    else
    {
      rv = new IMoveInfo[0];
    }
    
    
    return rv;
  }

  @Override
  public IMoveInfo getPrev() 
  {
    return m_prevMove;
  }

  @Override
  public IMoveInfo findMoveInNextList(ISquare p_from, ISquare p_to)
  {
    IMoveInfo rv = null;
    IMoveInfo mi;
    int i;
    
    if (p_from != null && p_to != null)
    {
      for (i=0; i<m_nextList.size() && rv == null; i++)
      {
        mi = m_nextList.get(i);
        if (p_from.equals(mi.getFrom()) && p_to.equals(mi.getTo()))
        {
          rv = mi;
        }
      }
    }
    
    return rv;
  }
  
}
