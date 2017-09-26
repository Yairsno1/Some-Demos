/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ychessblocks.uidemo;

import java.awt.Graphics;
import java.awt.Cursor;
import java.awt.Toolkit;
import java.awt.Image;
import java.awt.Point;
import javax.swing.ImageIcon;

import ychessblocks.board.*;
import ychessblocks.piece.*;
import ychessblocks.position.*;

/**
 *
 * @author Yair
 */
public class VBoard extends javax.swing.JPanel
{
  private VSquare[] m_squares; 
  private IPosition m_model;
  private VSquare m_from;
  private VSquare m_to;
  private ImageIcon m_draggedPiece;
  private int m_lastX;
  private int m_lastY;
  private Cursor m_savCursor; 
  private Cursor m_draggedPieceCursor;
  
  /**
   * Creates new form VBoard
   */
  public VBoard()
  {
    m_model = new Position();
    m_model.set();
    m_from = null;
    m_draggedPiece = null;
    m_draggedPieceCursor = null;
    initComponents();
    myInitComponents();
  }

  public void pieceGrabbed(VSquare p_squareOfPiece)
  {
    m_from = p_squareOfPiece;
    m_savCursor = getCursor();
  }

  public void moveDone(VSquare p_squareOfPiece)
  {
    int i;
    m_to = p_squareOfPiece;
    
    if (m_from != null)
    {
      try
      {
        IPosition newPos = m_model.move(m_from.getModel(), m_to.getModel());
        m_model = newPos;
      }
      catch (Exception excp) {//IllegalMove}
        
      }
      for (i=0; i<64; i++)
      {
        m_squares[i].putPiece(m_model);
        m_squares[i].repaint();
      }      
    }
    else
    {
      p_squareOfPiece.putPiece(m_model);
      p_squareOfPiece.repaint();        
    }
    
    m_from = null;
    m_to = null;
  }
  
