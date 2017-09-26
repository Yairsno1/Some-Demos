/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ychessblocks.ux;

import ychessblocks.position.*;
/**
 *
 * @author Yair
 */
public interface IGBoard
{
  public IPosition getModel();
  
  public void grabbingPiece(IGSquare pieceSquare);
  public void layingPiece(IGSquare pieceSquare);
}
