/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ychessblocks.uidemo;

import java.awt.Graphics;
import java.net.*;
import javax.swing.ImageIcon;

import ychessblocks.board.*;
import ychessblocks.piece.*;
import ychessblocks.position.*;

/**
 *
 * @author Yair
 */
public class VSquare1 extends javax.swing.JPanel 
{
  private ISquare m_model;
  private ImageIcon m_whiteSq;
  private ImageIcon m_blackSq;
  private ImageIcon m_pieceImg;
  private String m_SAN;
  /**
   * Creates new form VSquare1
   */
  public VSquare1(ISquare p_model) 
  {
    m_model = p_model;
    calcSAN();
    initComponents();
    myInitComponents();
  }

  public ISquare getModel()
  {
    return m_model;  
  }
  
  public String getSAN()
  {
    return m_SAN;  
  }

  public void setPiece(IPosition pos)
  {
    createPieceImage(pos.getPiece(m_model));    
  }
  
  public ImageIcon pieceGrabbed(IPosition pos)
  {
    ImageIcon rv;
    
    rv = createPieceImage(pos.getPiece(m_model));    
    m_pieceImg = null;
    
    return rv;
  }
  
  @Override
  protected void paintComponent(Graphics g) 
  {    
    super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
    
    if (m_model.getColor().getColor().equals(IColor.ChessColor.WHITE))
    {
      g.drawImage(m_whiteSq.getImage(), 0, 0, null);
    }
    else
    { 
      g.drawImage(m_blackSq.getImage(), 0, 0, null);
    }     
    
    if (m_pieceImg != null)
    {
      g.drawImage(m_pieceImg.getImage(), 3, 3, null);
    }
  }
  
  private void myInitComponents() 
  {
    URL urlWhiteBkg = getClass().getResource("images/Schemes/wood/white.jpg");  
    m_whiteSq = new ImageIcon(urlWhiteBkg);
    URL urlBlackBkg = getClass().getResource("images/Schemes/wood/black.jpg");  
    m_blackSq = new ImageIcon(urlBlackBkg);    
    
    m_pieceImg = null;
  }
  
  private void calcSAN()
  {
    if (m_model.getFile().getVal().equals(IFile.ChessboardFile.FILEa))
    {
      m_SAN = "a";
    }
    else if (m_model.getFile().getVal().equals(IFile.ChessboardFile.FILEb))
    {
      m_SAN = "b";
    }
    else if (m_model.getFile().getVal().equals(IFile.ChessboardFile.FILEc))
    {
      m_SAN = "c";
    }
    else if (m_model.getFile().getVal().equals(IFile.ChessboardFile.FILEd))
    {
      m_SAN = "d";
    }
    else if (m_model.getFile().getVal().equals(IFile.ChessboardFile.FILEe))
    {
      m_SAN = "e";
    }
    else if (m_model.getFile().getVal().equals(IFile.ChessboardFile.FILEf))
    {
      m_SAN = "f";
    }
    else if (m_model.getFile().getVal().equals(IFile.ChessboardFile.FILEg))
    {
      m_SAN = "g";
    }
    else if (m_model.getFile().getVal().equals(IFile.ChessboardFile.FILEh))
    {
      m_SAN = "h";
    }

    if (m_model.getRank().getVal().equals(IRank.ChessboardRank.RANK1))
    {
      m_SAN += "1";
    }
    else if (m_model.getRank().getVal().equals(IRank.ChessboardRank.RANK2))
    {
      m_SAN += "2";
    }
    else if (m_model.getRank().getVal().equals(IRank.ChessboardRank.RANK3))
    {
      m_SAN += "3";
    }
    else if (m_model.getRank().getVal().equals(IRank.ChessboardRank.RANK4))
    {
      m_SAN += "4";
    }
    else if (m_model.getRank().getVal().equals(IRank.ChessboardRank.RANK5))
    {
      m_SAN += "5";
    }
    else if (m_model.getRank().getVal().equals(IRank.ChessboardRank.RANK6))
    {
      m_SAN += "6";
    }
    else if (m_model.getRank().getVal().equals(IRank.ChessboardRank.RANK7))
    {
      m_SAN += "7";
    }
    else if (m_model.getRank().getVal().equals(IRank.ChessboardRank.RANK8))
    {
      m_SAN += "8";
    }    
  }
  private ImageIcon createPieceImage(IPiece p_pieceModel)
  {
    ImageIcon rv;
    URL urlPiece;
    
    if (null == p_pieceModel)
    {
      rv = null;
      m_pieceImg = null;
      return rv;
    }
    
    if (p_pieceModel.isWhite())
    {
       if (p_pieceModel.getKind().equals(IPiece.PieceKind.KING))
       {
         urlPiece = getClass().getResource("images/wk.gif");  
       }
       else if (p_pieceModel.getKind().equals(IPiece.PieceKind.QUEEN))
       {
         urlPiece = getClass().getResource("images/wq.gif");  
       }
       else if (p_pieceModel.getKind().equals(IPiece.PieceKind.ROOK))
       {
         urlPiece = getClass().getResource("images/wr.gif");  
       }
       else if (p_pieceModel.getKind().equals(IPiece.PieceKind.KNIGHT))
       {
         urlPiece = getClass().getResource("images/wn.gif");  
       }
       else if (p_pieceModel.getKind().equals(IPiece.PieceKind.BISHOP))
       {
         urlPiece = getClass().getResource("images/wb.gif");  
       }
       else
       {
         urlPiece = getClass().getResource("images/wp.gif");  
       }
    }
    else
    {
      if (p_pieceModel.getKind().equals(IPiece.PieceKind.KING))
      {
        urlPiece = getClass().getResource("images/bk.gif");  
      }
      else if (p_pieceModel.getKind().equals(IPiece.PieceKind.QUEEN))
      {
        urlPiece = getClass().getResource("images/bq.gif");  
      }
      else if (p_pieceModel.getKind().equals(IPiece.PieceKind.ROOK))
      {
        urlPiece = getClass().getResource("images/br.gif");  
      }
      else if (p_pieceModel.getKind().equals(IPiece.PieceKind.KNIGHT))
      {
        urlPiece = getClass().getResource("images/bn.gif");  
      }
      else if (p_pieceModel.getKind().equals(IPiece.PieceKind.BISHOP))
      {
        urlPiece = getClass().getResource("images/bb.gif");  
      }
      else
      {
        urlPiece = getClass().getResource("images/bp.gif");  
      }
    }
    
    rv = new ImageIcon(urlPiece);    
    m_pieceImg = new ImageIcon(urlPiece);    
    
    return rv;
  }
  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    setBorder(javax.swing.BorderFactory.createEtchedBorder());

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 26, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 26, Short.MAX_VALUE)
    );
  }// </editor-fold>//GEN-END:initComponents

  // Variables declaration - do not modify//GEN-BEGIN:variables
  // End of variables declaration//GEN-END:variables
}
