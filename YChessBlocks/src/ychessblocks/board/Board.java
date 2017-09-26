/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ychessblocks.board;

import java.util.*;

/**
 *
 * @author Yair
 */
final public class Board implements IBoard
{
  private static final Board m_instance = new Board();
  private ISquare[] m_squares;
  private EnumMap<IFile.ChessboardFile,File> m_files;
  private IFile[] m_ordinal2File;
  private EnumMap<IRank.ChessboardRank,Rank> m_ranks;
  private IRank[] m_ordinal2Rank;
  
  private Board()
  {
    createFiles();
    createRanks();
    createSquares();
  }
  
  public static Board getInstance()
  {
    return m_instance;
  }
  
  
  @Override 
  public IFile getFile(IFile.ChessboardFile p_file)
  {
    return m_files.get(p_file);
  }
  
  
  @Override 
  public IRank getRank(IRank.ChessboardRank p_rank)
  {
    return m_ranks.get(p_rank);
  }
  
  
  @Override 
  public ISquare getSquare(IFile p_file, IRank p_rank) throws IllegalArgumentException
  {
    ISquare rv;
    Rank r;
    File f;
    
    if (p_file == null || p_rank == null)
    {
      throw new IllegalArgumentException();
    } 
    else
    {
      r = m_ranks.get(p_rank.getVal());
      f = m_files.get(p_file.getVal());
      rv = m_squares[calcIndex(r,f)];
    }
    
    return rv;
  }

  @Override
  public boolean tryNorth(ISquare p_from, ISquare p_to)
  {
    boolean rv = false;
    
    if (p_from != null && p_to != null)
    {
      if (p_from.getFile().equals(p_to.getFile()))
      {
        if (p_to.getRank().getVal().getOrdinal() > p_from.getRank().getVal().getOrdinal())
        {
          rv = true;
        }
      }
    }
    
    return rv;
  }

  @Override
  public boolean tryNorthEast(ISquare p_from, ISquare p_to)
  {
    boolean rv = false;
    int fileOffset;
    int rankOffset;
    
    if (p_from != null && p_to != null)
    {
      fileOffset = p_to.getFile().getVal().getOrdinal() - p_from.getFile().getVal().getOrdinal();
      rankOffset = p_to.getRank().getVal().getOrdinal() - p_from.getRank().getVal().getOrdinal();        
    
      rv = (fileOffset > 0) && (rankOffset > 0) && (fileOffset == rankOffset); 
    }
    
    return rv;
  }
  
  @Override
  public boolean tryEast(ISquare p_from, ISquare p_to)
  {
    boolean rv = false;
    
    if (p_from != null && p_to != null)
    {
      if (p_from.getRank().equals(p_to.getRank()))
      {
        if (p_to.getFile().getVal().getOrdinal() > p_from.getFile().getVal().getOrdinal())
        {
          rv = true;
        }
      }
    }
    
    return rv;
  }

  @Override
  public boolean trySouthEast(ISquare p_from, ISquare p_to)
  {
    boolean rv = false;
    int fileOffset;
    int rankOffset;

    if (p_from != null && p_to != null)
    {
      fileOffset = p_to.getFile().getVal().getOrdinal() - p_from.getFile().getVal().getOrdinal();
      rankOffset = p_to.getRank().getVal().getOrdinal() - p_from.getRank().getVal().getOrdinal();        
    
      rv = (fileOffset > 0) && (rankOffset < 0) && (-1*fileOffset == rankOffset); 
    }
    
    return rv;
  }
  
  @Override
  public boolean trySouth(ISquare p_from, ISquare p_to)
  {
    boolean rv = false;
    
    if (p_from != null && p_to != null)
    {
      if (p_from.getFile().equals(p_to.getFile()))
      {
        if (p_to.getRank().getVal().getOrdinal() < p_from.getRank().getVal().getOrdinal())
        {
          rv = true;
        }
      }
    }
    
    return rv;
  }

  @Override
  public boolean trySouthWest(ISquare p_from, ISquare p_to)
  {
    boolean rv = false;
    int fileOffset;
    int rankOffset;
    
    if (p_from != null && p_to != null)
    {
      fileOffset = p_to.getFile().getVal().getOrdinal() - p_from.getFile().getVal().getOrdinal();
      rankOffset = p_to.getRank().getVal().getOrdinal() - p_from.getRank().getVal().getOrdinal();        
    
      rv = (fileOffset < 0) && (rankOffset < 0) && (fileOffset == rankOffset); 
    }
    
    return rv;
  }
  
  @Override
  public boolean tryWest(ISquare p_from, ISquare p_to)
  {
    boolean rv = false;
    
    if (p_from != null && p_to != null)
    {
      if (p_from.getRank().equals(p_to.getRank()))
      {
        if (p_to.getFile().getVal().getOrdinal() < p_from.getFile().getVal().getOrdinal())
        {
          rv = true;
        }
      }
    }
    
    return rv;
  }

