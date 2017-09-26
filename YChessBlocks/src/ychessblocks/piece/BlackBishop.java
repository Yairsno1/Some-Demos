/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ychessblocks.piece;

import ychessblocks.board.*;
import ychessblocks.position.*;

/**
 *
 * @author Yair
 */
public class BlackBishop extends Bishop  
{
  public BlackBishop()
  {
    super(ChessColor.getInstance().getBlack());    
  }

  @Override
  public boolean isWhite()
  {
    return false;    
  }

  @Override
  public boolean isBlack() 
  {
    return true;
  }
  
  @Override
  protected boolean canCapture(ISquare p_to, IPosition p_position)
  {
    boolean rv = false;
    IPiece p;
    
    p = p_position.getPiece(p_to);
    if (p == null)
    {
      rv = true;
    }
    else if (p.isWhite())
    {
      rv = true;
    }
    
    return rv;
  }
 
}
