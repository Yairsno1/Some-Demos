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
import ychessblocks.board.Board;
import ychessblocks.board.ChessColor;
import ychessblocks.board.IColor;
import ychessblocks.board.IFile;
import ychessblocks.board.IRank;
import ychessblocks.board.ISquare;
import ychessblocks.piece.IPieceBox;
import ychessblocks.piece.PieceBox;

/**
 *
 * @author Yair
 */
public class PuzzlePositionTest
{
  private static Board m_board;
  private static ChessColor m_chessColor;
  private IPieceBox m_pieceBox;
  
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
  
  public PuzzlePositionTest() {
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
    m_pieceBox = PieceBox.getInstance();
    
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
   * Test of set method, of class PuzzlePosition.
   */
  @Test
  public void testSet() throws Exception 
  {
    System.out.println("set");
        
    PuzzlePosition pzl;
    
    ISquarePiece[] pieceList = new ISquarePiece[30];
    int i = 0;
    
    //Timman - Tore, Tilburg '82 1-0
    //24th move, white to play
    //Kings
    pieceList[i++] = new SquarePiece(g1,m_pieceBox.createWhiteKing());
    pieceList[i++] = new SquarePiece(g8,m_pieceBox.createBlackKing());
    //Queens
    pieceList[i++] = new SquarePiece(d2,m_pieceBox.createWhiteQueen());
    pieceList[i++] = new SquarePiece(a7,m_pieceBox.createBlackQueen());
    //Rooks
    pieceList[i++] = new SquarePiece(e2,m_pieceBox.createWhiteRook());
    pieceList[i++] = new SquarePiece(c1,m_pieceBox.createWhiteRook());
    pieceList[i++] = new SquarePiece(a8,m_pieceBox.createBlackRook());
    pieceList[i++] = new SquarePiece(c4,m_pieceBox.createBlackRook());
    //Bishops
    pieceList[i++] = new SquarePiece(c2,m_pieceBox.createWhiteBishop());
    pieceList[i++] = new SquarePiece(c3,m_pieceBox.createWhiteBishop());
    pieceList[i++] = new SquarePiece(b6,m_pieceBox.createBlackBishop());
    pieceList[i++] = new SquarePiece(d7,m_pieceBox.createBlackBishop());    
    //Knights
    pieceList[i++] = new SquarePiece(f3,m_pieceBox.createWhiteKnight());
    pieceList[i++] = new SquarePiece(d3,m_pieceBox.createWhiteKnight());
    pieceList[i++] = new SquarePiece(f6,m_pieceBox.createBlackKnight());
    pieceList[i++] = new SquarePiece(a6,m_pieceBox.createBlackKnight());        
    //Pawns
    pieceList[i++] = new SquarePiece(h3,m_pieceBox.createWhitePawn());
    pieceList[i++] = new SquarePiece(g2,m_pieceBox.createWhitePawn());
    pieceList[i++] = new SquarePiece(f2,m_pieceBox.createWhitePawn());
    pieceList[i++] = new SquarePiece(e4,m_pieceBox.createWhitePawn());        
    pieceList[i++] = new SquarePiece(d5,m_pieceBox.createWhitePawn());
    pieceList[i++] = new SquarePiece(b2,m_pieceBox.createWhitePawn());
    pieceList[i++] = new SquarePiece(a3,m_pieceBox.createWhitePawn());
    pieceList[i++] = new SquarePiece(h7,m_pieceBox.createBlackPawn());
    pieceList[i++] = new SquarePiece(g7,m_pieceBox.createBlackPawn());
    pieceList[i++] = new SquarePiece(f7,m_pieceBox.createBlackPawn());
    pieceList[i++] = new SquarePiece(e5,m_pieceBox.createBlackPawn());        
    pieceList[i++] = new SquarePiece(d6,m_pieceBox.createBlackPawn());
    pieceList[i++] = new SquarePiece(b5,m_pieceBox.createBlackPawn());
    pieceList[i++] = new SquarePiece(a4,m_pieceBox.createBlackPawn());

    IColor p_activeColor = ChessColor.getInstance().getWhite();
    boolean p_white00 = false;
    boolean p_white000 = false;
    boolean p_black00 = false;
    boolean p_black000 = false;
    ISquare enPassant = null;
    int p_halfMoveClock = 0;
    int p_fullMoveNumber = 24;
    pzl = new PuzzlePosition();
    pzl.set(pieceList, p_activeColor, p_white00, p_white000, p_black00, p_black000, enPassant, p_halfMoveClock, p_fullMoveNumber);
    
    assertEquals(m_chessColor.getWhite(), pzl.getActiveColor());
    
    assertEquals(m_pieceBox.createWhitePawn(), pzl.getPiece(h3));
    assertEquals(m_pieceBox.createWhitePawn(), pzl.getPiece(g2));
    assertEquals(m_pieceBox.createWhitePawn(), pzl.getPiece(f2));
    assertEquals(m_pieceBox.createWhitePawn(), pzl.getPiece(e4));
    assertEquals(m_pieceBox.createWhitePawn(), pzl.getPiece(d5));
    assertEquals(m_pieceBox.createWhitePawn(), pzl.getPiece(b2));
    assertEquals(m_pieceBox.createWhitePawn(), pzl.getPiece(a3));
    assertEquals(m_pieceBox.createWhiteQueen(), pzl.getPiece(d2));
    assertEquals(m_pieceBox.createWhiteRook(), pzl.getPiece(e2));
    assertEquals(m_pieceBox.createWhiteRook(), pzl.getPiece(c1));
    assertEquals(m_pieceBox.createWhiteBishop(), pzl.getPiece(c2));
    assertEquals(m_pieceBox.createWhiteBishop(), pzl.getPiece(c3));
    assertEquals(m_pieceBox.createWhiteKnight(), pzl.getPiece(f3));
    assertEquals(m_pieceBox.createWhiteKnight(), pzl.getPiece(d3));    
    assertEquals(m_pieceBox.createWhiteKing(), pzl.getPiece(g1));
    
    //few empty squares
    assertTrue(pzl.getPiece(b8) == null);
    assertTrue(pzl.getPiece(a2) == null);
    assertTrue(pzl.getPiece(c5) == null);
    
    assertEquals(m_pieceBox.createBlackPawn(), pzl.getPiece(h7));
    assertEquals(m_pieceBox.createBlackPawn(), pzl.getPiece(g7));
    assertEquals(m_pieceBox.createBlackPawn(), pzl.getPiece(f7));
    assertEquals(m_pieceBox.createBlackPawn(), pzl.getPiece(e5));
    assertEquals(m_pieceBox.createBlackPawn(), pzl.getPiece(d6));
    assertEquals(m_pieceBox.createBlackPawn(), pzl.getPiece(b5));
    assertEquals(m_pieceBox.createBlackPawn(), pzl.getPiece(a4));
    assertEquals(m_pieceBox.createBlackQueen(), pzl.getPiece(a7));
    assertEquals(m_pieceBox.createBlackRook(), pzl.getPiece(a8));
    assertEquals(m_pieceBox.createBlackRook(), pzl.getPiece(c4));
    assertEquals(m_pieceBox.createBlackBishop(), pzl.getPiece(d7));
    assertEquals(m_pieceBox.createBlackBishop(), pzl.getPiece(b6));
    assertEquals(m_pieceBox.createBlackKnight(), pzl.getPiece(f6));
    assertEquals(m_pieceBox.createBlackKnight(), pzl.getPiece(a6));    
    assertEquals(m_pieceBox.createBlackKing(), pzl.getPiece(g8));
    
    //Now lets move some pieces around
    IPosition next;
    
    //24. Ndxe5 dxe
    next = pzl.move(d3, e5);
    assertTrue(next != null);
    assertTrue(next.getPiece(d3) == null);
    assertEquals(m_pieceBox.createWhiteKnight(), next.getPiece(e5));
    assertEquals(m_chessColor.getBlack(), next.getActiveColor());

    next = next.move(d6, e5);
    assertTrue(next != null);
    assertTrue(next.getPiece(d6) == null);
    assertEquals(m_pieceBox.createBlackPawn(), next.getPiece(e5));
    assertEquals(m_chessColor.getWhite(), next.getActiveColor());
      
    //25. Nxe5 Rcc8
    next = next.move(f3, e5);
    assertTrue(next != null);

    next = next.move(c4, c8);
    assertTrue(next != null);

    //26. Nc6! Bxc6
    next = next.move(e5, c6);
    assertTrue(next != null);

    next = next.move(d7, c6);
    assertTrue(next != null);

    //27. Bxf6 gxf
    next = next.move(c3, f6);
    assertTrue(next != null);

    next = next.move(g7, f6);
    assertTrue(next != null);
    
    //28. e5! f5
    next = next.move(e4, e5);
    assertTrue(next != null);

    next = next.move(f6, f5);
    assertTrue(next != null);

    //29. Qg5+ Kf8
    next = next.move(d2, g5);
    assertTrue(next != null);

    next = next.move(g8, f8);
    assertTrue(next != null);

    //30. Qh6+ Ke8
    next = next.move(g5, h6);
    assertTrue(next != null);

    next = next.move(f8, e8);
    assertTrue(next != null);

    //31. dxc Nc5
    next = next.move(d5, c6);
    assertTrue(next != null);

    next = next.move(a6, c5);
    assertTrue(next != null);

    //32. Bxf5 Ne6
    next = next.move(c2, f5);
    assertTrue(next != null);

    next = next.move(c5, e6);
    assertTrue(next != null);

    //33. Bxe6 fxe
    next = next.move(f5, e6);
    assertTrue(next != null);

    next = next.move(f7, e6);
    assertTrue(next != null);

    //34. c7! Rxc7
    next = next.move(c6, c7);
    assertTrue(next != null);

    next = next.move(c8, c7);
    assertTrue(next != null);

    //35. Qxe6+ Kf8
    next = next.move(h6, e6);
    assertTrue(next != null);

    next = next.move(e8, f8);
    assertTrue(next != null);

    //36. Rxc7 Bxc7
    next = next.move(c1, c7);
    assertTrue(next != null);

    next = next.move(b6, c7);
    assertTrue(next != null);

    //37. Re4 Qb6
    next = next.move(e2, e4);
    assertTrue(next != null);

    next = next.move(a7, b6);
    assertTrue(next != null);

    //38. Rf4+ Kg7
    next = next.move(e4, f4);
    assertTrue(next != null);

    next = next.move(f8, g7);
    assertTrue(next != null);

    //39. Qe7+ Kh8
    next = next.move(e6, e7);
    assertTrue(next != null);

    next = next.move(g7, h8);
    assertTrue(next != null);

    //40. Rf8+ Black Resigned
    next = next.move(f4, f8);
    assertTrue(next != null);
    
    try
    {
      next = next.move(c7, d6);
    }
    catch (IllegalMoveException ime)
    {
      assertTrue(ime.getFault() == IllegalMoveException.MoveFault.CHECK);
    }
    
    //Black to play
    pieceList = new ISquarePiece[29];
    i = 0;
    
    //Kings
    pieceList[i++] = new SquarePiece(g1,m_pieceBox.createWhiteKing());
    pieceList[i++] = new SquarePiece(g8,m_pieceBox.createBlackKing());
    //Queens
    pieceList[i++] = new SquarePiece(d2,m_pieceBox.createWhiteQueen());
    pieceList[i++] = new SquarePiece(a7,m_pieceBox.createBlackQueen());
    //Rooks
    pieceList[i++] = new SquarePiece(e2,m_pieceBox.createWhiteRook());
    pieceList[i++] = new SquarePiece(c1,m_pieceBox.createWhiteRook());
    pieceList[i++] = new SquarePiece(a8,m_pieceBox.createBlackRook());
    pieceList[i++] = new SquarePiece(c4,m_pieceBox.createBlackRook());
    //Bishops
    pieceList[i++] = new SquarePiece(c2,m_pieceBox.createWhiteBishop());
    pieceList[i++] = new SquarePiece(c3,m_pieceBox.createWhiteBishop());
    pieceList[i++] = new SquarePiece(b6,m_pieceBox.createBlackBishop());
    pieceList[i++] = new SquarePiece(d7,m_pieceBox.createBlackBishop());    
    //Knights
    pieceList[i++] = new SquarePiece(e5,m_pieceBox.createWhiteKnight());
    pieceList[i++] = new SquarePiece(d3,m_pieceBox.createWhiteKnight());
    pieceList[i++] = new SquarePiece(f6,m_pieceBox.createBlackKnight());
    pieceList[i++] = new SquarePiece(a6,m_pieceBox.createBlackKnight());        
    //Pawns
    pieceList[i++] = new SquarePiece(h3,m_pieceBox.createWhitePawn());
    pieceList[i++] = new SquarePiece(g2,m_pieceBox.createWhitePawn());
    pieceList[i++] = new SquarePiece(f2,m_pieceBox.createWhitePawn());
    pieceList[i++] = new SquarePiece(e4,m_pieceBox.createWhitePawn());        
    pieceList[i++] = new SquarePiece(d5,m_pieceBox.createWhitePawn());
    pieceList[i++] = new SquarePiece(b2,m_pieceBox.createWhitePawn());
    pieceList[i++] = new SquarePiece(a3,m_pieceBox.createWhitePawn());
    pieceList[i++] = new SquarePiece(h7,m_pieceBox.createBlackPawn());
    pieceList[i++] = new SquarePiece(g7,m_pieceBox.createBlackPawn());
    pieceList[i++] = new SquarePiece(f7,m_pieceBox.createBlackPawn());
    pieceList[i++] = new SquarePiece(d6,m_pieceBox.createBlackPawn());
    pieceList[i++] = new SquarePiece(b5,m_pieceBox.createBlackPawn());
    pieceList[i++] = new SquarePiece(a4,m_pieceBox.createBlackPawn());
    p_activeColor = ChessColor.getInstance().getBlack();
    p_white00 = false;
    p_white000 = false;
    p_black00 = false;
    p_black000 = false;
    enPassant = null;
    p_halfMoveClock = 0;
    p_fullMoveNumber = 24;
    pzl = new PuzzlePosition();
    pzl.set(pieceList, p_activeColor, p_white00, p_white000, p_black00, p_black000, enPassant, p_halfMoveClock, p_fullMoveNumber);
    
    assertEquals(m_chessColor.getBlack(), pzl.getActiveColor());
    
    
    pzl = new PuzzlePosition();
    try
    {
      pzl.set(null, 
              p_activeColor,
              p_white00,p_white000, p_black00, p_black000,
              enPassant,
              p_halfMoveClock,
              p_fullMoveNumber);
    }
    catch (IllegalArgumentException iae)
    {
      System.out.println(iae.getMessage());
    }


    pieceList = new ISquarePiece[29];
    i = 0;
    
    //Kings
    pieceList[i++] = new SquarePiece(g1,m_pieceBox.createWhiteKing());
    pieceList[i++] = new SquarePiece(g8,m_pieceBox.createBlackKing());
    //Queens
    pieceList[i++] = new SquarePiece(d2,m_pieceBox.createWhiteQueen());
    pieceList[i++] = new SquarePiece(a7,m_pieceBox.createBlackQueen());
    //Rooks
    pieceList[i++] = new SquarePiece(e2,m_pieceBox.createWhiteRook());
    pieceList[i++] = new SquarePiece(c1,null);
    pieceList[i++] = new SquarePiece(a8,m_pieceBox.createBlackRook());
    pieceList[i++] = new SquarePiece(c4,m_pieceBox.createBlackRook());
    //Bishops
    pieceList[i++] = new SquarePiece(c2,m_pieceBox.createWhiteBishop());
    pieceList[i++] = new SquarePiece(c3,m_pieceBox.createWhiteBishop());
    pieceList[i++] = new SquarePiece(b6,m_pieceBox.createBlackBishop());
    pieceList[i++] = new SquarePiece(d7,m_pieceBox.createBlackBishop());    
    //Knights
    pieceList[i++] = new SquarePiece(e5,m_pieceBox.createWhiteKnight());
    pieceList[i++] = new SquarePiece(d3,m_pieceBox.createWhiteKnight());
    pieceList[i++] = new SquarePiece(f6,m_pieceBox.createBlackKnight());
    pieceList[i++] = new SquarePiece(a6,m_pieceBox.createBlackKnight());        
    //Pawns
    pieceList[i++] = new SquarePiece(h3,m_pieceBox.createWhitePawn());
    pieceList[i++] = new SquarePiece(g2,m_pieceBox.createWhitePawn());
    pieceList[i++] = new SquarePiece(f2,m_pieceBox.createWhitePawn());
    pieceList[i++] = new SquarePiece(e4,m_pieceBox.createWhitePawn());        
    pieceList[i++] = new SquarePiece(d5,m_pieceBox.createWhitePawn());
    pieceList[i++] = new SquarePiece(b2,m_pieceBox.createWhitePawn());
    pieceList[i++] = new SquarePiece(a3,m_pieceBox.createWhitePawn());
    pieceList[i++] = new SquarePiece(h7,m_pieceBox.createBlackPawn());
    pieceList[i++] = new SquarePiece(g7,m_pieceBox.createBlackPawn());
    pieceList[i++] = new SquarePiece(f7,m_pieceBox.createBlackPawn());
    pieceList[i++] = new SquarePiece(d6,m_pieceBox.createBlackPawn());
    pieceList[i++] = new SquarePiece(b5,m_pieceBox.createBlackPawn());
    pieceList[i++] = new SquarePiece(a4,m_pieceBox.createBlackPawn());
    p_activeColor = ChessColor.getInstance().getBlack();
    p_white00 = false;
    p_white000 = false;
    p_black00 = false;
    p_black000 = false;
    enPassant = null;
    p_halfMoveClock = 0;
    p_fullMoveNumber = 24;
    pzl = new PuzzlePosition();
    try
    {
      pzl.set(pieceList, 
              p_activeColor,
              p_white00,p_white000, p_black00, p_black000,
              enPassant,
              p_halfMoveClock,
              p_fullMoveNumber);
    }
    catch (IllegalArgumentException iae)
    {
      System.out.println(iae.getMessage());
    }

    pieceList = new ISquarePiece[29];
    i = 0;
    
    //Kings
    pieceList[i++] = new SquarePiece(g1,m_pieceBox.createWhiteKing());
    pieceList[i++] = new SquarePiece(g8,m_pieceBox.createBlackKing());
    //Queens
    pieceList[i++] = new SquarePiece(d2,m_pieceBox.createWhiteQueen());
    pieceList[i++] = new SquarePiece(a7,m_pieceBox.createBlackQueen());
    //Rooks
    pieceList[i++] = new SquarePiece(e2,m_pieceBox.createWhiteRook());
    pieceList[i++] = new SquarePiece(c1,m_pieceBox.createWhiteRook());
    pieceList[i++] = new SquarePiece(a8,m_pieceBox.createBlackRook());
    pieceList[i++] = new SquarePiece(c4,m_pieceBox.createBlackRook());
    //Bishops
    pieceList[i++] = new SquarePiece(c2,m_pieceBox.createWhiteBishop());
    pieceList[i++] = new SquarePiece(c3,m_pieceBox.createWhiteBishop());
    pieceList[i++] = new SquarePiece(b6,m_pieceBox.createBlackBishop());
    pieceList[i++] = new SquarePiece(d7,m_pieceBox.createBlackBishop());    
    //Knights
    pieceList[i++] = new SquarePiece(e5,m_pieceBox.createWhiteKnight());
    pieceList[i++] = new SquarePiece(d3,m_pieceBox.createWhiteKnight());
    pieceList[i++] = new SquarePiece(f6,m_pieceBox.createBlackKnight());
    pieceList[i++] = new SquarePiece(a6,m_pieceBox.createBlackKnight());        
    //Pawns
    pieceList[i++] = new SquarePiece(h3,m_pieceBox.createWhitePawn());
    pieceList[i++] = new SquarePiece(g2,m_pieceBox.createWhitePawn());
    pieceList[i++] = new SquarePiece(f2,m_pieceBox.createWhitePawn());
    pieceList[i++] = new SquarePiece(e4,m_pieceBox.createWhitePawn());        
    pieceList[i++] = new SquarePiece(d5,m_pieceBox.createWhitePawn());
    pieceList[i++] = new SquarePiece(b2,m_pieceBox.createWhitePawn());
    pieceList[i++] = new SquarePiece(a1,m_pieceBox.createWhitePawn());
    pieceList[i++] = new SquarePiece(h7,m_pieceBox.createBlackPawn());
    pieceList[i++] = new SquarePiece(g7,m_pieceBox.createBlackPawn());
    pieceList[i++] = new SquarePiece(f7,m_pieceBox.createBlackPawn());
    pieceList[i++] = new SquarePiece(d6,m_pieceBox.createBlackPawn());
    pieceList[i++] = new SquarePiece(b5,m_pieceBox.createBlackPawn());
    pieceList[i++] = new SquarePiece(a4,m_pieceBox.createBlackPawn());
    p_activeColor = ChessColor.getInstance().getBlack();
    p_white00 = false;
    p_white000 = false;
    p_black00 = false;
    p_black000 = false;
    enPassant = null;
    p_halfMoveClock = 0;
    p_fullMoveNumber = 24;
    pzl = new PuzzlePosition();
    try
    {
      pzl.set(pieceList, 
              p_activeColor,
              p_white00,p_white000, p_black00, p_black000,
              enPassant,
              p_halfMoveClock,
              p_fullMoveNumber);
    }
    catch (IllegalPawnException ipe)
    {
      System.out.println(ipe.getMessage());
    }

    pieceList = new ISquarePiece[28];
    i = 0;
    
    //Kings
    pieceList[i++] = new SquarePiece(g1,m_pieceBox.createWhiteKing());
    //Queens
    pieceList[i++] = new SquarePiece(d2,m_pieceBox.createWhiteQueen());
    pieceList[i++] = new SquarePiece(a7,m_pieceBox.createBlackQueen());
    //Rooks
    pieceList[i++] = new SquarePiece(e2,m_pieceBox.createWhiteRook());
    pieceList[i++] = new SquarePiece(c1,m_pieceBox.createWhiteRook());
    pieceList[i++] = new SquarePiece(a8,m_pieceBox.createBlackRook());
    pieceList[i++] = new SquarePiece(c4,m_pieceBox.createBlackRook());
    //Bishops
    pieceList[i++] = new SquarePiece(c2,m_pieceBox.createWhiteBishop());
    pieceList[i++] = new SquarePiece(c3,m_pieceBox.createWhiteBishop());
    pieceList[i++] = new SquarePiece(b6,m_pieceBox.createBlackBishop());
    pieceList[i++] = new SquarePiece(d7,m_pieceBox.createBlackBishop());    
    //Knights
    pieceList[i++] = new SquarePiece(e5,m_pieceBox.createWhiteKnight());
    pieceList[i++] = new SquarePiece(d3,m_pieceBox.createWhiteKnight());
    pieceList[i++] = new SquarePiece(f6,m_pieceBox.createBlackKnight());
    pieceList[i++] = new SquarePiece(a6,m_pieceBox.createBlackKnight());        
    //Pawns
    pieceList[i++] = new SquarePiece(h3,m_pieceBox.createWhitePawn());
    pieceList[i++] = new SquarePiece(g2,m_pieceBox.createWhitePawn());
    pieceList[i++] = new SquarePiece(f2,m_pieceBox.createWhitePawn());
    pieceList[i++] = new SquarePiece(e4,m_pieceBox.createWhitePawn());        
    pieceList[i++] = new SquarePiece(d5,m_pieceBox.createWhitePawn());
    pieceList[i++] = new SquarePiece(b2,m_pieceBox.createWhitePawn());
    pieceList[i++] = new SquarePiece(a3,m_pieceBox.createWhitePawn());
    pieceList[i++] = new SquarePiece(h7,m_pieceBox.createBlackPawn());
    pieceList[i++] = new SquarePiece(g7,m_pieceBox.createBlackPawn());
    pieceList[i++] = new SquarePiece(f7,m_pieceBox.createBlackPawn());
    pieceList[i++] = new SquarePiece(d6,m_pieceBox.createBlackPawn());
    pieceList[i++] = new SquarePiece(b5,m_pieceBox.createBlackPawn());
    pieceList[i++] = new SquarePiece(a4,m_pieceBox.createBlackPawn());
    p_activeColor = ChessColor.getInstance().getBlack();
    p_white00 = false;
    p_white000 = false;
    p_black00 = false;
    p_black000 = false;
    enPassant = null;
    p_halfMoveClock = 0;
    p_fullMoveNumber = 24;
    pzl = new PuzzlePosition();
    try
    {
      pzl.set(pieceList, 
              p_activeColor,
              p_white00,p_white000, p_black00, p_black000,
              enPassant,
              p_halfMoveClock,
              p_fullMoveNumber);
    }
    catch (IllegalKingException ike)
    {
      System.out.println(ike.getMessage());
    }
    
    pieceList = new ISquarePiece[29];
    i = 0;
    
    //Kings
    pieceList[i++] = new SquarePiece(g1,m_pieceBox.createWhiteKing());
    pieceList[i++] = new SquarePiece(g8,m_pieceBox.createBlackKing());
    //Queens
    pieceList[i++] = new SquarePiece(d2,m_pieceBox.createWhiteQueen());
    pieceList[i++] = new SquarePiece(a7,m_pieceBox.createBlackQueen());
    //Rooks
    pieceList[i++] = new SquarePiece(e2,m_pieceBox.createWhiteRook());
    pieceList[i++] = new SquarePiece(c1,m_pieceBox.createWhiteRook());
    pieceList[i++] = new SquarePiece(a8,m_pieceBox.createBlackRook());
    pieceList[i++] = new SquarePiece(c4,m_pieceBox.createBlackRook());
    //Bishops
    pieceList[i++] = new SquarePiece(c2,m_pieceBox.createWhiteBishop());
    pieceList[i++] = new SquarePiece(c3,m_pieceBox.createWhiteBishop());
    pieceList[i++] = new SquarePiece(b6,m_pieceBox.createBlackBishop());
    pieceList[i++] = new SquarePiece(d7,m_pieceBox.createBlackBishop());    
    //Knights
    pieceList[i++] = new SquarePiece(e5,m_pieceBox.createWhiteKnight());
    pieceList[i++] = new SquarePiece(d3,m_pieceBox.createWhiteKnight());
    pieceList[i++] = new SquarePiece(f6,m_pieceBox.createBlackKnight());
    pieceList[i++] = new SquarePiece(a6,m_pieceBox.createBlackKnight());        
    //Pawns
    pieceList[i++] = new SquarePiece(h3,m_pieceBox.createWhitePawn());
    pieceList[i++] = new SquarePiece(g2,m_pieceBox.createWhitePawn());
    pieceList[i++] = new SquarePiece(f2,m_pieceBox.createWhitePawn());
    pieceList[i++] = new SquarePiece(e4,m_pieceBox.createWhitePawn());        
    pieceList[i++] = new SquarePiece(d5,m_pieceBox.createWhitePawn());
    pieceList[i++] = new SquarePiece(b2,m_pieceBox.createWhitePawn());
    pieceList[i++] = new SquarePiece(a3,m_pieceBox.createWhitePawn());
    pieceList[i++] = new SquarePiece(h7,m_pieceBox.createBlackPawn());
    pieceList[i++] = new SquarePiece(g7,m_pieceBox.createBlackPawn());
    pieceList[i++] = new SquarePiece(f7,m_pieceBox.createBlackPawn());
    pieceList[i++] = new SquarePiece(d6,m_pieceBox.createBlackPawn());
    pieceList[i++] = new SquarePiece(b5,m_pieceBox.createBlackPawn());
    pieceList[i++] = new SquarePiece(a4,m_pieceBox.createBlackPawn());
    p_activeColor = ChessColor.getInstance().getBlack();
    p_white00 = false;
    p_white000 = false;
    p_black00 = false;
    p_black000 = false;
    enPassant = null;
    p_halfMoveClock = 50;
    p_fullMoveNumber = 24;
    pzl = new PuzzlePosition();
    try
    {
      pzl.set(pieceList, 
              p_activeColor,
              p_white00,p_white000, p_black00, p_black000,
              enPassant,
              p_halfMoveClock,
              p_fullMoveNumber);
    }
    catch (IllegalArgumentException iae)
    {
      System.out.println(iae.getMessage());
    }

    pieceList = new ISquarePiece[28];
    i = 0;
    
    //Kings
    pieceList[i++] = new SquarePiece(g1,m_pieceBox.createWhiteKing());
    pieceList[i++] = new SquarePiece(g8,m_pieceBox.createBlackKing());
    //Queens
    pieceList[i++] = new SquarePiece(d2,m_pieceBox.createWhiteQueen());
    pieceList[i++] = new SquarePiece(a7,m_pieceBox.createBlackQueen());
    //Rooks
    pieceList[i++] = new SquarePiece(e2,m_pieceBox.createWhiteRook());
    pieceList[i++] = new SquarePiece(c1,m_pieceBox.createWhiteRook());
    pieceList[i++] = new SquarePiece(a8,m_pieceBox.createBlackRook());
    pieceList[i++] = new SquarePiece(c4,m_pieceBox.createBlackRook());
    //Bishops
    pieceList[i++] = new SquarePiece(c2,m_pieceBox.createWhiteBishop());
    pieceList[i++] = new SquarePiece(c3,m_pieceBox.createWhiteBishop());
    pieceList[i++] = new SquarePiece(b6,m_pieceBox.createBlackBishop());
    pieceList[i++] = new SquarePiece(d7,m_pieceBox.createBlackBishop());    
    //Knights
    pieceList[i++] = new SquarePiece(e5,m_pieceBox.createWhiteKnight());
    pieceList[i++] = new SquarePiece(d3,m_pieceBox.createWhiteKnight());
    pieceList[i++] = new SquarePiece(f6,m_pieceBox.createBlackKnight());
    pieceList[i++] = new SquarePiece(a6,m_pieceBox.createBlackKnight());        
    //Pawns
    pieceList[i++] = new SquarePiece(h3,m_pieceBox.createWhitePawn());
    pieceList[i++] = new SquarePiece(g2,m_pieceBox.createWhitePawn());
    pieceList[i++] = new SquarePiece(e4,m_pieceBox.createWhitePawn());        
    pieceList[i++] = new SquarePiece(d5,m_pieceBox.createWhitePawn());
    pieceList[i++] = new SquarePiece(b2,m_pieceBox.createWhitePawn());
    pieceList[i++] = new SquarePiece(a3,m_pieceBox.createWhitePawn());
    pieceList[i++] = new SquarePiece(h7,m_pieceBox.createBlackPawn());
    pieceList[i++] = new SquarePiece(g7,m_pieceBox.createBlackPawn());
    pieceList[i++] = new SquarePiece(f7,m_pieceBox.createBlackPawn());
    pieceList[i++] = new SquarePiece(d6,m_pieceBox.createBlackPawn());
    pieceList[i++] = new SquarePiece(b5,m_pieceBox.createBlackPawn());
    pieceList[i++] = new SquarePiece(a4,m_pieceBox.createBlackPawn());
    p_activeColor = ChessColor.getInstance().getBlack();
    p_white00 = false;
    p_white000 = false;
    p_black00 = false;
    p_black000 = false;
    enPassant = null;
    p_halfMoveClock = 0;
    p_fullMoveNumber = 24;
    pzl = new PuzzlePosition();
    try
    {
      pzl.set(pieceList, 
              p_activeColor,
              p_white00,p_white000, p_black00, p_black000,
              enPassant,
              p_halfMoveClock,
              p_fullMoveNumber);
    }
    catch (IllegalTurnException ike)
    {
      System.out.println(ike.getMessage());
    }
    
  }
  
    /**
   * Test of isThreefoldRepetition method, of class IPosition.
   */
  @Test
  public void testIsThreefoldRepetition() throws Exception
  {
    System.out.println("isThreefoldRepetition");
    
    PuzzlePosition pzl;
    
    ISquarePiece[] pieceList = new ISquarePiece[19];
    int i = 0;
    
    //Gelfand - Grishchuk, World Championship Candidates (2013) 1/2
    //23rd move, white to play
        
    pieceList[i++] = new SquarePiece(h1,m_pieceBox.createWhiteKing());
    pieceList[i++] = new SquarePiece(g8,m_pieceBox.createBlackKing());
    pieceList[i++] = new SquarePiece(c5,m_pieceBox.createWhiteQueen());
    pieceList[i++] = new SquarePiece(a3,m_pieceBox.createBlackQueen());
    pieceList[i++] = new SquarePiece(f1,m_pieceBox.createWhiteRook());
    pieceList[i++] = new SquarePiece(d1,m_pieceBox.createWhiteRook());
    pieceList[i++] = new SquarePiece(f8,m_pieceBox.createBlackRook());
    pieceList[i++] = new SquarePiece(e8,m_pieceBox.createBlackRook());   
    pieceList[i++] = new SquarePiece(a2,m_pieceBox.createWhitePawn());
    pieceList[i++] = new SquarePiece(c4,m_pieceBox.createWhitePawn());
    pieceList[i++] = new SquarePiece(d5,m_pieceBox.createWhitePawn());
    pieceList[i++] = new SquarePiece(f2,m_pieceBox.createWhitePawn());
    pieceList[i++] = new SquarePiece(f4,m_pieceBox.createWhitePawn());
    pieceList[i++] = new SquarePiece(h2,m_pieceBox.createWhitePawn());    
    pieceList[i++] = new SquarePiece(a7,m_pieceBox.createBlackPawn());
    pieceList[i++] = new SquarePiece(b4,m_pieceBox.createBlackPawn());
    pieceList[i++] = new SquarePiece(f7,m_pieceBox.createBlackPawn());
    pieceList[i++] = new SquarePiece(g6,m_pieceBox.createBlackPawn());
    pieceList[i++] = new SquarePiece(h7,m_pieceBox.createBlackPawn());
    IColor p_activeColor = ChessColor.getInstance().getWhite();
    boolean p_white00 = false;
    boolean p_white000 = false;
    boolean p_black00 = false;
    boolean p_black000 = false;
    ISquare enPassant = null;
    int p_halfMoveClock = 1;
    int p_fullMoveNumber = 23;
    pzl = new PuzzlePosition();
    pzl.set(pieceList,
            p_activeColor,
            p_white00, p_white000, p_black00, p_black000,
            enPassant,
            p_halfMoveClock,
            p_fullMoveNumber);
    
    
    IPosition next;    
    //23. d6 Qf3+
    next = pzl.move(d5, d6);
    assertFalse(next.isThreefoldRepetition());

    next = next.move(a3, f3);
    assertFalse(next.isThreefoldRepetition());
    
    //24. Kg1 Qg4+
    next = next.move(h1, g1);
    assertFalse(next.isThreefoldRepetition());

    next = next.move(f3, g4);
    assertFalse(next.isThreefoldRepetition());
    
    //25. Kh1 Qf3+
    next = next.move(g1, h1);
    assertFalse(next.isThreefoldRepetition());

    next = next.move(g4, f3);
    assertFalse(next.isThreefoldRepetition());

    //26. Kg1 Qg4+
    next = next.move(h1, g1);
    assertFalse(next.isThreefoldRepetition());

    next = next.move(f3, g4);
    assertFalse(next.isThreefoldRepetition());

    //27. Kh1 Qf3+
    next = next.move(g1, h1);
    assertFalse(next.isThreefoldRepetition());

    next = next.move(g4, f3);
    assertTrue(next.isThreefoldRepetition());
    
  }
}
