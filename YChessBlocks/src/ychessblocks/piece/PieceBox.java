/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ychessblocks.piece;

import ychessblocks.board.IColor;

/**
 *
 * @author Yair
 */
public class PieceBox implements IPieceBox
{

  private static PieceBox m_instance = new PieceBox();
  
  private static IPiece m_wPawn = new WhitePawn();
  private static IPiece m_bPawn = new BlackPawn();
  private static IPiece m_wBishop = new WhiteBishop();
  private static IPiece m_bBishop = new BlackBishop();
  private static IPiece m_wRook = new WhiteRook();
  private static IPiece m_bRook = new BlackRook();
  private static IPiece m_wQueen = new WhiteQueen();
  private static IPiece m_bQueen = new BlackQueen();
  private static IPiece m_wKing = new WhiteKing();
  private static IPiece m_bKing = new BlackKing();
  private static IPiece m_wKnight = new WhiteKnight();
  private static IPiece m_bKnight = new BlackKnight();
  
  protected PieceBox()
  {
    
  }
  
  public static PieceBox getInstance()
  {
    return m_instance;
  }

  @Override
  public IPiece createWhiteRook() 
  {
    return m_wRook;
  }

  @Override
  public IPiece createBlackRook() 
  {
    return m_bRook;
  }

  @Override
  public IPiece createWhiteKnight() 
  {
    return m_wKnight;
  }

  @Override
  public IPiece createBlackKnight() 
  {
    return m_bKnight;
  }
  
  @Override
  public IPiece createWhiteBishop() 
  {
    return m_wBishop;
  }

  @Override
  public IPiece createBlackBishop() 
  {
    return m_bBishop;
  }

  @Override
  public IPiece createWhiteQueen() 
  {
    return m_wQueen;
  }

  @Override
  public IPiece createBlackQueen() 
  {
    return m_bQueen;
  }

  @Override
  public IPiece createWhiteKing() 
  {
    return m_wKing;
  }

  @Override
  public IPiece createBlackKing() 
  {
    return m_bKing;
  }
  
  @Override
  public IPiece createWhitePawn() 
  {
    return m_wPawn;
  }

  @Override
  public IPiece createBlackPawn() 
  {
    return m_bPawn;
  }
  
  @Override
  public IPiece createPiece(IPiece.PieceKind p_pieceKind,
                            IColor p_color) throws IllegalArgumentException
  {      
    IPiece rv = null;  
  
    if (p_color == null)
    {
      throw new IllegalArgumentException();
    }
    else if (p_color.getColor().equals(IColor.ChessColor.WHITE))
    {
      if (p_pieceKind.equals(IPiece.PieceKind.KING))
      {
        rv = createWhiteKing();
      }
      else if (p_pieceKind.equals(IPiece.PieceKind.QUEEN))
      {
        rv = createWhiteQueen();
      }
      else if (p_pieceKind.equals(IPiece.PieceKind.ROOK))
      {
        rv = createWhiteRook();
      }
      else if (p_pieceKind.equals(IPiece.PieceKind.BISHOP))
      {
        rv = createWhiteBishop();
      }
      else if (p_pieceKind.equals(IPiece.PieceKind.KNIGHT))
      {
        rv = createWhiteKnight();
      }
      else if (p_pieceKind.equals(IPiece.PieceKind.PAWN))
      {
        rv = createWhitePawn();
      }          
    }
    else  //black piece
    {
      if (p_pieceKind.equals(IPiece.PieceKind.KING))
      {
        rv = createBlackKing();
      }
      else if (p_pieceKind.equals(IPiece.PieceKind.QUEEN))
      {
        rv = createBlackQueen();
      }     
      else if (p_pieceKind.equals(IPiece.PieceKind.ROOK))
      {
        rv = createBlackRook();
      }
      else if (p_pieceKind.equals(IPiece.PieceKind.BISHOP))
      {
        rv = createBlackBishop();
      }
      else if (p_pieceKind.equals(IPiece.PieceKind.KNIGHT))
      {
        rv = createBlackKnight();
      }
      else if (p_pieceKind.equals(IPiece.PieceKind.PAWN))
      {
        rv = createBlackPawn();
      }     
    }
    
    return rv;
  }
  
}