  @Override
  public boolean tryNorthWest(ISquare p_from, ISquare p_to)
  {
    boolean rv = false;
    int fileOffset;
    int rankOffset;

    if (p_from != null && p_to != null)
    {
      fileOffset = p_to.getFile().getVal().getOrdinal() - p_from.getFile().getVal().getOrdinal();
      rankOffset = p_to.getRank().getVal().getOrdinal() - p_from.getRank().getVal().getOrdinal();        
    
      rv = (fileOffset < 0) && (rankOffset > 0) && (fileOffset == -1*rankOffset); 
    }
    
    return rv;
  }

  @Override
  public IFile decFile(IFile p_currFile) throws IndexOutOfBoundsException,
                                                IllegalArgumentException
  {
    IFile rv;
    int ifile = p_currFile.getVal().getOrdinal();
    
    if (p_currFile == null)
    {
      throw new IllegalArgumentException();
    }
    else
    {
      if (ifile > 0)
      {
        rv = m_ordinal2File[--ifile];       
      }
      else
      {
        throw new IndexOutOfBoundsException("Can't decrease a-file");
      }
    }
    
    return rv;
  }

  @Override
  public IRank decRank(IRank p_currRank) throws IndexOutOfBoundsException, 
                                                IllegalArgumentException
  {
    IRank rv;
    int irank = p_currRank.getVal().getOrdinal();
    
    if (p_currRank == null)
    {
      throw new IllegalArgumentException();
    }
    else
    {
      if (irank > 0)
      {
        rv = m_ordinal2Rank[--irank];       
      }
      else
      {
        throw new IndexOutOfBoundsException("Can't decrease first rank");
      }
    }
    
    return rv;
  }
  
  @Override
  public IFile incFile(IFile p_currFile) throws IndexOutOfBoundsException,
                                                IllegalArgumentException
  {
    IFile rv;
    int ifile = p_currFile.getVal().getOrdinal();
    
    if (p_currFile == null)
    {
      throw new IllegalArgumentException();  
    }
    else
    {
      if (ifile < 7)
      {
        rv = m_ordinal2File[++ifile];       
      }
      else
      {
        throw new IndexOutOfBoundsException("Can't increase h-file");
      }
    }
    
    return rv;
  }

  @Override
  public IRank incRank(IRank p_currRank) throws IndexOutOfBoundsException,
                                                IllegalArgumentException
  {
    IRank rv;
    int irank = p_currRank.getVal().getOrdinal();
    
    if (p_currRank == null)
    {
      throw new IllegalArgumentException();  
    }
    else
    {
      if (irank < 7)
      {
        rv = m_ordinal2Rank[++irank];       
      }
      else
      {
        throw new IndexOutOfBoundsException("Can't increase 8th rank");
      }
    }
    
    return rv;
  }
  
  private void createFiles()
  {
    int i;
    IFile.ChessboardFile[] tmpFiles = {IFile.ChessboardFile.FILEa,
                                       IFile.ChessboardFile.FILEb,
                                       IFile.ChessboardFile.FILEc,
                                       IFile.ChessboardFile.FILEd,
                                       IFile.ChessboardFile.FILEe,
                                       IFile.ChessboardFile.FILEf,
                                       IFile.ChessboardFile.FILEg,
                                       IFile.ChessboardFile.FILEh};
    File file;
    
    m_files = new EnumMap<>(IFile.ChessboardFile.class);
    m_ordinal2File = new IFile[tmpFiles.length];
    for (i=0; i<tmpFiles.length; i++)
    {
      file = new File(tmpFiles[i]);
      m_files.put(tmpFiles[i], file);
      m_ordinal2File[i] = file;
    }
  }
  
  private void createRanks()
  {
    int i;
    IRank.ChessboardRank[] tmpRanks = {IRank.ChessboardRank.RANK1,
                                       IRank.ChessboardRank.RANK2,
                                       IRank.ChessboardRank.RANK3,
                                       IRank.ChessboardRank.RANK4,
                                       IRank.ChessboardRank.RANK5,
                                       IRank.ChessboardRank.RANK6,
                                       IRank.ChessboardRank.RANK7,
                                       IRank.ChessboardRank.RANK8};
    Rank rank;
    
    m_ranks = new EnumMap<>(IRank.ChessboardRank.class);
    m_ordinal2Rank = new IRank[tmpRanks.length];
    for (i=0; i<tmpRanks.length; i++)
    {
      rank = new Rank(tmpRanks[i]);
      m_ranks.put(tmpRanks[i], rank);
      m_ordinal2Rank[i] = rank;
    }

  }
  
