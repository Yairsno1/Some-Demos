/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ychessblocks.position;

import java.util.*;

/**
 *
 * @author Yair
 */
public interface IPromotionListener extends EventListener
{
  public enum PromoteToPieceKind 
  {
    QUEEN,
    ROOK,
    KNIGHT,
    BISHOP
  }
 
  public PromoteToPieceKind getPiece(PromotionEvent e); 
}
