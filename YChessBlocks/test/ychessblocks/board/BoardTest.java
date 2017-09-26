/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ychessblocks.board;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import ychessblocks.board.IFile.ChessboardFile;
import ychessblocks.board.IRank.ChessboardRank;

import java.util.*;

/**
 *
 * @author Yair
 */
public class BoardTest 
{
  
  private EnumMap<IFile.ChessboardFile,String> m_file2NotationMap;    
  private EnumMap<IRank.ChessboardRank,String> m_rank2NotationMap;   
  private EnumMap<IColor.ChessColor,String> m_color2NameMap;
  
  private final IFile.ChessboardFile[] M_FILES_ID = {IFile.ChessboardFile.FILEa,
                                                     IFile.ChessboardFile.FILEb,
                                                     IFile.ChessboardFile.FILEc,
                                                     IFile.ChessboardFile.FILEd,
                                                     IFile.ChessboardFile.FILEe,
                                                     IFile.ChessboardFile.FILEf,
                                                     IFile.ChessboardFile.FILEg,
                                                     IFile.ChessboardFile.FILEh};
  
  private final IRank.ChessboardRank[] M_RANK_ID = {IRank.ChessboardRank.RANK1,
                                                    IRank.ChessboardRank.RANK2,
                                                    IRank.ChessboardRank.RANK3,
                                                    IRank.ChessboardRank.RANK4,
                                                    IRank.ChessboardRank.RANK5,
                                                    IRank.ChessboardRank.RANK6,
                                                    IRank.ChessboardRank.RANK7,
                                                    IRank.ChessboardRank.RANK8};
  
  
  public BoardTest() 
  {
    m_file2NotationMap = new EnumMap<>(IFile.ChessboardFile.class);
    m_rank2NotationMap = new EnumMap<>(IRank.ChessboardRank.class);
    m_color2NameMap = new EnumMap<>(IColor.ChessColor.class);
  }
  
  @BeforeClass
  public static void setUpClass()
  {
    
  }
  
  @AfterClass
  public static void tearDownClass() {
  }
  
  @Before
  public void setUp() 
  {
    m_file2NotationMap.put(ChessboardFile.FILEa, "a");
    m_file2NotationMap.put(ChessboardFile.FILEb, "b");
    m_file2NotationMap.put(ChessboardFile.FILEc, "c");
    m_file2NotationMap.put(ChessboardFile.FILEd, "d");
    m_file2NotationMap.put(ChessboardFile.FILEe, "e");
    m_file2NotationMap.put(ChessboardFile.FILEf, "f");
    m_file2NotationMap.put(ChessboardFile.FILEg, "g");
    m_file2NotationMap.put(ChessboardFile.FILEh, "h");
    
    m_rank2NotationMap.put(ChessboardRank.RANK1, "1");
    m_rank2NotationMap.put(ChessboardRank.RANK2, "2");
    m_rank2NotationMap.put(ChessboardRank.RANK3, "3");
    m_rank2NotationMap.put(ChessboardRank.RANK4, "4");
    m_rank2NotationMap.put(ChessboardRank.RANK5, "5");
    m_rank2NotationMap.put(ChessboardRank.RANK6, "6");
    m_rank2NotationMap.put(ChessboardRank.RANK7, "7");
    m_rank2NotationMap.put(ChessboardRank.RANK8, "8");    
    
    m_color2NameMap.put(ChessColor.getInstance().getWhite().getColor(), "W");    
    m_color2NameMap.put(ChessColor.getInstance().getBlack().getColor(), "B");    
  }
  
  @After
  public void tearDown() {
  }


  /**
   * Test of getFile method, of class Board.
   */
  @Test
  public void testGetFile() 
  {
    ChessboardFile expResult;
    IFile result;
    
    System.out.println("getFile");
    
    Board instance = Board.getInstance();
    
    for (ChessboardFile f: IFile.ChessboardFile.values())
    {
      expResult = f;
      result = instance.getFile(expResult);
      assertEquals(expResult, result.getVal());
    }
  }

  /**
   * Test of getRank method, of class Board.
   */
  @Test
  public void testGetRank()
  {
    ChessboardRank expResult;
    IRank result;
    
    System.out.println("getRank");

    Board instance = Board.getInstance();
    
    for (ChessboardRank r: ChessboardRank.values())
    {
      expResult = r;
      result = instance.getRank(expResult);
      assertEquals(expResult, result.getVal());
    }    
  }

