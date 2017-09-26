/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ychessblocks.piece;

import ychessblocks.board.*;
import ychessblocks.position.IPosition;

/**
 *
 * @author Yair
 */
public class WhiteQueen extends Queen
{
  public WhiteQueen()
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
  public ISquare[] generateSlides(ISquare p_from, IPosition p_position)
  {
    ISquare[] rv;
    ISquare[] bishopSlides;
    ISquare[] rookSlides;
    IPiece bishop;
    IPiece rook;
    int i;
    int j;
    
    bishop = PieceBox.getInstance().createWhiteBishop();
    bishopSlides = bishop.generateSlides(p_from, p_position);
    
    rook = PieceBox.getInstance().createWhiteRook();
    rookSlides = rook.generateSlides(p_from, p_position);
    
    rv = new ISquare[bishopSlides.length + rookSlides.length];
    j = 0;
    for (i=0; i<bishopSlides.length; i++)
    {
      rv[j++] = bishopSlides[i];
    }
    for (i=0; i<rookSlides.length; i++)
    {
      rv[j++] = rookSlides[i];
    }
    
    return rv;
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
