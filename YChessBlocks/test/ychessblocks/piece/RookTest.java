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
import ychessblocks.board.IBoard;
import ychessblocks.board.IFile;
import ychessblocks.board.IRank;
import ychessblocks.board.ISquare;
import ychessblocks.position.IPosition;
import ychessblocks.position.ISquarePiece;
import ychessblocks.position.Position;
import ychessblocks.position.PuzzlePosition;
import ychessblocks.position.SquarePiece;

/**
 *
 * @author Yair
 */
public class RookTest 
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

  public RookTest() {
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
   * Test of trySlide method, of class WhiteRook.
   */
  @Test
  public void testWhiteRookTrySlide()
  {
    System.out.println("trySlide WhiteRook");
    
    IPosition p_position = new Position();
    p_position.set();    
    WhiteRook instance = (WhiteRook)(PieceBox.getInstance().createWhiteRook());
    
    boolean result = instance.trySlide(e4, e5, p_position);
    assertTrue(result);
    result = instance.trySlide(e4, e6, p_position);
    assertTrue(result);
    result = instance.trySlide(e4, e7, p_position);
    assertTrue(result);
    result = instance.trySlide(e4, e8, p_position);
    assertFalse(result);

    result = instance.trySlide(e4, f4, p_position);
    assertTrue(result);
    result = instance.trySlide(e4, g4, p_position);
    assertTrue(result);
    result = instance.trySlide(e4, h4, p_position);
    assertTrue(result);

    result = instance.trySlide(e4, e3, p_position);
    assertTrue(result);
    result = instance.trySlide(e4, e2, p_position);
    assertFalse(result);
    result = instance.trySlide(e4, e1, p_position);
    assertFalse(result);

    result = instance.trySlide(e4, d4, p_position);
    assertTrue(result);
    result = instance.trySlide(e4, c4, p_position);
    assertTrue(result);
    result = instance.trySlide(e4, b4, p_position);
    assertTrue(result);
    result = instance.trySlide(e4, a4, p_position);
    assertTrue(result);

    result = instance.trySlide(h1, h1, p_position);
    assertFalse(result);  
    result = instance.trySlide(c3, f6, p_position);
    assertFalse(result);
    result = instance.trySlide(d6, f4, p_position);
    assertFalse(result);
    result = instance.trySlide(d6, a3, p_position);
    assertFalse(result);
    result = instance.trySlide(f3, d5, p_position);
    assertFalse(result);    
  }

  /**
   * Test of trySlide method, of class BlackRook.
   */
  @Test
  public void testBlackeRookTrySlide()
  {
    System.out.println("trySlide BlackRook");
    
    IPosition p_position = new Position();
    p_position.set();    
    BlackRook instance = (BlackRook)(PieceBox.getInstance().createBlackRook());
    
    boolean result = instance.trySlide(d4, d5, p_position);
    assertTrue(result);
    result = instance.trySlide(d4, d6, p_position);
    assertTrue(result);
    result = instance.trySlide(d4, d7, p_position);
    assertFalse(result);
    result = instance.trySlide(d4, d8, p_position);
    assertFalse(result);

    result = instance.trySlide(d4, e4, p_position);
    assertTrue(result);
    result = instance.trySlide(d4, f4, p_position);
    assertTrue(result);
    result = instance.trySlide(d4, g4, p_position);
    assertTrue(result);
    result = instance.trySlide(d4, g4, p_position);
    assertTrue(result);

    result = instance.trySlide(d4, d3, p_position);
    assertTrue(result);
    result = instance.trySlide(d4, d2, p_position);
    assertTrue(result);
    result = instance.trySlide(d4, d1, p_position);
    assertFalse(result);

    result = instance.trySlide(d4, c4, p_position);
    assertTrue(result);
    result = instance.trySlide(d4, b4, p_position);
    assertTrue(result);
    result = instance.trySlide(d4, a4, p_position);
    assertTrue(result);

    result = instance.trySlide(a6, a6, p_position);
    assertFalse(result);  
    result = instance.trySlide(c3, f6, p_position);
    assertFalse(result);
    result = instance.trySlide(d6, f4, p_position);
    assertFalse(result);
    result = instance.trySlide(d6, a3, p_position);
    assertFalse(result);
    result = instance.trySlide(f3, d5, p_position);
    assertFalse(result);    
  }

   /**
   * Test of generateSlides method, of class Rook.
   */
  @Test 
  public void testGenerateSlides() throws Exception
  {
    System.out.println("Rook generateSlides");    
    
    IPosition pzl;
    ISquare[] slides;
    IPiece rook;
    
    ISquarePiece[] pieceList = new ISquarePiece[3];
    pieceList[0] = new SquarePiece(e1,PieceBox.getInstance().createWhiteKing());
    pieceList[1] = new SquarePiece(e8,PieceBox.getInstance().createBlackKing());
    pieceList[2] = new SquarePiece(d5,PieceBox.getInstance().createWhiteRook());
    pzl = new PuzzlePosition();
    ((PuzzlePosition)pzl).set(pieceList,
                              ChessColor.getInstance().getWhite(),
                              false,false,false,false,
                              null,
                              0,1);
    rook = pzl.getPiece(d5);
    
    slides = rook.generateSlides(d5, pzl);
    assertFalse(slides == null);   
    assertTrue(slides.length == 14);   
    assertTrue(squareFound(slides,d6));       
    assertTrue(squareFound(slides,d7));       
    assertTrue(squareFound(slides,d8));       
    assertTrue(squareFound(slides,d4));       
    assertTrue(squareFound(slides,d3));       
    assertTrue(squareFound(slides,d2));       
    assertTrue(squareFound(slides,d1));       
    assertTrue(squareFound(slides,e5));       
    assertTrue(squareFound(slides,f5));       
    assertTrue(squareFound(slides,g5));       
    assertTrue(squareFound(slides,h5));       
    assertTrue(squareFound(slides,c5));       
    assertTrue(squareFound(slides,b5));       
    assertTrue(squareFound(slides,a5));       

    pieceList = new ISquarePiece[4];
    pieceList[0] = new SquarePiece(e1,PieceBox.getInstance().createWhiteKing());
    pieceList[1] = new SquarePiece(e8,PieceBox.getInstance().createBlackKing());
    pieceList[2] = new SquarePiece(h1,PieceBox.getInstance().createWhiteRook());
    pieceList[3] = new SquarePiece(a8,PieceBox.getInstance().createBlackRook());
    pzl = new PuzzlePosition();
    ((PuzzlePosition)pzl).set(pieceList,
                              ChessColor.getInstance().getBlack(),
                              false,false,false,false,
                              null,
                              0,1);
    rook = pzl.getPiece(a8);
    
    slides = rook.generateSlides(a8, pzl);
    assertFalse(slides == null);   
    assertTrue(slides.length == 10);   
    assertTrue(squareFound(slides,b8));       
    assertTrue(squareFound(slides,c8));       
    assertTrue(squareFound(slides,d8)); 
    assertTrue(squareFound(slides,a7));       
    assertTrue(squareFound(slides,a6));       
    assertTrue(squareFound(slides,a5));
    assertTrue(squareFound(slides,a4));       
    assertTrue(squareFound(slides,a3));       
    assertTrue(squareFound(slides,a2));       
    assertTrue(squareFound(slides,a1));       
    
    pieceList = new ISquarePiece[5];
    pieceList[0] = new SquarePiece(e1,PieceBox.getInstance().createWhiteKing());
    pieceList[1] = new SquarePiece(e8,PieceBox.getInstance().createBlackKing());
    pieceList[2] = new SquarePiece(h1,PieceBox.getInstance().createWhiteRook());
    pieceList[3] = new SquarePiece(a8,PieceBox.getInstance().createBlackRook());
    pieceList[4] = new SquarePiece(a6,PieceBox.getInstance().createWhiteBishop());
    pzl = new PuzzlePosition();
    ((PuzzlePosition)pzl).set(pieceList,
                              ChessColor.getInstance().getBlack(),
                              false,false,false,false,
                              null,
                              0,1);
    rook = pzl.getPiece(a8);
    
    slides = rook.generateSlides(a8, pzl);
    assertFalse(slides == null);   
    assertTrue(slides.length == 5);   
    assertTrue(squareFound(slides,b8));       
    assertTrue(squareFound(slides,c8));       
    assertTrue(squareFound(slides,d8)); 
    assertTrue(squareFound(slides,a7));       
    assertTrue(squareFound(slides,a6));    

    int i=0;
    pieceList = new ISquarePiece[23];
    pieceList[i++] = new SquarePiece(g1,PieceBox.getInstance().createWhiteKing());
    pieceList[i++] = new SquarePiece(e7,PieceBox.getInstance().createBlackKing());
    pieceList[i++] = new SquarePiece(f2,PieceBox.getInstance().createWhiteRook());    
    pieceList[i++] = new SquarePiece(f6,PieceBox.getInstance().createWhiteRook());
    pieceList[i++] = new SquarePiece(f8,PieceBox.getInstance().createBlackRook());    
    pieceList[i++] = new SquarePiece(a8,PieceBox.getInstance().createBlackRook());
    pieceList[i++] = new SquarePiece(c3,PieceBox.getInstance().createWhiteKnight());    
    pieceList[i++] = new SquarePiece(b3,PieceBox.getInstance().createWhiteBishop());
    pieceList[i++] = new SquarePiece(c8,PieceBox.getInstance().createBlackBishop());    
    pieceList[i++] = new SquarePiece(a2,PieceBox.getInstance().createWhitePawn());
    pieceList[i++] = new SquarePiece(b2,PieceBox.getInstance().createWhitePawn());
    pieceList[i++] = new SquarePiece(c2,PieceBox.getInstance().createWhitePawn());
    pieceList[i++] = new SquarePiece(d4,PieceBox.getInstance().createWhitePawn());
    pieceList[i++] = new SquarePiece(e4,PieceBox.getInstance().createWhitePawn());
    pieceList[i++] = new SquarePiece(g2,PieceBox.getInstance().createWhitePawn());
    pieceList[i++] = new SquarePiece(h3,PieceBox.getInstance().createWhitePawn());    
    pieceList[i++] = new SquarePiece(h7,PieceBox.getInstance().createBlackPawn());
    pieceList[i++] = new SquarePiece(h6,PieceBox.getInstance().createBlackPawn());
    pieceList[i++] = new SquarePiece(f7,PieceBox.getInstance().createBlackPawn());
    pieceList[i++] = new SquarePiece(d6,PieceBox.getInstance().createBlackPawn());
    pieceList[i++] = new SquarePiece(c5,PieceBox.getInstance().createBlackPawn());
    pieceList[i++] = new SquarePiece(b5,PieceBox.getInstance().createBlackPawn());
    pieceList[i++] = new SquarePiece(a6,PieceBox.getInstance().createBlackPawn());
    pzl = new PuzzlePosition();
    ((PuzzlePosition)pzl).set(pieceList,
                              ChessColor.getInstance().getWhite(),
                              false,false,false,false,
                              null,
                              0,18);
    rook = pzl.getPiece(f6);
    slides = rook.generateSlides(f6, pzl);
    assertFalse(slides == null);   
    assertTrue(slides.length == 8);   
    assertTrue(squareFound(slides,g6));       
    assertTrue(squareFound(slides,h6));       
    assertTrue(squareFound(slides,e6));       
    assertTrue(squareFound(slides,d6));
    assertTrue(squareFound(slides,f7));       
    assertTrue(squareFound(slides,f5));       
    assertTrue(squareFound(slides,f4));       
    assertTrue(squareFound(slides,f3));       
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
