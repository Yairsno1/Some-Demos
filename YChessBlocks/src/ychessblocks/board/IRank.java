/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ychessblocks.board;

/**
 *
 * @author Yair
 */
public interface IRank 
{
  public enum ChessboardRank
  {
    RANK1(0),
    RANK2(1),
    RANK3(2),
    RANK4(3),
    RANK5(4),
    RANK6(5),
    RANK7(6),
    RANK8(7);
    
    private int m_ordinal;
    private ChessboardRank(int p_ordinal)
    {
      m_ordinal = p_ordinal;
    }
    
    public int getOrdinal()
    {
      return m_ordinal;
    }    
  }
  
  public ChessboardRank getVal();
}
