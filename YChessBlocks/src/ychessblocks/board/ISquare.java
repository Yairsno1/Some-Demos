/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ychessblocks.board;

/**
 *
 * @author Yair
 */
public interface ISquare
{
  public IFile getFile();
  public IRank getRank();
  public IColor getColor();
}
