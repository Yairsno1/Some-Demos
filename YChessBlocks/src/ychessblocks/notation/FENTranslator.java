/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ychessblocks.notation;

import java.util.*;

import ychessblocks.board.*;
import ychessblocks.piece.IPiece;

/**
 *
 * @author Yair
 */
public class FENTranslator
{
  private HashMap<IPiece.PieceKind,String> m_whitePieceMap;
  private HashMap<IPiece.PieceKind,String> m_blackPieceMap;
  private HashMap<IColor,String> m_colorMap;
  private String[] m_castlingMap;
  
  FENTranslator()
  {
    //pieceMaps will be filled on demand.
    m_whitePieceMap = new HashMap<>();
    m_blackPieceMap = new HashMap<>();
    
    m_colorMap = new HashMap<>();
    m_colorMap.put(ChessColor.getInstance().getWhite(), "w");
    m_colorMap.put(ChessColor.getInstance().getBlack(), "b");
    
    m_castlingMap = new String[16];
    m_castlingMap[0] = "-";
    m_castlingMap[1] = "K";
    m_castlingMap[2] = "Q";
    m_castlingMap[3] = "KQ";
    m_castlingMap[4] = "k";
    m_castlingMap[5] = "Kk";
    m_castlingMap[6] = "Qk";
    m_castlingMap[7] = "KQk";
    m_castlingMap[8] = "q";
    m_castlingMap[9] = "Kq";
    m_castlingMap[10] = "Qq";
    m_castlingMap[11] = "KQq";
    m_castlingMap[12] = "kq";
    m_castlingMap[13] = "Kkq";
    m_castlingMap[14] = "Qkq";
    m_castlingMap[15] = "KQkq";   
  }

  public String getActiveColorNotation(IColor p_color)
  {
    return p_color != null ? m_colorMap.get(p_color) : "";  
  }
  
  public String getCastlingNotation(boolean p_w00,
                                    boolean p_w000,
                                    boolean p_b00,
                                    boolean p_b000)
  {   
    //We cover all 16 possible combinations by implementing 
    //castling flags as bits. p_w00 is the LSB.
    int i = 0;   
    i = p_w00  ? i|1 : i;
    i = p_w000 ? i|2 : i;
    i = p_b00  ? i|4 : i;
    i = p_b000 ? i|8 : i;
        
    return m_castlingMap[i];    
  }
  
  public String getFullmoveNumberNotation(int p_fullmoveNum)
  {
    return String.valueOf(p_fullmoveNum);
  }

  public String getHalfmoveClockNotation(int p_halfmoveClock)
  {
    return String.valueOf(p_halfmoveClock);
  }
  
  public String getPieceNotation(IPiece p_piece)
  {
    String rv = "";
    
    if (p_piece != null)
    {
      rv = p_piece.isWhite() ? 
             getWhitePieceNotation(p_piece) : 
             getBlackPieceNotation(p_piece);
    }
    
    return rv;
  }
  
  public String getSquareNotation(ISquare p_square)
  {
    SANTranslator SAN = NotationTranslator.getInstance().getStandradAlgebricNotationTranslator();  

    return p_square != null ? SAN.getSquareNotation(p_square) : "-";
  }
  
  private String getBlackPieceNotation(IPiece p_piece)
  {
    String rv;
    
    rv = m_blackPieceMap.get(p_piece.getKind());
    if (null == rv)
    {
      if (p_piece.getKind().equals(IPiece.PieceKind.KING))
      {
        rv = "k";
      }
      else if (p_piece.getKind().equals(IPiece.PieceKind.QUEEN))
      {
        rv = "q";
      }
      else if (p_piece.getKind().equals(IPiece.PieceKind.ROOK))
      {
        rv = "r";
      }
      else if (p_piece.getKind().equals(IPiece.PieceKind.KNIGHT))
      {
        rv = "n";
      }
      else if (p_piece.getKind().equals(IPiece.PieceKind.BISHOP))
      {
        rv = "b";
      }
      else if (p_piece.getKind().equals(IPiece.PieceKind.PAWN))
      {
        rv = "p";
      }      
      m_blackPieceMap.put(p_piece.getKind(), rv);
    }
    
    return rv;
  }
  
  private String getWhitePieceNotation(IPiece p_piece)
  {
    String rv;
    
    rv = m_whitePieceMap.get(p_piece.getKind());
    if (null == rv)
    {
      if (p_piece.getKind().equals(IPiece.PieceKind.KING))
      {
        rv = "K";
      }
      else if (p_piece.getKind().equals(IPiece.PieceKind.QUEEN))
      {
        rv = "Q";
      }
      else if (p_piece.getKind().equals(IPiece.PieceKind.ROOK))
      {
        rv = "R";
      }
      else if (p_piece.getKind().equals(IPiece.PieceKind.KNIGHT))
      {
        rv = "N";
      }
      else if (p_piece.getKind().equals(IPiece.PieceKind.BISHOP))
      {
        rv = "B";
      }
      else if (p_piece.getKind().equals(IPiece.PieceKind.PAWN))
      {
        rv = "P";
      }      
      m_whitePieceMap.put(p_piece.getKind(), rv);
    }
    
    return rv;
  }
  
}
