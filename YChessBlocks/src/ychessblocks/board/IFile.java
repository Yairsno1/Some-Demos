/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ychessblocks.board;

/**
 *
 * @author Yair
 */
public interface IFile 
{
  public enum ChessboardFile
  {
    FILEa(0),
    FILEb(1),
    FILEc(2),
    FILEd(3),
    FILEe(4),
    FILEf(5),
    FILEg(6),
    FILEh(7);
    
    private int m_ordinal;
    
    private ChessboardFile(int p_ordinal)
    {
      m_ordinal = p_ordinal;
    }
    
    public int getOrdinal()
    {
      return m_ordinal;
    }
    
  }
  
  public ChessboardFile getVal();    
}
