/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ychessblocks.ux;

import ychessblocks.board.*;

/**
 *
 * @author Yair
 */
public interface IGSquare 
{
  public IGBoard getBoard();
  public ISquare getModel();
  
  public void paint();
  public void putPiece();
}