  private void createSquares()
  {    
    Square sq;
    m_squares = new ISquare[64];
   
    for (Rank r: m_ranks.values()) 
    {
      for (File f: m_files.values())
      {
        sq = new Square(f,r);
        sq.setOrdinal(calcIndex(r,f));
        m_squares[sq.getOrdinal()] = sq;
      }
    }            
  }
  
  private static int calcIndex(Rank p_rank, File p_file)
  {
    return  p_rank.getOrdinal()*8 + p_file.getOrdinal();    
  }

  final private class Square implements ISquare
  {
    private IFile m_file;
    private IRank m_rank;
    private IColor m_color;
    private int m_ordinal;
    
    public Square(IFile p_file, IRank p_rank)
    {
      m_file = p_file;
      m_rank = p_rank;
      if ((m_rank.getVal().equals(IRank.ChessboardRank.RANK1) ||
           m_rank.getVal().equals(IRank.ChessboardRank.RANK3) ||
           m_rank.getVal().equals(IRank.ChessboardRank.RANK5) ||
           m_rank.getVal().equals(IRank.ChessboardRank.RANK7)) &&
          (m_file.getVal().equals(IFile.ChessboardFile.FILEa) ||
           m_file.getVal().equals(IFile.ChessboardFile.FILEc) ||
           m_file.getVal().equals(IFile.ChessboardFile.FILEe) ||
           m_file.getVal().equals(IFile.ChessboardFile.FILEg))
          )
      {
        m_color = ChessColor.getInstance().getBlack();
      }
      else if((m_rank.getVal().equals(IRank.ChessboardRank.RANK2) ||
               m_rank.getVal().equals(IRank.ChessboardRank.RANK4) ||
               m_rank.getVal().equals(IRank.ChessboardRank.RANK6) ||
               m_rank.getVal().equals(IRank.ChessboardRank.RANK8)) &&
              (m_file.getVal().equals(IFile.ChessboardFile.FILEb) ||
               m_file.getVal().equals(IFile.ChessboardFile.FILEd) ||
               m_file.getVal().equals(IFile.ChessboardFile.FILEf) ||
               m_file.getVal().equals(IFile.ChessboardFile.FILEh))
          )
      {
        m_color = ChessColor.getInstance().getBlack();        
      }
      else
      {
        m_color = ChessColor.getInstance().getWhite();        
      }
    }

    @Override
    public IFile getFile()
    {
      return m_file;
    }

    @Override
    public IRank getRank() {
      return m_rank;
    }

    @Override
    public IColor getColor() {
      return m_color;
    }

    public int getOrdinal()
    {
      return m_ordinal;
    }
    
    public void setOrdinal(int p_ordinal)
    {
      m_ordinal = p_ordinal;
    }    
    
    @Override
    public boolean equals(Object obj)
    {
      boolean rv;      
      
      if (obj == this)
      {
        rv = true;
      }
      else if((obj == null) || (obj.getClass() != this.getClass()))
      {
        rv = false;
      }
      else
      {
        Square rhs = (Square)obj;
        rv = rhs.m_file.equals(m_file) && rhs.m_rank.equals(m_rank);
      }
      
      return rv;
    }
    
    @Override
    public int hashCode()
    {
      return m_ordinal;
    }
    
  }
  
  final private class File implements IFile
  {
    private ChessboardFile m_file;
    private int m_ordinal;
    
    public File(ChessboardFile p_file)
    {
      m_file = p_file;
      m_ordinal = p_file.getOrdinal();
    }
    
    @Override
    public ChessboardFile getVal()
    {
      return m_file;
    }
    
    public int getOrdinal()
    {
      return m_ordinal;
    }
    
    @Override
    public boolean equals(Object obj)
    {
      boolean rv;      
      
      if (obj == this)
      {
        rv = true;
      }
      else if((obj == null) || (obj.getClass() != this.getClass()))
      {
        rv = false;
      }
      else
      {
        rv = (((File)obj).m_file == this.m_file);
      }
      
      return rv;
    }
    
    @Override
    public int hashCode()
    {
      return m_ordinal;
    }
  }
    
  
  final private class Rank implements IRank
  {
    private ChessboardRank m_rank;
    private int m_ordinal;
    
    public Rank(ChessboardRank p_rank)
    {
      m_rank = p_rank;
      m_ordinal = p_rank.getOrdinal();
    }
    
    @Override
    public ChessboardRank getVal()
    {
      return m_rank;
    }
    public int getOrdinal()
    {
      return m_ordinal;
    }
    
   
    @Override
    public boolean equals(Object obj)
    {
      boolean rv;      
      
      if (obj == this)
      {
        rv = true;
      }
      else if((obj == null) || (obj.getClass() != this.getClass()))
      {
        rv = false;
      }
      else
      {
        rv = (((Rank)obj).m_rank == this.m_rank);
      }
      
      return rv;
    }
    
    @Override
    public int hashCode()
    {
      return m_ordinal;
    }
    
  }
  
}
