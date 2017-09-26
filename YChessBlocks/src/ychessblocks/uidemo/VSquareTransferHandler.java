/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ychessblocks.uidemo;

import javax.swing.*;
import java.awt.datatransfer.*;
import java.awt.Point;

/**
 *
 * @author Yair
 */
public class VSquareTransferHandler extends TransferHandler
{
  public VSquareTransferHandler()
  {
    super();
  }
  
  @Override
  public int getSourceActions(JComponent c) 
  {
    VSquare vsq = (VSquare)c;
    if (!vsq.isEmpty())
    {
      this.setDragImage(vsq.getPieceCursor().getImage());
    }
    
    return MOVE;
  }  
  
  @Override
  protected Transferable createTransferable(JComponent c)
  {
    Transferable rv = null;
    
    VSquare vsq = (VSquare)c;
    if (!vsq.isEmpty())
    {
      ((VBoard)vsq.getParent()).pieceGrabbed(vsq);
      rv = new StringSelection(vsq.getSAN());
      vsq.clear();
    }
    
    return rv;
  }
  
  @Override
  protected void exportDone(JComponent source,
                            Transferable data,
                            int action)
  {
    VSquare vsq = (VSquare)source;
    //Piece dragged out of board
    ((VBoard)vsq.getParent()).moveDone(vsq);
    //vsq.repaint();
  }
  
  @Override
  public boolean canImport(TransferHandler.TransferSupport support)
  {
    return true;
  }
  
  @Override
  public boolean importData(TransferSupport supp) 
  {
    if (!canImport(supp)) 
    {
      return false;
    }

    String data;
    // Fetch the Transferable and its data
    Transferable t = supp.getTransferable();
    try
    {
      data = (String)(t.getTransferData(DataFlavor.stringFlavor));
    }
    catch (Exception e)
    {
      return false; 
    }

    VSquare vsq = (VSquare)supp.getComponent();
    ((VBoard)vsq.getParent()).moveDone(vsq);

    //vsq.repaint();
    
    return true;
  }  
  
  @Override
  public Point getDragImageOffset()
  {
    Point rv;
    
    rv = new Point(10,10); //super.getDragImageOffset();    
    
    return rv; 
  }
}
