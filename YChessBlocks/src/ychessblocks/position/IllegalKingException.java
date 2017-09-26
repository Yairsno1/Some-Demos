/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ychessblocks.position;

/**
 *
 * @author Yair
 */
public class IllegalKingException extends Exception 
{

  /**
   * Creates a new instance of
   * <code>IllegalKingException</code> without detail message.
   */
  public IllegalKingException() 
  {
    super();
  }

  /**
   * Constructs an instance of
   * <code>IllegalKingException</code> with the specified detail message.
   *
   * @param msg the detail message.
   */
  public IllegalKingException(String p_msg) 
  {
    super(p_msg);
  }
}
