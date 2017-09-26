/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ychessblocks.position;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import ychessblocks.board.IColor;
import ychessblocks.board.ISquare;
import ychessblocks.piece.*;
import ychessblocks.board.*;

/**
 *
 * @author Yair
 */
public class PositionTest 
{
  private static Board m_board;
  private static ChessColor m_chessColor;
  
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
  
  public PositionTest() {
  }
  
  @BeforeClass
  public static void setUpClass()
  {
    m_board = Board.getInstance();
    m_chessColor = ChessColor.getInstance();
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
   * Test of move method, of class Position.
   */
  @Test //(expected=IllegalMoveException.class)
  public void testMove() throws Exception
  {
    System.out.println("move");
    
    Position instance;
    Position next;
    Position falseMovePos;
    IPieceBox pbox = PieceBox.getInstance();
    
    //We follow the game
    //Morphy vs. Dukes
    //(* suffixed moves are illegal moves)
    instance = new Position();
    instance.set();
   
    //1. e4
    next = (Position)(instance.move(e2, e4));
    assertTrue(next != null);
    assertTrue(next.getPiece(e2) == null);
    assertEquals(pbox.createWhitePawn(), next.getPiece(e4));
    assertEquals(m_chessColor.getBlack(), next.getActiveColor());
    instance = next;
    
    //1. .. e5
    next = (Position)(instance.move(e7, e5));
    assertTrue(next != null);
    assertTrue(next.getPiece(e7) == null);
    assertEquals(pbox.createBlackPawn(), next.getPiece(e5));
    assertEquals(m_chessColor.getWhite(), next.getActiveColor());
    instance = next;
    
    //2. Nf3
    next = (Position)(instance.move(g1, f3));
    assertTrue(next != null);
    assertTrue(next.getPiece(g1) == null);
    assertEquals(pbox.createWhiteKnight(), next.getPiece(f3));
    assertEquals(m_chessColor.getBlack(), next.getActiveColor());
    instance = next;
    
    //2. .. d6
    next = (Position)(instance.move(d7, d6));
    assertTrue(next != null);
    assertTrue(next.getPiece(d7) == null);
    assertEquals(pbox.createBlackPawn(), next.getPiece(d6));
    assertEquals(m_chessColor.getWhite(), next.getActiveColor());
    instance = next;
    
    //3. e5*
    falseMovePos = null;
    try
    {
      falseMovePos = (Position)(instance.move(e4, e5));
    }
    catch (IllegalMoveException excp)
    {
      assertTrue(excp.getFault() == IllegalMoveException.MoveFault.PIECE);
    }
    assertTrue(falseMovePos == null);
    assertTrue(instance.getPiece(e4) != null);
    assertEquals(pbox.createWhitePawn(), instance.getPiece(e4));
    assertEquals(pbox.createBlackPawn(), instance.getPiece(e5));
    assertEquals(m_chessColor.getWhite(), instance.getActiveColor());

    //3. d4
    next = (Position)(instance.move(d2, d4));
    assertTrue(next != null);
    assertTrue(next.getPiece(d2) == null);
    assertEquals(pbox.createWhitePawn(), next.getPiece(d4));
    assertEquals(m_chessColor.getBlack(), next.getActiveColor());
    instance = next;

    //3. .. Bg4
    next = (Position)(instance.move(c8, g4));
    assertTrue(next != null);
    assertTrue(next.getPiece(c8) == null);
    assertEquals(pbox.createBlackBishop(), next.getPiece(g4));
    assertEquals(m_chessColor.getWhite(), next.getActiveColor());
    instance = next;

    //4. dxe5
    next = (Position)(instance.move(d4, e5));
    assertTrue(next != null);
    assertTrue(next.getPiece(d4) == null);
    assertEquals(pbox.createWhitePawn(), next.getPiece(e5));
    assertEquals(m_chessColor.getBlack(), next.getActiveColor());
    instance = next;

    //4. .. Bxf3
    next = (Position)(instance.move(g4, f3));
    assertTrue(next != null);
    assertTrue(next.getPiece(g4) == null);
    assertEquals(pbox.createBlackBishop(), next.getPiece(f3));
    assertEquals(m_chessColor.getWhite(), next.getActiveColor());
    instance = next;

    //5. Ke2*
    falseMovePos = null;
    try
    {
      falseMovePos = (Position)(instance.move(e1, e2));
    }
    catch (IllegalMoveException excp)
    {
      assertTrue(excp.getFault() == IllegalMoveException.MoveFault.CHECK);
    }    
    assertTrue(falseMovePos == null);
    assertTrue(instance.getPiece(e1) != null);
    assertEquals(pbox.createWhiteKing(), instance.getPiece(e1));
    assertEquals(m_chessColor.getWhite(), instance.getActiveColor());

    //5. Qxf3
    next = (Position)(instance.move(d1, f3));
    assertTrue(next != null);
    assertTrue(next.getPiece(d1) == null);
    assertEquals(pbox.createWhiteQueen(), next.getPiece(f3));
    assertEquals(m_chessColor.getBlack(), next.getActiveColor());
    instance = next;

    //5. .. dxe5
    next = (Position)(instance.move(d6, e5));
    assertTrue(next != null);
    assertTrue(next.getPiece(d6) == null);
    assertEquals(pbox.createBlackPawn(), next.getPiece(e5));
    assertEquals(m_chessColor.getWhite(), next.getActiveColor());
    instance = next;

    //6. Bc4
    next = (Position)(instance.move(f1, c4));
    assertTrue(next != null);
    assertTrue(next.getPiece(f1) == null);
    assertEquals(pbox.createWhiteBishop(), next.getPiece(c4));
    assertEquals(m_chessColor.getBlack(), next.getActiveColor());
    instance = next;

    //6. .. Nf6
    next = (Position)(instance.move(g8, f6));
    assertTrue(next != null);
    assertTrue(next.getPiece(g8) == null);
    assertEquals(pbox.createBlackKnight(), next.getPiece(f6));
    assertEquals(m_chessColor.getWhite(), next.getActiveColor());
    instance = next;
    
    //7. Qb3
    next = (Position)(instance.move(f3, b3));
    assertTrue(next != null);
    assertTrue(next.getPiece(f3) == null);
    assertEquals(pbox.createWhiteQueen(), next.getPiece(b3));
    assertEquals(m_chessColor.getBlack(), next.getActiveColor());
    instance = next;

    //7. .. Qe7
    next = (Position)(instance.move(d8, e7));
    assertTrue(next != null);
    assertTrue(next.getPiece(d8) == null);
    assertEquals(pbox.createBlackQueen(), next.getPiece(e7));
    assertEquals(m_chessColor.getWhite(), next.getActiveColor());
    instance = next;

    //7. .. Qb4*
    falseMovePos = null;
    try
    {
      falseMovePos = (Position)(instance.move(e7, b4));
    }
    catch (IllegalMoveException excp)
    {
      assertTrue(excp.getFault() == IllegalMoveException.MoveFault.COLOR);
    }
    assertTrue(falseMovePos == null);
    assertTrue(instance.getPiece(e7) != null);
    assertEquals(pbox.createBlackQueen(), instance.getPiece(e7));
    assertTrue(instance.getPiece(b4) == null);
    assertEquals(m_chessColor.getWhite(), instance.getActiveColor());

    //8. Nc3
    next = (Position)(instance.move(b1, c3));
    assertTrue(next != null);
    assertTrue(next.getPiece(b1) == null);
    assertEquals(pbox.createWhiteKnight(), next.getPiece(c3));
    assertEquals(m_chessColor.getBlack(), next.getActiveColor());
    instance = next;

    //8. .. c6
    next = (Position)(instance.move(c7, c6));
    assertTrue(next != null);
    assertTrue(next.getPiece(c7) == null);
    assertEquals(pbox.createBlackPawn(), next.getPiece(c6));
    assertEquals(m_chessColor.getWhite(), next.getActiveColor());
    instance = next;

    //9. 0-0-0*
    falseMovePos = null;
    try
    {
      falseMovePos = (Position)(instance.move(e1, c1));
    }
    catch (IllegalMoveException excp)
    {
      assertTrue(excp.getFault() == IllegalMoveException.MoveFault.PIECE);
    }   
    assertTrue(falseMovePos == null);
    assertTrue(instance.getPiece(e1) != null);
    assertEquals(pbox.createWhiteKing(), instance.getPiece(e1));
    assertEquals(pbox.createWhiteRook(), instance.getPiece(a1));
    assertEquals(pbox.createWhiteBishop(), instance.getPiece(c1));
    assertEquals(m_chessColor.getWhite(), instance.getActiveColor());
    
    //9. Bg5
    next = (Position)(instance.move(c1, g5));
    assertTrue(next != null);
    assertTrue(next.getPiece(c1) == null);
    assertEquals(pbox.createWhiteBishop(), next.getPiece(g5));
    assertEquals(m_chessColor.getBlack(), next.getActiveColor());
    instance = next;

    //9. .. b5
    next = (Position)(instance.move(b7, b5));
    assertTrue(next != null);
    assertTrue(next.getPiece(b7) == null);
    assertEquals(pbox.createBlackPawn(), next.getPiece(b5));
    assertEquals(m_chessColor.getWhite(), next.getActiveColor());
    instance = next;
    
    //10. Nxb5!
    next = (Position)(instance.move(c3, b5));
    assertTrue(next != null);
    assertTrue(next.getPiece(c3) == null);
    assertEquals(pbox.createWhiteKnight(), next.getPiece(b5));
    assertEquals(m_chessColor.getBlack(), next.getActiveColor());
    instance = next;

    //10. .. cxb5
    next = (Position)(instance.move(c6, b5));
    assertTrue(next != null);
    assertTrue(next.getPiece(c6) == null);
    assertEquals(pbox.createBlackPawn(), next.getPiece(b5));
    assertEquals(m_chessColor.getWhite(), next.getActiveColor());
    instance = next;

    //11. Bxb5+
    next = (Position)(instance.move(c4, b5));
    assertTrue(next != null);
    assertTrue(next.getPiece(c4) == null);
    assertEquals(pbox.createWhiteBishop(), next.getPiece(b5));
    assertEquals(m_chessColor.getBlack(), next.getActiveColor());
    instance = next;

    //11. .. Nbd7
    next = (Position)(instance.move(b8, d7));
    assertTrue(next != null);
    assertTrue(next.getPiece(b8) == null);
    assertEquals(pbox.createBlackKnight(), next.getPiece(d7));
    assertEquals(m_chessColor.getWhite(), next.getActiveColor());
    instance = next;

    //12. 0-0-0
    next = (Position)(instance.move(e1, c1));
    assertTrue(next != null);
    assertTrue(next.getPiece(e1) == null);
    assertTrue(next.getPiece(a1) == null);
    assertEquals(pbox.createWhiteKing(), next.getPiece(c1));
    assertEquals(pbox.createWhiteRook(), next.getPiece(d1));
    assertEquals(m_chessColor.getBlack(), next.getActiveColor());
    instance = next;

    //12. .. Rd8
    next = (Position)(instance.move(a8, d8));
    assertTrue(next != null);
    assertTrue(next.getPiece(a8) == null);
    assertEquals(pbox.createBlackRook(), next.getPiece(d8));
    assertEquals(m_chessColor.getWhite(), next.getActiveColor());
    instance = next;

    //13. Rxd7!
    next = (Position)(instance.move(d1, d7));
    assertTrue(next != null);
    assertTrue(next.getPiece(d1) == null);
    assertEquals(pbox.createWhiteRook(), next.getPiece(d7));
    assertEquals(m_chessColor.getBlack(), next.getActiveColor());
    instance = next;

    //13. .. Rxd7
    next = (Position)(instance.move(d8, d7));
    assertTrue(next != null);
    assertTrue(next.getPiece(d8) == null);
    assertEquals(pbox.createBlackRook(), next.getPiece(d7));
    assertEquals(m_chessColor.getWhite(), next.getActiveColor());
    instance = next;

    //14. Rd1
    next = (Position)(instance.move(h1, d1));
    assertTrue(next != null);
    assertTrue(next.getPiece(h1) == null);
    assertEquals(pbox.createWhiteRook(), next.getPiece(d1));
    assertEquals(m_chessColor.getBlack(), next.getActiveColor());
    instance = next;

    //14. .. Qg6*
    falseMovePos = null;
    try
    {
      falseMovePos = (Position)(instance.move(e7, g6));
    }
    catch (IllegalMoveException excp)
    {
      assertTrue(excp.getFault() == IllegalMoveException.MoveFault.PIECE);
    }
    assertTrue(falseMovePos == null);
    assertTrue(instance.getPiece(e7) != null);
    assertEquals(pbox.createBlackQueen(), instance.getPiece(e7));
    assertTrue(instance.getPiece(g6) == null);
    assertEquals(m_chessColor.getBlack(), instance.getActiveColor());

    //14. .. Qe6
    next = (Position)(instance.move(e7, e6));
    assertTrue(next != null);
    assertTrue(next.getPiece(e7) == null);
    assertEquals(pbox.createBlackQueen(), next.getPiece(e6));
    assertEquals(m_chessColor.getWhite(), next.getActiveColor());
    instance = next;
    
    //15. Bxd7+
    next = (Position)(instance.move(b5, d7));
    assertTrue(next != null);
    assertTrue(next.getPiece(b5) == null);
    assertEquals(pbox.createWhiteBishop(), next.getPiece(d7));
    assertEquals(m_chessColor.getBlack(), next.getActiveColor());
    instance = next;

    //15. .. Bb4*
    falseMovePos = null;
    try
    {
      falseMovePos = (Position)(instance.move(f8, b4));
    }
    catch (IllegalMoveException excp)
    {
      assertTrue(excp.getFault() == IllegalMoveException.MoveFault.CHECK);
    }    
    assertTrue(falseMovePos == null);
    assertTrue(instance.getPiece(f8) != null);
    assertEquals(pbox.createBlackBishop(), instance.getPiece(f8));
    assertTrue(instance.getPiece(b4) == null);
    assertEquals(m_chessColor.getBlack(), instance.getActiveColor());
    
    //15. .. Nxd7
    next = (Position)(instance.move(f6, d7));
    assertTrue(next != null);
    assertTrue(next.getPiece(f6) == null);
    assertEquals(pbox.createBlackKnight(), next.getPiece(d7));
    assertEquals(m_chessColor.getWhite(), next.getActiveColor());
    instance = next;

    //16. Qb8+!!
    next = (Position)(instance.move(b3, b8));
    assertTrue(next != null);
    assertTrue(next.getPiece(b3) == null);
    assertEquals(pbox.createWhiteQueen(), next.getPiece(b8));
    assertEquals(m_chessColor.getBlack(), next.getActiveColor());
    instance = next;

    //16. .. Nxb8
    next = (Position)(instance.move(d7, b8));
    assertTrue(next != null);
    assertTrue(next.getPiece(d7) == null);
    assertEquals(pbox.createBlackKnight(), next.getPiece(b8));
    assertEquals(m_chessColor.getWhite(), next.getActiveColor());
    instance = next;

    //17. Rd8#
    next = (Position)(instance.move(d1, d8));
    assertTrue(next != null);
    assertTrue(next.getPiece(d1) == null);
    assertEquals(pbox.createWhiteRook(), next.getPiece(d8));
    assertEquals(m_chessColor.getBlack(), next.getActiveColor());
    instance = next;

    //17. .. Kxd8*
    falseMovePos = null;
    try
    {
      falseMovePos = (Position)(instance.move(e8, d8));
    }
    catch (IllegalMoveException excp)
    {
      assertTrue(excp.getFault() == IllegalMoveException.MoveFault.CHECK);
    }
    assertTrue(falseMovePos == null);
    assertTrue(instance.getPiece(e8) != null);
    assertEquals(pbox.createBlackKing(), instance.getPiece(e8));
    assertEquals(pbox.createWhiteRook(), instance.getPiece(d8));
    assertEquals(m_chessColor.getBlack(), instance.getActiveColor());


    //Test en passant capture
    instance = new Position();
    instance.set();
    
    //1. e4
    next = (Position)(instance.move(e2, e4));
    assertTrue(next != null);
    assertTrue(next.getPiece(e2) == null);
    assertEquals(pbox.createWhitePawn(), next.getPiece(e4));
    assertEquals(m_chessColor.getBlack(), next.getActiveColor());
    assertTrue(next.getEnpassant().equals(e3));
    instance = next;
    
    //1. .. c6
    next = (Position)(instance.move(c7, c6));
    assertTrue(next != null);
    assertTrue(next.getPiece(c7) == null);
    assertEquals(pbox.createBlackPawn(), next.getPiece(c6));
    assertEquals(m_chessColor.getWhite(), next.getActiveColor());
    assertTrue(next.getEnpassant() == null);
    instance = next;

    //2. d4
    next = (Position)(instance.move(d2, d4));
    assertTrue(next != null);
    assertTrue(next.getPiece(d2) == null);
    assertEquals(pbox.createWhitePawn(), next.getPiece(d4));
    assertEquals(m_chessColor.getBlack(), next.getActiveColor());
    assertTrue(next.getEnpassant().equals(d3));
    instance = next;
    
    //2. .. d5
    next = (Position)(instance.move(d7, d5));
    assertTrue(next != null);
    assertTrue(next.getPiece(d7) == null);
    assertEquals(pbox.createBlackPawn(), next.getPiece(d5));
    assertEquals(m_chessColor.getWhite(), next.getActiveColor());
    assertTrue(next.getEnpassant().equals(d6));
    instance = next;

    //3. e5
    next = (Position)(instance.move(e4, e5));
    assertTrue(next != null);
    assertTrue(next.getPiece(e4) == null);
    assertEquals(pbox.createWhitePawn(), next.getPiece(e5));
    assertEquals(m_chessColor.getBlack(), next.getActiveColor());
    assertTrue(next.getEnpassant() == null);
    instance = next;
    
    //3. .. f5?!
    next = (Position)(instance.move(f7, f5));
    assertTrue(next != null);
    assertTrue(next.getPiece(f7) == null);
    assertEquals(pbox.createBlackPawn(), next.getPiece(f5));
    assertEquals(m_chessColor.getWhite(), next.getActiveColor());
    assertTrue(next.getEnpassant().equals(f6));
    instance = next;
    
    //4. exf e.p.
    next = (Position)(instance.move(e5, f6));
    assertTrue(next != null);
    assertTrue(next.getPiece(e4) == null);
    assertEquals(pbox.createWhitePawn(), next.getPiece(f6));
    assertTrue(next.getPiece(f5) == null);
    assertEquals(m_chessColor.getBlack(), next.getActiveColor());
    assertTrue(next.getEnpassant() == null);
    instance = next;

    //3. .. f4*
    falseMovePos = null;
    try
    {
      falseMovePos = (Position)(instance.move(f5, f4));
    }
    catch (IllegalMoveException excp)
    {
      assertTrue(excp.getFault() == IllegalMoveException.MoveFault.PIECE);
    }    
    assertTrue(falseMovePos == null);
    assertTrue(instance.getPiece(f5) == null);
    assertTrue(instance.getPiece(f4) == null);
    assertEquals(m_chessColor.getBlack(), instance.getActiveColor());   
    
    //Promotion
    TestPromotionListener promotionListener = new TestPromotionListener();
    instance = new Position();
    instance.set();
    instance.setPromotionListener(promotionListener);
    IPosition posBeforePromotion;
    
    //1. d4
    next = (Position)(instance.move(d2, d4));
    assertTrue(next != null);
    instance = next;
    
    //1. .. d5
    next = (Position)(instance.move(d7, d5));
    assertTrue(next != null);
    instance = next;

    //2. c4
    next = (Position)(instance.move(c2, c4));
    assertTrue(next != null);
    instance = next;
    
    //2. .. e5 (D08: Albin counter gambit)
    next = (Position)(instance.move(e7, e5));
    assertTrue(next != null);
    instance = next;

    //3. dxe
    next = (Position)(instance.move(d4, e5));
    assertTrue(next != null);
    instance = next;
    
    //3. .. d4
    next = (Position)(instance.move(d5, d4));
    assertTrue(next != null);
    instance = next;
    
    //4. e3
    next = (Position)(instance.move(e2, e3));
    assertTrue(next != null);
    instance = next;
    
    //4. .. Bb4+
    next = (Position)(instance.move(f8, b4));
    assertTrue(next != null);
    instance = next;

    //5. Bd2
    next = (Position)(instance.move(c1, d2));
    assertTrue(next != null);
    instance = next;
    
    //5. .. dxe3
    next = (Position)(instance.move(d4, e3));
    assertTrue(next != null);
    instance = next;
    
    //6. Bxb4
    next = (Position)(instance.move(d2, b4));
    assertTrue(next != null);
    instance = next;
    
    //6. .. eXf2+
    next = (Position)(instance.move(e3, f2));
    assertTrue(next != null);
    instance = next;
    
    //7. Ke2
    next = (Position)(instance.move(e1, e2));
    assertTrue(next != null);
    instance = next;
    posBeforePromotion = next;
    
    //7. .. fxg=R
    next = (Position)(instance.move(f2, g1));
    assertTrue(next != null);
    assertTrue(next.getPiece(f2) == null);
    assertEquals(pbox.createBlackRook(), next.getPiece(g1));
    assertEquals(m_chessColor.getWhite(), next.getActiveColor());

    //7. .. fxg=Q
    promotionListener.m_promotionKind = IPromotionListener.PromoteToPieceKind.QUEEN;
    instance = (Position)posBeforePromotion;
    next = (Position)(instance.move(f2, g1));
    assertTrue(next != null);
    assertTrue(next.getPiece(f2) == null);
    assertEquals(pbox.createBlackQueen(), next.getPiece(g1));
    assertEquals(m_chessColor.getWhite(), next.getActiveColor());
    
    //7. .. fxg=B
    promotionListener.m_promotionKind = IPromotionListener.PromoteToPieceKind.BISHOP;
    instance = (Position)posBeforePromotion;
    next = (Position)(instance.move(f2, g1));
    assertTrue(next != null);
    assertTrue(next.getPiece(f2) == null);
    assertEquals(pbox.createBlackBishop(), next.getPiece(g1));
    assertEquals(m_chessColor.getWhite(), next.getActiveColor());

    //7. .. fxg=N+!
    promotionListener.m_promotionKind = IPromotionListener.PromoteToPieceKind.KNIGHT;
    instance = (Position)posBeforePromotion;
    next = (Position)(instance.move(f2, g1));
    assertTrue(next != null);
    assertTrue(next.getPiece(f2) == null);
    assertEquals(pbox.createBlackKnight(), next.getPiece(g1));
    assertEquals(m_chessColor.getWhite(), next.getActiveColor());

    //7. .. fxg=Q
    instance = (Position)posBeforePromotion;
    instance.clearPromotionListener();
    next = (Position)(instance.move(f2, g1));
    assertTrue(next != null);
    assertTrue(next.getPiece(f2) == null);
    assertEquals(pbox.createBlackQueen(), next.getPiece(g1));
    assertEquals(m_chessColor.getWhite(), next.getActiveColor());    
  }

  /**
   * Test of set method, of class Position.
   */
  @Test
  public void testSet_0args() 
  {
    System.out.println("set");
    
    Position instance = new Position();
    instance.set();
    
    assertTrue(m_chessColor.getWhite().equals(instance.getActiveColor()));
    
    //White pawns position
    assertEquals(IPiece.PieceKind.PAWN, instance.getPiece(a2).getKind());
    assertTrue(instance.getPiece(a2).isWhite());    
    assertEquals(IPiece.PieceKind.PAWN, instance.getPiece(b2).getKind());
    assertTrue(instance.getPiece(b2).isWhite());
    assertEquals(IPiece.PieceKind.PAWN, instance.getPiece(c2).getKind());
    assertTrue(instance.getPiece(c2).isWhite());
    assertEquals(IPiece.PieceKind.PAWN, instance.getPiece(d2).getKind());
    assertTrue(instance.getPiece(d2).isWhite());
    assertEquals(IPiece.PieceKind.PAWN, instance.getPiece(e2).getKind());
    assertTrue(instance.getPiece(e2).isWhite());
    assertEquals(IPiece.PieceKind.PAWN, instance.getPiece(f2).getKind());
    assertTrue(instance.getPiece(f2).isWhite());
    assertEquals(IPiece.PieceKind.PAWN, instance.getPiece(g2).getKind());
    assertTrue(instance.getPiece(g2).isWhite());
    assertEquals(IPiece.PieceKind.PAWN, instance.getPiece(h2).getKind());
    assertTrue(instance.getPiece(h2).isWhite());

    //Black pawns position
    assertEquals(IPiece.PieceKind.PAWN, instance.getPiece(a7).getKind());
    assertTrue(instance.getPiece(a7).isBlack());
    assertEquals(IPiece.PieceKind.PAWN, instance.getPiece(b7).getKind());
    assertTrue(instance.getPiece(b7).isBlack());
    assertEquals(IPiece.PieceKind.PAWN, instance.getPiece(c7).getKind());
    assertTrue(instance.getPiece(c7).isBlack());
    assertEquals(IPiece.PieceKind.PAWN, instance.getPiece(d7).getKind());
    assertTrue(instance.getPiece(d7).isBlack());
    assertEquals(IPiece.PieceKind.PAWN, instance.getPiece(e7).getKind());
    assertTrue(instance.getPiece(e7).isBlack());
    assertEquals(IPiece.PieceKind.PAWN, instance.getPiece(f7).getKind());
    assertTrue(instance.getPiece(f7).isBlack());
    assertEquals(IPiece.PieceKind.PAWN, instance.getPiece(g7).getKind());
    assertTrue(instance.getPiece(g7).isBlack());
    assertEquals(IPiece.PieceKind.PAWN, instance.getPiece(h7).getKind());
    assertTrue(instance.getPiece(h7).isBlack());
    
    //Test Rooks
    assertEquals(IPiece.PieceKind.ROOK, instance.getPiece(a1).getKind());
    assertTrue(instance.getPiece(a1).isWhite());
    assertEquals(IPiece.PieceKind.ROOK, instance.getPiece(h1).getKind());
    assertTrue(instance.getPiece(h1).isWhite());
    assertEquals(IPiece.PieceKind.ROOK, instance.getPiece(a8).getKind());
    assertTrue(instance.getPiece(a8).isBlack());
    assertEquals(IPiece.PieceKind.ROOK, instance.getPiece(h8).getKind());
    assertTrue(instance.getPiece(h8).isBlack());

    
    //Test Knights
    assertEquals(IPiece.PieceKind.KNIGHT, instance.getPiece(b1).getKind());
    assertTrue(instance.getPiece(b1).isWhite());
    assertEquals(IPiece.PieceKind.KNIGHT, instance.getPiece(g1).getKind());
    assertTrue(instance.getPiece(g1).isWhite());
    assertEquals(IPiece.PieceKind.KNIGHT, instance.getPiece(b8).getKind());
    assertTrue(instance.getPiece(b8).isBlack());
    assertEquals(IPiece.PieceKind.KNIGHT, instance.getPiece(g8).getKind());
    assertTrue(instance.getPiece(g8).isBlack());

    
    //Test Bishops
    assertEquals(IPiece.PieceKind.BISHOP, instance.getPiece(c1).getKind());
    assertTrue(instance.getPiece(c1).isWhite());
    assertEquals(IPiece.PieceKind.BISHOP, instance.getPiece(f1).getKind());
    assertTrue(instance.getPiece(f1).isWhite());
    assertEquals(IPiece.PieceKind.BISHOP, instance.getPiece(c8).getKind());
    assertTrue(instance.getPiece(c8).isBlack());
    assertEquals(IPiece.PieceKind.BISHOP, instance.getPiece(f8).getKind());
    assertTrue(instance.getPiece(f8).isBlack());

    
    //Test Queens
    assertEquals(IPiece.PieceKind.QUEEN, instance.getPiece(d1).getKind());
    assertTrue(instance.getPiece(d1).isWhite());
    assertEquals(IPiece.PieceKind.QUEEN, instance.getPiece(d8).getKind());
    assertTrue(instance.getPiece(d8).isBlack());
    
    //Test Kings
    assertEquals(IPiece.PieceKind.KING, instance.getPiece(e1).getKind());
    assertTrue(instance.getPiece(e1).isWhite());
    assertEquals(IPiece.PieceKind.KING, instance.getPiece(e8).getKind());
    assertTrue(instance.getPiece(e8).isBlack());
    
    //Empty Squares - Todo: remove quares when more pieces will be added   
    assertTrue(instance.getPiece(a3) == null);
    assertTrue(instance.getPiece(b3) == null);
    assertTrue(instance.getPiece(c3) == null);
    assertTrue(instance.getPiece(d3) == null);
    assertTrue(instance.getPiece(e3) == null);
    assertTrue(instance.getPiece(f3) == null);
    assertTrue(instance.getPiece(g3) == null);
    assertTrue(instance.getPiece(h3) == null);

    assertTrue(instance.getPiece(a4) == null);
    assertTrue(instance.getPiece(b4) == null);
    assertTrue(instance.getPiece(c4) == null);
    assertTrue(instance.getPiece(d4) == null);
    assertTrue(instance.getPiece(e4) == null);
    assertTrue(instance.getPiece(f4) == null);
    assertTrue(instance.getPiece(g4) == null);
    assertTrue(instance.getPiece(h4) == null);

    assertTrue(instance.getPiece(a5) == null);
    assertTrue(instance.getPiece(b5) == null);
    assertTrue(instance.getPiece(c5) == null);
    assertTrue(instance.getPiece(d5) == null);
    assertTrue(instance.getPiece(e5) == null);
    assertTrue(instance.getPiece(f5) == null);
    assertTrue(instance.getPiece(g5) == null);
    assertTrue(instance.getPiece(h5) == null);

    assertTrue(instance.getPiece(a6) == null);
    assertTrue(instance.getPiece(b6) == null);
    assertTrue(instance.getPiece(c6) == null);
    assertTrue(instance.getPiece(d6) == null);
    assertTrue(instance.getPiece(e6) == null);
    assertTrue(instance.getPiece(f6) == null);
    assertTrue(instance.getPiece(g6) == null);
    assertTrue(instance.getPiece(h6) == null);    
  }

  /**
   * Test of isSquareRayed method, of class Position.
   */
  @Test
  public void testIsSquareRayed() 
  {
    System.out.println("isSquareRayed");
    
    Position instance = new Position();
    instance.set();
    
    IColor attackingColor = ChessColor.getInstance().getWhite();
        
    ISquare[] result;
    ISquare attacked = c4;
    ISquare[] expcResult = new ISquare[0];
    result = instance.isSquareRayed(attacked, attackingColor);
    assertTrue(instance.getPiece(attacked) == null);
    assertTrue(result.length==0);
        
    attacked = b3;
    expcResult = new ISquare[2];
    expcResult[0] = a2;
    expcResult[1] = c2;
    result = instance.isSquareRayed(attacked, attackingColor);
    assertTrue(instance.getPiece(attacked) == null);
    assertArrayEquals(expcResult, result);
    
    
    attackingColor = ChessColor.getInstance().getBlack();
        
    attacked = h4;
    expcResult = new ISquare[0];
    result = instance.isSquareRayed(attacked, attackingColor);
    assertTrue(instance.getPiece(attacked) == null);
    assertTrue(result.length==0);
    
    attacked = e6;
    expcResult = new ISquare[2];
    expcResult[0] = d7;
    expcResult[1] = f7;
    result = instance.isSquareRayed(attacked, attackingColor);
    assertTrue(instance.getPiece(attacked) == null);
    assertArrayEquals(expcResult, result);    
  }

  /**
   * Test of isMate method, of class Position.
   */
  @Test
  public void testIsMate() throws Exception
  {
    System.out.println("isMate");

    boolean result;
    boolean expcResult;    
    IPosition pos = new Position();
    pos.set();
    
    expcResult = false;
    result = pos.isMate();
    assertEquals(expcResult, result);
    
    pos = pos.move(e2, e4);
    expcResult = false;
    result = pos.isMate();
    assertEquals(expcResult, result);

    pos = pos.move(e7, e5);
    expcResult = false;
    result = pos.isMate();
    assertEquals(expcResult, result);

    pos = pos.move(f1, c4);
    expcResult = false;
    result = pos.isMate();
    assertEquals(expcResult, result);

    pos = pos.move(b8, c6);
    expcResult = false;
    result = pos.isMate();
    assertEquals(expcResult, result);
        
    pos = pos.move(d1, h5);
    expcResult = false;
    result = pos.isMate();
    assertEquals(expcResult, result);
    
    pos = pos.move(g8, f6);
    expcResult = false;
    result = pos.isMate();
    assertEquals(expcResult, result);
    
    //Fools mate
    pos = pos.move(h5, f7);
    expcResult = true;
    result = pos.isMate();
    assertEquals(expcResult, result);
    
    //And now to the fewest moves possible checkmate.
    pos = new Position();
    pos.set();
    pos = pos.move(f2, f3);
    pos = pos.move(e7, e5);
    pos = pos.move(g2, g4); 
    pos = pos.move(d8, h4);
    expcResult = true;
    result = pos.isMate();
    assertEquals(expcResult, result);
    
    //Check but not mate
    pos = new Position();
    pos.set();
    pos = pos.move(f2, f3);
    pos = pos.move(e7, e5);
    pos = pos.move(h2, h3); 
    pos = pos.move(d8, h4);
    expcResult = false;
    result = pos.isMate();
    assertEquals(expcResult, result);
    
    pos = pos.move(g2, g3); 
    pos = pos.move(h4, g3); //Now its mate!
    expcResult = true;
    result = pos.isMate();
    assertEquals(expcResult, result);
  }

  /**
   * Test of isStalemate method, of class Position.
   */
  @Test
  public void testIsStalemate() throws Exception
  {
    System.out.println("isStalemate");

    boolean result;
    boolean expcResult;    
    IPosition pos = new Position();
    pos.set();
    
    expcResult = false;
    result = pos.isStalemate();
    assertEquals(expcResult, result);
   
    ISquarePiece[] pieceList = new ISquarePiece[3];
    pieceList[0] = new SquarePiece(e6,PieceBox.getInstance().createWhiteKing());
    pieceList[1] = new SquarePiece(e8,PieceBox.getInstance().createBlackKing());
    pieceList[2] = new SquarePiece(e7,PieceBox.getInstance().createWhitePawn());
    pos = new PuzzlePosition();
    ((PuzzlePosition)pos).set(pieceList,
                              ChessColor.getInstance().getBlack(),
                              false,false,false,false,
                              null,
                              1,1);
    expcResult = true;
    result = pos.isStalemate();
    assertEquals(expcResult, result);

    pieceList = new ISquarePiece[3];
    pieceList[0] = new SquarePiece(e6,PieceBox.getInstance().createWhiteKing());
    pieceList[1] = new SquarePiece(e8,PieceBox.getInstance().createBlackKing());
    pieceList[2] = new SquarePiece(e7,PieceBox.getInstance().createWhiteQueen());
    pos = new PuzzlePosition();
    ((PuzzlePosition)pos).set(pieceList,
                              ChessColor.getInstance().getBlack(),
                              false,false,false,false,
                              null,
                              0,1); //mate position
    expcResult = false;
    result = pos.isStalemate();
    assertEquals(expcResult, result);    
  }
  
  /**
   * Test of protected_isCheck method, of class Position.
   */
  @Test
  public void testIsChecked1() 
  {
    System.out.println("protected_isCheck");
    
    MockedPosition pos = new MockedPosition();
    pos.addPiece(c2, PieceBox.getInstance().createWhiteKing());
    pos.addPiece(c6, PieceBox.getInstance().createBlackKing());
    pos.addPiece(d5, PieceBox.getInstance().createWhitePawn());
    boolean result = pos.mockIsCheck(m_chessColor.getBlack());
    assertTrue(result);
    
    pos = new MockedPosition();
    pos.addPiece(c2, PieceBox.getInstance().createWhiteKing());
    pos.addPiece(d6, PieceBox.getInstance().createBlackKing());
    pos.addPiece(d5, PieceBox.getInstance().createWhitePawn());
    result = pos.mockIsCheck(m_chessColor.getBlack());
    assertFalse(result);
    
    pos = new MockedPosition();
    pos.addPiece(d2, PieceBox.getInstance().createWhiteKing());
    pos.addPiece(h8, PieceBox.getInstance().createBlackKing());
    pos.addPiece(d4, PieceBox.getInstance().createWhiteBishop());
    pos.addPiece(f8, PieceBox.getInstance().createBlackBishop());
    pos.addPiece(g8, PieceBox.getInstance().createBlackBishop());
    pos.addPiece(h7, PieceBox.getInstance().createBlackPawn());
    result = pos.mockIsCheck(m_chessColor.getBlack());
    assertTrue(result);    

    pos = new MockedPosition();
    pos.addPiece(d2, PieceBox.getInstance().createWhiteKing());
    pos.addPiece(h8, PieceBox.getInstance().createBlackKing());
    pos.addPiece(d4, PieceBox.getInstance().createWhiteBishop());
    pos.addPiece(f8, PieceBox.getInstance().createBlackBishop());
    pos.addPiece(g8, PieceBox.getInstance().createBlackBishop());
    pos.addPiece(h7, PieceBox.getInstance().createBlackPawn());
    result = pos.mockIsCheck(m_chessColor.getWhite());
    assertFalse(result);    

    pos = new MockedPosition();
    pos.addPiece(d6, PieceBox.getInstance().createWhiteKing());
    pos.addPiece(g7, PieceBox.getInstance().createBlackKing());
    pos.addPiece(b6, PieceBox.getInstance().createWhiteBishop());
    pos.addPiece(f5, PieceBox.getInstance().createWhiteBishop());
    pos.addPiece(h4, PieceBox.getInstance().createWhiteRook());
    pos.addPiece(d3, PieceBox.getInstance().createBlackRook());
    result = pos.mockIsCheck(m_chessColor.getWhite());
    assertTrue(result);    

    pos = new MockedPosition();
    pos.addPiece(d6, PieceBox.getInstance().createWhiteKing());
    pos.addPiece(g7, PieceBox.getInstance().createBlackKing());
    pos.addPiece(b6, PieceBox.getInstance().createWhiteBishop());
    pos.addPiece(f5, PieceBox.getInstance().createWhiteBishop());
    pos.addPiece(h4, PieceBox.getInstance().createWhiteRook());
    pos.addPiece(d5, PieceBox.getInstance().createWhiteKnight());
    pos.addPiece(d3, PieceBox.getInstance().createBlackRook());
    result = pos.mockIsCheck(m_chessColor.getWhite());
    assertFalse(result);    
    
  }
  
  private class TestPromotionListener implements IPromotionListener
  {

    public IPromotionListener.PromoteToPieceKind m_promotionKind;
    
    public TestPromotionListener()
    {
      m_promotionKind = IPromotionListener.PromoteToPieceKind.ROOK;      
    }
    
    @Override
    public PromoteToPieceKind getPiece(PromotionEvent e) 
    {
      return m_promotionKind;      
    }

    
  }
  
  //=====================================
  public static class MockedPosition extends Position
  {

    private boolean[] m_castle;
    private ISquare m_epSq;
    
    public MockedPosition()
    {
      super();
      m_castle = new boolean[4]; 
      m_epSq = null;
    }
    
    public void addPiece(ISquare p_sq, IPiece p_piece)
    {
      putPiece(p_sq, p_piece);
    }
    
    public void clearSquare(ISquare p_sq)
    {
      putPiece(p_sq, null);
    }
    
    public void setCastleFlags(boolean p_00w,
                               boolean p_000w,
                               boolean p_00b,
                               boolean p_000b)
    {
      m_castle[0] = p_00w;
      m_castle[1] = p_000w;
      m_castle[2] = p_00b;
      m_castle[3] = p_000b;
    }
    
    public void mockEnpassant(ISquare p_epSq)
    {
      m_epSq = p_epSq;
    }
    
    @Override
    public ISquare getEnpassant()
    {
      return m_epSq;
    }

    @Override
    public boolean isWhite00() 
    {
      return m_castle[0];
    }

    @Override
    public boolean isWhite000() 
    {
      return m_castle[1];
    }

    @Override
    public boolean isBlack00() 
    {
      return m_castle[2];
    }

    @Override
    public boolean isBlack000() 
    {
      return m_castle[3];
    }
    
    //Wrap the protected isCheck method
    public boolean mockIsCheck(IColor p_kingColor)
    {
      return isCheck(this,p_kingColor);
    }
  }
  
  
  //=====================================
}