  /**
   * Test of getSquare method, of class Board.
   */
  @Test
  public void testGetSquare()
  {
    String expResult;
    String result;
    
    System.out.println("getSquare");
    
    Board instance = Board.getInstance();    
    
    //Get black squares 1
    for (ChessboardRank r: ChessboardRank.values())
    {      
      if (r.equals(ChessboardRank.RANK2) ||
          r.equals(ChessboardRank.RANK4) ||
          r.equals(ChessboardRank.RANK6) ||
          r.equals(ChessboardRank.RANK8))
      {
        continue;
      }
      IRank rank = instance.getRank(r);
      
      for (ChessboardFile f: IFile.ChessboardFile.values())
      {
        if (f.equals(ChessboardFile.FILEb) ||
            f.equals(ChessboardFile.FILEd) ||
            f.equals(ChessboardFile.FILEf) ||
            f.equals(ChessboardFile.FILEh))
        {
          continue;
        }
        IFile file = instance.getFile(f);
        expResult = m_file2NotationMap.get(file.getVal()) + 
                    m_rank2NotationMap.get(rank.getVal()) +
                    "::B";
        
         ISquare sq = instance.getSquare(file, rank);
         result = m_file2NotationMap.get(sq.getFile().getVal()) + 
                  m_rank2NotationMap.get(sq.getRank().getVal()) +
                  "::" +
                  m_color2NameMap.get(sq.getColor().getColor());

         assertEquals(expResult, result);
      }
    }
    
    //Get black squares 2
    for (ChessboardRank r: ChessboardRank.values())
    {      
      if (r.equals(ChessboardRank.RANK1) ||
          r.equals(ChessboardRank.RANK3) ||
          r.equals(ChessboardRank.RANK5) ||
          r.equals(ChessboardRank.RANK7))
      {
        continue;
      }
      IRank rank = instance.getRank(r);
      
      for (ChessboardFile f: IFile.ChessboardFile.values())
      {
        if (f.equals(ChessboardFile.FILEa) ||
            f.equals(ChessboardFile.FILEc) ||
            f.equals(ChessboardFile.FILEe) ||
            f.equals(ChessboardFile.FILEg))
        {
          continue;
        }
        IFile file = instance.getFile(f);
        expResult = m_file2NotationMap.get(file.getVal()) + 
                    m_rank2NotationMap.get(rank.getVal()) +
                    "::B";
        
         ISquare sq = instance.getSquare(file, rank);
         result = m_file2NotationMap.get(sq.getFile().getVal()) + 
                  m_rank2NotationMap.get(sq.getRank().getVal()) +
                  "::" +
                  m_color2NameMap.get(sq.getColor().getColor());

         assertEquals(expResult, result);
      }
    }

    //Get white squares 1
    for (ChessboardRank r: ChessboardRank.values())
    {      
      if (r.equals(ChessboardRank.RANK2) ||
          r.equals(ChessboardRank.RANK4) ||
          r.equals(ChessboardRank.RANK6) ||
          r.equals(ChessboardRank.RANK8))
      {
        continue;
      }
      IRank rank = instance.getRank(r);
      
      for (ChessboardFile f: IFile.ChessboardFile.values())
      {
        if (f.equals(ChessboardFile.FILEa) ||
            f.equals(ChessboardFile.FILEc) ||
            f.equals(ChessboardFile.FILEe) ||
            f.equals(ChessboardFile.FILEg))
        {
          continue;
        }
        IFile file = instance.getFile(f);
        expResult = m_file2NotationMap.get(file.getVal()) + 
                    m_rank2NotationMap.get(rank.getVal()) +
                    "::W";
        
         ISquare sq = instance.getSquare(file, rank);
         
         IColor c = sq.getColor();
         
         result = m_file2NotationMap.get(sq.getFile().getVal()) + 
                  m_rank2NotationMap.get(sq.getRank().getVal()) +
                  "::" +
                  m_color2NameMap.get(sq.getColor().getColor());

         assertEquals(expResult, result);
      }
    }

    //Get white squares 
    for (ChessboardRank r: ChessboardRank.values())
    {      
      if (r.equals(ChessboardRank.RANK1) ||
          r.equals(ChessboardRank.RANK3) ||
          r.equals(ChessboardRank.RANK5) ||
          r.equals(ChessboardRank.RANK7))
      {
        continue;
      }
      IRank rank = instance.getRank(r);
      
      for (ChessboardFile f: IFile.ChessboardFile.values())
      {
        if (f.equals(ChessboardFile.FILEb) ||
            f.equals(ChessboardFile.FILEd) ||
            f.equals(ChessboardFile.FILEf) ||
            f.equals(ChessboardFile.FILEh))
        {
          continue;
        }
        IFile file = instance.getFile(f);
        expResult = m_file2NotationMap.get(file.getVal()) + 
                    m_rank2NotationMap.get(rank.getVal()) +
                    "::W";
        
         ISquare sq = instance.getSquare(file, rank);
         
         IColor c = sq.getColor();
         
         result = m_file2NotationMap.get(sq.getFile().getVal()) + 
                  m_rank2NotationMap.get(sq.getRank().getVal()) +
                  "::" +
                  m_color2NameMap.get(sq.getColor().getColor());

         assertEquals(expResult, result);
      }
    }
    
  }

  /**
   * Test of tryNorth method, of class Board.
   */
  @Test
  public void testTryNorth()
  {
    System.out.println("tryNorth");
    
    Board instance = Board.getInstance();
    
    //f1-f6 {N}
    ISquare p_from = instance.getSquare(instance.getFile(ChessboardFile.FILEf),
                                        instance.getRank(ChessboardRank.RANK1));
    ISquare p_to = instance.getSquare(instance.getFile(ChessboardFile.FILEf),
                                        instance.getRank(ChessboardRank.RANK6));
    boolean result = instance.tryNorth(p_from, p_to);
    assertTrue("f1-f6",result);
    
    //g4-g4 
    p_from = instance.getSquare(instance.getFile(ChessboardFile.FILEg),
                                instance.getRank(ChessboardRank.RANK4));
    p_to = instance.getSquare(instance.getFile(ChessboardFile.FILEg),
                              instance.getRank(ChessboardRank.RANK4));
    result = instance.tryNorth(p_from, p_to);
    assertFalse("g4-g4",result);
    
    //b4-c7
    p_from = instance.getSquare(instance.getFile(ChessboardFile.FILEb),
                                instance.getRank(ChessboardRank.RANK4));
    p_to = instance.getSquare(instance.getFile(ChessboardFile.FILEc),
                              instance.getRank(ChessboardRank.RANK7));
    result = instance.tryNorth(p_from, p_to);
    assertFalse("b4-c7",result);

    //e6-e3 {S}
    p_from = instance.getSquare(instance.getFile(ChessboardFile.FILEe),
                                instance.getRank(ChessboardRank.RANK6));
    p_to = instance.getSquare(instance.getFile(ChessboardFile.FILEe),
                              instance.getRank(ChessboardRank.RANK3));
    result = instance.tryNorth(p_from, p_to);
    assertFalse("e6-e3",result);

    //e6-h6 {E}
    p_from = instance.getSquare(instance.getFile(ChessboardFile.FILEe),
                                instance.getRank(ChessboardRank.RANK6));
    p_to = instance.getSquare(instance.getFile(ChessboardFile.FILEh),
                              instance.getRank(ChessboardRank.RANK6));
    result = instance.tryNorth(p_from, p_to);
    assertFalse("e6-h6",result);

    //e6-d6 {W}
    p_from = instance.getSquare(instance.getFile(ChessboardFile.FILEe),
                                instance.getRank(ChessboardRank.RANK6));
    p_to = instance.getSquare(instance.getFile(ChessboardFile.FILEd),
                              instance.getRank(ChessboardRank.RANK6));
    result = instance.tryNorth(p_from, p_to);
    assertFalse("e6-d6",result);

    //e6-g8 {NE}
    p_from = instance.getSquare(instance.getFile(ChessboardFile.FILEe),
                                instance.getRank(ChessboardRank.RANK6));
    p_to = instance.getSquare(instance.getFile(ChessboardFile.FILEg),
                              instance.getRank(ChessboardRank.RANK8));
    result = instance.tryNorth(p_from, p_to);
    assertFalse("e6-g8",result);

    //e6-d7 {NW}
    p_from = instance.getSquare(instance.getFile(ChessboardFile.FILEe),
                                instance.getRank(ChessboardRank.RANK6));
    p_to = instance.getSquare(instance.getFile(ChessboardFile.FILEd),
                              instance.getRank(ChessboardRank.RANK7));
    result = instance.tryNorth(p_from, p_to);
    assertFalse("e6-d7",result);

    //e6-h3 {SE}
    p_from = instance.getSquare(instance.getFile(ChessboardFile.FILEe),
                                instance.getRank(ChessboardRank.RANK6));
    p_to = instance.getSquare(instance.getFile(ChessboardFile.FILEh),
                              instance.getRank(ChessboardRank.RANK3));
    result = instance.tryNorth(p_from, p_to);
    assertFalse("e6-h3",result);

    //e6-c4 {SW}
    p_from = instance.getSquare(instance.getFile(ChessboardFile.FILEe),
                                instance.getRank(ChessboardRank.RANK6));
    p_to = instance.getSquare(instance.getFile(ChessboardFile.FILEc),
                              instance.getRank(ChessboardRank.RANK4));
    result = instance.tryNorth(p_from, p_to);
    assertFalse("e6-h3",result);   
  }

