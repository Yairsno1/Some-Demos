/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ychessblocks.piece;

import ychessblocks.board.*;
import ychessblocks.position.*;
import java.util.*;

/**
 *
 * @author Yair
 */
public abstract class AbsPiece implements IPiece
{
  private PieceKind m_kind;
  private IColor m_color;  
  
  protected AbsPiece(PieceKind p_kind, IColor p_color)
  {
    m_kind = p_kind;
    m_color = p_color;
  }
  
  @Override
  public PieceKind getKind()
  {
    return m_kind;
  }
  
  @Override
  public IColor getColor()
  {
    return m_color;
  }
  
  protected boolean isSquaresEmpty(ArrayList<ISquare> p_inBetween, IPosition p_pos)
  {
    boolean rv = true; 
    int i;
    ISquare sq;
    
    for (i = 0;i<p_inBetween.size(); i++)
    {
      sq  = p_inBetween.get(i);
      if (p_pos.getPiece(sq) != null)
      {
        rv = false;
        break;
      }
    }
    
    return rv;
  }
    
}
