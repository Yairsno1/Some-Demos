/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ychessblocks.position;

/**
 *
 * @author Yair
 */
public class IllegalTurnException extends Exception
{

  /**
   * Creates a new instance of
   * <code>IllegalTurnException</code> without detail message.
   */
  public IllegalTurnException() 
  {
    super();
  }

  /**
   * Constructs an instance of
   * <code>IllegalTurnException</code> with the specified detail message.
   *
   * @param msg the detail message.
   */
  public IllegalTurnException(String p_msg) 
  {
    super(p_msg);
  }
}