  /**
   * Test of tryNorthEast method, of class Board.
   */
  @Test
  public void testTryNorthEast() 
  {
    System.out.println("tryNorthEast");
    
    Board instance = Board.getInstance();
    
    //f1-f6 {N}
    ISquare p_from = instance.getSquare(instance.getFile(ChessboardFile.FILEf),
                                        instance.getRank(ChessboardRank.RANK1));
    ISquare p_to = instance.getSquare(instance.getFile(ChessboardFile.FILEf),
                                        instance.getRank(ChessboardRank.RANK6));
    boolean result = instance.tryNorthEast(p_from, p_to);
    assertFalse("f1-f6",result);
    
    //g4-g4 
    p_from = instance.getSquare(instance.getFile(ChessboardFile.FILEg),
                                instance.getRank(ChessboardRank.RANK4));
    p_to = instance.getSquare(instance.getFile(ChessboardFile.FILEg),
                              instance.getRank(ChessboardRank.RANK4));
    result = instance.tryNorthEast(p_from, p_to);
    assertFalse("g4-g4",result);
    
    //b4-c7
    p_from = instance.getSquare(instance.getFile(ChessboardFile.FILEb),
                                instance.getRank(ChessboardRank.RANK4));
    p_to = instance.getSquare(instance.getFile(ChessboardFile.FILEc),
                              instance.getRank(ChessboardRank.RANK7));
    result = instance.tryNorthEast(p_from, p_to);
    assertFalse("b4-c7",result);

    //e6-e3 {S}
    p_from = instance.getSquare(instance.getFile(ChessboardFile.FILEe),
                                instance.getRank(ChessboardRank.RANK6));
    p_to = instance.getSquare(instance.getFile(ChessboardFile.FILEe),
                              instance.getRank(ChessboardRank.RANK3));
    result = instance.tryNorthEast(p_from, p_to);
    assertFalse("e6-e3",result);

    //e6-h6 {E}
    p_from = instance.getSquare(instance.getFile(ChessboardFile.FILEe),
                                instance.getRank(ChessboardRank.RANK6));
    p_to = instance.getSquare(instance.getFile(ChessboardFile.FILEh),
                              instance.getRank(ChessboardRank.RANK6));
    result = instance.tryNorthEast(p_from, p_to);
    assertFalse("e6-h6",result);

    //e6-d6 {W}
    p_from = instance.getSquare(instance.getFile(ChessboardFile.FILEe),
                                instance.getRank(ChessboardRank.RANK6));
    p_to = instance.getSquare(instance.getFile(ChessboardFile.FILEd),
                              instance.getRank(ChessboardRank.RANK6));
    result = instance.tryNorthEast(p_from, p_to);
    assertFalse("e6-d6",result);

    //e6-g8 {NE}
    p_from = instance.getSquare(instance.getFile(ChessboardFile.FILEe),
                                instance.getRank(ChessboardRank.RANK6));
    p_to = instance.getSquare(instance.getFile(ChessboardFile.FILEg),
                              instance.getRank(ChessboardRank.RANK8));
    result = instance.tryNorthEast(p_from, p_to);
    assertTrue("e6-g8",result);

    //e6-d7 {NW}
    p_from = instance.getSquare(instance.getFile(ChessboardFile.FILEe),
                                instance.getRank(ChessboardRank.RANK6));
    p_to = instance.getSquare(instance.getFile(ChessboardFile.FILEd),
                              instance.getRank(ChessboardRank.RANK7));
    result = instance.tryNorthEast(p_from, p_to);
    assertFalse("e6-d7",result);

    //e6-h3 {SE}
    p_from = instance.getSquare(instance.getFile(ChessboardFile.FILEe),
                                instance.getRank(ChessboardRank.RANK6));
    p_to = instance.getSquare(instance.getFile(ChessboardFile.FILEh),
                              instance.getRank(ChessboardRank.RANK3));
    result = instance.tryNorthEast(p_from, p_to);
    assertFalse("e6-h3",result);

    //e6-c4 {SW}
    p_from = instance.getSquare(instance.getFile(ChessboardFile.FILEe),
                                instance.getRank(ChessboardRank.RANK6));
    p_to = instance.getSquare(instance.getFile(ChessboardFile.FILEc),
                              instance.getRank(ChessboardRank.RANK4));
    result = instance.tryNorthEast(p_from, p_to);
    assertFalse("e6-h3",result);
  }

