/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ychessblocks.uidemo;

import java.net.*;
import javax.swing.ImageIcon;

import ychessblocks.board.*;
import ychessblocks.piece.*;
import ychessblocks.position.*;

/**
 *
 * @author Yair
 */
public class GraphicsRepository
{
  private static GraphicsRepository m_instance = new GraphicsRepository();
  
  private ImageIcon m_whiteSq;
  private ImageIcon m_blackSq;
  private ImageIcon m_whiteKing;
  private ImageIcon m_whiteQueen;
  private ImageIcon m_whiteRook;
  private ImageIcon m_whiteKnight;
  private ImageIcon m_whiteBishop;
  private ImageIcon m_whitePawn;
  private ImageIcon m_blackKing;
  private ImageIcon m_blackQueen;
  private ImageIcon m_blackRook;
  private ImageIcon m_blackKnight;
  private ImageIcon m_blackBishop;
  private ImageIcon m_blackPawn;
  
  private GraphicsRepository()
  {    
    createSquares();  
    createPieces();  
  }
  
  public static GraphicsRepository getInstance()
  {
    return m_instance;
  }
  
  public ImageIcon getSquareBkg(ISquare p_sq)
  {
    return p_sq.getColor().getColor().equals(IColor.ChessColor.WHITE) ? 
             m_whiteSq :
             m_blackSq;
  }
  
  public ImageIcon createPieceImage(IPiece p_pieceModel)
  {
    ImageIcon rv;
    
    if (null == p_pieceModel)
    {
      rv = null;
      return rv;
    }
    
    if (p_pieceModel.isWhite())
    {
       if (p_pieceModel.getKind().equals(IPiece.PieceKind.KING))
       {
         rv = m_whiteKing;
       }
       else if (p_pieceModel.getKind().equals(IPiece.PieceKind.QUEEN))
       {
         rv = m_whiteQueen;
       }
       else if (p_pieceModel.getKind().equals(IPiece.PieceKind.ROOK))
       {
         rv = m_whiteRook;
       }
       else if (p_pieceModel.getKind().equals(IPiece.PieceKind.KNIGHT))
       {
         rv = m_whiteKnight;
       }
       else if (p_pieceModel.getKind().equals(IPiece.PieceKind.BISHOP))
       {
         rv = m_whiteBishop;
       }
       else
       {
         rv = m_whitePawn;
       }
    }
    else
    {
      if (p_pieceModel.getKind().equals(IPiece.PieceKind.KING))
      {
        rv = m_blackKing;
      }
      else if (p_pieceModel.getKind().equals(IPiece.PieceKind.QUEEN))
      {
        rv = m_blackQueen;
      }
      else if (p_pieceModel.getKind().equals(IPiece.PieceKind.ROOK))
      {
        rv = m_blackRook;
      }
      else if (p_pieceModel.getKind().equals(IPiece.PieceKind.KNIGHT))
      {
        rv = m_blackKnight;
      }
      else if (p_pieceModel.getKind().equals(IPiece.PieceKind.BISHOP))
      {
        rv = m_blackBishop;
      }
      else
      {
        rv = m_blackPawn;
      }
    }
       
    return rv;
  }
  
  private void createSquares()
  {
    URL imgUrl = getClass().getResource("images/Schemes/wood/white.jpg");  
    m_whiteSq = new ImageIcon(imgUrl);    
    imgUrl = getClass().getResource("images/Schemes/wood/black.jpg");  
    m_blackSq = new ImageIcon(imgUrl);        
  }
  
  private void createPieces()
  {
    URL imgUrl = getClass().getResource("images/wk.gif");  
    m_whiteKing = new ImageIcon(imgUrl);    
    imgUrl = getClass().getResource("images/bk.gif");  
    m_blackKing = new ImageIcon(imgUrl);    
    
    imgUrl = getClass().getResource("images/wq.gif");  
    m_whiteQueen = new ImageIcon(imgUrl);    
    imgUrl = getClass().getResource("images/bq.gif");  
    m_blackQueen = new ImageIcon(imgUrl);    

    imgUrl = getClass().getResource("images/wr.gif");  
    m_whiteRook = new ImageIcon(imgUrl);    
    imgUrl = getClass().getResource("images/br.gif");  
    m_blackRook = new ImageIcon(imgUrl);    

    imgUrl = getClass().getResource("images/wn.gif");  
    m_whiteKnight = new ImageIcon(imgUrl);    
    imgUrl = getClass().getResource("images/bn.gif");  
    m_blackKnight = new ImageIcon(imgUrl);    

    imgUrl = getClass().getResource("images/wb.gif");  
    m_whiteBishop = new ImageIcon(imgUrl);    
    imgUrl = getClass().getResource("images/bb.gif");  
    m_blackBishop = new ImageIcon(imgUrl);    

    imgUrl = getClass().getResource("images/wp.gif");  
    m_whitePawn = new ImageIcon(imgUrl);    
    imgUrl = getClass().getResource("images/bp.gif");  
    m_blackPawn = new ImageIcon(imgUrl);    
    
  }

}
