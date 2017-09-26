/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ychessblocks.move;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import ychessblocks.board.Board;
import ychessblocks.board.IColor;
import ychessblocks.board.IFile;
import ychessblocks.board.IRank;
import ychessblocks.board.ISquare;
import ychessblocks.piece.*;
import ychessblocks.position.*;

/**
 *
 * @author Yair
 */
public class MoveInfoTest
{
  private static Board m_board;
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
  
  public MoveInfoTest() {
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
   * Test of execute method, of class MoveInfo.
   */
  @Test
  public void testExecute() throws Exception
  {
    System.out.println("execute");

    IPosition pos;
    MoveInfo head;
    MoveInfo curr;
    IPieceBox pbox = PieceBox.getInstance();
    MoveInfo prev;
    
    //Nunn - Sosonko
    //Tilburg 82
    //1-0
    //"Shahmat" #2, FEB-1983
    pos = new Position();
    pos.set();
    
    head = new MoveInfo(pos,null);
    
    curr = head;
    //1. e4 c6
    curr.execute(e2, e4);
    assertTrue(curr.getColor().getColor() == IColor.ChessColor.WHITE);
    assertTrue(curr.getFrom().equals(e2));
    assertTrue(curr.getTo().equals(e4));
    assertTrue(curr.getPiece().equals(pbox.createWhitePawn()));
    assertEquals(pos, curr.getPosition());
    assertTrue(curr.getPrev() == null);
    assertTrue(curr.getNext().getPrev() == curr);
    prev = curr;
    curr = (MoveInfo)(curr.getNext());
    pos = curr.getPosition();
    
    curr.execute(c7, c6);
    assertTrue(curr.getColor().getColor() == IColor.ChessColor.BLACK);
    assertTrue(curr.getFrom().equals(c7));
    assertTrue(curr.getTo().equals(c6));
    assertTrue(curr.getPiece().equals(pbox.createBlackPawn()));
    assertEquals(pos, curr.getPosition());
    assertTrue(curr.getPrev() == prev);
    assertTrue(curr.getNext().getPrev() == curr);
    prev = curr;
    curr = (MoveInfo)(curr.getNext());
    pos = curr.getPosition();
    
    //2. d4 d5
    curr.execute(d2, d4);
    assertTrue(curr.getColor().getColor() == IColor.ChessColor.WHITE);
    assertTrue(curr.getFrom().equals(d2));
    assertTrue(curr.getTo().equals(d4));
    assertTrue(curr.getPiece().equals(pbox.createWhitePawn()));
    assertEquals(pos, curr.getPosition());
    assertTrue(curr.getPrev() == prev);
    assertTrue(curr.getNext().getPrev() == curr);
    prev = curr;
    curr = (MoveInfo)(curr.getNext());
    pos = curr.getPosition();
    
    curr.execute(d7, d5);
    assertTrue(curr.getColor().getColor() == IColor.ChessColor.BLACK);
    assertTrue(curr.getFrom().equals(d7));
    assertTrue(curr.getTo().equals(d5));
    assertTrue(curr.getPiece().equals(pbox.createBlackPawn()));
    assertEquals(pos, curr.getPosition());
    assertTrue(curr.getPrev() == prev);
    assertTrue(curr.getNext().getPrev() == curr);
    prev = curr;
    curr = (MoveInfo)(curr.getNext());
    pos = curr.getPosition();

    //3. e5 Bf5
    curr.execute(e4, e5);
    assertTrue(curr.getColor().getColor() == IColor.ChessColor.WHITE);
    assertTrue(curr.getFrom().equals(e4));
    assertTrue(curr.getTo().equals(e5));
    assertTrue(curr.getPiece().equals(pbox.createWhitePawn()));
    assertEquals(pos, curr.getPosition());
    assertTrue(curr.getPrev() == prev);
    assertTrue(curr.getNext().getPrev() == curr);
    prev = curr;
    curr = (MoveInfo)(curr.getNext());
    pos = curr.getPosition();
    
    curr.execute(c8, f5);
    assertTrue(curr.getColor().getColor() == IColor.ChessColor.BLACK);
    assertTrue(curr.getFrom().equals(c8));
    assertTrue(curr.getTo().equals(f5));
    assertTrue(curr.getPiece().equals(pbox.createBlackBishop()));
    assertEquals(pos, curr.getPosition());
    assertTrue(curr.getPrev() == prev);
    assertTrue(curr.getNext().getPrev() == curr);
    prev = curr;
    curr = (MoveInfo)(curr.getNext());
    pos = curr.getPosition();

    //4. Nc3 e6
    curr.execute(b1, c3);
    assertTrue(curr.getColor().getColor() == IColor.ChessColor.WHITE);
    assertTrue(curr.getFrom().equals(b1));
    assertTrue(curr.getTo().equals(c3));
    assertTrue(curr.getPiece().equals(pbox.createWhiteKnight()));
    assertEquals(pos, curr.getPosition());
    assertTrue(curr.getPrev() == prev);
    assertTrue(curr.getNext().getPrev() == curr);
    prev = curr;
    curr = (MoveInfo)(curr.getNext());
    pos = curr.getPosition();
    
    curr.execute(e7, e6);
    assertTrue(curr.getColor().getColor() == IColor.ChessColor.BLACK);
    assertTrue(curr.getFrom().equals(e7));
    assertTrue(curr.getTo().equals(e6));
    assertTrue(curr.getPiece().equals(pbox.createBlackPawn()));
    assertEquals(pos, curr.getPosition());
    assertTrue(curr.getPrev() == prev);
    assertTrue(curr.getNext().getPrev() == curr);
    prev = curr;
    curr = (MoveInfo)(curr.getNext());
    pos = curr.getPosition();

    //5. g4 Bg6
    curr.execute(g2, g4);
    assertTrue(curr.getColor().getColor() == IColor.ChessColor.WHITE);
    assertTrue(curr.getFrom().equals(g2));
    assertTrue(curr.getTo().equals(g4));
    assertTrue(curr.getPiece().equals(pbox.createWhitePawn()));
    assertEquals(pos, curr.getPosition());
    assertTrue(curr.getPrev() == prev);
    assertTrue(curr.getNext().getPrev() == curr);
    prev = curr;
    curr = (MoveInfo)(curr.getNext());
    pos = curr.getPosition();
    
    curr.execute(f5, g6);
    assertTrue(curr.getColor().getColor() == IColor.ChessColor.BLACK);
    assertTrue(curr.getFrom().equals(f5));
    assertTrue(curr.getTo().equals(g6));
    assertTrue(curr.getPiece().equals(pbox.createBlackBishop()));
    assertEquals(pos, curr.getPosition());
    assertTrue(curr.getPrev() == prev);
    assertTrue(curr.getNext().getPrev() == curr);
    prev = curr;
    curr = (MoveInfo)(curr.getNext());
    pos = curr.getPosition();

    //6. Nge2 c5
    curr.execute(g1, e2);
    assertTrue(curr.getColor().getColor() == IColor.ChessColor.WHITE);
    assertTrue(curr.getFrom().equals(g1));
    assertTrue(curr.getTo().equals(e2));
    assertTrue(curr.getPiece().equals(pbox.createWhiteKnight()));
    assertEquals(pos, curr.getPosition());
    assertTrue(curr.getPrev() == prev);
    assertTrue(curr.getNext().getPrev() == curr);
    prev = curr;
    curr = (MoveInfo)(curr.getNext());
    pos = curr.getPosition();
    
    curr.execute(c6, c5);
    assertTrue(curr.getColor().getColor() == IColor.ChessColor.BLACK);
    assertTrue(curr.getFrom().equals(c6));
    assertTrue(curr.getTo().equals(c5));
    assertTrue(curr.getPiece().equals(pbox.createBlackPawn()));
    assertEquals(pos, curr.getPosition());
    assertTrue(curr.getPrev() == prev);
    assertTrue(curr.getNext().getPrev() == curr);
    prev = curr;
    curr = (MoveInfo)(curr.getNext());
    pos = curr.getPosition();

    //7. Be3 Nc6
    curr.execute(c1, e3);
    assertTrue(curr.getColor().getColor() == IColor.ChessColor.WHITE);
    assertTrue(curr.getFrom().equals(c1));
    assertTrue(curr.getTo().equals(e3));
    assertTrue(curr.getPiece().equals(pbox.createWhiteBishop()));
    assertEquals(pos, curr.getPosition());
    assertTrue(curr.getPrev() == prev);
    assertTrue(curr.getNext().getPrev() == curr);
    prev = curr;
    curr = (MoveInfo)(curr.getNext());
    pos = curr.getPosition();
    
    curr.execute(b8, c6);
    assertTrue(curr.getColor().getColor() == IColor.ChessColor.BLACK);
    assertTrue(curr.getFrom().equals(b8));
    assertTrue(curr.getTo().equals(c6));
    assertTrue(curr.getPiece().equals(pbox.createBlackKnight()));
    assertEquals(pos, curr.getPosition());
    assertTrue(curr.getPrev() == prev);
    assertTrue(curr.getNext().getPrev() == curr);
    prev = curr;
    curr = (MoveInfo)(curr.getNext());
    pos = curr.getPosition();

    //8. dxc Qh4
    curr.execute(d4, c5);
    assertTrue(curr.getColor().getColor() == IColor.ChessColor.WHITE);
    assertTrue(curr.getFrom().equals(d4));
    assertTrue(curr.getTo().equals(c5));
    assertTrue(curr.getPiece().equals(pbox.createWhitePawn()));
    assertEquals(pos, curr.getPosition());
    assertTrue(curr.getPrev() == prev);
    assertTrue(curr.getNext().getPrev() == curr);
    prev = curr;
    curr = (MoveInfo)(curr.getNext());
    pos = curr.getPosition();
    
    curr.execute(d8, h4);
    assertTrue(curr.getColor().getColor() == IColor.ChessColor.BLACK);
    assertTrue(curr.getFrom().equals(d8));
    assertTrue(curr.getTo().equals(h4));
    assertTrue(curr.getPiece().equals(pbox.createBlackQueen()));
    assertEquals(pos, curr.getPosition());
    assertTrue(curr.getPrev() == prev);
    assertTrue(curr.getNext().getPrev() == curr);
    prev = curr;
    curr = (MoveInfo)(curr.getNext());
    pos = curr.getPosition();

    //9. Nb5 Nh6?!
    curr.execute(c3, b5);
    assertTrue(curr.getColor().getColor() == IColor.ChessColor.WHITE);
    assertEquals(pos, curr.getPosition());
    assertTrue(curr.getPrev() == prev);
    assertTrue(curr.getNext().getPrev() == curr);
    prev = curr;
    curr = (MoveInfo)(curr.getNext());
    pos = curr.getPosition();
    
    curr.execute(g8, h6);
    assertTrue(curr.getColor().getColor() == IColor.ChessColor.BLACK);
    assertEquals(pos, curr.getPosition());
    assertTrue(curr.getPrev() == prev);
    assertTrue(curr.getNext().getPrev() == curr);
    prev = curr;
    curr = (MoveInfo)(curr.getNext());
    pos = curr.getPosition();

    //10. h3 Rc8
    curr.execute(h2, h3);
    assertTrue(curr.getColor().getColor() == IColor.ChessColor.WHITE);
    assertEquals(pos, curr.getPosition());
    assertTrue(curr.getPrev() == prev);
    assertTrue(curr.getNext().getPrev() == curr);
    prev = curr;
    curr = (MoveInfo)(curr.getNext());
    pos = curr.getPosition();
    
    curr.execute(a8, c8);
    assertTrue(curr.getColor().getColor() == IColor.ChessColor.BLACK);
    assertEquals(pos, curr.getPosition());
    assertTrue(curr.getPrev() == prev);
    assertTrue(curr.getNext().getPrev() == curr);
    prev = curr;
    curr = (MoveInfo)(curr.getNext());
    pos = curr.getPosition();

    //11. Ng3 Nxe5
    curr.execute(e2, g3);
    assertTrue(curr.getColor().getColor() == IColor.ChessColor.WHITE);
    assertEquals(pos, curr.getPosition());
    assertTrue(curr.getPrev() == prev);
    assertTrue(curr.getNext().getPrev() == curr);
    prev = curr;
    curr = (MoveInfo)(curr.getNext());
    pos = curr.getPosition();
    
    curr.execute(c6, e5);
    assertTrue(curr.getColor().getColor() == IColor.ChessColor.BLACK);
    assertEquals(pos, curr.getPosition());
    assertTrue(curr.getPrev() == prev);
    assertTrue(curr.getNext().getPrev() == curr);
    prev = curr;
    curr = (MoveInfo)(curr.getNext());
    pos = curr.getPosition();

    //12. Nxa7 Rxc5!
    curr.execute(b5, a7);
    assertTrue(curr.getColor().getColor() == IColor.ChessColor.WHITE);
    assertEquals(pos, curr.getPosition());
    assertTrue(curr.getPrev() == prev);
    assertTrue(curr.getNext().getPrev() == curr);
    prev = curr;
    curr = (MoveInfo)(curr.getNext());
    pos = curr.getPosition();
    
    curr.execute(c8, c5);
    assertTrue(curr.getColor().getColor() == IColor.ChessColor.BLACK);
    assertEquals(pos, curr.getPosition());
    assertTrue(curr.getPrev() == prev);
    assertTrue(curr.getNext().getPrev() == curr);
    prev = curr;
    curr = (MoveInfo)(curr.getNext());
    pos = curr.getPosition();

    //13. c3 Nc4
    curr.execute(c2, c3);
    assertTrue(curr.getColor().getColor() == IColor.ChessColor.WHITE);
    assertEquals(pos, curr.getPosition());
    assertTrue(curr.getPrev() == prev);
    assertTrue(curr.getNext().getPrev() == curr);
    prev = curr;
    curr = (MoveInfo)(curr.getNext());
    pos = curr.getPosition();
    
    curr.execute(e5, c4);
    assertTrue(curr.getColor().getColor() == IColor.ChessColor.BLACK);
    assertEquals(pos, curr.getPosition());
    assertTrue(curr.getPrev() == prev);
    assertTrue(curr.getNext().getPrev() == curr);
    prev = curr;
    curr = (MoveInfo)(curr.getNext());
    pos = curr.getPosition();

    //14. Bxc5 Bxc5
    curr.execute(e3, c5);
    assertTrue(curr.getColor().getColor() == IColor.ChessColor.WHITE);
    assertEquals(pos, curr.getPosition());
    assertTrue(curr.getPrev() == prev);
    assertTrue(curr.getNext().getPrev() == curr);
    prev = curr;
    curr = (MoveInfo)(curr.getNext());
    pos = curr.getPosition();
    
    curr.execute(f8, c5);
    assertTrue(curr.getColor().getColor() == IColor.ChessColor.BLACK);
    assertEquals(pos, curr.getPosition());
    assertTrue(curr.getPrev() == prev);
    assertTrue(curr.getNext().getPrev() == curr);
    prev = curr;
    curr = (MoveInfo)(curr.getNext());
    pos = curr.getPosition();

    //15. Qa4+ Ke7
    curr.execute(d1, a4);
    assertTrue(curr.getColor().getColor() == IColor.ChessColor.WHITE);
    assertEquals(pos, curr.getPosition());
    assertTrue(curr.getPrev() == prev);
    assertTrue(curr.getNext().getPrev() == curr);
    prev = curr;
    curr = (MoveInfo)(curr.getNext());
    pos = curr.getPosition();
    
    curr.execute(e8, e7);
    assertTrue(curr.getColor().getColor() == IColor.ChessColor.BLACK);
    assertEquals(pos, curr.getPosition());
    assertTrue(curr.getPrev() == prev);
    assertTrue(curr.getNext().getPrev() == curr);
    prev = curr;
    curr = (MoveInfo)(curr.getNext());
    pos = curr.getPosition();

    //16. Bxc4 Qf6!
    curr.execute(f1, c4);
    assertTrue(curr.getColor().getColor() == IColor.ChessColor.WHITE);
    assertEquals(pos, curr.getPosition());
    assertTrue(curr.getPrev() == prev);
    assertTrue(curr.getNext().getPrev() == curr);
    prev = curr;
    curr = (MoveInfo)(curr.getNext());
    pos = curr.getPosition();
    
    curr.execute(h4, f6);
    assertTrue(curr.getColor().getColor() == IColor.ChessColor.BLACK);
    assertEquals(pos, curr.getPosition());
    assertTrue(curr.getPrev() == prev);
    assertTrue(curr.getNext().getPrev() == curr);
    prev = curr;
    curr = (MoveInfo)(curr.getNext());
    pos = curr.getPosition();
    
    //Lets take a break for a moment to test the position
    assertEquals(pbox.createWhiteRook(), pos.getPiece(a1));
    assertEquals(null, pos.getPiece(b1));
    assertEquals(null, pos.getPiece(c1));
    assertEquals(null, pos.getPiece(d1));
    assertEquals(pbox.createWhiteKing(), pos.getPiece(e1));
    assertEquals(null, pos.getPiece(f1));
    assertEquals(null, pos.getPiece(g1));
    assertEquals(pbox.createWhiteRook(), pos.getPiece(h1));
    assertEquals(pbox.createWhitePawn(), pos.getPiece(a2));
    assertEquals(pbox.createWhitePawn(), pos.getPiece(b2));
    assertEquals(null, pos.getPiece(c2));
    assertEquals(null, pos.getPiece(d2));
    assertEquals(null, pos.getPiece(e2));
    assertEquals(pbox.createWhitePawn(), pos.getPiece(f2));
    assertEquals(null, pos.getPiece(g2));
    assertEquals(null, pos.getPiece(h2));
    assertEquals(null, pos.getPiece(a3));
    assertEquals(null, pos.getPiece(b3));
    assertEquals(pbox.createWhitePawn(), pos.getPiece(c3));
    assertEquals(null, pos.getPiece(d3));
    assertEquals(null, pos.getPiece(e3));
    assertEquals(null, pos.getPiece(f3));
    assertEquals(pbox.createWhiteKnight(), pos.getPiece(g3));
    assertEquals(pbox.createWhitePawn(), pos.getPiece(h3));
    assertEquals(pbox.createWhiteQueen(), pos.getPiece(a4));
    assertEquals(null, pos.getPiece(b4));
    assertEquals(pbox.createWhiteBishop(), pos.getPiece(c4));
    assertEquals(null, pos.getPiece(d4));
    assertEquals(null, pos.getPiece(e4));
    assertEquals(null, pos.getPiece(f4));
    assertEquals(pbox.createWhitePawn(), pos.getPiece(g4));
    assertEquals(null, pos.getPiece(h4));
    assertEquals(null, pos.getPiece(a5));
    assertEquals(null, pos.getPiece(b5));
    assertEquals(pbox.createBlackBishop(), pos.getPiece(c5));
    assertEquals(pbox.createBlackPawn(), pos.getPiece(d5));
    assertEquals(null, pos.getPiece(e5));
    assertEquals(null, pos.getPiece(f5));
    assertEquals(null, pos.getPiece(g5));
    assertEquals(null, pos.getPiece(h5));
    assertEquals(null, pos.getPiece(a6));
    assertEquals(null, pos.getPiece(b6));
    assertEquals(null, pos.getPiece(c6));
    assertEquals(null, pos.getPiece(d6));
    assertEquals(pbox.createBlackPawn(), pos.getPiece(e6));
    assertEquals(pbox.createBlackQueen(), pos.getPiece(f6));
    assertEquals(pbox.createBlackBishop(), pos.getPiece(g6));
    assertEquals(pbox.createBlackKnight(), pos.getPiece(h6));
    assertEquals(pbox.createWhiteKnight(), pos.getPiece(a7));
    assertEquals(pbox.createBlackPawn(), pos.getPiece(b7));
    assertEquals(null, pos.getPiece(c7));
    assertEquals(null, pos.getPiece(d7));
    assertEquals(pbox.createBlackKing(), pos.getPiece(e7));
    assertEquals(pbox.createBlackPawn(), pos.getPiece(f7));
    assertEquals(pbox.createBlackPawn(), pos.getPiece(g7));
    assertEquals(pbox.createBlackPawn(), pos.getPiece(h7));
    assertEquals(null, pos.getPiece(a8));
    assertEquals(null, pos.getPiece(b8));
    assertEquals(null, pos.getPiece(c8));
    assertEquals(null, pos.getPiece(d8));
    assertEquals(null, pos.getPiece(e8));
    assertEquals(null, pos.getPiece(f8));
    assertEquals(null, pos.getPiece(g8));
    assertEquals(pbox.createBlackRook(), pos.getPiece(h8));
    assertTrue(pos.isWhite00());
    assertTrue(pos.isWhite000());
    assertFalse(pos.isBlack00());
    assertFalse(pos.isBlack000());
    assertEquals(null, pos.getEnpassant());
    assertEquals(1, pos.getHalfMoveCount());

    //17. 0-0 Qf3!
    curr.execute(e1, g1);
    assertTrue(curr.getColor().getColor() == IColor.ChessColor.WHITE);
    assertEquals(pos, curr.getPosition());
    assertTrue(curr.getPrev() == prev);
    assertTrue(curr.getNext().getPrev() == curr);
    prev = curr;
    curr = (MoveInfo)(curr.getNext());
    pos = curr.getPosition();
    
    curr.execute(f6, f3);
    assertTrue(curr.getColor().getColor() == IColor.ChessColor.BLACK);
    assertEquals(pos, curr.getPosition());
    assertTrue(curr.getPrev() == prev);
    assertTrue(curr.getNext().getPrev() == curr);
    prev = curr;
    curr = (MoveInfo)(curr.getNext());
    pos = curr.getPosition();
    
    //18. Bxd5! exd5
    curr.execute(c4, d5);
    assertTrue(curr.getColor().getColor() == IColor.ChessColor.WHITE);
    assertEquals(pos, curr.getPosition());
    assertTrue(curr.getPrev() == prev);
    assertTrue(curr.getNext().getPrev() == curr);
    prev = curr;
    curr = (MoveInfo)(curr.getNext());
    pos = curr.getPosition();
    
    curr.execute(e6, d5);
    assertTrue(curr.getColor().getColor() == IColor.ChessColor.BLACK);
    assertEquals(pos, curr.getPosition());
    assertTrue(curr.getPrev() == prev);
    assertTrue(curr.getNext().getPrev() == curr);
    prev = curr;
    curr = (MoveInfo)(curr.getNext());
    pos = curr.getPosition();

    //19. Rae1+ Kd8
    curr.execute(a1, e1);
    assertTrue(curr.getColor().getColor() == IColor.ChessColor.WHITE);
    assertEquals(pos, curr.getPosition());
    assertTrue(curr.getPrev() == prev);
    assertTrue(curr.getNext().getPrev() == curr);
    prev = curr;
    curr = (MoveInfo)(curr.getNext());
    pos = curr.getPosition();
    
    curr.execute(e7, d8);
    assertTrue(curr.getColor().getColor() == IColor.ChessColor.BLACK);
    assertEquals(pos, curr.getPosition());
    assertTrue(curr.getPrev() == prev);
    assertTrue(curr.getNext().getPrev() == curr);
    prev = curr;
    curr = (MoveInfo)(curr.getNext());
    pos = curr.getPosition();

    //20. Nc6+! Kc7
    curr.execute(a7, c6);
    assertTrue(curr.getColor().getColor() == IColor.ChessColor.WHITE);
    assertEquals(pos, curr.getPosition());
    assertTrue(curr.getPrev() == prev);
    assertTrue(curr.getNext().getPrev() == curr);
    prev = curr;
    curr = (MoveInfo)(curr.getNext());
    pos = curr.getPosition();
    
    curr.execute(d8, c7);
    assertTrue(curr.getColor().getColor() == IColor.ChessColor.BLACK);
    assertEquals(pos, curr.getPosition());
    assertTrue(curr.getPrev() == prev);
    assertTrue(curr.getNext().getPrev() == curr);
    prev = curr;
    curr = (MoveInfo)(curr.getNext());
    pos = curr.getPosition();

    //21. Nd4 Qf6
    curr.execute(c6, d4);
    assertTrue(curr.getColor().getColor() == IColor.ChessColor.WHITE);
    assertEquals(pos, curr.getPosition());
    assertTrue(curr.getPrev() == prev);
    assertTrue(curr.getNext().getPrev() == curr);
    prev = curr;
    curr = (MoveInfo)(curr.getNext());
    pos = curr.getPosition();
    
    curr.execute(f3,f6);
    assertTrue(curr.getColor().getColor() == IColor.ChessColor.BLACK);
    assertEquals(pos, curr.getPosition());
    assertTrue(curr.getPrev() == prev);
    assertTrue(curr.getNext().getPrev() == curr);
    prev = curr;
    curr = (MoveInfo)(curr.getNext());
    pos = curr.getPosition();
    //Black resign, 1-0
  }

  /**
   * Test of getPosition method, of class MoveInfo.
   */
  @Test
  public void testGetPosition() 
  {
    System.out.println("getPosition");
    
    MoveInfo instance;
    IPosition expResult;    
    IPosition result;
    
    expResult = new Position();
    expResult.set();
    instance = new MoveInfo(expResult, null);
    result = instance.getPosition();
    
    assertEquals(expResult, result);
  }

  /**
   * Test of variations method, of class MoveInfo.
   */
  @Test
  public void testVariations()  throws Exception
  {
    System.out.println("variations");
    
    IPosition pos;
    MoveInfo head;
    MoveInfo curr;
    IPieceBox pbox = PieceBox.getInstance();
    MoveInfo prev;
    MoveInfo analisys;
    MoveInfo analisys1;
    MoveInfo variant;
    
    //Nunn - Sosonko
    //Tilburg 82
    //1-0
    //"Shahmat" #2, FEB-1983
    //Analisys by M. Czerniak.
    
    pos = new Position();
    pos.set();
    
    head = new MoveInfo(pos,null);
    
    curr = head;
    //1. e4 c6
    curr.execute(e2, e4);
    assertTrue(curr.getColor().getColor() == IColor.ChessColor.WHITE);
    assertTrue(curr.getFrom().equals(e2));
    assertTrue(curr.getTo().equals(e4));
    assertTrue(curr.getPiece().equals(pbox.createWhitePawn()));
    assertEquals(pos, curr.getPosition());
    assertTrue(curr.getPrev() == null);
    assertTrue(curr.getNext().getPrev() == curr);
    prev = curr;
    curr = (MoveInfo)(curr.getNext());
    pos = curr.getPosition();
    
    curr.execute(c7, c6);
    assertTrue(curr.getColor().getColor() == IColor.ChessColor.BLACK);
    assertTrue(curr.getFrom().equals(c7));
    assertTrue(curr.getTo().equals(c6));
    assertTrue(curr.getPiece().equals(pbox.createBlackPawn()));
    assertEquals(pos, curr.getPosition());
    assertTrue(curr.getPrev() == prev);
    assertTrue(curr.getNext().getPrev() == curr);
    prev = curr;
    curr = (MoveInfo)(curr.getNext());
    pos = curr.getPosition();
    
    //2. d4 d5
    curr.execute(d2, d4);
    assertTrue(curr.getColor().getColor() == IColor.ChessColor.WHITE);
    assertTrue(curr.getFrom().equals(d2));
    assertTrue(curr.getTo().equals(d4));
    assertTrue(curr.getPiece().equals(pbox.createWhitePawn()));
    assertEquals(pos, curr.getPosition());
    assertTrue(curr.getPrev() == prev);
    assertTrue(curr.getNext().getPrev() == curr);
    prev = curr;
    curr = (MoveInfo)(curr.getNext());
    pos = curr.getPosition();
    
    curr.execute(d7, d5);
    assertTrue(curr.getColor().getColor() == IColor.ChessColor.BLACK);
    assertTrue(curr.getFrom().equals(d7));
    assertTrue(curr.getTo().equals(d5));
    assertTrue(curr.getPiece().equals(pbox.createBlackPawn()));
    assertEquals(pos, curr.getPosition());
    assertTrue(curr.getPrev() == prev);
    assertTrue(curr.getNext().getPrev() == curr);
    prev = curr;
    curr = (MoveInfo)(curr.getNext());
    pos = curr.getPosition();

    //3. e5 Bf5
    curr.execute(e4, e5);
    assertTrue(curr.getColor().getColor() == IColor.ChessColor.WHITE);
    assertTrue(curr.getFrom().equals(e4));
    assertTrue(curr.getTo().equals(e5));
    assertTrue(curr.getPiece().equals(pbox.createWhitePawn()));
    assertEquals(pos, curr.getPosition());
    assertTrue(curr.getPrev() == prev);
    assertTrue(curr.getNext().getPrev() == curr);
    prev = curr;
    curr = (MoveInfo)(curr.getNext());
    pos = curr.getPosition();
    
    curr.execute(c8, f5);
    assertTrue(curr.getColor().getColor() == IColor.ChessColor.BLACK);
    assertTrue(curr.getFrom().equals(c8));
    assertTrue(curr.getTo().equals(f5));
    assertTrue(curr.getPiece().equals(pbox.createBlackBishop()));
    assertEquals(pos, curr.getPosition());
    assertTrue(curr.getPrev() == prev);
    assertTrue(curr.getNext().getPrev() == curr);
    prev = curr;
    curr = (MoveInfo)(curr.getNext());
    pos = curr.getPosition();

    //4. Nc3 e6
    curr.execute(b1, c3);
    assertTrue(curr.getColor().getColor() == IColor.ChessColor.WHITE);
    assertTrue(curr.getFrom().equals(b1));
    assertTrue(curr.getTo().equals(c3));
    assertTrue(curr.getPiece().equals(pbox.createWhiteKnight()));
    assertEquals(pos, curr.getPosition());
    assertTrue(curr.getPrev() == prev);
    assertTrue(curr.getNext().getPrev() == curr);
    prev = curr;
    curr = (MoveInfo)(curr.getNext());
    pos = curr.getPosition();
    
    curr.execute(e7, e6);
    assertTrue(curr.getColor().getColor() == IColor.ChessColor.BLACK);
    assertTrue(curr.getFrom().equals(e7));
    assertTrue(curr.getTo().equals(e6));
    assertTrue(curr.getPiece().equals(pbox.createBlackPawn()));
    assertEquals(pos, curr.getPosition());
    assertTrue(curr.getPrev() == prev);
    assertTrue(curr.getNext().getPrev() == curr);
    prev = curr;
    curr = (MoveInfo)(curr.getNext());
    pos = curr.getPosition();

    //5. g4 Bg6
    curr.execute(g2, g4);
    assertTrue(curr.getColor().getColor() == IColor.ChessColor.WHITE);
    assertTrue(curr.getFrom().equals(g2));
    assertTrue(curr.getTo().equals(g4));
    assertTrue(curr.getPiece().equals(pbox.createWhitePawn()));
    assertEquals(pos, curr.getPosition());
    assertTrue(curr.getPrev() == prev);
    assertTrue(curr.getNext().getPrev() == curr);
    prev = curr;
    curr = (MoveInfo)(curr.getNext());
    pos = curr.getPosition();
    
    curr.execute(f5, g6);
    assertTrue(curr.getColor().getColor() == IColor.ChessColor.BLACK);
    assertTrue(curr.getFrom().equals(f5));
    assertTrue(curr.getTo().equals(g6));
    assertTrue(curr.getPiece().equals(pbox.createBlackBishop()));
    assertEquals(pos, curr.getPosition());
    assertTrue(curr.getPrev() == prev);
    assertTrue(curr.getNext().getPrev() == curr);
    prev = curr;
    curr = (MoveInfo)(curr.getNext());
    pos = curr.getPosition();

    //6. Nge2 c5
    curr.execute(g1, e2);
    assertTrue(curr.getColor().getColor() == IColor.ChessColor.WHITE);
    assertTrue(curr.getFrom().equals(g1));
    assertTrue(curr.getTo().equals(e2));
    assertTrue(curr.getPiece().equals(pbox.createWhiteKnight()));
    assertEquals(pos, curr.getPosition());
    assertTrue(curr.getPrev() == prev);
    assertTrue(curr.getNext().getPrev() == curr);
    prev = curr;
    curr = (MoveInfo)(curr.getNext());
    pos = curr.getPosition();
    
    curr.execute(c6, c5);
    assertTrue(curr.getColor().getColor() == IColor.ChessColor.BLACK);
    assertTrue(curr.getFrom().equals(c6));
    assertTrue(curr.getTo().equals(c5));
    assertTrue(curr.getPiece().equals(pbox.createBlackPawn()));
    assertEquals(pos, curr.getPosition());
    assertTrue(curr.getPrev() == prev);
    assertTrue(curr.getNext().getPrev() == curr);
    prev = curr;
    curr = (MoveInfo)(curr.getNext());
    pos = curr.getPosition();

    //7. Be3 Nc6
    curr.execute(c1, e3);
    assertTrue(curr.getColor().getColor() == IColor.ChessColor.WHITE);
    assertTrue(curr.getFrom().equals(c1));
    assertTrue(curr.getTo().equals(e3));
    assertTrue(curr.getPiece().equals(pbox.createWhiteBishop()));
    assertEquals(pos, curr.getPosition());
    assertTrue(curr.getPrev() == prev);
    assertTrue(curr.getNext().getPrev() == curr);
    prev = curr;
    curr = (MoveInfo)(curr.getNext());
    pos = curr.getPosition();
    
    curr.execute(b8, c6);
    assertTrue(curr.getColor().getColor() == IColor.ChessColor.BLACK);
    assertTrue(curr.getFrom().equals(b8));
    assertTrue(curr.getTo().equals(c6));
    assertTrue(curr.getPiece().equals(pbox.createBlackKnight()));
    assertEquals(pos, curr.getPosition());
    assertTrue(curr.getPrev() == prev);
    assertTrue(curr.getNext().getPrev() == curr);
    prev = curr;
    curr = (MoveInfo)(curr.getNext());
    pos = curr.getPosition();

    //8. dxc Qh4
    curr.execute(d4, c5);
    assertTrue(curr.getColor().getColor() == IColor.ChessColor.WHITE);
    assertTrue(curr.getFrom().equals(d4));
    assertTrue(curr.getTo().equals(c5));
    assertTrue(curr.getPiece().equals(pbox.createWhitePawn()));
    assertEquals(pos, curr.getPosition());
    assertTrue(curr.getPrev() == prev);
    assertTrue(curr.getNext().getPrev() == curr);
    prev = curr;
    curr = (MoveInfo)(curr.getNext());
    pos = curr.getPosition();
    
    curr.execute(d8, h4);
    assertTrue(curr.getColor().getColor() == IColor.ChessColor.BLACK);
    assertTrue(curr.getFrom().equals(d8));
    assertTrue(curr.getTo().equals(h4));
    assertTrue(curr.getPiece().equals(pbox.createBlackQueen()));
    assertEquals(pos, curr.getPosition());
    assertTrue(curr.getPrev() == prev);
    assertTrue(curr.getNext().getPrev() == curr);
    analisys = (MoveInfo)(curr.getPrev());
    prev = curr;
    curr = (MoveInfo)(curr.getNext());
    pos = curr.getPosition();

    //Or 8 . .. Nxe5 9. Nd4 threatening Bb5+ or h4
    analisys.addVariant(c6, e5);
    assertTrue(analisys.getVariations().length == 1);
    assertTrue(analisys.getVariations()[0].getColor().getColor() == IColor.ChessColor.BLACK);
    variant = (MoveInfo)(analisys.getVariations()[0]);
    assertTrue(analisys.getNext().getFrom().equals(d8));
    assertTrue(analisys.getNext().getTo().equals(h4));
    assertTrue(variant.getPrev() == analisys);
    assertTrue(variant.getNext().getFrom() == null);
    
    try
    {
      ((MoveInfo)(variant.getNext())).addVariant(e2, g3);
    }
    catch(NoMainlineException nmle)
    {
      assertTrue(variant.getVariations().length == 0);
    }            
    ((MoveInfo)(variant.getNext())).execute(e2, d4);
    assertTrue(variant.getNext().getColor().getColor() == IColor.ChessColor.WHITE);
    assertTrue(variant.getVariations().length == 0);
    
    //9. Nb5 Nh6?!
    curr.execute(c3, b5);
    assertTrue(curr.getColor().getColor() == IColor.ChessColor.WHITE);
    assertEquals(pos, curr.getPosition());
    assertTrue(curr.getPrev() == prev);
    assertTrue(curr.getNext().getPrev() == curr);
    prev = curr;
    curr = (MoveInfo)(curr.getNext());
    pos = curr.getPosition();
    
    curr.execute(g8, h6);
    assertTrue(curr.getColor().getColor() == IColor.ChessColor.BLACK);
    assertEquals(pos, curr.getPosition());
    assertTrue(curr.getPrev() == prev);
    assertTrue(curr.getNext().getPrev() == curr);
    prev = curr;
    curr = (MoveInfo)(curr.getNext());
    pos = curr.getPosition();

    //10. h3 Rc8
    curr.execute(h2, h3);
    assertTrue(curr.getColor().getColor() == IColor.ChessColor.WHITE);
    assertEquals(pos, curr.getPosition());
    assertTrue(curr.getPrev() == prev);
    assertTrue(curr.getNext().getPrev() == curr);
    analisys = (MoveInfo)(curr.getPrev());
    prev = curr;    
    curr = (MoveInfo)(curr.getNext());
    pos = curr.getPosition();
    
    //Capturing the rook is too risky
    //10. Nc7+? Kd7 11. Nxa8 Nxg4 12. Qd2 Nxe5
    //and white has many difficulties.
    //The ia true for 10. Rxh6 gxh 11. Nc7+ Kd7 12. Nxa8 Bxc5
    //with strong initiative for black.
    analisys.addVariant(b5, c7);
    assertTrue(analisys.getVariations().length == 1);
    assertTrue(analisys.getVariations()[0].getColor().getColor() == IColor.ChessColor.WHITE);
    variant = (MoveInfo)(analisys.getVariations()[0]);
    assertTrue(analisys.getNext().getFrom().equals(h2));
    assertTrue(analisys.getNext().getTo().equals(h3));
    assertTrue(variant.getPrev() == analisys);
    assertTrue(variant.getNext().getFrom() == null);
    
    variant = (MoveInfo)(variant.getNext());
    variant.execute(e8, d7);
    assertTrue(variant.getColor().getColor() == IColor.ChessColor.BLACK);
    assertTrue(variant.getNext().getColor().getColor() == IColor.ChessColor.WHITE);
    assertTrue(variant.getVariations().length == 0);
    
    variant = (MoveInfo)(variant.getNext());
    variant.execute(c7, a8);
    assertTrue(variant.getColor().getColor() == IColor.ChessColor.WHITE);
    assertTrue(variant.getNext().getColor().getColor() == IColor.ChessColor.BLACK);
    assertTrue(variant.getVariations().length == 0);
    
    variant = (MoveInfo)(variant.getNext());
    variant.execute(h6, g4);
    assertTrue(variant.getColor().getColor() == IColor.ChessColor.BLACK);
    assertTrue(variant.getNext().getColor().getColor() == IColor.ChessColor.WHITE);
    assertTrue(variant.getVariations().length == 0);
    
    variant = (MoveInfo)(variant.getNext());
    variant.execute(d1, d2);
    assertTrue(variant.getColor().getColor() == IColor.ChessColor.WHITE);
    assertTrue(variant.getNext().getColor().getColor() == IColor.ChessColor.BLACK);
    assertTrue(variant.getVariations().length == 0);

    variant = (MoveInfo)(variant.getNext());
    variant.execute(g4, e5);
    assertTrue(variant.getColor().getColor() == IColor.ChessColor.BLACK);
    assertTrue(variant.getNext().getColor().getColor() == IColor.ChessColor.WHITE);
    assertTrue(variant.getVariations().length == 0);
    
    analisys.addVariant(e3, h6);
    assertTrue(analisys.getVariations().length == 2);
    assertTrue(analisys.getVariations()[0].getColor().getColor() == IColor.ChessColor.WHITE);
    variant = (MoveInfo)(analisys.getVariations()[1]);
    assertTrue(analisys.getNext().getFrom().equals(h2));
    assertTrue(analisys.getNext().getTo().equals(h3));
    assertTrue(variant.getPrev() == analisys);
    assertTrue(variant.getNext().getFrom() == null);
    
    variant = (MoveInfo)(variant.getNext());
    variant.execute(g7, h6);
    assertTrue(variant.getColor().getColor() == IColor.ChessColor.BLACK);
    assertTrue(variant.getNext().getColor().getColor() == IColor.ChessColor.WHITE);
    assertTrue(variant.getVariations().length == 0);
    
    variant = (MoveInfo)(variant.getNext());
    variant.execute(b5, c7);
    assertTrue(variant.getColor().getColor() == IColor.ChessColor.WHITE);
    assertTrue(variant.getNext().getColor().getColor() == IColor.ChessColor.BLACK);
    assertTrue(variant.getVariations().length == 0);
    
    variant = (MoveInfo)(variant.getNext());
    variant.execute(e8, d7);
    assertTrue(variant.getColor().getColor() == IColor.ChessColor.BLACK);
    assertTrue(variant.getNext().getColor().getColor() == IColor.ChessColor.WHITE);
    assertTrue(variant.getVariations().length == 0);
    
    variant = (MoveInfo)(variant.getNext());
    variant.execute(c7, a8);
    assertTrue(variant.getColor().getColor() == IColor.ChessColor.WHITE);
    assertTrue(variant.getNext().getColor().getColor() == IColor.ChessColor.BLACK);
    assertTrue(variant.getVariations().length == 0);

    variant = (MoveInfo)(variant.getNext());
    variant.execute(f8, c5);
    assertTrue(variant.getColor().getColor() == IColor.ChessColor.BLACK);
    assertTrue(variant.getNext().getColor().getColor() == IColor.ChessColor.WHITE);
    assertTrue(variant.getVariations().length == 0);
    
    curr.execute(a8, c8);
    assertTrue(curr.getColor().getColor() == IColor.ChessColor.BLACK);
    assertEquals(pos, curr.getPosition());
    assertTrue(curr.getPrev() == prev);
    assertTrue(curr.getNext().getPrev() == curr);
    analisys = (MoveInfo)(curr.getPrev());
    prev = curr;
    curr = (MoveInfo)(curr.getNext());
    pos = curr.getPosition();

    //10. .. Nxg4 won't help now because then will come
    //11. hxg Qxh1 12. Nc7+
    analisys.addVariant(h6, g4);
    assertTrue(analisys.getVariations().length == 1);
    assertTrue(analisys.getVariations()[0].getColor().getColor() == IColor.ChessColor.BLACK);
    variant = (MoveInfo)(analisys.getVariations()[0]);
    assertTrue(analisys.getNext().getFrom().equals(a8));
    assertTrue(analisys.getNext().getTo().equals(c8));
    assertTrue(variant.getPrev() == analisys);
    assertTrue(variant.getNext().getFrom() == null);
    
    variant = (MoveInfo)(variant.getNext());
    variant.execute(h3, g4);
    assertTrue(variant.getColor().getColor() == IColor.ChessColor.WHITE);
    assertTrue(variant.getNext().getColor().getColor() == IColor.ChessColor.BLACK);
    assertTrue(variant.getVariations().length == 0);
    
    variant = (MoveInfo)(variant.getNext());
    variant.execute(h4, h1);
    assertTrue(variant.getColor().getColor() == IColor.ChessColor.BLACK);
    assertTrue(variant.getNext().getColor().getColor() == IColor.ChessColor.WHITE);
    assertTrue(variant.getVariations().length == 0);
    
    variant = (MoveInfo)(variant.getNext());
    variant.execute(b5, c7);
    assertTrue(variant.getColor().getColor() == IColor.ChessColor.WHITE);
    assertTrue(variant.getNext().getColor().getColor() == IColor.ChessColor.BLACK);
    assertTrue(variant.getVariations().length == 0);
    
    //11. Ng3 Nxe5
    curr.execute(e2, g3);
    assertTrue(curr.getColor().getColor() == IColor.ChessColor.WHITE);
    assertEquals(pos, curr.getPosition());
    assertTrue(curr.getPrev() == prev);
    assertTrue(curr.getNext().getPrev() == curr);
    prev = curr;
    curr = (MoveInfo)(curr.getNext());
    pos = curr.getPosition();
    
    curr.execute(c6, e5);
    assertTrue(curr.getColor().getColor() == IColor.ChessColor.BLACK);
    assertEquals(pos, curr.getPosition());
    assertTrue(curr.getPrev() == prev);
    assertTrue(curr.getNext().getPrev() == curr);
    prev = curr;
    curr = (MoveInfo)(curr.getNext());
    pos = curr.getPosition();

    //12. Nxa7 Rxc5!
    curr.execute(b5, a7);
    assertTrue(curr.getColor().getColor() == IColor.ChessColor.WHITE);
    assertEquals(pos, curr.getPosition());
    assertTrue(curr.getPrev() == prev);
    assertTrue(curr.getNext().getPrev() == curr);
    prev = curr;
    curr = (MoveInfo)(curr.getNext());
    pos = curr.getPosition();
    
    curr.execute(c8, c5);
    assertTrue(curr.getColor().getColor() == IColor.ChessColor.BLACK);
    assertEquals(pos, curr.getPosition());
    assertTrue(curr.getPrev() == prev);
    assertTrue(curr.getNext().getPrev() == curr);
    prev = curr;
    curr = (MoveInfo)(curr.getNext());
    pos = curr.getPosition();

    //13. c3 Nc4
    curr.execute(c2, c3);
    assertTrue(curr.getColor().getColor() == IColor.ChessColor.WHITE);
    assertEquals(pos, curr.getPosition());
    assertTrue(curr.getPrev() == prev);
    assertTrue(curr.getNext().getPrev() == curr);
    prev = curr;
    curr = (MoveInfo)(curr.getNext());
    pos = curr.getPosition();
    
    curr.execute(e5, c4);
    assertTrue(curr.getColor().getColor() == IColor.ChessColor.BLACK);
    assertEquals(pos, curr.getPosition());
    assertTrue(curr.getPrev() == prev);
    assertTrue(curr.getNext().getPrev() == curr);
    prev = curr;
    curr = (MoveInfo)(curr.getNext());
    pos = curr.getPosition();

    //14. Bxc5 Bxc5
    curr.execute(e3, c5);
    assertTrue(curr.getColor().getColor() == IColor.ChessColor.WHITE);
    assertEquals(pos, curr.getPosition());
    assertTrue(curr.getPrev() == prev);
    assertTrue(curr.getNext().getPrev() == curr);
    prev = curr;
    curr = (MoveInfo)(curr.getNext());
    pos = curr.getPosition();
    
    curr.execute(f8, c5);
    assertTrue(curr.getColor().getColor() == IColor.ChessColor.BLACK);
    assertEquals(pos, curr.getPosition());
    assertTrue(curr.getPrev() == prev);
    assertTrue(curr.getNext().getPrev() == curr);
    prev = curr;
    curr = (MoveInfo)(curr.getNext());
    pos = curr.getPosition();

    //15. Qa4+ Ke7
    curr.execute(d1, a4);
    assertTrue(curr.getColor().getColor() == IColor.ChessColor.WHITE);
    assertEquals(pos, curr.getPosition());
    assertTrue(curr.getPrev() == prev);
    assertTrue(curr.getNext().getPrev() == curr);
    prev = curr;
    curr = (MoveInfo)(curr.getNext());
    pos = curr.getPosition();
    
    curr.execute(e8, e7);
    assertTrue(curr.getColor().getColor() == IColor.ChessColor.BLACK);
    assertEquals(pos, curr.getPosition());
    assertTrue(curr.getPrev() == prev);
    assertTrue(curr.getNext().getPrev() == curr);
    prev = curr;
    curr = (MoveInfo)(curr.getNext());
    pos = curr.getPosition();

    //16. Bxc4 Qf6!
    curr.execute(f1, c4);
    assertTrue(curr.getColor().getColor() == IColor.ChessColor.WHITE);
    assertEquals(pos, curr.getPosition());
    assertTrue(curr.getPrev() == prev);
    assertTrue(curr.getNext().getPrev() == curr);
    prev = curr;
    curr = (MoveInfo)(curr.getNext());
    pos = curr.getPosition();
    
    curr.execute(h4, f6);
    assertTrue(curr.getColor().getColor() == IColor.ChessColor.BLACK);
    assertEquals(pos, curr.getPosition());
    assertTrue(curr.getPrev() == prev);
    assertTrue(curr.getNext().getPrev() == curr);
    prev = curr;
    curr = (MoveInfo)(curr.getNext());
    pos = curr.getPosition();
    
    //Lets take a break for a moment to test the position
    assertEquals(pbox.createWhiteRook(), pos.getPiece(a1));
    assertEquals(null, pos.getPiece(b1));
    assertEquals(null, pos.getPiece(c1));
    assertEquals(null, pos.getPiece(d1));
    assertEquals(pbox.createWhiteKing(), pos.getPiece(e1));
    assertEquals(null, pos.getPiece(f1));
    assertEquals(null, pos.getPiece(g1));
    assertEquals(pbox.createWhiteRook(), pos.getPiece(h1));
    assertEquals(pbox.createWhitePawn(), pos.getPiece(a2));
    assertEquals(pbox.createWhitePawn(), pos.getPiece(b2));
    assertEquals(null, pos.getPiece(c2));
    assertEquals(null, pos.getPiece(d2));
    assertEquals(null, pos.getPiece(e2));
    assertEquals(pbox.createWhitePawn(), pos.getPiece(f2));
    assertEquals(null, pos.getPiece(g2));
    assertEquals(null, pos.getPiece(h2));
    assertEquals(null, pos.getPiece(a3));
    assertEquals(null, pos.getPiece(b3));
    assertEquals(pbox.createWhitePawn(), pos.getPiece(c3));
    assertEquals(null, pos.getPiece(d3));
    assertEquals(null, pos.getPiece(e3));
    assertEquals(null, pos.getPiece(f3));
    assertEquals(pbox.createWhiteKnight(), pos.getPiece(g3));
    assertEquals(pbox.createWhitePawn(), pos.getPiece(h3));
    assertEquals(pbox.createWhiteQueen(), pos.getPiece(a4));
    assertEquals(null, pos.getPiece(b4));
    assertEquals(pbox.createWhiteBishop(), pos.getPiece(c4));
    assertEquals(null, pos.getPiece(d4));
    assertEquals(null, pos.getPiece(e4));
    assertEquals(null, pos.getPiece(f4));
    assertEquals(pbox.createWhitePawn(), pos.getPiece(g4));
    assertEquals(null, pos.getPiece(h4));
    assertEquals(null, pos.getPiece(a5));
    assertEquals(null, pos.getPiece(b5));
    assertEquals(pbox.createBlackBishop(), pos.getPiece(c5));
    assertEquals(pbox.createBlackPawn(), pos.getPiece(d5));
    assertEquals(null, pos.getPiece(e5));
    assertEquals(null, pos.getPiece(f5));
    assertEquals(null, pos.getPiece(g5));
    assertEquals(null, pos.getPiece(h5));
    assertEquals(null, pos.getPiece(a6));
    assertEquals(null, pos.getPiece(b6));
    assertEquals(null, pos.getPiece(c6));
    assertEquals(null, pos.getPiece(d6));
    assertEquals(pbox.createBlackPawn(), pos.getPiece(e6));
    assertEquals(pbox.createBlackQueen(), pos.getPiece(f6));
    assertEquals(pbox.createBlackBishop(), pos.getPiece(g6));
    assertEquals(pbox.createBlackKnight(), pos.getPiece(h6));
    assertEquals(pbox.createWhiteKnight(), pos.getPiece(a7));
    assertEquals(pbox.createBlackPawn(), pos.getPiece(b7));
    assertEquals(null, pos.getPiece(c7));
    assertEquals(null, pos.getPiece(d7));
    assertEquals(pbox.createBlackKing(), pos.getPiece(e7));
    assertEquals(pbox.createBlackPawn(), pos.getPiece(f7));
    assertEquals(pbox.createBlackPawn(), pos.getPiece(g7));
    assertEquals(pbox.createBlackPawn(), pos.getPiece(h7));
    assertEquals(null, pos.getPiece(a8));
    assertEquals(null, pos.getPiece(b8));
    assertEquals(null, pos.getPiece(c8));
    assertEquals(null, pos.getPiece(d8));
    assertEquals(null, pos.getPiece(e8));
    assertEquals(null, pos.getPiece(f8));
    assertEquals(null, pos.getPiece(g8));
    assertEquals(pbox.createBlackRook(), pos.getPiece(h8));
    assertTrue(pos.isWhite00());
    assertTrue(pos.isWhite000());
    assertFalse(pos.isBlack00());
    assertFalse(pos.isBlack000());
    assertEquals(null, pos.getEnpassant());
    assertEquals(1, pos.getHalfMoveCount());

    //17. 0-0 Qf3!
    curr.execute(e1, g1);
    assertTrue(curr.getColor().getColor() == IColor.ChessColor.WHITE);
    assertEquals(pos, curr.getPosition());
    assertTrue(curr.getPrev() == prev);
    assertTrue(curr.getNext().getPrev() == curr);
    prev = curr;
    curr = (MoveInfo)(curr.getNext());
    pos = curr.getPosition();
    
    curr.execute(f6, f3);
    assertTrue(curr.getColor().getColor() == IColor.ChessColor.BLACK);
    assertEquals(pos, curr.getPosition());
    assertTrue(curr.getPrev() == prev);
    assertTrue(curr.getNext().getPrev() == curr);
    prev = curr;
    curr = (MoveInfo)(curr.getNext());
    pos = curr.getPosition();
    
    //18. Bxd5! exd5
    curr.execute(c4, d5);
    assertTrue(curr.getColor().getColor() == IColor.ChessColor.WHITE);
    assertEquals(pos, curr.getPosition());
    assertTrue(curr.getPrev() == prev);
    assertTrue(curr.getNext().getPrev() == curr);
    analisys = (MoveInfo)(curr.getPrev());
    prev = curr;
    curr = (MoveInfo)(curr.getNext());
    pos = curr.getPosition();

    //Tricky defense, not sufficient 18. Kh2 Bxf2
    //19. Rg1 dxc4 and black still has strong initiative.
    //The text move gaininig important tempo 18. .. Qxg3+ 19. Bg2
    // or 18. .. Qxd5 19. Nb5 Qf3 20. Nd4
    analisys.addVariant(g1, h2);
    assertTrue(analisys.getVariations().length == 1);
    assertTrue(analisys.getVariations()[0].getColor().getColor() == IColor.ChessColor.WHITE);
    variant = (MoveInfo)(analisys.getVariations()[0]);
    assertTrue(analisys.getNext().getFrom().equals(c4));
    assertTrue(analisys.getNext().getTo().equals(d5));
    assertTrue(variant.getPrev() == analisys);
    assertTrue(variant.getNext().getFrom() == null);
    
    variant = (MoveInfo)(variant.getNext());
    variant.execute(c5, f2);
    assertTrue(variant.getColor().getColor() == IColor.ChessColor.BLACK);
    assertTrue(variant.getNext().getColor().getColor() == IColor.ChessColor.WHITE);
    assertTrue(variant.getVariations().length == 0);

    variant = (MoveInfo)(variant.getNext());
    variant.execute(f1, g1);
    assertTrue(variant.getColor().getColor() == IColor.ChessColor.WHITE);
    assertTrue(variant.getNext().getColor().getColor() == IColor.ChessColor.BLACK);
    assertTrue(variant.getVariations().length == 0);

    variant = (MoveInfo)(variant.getNext());
    variant.execute(d5, c4);
    assertTrue(variant.getColor().getColor() == IColor.ChessColor.BLACK);
    assertTrue(variant.getNext().getColor().getColor() == IColor.ChessColor.WHITE);
    assertTrue(variant.getVariations().length == 0);
    
    curr.execute(e6, d5);
    assertTrue(curr.getColor().getColor() == IColor.ChessColor.BLACK);
    assertEquals(pos, curr.getPosition());
    assertTrue(curr.getPrev() == prev);
    assertTrue(curr.getNext().getPrev() == curr);
    analisys = (MoveInfo)(curr.getPrev());
    analisys1 = (MoveInfo)(curr.getPrev());
    prev = curr;
    curr = (MoveInfo)(curr.getNext());
    pos = curr.getPosition();

    analisys.addVariant(f3, g3);
    assertTrue(analisys.getVariations().length == 1);
    assertTrue(analisys.getVariations()[0].getColor().getColor() == IColor.ChessColor.BLACK);
    variant = (MoveInfo)(analisys.getVariations()[0]);
    assertTrue(analisys.getNext().getFrom().equals(e6));
    assertTrue(analisys.getNext().getTo().equals(d5));
    assertTrue(variant.getPrev() == analisys);
    assertTrue(variant.getNext().getFrom() == null);
    
    variant = (MoveInfo)(variant.getNext());
    variant.execute(d5, g2);
    assertTrue(variant.getColor().getColor() == IColor.ChessColor.WHITE);
    assertTrue(variant.getNext().getColor().getColor() == IColor.ChessColor.BLACK);
    assertTrue(variant.getVariations().length == 0);

    analisys.addVariant(f3, d5);
    assertTrue(analisys.getVariations().length == 2);
    assertTrue(analisys.getVariations()[0].getColor().getColor() == IColor.ChessColor.BLACK);
    variant = (MoveInfo)(analisys.getVariations()[1]);
    assertTrue(analisys.getNext().getFrom().equals(e6));
    assertTrue(analisys.getNext().getTo().equals(d5));
    assertTrue(variant.getPrev() == analisys);
    assertTrue(variant.getNext().getFrom() == null);
       
    variant = (MoveInfo)(variant.getNext());
    variant.execute(a7, b5);
    assertTrue(variant.getColor().getColor() == IColor.ChessColor.WHITE);
    assertTrue(variant.getNext().getColor().getColor() == IColor.ChessColor.BLACK);
    assertTrue(variant.getVariations().length == 0);

    variant = (MoveInfo)(variant.getNext());
    variant.execute(d5, f3);
    assertTrue(variant.getColor().getColor() == IColor.ChessColor.BLACK);
    assertTrue(variant.getNext().getColor().getColor() == IColor.ChessColor.WHITE);
    assertTrue(variant.getVariations().length == 0);

    variant = (MoveInfo)(variant.getNext());
    variant.execute(b5, d4);
    assertTrue(variant.getColor().getColor() == IColor.ChessColor.WHITE);
    assertTrue(variant.getNext().getColor().getColor() == IColor.ChessColor.BLACK);
    assertTrue(variant.getVariations().length == 0);

    
    //19. Rae1+ Kd8
    curr.execute(a1, e1);
    assertTrue(curr.getColor().getColor() == IColor.ChessColor.WHITE);
    assertEquals(pos, curr.getPosition());
    assertTrue(curr.getPrev() == prev);
    assertTrue(curr.getNext().getPrev() == curr);
    prev = curr;
    curr = (MoveInfo)(curr.getNext());
    pos = curr.getPosition();
    
    curr.execute(e7, d8);
    assertTrue(curr.getColor().getColor() == IColor.ChessColor.BLACK);
    assertEquals(pos, curr.getPosition());
    assertTrue(curr.getPrev() == prev);
    assertTrue(curr.getNext().getPrev() == curr);
    prev = curr;
    curr = (MoveInfo)(curr.getNext());
    pos = curr.getPosition();

    //Black is sure that white is defenseless now,
    //yet white has left one more Ace.
    
    //20. Nc6+! Kc7
    curr.execute(a7, c6);
    assertTrue(curr.getColor().getColor() == IColor.ChessColor.WHITE);
    assertEquals(pos, curr.getPosition());
    assertTrue(curr.getPrev() == prev);
    assertTrue(curr.getNext().getPrev() == curr);
    analisys = (MoveInfo)(curr.getPrev());
    prev = curr;
    curr = (MoveInfo)(curr.getNext());
    pos = curr.getPosition();
    
    analisys.addVariant(a4, a5);
    assertTrue(analisys.getVariations().length == 1);
    assertTrue(analisys.getVariations()[0].getColor().getColor() == IColor.ChessColor.WHITE);
    variant = (MoveInfo)(analisys.getVariations()[0]);
    assertTrue(analisys.getNext().getFrom().equals(a7));
    assertTrue(analisys.getNext().getTo().equals(c6));
    assertTrue(variant.getPrev() == analisys);
    assertTrue(variant.getNext().getFrom() == null);
    
    variant = (MoveInfo)(variant.getNext());
    variant.execute(b7, b6);
    assertTrue(variant.getColor().getColor() == IColor.ChessColor.BLACK);
    assertTrue(variant.getNext().getColor().getColor() == IColor.ChessColor.WHITE);
    assertTrue(variant.getVariations().length == 0);
    
    
    curr.execute(d8, c7);
    assertTrue(curr.getColor().getColor() == IColor.ChessColor.BLACK);
    assertEquals(pos, curr.getPosition());
    assertTrue(curr.getPrev() == prev);
    assertTrue(curr.getNext().getPrev() == curr);
    analisys = (MoveInfo)(curr.getPrev());
    prev = curr;
    curr = (MoveInfo)(curr.getNext());
    pos = curr.getPosition();

    //There is no choice 20. .. bxc6 looses to Qa5+
    analisys.addVariant(b7, c6);
    assertTrue(analisys.getVariations().length == 1);
    assertTrue(analisys.getVariations()[0].getColor().getColor() == IColor.ChessColor.BLACK);
    variant = (MoveInfo)(analisys.getVariations()[0]);
    assertTrue(analisys.getNext().getFrom().equals(d8));
    assertTrue(analisys.getNext().getTo().equals(c7));
    assertTrue(variant.getPrev() == analisys);
    assertTrue(variant.getNext().getFrom() == null);
    
    variant = (MoveInfo)(variant.getNext());
    variant.execute(a4, a5);
    assertTrue(variant.getColor().getColor() == IColor.ChessColor.WHITE);
    assertTrue(variant.getNext().getColor().getColor() == IColor.ChessColor.BLACK);
    assertTrue(variant.getVariations().length == 0);

    
    //21. Nd4 Qf6
    curr.execute(c6, d4);
    assertTrue(curr.getColor().getColor() == IColor.ChessColor.WHITE);
    assertEquals(pos, curr.getPosition());
    assertTrue(curr.getPrev() == prev);
    assertTrue(curr.getNext().getPrev() == curr);
    prev = curr;
    curr = (MoveInfo)(curr.getNext());
    pos = curr.getPosition();
    
    curr.execute(f3,f6);
    assertTrue(curr.getColor().getColor() == IColor.ChessColor.BLACK);
    assertEquals(pos, curr.getPosition());
    assertTrue(curr.getPrev() == prev);
    assertTrue(curr.getNext().getPrev() == curr);
    analisys = (MoveInfo)(curr.getPrev());
    prev = curr;
    curr = (MoveInfo)(curr.getNext());
    pos = curr.getPosition();
    //Black resign, 1-0
    
    //After 22. f4 winning is at hand.
    
    //Try to add move that is already in the list
    //18 . .. e6xd5 (18. .. Qxg3, 18. .. Qxd5)
    IMoveInfo existMove = analisys1.addVariant(e6, d5);
    assertEquals(a1, existMove.getFrom());
    assertEquals(e1, existMove.getTo());
    assertTrue(existMove.getColor().getColor() == IColor.ChessColor.WHITE);

    existMove = analisys1.addVariant(f3, g3);
    assertEquals(d5, existMove.getFrom());
    assertEquals(g2, existMove.getTo());
    assertTrue(existMove.getColor().getColor() == IColor.ChessColor.WHITE);    
  }
}
