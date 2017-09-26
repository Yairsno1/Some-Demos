/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ychessblocks.board;

/**
 *
 * @author Yair
 */
public interface IColor
{
  public enum ChessColor
  {
    WHITE,
    BLACK
  }
  
  public ChessColor getColor();
}
