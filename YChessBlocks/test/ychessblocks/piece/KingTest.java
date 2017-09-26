/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ychessblocks.piece;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import ychessblocks.board.Board;
import ychessblocks.board.IBoard;
import ychessblocks.board.ChessColor;
import ychessblocks.board.IFile;
import ychessblocks.board.IRank;
import ychessblocks.board.ISquare;
import ychessblocks.position.IPosition;
import ychessblocks.position.ISquarePiece;
import ychessblocks.position.PositionTest.MockedPosition;
import ychessblocks.position.SquarePiece;
import ychessblocks.position.PuzzlePosition;

/**
 *
 * @author Yair
 */
public class KingTest
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

  public KingTest() {
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
   * Test of trySlide method, of class WhiteKing.
   */
  @Test
  public void testWhiteKingTrySlide()
  {
    System.out.println("trySlide white king");

    MockedPosition pos;
    WhiteKing whiteK;
    boolean result;
    
    pos = new MockedPosition();
    whiteK = (WhiteKing)(PieceBox.getInstance().createWhiteKing());
    
    result = whiteK.trySlide(c3, c4, pos);
    assertTrue(result);
    result = whiteK.trySlide(c3, d4, pos);
    assertTrue(result);
    result = whiteK.trySlide(c3, d3, pos);
    assertTrue(result);
    result = whiteK.trySlide(c3, d2, pos);
    assertTrue(result);
    result = whiteK.trySlide(c3, c2, pos);
    assertTrue(result);
    result = whiteK.trySlide(c3, b2, pos);
    assertTrue(result);
    result = whiteK.trySlide(c3, b3, pos);
    assertTrue(result);
    result = whiteK.trySlide(c3, b4, pos);
    assertTrue(result);

    result = whiteK.trySlide(c3, c3, pos);
    assertFalse(result);   
    result = whiteK.trySlide(c3, c5, pos);
    assertFalse(result);   
    result = whiteK.trySlide(c3, e5, pos);
    assertFalse(result);   
    result = whiteK.trySlide(c3, e2, pos);
    assertFalse(result);   
    result = whiteK.trySlide(c3, e1, pos);
    assertFalse(result);   
    result = whiteK.trySlide(c3, c1, pos);
    assertFalse(result);   
    result = whiteK.trySlide(c3, a1, pos);
    assertFalse(result);   
    result = whiteK.trySlide(c3, a3, pos);
    assertFalse(result);   
    result = whiteK.trySlide(c3, a5, pos);
    assertFalse(result);   
    result = whiteK.trySlide(c3, a2, pos);
    assertFalse(result);   
    result = whiteK.trySlide(c3, d6, pos);
    assertFalse(result);   
    
    pos = new MockedPosition();
    pos.addPiece(h2, PieceBox.getInstance().createWhitePawn());
    pos.addPiece(g2, PieceBox.getInstance().createBlackBishop());
    result = whiteK.trySlide(g1, h2, pos);
    assertFalse(result);   
    result = whiteK.trySlide(g1, g2, pos); //? Kg1xg2
    assertTrue(result);   

    //Test castling, 0-0
    pos = new MockedPosition();
    pos.addPiece(e1, whiteK);
    pos.setCastleFlags(true, true, true, true);
    result = whiteK.trySlide(e1, g1, pos);
    assertFalse(result);   

    pos = new MockedPosition();
    pos.addPiece(e1, whiteK);
    pos.addPiece(h1, PieceBox.getInstance().createWhiteRook());
    pos.addPiece(f1, PieceBox.getInstance().createWhiteQueen());
    pos.setCastleFlags(true, true, true, true);
    result = whiteK.trySlide(e1, g1, pos);
    assertFalse(result);   

    pos = new MockedPosition();
    pos.addPiece(e1, whiteK);
    pos.addPiece(h1, PieceBox.getInstance().createWhiteRook());
    pos.addPiece(f1, PieceBox.getInstance().createBlackBishop());
    pos.setCastleFlags(true, true, true, true);
    result = whiteK.trySlide(e1, g1, pos);
    assertFalse(result);   

    pos = new MockedPosition();
    pos.addPiece(e1, whiteK);
    pos.addPiece(h1, PieceBox.getInstance().createWhiteRook());
    pos.addPiece(g1, PieceBox.getInstance().createWhiteQueen());
    pos.setCastleFlags(true, true, true, true);
    result = whiteK.trySlide(e1, g1, pos);
    assertFalse(result);   

    pos = new MockedPosition();
    pos.addPiece(e1, whiteK);
    pos.addPiece(h1, PieceBox.getInstance().createWhiteRook());
    pos.addPiece(g1, PieceBox.getInstance().createBlackBishop());
    pos.setCastleFlags(true, true, true, true);
    result = whiteK.trySlide(e1, g1, pos);
    assertFalse(result);   
    

    pos = new MockedPosition();
    pos.addPiece(e1, whiteK);
    pos.addPiece(h1, PieceBox.getInstance().createWhiteRook());
    pos.addPiece(e4, PieceBox.getInstance().createBlackRook());
    pos.setCastleFlags(true, true, true, true);
    result = whiteK.trySlide(e1, g1, pos);
    assertFalse(result);   

    pos = new MockedPosition();
    pos.addPiece(e1, whiteK);
    pos.addPiece(h1, PieceBox.getInstance().createWhiteRook());
    pos.addPiece(a6, PieceBox.getInstance().createBlackBishop());
    pos.setCastleFlags(true, true, true, true);
    result = whiteK.trySlide(e1, g1, pos);
    assertFalse(result);   

    pos = new MockedPosition();
    pos.addPiece(e1, whiteK);
    pos.addPiece(h1, PieceBox.getInstance().createWhiteRook());
    pos.addPiece(h2, PieceBox.getInstance().createBlackPawn());
    pos.setCastleFlags(true, true, true, true);
    result = whiteK.trySlide(e1, g1, pos);
    assertFalse(result);   

    pos = new MockedPosition();
    pos.addPiece(e1, whiteK);
    pos.addPiece(h1, PieceBox.getInstance().createWhiteRook());
    pos.addPiece(f2, PieceBox.getInstance().createWhitePawn());
    pos.addPiece(g2, PieceBox.getInstance().createWhitePawn());
    pos.addPiece(h2, PieceBox.getInstance().createWhitePawn());
    pos.addPiece(g3, PieceBox.getInstance().createBlackQueen());
    pos.setCastleFlags(false, true, true, true);
    result = whiteK.trySlide(e1, g1, pos);
    assertFalse(result);   

    pos = new MockedPosition();
    pos.addPiece(e1, whiteK);
    pos.addPiece(h1, PieceBox.getInstance().createWhiteRook());
    pos.addPiece(f2, PieceBox.getInstance().createWhitePawn());
    pos.addPiece(g2, PieceBox.getInstance().createWhitePawn());
    pos.addPiece(h2, PieceBox.getInstance().createWhitePawn());
    pos.addPiece(g3, PieceBox.getInstance().createBlackQueen());
    pos.setCastleFlags(true, true, true, true);
    result = whiteK.trySlide(e1, g1, pos);
    assertTrue(result);   

    //Test castling, 0-0-0
    pos = new MockedPosition();
    pos.addPiece(e1, whiteK);
    pos.setCastleFlags(true, true, true, true);
    result = whiteK.trySlide(e1, c1, pos);
    assertFalse(result);   

    pos = new MockedPosition();
    pos.addPiece(e1, whiteK);
    pos.addPiece(a1, PieceBox.getInstance().createWhiteRook());
    pos.addPiece(d1, PieceBox.getInstance().createWhiteQueen());
    pos.setCastleFlags(true, true, true, true);
    result = whiteK.trySlide(e1, c1, pos);
    assertFalse(result);   

    pos = new MockedPosition();
    pos.addPiece(e1, whiteK);
    pos.addPiece(a1, PieceBox.getInstance().createWhiteRook());
    pos.addPiece(d1, PieceBox.getInstance().createBlackBishop());
    pos.setCastleFlags(true, true, true, true);
    result = whiteK.trySlide(e1, c1, pos);
    assertFalse(result);   

    pos = new MockedPosition();
    pos.addPiece(e1, whiteK);
    pos.addPiece(a1, PieceBox.getInstance().createWhiteRook());
    pos.addPiece(c1, PieceBox.getInstance().createWhiteQueen());
    pos.setCastleFlags(true, true, true, true);
    result = whiteK.trySlide(e1, c1, pos);
    assertFalse(result);   

    pos = new MockedPosition();
    pos.addPiece(e1, whiteK);
    pos.addPiece(a1, PieceBox.getInstance().createWhiteRook());
    pos.addPiece(c1, PieceBox.getInstance().createBlackBishop());
    pos.setCastleFlags(true, true, true, true);
    result = whiteK.trySlide(e1, c1, pos);
    assertFalse(result);   
    

    pos = new MockedPosition();
    pos.addPiece(e1, whiteK);
    pos.addPiece(a1, PieceBox.getInstance().createWhiteRook());
    pos.addPiece(e4, PieceBox.getInstance().createBlackRook());
    pos.setCastleFlags(true, true, true, true);
    result = whiteK.trySlide(e1, c1, pos);
    assertFalse(result);   

    pos = new MockedPosition();
    pos.addPiece(e1, whiteK);
    pos.addPiece(a1, PieceBox.getInstance().createWhiteRook());
    pos.addPiece(g5, PieceBox.getInstance().createBlackBishop());
    pos.setCastleFlags(true, true, true, true);
    result = whiteK.trySlide(e1, c1, pos);
    assertFalse(result);   

    pos = new MockedPosition();
    pos.addPiece(e1, whiteK);
    pos.addPiece(a1, PieceBox.getInstance().createWhiteRook());
    pos.addPiece(b2, PieceBox.getInstance().createBlackPawn());
    pos.setCastleFlags(true, true, true, true);
    result = whiteK.trySlide(e1, c1, pos);
    assertFalse(result);   

    pos = new MockedPosition();
    pos.addPiece(e1, whiteK);
    pos.addPiece(a1, PieceBox.getInstance().createWhiteRook());
    pos.addPiece(c2, PieceBox.getInstance().createWhitePawn());
    pos.addPiece(b2, PieceBox.getInstance().createWhitePawn());
    pos.addPiece(a2, PieceBox.getInstance().createWhitePawn());
    pos.addPiece(c4, PieceBox.getInstance().createBlackQueen());
    pos.setCastleFlags(true, false, true, true);
    result = whiteK.trySlide(e1, c1, pos);
    assertFalse(result);   

    pos = new MockedPosition();
    pos.addPiece(e1, whiteK);
    pos.addPiece(a1, PieceBox.getInstance().createWhiteRook());
    pos.addPiece(c2, PieceBox.getInstance().createWhitePawn());
    pos.addPiece(b2, PieceBox.getInstance().createWhitePawn());
    pos.addPiece(a2, PieceBox.getInstance().createWhitePawn());
    pos.addPiece(c4, PieceBox.getInstance().createBlackQueen());
    pos.setCastleFlags(true, true, true, true);
    result = whiteK.trySlide(e1, c1, pos);
    assertTrue(result);   
    
  }

  /**
   * Test of trySlide method, of class BlackKing.
   */
  @Test
  public void testBlackKingTrySlide()
  {
    System.out.println("trySlide black king");

    MockedPosition pos;
    BlackKing blackK;
    boolean result;
    
    pos = new MockedPosition();
    blackK = (BlackKing)(PieceBox.getInstance().createBlackKing());
    
    result = blackK.trySlide(b5, b6, pos);
    assertTrue(result);
    result = blackK.trySlide(b5, c6, pos);
    assertTrue(result);
    result = blackK.trySlide(b5, c5, pos);
    assertTrue(result);
    result = blackK.trySlide(b5, c4, pos);
    assertTrue(result);
    result = blackK.trySlide(b5, b4, pos);
    assertTrue(result);
    result = blackK.trySlide(b5, a4, pos);
    assertTrue(result);
    result = blackK.trySlide(b5, a5, pos);
    assertTrue(result);
    result = blackK.trySlide(b5, a6, pos);
    assertTrue(result);

    result = blackK.trySlide(b5, b5, pos);
    assertFalse(result);   
    result = blackK.trySlide(b5, b7, pos);
    assertFalse(result);   
    result = blackK.trySlide(b5, d7, pos);
    assertFalse(result);   
    result = blackK.trySlide(b5, d5, pos);
    assertFalse(result);   
    result = blackK.trySlide(b5, d3, pos);
    assertFalse(result);   
    result = blackK.trySlide(b5, b3, pos);
    assertFalse(result);   
    result = blackK.trySlide(b5, a3, pos);
    assertFalse(result);   
    result = blackK.trySlide(b5, g6, pos);
    assertFalse(result);   
    result = blackK.trySlide(c3, a2, pos);
    assertFalse(result);   
    result = blackK.trySlide(c3, d6, pos);
    assertFalse(result);   
    
    pos = new MockedPosition();
    pos.addPiece(h7, PieceBox.getInstance().createBlackPawn());
    pos.addPiece(g7, PieceBox.getInstance().createWhiteBishop());
    result = blackK.trySlide(g8, h7, pos);
    assertFalse(result);   
    result = blackK.trySlide(g8, g7, pos); //? Kg8xg7
    assertTrue(result);   

    //Test castling, 0-0
    pos = new MockedPosition();
    pos.addPiece(e8, blackK);
    pos.setCastleFlags(true, true, true, true);
    result = blackK.trySlide(e8, g8, pos);
    assertFalse(result);   

    pos = new MockedPosition();
    pos.addPiece(e8, blackK);
    pos.addPiece(h8, PieceBox.getInstance().createBlackRook());
    pos.addPiece(f8, PieceBox.getInstance().createBlackQueen());
    pos.setCastleFlags(true, true, true, true);
    result = blackK.trySlide(e8, g8, pos);
    assertFalse(result);   

    pos = new MockedPosition();
    pos.addPiece(e8, blackK);
    pos.addPiece(h8, PieceBox.getInstance().createBlackRook());
    pos.addPiece(f8, PieceBox.getInstance().createWhiteBishop());
    pos.setCastleFlags(true, true, true, true);
    result = blackK.trySlide(e8, g8, pos);
    assertFalse(result);   

    pos = new MockedPosition();
    pos.addPiece(e8, blackK);
    pos.addPiece(h8, PieceBox.getInstance().createBlackRook());
    pos.addPiece(g8, PieceBox.getInstance().createBlackQueen());
    pos.setCastleFlags(true, true, true, true);
    result = blackK.trySlide(e8, g8, pos);
    assertFalse(result);   

    pos = new MockedPosition();
    pos.addPiece(e8, blackK);
    pos.addPiece(h8, PieceBox.getInstance().createBlackRook());
    pos.addPiece(g8, PieceBox.getInstance().createWhiteBishop());
    pos.setCastleFlags(true, true, true, true);
    result = blackK.trySlide(e8, g8, pos);
    assertFalse(result);   
    

    pos = new MockedPosition();
    pos.addPiece(e8, blackK);
    pos.addPiece(h8, PieceBox.getInstance().createBlackRook());
    pos.addPiece(e4, PieceBox.getInstance().createWhiteRook());
    pos.setCastleFlags(true, true, true, true);
    result = blackK.trySlide(e8, g8, pos);
    assertFalse(result);   

    pos = new MockedPosition();
    pos.addPiece(e8, blackK);
    pos.addPiece(h8, PieceBox.getInstance().createBlackRook());
    pos.addPiece(b4, PieceBox.getInstance().createWhiteBishop());
    pos.setCastleFlags(true, true, true, true);
    result = blackK.trySlide(e8, g8, pos);
    assertFalse(result);   

    pos = new MockedPosition();
    pos.addPiece(e8, blackK);
    pos.addPiece(h8, PieceBox.getInstance().createBlackRook());
    pos.addPiece(h7, PieceBox.getInstance().createWhitePawn());
    pos.setCastleFlags(true, true, true, true);
    result = blackK.trySlide(e8, g8, pos);
    assertFalse(result);   

    pos = new MockedPosition();
    pos.addPiece(e8, blackK);
    pos.addPiece(h8, PieceBox.getInstance().createBlackRook());
    pos.addPiece(f7, PieceBox.getInstance().createBlackPawn());
    pos.addPiece(g7, PieceBox.getInstance().createBlackPawn());
    pos.addPiece(h7, PieceBox.getInstance().createBlackPawn());
    pos.addPiece(g6, PieceBox.getInstance().createWhiteQueen());
    pos.setCastleFlags(true, true, false, true);
    result = blackK.trySlide(e8, g8, pos);
    assertFalse(result);   

    pos = new MockedPosition();
    pos.addPiece(e8, blackK);
    pos.addPiece(h8, PieceBox.getInstance().createBlackRook());
    pos.addPiece(f7, PieceBox.getInstance().createBlackPawn());
    pos.addPiece(g7, PieceBox.getInstance().createBlackPawn());
    pos.addPiece(h7, PieceBox.getInstance().createBlackPawn());
    pos.addPiece(g6, PieceBox.getInstance().createWhiteQueen());
    pos.setCastleFlags(true, true, true, true);
    result = blackK.trySlide(e8, g8, pos);
    assertTrue(result);   

    //Test castling, 0-0-0
    pos = new MockedPosition();
    pos.addPiece(e8, blackK);
    pos.setCastleFlags(true, true, true, true);
    result = blackK.trySlide(e8, c8, pos);
    assertFalse(result);   

    pos = new MockedPosition();
    pos.addPiece(e8, blackK);
    pos.addPiece(a8, PieceBox.getInstance().createBlackRook());
    pos.addPiece(d8, PieceBox.getInstance().createBlackQueen());
    pos.setCastleFlags(true, true, true, true);
    result = blackK.trySlide(e8, c8, pos);
    assertFalse(result);   

    pos = new MockedPosition();
    pos.addPiece(e8, blackK);
    pos.addPiece(a8, PieceBox.getInstance().createBlackRook());
    pos.addPiece(d8, PieceBox.getInstance().createWhiteBishop());
    pos.setCastleFlags(true, true, true, true);
    result = blackK.trySlide(e8, c8, pos);
    assertFalse(result);   

    pos = new MockedPosition();
    pos.addPiece(e8, blackK);
    pos.addPiece(a8, PieceBox.getInstance().createBlackRook());
    pos.addPiece(c8, PieceBox.getInstance().createBlackQueen());
    pos.setCastleFlags(true, true, true, true);
    result = blackK.trySlide(e8, c8, pos);
    assertFalse(result);   

    pos = new MockedPosition();
    pos.addPiece(e8, blackK);
    pos.addPiece(a8, PieceBox.getInstance().createBlackRook());
    pos.addPiece(c8, PieceBox.getInstance().createWhiteBishop());
    pos.setCastleFlags(true, true, true, true);
    result = blackK.trySlide(e8, c8, pos);
    assertFalse(result);   
    

    pos = new MockedPosition();
    pos.addPiece(e8, blackK);
    pos.addPiece(a8, PieceBox.getInstance().createBlackRook());
    pos.addPiece(e4, PieceBox.getInstance().createWhiteRook());
    pos.setCastleFlags(true, true, true, true);
    result = blackK.trySlide(e8, c8, pos);
    assertFalse(result);   

    pos = new MockedPosition();
    pos.addPiece(e8, blackK);
    pos.addPiece(a8, PieceBox.getInstance().createBlackRook());
    pos.addPiece(f5, PieceBox.getInstance().createWhiteBishop());
    pos.setCastleFlags(true, true, true, true);
    result = blackK.trySlide(e8, c8, pos);
    assertFalse(result);   

    pos = new MockedPosition();
    pos.addPiece(e8, blackK);
    pos.addPiece(a8, PieceBox.getInstance().createBlackRook());
    pos.addPiece(b7, PieceBox.getInstance().createWhitePawn());
    pos.setCastleFlags(true, true, true, true);
    result = blackK.trySlide(e8, c8, pos);
    assertFalse(result);   

    pos = new MockedPosition();
    pos.addPiece(e8, blackK);
    pos.addPiece(a8, PieceBox.getInstance().createBlackRook());
    pos.addPiece(c7, PieceBox.getInstance().createBlackPawn());
    pos.addPiece(b7, PieceBox.getInstance().createBlackPawn());
    pos.addPiece(a7, PieceBox.getInstance().createBlackPawn());
    pos.addPiece(c4, PieceBox.getInstance().createWhiteQueen());
    pos.setCastleFlags(true, true, true, false);
    result = blackK.trySlide(e8, c8, pos);
    assertFalse(result);   

    pos = new MockedPosition();
    pos.addPiece(e8, blackK);
    pos.addPiece(a8, PieceBox.getInstance().createBlackRook());
    pos.addPiece(c7, PieceBox.getInstance().createBlackPawn());
    pos.addPiece(b7, PieceBox.getInstance().createBlackPawn());
    pos.addPiece(a7, PieceBox.getInstance().createBlackPawn());
    pos.addPiece(c4, PieceBox.getInstance().createWhiteQueen());
    pos.setCastleFlags(true, true, true, true);
    result = blackK.trySlide(e8, c8, pos);
    assertTrue(result);   
  }

   /**
   * Test of generateSlides method, of class King.
   */
  @Test
  public void testGenerateSlides() throws Exception
  {
    System.out.println("King generateSlides");    
    
    IPosition pzl;
    ISquare[] slides;
    IPiece king;
    
    ISquarePiece[] pieceList = new ISquarePiece[2];
    pieceList[0] = new SquarePiece(e4,PieceBox.getInstance().createWhiteKing());
    pieceList[1] = new SquarePiece(e8,PieceBox.getInstance().createBlackKing());
    pzl = new PuzzlePosition();
    ((PuzzlePosition)pzl).set(pieceList,
                              ChessColor.getInstance().getWhite(),
                              false,false,false,false,
                              null,
                              0,1);
    king = pzl.getPiece(e4);
    
    slides = king.generateSlides(e4, pzl);
    assertFalse(slides == null);   
    assertTrue(slides.length == 8);   
    assertTrue(squareFound(slides,e5));       
    assertTrue(squareFound(slides,d5));       
    assertTrue(squareFound(slides,d4));       
    assertTrue(squareFound(slides,d3));       
    assertTrue(squareFound(slides,e3));       
    assertTrue(squareFound(slides,f3));       
    assertTrue(squareFound(slides,f4));       
    assertTrue(squareFound(slides,f5));           
    
    
    pieceList = new ISquarePiece[3];
    pieceList[0] = new SquarePiece(e1,PieceBox.getInstance().createWhiteKing());
    pieceList[1] = new SquarePiece(h8,PieceBox.getInstance().createBlackKing());
    pieceList[2] = new SquarePiece(h7,PieceBox.getInstance().createBlackPawn());
    pzl = new PuzzlePosition();
    ((PuzzlePosition)pzl).set(pieceList,
                              ChessColor.getInstance().getBlack(),
                              false,false,false,false,
                              null,
                              0,1);
    king = pzl.getPiece(h8);
    
    slides = king.generateSlides(h8, pzl);
    assertFalse(slides == null);   
    assertTrue(slides.length == 2);   
    assertTrue(squareFound(slides,g8));       
    assertTrue(squareFound(slides,g7));           
    
    pieceList = new ISquarePiece[3];
    pieceList[0] = new SquarePiece(e1,PieceBox.getInstance().createWhiteKing());
    pieceList[1] = new SquarePiece(h8,PieceBox.getInstance().createBlackKing());
    pieceList[2] = new SquarePiece(h7,PieceBox.getInstance().createWhitePawn());
    pzl = new PuzzlePosition();
    ((PuzzlePosition)pzl).set(pieceList,
                              ChessColor.getInstance().getBlack(),
                              false,false,false,false,
                              null,
                              0,1);
    king = pzl.getPiece(h8);
    
    slides = king.generateSlides(h8, pzl);
    assertFalse(slides == null);   
    assertTrue(slides.length == 3);   
    assertTrue(squareFound(slides,g8));       
    assertTrue(squareFound(slides,g7));           
    assertTrue(squareFound(slides,h7));           

    //White castles
    pieceList = new ISquarePiece[4];
    pieceList[0] = new SquarePiece(e1,PieceBox.getInstance().createWhiteKing());
    pieceList[1] = new SquarePiece(e8,PieceBox.getInstance().createBlackKing());
    pieceList[2] = new SquarePiece(h1,PieceBox.getInstance().createWhiteRook());
    pieceList[3] = new SquarePiece(a1,PieceBox.getInstance().createWhiteRook());
    pzl = new PuzzlePosition();
    ((PuzzlePosition)pzl).set(pieceList,
                              ChessColor.getInstance().getWhite(),
                              true,true,false,false,
                              null,
                              0,1);
    king = pzl.getPiece(e1);
    
    slides = king.generateSlides(e1, pzl);
    assertFalse(slides == null);   
    assertTrue(slides.length == 7);   
    assertTrue(squareFound(slides,f1));       
    assertTrue(squareFound(slides,f2));       
    assertTrue(squareFound(slides,e2));       
    assertTrue(squareFound(slides,d2));       
    assertTrue(squareFound(slides,d1));       
    assertTrue(squareFound(slides,g1));       
    assertTrue(squareFound(slides,c1));       

    pieceList = new ISquarePiece[5];
    pieceList[0] = new SquarePiece(e1,PieceBox.getInstance().createWhiteKing());
    pieceList[1] = new SquarePiece(e8,PieceBox.getInstance().createBlackKing());
    pieceList[2] = new SquarePiece(h1,PieceBox.getInstance().createWhiteRook());
    pieceList[3] = new SquarePiece(a1,PieceBox.getInstance().createWhiteRook());
    pieceList[4] = new SquarePiece(b1,PieceBox.getInstance().createWhiteKnight());
    pzl = new PuzzlePosition();
    ((PuzzlePosition)pzl).set(pieceList,
                              ChessColor.getInstance().getWhite(),
                              true,true,false,false,
                              null,
                              0,1);
    king = pzl.getPiece(e1);
    
    slides = king.generateSlides(e1, pzl);
    assertFalse(slides == null);   
    assertTrue(slides.length == 6);   
    assertTrue(squareFound(slides,f1));       
    assertTrue(squareFound(slides,f2));       
    assertTrue(squareFound(slides,e2));       
    assertTrue(squareFound(slides,d2));       
    assertTrue(squareFound(slides,d1));       
    assertTrue(squareFound(slides,g1));       

    pieceList = new ISquarePiece[5];
    pieceList[0] = new SquarePiece(e1,PieceBox.getInstance().createWhiteKing());
    pieceList[1] = new SquarePiece(e8,PieceBox.getInstance().createBlackKing());
    pieceList[2] = new SquarePiece(h1,PieceBox.getInstance().createWhiteRook());
    pieceList[3] = new SquarePiece(a1,PieceBox.getInstance().createWhiteRook());
    pieceList[4] = new SquarePiece(e6,PieceBox.getInstance().createBlackRook()); //Check
    pzl = new PuzzlePosition();
    ((PuzzlePosition)pzl).set(pieceList,
                              ChessColor.getInstance().getWhite(),
                              true,true,false,false,
                              null,
                              0,1);
    king = pzl.getPiece(e1);
    
    slides = king.generateSlides(e1, pzl);
    assertFalse(slides == null);   
    assertTrue(slides.length == 5);   
    assertTrue(squareFound(slides,f1));       
    assertTrue(squareFound(slides,f2));       
    assertTrue(squareFound(slides,e2));       
    assertTrue(squareFound(slides,d2));       
    assertTrue(squareFound(slides,d1));       

    pieceList = new ISquarePiece[5];
    pieceList[0] = new SquarePiece(e1,PieceBox.getInstance().createWhiteKing());
    pieceList[1] = new SquarePiece(e8,PieceBox.getInstance().createBlackKing());
    pieceList[2] = new SquarePiece(h1,PieceBox.getInstance().createWhiteRook());
    pieceList[3] = new SquarePiece(a1,PieceBox.getInstance().createWhiteRook());
    pieceList[4] = new SquarePiece(a6,PieceBox.getInstance().createBlackBishop()); //ray f1
    pzl = new PuzzlePosition();
    ((PuzzlePosition)pzl).set(pieceList,
                              ChessColor.getInstance().getWhite(),
                              true,true,false,false,
                              null,
                              0,1);
    king = pzl.getPiece(e1);
    
    slides = king.generateSlides(e1, pzl);
    assertFalse(slides == null);   
    assertTrue(slides.length == 6);   
    assertTrue(squareFound(slides,f1));       
    assertTrue(squareFound(slides,f2));       
    assertTrue(squareFound(slides,e2));       
    assertTrue(squareFound(slides,d2));       
    assertTrue(squareFound(slides,d1));       
    assertTrue(squareFound(slides,c1));       
    
    //Black castles
    pieceList = new ISquarePiece[4];
    pieceList[0] = new SquarePiece(e1,PieceBox.getInstance().createWhiteKing());
    pieceList[1] = new SquarePiece(e8,PieceBox.getInstance().createBlackKing());
    pieceList[2] = new SquarePiece(h8,PieceBox.getInstance().createBlackRook());
    pieceList[3] = new SquarePiece(a8,PieceBox.getInstance().createBlackRook());
    pzl = new PuzzlePosition();
    ((PuzzlePosition)pzl).set(pieceList,
                              ChessColor.getInstance().getBlack(),
                              false,false,true,true,
                              null,
                              0,1);
    king = pzl.getPiece(e8);
    
    slides = king.generateSlides(e8, pzl);
    assertFalse(slides == null);   
    assertTrue(slides.length == 7);   
    assertTrue(squareFound(slides,f8));       
    assertTrue(squareFound(slides,f7));       
    assertTrue(squareFound(slides,e7));       
    assertTrue(squareFound(slides,d8));       
    assertTrue(squareFound(slides,d7));       
    assertTrue(squareFound(slides,g8));       
    assertTrue(squareFound(slides,c8));       

    pieceList = new ISquarePiece[5];
    pieceList[0] = new SquarePiece(e1,PieceBox.getInstance().createWhiteKing());
    pieceList[1] = new SquarePiece(e8,PieceBox.getInstance().createBlackKing());
    pieceList[2] = new SquarePiece(h8,PieceBox.getInstance().createBlackRook());
    pieceList[3] = new SquarePiece(a8,PieceBox.getInstance().createBlackRook());
    pieceList[4] = new SquarePiece(b8,PieceBox.getInstance().createBlackKnight());
    pzl = new PuzzlePosition();
    ((PuzzlePosition)pzl).set(pieceList,
                              ChessColor.getInstance().getBlack(),
                              false,false,true,true,
                              null,
                              0,1);
    king = pzl.getPiece(e8);
    
    slides = king.generateSlides(e8, pzl);
    assertFalse(slides == null);   
    assertTrue(slides.length == 6);   
    assertTrue(squareFound(slides,f8));       
    assertTrue(squareFound(slides,f7));       
    assertTrue(squareFound(slides,e7));       
    assertTrue(squareFound(slides,d8));       
    assertTrue(squareFound(slides,d7));       
    assertTrue(squareFound(slides,g8));       

    pieceList = new ISquarePiece[5];
    pieceList[0] = new SquarePiece(e1,PieceBox.getInstance().createWhiteKing());
    pieceList[1] = new SquarePiece(e8,PieceBox.getInstance().createBlackKing());
    pieceList[2] = new SquarePiece(h8,PieceBox.getInstance().createBlackRook());
    pieceList[3] = new SquarePiece(a8,PieceBox.getInstance().createBlackRook());
    pieceList[4] = new SquarePiece(e2,PieceBox.getInstance().createWhiteQueen()); //Check
    pzl = new PuzzlePosition();
    ((PuzzlePosition)pzl).set(pieceList,
                              ChessColor.getInstance().getBlack(),
                              false,false,true,true,
                              null,
                              0,1);
    king = pzl.getPiece(e8);
    
    slides = king.generateSlides(e8, pzl);
    assertFalse(slides == null);   
    assertTrue(slides.length == 5);   
    assertTrue(squareFound(slides,f8));       
    assertTrue(squareFound(slides,f7));       
    assertTrue(squareFound(slides,e7));       
    assertTrue(squareFound(slides,d8));       
    assertTrue(squareFound(slides,d7));       

    pieceList = new ISquarePiece[4];
    pieceList[0] = new SquarePiece(e1,PieceBox.getInstance().createWhiteKing());
    pieceList[1] = new SquarePiece(e8,PieceBox.getInstance().createBlackKing());
    pieceList[2] = new SquarePiece(h8,PieceBox.getInstance().createBlackRook());
    pieceList[3] = new SquarePiece(a8,PieceBox.getInstance().createBlackRook());
    pzl = new PuzzlePosition();
    ((PuzzlePosition)pzl).set(pieceList,
                              ChessColor.getInstance().getBlack(),
                              false,false,false,true,
                              null,
                              0,1);
    king = pzl.getPiece(e8);
    
    slides = king.generateSlides(e8, pzl);
    assertFalse(slides == null);   
    assertTrue(slides.length == 6);   
    assertTrue(squareFound(slides,f8));       
    assertTrue(squareFound(slides,f7));       
    assertTrue(squareFound(slides,e7));       
    assertTrue(squareFound(slides,d8));       
    assertTrue(squareFound(slides,d7));       
    assertTrue(squareFound(slides,c8));          
  }
  
  private boolean squareFound(ISquare[] p_squares, ISquare p_square)
  {
    boolean rv = false;
    int i;
    
    for (i=0; i<p_squares.length && !rv; i++)
    {
      rv = p_squares[i].equals(p_square);
    }
    
    return rv;
  }
}
