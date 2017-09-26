/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ychessblocks.position;

/**
 *
 * @author Yair
 */
public class IllegalMoveException extends Exception 
{
  public enum MoveFault
  {
    PIECE,
    COLOR,
    CHECK
  }
    
  private MoveFault m_fault;
  /**
   * Creates a new instance of
   * <code>IllegalMoveException</code> without detail message.
   */
  //public IllegalMoveException() 
  //{
  //}

  public IllegalMoveException(MoveFault p_fault)
  {
    super();
    m_fault = p_fault;  
  }
  /**
   * Constructs an instance of
   * <code>IllegalMoveException</code> with the specified detail message.
   *
   * @param msg the detail message.
   */
  public IllegalMoveException(MoveFault p_fault,String p_msg) 
  {
    super(p_msg);
    m_fault = p_fault;  
  }
  
  public MoveFault getFault()
  {
    return m_fault;
  }
}