  private void myInitComponents() 
  {
    IBoard boardModel = Board.getInstance();
    
    m_squares = new VSquare[64];
    
    //This is white view!
    //8th Rank
    m_squares[0] = new VSquare(boardModel.getSquare(boardModel.getFile(IFile.ChessboardFile.FILEa),
                                               boardModel.getRank(IRank.ChessboardRank.RANK8)));
    m_squares[1] = new VSquare(boardModel.getSquare(boardModel.getFile(IFile.ChessboardFile.FILEb),
                                               boardModel.getRank(IRank.ChessboardRank.RANK8)));
    m_squares[2] = new VSquare(boardModel.getSquare(boardModel.getFile(IFile.ChessboardFile.FILEc),
                                               boardModel.getRank(IRank.ChessboardRank.RANK8)));
    m_squares[3] = new VSquare(boardModel.getSquare(boardModel.getFile(IFile.ChessboardFile.FILEd),
                                               boardModel.getRank(IRank.ChessboardRank.RANK8)));
    m_squares[4] = new VSquare(boardModel.getSquare(boardModel.getFile(IFile.ChessboardFile.FILEe),
                                               boardModel.getRank(IRank.ChessboardRank.RANK8)));
    m_squares[5] = new VSquare(boardModel.getSquare(boardModel.getFile(IFile.ChessboardFile.FILEf),
                                               boardModel.getRank(IRank.ChessboardRank.RANK8)));
    m_squares[6] = new VSquare(boardModel.getSquare(boardModel.getFile(IFile.ChessboardFile.FILEg),
                                               boardModel.getRank(IRank.ChessboardRank.RANK8)));
    m_squares[7] = new VSquare(boardModel.getSquare(boardModel.getFile(IFile.ChessboardFile.FILEh),
                                               boardModel.getRank(IRank.ChessboardRank.RANK8)));    
    //7th Rank
    m_squares[8] = new VSquare(boardModel.getSquare(boardModel.getFile(IFile.ChessboardFile.FILEa),
                                               boardModel.getRank(IRank.ChessboardRank.RANK7)));
    m_squares[9] = new VSquare(boardModel.getSquare(boardModel.getFile(IFile.ChessboardFile.FILEb),
                                               boardModel.getRank(IRank.ChessboardRank.RANK7)));
    m_squares[10] = new VSquare(boardModel.getSquare(boardModel.getFile(IFile.ChessboardFile.FILEc),
                                               boardModel.getRank(IRank.ChessboardRank.RANK7)));
    m_squares[11] = new VSquare(boardModel.getSquare(boardModel.getFile(IFile.ChessboardFile.FILEd),
                                               boardModel.getRank(IRank.ChessboardRank.RANK7)));
    m_squares[12] = new VSquare(boardModel.getSquare(boardModel.getFile(IFile.ChessboardFile.FILEe),
                                               boardModel.getRank(IRank.ChessboardRank.RANK7)));
    m_squares[13] = new VSquare(boardModel.getSquare(boardModel.getFile(IFile.ChessboardFile.FILEf),
                                               boardModel.getRank(IRank.ChessboardRank.RANK7)));
    m_squares[14] = new VSquare(boardModel.getSquare(boardModel.getFile(IFile.ChessboardFile.FILEg),
                                               boardModel.getRank(IRank.ChessboardRank.RANK7)));
    m_squares[15] = new VSquare(boardModel.getSquare(boardModel.getFile(IFile.ChessboardFile.FILEh),
                                               boardModel.getRank(IRank.ChessboardRank.RANK7)));    
    //6th Rank
    m_squares[16] = new VSquare(boardModel.getSquare(boardModel.getFile(IFile.ChessboardFile.FILEa),
                                               boardModel.getRank(IRank.ChessboardRank.RANK6)));
    m_squares[17] = new VSquare(boardModel.getSquare(boardModel.getFile(IFile.ChessboardFile.FILEb),
                                               boardModel.getRank(IRank.ChessboardRank.RANK6)));
    m_squares[18] = new VSquare(boardModel.getSquare(boardModel.getFile(IFile.ChessboardFile.FILEc),
                                               boardModel.getRank(IRank.ChessboardRank.RANK6)));
    m_squares[19] = new VSquare(boardModel.getSquare(boardModel.getFile(IFile.ChessboardFile.FILEd),
                                               boardModel.getRank(IRank.ChessboardRank.RANK6)));
    m_squares[20] = new VSquare(boardModel.getSquare(boardModel.getFile(IFile.ChessboardFile.FILEe),
                                               boardModel.getRank(IRank.ChessboardRank.RANK6)));
    m_squares[21] = new VSquare(boardModel.getSquare(boardModel.getFile(IFile.ChessboardFile.FILEf),
                                               boardModel.getRank(IRank.ChessboardRank.RANK6)));
    m_squares[22] = new VSquare(boardModel.getSquare(boardModel.getFile(IFile.ChessboardFile.FILEg),
                                               boardModel.getRank(IRank.ChessboardRank.RANK6)));
    m_squares[23] = new VSquare(boardModel.getSquare(boardModel.getFile(IFile.ChessboardFile.FILEh),
                                               boardModel.getRank(IRank.ChessboardRank.RANK6)));    
    //5th Rank
    m_squares[24] = new VSquare(boardModel.getSquare(boardModel.getFile(IFile.ChessboardFile.FILEa),
                                               boardModel.getRank(IRank.ChessboardRank.RANK5)));
    m_squares[25] = new VSquare(boardModel.getSquare(boardModel.getFile(IFile.ChessboardFile.FILEb),
                                               boardModel.getRank(IRank.ChessboardRank.RANK5)));
    m_squares[26] = new VSquare(boardModel.getSquare(boardModel.getFile(IFile.ChessboardFile.FILEc),
                                               boardModel.getRank(IRank.ChessboardRank.RANK5)));
    m_squares[27] = new VSquare(boardModel.getSquare(boardModel.getFile(IFile.ChessboardFile.FILEd),
                                               boardModel.getRank(IRank.ChessboardRank.RANK5)));
    m_squares[28] = new VSquare(boardModel.getSquare(boardModel.getFile(IFile.ChessboardFile.FILEe),
                                               boardModel.getRank(IRank.ChessboardRank.RANK5)));
    m_squares[29] = new VSquare(boardModel.getSquare(boardModel.getFile(IFile.ChessboardFile.FILEf),
                                               boardModel.getRank(IRank.ChessboardRank.RANK5)));
    m_squares[30] = new VSquare(boardModel.getSquare(boardModel.getFile(IFile.ChessboardFile.FILEg),
                                               boardModel.getRank(IRank.ChessboardRank.RANK5)));
    m_squares[31] = new VSquare(boardModel.getSquare(boardModel.getFile(IFile.ChessboardFile.FILEh),
                                               boardModel.getRank(IRank.ChessboardRank.RANK5)));    
    //4th Rank
    m_squares[32] = new VSquare(boardModel.getSquare(boardModel.getFile(IFile.ChessboardFile.FILEa),
                                               boardModel.getRank(IRank.ChessboardRank.RANK4)));
    m_squares[33] = new VSquare(boardModel.getSquare(boardModel.getFile(IFile.ChessboardFile.FILEb),
                                               boardModel.getRank(IRank.ChessboardRank.RANK4)));
    m_squares[34] = new VSquare(boardModel.getSquare(boardModel.getFile(IFile.ChessboardFile.FILEc),
                                               boardModel.getRank(IRank.ChessboardRank.RANK4)));
    m_squares[35] = new VSquare(boardModel.getSquare(boardModel.getFile(IFile.ChessboardFile.FILEd),
                                               boardModel.getRank(IRank.ChessboardRank.RANK4)));
    m_squares[36] = new VSquare(boardModel.getSquare(boardModel.getFile(IFile.ChessboardFile.FILEe),
                                               boardModel.getRank(IRank.ChessboardRank.RANK4)));
    m_squares[37] = new VSquare(boardModel.getSquare(boardModel.getFile(IFile.ChessboardFile.FILEf),
                                               boardModel.getRank(IRank.ChessboardRank.RANK4)));
    m_squares[38] = new VSquare(boardModel.getSquare(boardModel.getFile(IFile.ChessboardFile.FILEg),
                                               boardModel.getRank(IRank.ChessboardRank.RANK4)));
    m_squares[39] = new VSquare(boardModel.getSquare(boardModel.getFile(IFile.ChessboardFile.FILEh),
                                               boardModel.getRank(IRank.ChessboardRank.RANK4)));    
    //3rd Rank
    m_squares[40] = new VSquare(boardModel.getSquare(boardModel.getFile(IFile.ChessboardFile.FILEa),
                                               boardModel.getRank(IRank.ChessboardRank.RANK3)));
    m_squares[41] = new VSquare(boardModel.getSquare(boardModel.getFile(IFile.ChessboardFile.FILEb),
                                               boardModel.getRank(IRank.ChessboardRank.RANK3)));
    m_squares[42] = new VSquare(boardModel.getSquare(boardModel.getFile(IFile.ChessboardFile.FILEc),
                                               boardModel.getRank(IRank.ChessboardRank.RANK3)));
    m_squares[43] = new VSquare(boardModel.getSquare(boardModel.getFile(IFile.ChessboardFile.FILEd),
                                               boardModel.getRank(IRank.ChessboardRank.RANK3)));
    m_squares[44] = new VSquare(boardModel.getSquare(boardModel.getFile(IFile.ChessboardFile.FILEe),
                                               boardModel.getRank(IRank.ChessboardRank.RANK3)));
    m_squares[45] = new VSquare(boardModel.getSquare(boardModel.getFile(IFile.ChessboardFile.FILEf),
                                               boardModel.getRank(IRank.ChessboardRank.RANK3)));
    m_squares[46] = new VSquare(boardModel.getSquare(boardModel.getFile(IFile.ChessboardFile.FILEg),
                                               boardModel.getRank(IRank.ChessboardRank.RANK3)));
    m_squares[47] = new VSquare(boardModel.getSquare(boardModel.getFile(IFile.ChessboardFile.FILEh),
                                               boardModel.getRank(IRank.ChessboardRank.RANK3)));    
    //2nd Rank
    m_squares[48] = new VSquare(boardModel.getSquare(boardModel.getFile(IFile.ChessboardFile.FILEa),
                                               boardModel.getRank(IRank.ChessboardRank.RANK2)));
    m_squares[49] = new VSquare(boardModel.getSquare(boardModel.getFile(IFile.ChessboardFile.FILEb),
                                               boardModel.getRank(IRank.ChessboardRank.RANK2)));
    m_squares[50] = new VSquare(boardModel.getSquare(boardModel.getFile(IFile.ChessboardFile.FILEc),
                                               boardModel.getRank(IRank.ChessboardRank.RANK2)));
    m_squares[51] = new VSquare(boardModel.getSquare(boardModel.getFile(IFile.ChessboardFile.FILEd),
                                               boardModel.getRank(IRank.ChessboardRank.RANK2)));
    m_squares[52] = new VSquare(boardModel.getSquare(boardModel.getFile(IFile.ChessboardFile.FILEe),
                                               boardModel.getRank(IRank.ChessboardRank.RANK2)));
    m_squares[53] = new VSquare(boardModel.getSquare(boardModel.getFile(IFile.ChessboardFile.FILEf),
                                               boardModel.getRank(IRank.ChessboardRank.RANK2)));
    m_squares[54] = new VSquare(boardModel.getSquare(boardModel.getFile(IFile.ChessboardFile.FILEg),
                                               boardModel.getRank(IRank.ChessboardRank.RANK2)));
    m_squares[55] = new VSquare(boardModel.getSquare(boardModel.getFile(IFile.ChessboardFile.FILEh),
                                               boardModel.getRank(IRank.ChessboardRank.RANK2)));    
    //1st Rank
    m_squares[56] = new VSquare(boardModel.getSquare(boardModel.getFile(IFile.ChessboardFile.FILEa),
                                               boardModel.getRank(IRank.ChessboardRank.RANK1)));
    m_squares[57] = new VSquare(boardModel.getSquare(boardModel.getFile(IFile.ChessboardFile.FILEb),
                                               boardModel.getRank(IRank.ChessboardRank.RANK1)));
    m_squares[58] = new VSquare(boardModel.getSquare(boardModel.getFile(IFile.ChessboardFile.FILEc),
                                               boardModel.getRank(IRank.ChessboardRank.RANK1)));
    m_squares[59] = new VSquare(boardModel.getSquare(boardModel.getFile(IFile.ChessboardFile.FILEd),
                                               boardModel.getRank(IRank.ChessboardRank.RANK1)));
    m_squares[60] = new VSquare(boardModel.getSquare(boardModel.getFile(IFile.ChessboardFile.FILEe),
                                               boardModel.getRank(IRank.ChessboardRank.RANK1)));
    m_squares[61] = new VSquare(boardModel.getSquare(boardModel.getFile(IFile.ChessboardFile.FILEf),
                                               boardModel.getRank(IRank.ChessboardRank.RANK1)));
    m_squares[62] = new VSquare(boardModel.getSquare(boardModel.getFile(IFile.ChessboardFile.FILEg),
                                               boardModel.getRank(IRank.ChessboardRank.RANK1)));
    m_squares[63] = new VSquare(boardModel.getSquare(boardModel.getFile(IFile.ChessboardFile.FILEh),
                                               boardModel.getRank(IRank.ChessboardRank.RANK1)));    
    
    int i;
    for (i=0; i<64; i++)
    {
      m_squares[i].putPiece(m_model);
      add(m_squares[i]);
    }
  }
  
  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    setLayout(new java.awt.GridLayout(8, 8));
  }// </editor-fold>//GEN-END:initComponents

  private Cursor createCursor(VSquare1 sq)
  {
    IPiece p;
    Toolkit toolkit = Toolkit.getDefaultToolkit();  
    Image cursorImg = null;
    
    if (m_model.getPiece(sq.getModel()) != null)
    {
      p = m_model.getPiece(sq.getModel());
      
      if (p.isWhite())
      {
        if (p.getKind().equals(IPiece.PieceKind.KING))
        {
          cursorImg = toolkit.getImage("images/wk.gif");  
        }
        else if (p.getKind().equals(IPiece.PieceKind.QUEEN))
        {
          cursorImg = toolkit.getImage("images/wq.gif");  
        }
        else if (p.getKind().equals(IPiece.PieceKind.ROOK))
        {
          cursorImg = toolkit.getImage("images/wr.gif");  
        }
        else if (p.getKind().equals(IPiece.PieceKind.KNIGHT))
        {
          cursorImg = toolkit.getImage("images/wn.gif");  
        }
        else if (p.getKind().equals(IPiece.PieceKind.BISHOP))
        {
          cursorImg = toolkit.getImage("images/wb.gif");  
        }
        else
        {
          cursorImg = toolkit.getImage("images/wp.gif");  
        }
     }
     else
     {
       if (p.getKind().equals(IPiece.PieceKind.KING))
       {
         cursorImg = toolkit.getImage("images/bk.gif");  
       }
       else if (p.getKind().equals(IPiece.PieceKind.QUEEN))
       {
         cursorImg = toolkit.getImage("images/bq.gif");  
       }
       else if (p.getKind().equals(IPiece.PieceKind.ROOK))
       {
         cursorImg = toolkit.getImage("images/br.gif");  
       }
       else if (p.getKind().equals(IPiece.PieceKind.KNIGHT))
       {
         cursorImg = toolkit.getImage("images/bn.gif");  
       }
       else if (p.getKind().equals(IPiece.PieceKind.BISHOP))
       {
         cursorImg = toolkit.getImage("images/bb.gif");  
       }
       else
       {
         cursorImg = toolkit.getImage("images/bp.gif");  
       }
      }
    }
    
    if (cursorImg != null)
    {
      Point hotSpot = new Point(0,0);  
      return toolkit.createCustomCursor(cursorImg, hotSpot, "xxx");        
    }
    else
    {
      return null;
    }
  }
  // Variables declaration - do not modify//GEN-BEGIN:variables
  // End of variables declaration//GEN-END:variables
}
