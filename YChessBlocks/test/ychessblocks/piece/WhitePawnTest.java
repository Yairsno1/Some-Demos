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
import ychessblocks.board.Board;
import ychessblocks.board.ChessColor;
import ychessblocks.board.IFile;
import ychessblocks.board.IRank;
import ychessblocks.board.ISquare;
import ychessblocks.position.*;
import ychessblocks.position.PositionTest.MockedPosition;

/**
 *
 * @author Yair
 */
public class WhitePawnTest
{
  private static Board m_board;  
  
  public WhitePawnTest() {
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
  public void setUp() {
  }
  
  @After
  public void tearDown() {
  }

  /**
   * Test of trySlide method, of class WhitePawn.
   */
  @Test
  public void testTrySlide() 
  {
    System.out.println("trySlide");
    
    IPosition p_position = new Position();
    p_position.set();    
    WhitePawn instance = new WhitePawn();

    //1. e2-e4
    ISquare p_from = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEe),
                                       m_board.getRank(IRank.ChessboardRank.RANK2));
    ISquare p_to   = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEe),
                                       m_board.getRank(IRank.ChessboardRank.RANK4));
    boolean result = instance.trySlide(p_from, p_to, p_position);
    assertTrue("1. e2-e4", result);

    //1. g2-g3
    p_from = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEg),
                               m_board.getRank(IRank.ChessboardRank.RANK2));
    p_to   = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEg),
                               m_board.getRank(IRank.ChessboardRank.RANK3));
    result = instance.trySlide(p_from, p_to, p_position);
    assertTrue("1. g2-g3", result);

    //1. a2-a5
    p_from = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEa),
                               m_board.getRank(IRank.ChessboardRank.RANK2));
    p_to   = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEa),
                               m_board.getRank(IRank.ChessboardRank.RANK5));
    result = instance.trySlide(p_from, p_to, p_position);
    assertFalse("1. a2-a5", result);
    
    //?. b3-b4
    p_from = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEb),
                               m_board.getRank(IRank.ChessboardRank.RANK3));
    p_to   = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEb),
                               m_board.getRank(IRank.ChessboardRank.RANK4));
    result = instance.trySlide(p_from, p_to, p_position);
    assertTrue("?. b3-b4", result);

    //?. b3-b5
    p_from = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEb),
                               m_board.getRank(IRank.ChessboardRank.RANK3));
    p_to   = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEb),
                               m_board.getRank(IRank.ChessboardRank.RANK5));
    result = instance.trySlide(p_from, p_to, p_position);
    assertFalse("?. b3-b5", result);

    //?. c6-c7
    p_from = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEc),
                               m_board.getRank(IRank.ChessboardRank.RANK6));
    p_to   = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEc),
                               m_board.getRank(IRank.ChessboardRank.RANK7));
    result = instance.trySlide(p_from, p_to, p_position);
    assertFalse("?. c6-c7", result);
    
    //?. c5-e6
    p_from = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEc),
                               m_board.getRank(IRank.ChessboardRank.RANK5));
    p_to   = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEe),
                               m_board.getRank(IRank.ChessboardRank.RANK6));
    result = instance.trySlide(p_from, p_to, p_position);
    assertFalse("?. c5-e6", result);

    //?. d4-d4
    p_from = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEd),
                               m_board.getRank(IRank.ChessboardRank.RANK4));
    p_to   = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEd),
                               m_board.getRank(IRank.ChessboardRank.RANK4));
    result = instance.trySlide(p_from, p_to, p_position);
    assertFalse("?. d4-d4", result);


    //?. d6xe7
    p_from = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEd),
                               m_board.getRank(IRank.ChessboardRank.RANK6));
    p_to   = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEe),
                               m_board.getRank(IRank.ChessboardRank.RANK7));
    result = instance.trySlide(p_from, p_to, p_position);
    assertTrue("?. d6xe7", result);

    //?. d6xc7
    p_from = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEd),
                               m_board.getRank(IRank.ChessboardRank.RANK6));
    p_to   = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEc),
                               m_board.getRank(IRank.ChessboardRank.RANK7));
    result = instance.trySlide(p_from, p_to, p_position);
    assertTrue("?. d6xc7", result);
    
    //?. e3xd4
    p_from = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEe),
                               m_board.getRank(IRank.ChessboardRank.RANK3));
    p_to   = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEd),
                               m_board.getRank(IRank.ChessboardRank.RANK4));
    result = instance.trySlide(p_from, p_to, p_position);
    assertFalse("?. e3xd4", result);

    //?. e3xf4
    p_from = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEe),
                               m_board.getRank(IRank.ChessboardRank.RANK3));
    p_to   = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEf),
                               m_board.getRank(IRank.ChessboardRank.RANK4));
    result = instance.trySlide(p_from, p_to, p_position);
    assertFalse("?. e3xf4", result);

    //?. e5xg7
    p_from = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEe),
                               m_board.getRank(IRank.ChessboardRank.RANK5));
    p_to   = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEg),
                               m_board.getRank(IRank.ChessboardRank.RANK7));
    result = instance.trySlide(p_from, p_to, p_position);
    assertFalse("?. e5xg7", result);    
    
    //?. e2xc4
    p_from = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEe),
                               m_board.getRank(IRank.ChessboardRank.RANK2));
    p_to   = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEc),
                               m_board.getRank(IRank.ChessboardRank.RANK4));
    result = instance.trySlide(p_from, p_to, p_position);
    assertFalse("?. e2xc4", result);    

    //?. e2xg4
    p_from = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEe),
                               m_board.getRank(IRank.ChessboardRank.RANK2));
    p_to   = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEg),
                               m_board.getRank(IRank.ChessboardRank.RANK4));
    result = instance.trySlide(p_from, p_to, p_position);
    assertFalse("?. e2xg4", result);    

    //?. d5xc4
    p_from = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEd),
                               m_board.getRank(IRank.ChessboardRank.RANK5));
    p_to   = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEc),
                               m_board.getRank(IRank.ChessboardRank.RANK4));
    result = instance.trySlide(p_from, p_to, p_position);
    assertFalse("?. d5xc4", result);    
    
    //?. d5xe4
    p_from = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEd),
                               m_board.getRank(IRank.ChessboardRank.RANK5));
    p_to   = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEe),
                               m_board.getRank(IRank.ChessboardRank.RANK4));
    result = instance.trySlide(p_from, p_to, p_position);
    assertFalse("?. d5xe4", result);    
    
    //?. e5xd6 e.p.
    p_position = new MockedPosition();
    ISquare sq1;
    sq1 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEe),
                            m_board.getRank(IRank.ChessboardRank.RANK1));
    ((MockedPosition)p_position).addPiece(sq1,
                                          PieceBox.getInstance().createWhiteKing());
    sq1 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEe),
                            m_board.getRank(IRank.ChessboardRank.RANK8));
    ((MockedPosition)p_position).addPiece(sq1,
                                          PieceBox.getInstance().createBlackKing());
    sq1 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEe),
                            m_board.getRank(IRank.ChessboardRank.RANK5));
    ((MockedPosition)p_position).addPiece(sq1,
                                          PieceBox.getInstance().createWhitePawn());
    sq1 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEd),
                            m_board.getRank(IRank.ChessboardRank.RANK5));
    ((MockedPosition)p_position).addPiece(sq1,
                                          PieceBox.getInstance().createBlackPawn());
    sq1 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEd),
                            m_board.getRank(IRank.ChessboardRank.RANK6));
    ((MockedPosition)p_position).mockEnpassant(sq1);
    p_from = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEe),
                               m_board.getRank(IRank.ChessboardRank.RANK5));
    p_to   = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEd),
                               m_board.getRank(IRank.ChessboardRank.RANK6));
    result = instance.trySlide(p_from, p_to, p_position);
    assertTrue("?. e5xd6 e.p.", result);    
    
  }
  
   /**
   * Test of generateSlides method, of class WhitePawn.
   */
  @Test
  public void testGenerateSlides() throws Exception
  {
    System.out.println("White generateSlides");    
    
    IPosition pzl;
    ISquare[] slides;
    IPiece pawn;
    ISquare e1 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEe),
                                   m_board.getRank(IRank.ChessboardRank.RANK1));
    ISquare e8 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEe),
                                   m_board.getRank(IRank.ChessboardRank.RANK8));
    ISquare e2 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEe),
                                   m_board.getRank(IRank.ChessboardRank.RANK2));
    ISquare e3 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEe),
                                   m_board.getRank(IRank.ChessboardRank.RANK3));
    ISquare e4 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEe),
                                   m_board.getRank(IRank.ChessboardRank.RANK4));
    ISquare f3 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEf),
                                   m_board.getRank(IRank.ChessboardRank.RANK3));
    ISquare d3 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEd),
                                   m_board.getRank(IRank.ChessboardRank.RANK3));
    ISquare h3 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEh),
                                   m_board.getRank(IRank.ChessboardRank.RANK3));
    ISquare g4 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEg),
                                   m_board.getRank(IRank.ChessboardRank.RANK4));
    ISquare h4 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEh),
                                   m_board.getRank(IRank.ChessboardRank.RANK4));
    ISquare a7 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEa),
                                   m_board.getRank(IRank.ChessboardRank.RANK7));
    ISquare a8 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEa),
                                   m_board.getRank(IRank.ChessboardRank.RANK8));
    ISquare b8 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEb),
                                   m_board.getRank(IRank.ChessboardRank.RANK8));
    
    
    ISquarePiece[] pieceList = new ISquarePiece[5];
    pieceList[0] = new SquarePiece(e1,PieceBox.getInstance().createWhiteKing());
    pieceList[1] = new SquarePiece(e8,PieceBox.getInstance().createBlackKing());
    pieceList[2] = new SquarePiece(e2,PieceBox.getInstance().createWhitePawn());
    pieceList[3] = new SquarePiece(f3,PieceBox.getInstance().createBlackPawn());
    pieceList[4] = new SquarePiece(d3,PieceBox.getInstance().createBlackRook());
    
    pzl = new PuzzlePosition();
    ((PuzzlePosition)pzl).set(pieceList,
                              ChessColor.getInstance().getWhite(),
                              false,false,false,false,
                              null,
                              0,1);
    pawn = pzl.getPiece(e2);
    
    slides = pawn.generateSlides(e2, pzl);
    assertFalse(slides == null);   
    assertTrue(slides.length == 4);   
    assertTrue(squareFound(slides,e3));       
    assertTrue(squareFound(slides,e4));
    assertTrue(squareFound(slides,f3));       
    assertTrue(squareFound(slides,d3));

    pieceList = new ISquarePiece[3];
    pieceList[0] = new SquarePiece(e1,PieceBox.getInstance().createWhiteKing());
    pieceList[1] = new SquarePiece(e8,PieceBox.getInstance().createBlackKing());
    pieceList[2] = new SquarePiece(e2,PieceBox.getInstance().createWhitePawn());
    
    pzl = new PuzzlePosition();
    ((PuzzlePosition)pzl).set(pieceList,
                              ChessColor.getInstance().getWhite(),
                              false,false,false,false,
                              null,
                              0,1);
    pawn = pzl.getPiece(e2);
    
    slides = pawn.generateSlides(e2, pzl);
    assertFalse(slides == null);   
    assertTrue(slides.length == 2);   
    assertTrue(squareFound(slides,e3));       
    assertTrue(squareFound(slides,e4));

    pieceList = new ISquarePiece[4];
    pieceList[0] = new SquarePiece(e1,PieceBox.getInstance().createWhiteKing());
    pieceList[1] = new SquarePiece(e8,PieceBox.getInstance().createBlackKing());
    pieceList[2] = new SquarePiece(e2,PieceBox.getInstance().createWhitePawn());
    pieceList[3] = new SquarePiece(e4,PieceBox.getInstance().createWhitePawn());
    
    pzl = new PuzzlePosition();
    ((PuzzlePosition)pzl).set(pieceList,
                              ChessColor.getInstance().getWhite(),
                              false,false,false,false,
                              null,
                              0,1);
    pawn = pzl.getPiece(e2);
    
    slides = pawn.generateSlides(e2, pzl);
    assertFalse(slides == null);   
    assertTrue(slides.length == 1);   
    assertTrue(squareFound(slides,e3));       

    pieceList = new ISquarePiece[5];
    pieceList[0] = new SquarePiece(e1,PieceBox.getInstance().createWhiteKing());
    pieceList[1] = new SquarePiece(e8,PieceBox.getInstance().createBlackKing());
    pieceList[2] = new SquarePiece(e2,PieceBox.getInstance().createWhitePawn());
    pieceList[3] = new SquarePiece(e4,PieceBox.getInstance().createWhitePawn());
    pieceList[4] = new SquarePiece(e3,PieceBox.getInstance().createBlackPawn());
    
    pzl = new PuzzlePosition();
    ((PuzzlePosition)pzl).set(pieceList,
                              ChessColor.getInstance().getWhite(),
                              false,false,false,false,
                              null,
                              0,1);
    pawn = pzl.getPiece(e2);
    
    slides = pawn.generateSlides(e2, pzl);
    assertFalse(slides == null);   
    assertTrue(slides.length == 0);   
    
    pieceList = new ISquarePiece[4];
    pieceList[0] = new SquarePiece(e1,PieceBox.getInstance().createWhiteKing());
    pieceList[1] = new SquarePiece(e8,PieceBox.getInstance().createBlackKing());
    pieceList[2] = new SquarePiece(h3,PieceBox.getInstance().createWhitePawn());
    pieceList[3] = new SquarePiece(g4,PieceBox.getInstance().createBlackPawn());
    
    pzl = new PuzzlePosition();
    ((PuzzlePosition)pzl).set(pieceList,
                              ChessColor.getInstance().getWhite(),
                              false,false,false,false,
                              null,
                              0,1);
    pawn = pzl.getPiece(h3);
    
    slides = pawn.generateSlides(h3, pzl);
    assertFalse(slides == null);   
    assertTrue(slides.length == 2);   
    assertTrue(squareFound(slides,h4));
    assertTrue(squareFound(slides,g4));       
    
    pieceList = new ISquarePiece[4];
    pieceList[0] = new SquarePiece(e1,PieceBox.getInstance().createWhiteKing());
    pieceList[1] = new SquarePiece(e8,PieceBox.getInstance().createBlackKing());
    pieceList[2] = new SquarePiece(a7,PieceBox.getInstance().createWhitePawn());
    pieceList[3] = new SquarePiece(b8,PieceBox.getInstance().createBlackKnight());
    
    pzl = new PuzzlePosition();
    ((PuzzlePosition)pzl).set(pieceList,
                              ChessColor.getInstance().getWhite(),
                              false,false,false,false,
                              null,
                              0,1);
    pawn = pzl.getPiece(a7);
    
    slides = pawn.generateSlides(a7, pzl);
    assertFalse(slides == null);   
    assertTrue(slides.length == 2);   
    assertTrue(squareFound(slides,a8));
    assertTrue(squareFound(slides,b8));           
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