  /**
   * Test of tryEast method, of class Board.
   */
  @Test
  public void testTryEast() 
  {
    System.out.println("tryEast");
    
    Board instance = Board.getInstance();
    
    //f1-f6 {N}
    ISquare p_from = instance.getSquare(instance.getFile(ChessboardFile.FILEf),
                                        instance.getRank(ChessboardRank.RANK1));
    ISquare p_to = instance.getSquare(instance.getFile(ChessboardFile.FILEf),
                                        instance.getRank(ChessboardRank.RANK6));
    boolean result = instance.tryEast(p_from, p_to);
    assertFalse("f1-f6",result);
    
    //g4-g4 
    p_from = instance.getSquare(instance.getFile(ChessboardFile.FILEg),
                                instance.getRank(ChessboardRank.RANK4));
    p_to = instance.getSquare(instance.getFile(ChessboardFile.FILEg),
                              instance.getRank(ChessboardRank.RANK4));
    result = instance.tryEast(p_from, p_to);
    assertFalse("g4-g4",result);
    
    //b4-c7
    p_from = instance.getSquare(instance.getFile(ChessboardFile.FILEb),
                                instance.getRank(ChessboardRank.RANK4));
    p_to = instance.getSquare(instance.getFile(ChessboardFile.FILEc),
                              instance.getRank(ChessboardRank.RANK7));
    result = instance.tryEast(p_from, p_to);
    assertFalse("b4-c7",result);

    //e6-e3 {S}
    p_from = instance.getSquare(instance.getFile(ChessboardFile.FILEe),
                                instance.getRank(ChessboardRank.RANK6));
    p_to = instance.getSquare(instance.getFile(ChessboardFile.FILEe),
                              instance.getRank(ChessboardRank.RANK3));
    result = instance.tryEast(p_from, p_to);
    assertFalse("e6-e3",result);

    //e6-h6 {E}
    p_from = instance.getSquare(instance.getFile(ChessboardFile.FILEe),
                                instance.getRank(ChessboardRank.RANK6));
    p_to = instance.getSquare(instance.getFile(ChessboardFile.FILEh),
                              instance.getRank(ChessboardRank.RANK6));
    result = instance.tryEast(p_from, p_to);
    assertTrue("e6-h6",result);

    //e6-d6 {W}
    p_from = instance.getSquare(instance.getFile(ChessboardFile.FILEe),
                                instance.getRank(ChessboardRank.RANK6));
    p_to = instance.getSquare(instance.getFile(ChessboardFile.FILEd),
                              instance.getRank(ChessboardRank.RANK6));
    result = instance.tryEast(p_from, p_to);
    assertFalse("e6-d6",result);

    //e6-g8 {NE}
    p_from = instance.getSquare(instance.getFile(ChessboardFile.FILEe),
                                instance.getRank(ChessboardRank.RANK6));
    p_to = instance.getSquare(instance.getFile(ChessboardFile.FILEg),
                              instance.getRank(ChessboardRank.RANK8));
    result = instance.tryEast(p_from, p_to);
    assertFalse("e6-g8",result);

    //e6-d7 {NW}
    p_from = instance.getSquare(instance.getFile(ChessboardFile.FILEe),
                                instance.getRank(ChessboardRank.RANK6));
    p_to = instance.getSquare(instance.getFile(ChessboardFile.FILEd),
                              instance.getRank(ChessboardRank.RANK7));
    result = instance.tryEast(p_from, p_to);
    assertFalse("e6-d7",result);

    //e6-h3 {SE}
    p_from = instance.getSquare(instance.getFile(ChessboardFile.FILEe),
                                instance.getRank(ChessboardRank.RANK6));
    p_to = instance.getSquare(instance.getFile(ChessboardFile.FILEh),
                              instance.getRank(ChessboardRank.RANK3));
    result = instance.tryEast(p_from, p_to);
    assertFalse("e6-h3",result);

    //e6-c4 {SW}
    p_from = instance.getSquare(instance.getFile(ChessboardFile.FILEe),
                                instance.getRank(ChessboardRank.RANK6));
    p_to = instance.getSquare(instance.getFile(ChessboardFile.FILEc),
                              instance.getRank(ChessboardRank.RANK4));
    result = instance.tryEast(p_from, p_to);
    assertFalse("e6-h3",result);
  }

  /**
   * Test of trySouthEast method, of class Board.
   */
  @Test
  public void testTrySouthEast() 
  {
    System.out.println("trySouthEast");
    
    Board instance = Board.getInstance();
    
    //f1-f6 {N}
    ISquare p_from = instance.getSquare(instance.getFile(ChessboardFile.FILEf),
                                        instance.getRank(ChessboardRank.RANK1));
    ISquare p_to = instance.getSquare(instance.getFile(ChessboardFile.FILEf),
                                        instance.getRank(ChessboardRank.RANK6));
    boolean result = instance.trySouthEast(p_from, p_to);
    assertFalse("f1-f6",result);
    
    //g4-g4 
    p_from = instance.getSquare(instance.getFile(ChessboardFile.FILEg),
                                instance.getRank(ChessboardRank.RANK4));
    p_to = instance.getSquare(instance.getFile(ChessboardFile.FILEg),
                              instance.getRank(ChessboardRank.RANK4));
    result = instance.trySouthEast(p_from, p_to);
    assertFalse("g4-g4",result);
    
    //b4-e2
    p_from = instance.getSquare(instance.getFile(ChessboardFile.FILEb),
                                instance.getRank(ChessboardRank.RANK4));
    p_to = instance.getSquare(instance.getFile(ChessboardFile.FILEe),
                              instance.getRank(ChessboardRank.RANK2));
    result = instance.trySouthEast(p_from, p_to);
    assertFalse("b4-e2",result);

    //e6-e3 {S}
    p_from = instance.getSquare(instance.getFile(ChessboardFile.FILEe),
                                instance.getRank(ChessboardRank.RANK6));
    p_to = instance.getSquare(instance.getFile(ChessboardFile.FILEe),
                              instance.getRank(ChessboardRank.RANK3));
    result = instance.trySouthEast(p_from, p_to);
    assertFalse("e6-e3",result);

    //e6-h6 {E}
    p_from = instance.getSquare(instance.getFile(ChessboardFile.FILEe),
                                instance.getRank(ChessboardRank.RANK6));
    p_to = instance.getSquare(instance.getFile(ChessboardFile.FILEh),
                              instance.getRank(ChessboardRank.RANK6));
    result = instance.trySouthEast(p_from, p_to);
    assertFalse("e6-h6",result);

    //e6-d6 {W}
    p_from = instance.getSquare(instance.getFile(ChessboardFile.FILEe),
                                instance.getRank(ChessboardRank.RANK6));
    p_to = instance.getSquare(instance.getFile(ChessboardFile.FILEd),
                              instance.getRank(ChessboardRank.RANK6));
    result = instance.trySouthEast(p_from, p_to);
    assertFalse("e6-d6",result);

    //e6-g8 {NE}
    p_from = instance.getSquare(instance.getFile(ChessboardFile.FILEe),
                                instance.getRank(ChessboardRank.RANK6));
    p_to = instance.getSquare(instance.getFile(ChessboardFile.FILEg),
                              instance.getRank(ChessboardRank.RANK8));
    result = instance.trySouthEast(p_from, p_to);
    assertFalse("e6-g8",result);

    //e6-d7 {NW}
    p_from = instance.getSquare(instance.getFile(ChessboardFile.FILEe),
                                instance.getRank(ChessboardRank.RANK6));
    p_to = instance.getSquare(instance.getFile(ChessboardFile.FILEd),
                              instance.getRank(ChessboardRank.RANK7));
    result = instance.trySouthEast(p_from, p_to);
    assertFalse("e6-d7",result);

    //e6-h3 {SE}
    p_from = instance.getSquare(instance.getFile(ChessboardFile.FILEe),
                                instance.getRank(ChessboardRank.RANK6));
    p_to = instance.getSquare(instance.getFile(ChessboardFile.FILEh),
                              instance.getRank(ChessboardRank.RANK3));
    result = instance.trySouthEast(p_from, p_to);
    assertTrue("e6-h3",result);

    //e6-c4 {SW}
    p_from = instance.getSquare(instance.getFile(ChessboardFile.FILEe),
                                instance.getRank(ChessboardRank.RANK6));
    p_to = instance.getSquare(instance.getFile(ChessboardFile.FILEc),
                              instance.getRank(ChessboardRank.RANK4));
    result = instance.trySouthEast(p_from, p_to);
    assertFalse("e6-h3",result);
  }

