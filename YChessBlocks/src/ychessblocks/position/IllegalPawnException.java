/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ychessblocks.position;

/**
 *
 * @author Yair
 */
public class IllegalPawnException extends Exception 
{

  /**
   * Creates a new instance of
   * <code>IllegalPawnException</code> without detail message.
   */
  public IllegalPawnException() 
  {
    super();
  }

  /**
   * Constructs an instance of
   * <code>IllegalPawnException</code> with the specified detail message.
   *
   * @param msg the detail message.
   */
  public IllegalPawnException(String p_msg) 
  {
    super(p_msg);
  }
}
