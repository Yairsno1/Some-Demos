/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ychessblocks.move;

import ychessblocks.position.IPosition;

/**
 *
 * @author Yair
 */
public class MoveTree extends AbsMoveTree
{
  protected MoveTree(IPosition p_position, IMoveTree p_prev)
  {
    super(p_position, p_prev);
  }

  protected MoveTree(IPosition p_position,
                     IMoveTree p_prev,
                     int p_moveNumber)
  {
    super(p_position, p_prev, p_moveNumber);
  }
  
  public static IMoveTree createTreeStart(IPosition p_position, int p_moveNumber)
  {
    IMoveTree rv;
    
    rv = new MoveTree(p_position,null,p_moveNumber);
    
    return rv;
  }
  
  @Override
  protected AbsMoveTree doCreateMoveTree(IPosition p_position, IMoveTree p_prev) 
  {
    return new MoveTree(p_position,p_prev);
  }
 
}