  /**
   * Test of trySouth method, of class Board.
   */
  @Test
  public void testTrySouth() 
  {
    System.out.println("trySouth");
    
    Board instance = Board.getInstance();
    
    //f1-f6 {N}
    ISquare p_from = instance.getSquare(instance.getFile(ChessboardFile.FILEf),
                                        instance.getRank(ChessboardRank.RANK1));
    ISquare p_to = instance.getSquare(instance.getFile(ChessboardFile.FILEf),
                                        instance.getRank(ChessboardRank.RANK6));
    boolean result = instance.trySouth(p_from, p_to);
    assertFalse("f1-f6",result);
    
    //g4-g4 
    p_from = instance.getSquare(instance.getFile(ChessboardFile.FILEg),
                                instance.getRank(ChessboardRank.RANK4));
    p_to = instance.getSquare(instance.getFile(ChessboardFile.FILEg),
                              instance.getRank(ChessboardRank.RANK4));
    result = instance.trySouth(p_from, p_to);
    assertFalse("g4-g4",result);
    
    //b4-e2
    p_from = instance.getSquare(instance.getFile(ChessboardFile.FILEb),
                                instance.getRank(ChessboardRank.RANK4));
    p_to = instance.getSquare(instance.getFile(ChessboardFile.FILEe),
                              instance.getRank(ChessboardRank.RANK2));
    result = instance.trySouth(p_from, p_to);
    assertFalse("b4-e2",result);

    //e6-e3 {S}
    p_from = instance.getSquare(instance.getFile(ChessboardFile.FILEe),
                                instance.getRank(ChessboardRank.RANK6));
    p_to = instance.getSquare(instance.getFile(ChessboardFile.FILEe),
                              instance.getRank(ChessboardRank.RANK3));
    result = instance.trySouth(p_from, p_to);
    assertTrue("e6-e3",result);

    //e6-h6 {E}
    p_from = instance.getSquare(instance.getFile(ChessboardFile.FILEe),
                                instance.getRank(ChessboardRank.RANK6));
    p_to = instance.getSquare(instance.getFile(ChessboardFile.FILEh),
                              instance.getRank(ChessboardRank.RANK6));
    result = instance.trySouth(p_from, p_to);
    assertFalse("e6-h6",result);

    //e6-d6 {W}
    p_from = instance.getSquare(instance.getFile(ChessboardFile.FILEe),
                                instance.getRank(ChessboardRank.RANK6));
    p_to = instance.getSquare(instance.getFile(ChessboardFile.FILEd),
                              instance.getRank(ChessboardRank.RANK6));
    result = instance.trySouth(p_from, p_to);
    assertFalse("e6-d6",result);

    //e6-g8 {NE}
    p_from = instance.getSquare(instance.getFile(ChessboardFile.FILEe),
                                instance.getRank(ChessboardRank.RANK6));
    p_to = instance.getSquare(instance.getFile(ChessboardFile.FILEg),
                              instance.getRank(ChessboardRank.RANK8));
    result = instance.trySouth(p_from, p_to);
    assertFalse("e6-g8",result);

    //e6-d7 {NW}
    p_from = instance.getSquare(instance.getFile(ChessboardFile.FILEe),
                                instance.getRank(ChessboardRank.RANK6));
    p_to = instance.getSquare(instance.getFile(ChessboardFile.FILEd),
                              instance.getRank(ChessboardRank.RANK7));
    result = instance.trySouth(p_from, p_to);
    assertFalse("e6-d7",result);

    //e6-h3 {SE}
    p_from = instance.getSquare(instance.getFile(ChessboardFile.FILEe),
                                instance.getRank(ChessboardRank.RANK6));
    p_to = instance.getSquare(instance.getFile(ChessboardFile.FILEh),
                              instance.getRank(ChessboardRank.RANK3));
    result = instance.trySouth(p_from, p_to);
    assertFalse("e6-h3",result);

    //e6-c4 {SW}
    p_from = instance.getSquare(instance.getFile(ChessboardFile.FILEe),
                                instance.getRank(ChessboardRank.RANK6));
    p_to = instance.getSquare(instance.getFile(ChessboardFile.FILEc),
                              instance.getRank(ChessboardRank.RANK4));
    result = instance.trySouth(p_from, p_to);
    assertFalse("e6-c4",result);
  }

