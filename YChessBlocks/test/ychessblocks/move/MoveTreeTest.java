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
import ychessblocks.board.ChessColor;
import ychessblocks.board.IFile;
import ychessblocks.board.IRank;
import ychessblocks.board.ISquare;
import ychessblocks.piece.IPieceBox;
import ychessblocks.piece.PieceBox;
import ychessblocks.position.IPosition;
import ychessblocks.position.Position;
import ychessblocks.position.IllegalMoveException;

/**
 *
 * @author Yair
 */
public class MoveTreeTest 
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
  
  private IColor white;
  private IColor black;
  
  public MoveTreeTest() 
  {
    m_board = Board.getInstance();
  }
  
  @BeforeClass
  public static void setUpClass() {
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
    
    white = ChessColor.getInstance().getWhite();
    black = ChessColor.getInstance().getBlack();
  }
  
  @After
  public void tearDown() {
  }

  /**
   * Test of addMove method, of class MoveTree.
   */
  @Test
  public void testAddMove() throws Exception 
  {
    System.out.println("AddMove");
    
    IPosition position;
    MoveTree head;
    MoveTree currNode;
    IMoveItem currMove;
    IPieceBox pbox = PieceBox.getInstance();
    MoveTree mainLine;
    IMoveItem illegalMove;
    
    position = new Position();
    position.set();
    head = (MoveTree)(MoveTree.createTreeStart(position,1));
    
    //Nunn - Sosonko
    //Tilburg 82
    //1-0
    //"Shahmat" #2, FEB-1983
    //Analisys by M. Czerniak.    
    
    currNode = head;
    //1. e4 c6
    assertEquals(white, currNode.getPosition().getActiveColor());
    currMove = currNode.addMove(e2, e4);
    assertEquals(pbox.createWhitePawn(), currMove.getPiece());
    assertEquals(e2, currMove.getFrom());
    assertEquals(e4, currMove.getTo());
    
    currNode = (MoveTree)(currMove.getNext());
    assertEquals(black, currNode.getPosition().getActiveColor());
    currMove = currNode.addMove(c7, c6);
    assertEquals(pbox.createBlackPawn(), currMove.getPiece());
    assertEquals(c7, currMove.getFrom());
    assertEquals(c6, currMove.getTo());
    
    //2. d4 d5
    currNode = (MoveTree)(currMove.getNext());
    assertEquals(white, currNode.getPosition().getActiveColor());
    currMove = currNode.addMove(d2, d4);
    assertEquals(pbox.createWhitePawn(), currMove.getPiece());
    assertEquals(d2, currMove.getFrom());
    assertEquals(d4, currMove.getTo());
    assertTrue(currNode.getMoveNumber() == 2);
    
    currNode = (MoveTree)(currMove.getNext());
    assertEquals(black, currNode.getPosition().getActiveColor());
    currMove = currNode.addMove(d7, d5);
    assertEquals(pbox.createBlackPawn(), currMove.getPiece());
    assertEquals(d7, currMove.getFrom());
    assertEquals(d5, currMove.getTo());
    assertTrue(currNode.getMoveNumber() == 2);
    
    //3. e5 Bf5
    currNode = (MoveTree)(currMove.getNext());
    assertEquals(white, currNode.getPosition().getActiveColor());
    currMove = currNode.addMove(e4, e5);
    assertEquals(pbox.createWhitePawn(), currMove.getPiece());
    assertEquals(e4, currMove.getFrom());
    assertEquals(e5, currMove.getTo());
    assertTrue(currNode.getMoveNumber() == 3);
    
    currNode = (MoveTree)(currMove.getNext());
    assertEquals(black, currNode.getPosition().getActiveColor());
    currMove = currNode.addMove(c8, f5);
    assertEquals(pbox.createBlackBishop(), currMove.getPiece());
    assertEquals(c8, currMove.getFrom());
    assertEquals(f5, currMove.getTo());

    //4. Nc3 e6
    currNode = (MoveTree)(currMove.getNext());
    assertEquals(white, currNode.getPosition().getActiveColor());
    currMove = currNode.addMove(b1, c3);
    assertEquals(pbox.createWhiteKnight(), currMove.getPiece());
    
    //* Nb1-b3
    try
    {
      illegalMove = currNode.addMove(b1, b3);
    }
    catch (IllegalMoveException ime)
    {
      assertEquals(IllegalMoveException.MoveFault.PIECE, ime.getFault());
      assertTrue(currNode.getVariations().length == 0);
    }
    
    currNode = (MoveTree)(currMove.getNext());
    
    //* Bf1-e2
    try
    {
      illegalMove = currNode.addMove(f1, e2);
    }
    catch (IllegalMoveException ime)
    {
      assertEquals(IllegalMoveException.MoveFault.COLOR, ime.getFault());
      assertTrue(currNode.getMainMove() == null);
    }
    
    assertEquals(black, currNode.getPosition().getActiveColor());
    currMove = currNode.addMove(e7, e6);
    assertEquals(pbox.createBlackPawn(), currMove.getPiece());
    assertTrue(currNode.getVariations().length == 0); 
    
    //5. g4 Bg6
    currNode = (MoveTree)(currMove.getNext());
    assertEquals(white, currNode.getPosition().getActiveColor());
    currMove = currNode.addMove(g2, g4);
    assertEquals(pbox.createWhitePawn(), currMove.getPiece());
    
    currNode = (MoveTree)(currMove.getNext());
    assertEquals(black, currNode.getPosition().getActiveColor());
    currMove = currNode.addMove(f5, g6);
    assertEquals(pbox.createBlackBishop(), currMove.getPiece());
    
    //6. Nge2 c5
    currNode = (MoveTree)(currMove.getNext());
    assertEquals(white, currNode.getPosition().getActiveColor());
    currMove = currNode.addMove(g1, e2);
    assertEquals(pbox.createWhiteKnight(), currMove.getPiece());
    
    currNode = (MoveTree)(currMove.getNext());
    assertEquals(black, currNode.getPosition().getActiveColor());
    currMove = currNode.addMove(c6, c5);
    assertEquals(pbox.createBlackPawn(), currMove.getPiece());

    //7. Be3 Nc6
    currNode = (MoveTree)(currMove.getNext());
    assertEquals(white, currNode.getPosition().getActiveColor());
    currMove = currNode.addMove(c1, e3);
    assertEquals(pbox.createWhiteBishop(), currMove.getPiece());
    
    currNode = (MoveTree)(currMove.getNext());
    assertEquals(black, currNode.getPosition().getActiveColor());
    currMove = currNode.addMove(b8, c6);
    assertEquals(pbox.createBlackKnight(), currMove.getPiece());
    
    //8. dxc5 Qh4
    currNode = (MoveTree)(currMove.getNext());
    assertEquals(white, currNode.getPosition().getActiveColor());
    currMove = currNode.addMove(d4, c5);
    assertEquals(pbox.createWhitePawn(), currMove.getPiece());
    assertEquals(currNode.getMainMove(), currMove);
    
    currNode = (MoveTree)(currMove.getNext());
    assertEquals(black, currNode.getPosition().getActiveColor());
    currMove = currNode.addMove(d8, h4);
    assertEquals(pbox.createBlackQueen(), currMove.getPiece());
    assertTrue(currNode.getVariations().length == 0);
     
    //(Or 8. .. Nxe5 9. Nd4 with the threats Bb5+ or h4)
    mainLine = currNode;
    assertEquals(black, currNode.getPosition().getActiveColor());
    currMove = currNode.addMove(c6, e5);
    assertEquals(pbox.createBlackKnight(), currMove.getPiece());
    assertTrue(currNode.getVariations().length == 1);
    assertEquals(d8,currNode.getMainMove().getFrom());
    assertEquals(h4,currNode.getMainMove().getTo());
    
    currNode = (MoveTree)(currMove.getNext());
    assertEquals(white, currNode.getPosition().getActiveColor());
    currMove = currNode.addMove(e2, d4);
    assertEquals(pbox.createWhiteKnight(), currMove.getPiece());
    assertEquals(currNode.getMainMove(), currMove);
    assertEquals(d8,currNode.getPrev().getMainMove().getFrom());
    assertEquals(h4,currNode.getPrev().getMainMove().getTo());
    assertEquals(c6,currMove.getOwner().getPrev().getVariations()[0].getFrom());
    assertEquals(e5,currMove.getOwner().getPrev().getVariations()[0].getTo());
    assertTrue(currNode.getMoveNumber() == 9);
    
    //9. Nb5 Nh6?!
    currNode = (MoveTree)(mainLine.getMainMove().getNext());
    assertEquals(white, currNode.getPosition().getActiveColor());
    currMove = currNode.addMove(c3, b5);
    assertEquals(pbox.createWhiteKnight(), currMove.getPiece());
    assertTrue(currNode.getMoveNumber() == 9);
    
    currNode = (MoveTree)(currMove.getNext());
    assertEquals(black, currNode.getPosition().getActiveColor());
    currMove = currNode.addMove(g8, h6);
    assertEquals(pbox.createBlackKnight(), currMove.getPiece());
    assertTrue(currNode.getMoveNumber() == 9);
    
    //10. h3
    currNode = (MoveTree)(currMove.getNext());
    assertEquals(white, currNode.getPosition().getActiveColor());
    currMove = currNode.addMove(h2, h3);
    assertEquals(pbox.createWhitePawn(), currMove.getPiece());
    
    //(Capturing the rook is too risky: 10. Nc7+? Kd7
    // 11. Nxa8 Ng4 12. Od2 Nxe5 and white has difficulties.
    // The same is true with 10. Bxh6 gxh 11. Nc7+ Kd7
    // 12. Nxa8 Bxc5. Black has strong intiative)
    mainLine = currNode;
    
    assertEquals(white, currNode.getPosition().getActiveColor());
    currMove = currNode.addMove(b5, c7);
    assertEquals(pbox.createWhiteKnight(), currMove.getPiece());

    currNode = (MoveTree)(currMove.getNext());
    assertEquals(black, currNode.getPosition().getActiveColor());
    currMove = currNode.addMove(e8, d7);
    assertEquals(pbox.createBlackKing(), currMove.getPiece());

    currNode = (MoveTree)(currMove.getNext());
    assertEquals(white, currNode.getPosition().getActiveColor());
    currMove = currNode.addMove(c7, a8);
    assertEquals(pbox.createWhiteKnight(), currMove.getPiece());

    currNode = (MoveTree)(currMove.getNext());
    assertEquals(black, currNode.getPosition().getActiveColor());
    currMove = currNode.addMove(h6, g4);
    assertEquals(pbox.createBlackKnight(), currMove.getPiece());

    currNode = (MoveTree)(currMove.getNext());
    assertEquals(white, currNode.getPosition().getActiveColor());
    currMove = currNode.addMove(d1, d2);
    assertEquals(pbox.createWhiteQueen(), currMove.getPiece());

    currNode = (MoveTree)(currMove.getNext());
    assertEquals(black, currNode.getPosition().getActiveColor());
    currMove = currNode.addMove(c6, e5);
    assertEquals(pbox.createBlackKnight(), currMove.getPiece());
    
    currNode = mainLine;
    assertEquals(white, currNode.getPosition().getActiveColor());
    currMove = currNode.addMove(e3, h6);
    assertEquals(pbox.createWhiteBishop(), currMove.getPiece());
    assertTrue(currNode.getVariations().length == 2);
    assertEquals(h2,currNode.getMainMove().getFrom());
    assertEquals(h3,currNode.getMainMove().getTo());
    assertEquals(h2,currMove.getOwner().getMainMove().getFrom());
    assertEquals(h3,currMove.getOwner().getMainMove().getTo());
    
    currNode = (MoveTree)(currMove.getNext());
    assertEquals(black, currNode.getPosition().getActiveColor());
    currMove = currNode.addMove(g7, h6);
    assertEquals(pbox.createBlackPawn(), currMove.getPiece());

    currNode = (MoveTree)(currMove.getNext());
    assertEquals(white, currNode.getPosition().getActiveColor());
    currMove = currNode.addMove(b5, c7);
    assertEquals(pbox.createWhiteKnight(), currMove.getPiece());

    currNode = (MoveTree)(currMove.getNext());
    assertEquals(black, currNode.getPosition().getActiveColor());
    currMove = currNode.addMove(e8, d7);
    assertEquals(pbox.createBlackKing(), currMove.getPiece());
    assertFalse(currMove.getNext().getPosition().isBlack00());
    assertFalse(currMove.getNext().getPosition().isBlack000());
    
    currNode = (MoveTree)(currMove.getNext());
    assertEquals(white, currNode.getPosition().getActiveColor());
    currMove = currNode.addMove(c7, a8);
    assertEquals(pbox.createWhiteKnight(), currMove.getPiece());
    assertFalse(currMove.getNext().getPosition().isBlack00());
    assertFalse(currMove.getNext().getPosition().isBlack000());

    currNode = (MoveTree)(currMove.getNext());
    assertEquals(black, currNode.getPosition().getActiveColor());
    currMove = currNode.addMove(f8, c5);
    assertEquals(pbox.createBlackBishop(), currMove.getPiece());
    assertFalse(currNode.getPosition().isBlack00());
    assertFalse(currNode.getPosition().isBlack000());
    
    //10. .. Rc8
    currNode = (MoveTree)(mainLine.getMainMove().getNext());
    assertTrue(currNode.getPosition().isBlack00());
    assertTrue(currNode.getPosition().isBlack000());    
    assertEquals(black, currNode.getPosition().getActiveColor());
    currMove = currNode.addMove(a8, c8);
    assertEquals(pbox.createBlackRook(), currMove.getPiece());
    
    //(10, .. Nxg4 is useless now because of 11. hxg4 Qxh1 12. Nc7+)
    mainLine = currNode;
    assertEquals(black, currNode.getPosition().getActiveColor());
    currMove = currNode.addMove(h6, g4);
    assertEquals(pbox.createBlackKnight(), currMove.getPiece());

    currNode = (MoveTree)(currMove.getNext());
    assertEquals(white, currNode.getPosition().getActiveColor());
    currMove = currNode.addMove(h3, g4);
    assertEquals(pbox.createWhitePawn(), currMove.getPiece());

    currNode = (MoveTree)(currMove.getNext());
    assertEquals(black, currNode.getPosition().getActiveColor());

    currMove = currNode.addMove(h4, h1);
    assertEquals(pbox.createBlackQueen(), currMove.getPiece());
    assertTrue(currNode.getPosition().isWhite00());
    assertTrue(currNode.getPosition().isWhite000());
    assertFalse(currNode.getMainMove().getNext().getPosition().isWhite00());
    assertTrue(currNode.getMainMove().getNext().getPosition().isWhite000());

    currNode = (MoveTree)(currMove.getNext());
    assertEquals(white, currNode.getPosition().getActiveColor());
    currMove = currNode.addMove(b5, c7);
    assertEquals(pbox.createWhiteKnight(), currMove.getPiece());
    
    //11. Ng3 Nxe5
    currNode = (MoveTree)(mainLine.getMainMove().getNext());
    assertEquals(white, currNode.getPosition().getActiveColor());
    currMove = currNode.addMove(e2, g3);
    assertEquals(pbox.createWhiteKnight(), currMove.getPiece());
    assertTrue(currMove.getNext().getPosition().isWhite00());
    assertTrue(currMove.getNext().getPosition().isWhite000());

    currNode = (MoveTree)(currMove.getNext());
    assertEquals(black, currNode.getPosition().getActiveColor());
    currMove = currNode.addMove(c6, e5);
    assertEquals(pbox.createBlackKnight(), currMove.getPiece());

    //12. Nxa7 Rxc5!
    currNode = (MoveTree)(currMove.getNext());
    assertEquals(white, currNode.getPosition().getActiveColor());
    currMove = currNode.addMove(b5, a7);
    assertEquals(pbox.createWhiteKnight(), currMove.getPiece());

    currNode = (MoveTree)(currMove.getNext());
    assertEquals(black, currNode.getPosition().getActiveColor());
    currMove = currNode.addMove(c8, c5);
    assertEquals(pbox.createBlackRook(), currMove.getPiece());

    //13. c3 Nc4
    currNode = (MoveTree)(currMove.getNext());
    assertEquals(white, currNode.getPosition().getActiveColor());
    currMove = currNode.addMove(c2, c3);
    assertEquals(pbox.createWhitePawn(), currMove.getPiece());

    currNode = (MoveTree)(currMove.getNext());
    assertEquals(black, currNode.getPosition().getActiveColor());
    currMove = currNode.addMove(e5, c4);
    assertEquals(pbox.createBlackKnight(), currMove.getPiece());
    
    //14. Bxc5 Bxc5
    currNode = (MoveTree)(currMove.getNext());
    assertEquals(white, currNode.getPosition().getActiveColor());
    currMove = currNode.addMove(e3, c5);
    assertEquals(pbox.createWhiteBishop(), currMove.getPiece());

    currNode = (MoveTree)(currMove.getNext());
    assertEquals(black, currNode.getPosition().getActiveColor());
    currMove = currNode.addMove(f8, c5);
    assertEquals(pbox.createBlackBishop(), currMove.getPiece());

    //15. Qa4+ Ke7
    currNode = (MoveTree)(currMove.getNext());
    assertEquals(white, currNode.getPosition().getActiveColor());
    currMove = currNode.addMove(d1, a4);
    assertEquals(pbox.createWhiteQueen(), currMove.getPiece());

    currNode = (MoveTree)(currMove.getNext());
    assertEquals(black, currNode.getPosition().getActiveColor());
    currMove = currNode.addMove(e8, e7);
    assertEquals(pbox.createBlackKing(), currMove.getPiece());

    //16. Bxc4 Qf6!
    currNode = (MoveTree)(currMove.getNext());
    assertEquals(white, currNode.getPosition().getActiveColor());
    currMove = currNode.addMove(f1, c4);
    assertEquals(pbox.createWhiteBishop(), currMove.getPiece());

    currNode = (MoveTree)(currMove.getNext());
    assertEquals(black, currNode.getPosition().getActiveColor());
    currMove = currNode.addMove(h4, f6);
    assertEquals(pbox.createBlackQueen(), currMove.getPiece());
   
    //Lets take a break for a moment to test the position
    IPosition pos = currMove.getNext().getPosition();
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
    
    //17. 0-0
    currNode = (MoveTree)(currMove.getNext());
    assertEquals(white, currNode.getPosition().getActiveColor());
    currMove = currNode.addMove(e1, g1);
    assertEquals(pbox.createWhiteKing(), currMove.getPiece());
   
    //(It sounds a like a paradox but maybe 17. Rf1 is preferable,
    // Because now white will need great accuracy defending his own king)
    mainLine = currNode;
    
    assertEquals(white, currNode.getPosition().getActiveColor());
    currMove = currNode.addMove(h1, f1);
    assertEquals(pbox.createWhiteRook(), currMove.getPiece());
    assertEquals(e1, currMove.getOwner().getMainMove().getFrom());
    assertEquals(g1, currMove.getOwner().getMainMove().getTo());
   
    //17. .. Qf3!
    currNode = (MoveTree)(mainLine.getMainMove().getNext());
    assertEquals(black, currNode.getPosition().getActiveColor());
    currMove = currNode.addMove(f6, f3);
    assertEquals(pbox.createBlackQueen(), currMove.getPiece());
    
    //18. Bxd5!
    currNode = (MoveTree)(currMove.getNext());
    assertEquals(white, currNode.getPosition().getActiveColor());
    currMove = currNode.addMove(c4, d5);
    assertEquals(pbox.createWhiteBishop(), currMove.getPiece());

    //(Tricky defense. Not good 18. Kh2 Bxf2 19. Rg1 dxc4 and black
    // still has strong initiative. The text move win an important
    // tempo 18. .. Qxg3+ Bg2 or 18. .. Qxd5 19. Nb5 Qf3 20. Nd4)
    mainLine = currNode;

    assertEquals(white, currNode.getPosition().getActiveColor());
    currMove = currNode.addMove(g1, h2);
    assertEquals(pbox.createWhiteKing(), currMove.getPiece());

    currNode = (MoveTree)(currMove.getNext());
    assertEquals(black, currNode.getPosition().getActiveColor());
    currMove = currNode.addMove(c5, f2);
    assertEquals(pbox.createBlackBishop(), currMove.getPiece());

    currNode = (MoveTree)(currMove.getNext());
    assertEquals(white, currNode.getPosition().getActiveColor());
    currMove = currNode.addMove(f1, g1);
    assertEquals(pbox.createWhiteRook(), currMove.getPiece());

    currNode = (MoveTree)(currMove.getNext());
    assertEquals(black, currNode.getPosition().getActiveColor());
    currMove = currNode.addMove(d5, c4);
    assertEquals(pbox.createBlackPawn(), currMove.getPiece());
    
    //18. .. exd5
    currNode = (MoveTree)(mainLine.getMainMove().getNext());
    assertEquals(black, currNode.getPosition().getActiveColor());
    currMove = currNode.addMove(e6, d5);
    assertEquals(pbox.createBlackPawn(), currMove.getPiece());
    
    mainLine = currNode;

    assertEquals(black, currNode.getPosition().getActiveColor());
    currMove = currNode.addMove(f3, g3);
    assertEquals(pbox.createBlackQueen(), currMove.getPiece());

    currNode = (MoveTree)(currMove.getNext());
    assertEquals(white, currNode.getPosition().getActiveColor());
    currMove = currNode.addMove(d5, g2);
    assertEquals(pbox.createWhiteBishop(), currMove.getPiece());
    
    currNode = mainLine;
    assertEquals(black, currNode.getPosition().getActiveColor());
    currMove = currNode.addMove(f3, d5);
    assertEquals(pbox.createBlackQueen(), currMove.getPiece());
    assertTrue(currNode.getVariations().length == 2);
    
    currNode = (MoveTree)(currMove.getNext());
    assertEquals(white, currNode.getPosition().getActiveColor());
    currMove = currNode.addMove(a7, b5);
    assertEquals(pbox.createWhiteKnight(), currMove.getPiece());

    currNode = (MoveTree)(currMove.getNext());
    assertEquals(black, currNode.getPosition().getActiveColor());
    currMove = currNode.addMove(d5, f3);
    assertEquals(pbox.createBlackQueen(), currMove.getPiece());
    
    currNode = (MoveTree)(currMove.getNext());
    assertEquals(white, currNode.getPosition().getActiveColor());
    currMove = currNode.addMove(b5, d4);
    assertEquals(pbox.createWhiteKnight(), currMove.getPiece());
    
    //Test isMoveExist and adding already existed move
    assertTrue(mainLine.isMoveExist(f3, g3));
    assertFalse(mainLine.isMoveExist(f3, f2));
    currMove = mainLine.addMove(f3, d5);
    assertEquals(pbox.createBlackQueen(), currMove.getPiece());
    assertEquals(f3, currMove.getFrom());
    assertEquals(d5, currMove.getTo());
    assertTrue(mainLine.getVariations().length == 2);
    
    //19. Rae1+ Kd8
    currNode = (MoveTree)(mainLine.getMainMove().getNext());
    assertEquals(white, currNode.getPosition().getActiveColor());
    currMove = currNode.addMove(a1, e1);
    assertEquals(pbox.createWhiteRook(), currMove.getPiece());

    currNode = (MoveTree)(currMove.getNext());
    
    //* Ke7-e6
    try
    {
      illegalMove = currNode.addMove(e7, e6);
    }
    catch (IllegalMoveException ime)
    {
      assertEquals(IllegalMoveException.MoveFault.CHECK, ime.getFault());
      assertTrue(currNode.getMainMove() == null);
    }
    
    assertEquals(black, currNode.getPosition().getActiveColor());
    currMove = currNode.addMove(e7, d8);
    assertEquals(pbox.createBlackKing(), currMove.getPiece());
    
    //(Black is sure that white is defenseless now,
    //20. (Qa5+ b6) yet white has one more Ace.)
    
    //20. Nc6+!
    currNode = (MoveTree)(currMove.getNext());
    assertEquals(white, currNode.getPosition().getActiveColor());
    currMove = currNode.addMove(a7, c6);
    assertEquals(pbox.createWhiteKnight(), currMove.getPiece());

    mainLine = currNode;
    
    assertEquals(white, currNode.getPosition().getActiveColor());
    currMove = currNode.addMove(a4, a5);
    assertEquals(pbox.createWhiteQueen(), currMove.getPiece());

    currNode = (MoveTree)(currMove.getNext());
    assertEquals(black, currNode.getPosition().getActiveColor());
    currMove = currNode.addMove(b7, b6);
    assertEquals(pbox.createBlackPawn(), currMove.getPiece());
    
    //20. .. Kc7
    currNode = (MoveTree)(mainLine.getMainMove().getNext());
    assertEquals(black, currNode.getPosition().getActiveColor());
    currMove = currNode.addMove(d8, c7);
    assertEquals(pbox.createBlackKing(), currMove.getPiece());

    //(There is no choice; 20. .. bxc6 lossing to Qa5+)
    mainLine = currNode;
    assertEquals(black, currNode.getPosition().getActiveColor());
    currMove = currNode.addMove(b7, c6);
    assertEquals(pbox.createBlackPawn(), currMove.getPiece());
    
    currNode = (MoveTree)(currMove.getNext());
    assertEquals(white, currNode.getPosition().getActiveColor());
    currMove = currNode.addMove(a4, a5);
    assertEquals(pbox.createWhiteQueen(), currMove.getPiece());
    
    //21. Nd4 Qf6
    currNode = (MoveTree)(mainLine.getMainMove().getNext());
    assertEquals(white, currNode.getPosition().getActiveColor());
    currMove = currNode.addMove(c6, d4);
    assertEquals(pbox.createWhiteKnight(), currMove.getPiece());

    currNode = (MoveTree)(currMove.getNext());
    assertEquals(black, currNode.getPosition().getActiveColor());
    currMove = currNode.addMove(f3, f6);
    assertEquals(pbox.createBlackQueen(), currMove.getPiece());   
    assertTrue(currNode.getMoveNumber() == 21);
    //Black resign, 1-0
    
    //* Qf4-f6
    try
    {
      illegalMove = currNode.addMove(f4, f6);
    }
    catch (IllegalMoveException ime)
    {
      assertEquals(IllegalMoveException.MoveFault.PIECE, ime.getFault());
    }

    try
    {
      illegalMove = currNode.addMove(null, f6);
    }
    catch (IllegalArgumentException ime) {}
    try
    {
      illegalMove = currNode.addMove(f3, null);
    }
    catch (IllegalArgumentException ime) {}
    try
    {
      illegalMove = currNode.addMove(null, null);
    }
    catch (IllegalArgumentException ime) {}
    
    //(After 22. f4 winning is at hand.)   
  }

}
