/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ychessblocks.piece;

import ychessblocks.board.*;
import java.util.*;

/**
 *
 * @author Yair
 */
public class Slide 
{
  private static IBoard m_board = Board.getInstance();
  private Slide()
  {
    
  }
  
  public static boolean north(ISquare p_from,
                              ISquare p_to,
                              ArrayList<ISquare> p_inBetween)
  {
    boolean rv = false;
    ISquare next;
    IRank nextRank;
    
    p_inBetween.clear();    
    rv = m_board.tryNorth(p_from, p_to);
    if (rv)
    {
      try
      {
        nextRank = m_board.incRank(p_from.getRank());
        next = m_board.getSquare(p_to.getFile(), nextRank);
        while (!p_to.equals(next))
        {
          p_inBetween.add(next);
          
          nextRank = m_board.incRank(next.getRank());
          next = m_board.getSquare(p_to.getFile(), nextRank);         
        }
      }
      catch (Exception excp){}
    }
    
    return rv;
  }

  public static boolean east(ISquare p_from,
                             ISquare p_to,
                             ArrayList<ISquare> p_inBetween)
  {
    boolean rv = false;
    ISquare next;
    IFile nextFile;
    
    p_inBetween.clear();    
    rv = m_board.tryEast(p_from, p_to);
    if (rv)
    {
      try
      {
        nextFile = m_board.incFile(p_from.getFile());
        next = m_board.getSquare(nextFile,p_to.getRank());
        while (!p_to.equals(next))
        {
          p_inBetween.add(next);
          
          nextFile = m_board.incFile(next.getFile());
          next = m_board.getSquare(nextFile,p_to.getRank());         
        }
      }
      catch (Exception excp){}
    }
    
    return rv;
  }
  
  public static boolean south(ISquare p_from,
                              ISquare p_to,
                              ArrayList<ISquare> p_inBetween)
  {
    boolean rv = false;
    ISquare next;
    IRank nextRank;
    
    p_inBetween.clear();    
    rv = m_board.trySouth(p_from, p_to);
    if (rv)
    {
      try
      {
        nextRank = m_board.decRank(p_from.getRank());
        next = m_board.getSquare(p_to.getFile(), nextRank);
        while (!p_to.equals(next))
        {
          p_inBetween.add(next);
          
          nextRank = m_board.decRank(next.getRank());
          next = m_board.getSquare(p_to.getFile(), nextRank);         
        }
      }
      catch (Exception excp){}
    }
    
    return rv;
  }

  public static boolean west(ISquare p_from,
                             ISquare p_to,
                             ArrayList<ISquare> p_inBetween)
  {
    boolean rv = false;
    ISquare next;
    IFile nextFile;
    
    p_inBetween.clear();    
    rv = m_board.tryWest(p_from, p_to);
    if (rv)
    {
      try
      {
        nextFile = m_board.decFile(p_from.getFile());
        next = m_board.getSquare(nextFile,p_to.getRank());
        while (!p_to.equals(next))
        {
          p_inBetween.add(next);
          
          nextFile = m_board.decFile(next.getFile());
          next = m_board.getSquare(nextFile,p_to.getRank());         
        }
      }
      catch (Exception excp){}
    }
    
    return rv;
  }
  
  public static boolean northEast(ISquare p_from,
                                  ISquare p_to,
                                  ArrayList<ISquare> p_inBetween)
  {
    boolean rv = false;
    ISquare next;
    IFile nextFile;
    IRank nextRank;
    
    p_inBetween.clear();    
    rv = m_board.tryNorthEast(p_from, p_to);
    if (rv)
    {
      try
      {
        nextFile = m_board.incFile(p_from.getFile());
        nextRank = m_board.incRank(p_from.getRank());
        next = m_board.getSquare(nextFile, nextRank);
        while (!p_to.equals(next))
        {
          p_inBetween.add(next);
          
          nextFile = m_board.incFile(next.getFile());
          nextRank = m_board.incRank(next.getRank());
          next = m_board.getSquare(nextFile, nextRank);         
        }
      }
      catch (Exception excp){}
    }
    
    return rv;
  }
 
  public static boolean northWest(ISquare p_from,
                                  ISquare p_to,
                                  ArrayList<ISquare> p_inBetween)
  {
    boolean rv = false;
    ISquare next;
    IFile nextFile;
    IRank nextRank;
    
    p_inBetween.clear();    
    rv = m_board.tryNorthWest(p_from, p_to);
    if (rv)
    {
      try
      {
        nextFile = m_board.decFile(p_from.getFile());
        nextRank = m_board.incRank(p_from.getRank());
        next = m_board.getSquare(nextFile, nextRank);
        while (!p_to.equals(next))
        {
          p_inBetween.add(next);
          
          nextFile = m_board.decFile(next.getFile());
          nextRank = m_board.incRank(next.getRank());
          next = m_board.getSquare(nextFile, nextRank);         
        }
      }
      catch (Exception excp){}
    }
    
    return rv;
  }

  public static boolean southEast(ISquare p_from,
                                  ISquare p_to,
                                  ArrayList<ISquare> p_inBetween)
  {
    boolean rv;
    ISquare next;
    IFile nextFile;
    IRank nextRank;
    
    p_inBetween.clear();    
    rv = m_board.trySouthEast(p_from, p_to);
    if (rv)
    {
      try
      {
        nextFile = m_board.incFile(p_from.getFile());
        nextRank = m_board.decRank(p_from.getRank());
        next = m_board.getSquare(nextFile, nextRank);
        while (!p_to.equals(next))
        {
          p_inBetween.add(next);
          
          nextFile = m_board.incFile(next.getFile());
          nextRank = m_board.decRank(next.getRank());
          next = m_board.getSquare(nextFile, nextRank);         
        }
      }
      catch (Exception excp)
      {
        p_inBetween.clear();    
        rv = false;
      }
    }
    
    return rv;
  }

  public static boolean southWest(ISquare p_from,
                                  ISquare p_to,
                                  ArrayList<ISquare> p_inBetween)
  {
    boolean rv;
    ISquare next;
    IFile nextFile;
    IRank nextRank;
    
    p_inBetween.clear();    
    rv = m_board.trySouthWest(p_from, p_to);
    if (rv)
    {
      try
      {
        nextFile = m_board.decFile(p_from.getFile());
        nextRank = m_board.decRank(p_from.getRank());
        next = m_board.getSquare(nextFile, nextRank);
        while (!p_to.equals(next))
        {
          p_inBetween.add(next);
          
          nextFile = m_board.decFile(next.getFile());
          nextRank = m_board.decRank(next.getRank());
          next = m_board.getSquare(nextFile, nextRank);         
        }
      }
      catch (Exception excp)
      {
        p_inBetween.clear();    
        rv = false;
      }
    }
    
    return rv;
  }
  
}