  /**
   * Test of trySouthWest method, of class Board.
   */
  @Test
  public void testTrySouthWest() 
  {
    System.out.println("trySouthWest");
    
    Board instance = Board.getInstance();
    
    //f1-f6 {N}
    ISquare p_from = instance.getSquare(instance.getFile(ChessboardFile.FILEf),
                                        instance.getRank(ChessboardRank.RANK1));
    ISquare p_to = instance.getSquare(instance.getFile(ChessboardFile.FILEf),
                                        instance.getRank(ChessboardRank.RANK6));
    boolean result = instance.trySouthWest(p_from, p_to);
    assertFalse("f1-f6",result);
    
    //g4-g4 
    p_from = instance.getSquare(instance.getFile(ChessboardFile.FILEg),
                                instance.getRank(ChessboardRank.RANK4));
    p_to = instance.getSquare(instance.getFile(ChessboardFile.FILEg),
                              instance.getRank(ChessboardRank.RANK4));
    result = instance.trySouthWest(p_from, p_to);
    assertFalse("g4-g4",result);
    
    //b4-a2
    p_from = instance.getSquare(instance.getFile(ChessboardFile.FILEb),
                                instance.getRank(ChessboardRank.RANK4));
    p_to = instance.getSquare(instance.getFile(ChessboardFile.FILEa),
                              instance.getRank(ChessboardRank.RANK2));
    result = instance.trySouthWest(p_from, p_to);
    assertFalse("b4-a2",result);

    //e6-e3 {S}
    p_from = instance.getSquare(instance.getFile(ChessboardFile.FILEe),
                                instance.getRank(ChessboardRank.RANK6));
    p_to = instance.getSquare(instance.getFile(ChessboardFile.FILEe),
                              instance.getRank(ChessboardRank.RANK3));
    result = instance.trySouthWest(p_from, p_to);
    assertFalse("e6-e3",result);

    //e6-h6 {E}
    p_from = instance.getSquare(instance.getFile(ChessboardFile.FILEe),
                                instance.getRank(ChessboardRank.RANK6));
    p_to = instance.getSquare(instance.getFile(ChessboardFile.FILEh),
                              instance.getRank(ChessboardRank.RANK6));
    result = instance.trySouthWest(p_from, p_to);
    assertFalse("e6-h6",result);

    //e6-d6 {W}
    p_from = instance.getSquare(instance.getFile(ChessboardFile.FILEe),
                                instance.getRank(ChessboardRank.RANK6));
    p_to = instance.getSquare(instance.getFile(ChessboardFile.FILEd),
                              instance.getRank(ChessboardRank.RANK6));
    result = instance.trySouthWest(p_from, p_to);
    assertFalse("e6-d6",result);

    //e6-g8 {NE}
    p_from = instance.getSquare(instance.getFile(ChessboardFile.FILEe),
                                instance.getRank(ChessboardRank.RANK6));
    p_to = instance.getSquare(instance.getFile(ChessboardFile.FILEg),
                              instance.getRank(ChessboardRank.RANK8));
    result = instance.trySouthWest(p_from, p_to);
    assertFalse("e6-g8",result);

    //e6-d7 {NW}
    p_from = instance.getSquare(instance.getFile(ChessboardFile.FILEe),
                                instance.getRank(ChessboardRank.RANK6));
    p_to = instance.getSquare(instance.getFile(ChessboardFile.FILEd),
                              instance.getRank(ChessboardRank.RANK7));
    result = instance.trySouthWest(p_from, p_to);
    assertFalse("e6-d7",result);

    //e6-h3 {SE}
    p_from = instance.getSquare(instance.getFile(ChessboardFile.FILEe),
                                instance.getRank(ChessboardRank.RANK6));
    p_to = instance.getSquare(instance.getFile(ChessboardFile.FILEh),
                              instance.getRank(ChessboardRank.RANK3));
    result = instance.trySouthWest(p_from, p_to);
    assertFalse("e6-h3",result);

    //e6-c4 {SW}
    p_from = instance.getSquare(instance.getFile(ChessboardFile.FILEe),
                                instance.getRank(ChessboardRank.RANK6));
    p_to = instance.getSquare(instance.getFile(ChessboardFile.FILEc),
                              instance.getRank(ChessboardRank.RANK4));
    result = instance.trySouthWest(p_from, p_to);
    assertTrue("e6-c4",result);
  }

  /**
   * Test of tryWest method, of class Board.
   */
  @Test
  public void testTryWest() 
  {
    System.out.println("tryWest");
    
    Board instance = Board.getInstance();
    
    //f1-f6 {N}
    ISquare p_from = instance.getSquare(instance.getFile(ChessboardFile.FILEf),
                                        instance.getRank(ChessboardRank.RANK1));
    ISquare p_to = instance.getSquare(instance.getFile(ChessboardFile.FILEf),
                                        instance.getRank(ChessboardRank.RANK6));
    boolean result = instance.tryWest(p_from, p_to);
    assertFalse("f1-f6",result);
    
    //g4-g4 
    p_from = instance.getSquare(instance.getFile(ChessboardFile.FILEg),
                                instance.getRank(ChessboardRank.RANK4));
    p_to = instance.getSquare(instance.getFile(ChessboardFile.FILEg),
                              instance.getRank(ChessboardRank.RANK4));
    result = instance.tryWest(p_from, p_to);
    assertFalse("g4-g4",result);
    
    //b4-a2
    p_from = instance.getSquare(instance.getFile(ChessboardFile.FILEb),
                                instance.getRank(ChessboardRank.RANK4));
    p_to = instance.getSquare(instance.getFile(ChessboardFile.FILEa),
                              instance.getRank(ChessboardRank.RANK2));
    result = instance.tryWest(p_from, p_to);
    assertFalse("b4-a2",result);

    //e6-e3 {S}
    p_from = instance.getSquare(instance.getFile(ChessboardFile.FILEe),
                                instance.getRank(ChessboardRank.RANK6));
    p_to = instance.getSquare(instance.getFile(ChessboardFile.FILEe),
                              instance.getRank(ChessboardRank.RANK3));
    result = instance.tryWest(p_from, p_to);
    assertFalse("e6-e3",result);

    //e6-h6 {E}
    p_from = instance.getSquare(instance.getFile(ChessboardFile.FILEe),
                                instance.getRank(ChessboardRank.RANK6));
    p_to = instance.getSquare(instance.getFile(ChessboardFile.FILEh),
                              instance.getRank(ChessboardRank.RANK6));
    result = instance.tryWest(p_from, p_to);
    assertFalse("e6-h6",result);

    //e6-d6 {W}
    p_from = instance.getSquare(instance.getFile(ChessboardFile.FILEe),
                                instance.getRank(ChessboardRank.RANK6));
    p_to = instance.getSquare(instance.getFile(ChessboardFile.FILEd),
                              instance.getRank(ChessboardRank.RANK6));
    result = instance.tryWest(p_from, p_to);
    assertTrue("e6-d6",result);

    //e6-g8 {NE}
    p_from = instance.getSquare(instance.getFile(ChessboardFile.FILEe),
                                instance.getRank(ChessboardRank.RANK6));
    p_to = instance.getSquare(instance.getFile(ChessboardFile.FILEg),
                              instance.getRank(ChessboardRank.RANK8));
    result = instance.tryWest(p_from, p_to);
    assertFalse("e6-g8",result);

    //e6-d7 {NW}
    p_from = instance.getSquare(instance.getFile(ChessboardFile.FILEe),
                                instance.getRank(ChessboardRank.RANK6));
    p_to = instance.getSquare(instance.getFile(ChessboardFile.FILEd),
                              instance.getRank(ChessboardRank.RANK7));
    result = instance.tryWest(p_from, p_to);
    assertFalse("e6-d7",result);

    //e6-h3 {SE}
    p_from = instance.getSquare(instance.getFile(ChessboardFile.FILEe),
                                instance.getRank(ChessboardRank.RANK6));
    p_to = instance.getSquare(instance.getFile(ChessboardFile.FILEh),
                              instance.getRank(ChessboardRank.RANK3));
    result = instance.tryWest(p_from, p_to);
    assertFalse("e6-h3",result);

    //e6-c4 {SW}
    p_from = instance.getSquare(instance.getFile(ChessboardFile.FILEe),
                                instance.getRank(ChessboardRank.RANK6));
    p_to = instance.getSquare(instance.getFile(ChessboardFile.FILEc),
                              instance.getRank(ChessboardRank.RANK4));
    result = instance.tryWest(p_from, p_to);
    assertFalse("e6-c4",result);
  }

