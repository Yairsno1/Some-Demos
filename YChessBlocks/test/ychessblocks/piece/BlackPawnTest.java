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
import ychessblocks.board.IFile;
import ychessblocks.board.IRank;
import ychessblocks.board.ISquare;
import ychessblocks.position.IPosition;
import ychessblocks.position.ISquarePiece;
import ychessblocks.position.Position;
import ychessblocks.position.PositionTest;
import ychessblocks.position.PuzzlePosition;
import ychessblocks.position.SquarePiece;

/**
 *
 * @author Yair
 */
public class BlackPawnTest
{
  private static IBoard m_board;  
  
  public BlackPawnTest() {
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
   * Test of trySlide method, of class BlackPawn.
   */
  @Test
  public void testTrySlide()
  {
    IPosition p_position = new Position();
    p_position.set();    
    IPiece instance = PieceBox.getInstance().createBlackPawn();

    //1. e7-e5
    ISquare p_from = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEe),
                                       m_board.getRank(IRank.ChessboardRank.RANK7));
    ISquare p_to   = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEe),
                                       m_board.getRank(IRank.ChessboardRank.RANK5));
    boolean result = instance.trySlide(p_from, p_to, p_position);
    assertTrue("1. e7-e5", result);

    //1. g7-g6
    p_from = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEg),
                               m_board.getRank(IRank.ChessboardRank.RANK7));
    p_to   = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEg),
                               m_board.getRank(IRank.ChessboardRank.RANK6));
    result = instance.trySlide(p_from, p_to, p_position);
    assertTrue("1. g7-g6", result);

    //1. a7-a4
    p_from = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEa),
                               m_board.getRank(IRank.ChessboardRank.RANK7));
    p_to   = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEa),
                               m_board.getRank(IRank.ChessboardRank.RANK4));
    result = instance.trySlide(p_from, p_to, p_position);
    assertFalse("1. a7-a4", result);
    
    //?. b6-b5
    p_from = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEb),
                               m_board.getRank(IRank.ChessboardRank.RANK6));
    p_to   = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEb),
                               m_board.getRank(IRank.ChessboardRank.RANK5));
    result = instance.trySlide(p_from, p_to, p_position);
    assertTrue("?. b6-b5", result);

    //?. b6-b4
    p_from = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEb),
                               m_board.getRank(IRank.ChessboardRank.RANK6));
    p_to   = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEb),
                               m_board.getRank(IRank.ChessboardRank.RANK4));
    result = instance.trySlide(p_from, p_to, p_position);
    assertFalse("?. b6-b4", result);

    //?. c3-c2
    p_from = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEc),
                               m_board.getRank(IRank.ChessboardRank.RANK3));
    p_to   = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEc),
                               m_board.getRank(IRank.ChessboardRank.RANK2));
    result = instance.trySlide(p_from, p_to, p_position);
    assertFalse("?. c3-c2", result);
    
    //?. c5-d3
    p_from = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEc),
                               m_board.getRank(IRank.ChessboardRank.RANK5));
    p_to   = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEd),
                               m_board.getRank(IRank.ChessboardRank.RANK3));
    result = instance.trySlide(p_from, p_to, p_position);
    assertFalse("?. c5-d3", result);
    
    //?. d4-d4
    p_from = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEd),
                               m_board.getRank(IRank.ChessboardRank.RANK4));
    p_to   = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEd),
                               m_board.getRank(IRank.ChessboardRank.RANK4));
    result = instance.trySlide(p_from, p_to, p_position);
    assertFalse("?. d4-d4", result);


    //?. d3xe2
    p_from = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEd),
                               m_board.getRank(IRank.ChessboardRank.RANK3));
    p_to   = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEe),
                               m_board.getRank(IRank.ChessboardRank.RANK2));
    result = instance.trySlide(p_from, p_to, p_position);
    assertTrue("?. d3xe2", result);

    //?. d3xc2
    p_from = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEd),
                               m_board.getRank(IRank.ChessboardRank.RANK3));
    p_to   = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEc),
                               m_board.getRank(IRank.ChessboardRank.RANK2));
    result = instance.trySlide(p_from, p_to, p_position);
    assertTrue("?. d3xc2", result);
    
    //?. d4xe3
    p_from = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEd),
                               m_board.getRank(IRank.ChessboardRank.RANK4));
    p_to   = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEe),
                               m_board.getRank(IRank.ChessboardRank.RANK3));
    result = instance.trySlide(p_from, p_to, p_position);
    assertFalse("?. d4xe3", result);

    //?. d4xc3
    p_from = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEd),
                               m_board.getRank(IRank.ChessboardRank.RANK4));
    p_to   = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEc),
                               m_board.getRank(IRank.ChessboardRank.RANK3));
    result = instance.trySlide(p_from, p_to, p_position);
    assertFalse("?. d4xc3", result);

    //?. e4xg2
    p_from = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEe),
                               m_board.getRank(IRank.ChessboardRank.RANK4));
    p_to   = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEg),
                               m_board.getRank(IRank.ChessboardRank.RANK2));
    result = instance.trySlide(p_from, p_to, p_position);
    assertFalse("?. e5xg7", result);    
    
    //?. e7xc5
    p_from = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEe),
                               m_board.getRank(IRank.ChessboardRank.RANK7));
    p_to   = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEc),
                               m_board.getRank(IRank.ChessboardRank.RANK5));
    result = instance.trySlide(p_from, p_to, p_position);
    assertFalse("?. e7xc5", result);    

    //?. e7xg5
    p_from = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEe),
                               m_board.getRank(IRank.ChessboardRank.RANK7));
    p_to   = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEg),
                               m_board.getRank(IRank.ChessboardRank.RANK5));
    result = instance.trySlide(p_from, p_to, p_position);
    assertFalse("?. e7xg5", result);    

    //?. d4xc5
    p_from = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEd),
                               m_board.getRank(IRank.ChessboardRank.RANK4));
    p_to   = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEc),
                               m_board.getRank(IRank.ChessboardRank.RANK5));
    result = instance.trySlide(p_from, p_to, p_position);
    assertFalse("?. d4xc5", result);    
    
    //?. d4xe5
    p_from = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEd),
                               m_board.getRank(IRank.ChessboardRank.RANK4));
    p_to   = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEe),
                               m_board.getRank(IRank.ChessboardRank.RANK5));
    result = instance.trySlide(p_from, p_to, p_position);
    assertFalse("?. d4xe5", result); 
    
    //?. e4xf3 e.p.
    p_position = new PositionTest.MockedPosition();
    ISquare sq1;
    sq1 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEe),
                            m_board.getRank(IRank.ChessboardRank.RANK1));
    ((PositionTest.MockedPosition)p_position).addPiece(sq1,
                                          PieceBox.getInstance().createWhiteKing());
    sq1 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEe),
                            m_board.getRank(IRank.ChessboardRank.RANK8));
    ((PositionTest.MockedPosition)p_position).addPiece(sq1,
                                          PieceBox.getInstance().createBlackKing());
    sq1 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEf),
                            m_board.getRank(IRank.ChessboardRank.RANK4));
    ((PositionTest.MockedPosition)p_position).addPiece(sq1,
                                          PieceBox.getInstance().createWhitePawn());
    sq1 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEe),
                            m_board.getRank(IRank.ChessboardRank.RANK4));
    ((PositionTest.MockedPosition)p_position).addPiece(sq1,
                                          PieceBox.getInstance().createBlackPawn());
    sq1 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEf),
                            m_board.getRank(IRank.ChessboardRank.RANK3));
    ((PositionTest.MockedPosition)p_position).mockEnpassant(sq1);
    p_from = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEe),
                               m_board.getRank(IRank.ChessboardRank.RANK4));
    p_to   = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEf),
                               m_board.getRank(IRank.ChessboardRank.RANK3));
    result = instance.trySlide(p_from, p_to, p_position);
    assertTrue("?. e4xf3 e.p.", result);    

    //?. false e4xf3 e.p. 
    p_position = new PositionTest.MockedPosition();
    sq1 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEe),
                            m_board.getRank(IRank.ChessboardRank.RANK1));
    ((PositionTest.MockedPosition)p_position).addPiece(sq1,
                                          PieceBox.getInstance().createWhiteKing());
    sq1 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEe),
                            m_board.getRank(IRank.ChessboardRank.RANK8));
    ((PositionTest.MockedPosition)p_position).addPiece(sq1,
                                          PieceBox.getInstance().createBlackKing());
    sq1 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEf),
                            m_board.getRank(IRank.ChessboardRank.RANK4));
    ((PositionTest.MockedPosition)p_position).addPiece(sq1,
                                          PieceBox.getInstance().createWhitePawn());
    sq1 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEe),
                            m_board.getRank(IRank.ChessboardRank.RANK4));
    ((PositionTest.MockedPosition)p_position).addPiece(sq1,
                                          PieceBox.getInstance().createBlackPawn());
    p_from = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEe),
                               m_board.getRank(IRank.ChessboardRank.RANK4));
    p_to   = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEf),
                               m_board.getRank(IRank.ChessboardRank.RANK3));
    result = instance.trySlide(p_from, p_to, p_position);
    assertFalse("?. false e4xf3 e.p.", result);        
  }
  
   /**
   * Test of generateSlides method, of class BlackPawn.
   */
  @Test
  public void testGenerateSlides() throws Exception
  {
    System.out.println("Black pawn generateSlides");    
    
    IPosition pzl;
    ISquare[] slides;
    IPiece pawn;
    ISquare e1 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEe),
                                   m_board.getRank(IRank.ChessboardRank.RANK1));
    ISquare e8 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEe),
                                   m_board.getRank(IRank.ChessboardRank.RANK8));
    ISquare e7 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEe),
                                   m_board.getRank(IRank.ChessboardRank.RANK7));
    ISquare e6 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEe),
                                   m_board.getRank(IRank.ChessboardRank.RANK6));
    ISquare e5 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEe),
                                   m_board.getRank(IRank.ChessboardRank.RANK5));
    ISquare f6 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEf),
                                   m_board.getRank(IRank.ChessboardRank.RANK6));
    ISquare d6 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEd),
                                   m_board.getRank(IRank.ChessboardRank.RANK6));
    ISquare h6 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEh),
                                   m_board.getRank(IRank.ChessboardRank.RANK6));
    ISquare g5 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEg),
                                   m_board.getRank(IRank.ChessboardRank.RANK5));
    ISquare h5 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEh),
                                   m_board.getRank(IRank.ChessboardRank.RANK5));
    ISquare a2 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEa),
                                   m_board.getRank(IRank.ChessboardRank.RANK2));
    ISquare a1 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEa),
                                   m_board.getRank(IRank.ChessboardRank.RANK1));
    ISquare b1 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEb),
                                   m_board.getRank(IRank.ChessboardRank.RANK1));
    
    
    ISquarePiece[] pieceList = new ISquarePiece[5];
    pieceList[0] = new SquarePiece(e1,PieceBox.getInstance().createWhiteKing());
    pieceList[1] = new SquarePiece(e8,PieceBox.getInstance().createBlackKing());
    pieceList[2] = new SquarePiece(e7,PieceBox.getInstance().createBlackPawn());
    pieceList[3] = new SquarePiece(f6,PieceBox.getInstance().createWhitePawn());
    pieceList[4] = new SquarePiece(d6,PieceBox.getInstance().createWhiteRook());
    
    pzl = new PuzzlePosition();
    ((PuzzlePosition)pzl).set(pieceList,
                              ChessColor.getInstance().getBlack(),
                              false,false,false,false,
                              null,
                              0,1);
    pawn = pzl.getPiece(e7);
    
    slides = pawn.generateSlides(e7, pzl);
    assertFalse(slides == null);   
    assertTrue(slides.length == 4);   
    assertTrue(squareFound(slides,e6));       
    assertTrue(squareFound(slides,e6));
    assertTrue(squareFound(slides,f6));       
    assertTrue(squareFound(slides,d6));

    pieceList = new ISquarePiece[3];
    pieceList[0] = new SquarePiece(e1,PieceBox.getInstance().createWhiteKing());
    pieceList[1] = new SquarePiece(e8,PieceBox.getInstance().createBlackKing());
    pieceList[2] = new SquarePiece(e7,PieceBox.getInstance().createBlackPawn());
    
    pzl = new PuzzlePosition();
    ((PuzzlePosition)pzl).set(pieceList,
                              ChessColor.getInstance().getBlack(),
                              false,false,false,false,
                              null,
                              0,1);
    pawn = pzl.getPiece(e7);
    
    slides = pawn.generateSlides(e7, pzl);
    assertFalse(slides == null);   
    assertTrue(slides.length == 2);   
    assertTrue(squareFound(slides,e6));       
    assertTrue(squareFound(slides,e5));

    pieceList = new ISquarePiece[4];
    pieceList[0] = new SquarePiece(e1,PieceBox.getInstance().createWhiteKing());
    pieceList[1] = new SquarePiece(e8,PieceBox.getInstance().createBlackKing());
    pieceList[2] = new SquarePiece(e7,PieceBox.getInstance().createBlackPawn());
    pieceList[3] = new SquarePiece(e5,PieceBox.getInstance().createBlackPawn());
    
    pzl = new PuzzlePosition();
    ((PuzzlePosition)pzl).set(pieceList,
                              ChessColor.getInstance().getBlack(),
                              false,false,false,false,
                              null,
                              0,1);
    pawn = pzl.getPiece(e7);
    
    slides = pawn.generateSlides(e7, pzl);
    assertFalse(slides == null);   
    assertTrue(slides.length == 1);   
    assertTrue(squareFound(slides,e6));       

    pieceList = new ISquarePiece[5];
    pieceList[0] = new SquarePiece(e1,PieceBox.getInstance().createWhiteKing());
    pieceList[1] = new SquarePiece(e8,PieceBox.getInstance().createBlackKing());
    pieceList[2] = new SquarePiece(e7,PieceBox.getInstance().createBlackPawn());
    pieceList[3] = new SquarePiece(e5,PieceBox.getInstance().createBlackPawn());
    pieceList[4] = new SquarePiece(e6,PieceBox.getInstance().createWhitePawn());
    
    pzl = new PuzzlePosition();
    ((PuzzlePosition)pzl).set(pieceList,
                              ChessColor.getInstance().getBlack(),
                              false,false,false,false,
                              null,
                              0,1);
    pawn = pzl.getPiece(e7);
    
    slides = pawn.generateSlides(e7, pzl);
    assertFalse(slides == null);   
    assertTrue(slides.length == 0);   
    
    pieceList = new ISquarePiece[4];
    pieceList[0] = new SquarePiece(e1,PieceBox.getInstance().createWhiteKing());
    pieceList[1] = new SquarePiece(e8,PieceBox.getInstance().createBlackKing());
    pieceList[2] = new SquarePiece(h6,PieceBox.getInstance().createBlackPawn());
    pieceList[3] = new SquarePiece(g5,PieceBox.getInstance().createWhitePawn());
    
    pzl = new PuzzlePosition();
    ((PuzzlePosition)pzl).set(pieceList,
                              ChessColor.getInstance().getBlack(),
                              false,false,false,false,
                              null,
                              0,1);
    pawn = pzl.getPiece(h6);
    
    slides = pawn.generateSlides(h6, pzl);
    assertFalse(slides == null);   
    assertTrue(slides.length == 2);   
    assertTrue(squareFound(slides,h5));
    assertTrue(squareFound(slides,g5));       
    
    pieceList = new ISquarePiece[4];
    pieceList[0] = new SquarePiece(e1,PieceBox.getInstance().createWhiteKing());
    pieceList[1] = new SquarePiece(e8,PieceBox.getInstance().createBlackKing());
    pieceList[2] = new SquarePiece(a2,PieceBox.getInstance().createBlackPawn());
    pieceList[3] = new SquarePiece(b1,PieceBox.getInstance().createWhiteKnight());
    
    pzl = new PuzzlePosition();
    ((PuzzlePosition)pzl).set(pieceList,
                              ChessColor.getInstance().getBlack(),
                              false,false,false,false,
                              null,
                              0,1);
    pawn = pzl.getPiece(a2);
    
    slides = pawn.generateSlides(a2, pzl);
    assertFalse(slides == null);   
    assertTrue(slides.length == 2);   
    assertTrue(squareFound(slides,a1));
    assertTrue(squareFound(slides,b1));           
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
