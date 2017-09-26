/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ychessblocks.piece;

import ychessblocks.board.*;

/**
 *
 * @author Yair
 */
public abstract class Pawn extends AbsPiece
{
  protected Pawn(IColor p_color) 
  {
    super(PieceKind.PAWN,p_color);
  }        
}