  /**
   * Test of tryNorthWest method, of class Board.
   */
  @Test
  public void testTryNorthWest() 
  {
    System.out.println("tryNorthWest");
    
    Board instance = Board.getInstance();
    
    //f1-f6 {N}
    ISquare p_from = instance.getSquare(instance.getFile(ChessboardFile.FILEf),
                                        instance.getRank(ChessboardRank.RANK1));
    ISquare p_to = instance.getSquare(instance.getFile(ChessboardFile.FILEf),
                                        instance.getRank(ChessboardRank.RANK6));
    boolean result = instance.tryNorthWest(p_from, p_to);
    assertFalse("f1-f6",result);
    
    //g4-g4 
    p_from = instance.getSquare(instance.getFile(ChessboardFile.FILEg),
                                instance.getRank(ChessboardRank.RANK4));
    p_to = instance.getSquare(instance.getFile(ChessboardFile.FILEg),
                              instance.getRank(ChessboardRank.RANK4));
    result = instance.tryNorthWest(p_from, p_to);
    assertFalse("g4-g4",result);
    
    //b4-a7
    p_from = instance.getSquare(instance.getFile(ChessboardFile.FILEb),
                                instance.getRank(ChessboardRank.RANK4));
    p_to = instance.getSquare(instance.getFile(ChessboardFile.FILEa),
                              instance.getRank(ChessboardRank.RANK2));
    result = instance.tryNorthWest(p_from, p_to);
    assertFalse("b4-a7",result);

    //e6-e3 {S}
    p_from = instance.getSquare(instance.getFile(ChessboardFile.FILEe),
                                instance.getRank(ChessboardRank.RANK6));
    p_to = instance.getSquare(instance.getFile(ChessboardFile.FILEe),
                              instance.getRank(ChessboardRank.RANK3));
    result = instance.tryNorthWest(p_from, p_to);
    assertFalse("e6-e3",result);

    //e6-h6 {E}
    p_from = instance.getSquare(instance.getFile(ChessboardFile.FILEe),
                                instance.getRank(ChessboardRank.RANK6));
    p_to = instance.getSquare(instance.getFile(ChessboardFile.FILEh),
                              instance.getRank(ChessboardRank.RANK6));
    result = instance.tryNorthWest(p_from, p_to);
    assertFalse("e6-h6",result);

    //e6-d6 {W}
    p_from = instance.getSquare(instance.getFile(ChessboardFile.FILEe),
                                instance.getRank(ChessboardRank.RANK6));
    p_to = instance.getSquare(instance.getFile(ChessboardFile.FILEd),
                              instance.getRank(ChessboardRank.RANK6));
    result = instance.tryNorthWest(p_from, p_to);
    assertFalse("e6-d6",result);

    //e6-g8 {NE}
    p_from = instance.getSquare(instance.getFile(ChessboardFile.FILEe),
                                instance.getRank(ChessboardRank.RANK6));
    p_to = instance.getSquare(instance.getFile(ChessboardFile.FILEg),
                              instance.getRank(ChessboardRank.RANK8));
    result = instance.tryNorthWest(p_from, p_to);
    assertFalse("e6-g8",result);

    //e6-d7 {NW}
    p_from = instance.getSquare(instance.getFile(ChessboardFile.FILEe),
                                instance.getRank(ChessboardRank.RANK6));
    p_to = instance.getSquare(instance.getFile(ChessboardFile.FILEd),
                              instance.getRank(ChessboardRank.RANK7));
    result = instance.tryNorthWest(p_from, p_to);
    assertTrue("e6-d7",result);

    //e6-h3 {SE}
    p_from = instance.getSquare(instance.getFile(ChessboardFile.FILEe),
                                instance.getRank(ChessboardRank.RANK6));
    p_to = instance.getSquare(instance.getFile(ChessboardFile.FILEh),
                              instance.getRank(ChessboardRank.RANK3));
    result = instance.tryNorthWest(p_from, p_to);
    assertFalse("e6-h3",result);

    //e6-c4 {SW}
    p_from = instance.getSquare(instance.getFile(ChessboardFile.FILEe),
                                instance.getRank(ChessboardRank.RANK6));
    p_to = instance.getSquare(instance.getFile(ChessboardFile.FILEc),
                              instance.getRank(ChessboardRank.RANK4));
    result = instance.tryNorthWest(p_from, p_to);
    assertFalse("e6-c4",result);
  }

