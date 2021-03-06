/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ychessblocks.piece;

import ychessblocks.board.ChessColor;
import ychessblocks.board.ISquare;
import ychessblocks.position.IPosition;

/**
 *
 * @author Yair
 */
public class WhiteKnight extends Knight
{
  public WhiteKnight()
  {
    super(ChessColor.getInstance().getWhite());
  }
  
  @Override
  public boolean isWhite()
  {
    return true;    
  }

  @Override
  public boolean isBlack() 
  {
    return false;
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
    else if (p.isBlack())
    {
      rv = true;
    }
    
    return rv;
  }
  
}
