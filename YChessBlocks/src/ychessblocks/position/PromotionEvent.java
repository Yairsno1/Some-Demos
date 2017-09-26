/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ychessblocks.position;

import java.util.*;
import ychessblocks.board.*;

/**
 *
 * @author Yair
 */
public class PromotionEvent extends EventObject
{ 
  private IColor m_color;
  
  public PromotionEvent(Object p_source, IColor p_color) 
  {
    super(p_source);
    m_color = p_color;
  } 
  
  public IColor getPawnColor()
  {
    return m_color;
  }
}