  /**
   * Test of decFile method, of class Board.
   */
  @Test (expected=IndexOutOfBoundsException.class)
  public void testdecFile() 
  {
    System.out.println("decFile");

    Board instance = Board.getInstance();
    
    IFile currFile = instance.getFile(ChessboardFile.FILEa);
    instance.decFile(currFile);

    currFile = instance.getFile(ChessboardFile.FILEb);
    IFile expResult = instance.getFile(ChessboardFile.FILEa);
    IFile result = instance.decFile(currFile);
    assertEquals(expResult, result);

    currFile = instance.getFile(ChessboardFile.FILEc);
    expResult = instance.getFile(ChessboardFile.FILEb);
    result = instance.decFile(currFile);
    assertEquals(expResult, result);

    currFile = instance.getFile(ChessboardFile.FILEd);
    expResult = instance.getFile(ChessboardFile.FILEc);
    result = instance.decFile(currFile);
    assertEquals(expResult, result);

    currFile = instance.getFile(ChessboardFile.FILEe);
    expResult = instance.getFile(ChessboardFile.FILEd);
    result = instance.decFile(currFile);
    assertEquals(expResult, result);

    currFile = instance.getFile(ChessboardFile.FILEf);
    expResult = instance.getFile(ChessboardFile.FILEe);
    result = instance.decFile(currFile);
    assertEquals(expResult, result);

    currFile = instance.getFile(ChessboardFile.FILEg);
    expResult = instance.getFile(ChessboardFile.FILEf);
    result = instance.decFile(currFile);
    assertEquals(expResult, result);

    currFile = instance.getFile(ChessboardFile.FILEh);
    expResult = instance.getFile(ChessboardFile.FILEg);
    result = instance.decFile(currFile);
    assertEquals(expResult, result);
  }

   /**
   * Test of decRank method, of class Board.
   */
  @Test (expected=IndexOutOfBoundsException.class)
  public void testdecRank() 
  {
    System.out.println("decRank");

    IBoard instance = Board.getInstance();   
    
    IRank currRank = instance.getRank(ChessboardRank.RANK1);
    instance.decRank(currRank);
    
    currRank = instance.getRank(ChessboardRank.RANK2);
    IRank expResult = instance.getRank(ChessboardRank.RANK1);
    IRank result = instance.decRank(currRank);
    assertEquals(expResult, result);
    
    currRank = instance.getRank(ChessboardRank.RANK3);
    expResult = instance.getRank(ChessboardRank.RANK2);
    result = instance.decRank(currRank);
    assertEquals(expResult, result);
    
    currRank = instance.getRank(ChessboardRank.RANK4);
    expResult = instance.getRank(ChessboardRank.RANK3);
    result = instance.decRank(currRank);
    assertEquals(expResult, result);

    currRank = instance.getRank(ChessboardRank.RANK5);
    expResult = instance.getRank(ChessboardRank.RANK4);
    result = instance.decRank(currRank);
    assertEquals(expResult, result);
    
    currRank = instance.getRank(ChessboardRank.RANK6);
    expResult = instance.getRank(ChessboardRank.RANK5);
    result = instance.decRank(currRank);
    assertEquals(expResult, result);
    
    currRank = instance.getRank(ChessboardRank.RANK7);
    expResult = instance.getRank(ChessboardRank.RANK6);
    result = instance.decRank(currRank);
    assertEquals(expResult, result);
    
    currRank = instance.getRank(ChessboardRank.RANK8);
    expResult = instance.getRank(ChessboardRank.RANK7);
    result = instance.decRank(currRank);
    assertEquals(expResult, result);
  }
  
  /**
   * Test of incFile method, of class Board.
   */
  @Test (expected=IndexOutOfBoundsException.class)
  public void testIncFile() 
  {
    System.out.println("incFile");

    Board instance = Board.getInstance();
    
    IFile currFile = instance.getFile(ChessboardFile.FILEa);
    IFile expResult = instance.getFile(ChessboardFile.FILEb);
    IFile result = instance.incFile(currFile);
    assertEquals(expResult, result);

    currFile = instance.getFile(ChessboardFile.FILEb);
    expResult = instance.getFile(ChessboardFile.FILEc);
    result = instance.incFile(currFile);
    assertEquals(expResult, result);

    currFile = instance.getFile(ChessboardFile.FILEc);
    expResult = instance.getFile(ChessboardFile.FILEd);
    result = instance.incFile(currFile);
    assertEquals(expResult, result);

    currFile = instance.getFile(ChessboardFile.FILEd);
    expResult = instance.getFile(ChessboardFile.FILEe);
    result = instance.incFile(currFile);
    assertEquals(expResult, result);

    currFile = instance.getFile(ChessboardFile.FILEe);
    expResult = instance.getFile(ChessboardFile.FILEf);
    result = instance.incFile(currFile);
    assertEquals(expResult, result);

    currFile = instance.getFile(ChessboardFile.FILEf);
    expResult = instance.getFile(ChessboardFile.FILEg);
    result = instance.incFile(currFile);
    assertEquals(expResult, result);

    currFile = instance.getFile(ChessboardFile.FILEg);
    expResult = instance.getFile(ChessboardFile.FILEh);
    result = instance.incFile(currFile);
    assertEquals(expResult, result);

    currFile = instance.getFile(ChessboardFile.FILEh);
    instance.incFile(currFile);
  }
  
   /**
   * Test of incRank method, of class Board.
   */
  @Test (expected=IndexOutOfBoundsException.class)
  public void testincRank() 
  {
    System.out.println("incRank");

    IBoard instance = Board.getInstance();   
    
    IRank currRank = instance.getRank(ChessboardRank.RANK8);
    instance.incRank(currRank);
    
    currRank = instance.getRank(ChessboardRank.RANK7);
    IRank expResult = instance.getRank(ChessboardRank.RANK8);
    IRank result = instance.incRank(currRank);
    assertEquals(expResult, result);
    
    currRank = instance.getRank(ChessboardRank.RANK6);
    expResult = instance.getRank(ChessboardRank.RANK7);
    result = instance.incRank(currRank);
    assertEquals(expResult, result);
    
    currRank = instance.getRank(ChessboardRank.RANK5);
    expResult = instance.getRank(ChessboardRank.RANK6);
    result = instance.incRank(currRank);
    assertEquals(expResult, result);

    currRank = instance.getRank(ChessboardRank.RANK4);
    expResult = instance.getRank(ChessboardRank.RANK5);
    result = instance.incRank(currRank);
    assertEquals(expResult, result);
    
    currRank = instance.getRank(ChessboardRank.RANK3);
    expResult = instance.getRank(ChessboardRank.RANK4);
    result = instance.incRank(currRank);
    assertEquals(expResult, result);
    
    currRank = instance.getRank(ChessboardRank.RANK2);
    expResult = instance.getRank(ChessboardRank.RANK3);
    result = instance.incRank(currRank);
    assertEquals(expResult, result);
    
    currRank = instance.getRank(ChessboardRank.RANK1);
    expResult = instance.getRank(ChessboardRank.RANK2);
    result = instance.incRank(currRank);
    assertEquals(expResult, result);
  }
  
}
