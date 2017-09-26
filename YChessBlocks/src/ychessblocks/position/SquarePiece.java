/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ychessblocks.position;

import ychessblocks.board.*;
import ychessblocks.piece.*;

/**
 *
 * @author Yair
 */
public class SquarePiece implements ISquarePiece
{

  private ISquare m_square;
  private IPiece m_piece;
  
  public SquarePiece(ISquare p_square, IPiece p_piece)
  {
    m_square = p_square;
    m_piece = p_piece;
  }
  
  @Override
  public ISquare getSquare()
  {
    return m_square;
    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public IPiece getPiece()
  {
    return m_piece;
  }
  
}
