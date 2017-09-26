/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ychessblocks.piece;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import ychessblocks.board.*;
import java.util.*;

/**
 *
 * @author Yair
 */
public class SlideTest
{
  private static Board m_board;
  private ArrayList<ISquare> m_inb;
  
  public SlideTest() {
  }
  
  @BeforeClass
  public static void setUpClass() 
  {
    m_board = Board.getInstance();
  }
  
  @AfterClass
  public static void tearDownClass() {
  }
  
  @Before
  public void setUp() 
  {
    m_inb = new ArrayList<>();
  }
  
  @After
  public void tearDown() {
  }

  /**
   * Test of north method, of class Slide.
   */
  @Test
  public void testNorth() 
  {
    
    System.out.println("north");
    
    //Qh2xh7
    ISquare p_from = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEh),
                                       m_board.getRank(IRank.ChessboardRank.RANK2));
    ISquare p_to = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEh),
                                       m_board.getRank(IRank.ChessboardRank.RANK7));
    ArrayList<ISquare> expResult = new ArrayList<>();
    expResult.add(m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEh),
                  m_board.getRank(IRank.ChessboardRank.RANK3)));
    expResult.add(m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEh),
                  m_board.getRank(IRank.ChessboardRank.RANK4)));
    expResult.add(m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEh),
                  m_board.getRank(IRank.ChessboardRank.RANK5)));
    expResult.add(m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEh),
                  m_board.getRank(IRank.ChessboardRank.RANK6)));
    
    boolean result = Slide.north(p_from, p_to,m_inb);
    assertTrue(result);
    assertArrayEquals(expResult.toArray(), m_inb.toArray());
    
    //e4-e5
    p_from = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEe),
                               m_board.getRank(IRank.ChessboardRank.RANK4));
    p_to = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEe),
                             m_board.getRank(IRank.ChessboardRank.RANK5));
    expResult.clear();
    result = Slide.north(p_from, p_to,m_inb);
    assertTrue(result);
    assertTrue(m_inb.isEmpty());    
    
    //c2-c4
    p_from = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEc),
                               m_board.getRank(IRank.ChessboardRank.RANK2));
    p_to = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEc),
                             m_board.getRank(IRank.ChessboardRank.RANK4));
    expResult.clear();
    expResult.add(m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEc),
                  m_board.getRank(IRank.ChessboardRank.RANK3)));
    result = Slide.north(p_from, p_to, m_inb);   
    assertTrue(result);
    assertArrayEquals(expResult.toArray(), m_inb.toArray());

    //Rg5-g8
    p_from = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEg),
                               m_board.getRank(IRank.ChessboardRank.RANK5));
    p_to = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEg),
                             m_board.getRank(IRank.ChessboardRank.RANK8));
    expResult.clear();
    expResult.add(m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEg),
                  m_board.getRank(IRank.ChessboardRank.RANK6)));
    expResult.add(m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEg),
                  m_board.getRank(IRank.ChessboardRank.RANK7)));    
    result = Slide.north(p_from, p_to,m_inb);    
    assertTrue(result);
    assertArrayEquals(expResult.toArray(), m_inb.toArray());
    
    //Nc3-d5
    p_from = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEc),
                               m_board.getRank(IRank.ChessboardRank.RANK3));
    p_to = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEd),
                             m_board.getRank(IRank.ChessboardRank.RANK5));
    expResult.clear();
    result = Slide.north(p_from, p_to,m_inb);    
    assertFalse(result);

    //Qd8-d5
    p_from = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEd),
                               m_board.getRank(IRank.ChessboardRank.RANK8));
    p_to = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEd),
                             m_board.getRank(IRank.ChessboardRank.RANK5));
    expResult.clear();
    result = Slide.north(p_from, p_to,m_inb);    
    assertFalse(result);    
  }

  /**
   * Test of south method, of class Slide.
   */
  @Test
  public void testSouth() 
  {
    System.out.println("south");
    
    //Rb8xb2
    ISquare p_from = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEb),
                                       m_board.getRank(IRank.ChessboardRank.RANK8));
    ISquare p_to = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEb),
                                       m_board.getRank(IRank.ChessboardRank.RANK2));
    ArrayList<ISquare> expResult = new ArrayList<>();
    expResult.add(m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEb),
                  m_board.getRank(IRank.ChessboardRank.RANK7)));    
    expResult.add(m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEb),
                  m_board.getRank(IRank.ChessboardRank.RANK6)));
    expResult.add(m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEb),
                  m_board.getRank(IRank.ChessboardRank.RANK5)));
    expResult.add(m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEb),
                  m_board.getRank(IRank.ChessboardRank.RANK4)));
    expResult.add(m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEb),
                  m_board.getRank(IRank.ChessboardRank.RANK3)));
    boolean result = Slide.south(p_from, p_to,m_inb);
    assertTrue(result);
    assertArrayEquals(expResult.toArray(), m_inb.toArray());
    
    //f3-f2
    p_from = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEf),
                               m_board.getRank(IRank.ChessboardRank.RANK3));
    p_to = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEf),
                             m_board.getRank(IRank.ChessboardRank.RANK2));
    expResult.clear();
    result = Slide.south(p_from, p_to,m_inb);
    assertTrue(result);
    assertTrue(m_inb.isEmpty());

    //e7-e5
    p_from = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEe),
                               m_board.getRank(IRank.ChessboardRank.RANK7));
    p_to = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEe),
                             m_board.getRank(IRank.ChessboardRank.RANK5));
    expResult.clear();
    expResult.add(m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEe),
                  m_board.getRank(IRank.ChessboardRank.RANK6)));    
    result = Slide.south(p_from, p_to,m_inb);
    assertTrue(result);
    assertArrayEquals(expResult.toArray(), m_inb.toArray());

    //Qc5-c1
    p_from = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEc),
                               m_board.getRank(IRank.ChessboardRank.RANK5));
    p_to = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEc),
                             m_board.getRank(IRank.ChessboardRank.RANK1));
    expResult.clear();
    expResult.add(m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEc),
                  m_board.getRank(IRank.ChessboardRank.RANK4)));    
    expResult.add(m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEc),
                  m_board.getRank(IRank.ChessboardRank.RANK3)));    
    expResult.add(m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEc),
                  m_board.getRank(IRank.ChessboardRank.RANK2)));        
    result = Slide.south(p_from, p_to,m_inb);
    assertTrue(result);
    assertArrayEquals(expResult.toArray(), m_inb.toArray());
    
    //Be6-c4
    p_from = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEe),
                               m_board.getRank(IRank.ChessboardRank.RANK6));
    p_to = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEc),
                             m_board.getRank(IRank.ChessboardRank.RANK4));
    expResult.clear();
    result = Slide.south(p_from, p_to,m_inb);
    assertFalse(result);

    //Rb1xb6
    p_from = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEb),
                               m_board.getRank(IRank.ChessboardRank.RANK1));
    p_to = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEb),
                             m_board.getRank(IRank.ChessboardRank.RANK6));
    expResult.clear();
    result = Slide.south(p_from, p_to,m_inb);
    assertFalse(result);    
  }
  
  /**
   * Test of northEast method, of class Slide.
   */
  @Test
  public void testNorthEast() 
  {
    
    System.out.println("northEast");
    
    //Qb2xg7
    ISquare p_from = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEb),
                                       m_board.getRank(IRank.ChessboardRank.RANK2));
    ISquare p_to = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEg),
                                       m_board.getRank(IRank.ChessboardRank.RANK7));
    ArrayList<ISquare> expResult = new ArrayList<>();
    expResult.add(m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEc),
                  m_board.getRank(IRank.ChessboardRank.RANK3)));
    expResult.add(m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEd),
                  m_board.getRank(IRank.ChessboardRank.RANK4)));
    expResult.add(m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEe),
                  m_board.getRank(IRank.ChessboardRank.RANK5)));
    expResult.add(m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEf),
                  m_board.getRank(IRank.ChessboardRank.RANK6)));
    
    boolean result = Slide.northEast(p_from, p_to,m_inb);
    assertTrue(result);
    assertArrayEquals(expResult.toArray(), m_inb.toArray());
    
    //e4xf5
    p_from = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEe),
                               m_board.getRank(IRank.ChessboardRank.RANK4));
    p_to = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEf),
                             m_board.getRank(IRank.ChessboardRank.RANK5));
    expResult.clear();
    result = Slide.northEast(p_from, p_to,m_inb);
    assertTrue(result);
    assertTrue(m_inb.isEmpty());    
    
    //Ba4-c6
    p_from = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEa),
                               m_board.getRank(IRank.ChessboardRank.RANK4));
    p_to = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEc),
                             m_board.getRank(IRank.ChessboardRank.RANK6));
    expResult.clear();
    expResult.add(m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEb),
                  m_board.getRank(IRank.ChessboardRank.RANK5)));
    result = Slide.northEast(p_from, p_to, m_inb);   
    assertTrue(result);
    assertArrayEquals(expResult.toArray(), m_inb.toArray());

    //BBc5-f8
    p_from = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEc),
                               m_board.getRank(IRank.ChessboardRank.RANK5));
    p_to = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEf),
                             m_board.getRank(IRank.ChessboardRank.RANK8));
    expResult.clear();
    expResult.add(m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEd),
                  m_board.getRank(IRank.ChessboardRank.RANK6)));
    expResult.add(m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEe),
                  m_board.getRank(IRank.ChessboardRank.RANK7)));    
    result = Slide.northEast(p_from, p_to,m_inb);    
    assertTrue(result);
    assertArrayEquals(expResult.toArray(), m_inb.toArray());
    
    //Nc3-d5
    p_from = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEc),
                               m_board.getRank(IRank.ChessboardRank.RANK3));
    p_to = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEd),
                             m_board.getRank(IRank.ChessboardRank.RANK5));
    expResult.clear();
    result = Slide.northEast(p_from, p_to,m_inb);    
    assertFalse(result);

    //Qd8-a5
    p_from = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEd),
                               m_board.getRank(IRank.ChessboardRank.RANK8));
    p_to = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEa),
                             m_board.getRank(IRank.ChessboardRank.RANK5));
    expResult.clear();
    result = Slide.northEast(p_from, p_to,m_inb);    
    assertFalse(result);    
  }

  /**
   * Test of northWest method, of class Slide.
   */
  @Test
  public void testNorthWest() 
  {
    
    System.out.println("northWest");
    
    //Qg2xb7
    ISquare p_from = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEg),
                                       m_board.getRank(IRank.ChessboardRank.RANK2));
    ISquare p_to = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEb),
                                       m_board.getRank(IRank.ChessboardRank.RANK7));
    ArrayList<ISquare> expResult = new ArrayList<>();
    expResult.add(m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEf),
                  m_board.getRank(IRank.ChessboardRank.RANK3)));
    expResult.add(m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEe),
                  m_board.getRank(IRank.ChessboardRank.RANK4)));
    expResult.add(m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEd),
                  m_board.getRank(IRank.ChessboardRank.RANK5)));
    expResult.add(m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEc),
                  m_board.getRank(IRank.ChessboardRank.RANK6)));
    
    boolean result = Slide.northWest(p_from, p_to,m_inb);
    assertTrue(result);
    assertArrayEquals(expResult.toArray(), m_inb.toArray());
    
    //e4xd5
    p_from = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEe),
                               m_board.getRank(IRank.ChessboardRank.RANK4));
    p_to = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEd),
                             m_board.getRank(IRank.ChessboardRank.RANK5));
    expResult.clear();
    result = Slide.northWest(p_from, p_to,m_inb);
    assertTrue(result);
    assertTrue(m_inb.isEmpty());    
    
    //Bh4-f6
    p_from = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEh),
                               m_board.getRank(IRank.ChessboardRank.RANK4));
    p_to = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEf),
                             m_board.getRank(IRank.ChessboardRank.RANK6));
    expResult.clear();
    expResult.add(m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEg),
                  m_board.getRank(IRank.ChessboardRank.RANK5)));
    result = Slide.northWest(p_from, p_to, m_inb);   
    assertTrue(result);
    assertArrayEquals(expResult.toArray(), m_inb.toArray());

    //Bd4-a7
    p_from = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEd),
                               m_board.getRank(IRank.ChessboardRank.RANK4));
    p_to = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEa),
                             m_board.getRank(IRank.ChessboardRank.RANK7));
    expResult.clear();
    expResult.add(m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEc),
                  m_board.getRank(IRank.ChessboardRank.RANK5)));
    expResult.add(m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEb),
                  m_board.getRank(IRank.ChessboardRank.RANK6)));    
    result = Slide.northWest(p_from, p_to,m_inb);    
    assertTrue(result);
    assertArrayEquals(expResult.toArray(), m_inb.toArray());
    
    //Nc3-d5
    p_from = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEc),
                               m_board.getRank(IRank.ChessboardRank.RANK3));
    p_to = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEd),
                             m_board.getRank(IRank.ChessboardRank.RANK5));
    expResult.clear();
    result = Slide.northWest(p_from, p_to,m_inb);    
    assertFalse(result);

    //Qd8-a5
    p_from = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEd),
                               m_board.getRank(IRank.ChessboardRank.RANK8));
    p_to = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEa),
                             m_board.getRank(IRank.ChessboardRank.RANK5));
    expResult.clear();
    result = Slide.northWest(p_from, p_to,m_inb);    
    assertFalse(result);    
  }

  /**
   * Test of southEast method, of class Slide.
   */
  @Test
  public void testSouthEast() 
  {
    
    System.out.println("southEast");
    
    //Qb7xg2
    ISquare p_from = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEb),
                                       m_board.getRank(IRank.ChessboardRank.RANK7));
    ISquare p_to = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEg),
                                       m_board.getRank(IRank.ChessboardRank.RANK2));
    ArrayList<ISquare> expResult = new ArrayList<>();
    expResult.add(m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEc),
                  m_board.getRank(IRank.ChessboardRank.RANK6)));
    expResult.add(m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEd),
                  m_board.getRank(IRank.ChessboardRank.RANK5)));
    expResult.add(m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEe),
                  m_board.getRank(IRank.ChessboardRank.RANK4)));
    expResult.add(m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEf),
                  m_board.getRank(IRank.ChessboardRank.RANK3)));
    
    boolean result = Slide.southEast(p_from, p_to,m_inb);
    assertTrue(result);
    assertArrayEquals(expResult.toArray(), m_inb.toArray());
    
    //e4xf3
    p_from = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEe),
                               m_board.getRank(IRank.ChessboardRank.RANK4));
    p_to = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEf),
                             m_board.getRank(IRank.ChessboardRank.RANK3));
    expResult.clear();
    result = Slide.southEast(p_from, p_to,m_inb);
    assertTrue(result);
    assertTrue(m_inb.isEmpty());    
    
    //Ba5-c3
    p_from = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEa),
                               m_board.getRank(IRank.ChessboardRank.RANK5));
    p_to = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEc),
                             m_board.getRank(IRank.ChessboardRank.RANK3));
    expResult.clear();
    expResult.add(m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEb),
                  m_board.getRank(IRank.ChessboardRank.RANK4)));
    result = Slide.southEast(p_from, p_to, m_inb);   
    assertTrue(result);
    assertArrayEquals(expResult.toArray(), m_inb.toArray());

    //Bc5-g1
    p_from = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEc),
                               m_board.getRank(IRank.ChessboardRank.RANK5));
    p_to = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEg),
                             m_board.getRank(IRank.ChessboardRank.RANK1));
    expResult.clear();
    expResult.add(m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEd),
                  m_board.getRank(IRank.ChessboardRank.RANK4)));
    expResult.add(m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEe),
                  m_board.getRank(IRank.ChessboardRank.RANK3)));    
    expResult.add(m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEf),
                  m_board.getRank(IRank.ChessboardRank.RANK2)));        
    result = Slide.southEast(p_from, p_to,m_inb);    
    assertTrue(result);
    assertArrayEquals(expResult.toArray(), m_inb.toArray());
    
    //Nc3-d1
    p_from = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEc),
                               m_board.getRank(IRank.ChessboardRank.RANK3));
    p_to = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEd),
                             m_board.getRank(IRank.ChessboardRank.RANK1));
    expResult.clear();
    result = Slide.southEast(p_from, p_to,m_inb);    
    assertFalse(result);

    //Qa5-d8
    p_from = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEa),
                               m_board.getRank(IRank.ChessboardRank.RANK5));
    p_to = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEd),
                             m_board.getRank(IRank.ChessboardRank.RANK8));
    expResult.clear();
    result = Slide.southEast(p_from, p_to,m_inb);    
    assertFalse(result);    
  }

  /**
   * Test of southWest method, of class Slide.
   */
  @Test
  public void testSouthWest() 
  {
    
    System.out.println("southWest");
    
    //Qg7xb2
    ISquare p_from = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEg),
                                       m_board.getRank(IRank.ChessboardRank.RANK7));
    ISquare p_to = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEb),
                                       m_board.getRank(IRank.ChessboardRank.RANK2));
    ArrayList<ISquare> expResult = new ArrayList<>();
    expResult.add(m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEf),
                  m_board.getRank(IRank.ChessboardRank.RANK6)));
    expResult.add(m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEe),
                  m_board.getRank(IRank.ChessboardRank.RANK5)));
    expResult.add(m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEd),
                  m_board.getRank(IRank.ChessboardRank.RANK4)));
    expResult.add(m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEc),
                  m_board.getRank(IRank.ChessboardRank.RANK3)));
    
    boolean result = Slide.southWest(p_from, p_to,m_inb);
    assertTrue(result);
    assertArrayEquals(expResult.toArray(), m_inb.toArray());
    
    //e4xd3
    p_from = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEe),
                               m_board.getRank(IRank.ChessboardRank.RANK4));
    p_to = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEd),
                             m_board.getRank(IRank.ChessboardRank.RANK3));
    expResult.clear();
    result = Slide.southWest(p_from, p_to,m_inb);
    assertTrue(result);
    assertTrue(m_inb.isEmpty());    
    
    //Bg6-e4
    p_from = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEg),
                               m_board.getRank(IRank.ChessboardRank.RANK6));
    p_to = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEe),
                             m_board.getRank(IRank.ChessboardRank.RANK4));
    expResult.clear();
    expResult.add(m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEf),
                  m_board.getRank(IRank.ChessboardRank.RANK5)));
    result = Slide.southWest(p_from, p_to, m_inb);   
    assertTrue(result);
    assertArrayEquals(expResult.toArray(), m_inb.toArray());

    //Bf4-c1
    p_from = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEf),
                               m_board.getRank(IRank.ChessboardRank.RANK4));
    p_to = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEc),
                             m_board.getRank(IRank.ChessboardRank.RANK1));
    expResult.clear();
    expResult.add(m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEe),
                  m_board.getRank(IRank.ChessboardRank.RANK3)));
    expResult.add(m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEd),
                  m_board.getRank(IRank.ChessboardRank.RANK2)));    
    result = Slide.southWest(p_from, p_to,m_inb);    
    assertTrue(result);
    assertArrayEquals(expResult.toArray(), m_inb.toArray());
    
    //Nc3-b1
    p_from = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEc),
                               m_board.getRank(IRank.ChessboardRank.RANK3));
    p_to = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEb),
                             m_board.getRank(IRank.ChessboardRank.RANK1));
    expResult.clear();
    result = Slide.southWest(p_from, p_to,m_inb);    
    assertFalse(result);

    //Qd8-g5
    p_from = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEd),
                               m_board.getRank(IRank.ChessboardRank.RANK8));
    p_to = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEg),
                             m_board.getRank(IRank.ChessboardRank.RANK5));
    expResult.clear();
    result = Slide.southWest(p_from, p_to,m_inb);    
    assertFalse(result);    
  }

  /**
   * Test of north method, of class Slide.
   */
  @Test
  public void testEast() 
  {
    
    System.out.println("East");
    
    //Qa5xg5
    ISquare p_from = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEa),
                                       m_board.getRank(IRank.ChessboardRank.RANK5));
    ISquare p_to = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEg),
                                       m_board.getRank(IRank.ChessboardRank.RANK5));
    ArrayList<ISquare> expResult = new ArrayList<>();
    expResult.add(m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEb),
                  m_board.getRank(IRank.ChessboardRank.RANK5)));
    expResult.add(m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEc),
                  m_board.getRank(IRank.ChessboardRank.RANK5)));
    expResult.add(m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEd),
                  m_board.getRank(IRank.ChessboardRank.RANK5)));
    expResult.add(m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEe),
                  m_board.getRank(IRank.ChessboardRank.RANK5)));
    expResult.add(m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEf),
                  m_board.getRank(IRank.ChessboardRank.RANK5)));
    
    boolean result = Slide.east(p_from, p_to,m_inb);
    assertTrue(result);
    assertArrayEquals(expResult.toArray(), m_inb.toArray());
    
    //Qc4-d4
    p_from = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEc),
                               m_board.getRank(IRank.ChessboardRank.RANK4));
    p_to = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEd),
                             m_board.getRank(IRank.ChessboardRank.RANK4));
    expResult.clear();
    
    result = Slide.east(p_from, p_to,m_inb);
    assertTrue(result);
    assertTrue(expResult.isEmpty());
    

    //Qe6-e6
    p_from = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEe),
                               m_board.getRank(IRank.ChessboardRank.RANK6));
    p_to = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEe),
                             m_board.getRank(IRank.ChessboardRank.RANK6));
    expResult.clear();
    
    result = Slide.east(p_from, p_to,m_inb);
    assertFalse(result);

    //0-0
    p_from = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEe),
                               m_board.getRank(IRank.ChessboardRank.RANK1));
    p_to = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEg),
                             m_board.getRank(IRank.ChessboardRank.RANK1));
    expResult.clear();
    expResult.add(m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEf),
                  m_board.getRank(IRank.ChessboardRank.RANK1)));
    
    result = Slide.east(p_from, p_to,m_inb);
    assertTrue(result);
    assertArrayEquals(expResult.toArray(), m_inb.toArray());
    
    //Qd2xd4
    p_from = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEd),
                               m_board.getRank(IRank.ChessboardRank.RANK2));
    p_to = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEd),
                             m_board.getRank(IRank.ChessboardRank.RANK4));
    expResult.clear();
    
    result = Slide.east(p_from, p_to,m_inb);
    assertFalse(result);

    //Qd2-g5
    p_from = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEd),
                               m_board.getRank(IRank.ChessboardRank.RANK2));
    p_to = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEg),
                             m_board.getRank(IRank.ChessboardRank.RANK5));
    expResult.clear();
    
    result = Slide.east(p_from, p_to,m_inb);
    assertFalse(result);

    //Qd2-e1
    p_from = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEd),
                               m_board.getRank(IRank.ChessboardRank.RANK2));
    p_to = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEe),
                             m_board.getRank(IRank.ChessboardRank.RANK1));
    expResult.clear();
    
    result = Slide.east(p_from, p_to,m_inb);
    assertFalse(result);
    
    //Qd2-d1
    p_from = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEd),
                               m_board.getRank(IRank.ChessboardRank.RANK2));
    p_to = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEd),
                             m_board.getRank(IRank.ChessboardRank.RANK1));
    expResult.clear();
    
    result = Slide.east(p_from, p_to,m_inb);
    assertFalse(result);

    //Qd2-c1
    p_from = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEd),
                               m_board.getRank(IRank.ChessboardRank.RANK2));
    p_to = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEc),
                             m_board.getRank(IRank.ChessboardRank.RANK1));
    expResult.clear();
    
    result = Slide.east(p_from, p_to,m_inb);
    assertFalse(result);

    //Qd2-a2
    p_from = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEd),
                               m_board.getRank(IRank.ChessboardRank.RANK2));
    p_to = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEa),
                             m_board.getRank(IRank.ChessboardRank.RANK2));
    expResult.clear();
    
    result = Slide.east(p_from, p_to,m_inb);
    assertFalse(result);

    //Qd2-b4
    p_from = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEd),
                               m_board.getRank(IRank.ChessboardRank.RANK2));
    p_to = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEb),
                             m_board.getRank(IRank.ChessboardRank.RANK4));
    expResult.clear();
    
    result = Slide.east(p_from, p_to,m_inb);
    assertFalse(result);    
  }

  /**
   * Test of north method, of class Slide.
   */
  @Test
  public void testWest() 
  {
    
    System.out.println("West");
    
    //Qh5xe5
    ISquare p_from = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEh),
                                       m_board.getRank(IRank.ChessboardRank.RANK5));
    ISquare p_to = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEe),
                                       m_board.getRank(IRank.ChessboardRank.RANK5));
    ArrayList<ISquare> expResult = new ArrayList<>();
    expResult.add(m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEg),
                  m_board.getRank(IRank.ChessboardRank.RANK5)));
    expResult.add(m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEf),
                  m_board.getRank(IRank.ChessboardRank.RANK5)));
    
    boolean result = Slide.west(p_from, p_to,m_inb);
    assertTrue(result);
    assertArrayEquals(expResult.toArray(), m_inb.toArray());
    
    //Qg4-f4
    p_from = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEg),
                               m_board.getRank(IRank.ChessboardRank.RANK4));
    p_to = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEf),
                             m_board.getRank(IRank.ChessboardRank.RANK4));
    expResult.clear();
    
    result = Slide.west(p_from, p_to,m_inb);
    assertTrue(result);
    assertTrue(expResult.isEmpty());
    

    //Qe6-e6
    p_from = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEe),
                               m_board.getRank(IRank.ChessboardRank.RANK6));
    p_to = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEe),
                             m_board.getRank(IRank.ChessboardRank.RANK6));
    expResult.clear();
    
    result = Slide.west(p_from, p_to,m_inb);
    assertFalse(result);

    //0-0-0
    p_from = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEe),
                               m_board.getRank(IRank.ChessboardRank.RANK8));
    p_to = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEc),
                             m_board.getRank(IRank.ChessboardRank.RANK8));
    expResult.clear();
    expResult.add(m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEd),
                  m_board.getRank(IRank.ChessboardRank.RANK8)));
    
    result = Slide.west(p_from, p_to,m_inb);
    assertTrue(result);
    assertArrayEquals(expResult.toArray(), m_inb.toArray());
    
    //Qd2xd4
    p_from = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEd),
                               m_board.getRank(IRank.ChessboardRank.RANK2));
    p_to = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEd),
                             m_board.getRank(IRank.ChessboardRank.RANK4));
    expResult.clear();
    
    result = Slide.west(p_from, p_to,m_inb);
    assertFalse(result);

    //Qd2-g5
    p_from = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEd),
                               m_board.getRank(IRank.ChessboardRank.RANK2));
    p_to = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEg),
                             m_board.getRank(IRank.ChessboardRank.RANK5));
    expResult.clear();
    
    result = Slide.west(p_from, p_to,m_inb);
    assertFalse(result);

    //Qd2-g2
    p_from = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEd),
                               m_board.getRank(IRank.ChessboardRank.RANK2));
    p_to = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEg),
                             m_board.getRank(IRank.ChessboardRank.RANK2));
    expResult.clear();
    
    result = Slide.west(p_from, p_to,m_inb);
    assertFalse(result);
    
    //Qd2-e1
    p_from = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEd),
                               m_board.getRank(IRank.ChessboardRank.RANK2));
    p_to = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEe),
                             m_board.getRank(IRank.ChessboardRank.RANK1));
    expResult.clear();
    
    result = Slide.west(p_from, p_to,m_inb);
    assertFalse(result);

    
    //Qd2-d1
    p_from = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEd),
                               m_board.getRank(IRank.ChessboardRank.RANK2));
    p_to = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEd),
                             m_board.getRank(IRank.ChessboardRank.RANK1));
    expResult.clear();
    
    result = Slide.west(p_from, p_to,m_inb);
    assertFalse(result);

    //Qd2-c1
    p_from = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEd),
                               m_board.getRank(IRank.ChessboardRank.RANK2));
    p_to = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEc),
                             m_board.getRank(IRank.ChessboardRank.RANK1));
    expResult.clear();
    
    result = Slide.west(p_from, p_to,m_inb);
    assertFalse(result);

    //Qd2-b4
    p_from = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEd),
                               m_board.getRank(IRank.ChessboardRank.RANK2));
    p_to = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEb),
                             m_board.getRank(IRank.ChessboardRank.RANK4));
    expResult.clear();
    
    result = Slide.west(p_from, p_to,m_inb);
    assertFalse(result);    
  }
  
}
