/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ychessblocks.notation;

import ychessblocks.board.*;
import ychessblocks.piece.*;

import java.util.*;

/**
 *
 * @author Yair
 */
public final class SANTranslator 
{
  private HashMap<IFile.ChessboardFile,String> m_fileMap;
  private HashMap<IRank.ChessboardRank,String> m_rankMap;
  private HashMap<ISquare,String> m_squareMap;
  private HashMap<IPiece.PieceKind,String> m_pieceMap;
  
  SANTranslator()
  {
    char notation;
            
    m_fileMap = new HashMap<>();
    for (IFile.ChessboardFile cbf: IFile.ChessboardFile.values())
    {
      notation = (char)('a' + cbf.getOrdinal());
      m_fileMap.put(cbf, String.valueOf(notation));
    }
    
    m_rankMap = new HashMap<>();
    for (IRank.ChessboardRank cbr: IRank.ChessboardRank.values())
    {
      notation = (char)('1' + cbr.getOrdinal());
      m_rankMap.put(cbr, String.valueOf(notation));
    }
    
    //squareMap will be filled on demand.
    m_squareMap = new HashMap<>();
    
    //pieceMap will be filled on demand.
    m_pieceMap = new HashMap<>();
  }
  
  public String getFileNotation(IFile p_file)
  {
    return p_file != null ? m_fileMap.get(p_file.getVal()) : "";
  }
  
  public String getRankNotation(IRank p_rank)
  {
    return p_rank != null ? m_rankMap.get(p_rank.getVal()) : "";
  }
  
  public String getSquareNotation(ISquare p_square)
  {
    String rv = "";
    
    if (p_square != null)
    {
      rv = m_squareMap.get(p_square);
      if (null == rv)
      {
        rv = getFileNotation(p_square.getFile()) + 
             getRankNotation(p_square.getRank());
        m_squareMap.put(p_square,rv);
      }
    }
    
    return rv;
  }
  
  public String getPieceNotation(IPiece p_piece)
  {
    String rv = "";
    
    if (p_piece != null)
    {
      rv = m_pieceMap.get(p_piece.getKind());
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
        else
        {
          rv = "";
        }
        m_pieceMap.put(p_piece.getKind(), rv);
      }
    }
    
    return rv;
  }
}
