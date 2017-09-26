/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ychessblocks.notation;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import ychessblocks.board.*;
import ychessblocks.piece.*;

/**
 *
 * @author Yair
 */
public class FENTranslatorTest
{
  private static IBoard m_board;  
  
  private ISquare a1;
  private ISquare a2;
  private ISquare a3;
  private ISquare a4;
  private ISquare a5;
  private ISquare a6;
  private ISquare a7;
  private ISquare a8;
  private ISquare b1;
  private ISquare b2;
  private ISquare b3;
  private ISquare b4;
  private ISquare b5;
  private ISquare b6;
  private ISquare b7;
  private ISquare b8;
  private ISquare c1;
  private ISquare c2;
  private ISquare c3;
  private ISquare c4;
  private ISquare c5;
  private ISquare c6;
  private ISquare c7;
  private ISquare c8;
  private ISquare d1;
  private ISquare d2;
  private ISquare d3;
  private ISquare d4;
  private ISquare d5;
  private ISquare d6;
  private ISquare d7;
  private ISquare d8;
  private ISquare e1;
  private ISquare e2;
  private ISquare e3;
  private ISquare e4;
  private ISquare e5;
  private ISquare e6;
  private ISquare e7;
  private ISquare e8;
  private ISquare f1;
  private ISquare f2;
  private ISquare f3;
  private ISquare f4;
  private ISquare f5;
  private ISquare f6;
  private ISquare f7;
  private ISquare f8;
  private ISquare g1;
  private ISquare g2;
  private ISquare g3;
  private ISquare g4;
  private ISquare g5;
  private ISquare g6;
  private ISquare g7;
  private ISquare g8;
  private ISquare h1;
  private ISquare h2;
  private ISquare h3;
  private ISquare h4;
  private ISquare h5;
  private ISquare h6;
  private ISquare h7;
  private ISquare h8;
  
