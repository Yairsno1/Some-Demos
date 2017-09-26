/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ychessblocks.board;

/**
 *
 * @author Yair
 */
public interface IBoard 
{
  public enum BoardCompass
  {
    NORTH,
    NORTHEAST,
    EAST,
    SOUTHEAST,
    SOUTH,
    SOUTHWEST,
    WEST,
    NORTHWEST
  }
  
  public IFile getFile(IFile.ChessboardFile file);
  public IRank getRank(IRank.ChessboardRank rank);
  public ISquare getSquare(IFile file, IRank rank) throws IllegalArgumentException;
  
  public IFile decFile(IFile currFile) throws IndexOutOfBoundsException, IllegalArgumentException;
  public IRank decRank(IRank currRank) throws IndexOutOfBoundsException, IllegalArgumentException;
  public IFile incFile(IFile currFile) throws IndexOutOfBoundsException, IllegalArgumentException;
  public IRank incRank(IRank currRank) throws IndexOutOfBoundsException, IllegalArgumentException;
  
  public boolean tryNorth(ISquare from, ISquare to);
  public boolean tryNorthEast(ISquare from, ISquare to);
  public boolean tryEast(ISquare from, ISquare to);
  public boolean trySouthEast(ISquare from, ISquare to);
  public boolean trySouth(ISquare from, ISquare to);
  public boolean trySouthWest(ISquare from, ISquare to);  
  public boolean tryWest(ISquare from, ISquare to);
  public boolean tryNorthWest(ISquare from, ISquare to);  
}