  public FENTranslatorTest() {
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
    a1 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEa),
                           m_board.getRank(IRank.ChessboardRank.RANK1));    
    a2 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEa),
                           m_board.getRank(IRank.ChessboardRank.RANK2));
    a3 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEa),
                           m_board.getRank(IRank.ChessboardRank.RANK3));
    a4 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEa),
                           m_board.getRank(IRank.ChessboardRank.RANK4));
    a5 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEa),
                           m_board.getRank(IRank.ChessboardRank.RANK5));
    a6 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEa),
                           m_board.getRank(IRank.ChessboardRank.RANK6));
    a7 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEa),
                           m_board.getRank(IRank.ChessboardRank.RANK7));
    a8 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEa),
                           m_board.getRank(IRank.ChessboardRank.RANK8));
    
    b1 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEb),
                           m_board.getRank(IRank.ChessboardRank.RANK1));
    b2 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEb),
                           m_board.getRank(IRank.ChessboardRank.RANK2));
    b3 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEb),
                           m_board.getRank(IRank.ChessboardRank.RANK3));
    b4 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEb),
                           m_board.getRank(IRank.ChessboardRank.RANK4));
    b5 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEb),
                           m_board.getRank(IRank.ChessboardRank.RANK5));
    b6 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEb),
                           m_board.getRank(IRank.ChessboardRank.RANK6));
    b7 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEb),
                           m_board.getRank(IRank.ChessboardRank.RANK7));
    b8 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEb),
                           m_board.getRank(IRank.ChessboardRank.RANK8));
    
    c1 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEc),
                           m_board.getRank(IRank.ChessboardRank.RANK1));
    c2 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEc),
                           m_board.getRank(IRank.ChessboardRank.RANK2));
    c3 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEc),
                           m_board.getRank(IRank.ChessboardRank.RANK3));
    c4 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEc),
                           m_board.getRank(IRank.ChessboardRank.RANK4));
    c5 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEc),
                           m_board.getRank(IRank.ChessboardRank.RANK5));
    c6 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEc),
                           m_board.getRank(IRank.ChessboardRank.RANK6));
    c7 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEc),
                           m_board.getRank(IRank.ChessboardRank.RANK7));
    c8 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEc),
                           m_board.getRank(IRank.ChessboardRank.RANK8));
    
    d1 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEd),
                           m_board.getRank(IRank.ChessboardRank.RANK1));
    d2 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEd),
                           m_board.getRank(IRank.ChessboardRank.RANK2));
    d3 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEd),
                           m_board.getRank(IRank.ChessboardRank.RANK3));
    d4 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEd),
                           m_board.getRank(IRank.ChessboardRank.RANK4));
    d5 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEd),
                           m_board.getRank(IRank.ChessboardRank.RANK5));
    d6 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEd),
                           m_board.getRank(IRank.ChessboardRank.RANK6));
    d7 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEd),
                           m_board.getRank(IRank.ChessboardRank.RANK7));
    d8 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEd),
                           m_board.getRank(IRank.ChessboardRank.RANK8));
    
    e1 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEe),
                           m_board.getRank(IRank.ChessboardRank.RANK1));
    e2 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEe),
                           m_board.getRank(IRank.ChessboardRank.RANK2));
    e3 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEe),
                           m_board.getRank(IRank.ChessboardRank.RANK3));
    e4 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEe),
                           m_board.getRank(IRank.ChessboardRank.RANK4));
    e5 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEe),
                           m_board.getRank(IRank.ChessboardRank.RANK5));
    e6 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEe),
                           m_board.getRank(IRank.ChessboardRank.RANK6));
    e7 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEe),
                           m_board.getRank(IRank.ChessboardRank.RANK7));
    e8 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEe),
                           m_board.getRank(IRank.ChessboardRank.RANK8));
    
    f1 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEf),
                           m_board.getRank(IRank.ChessboardRank.RANK1));
    f2 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEf),
                           m_board.getRank(IRank.ChessboardRank.RANK2));
    f3 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEf),
                           m_board.getRank(IRank.ChessboardRank.RANK3));
    f4 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEf),
                           m_board.getRank(IRank.ChessboardRank.RANK4));
    f5 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEf),
                           m_board.getRank(IRank.ChessboardRank.RANK5));
    f6 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEf),
                           m_board.getRank(IRank.ChessboardRank.RANK6));
    f7 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEf),
                           m_board.getRank(IRank.ChessboardRank.RANK7));
    f8 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEf),
                           m_board.getRank(IRank.ChessboardRank.RANK8));
    
    g1 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEg),
                           m_board.getRank(IRank.ChessboardRank.RANK1));
    g2 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEg),
                           m_board.getRank(IRank.ChessboardRank.RANK2));
    g3 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEg),
                           m_board.getRank(IRank.ChessboardRank.RANK3));
    g4 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEg),
                           m_board.getRank(IRank.ChessboardRank.RANK4));
    g5 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEg),
                           m_board.getRank(IRank.ChessboardRank.RANK5));
    g6 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEg),
                           m_board.getRank(IRank.ChessboardRank.RANK6));
    g7 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEg),
                           m_board.getRank(IRank.ChessboardRank.RANK7));
    g8 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEg),
                           m_board.getRank(IRank.ChessboardRank.RANK8));
    
    h1 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEh),
                           m_board.getRank(IRank.ChessboardRank.RANK1));
    h2 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEh),
                           m_board.getRank(IRank.ChessboardRank.RANK2));
    h3 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEh),
                           m_board.getRank(IRank.ChessboardRank.RANK3));
    h4 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEh),
                           m_board.getRank(IRank.ChessboardRank.RANK4));
    h5 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEh),
                           m_board.getRank(IRank.ChessboardRank.RANK5));
    h6 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEh),
                           m_board.getRank(IRank.ChessboardRank.RANK6));
    h7 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEh),
                           m_board.getRank(IRank.ChessboardRank.RANK7));
    h8 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEh),
                           m_board.getRank(IRank.ChessboardRank.RANK8));        
  }
  
  @After
  public void tearDown() {
  }

  /**
   * Test of getActiveColorNotation method, of class FENTranslator.
   */
  @Test
  public void testGetActiveColorNotation() 
  {
    System.out.println("getActiveColorNotation");
    
    String expResult;
    String result;
    FENTranslator instance = NotationTranslator.getInstance().getFENTranslator();
    
    expResult = "w";
    result = instance.getActiveColorNotation(ChessColor.getInstance().getWhite());
    assertEquals(expResult, result);
    
    expResult = "b";
    result = instance.getActiveColorNotation(ChessColor.getInstance().getBlack());
    assertEquals(expResult, result);    
  }

  /**
   * Test of getCastlingNotation method, of class FENTranslator.
   */
  @Test
  public void testGetCastlingNotation() 
  {
    System.out.println("getCastlingNotation");
    
    boolean p_w00;
    boolean p_w000;
    boolean p_b00;
    boolean p_b000;
    String expResult;
    String result;
    FENTranslator instance = NotationTranslator.getInstance().getFENTranslator();

    p_w00 = false;
    p_w000 = false;
    p_b00 = false;
    p_b000 = false;   
    expResult = "-";
    result = instance.getCastlingNotation(p_w00, p_w000, p_b00, p_b000);
    assertEquals(expResult, result);
    
    p_w00 = true;
    p_w000 = false;
    p_b00 = false;
    p_b000 = false;   
    expResult = "K";
    result = instance.getCastlingNotation(p_w00, p_w000, p_b00, p_b000);
    assertEquals(expResult, result);

    p_w00 = false;
    p_w000 = true;
    p_b00 = false;
    p_b000 = false;   
    expResult = "Q";
    result = instance.getCastlingNotation(p_w00, p_w000, p_b00, p_b000);
    assertEquals(expResult, result);

    p_w00 = true;
    p_w000 = true;
    p_b00 = false;
    p_b000 = false;   
    expResult = "KQ";
    result = instance.getCastlingNotation(p_w00, p_w000, p_b00, p_b000);
    assertEquals(expResult, result);

    p_w00 = false;
    p_w000 = false;
    p_b00 = true;
    p_b000 = false;   
    expResult = "k";
    result = instance.getCastlingNotation(p_w00, p_w000, p_b00, p_b000);
    assertEquals(expResult, result);

    p_w00 = true;
    p_w000 = false;
    p_b00 = true;
    p_b000 = false;   
    expResult = "Kk";
    result = instance.getCastlingNotation(p_w00, p_w000, p_b00, p_b000);
    assertEquals(expResult, result);

    p_w00 = false;
    p_w000 = true;
    p_b00 = true;
    p_b000 = false;   
    expResult = "Qk";
    result = instance.getCastlingNotation(p_w00, p_w000, p_b00, p_b000);
    assertEquals(expResult, result);

    p_w00 = true;
    p_w000 = true;
    p_b00 = true;
    p_b000 = false;   
    expResult = "KQk";
    result = instance.getCastlingNotation(p_w00, p_w000, p_b00, p_b000);
    assertEquals(expResult, result);

    p_w00 = false;
    p_w000 = false;
    p_b00 = false;
    p_b000 = true;   
    expResult = "q";
    result = instance.getCastlingNotation(p_w00, p_w000, p_b00, p_b000);
    assertEquals(expResult, result);

    p_w00 = true;
    p_w000 = false;
    p_b00 = false;
    p_b000 = true;   
    expResult = "Kq";
    result = instance.getCastlingNotation(p_w00, p_w000, p_b00, p_b000);
    assertEquals(expResult, result);

    p_w00 = false;
    p_w000 = true;
    p_b00 = false;
    p_b000 = true;   
    expResult = "Qq";
    result = instance.getCastlingNotation(p_w00, p_w000, p_b00, p_b000);
    assertEquals(expResult, result);

    p_w00 = true;
    p_w000 = true;
    p_b00 = false;
    p_b000 = true;   
    expResult = "KQq";
    result = instance.getCastlingNotation(p_w00, p_w000, p_b00, p_b000);
    assertEquals(expResult, result);

    p_w00 = false;
    p_w000 = false;
    p_b00 = true;
    p_b000 = true;   
    expResult = "kq";
    result = instance.getCastlingNotation(p_w00, p_w000, p_b00, p_b000);
    assertEquals(expResult, result);
    
    p_w00 = true;
    p_w000 = false;
    p_b00 = true;
    p_b000 = true;   
    expResult = "Kkq";
    result = instance.getCastlingNotation(p_w00, p_w000, p_b00, p_b000);
    assertEquals(expResult, result);

    p_w00 = false;
    p_w000 = true;
    p_b00 = true;
    p_b000 = true;   
    expResult = "Qkq";
    result = instance.getCastlingNotation(p_w00, p_w000, p_b00, p_b000);
    assertEquals(expResult, result);

    p_w00 = true;
    p_w000 = true;
    p_b00 = true;
    p_b000 = true;   
    expResult = "KQkq";
    result = instance.getCastlingNotation(p_w00, p_w000, p_b00, p_b000);
    assertEquals(expResult, result);    
  }
  /**
   * Test of getFullmoveNumberNotation method, of class FENTranslator.
   */
  @Test
  public void testGetFullmoveNumberNotation()
  {
    System.out.println("getFullmoveNumberNotation");
    
    String expResult;
    String result;
    FENTranslator instance = NotationTranslator.getInstance().getFENTranslator();
    
    expResult = "22";
    result = instance.getFullmoveNumberNotation(22);
    assertEquals(expResult, result);
  }

  /**
   * Test of getHalfmoveClockNotation method, of class FENTranslator.
   */
  @Test
  public void testGetHalfmoveClockNotation()
  {
    System.out.println("getHalfmoveClockNotation");
        
    String expResult;
    String result;
    FENTranslator instance = NotationTranslator.getInstance().getFENTranslator();
    
    expResult = "0";
    result = instance.getHalfmoveClockNotation(0);    
    assertEquals(expResult, result);
  }

  /**
   * Test of getPieceNotation method, of class FENTranslator.
   */
  @Test
  public void testGetPieceNotation()
  {
    System.out.println("getPieceNotation");
    
    IPieceBox pbox = PieceBox.getInstance();
    
    String expResult;
    String result;
    FENTranslator instance = NotationTranslator.getInstance().getFENTranslator();
    
    expResult = "K";
    result = instance.getPieceNotation(pbox.createWhiteKing());
    assertEquals(expResult, result);
    expResult = "k";
    result = instance.getPieceNotation(pbox.createBlackKing());
    assertEquals(expResult, result);

    expResult = "Q";
    result = instance.getPieceNotation(pbox.createWhiteQueen());
    assertEquals(expResult, result);
    expResult = "q";
    result = instance.getPieceNotation(pbox.createBlackQueen());
    assertEquals(expResult, result);

    expResult = "R";
    result = instance.getPieceNotation(pbox.createWhiteRook());
    assertEquals(expResult, result);
    expResult = "r";
    result = instance.getPieceNotation(pbox.createBlackRook());
    assertEquals(expResult, result);

    expResult = "N";
    result = instance.getPieceNotation(pbox.createWhiteKnight());
    assertEquals(expResult, result);
    expResult = "n";
    result = instance.getPieceNotation(pbox.createBlackKnight());
    assertEquals(expResult, result);

    expResult = "B";
    result = instance.getPieceNotation(pbox.createWhiteBishop());
    assertEquals(expResult, result);
    expResult = "b";
    result = instance.getPieceNotation(pbox.createBlackBishop());
    assertEquals(expResult, result);

    expResult = "P";
    result = instance.getPieceNotation(pbox.createWhitePawn());
    assertEquals(expResult, result);
    expResult = "p";
    result = instance.getPieceNotation(pbox.createBlackPawn());
    assertEquals(expResult, result);    
  }

  /**
   * Test of getSquareNotation method, of class FENTranslator.
   */
  @Test
  public void testGetSquareNotation()
  {
    System.out.println("getSquareNotation");
    
    String expResult;
    String result;
    FENTranslator instance = NotationTranslator.getInstance().getFENTranslator();
    
    expResult = "a1";
    result = instance.getSquareNotation(a1);
    assertEquals(expResult, result);
    expResult = "a2";
    result = instance.getSquareNotation(a2);
    assertEquals(expResult, result);
    expResult = "a3";
    result = instance.getSquareNotation(a3);
    assertEquals(expResult, result);
    expResult = "a4";
    result = instance.getSquareNotation(a4);
    assertEquals(expResult, result);
    expResult = "a5";
    result = instance.getSquareNotation(a5);
    assertEquals(expResult, result);
    expResult = "a6";
    result = instance.getSquareNotation(a6);
    assertEquals(expResult, result);
    expResult = "a7";
    result = instance.getSquareNotation(a7);
    assertEquals(expResult, result);
    expResult = "a8";
    result = instance.getSquareNotation(a8);
    assertEquals(expResult, result);

    expResult = "b1";
    result = instance.getSquareNotation(b1);
    assertEquals(expResult, result);
    expResult = "b2";
    result = instance.getSquareNotation(b2);
    assertEquals(expResult, result);
    expResult = "b3";
    result = instance.getSquareNotation(b3);
    assertEquals(expResult, result);
    expResult = "b4";
    result = instance.getSquareNotation(b4);
    assertEquals(expResult, result);
    expResult = "b5";
    result = instance.getSquareNotation(b5);
    assertEquals(expResult, result);
    expResult = "b6";
    result = instance.getSquareNotation(b6);
    assertEquals(expResult, result);
    expResult = "b7";
    result = instance.getSquareNotation(b7);
    assertEquals(expResult, result);
    expResult = "b8";
    result = instance.getSquareNotation(b8);
    assertEquals(expResult, result);

    expResult = "c1";
    result = instance.getSquareNotation(c1);
    assertEquals(expResult, result);
    expResult = "c2";
    result = instance.getSquareNotation(c2);
    assertEquals(expResult, result);
    expResult = "c3";
    result = instance.getSquareNotation(c3);
    assertEquals(expResult, result);
    expResult = "c4";
    result = instance.getSquareNotation(c4);
    assertEquals(expResult, result);
    expResult = "c5";
    result = instance.getSquareNotation(c5);
    assertEquals(expResult, result);
    expResult = "c6";
    result = instance.getSquareNotation(c6);
    assertEquals(expResult, result);
    expResult = "c7";
    result = instance.getSquareNotation(c7);
    assertEquals(expResult, result);
    expResult = "c8";
    result = instance.getSquareNotation(c8);
    assertEquals(expResult, result);

    expResult = "d1";
    result = instance.getSquareNotation(d1);
    assertEquals(expResult, result);
    expResult = "d2";
    result = instance.getSquareNotation(d2);
    assertEquals(expResult, result);
    expResult = "d3";
    result = instance.getSquareNotation(d3);
    assertEquals(expResult, result);
    expResult = "d4";
    result = instance.getSquareNotation(d4);
    assertEquals(expResult, result);
    expResult = "d5";
    result = instance.getSquareNotation(d5);
    assertEquals(expResult, result);
    expResult = "d6";
    result = instance.getSquareNotation(d6);
    assertEquals(expResult, result);
    expResult = "d7";
    result = instance.getSquareNotation(d7);
    assertEquals(expResult, result);
    expResult = "d8";
    result = instance.getSquareNotation(d8);
    assertEquals(expResult, result);

    expResult = "e1";
    result = instance.getSquareNotation(e1);
    assertEquals(expResult, result);
    expResult = "e2";
    result = instance.getSquareNotation(e2);
    assertEquals(expResult, result);
    expResult = "e3";
    result = instance.getSquareNotation(e3);
    assertEquals(expResult, result);
    expResult = "e4";
    result = instance.getSquareNotation(e4);
    assertEquals(expResult, result);
    expResult = "e5";
    result = instance.getSquareNotation(e5);
    assertEquals(expResult, result);
    expResult = "e6";
    result = instance.getSquareNotation(e6);
    assertEquals(expResult, result);
    expResult = "e7";
    result = instance.getSquareNotation(e7);
    assertEquals(expResult, result);
    expResult = "e8";
    result = instance.getSquareNotation(e8);
    assertEquals(expResult, result);

    expResult = "f1";
    result = instance.getSquareNotation(f1);
    assertEquals(expResult, result);
    expResult = "f2";
    result = instance.getSquareNotation(f2);
    assertEquals(expResult, result);
    expResult = "f3";
    result = instance.getSquareNotation(f3);
    assertEquals(expResult, result);
    expResult = "f4";
    result = instance.getSquareNotation(f4);
    assertEquals(expResult, result);
    expResult = "f5";
    result = instance.getSquareNotation(f5);
    assertEquals(expResult, result);
    expResult = "f6";
    result = instance.getSquareNotation(f6);
    assertEquals(expResult, result);
    expResult = "f7";
    result = instance.getSquareNotation(f7);
    assertEquals(expResult, result);
    expResult = "f8";
    result = instance.getSquareNotation(f8);
    assertEquals(expResult, result);

    expResult = "g1";
    result = instance.getSquareNotation(g1);
    assertEquals(expResult, result);
    expResult = "g2";
    result = instance.getSquareNotation(g2);
    assertEquals(expResult, result);
    expResult = "g3";
    result = instance.getSquareNotation(g3);
    assertEquals(expResult, result);
    expResult = "g4";
    result = instance.getSquareNotation(g4);
    assertEquals(expResult, result);
    expResult = "g5";
    result = instance.getSquareNotation(g5);
    assertEquals(expResult, result);
    expResult = "g6";
    result = instance.getSquareNotation(g6);
    assertEquals(expResult, result);
    expResult = "g7";
    result = instance.getSquareNotation(g7);
    assertEquals(expResult, result);
    expResult = "g8";
    result = instance.getSquareNotation(g8);
    assertEquals(expResult, result);

    expResult = "h1";
    result = instance.getSquareNotation(h1);
    assertEquals(expResult, result);
    expResult = "h2";
    result = instance.getSquareNotation(h2);
    assertEquals(expResult, result);
    expResult = "h3";
    result = instance.getSquareNotation(h3);
    assertEquals(expResult, result);
    expResult = "h4";
    result = instance.getSquareNotation(h4);
    assertEquals(expResult, result);
    expResult = "h5";
    result = instance.getSquareNotation(h5);
    assertEquals(expResult, result);
    expResult = "h6";
    result = instance.getSquareNotation(h6);
    assertEquals(expResult, result);
    expResult = "h7";
    result = instance.getSquareNotation(h7);
    assertEquals(expResult, result);
    expResult = "h8";
    result = instance.getSquareNotation(h8);
    assertEquals(expResult, result);    
  }
}
