/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ychessblocks.position;

import ychessblocks.board.*;
import ychessblocks.piece.*;
import ychessblocks.notation.*;
import java.util.*;

/**
 *
 * @author Yair
 */
public class Position implements IPosition
{ 
  private IBoard m_board;
  private IPieceBox m_pieceBox;
  private ChessColor m_colorFactory;
  private IColor m_activeColor;
  private HashMap<ISquare,IPiece> m_pieces;
  private boolean m_w00;
  private boolean m_w000;
  private boolean m_b00;
  private boolean m_b000;
  private ISquare m_enPassant;
  private IPromotionListener m_promotionListener;
  private int m_halfMoveClock;
  private HashMap<String,Integer> m_repetitionHistory;
  
  public Position()
  {
    m_board    = Board.getInstance();    
    m_pieceBox = PieceBox.getInstance();
    m_colorFactory = ChessColor.getInstance();
    
    m_promotionListener = null;
    m_pieces = new HashMap<>();
    m_repetitionHistory = new HashMap<>();
  }

  @Override
  public void clearPromotionListener()
  {
    m_promotionListener = null;
  }
  
  @Override
  public boolean isMate()
  {
    boolean rv = false;
    
    if (isCheck(this,m_activeColor))
    {
      rv = !isLegalMoveExsist();
    }
    
    return rv;
  }
   
  @Override
  public ISquare[] isSquareRayed(ISquare p_square, IColor p_attackingColor)
            throws IllegalArgumentException
  {
    ISquare[] rv;
    ArrayList<ISquare> attackingSquares;
    ISquare currSq;
    IPiece currP;
    //**********************
    //We temporary put piece on the attacked square
    //to mimic pawn raying.
    //Otherwise move like c2-c4 is seen like pawn attack.
    IPiece dummyPiece = null;
    
    if (p_square != null && p_attackingColor != null)
    {
      if (m_pieces.get(p_square) == null)
      {
        if (p_attackingColor.getColor().equals(IColor.ChessColor.WHITE))
        {
          dummyPiece = m_pieceBox.createBlackRook();
        }
        else
        {
          dummyPiece = m_pieceBox.createWhiteRook();
        }
        m_pieces.put(p_square, dummyPiece);
      }
      //**********************

      try
      {
        attackingSquares = new ArrayList<>();
        for (Map.Entry<ISquare,IPiece> sqp: m_pieces.entrySet())
        {
          currSq = sqp.getKey();
          currP = sqp.getValue();

          if (currP != null)
          {
            if (currP.getColor().equals(p_attackingColor))
            {
              if (currP.trySlide(currSq, p_square, this))
              {
                attackingSquares.add(currSq);
              }
            }
          }
        }
        rv = new ISquare[attackingSquares.size()];
        rv = attackingSquares.toArray(rv);
      }
      catch (Exception excp)
      {     
        rv = new ISquare[0];      
      }
      finally
      {
        if (dummyPiece != null)
        {
          m_pieces.remove(p_square);
        }
      }
    }
    else
    {
      throw new IllegalArgumentException();    
    }
    
    return rv;
  }  
 
  @Override
  public boolean isStalemate()
  {
    boolean rv = false;
    
    if (!isCheck(this,m_activeColor))
    {
      rv = !isLegalMoveExsist();
    }
    
    return rv;    
  }
  
  @Override
  public synchronized IPosition move(ISquare p_from, ISquare p_to) 
          throws IllegalMoveException, IllegalArgumentException 
  {
    IPosition rv = null;
    IPiece p;
    Position draft;
    
    if (p_from != null && p_to != null)
    {
      draft = (Position)makeClone();
      p = draft.getPiece(p_from);
      if (p == null)
      {
        throw new IllegalMoveException(IllegalMoveException.MoveFault.PIECE);
      }
      else if (!p.getColor().equals(m_activeColor))
      {
        throw new IllegalMoveException(IllegalMoveException.MoveFault.COLOR);
      }
      else if (p.trySlide(p_from, p_to, draft))
      {     
        IPiece tmpP = draft.checkPromotion(p,p_to);
        if (tmpP != null)
        {
          p = tmpP;
        }      
        draft.repositionPieces(p, p_from, p_to);

        if (isCheck(draft,draft.m_activeColor))
        {
          throw new IllegalMoveException(IllegalMoveException.MoveFault.CHECK);
        }
        else
        {
          draft.setFlags(p, p_from, p_to);
          draft.m_halfMoveClock = (getPiece(p_from).getKind() == IPiece.PieceKind.PAWN) || 
                                  (getPiece(p_to) != null) ? 0 : draft.m_halfMoveClock + 1;        
          draft.switchColor();        
          draft.addToRepetitionHistory();
          rv = draft;
        }
      }
      else
      {
        throw new IllegalMoveException(IllegalMoveException.MoveFault.PIECE);
      }
    }
    else
    {
      throw new IllegalArgumentException();  
    }
    
    return rv;
  }

  @Override
  public void set()
  {
    m_activeColor = m_colorFactory.getWhite();
    m_w00 = true;
    m_w000 = true;
    m_b00 = true;
    m_b000 = true;
    m_enPassant = null;
    m_halfMoveClock = 0;
    
    setRooks();
    setKnights();
    setBishops();
    setQueens();
    setKings();
    setPawns();
    
    m_repetitionHistory.put(this.generateRepetiotionId(), new Integer(1));
  }
  
  @Override
  public IColor getActiveColor()
  {
    return m_activeColor; 
  }
  
  @Override
  public ISquare getEnpassant()
  {
    return m_enPassant;
  }
  
  @Override
  public int getHalfMoveCount()
  {
    return m_halfMoveClock;  
  }
  
  @Override
  public IPiece getPiece(ISquare p_square)
  {
    return m_pieces.get(p_square);
  }
  
  @Override
  public boolean isWhite00()
  {
    return m_w00;
  }
  
  @Override
  public boolean isWhite000()
  {
    return m_w000;
  }
  
  @Override
  public boolean isBlack00()
  {
    return m_b00;
  }
  
  @Override
  public boolean isBlack000()
  {
    return m_b000;
  }
 
  @Override
  public boolean isThreefoldRepetition() 
  {
    String repetitionId = generateRepetiotionId();
    return (m_repetitionHistory.get(repetitionId).intValue() >= 3);
  }
  
  @Override
  public void setPromotionListener(IPromotionListener p_promotionListener)
  {
    if (p_promotionListener != null)
    {
      m_promotionListener = p_promotionListener;
    }
  }
  
  final protected void addToRepetitionHistory()
  {
    String repetitionId;
    int repetitionCount;
    
    repetitionId = generateRepetiotionId();
    repetitionCount = 1;
    if (m_repetitionHistory.containsKey(repetitionId))
    {
      repetitionCount = 1 + m_repetitionHistory.get(repetitionId).intValue();          
    }
    m_repetitionHistory.put(repetitionId, new Integer(repetitionCount));    
  }
  
  final protected void clear()
  {
    m_pieces.clear();
    m_repetitionHistory.clear();
  }
  
  final protected int countKings(IColor p_kingColor)
  {
    int rv = 0;
    IPiece p;
    
    for (Map.Entry<ISquare,IPiece> sqp: m_pieces.entrySet())
    {
      p = sqp.getValue();
      if (p.getKind() == IPiece.PieceKind.KING && 
          p.getColor().equals(p_kingColor))
      {
        ++rv;
      }
    }  
    
    return rv;
  }
  
  protected boolean isCheck(Position p_position, IColor p_kingColor)
  {
    ISquare kSq;
    IColor attackingColor;
    
    kSq = findKing(p_position, p_kingColor);
    attackingColor = p_kingColor.getColor().equals(IColor.ChessColor.WHITE) ? 
                        m_colorFactory.getBlack() : 
                        m_colorFactory.getWhite();
    
    ISquare[] rayingSquares = p_position.isSquareRayed(kSq, attackingColor);
    
    return rayingSquares.length > 0;
  }
  
  final protected void putPiece(ISquare p_square, IPiece p_piece)
  {
    if (p_piece == null)
    {
      m_pieces.remove(p_square);
    }
    else
    {
      m_pieces.put(p_square,p_piece);      
    }
  }
  
  protected IPosition makeClone()
  {
    Position rv = new Position();
    
    for (Map.Entry<ISquare,IPiece> sqp: m_pieces.entrySet())
    {
      rv.m_pieces.put(sqp.getKey(), sqp.getValue());
    }
    
    for (Map.Entry<String,Integer> rh:m_repetitionHistory.entrySet())
    {
      rv.m_repetitionHistory.put(rh.getKey(), rh.getValue());
    }
    
    rv.m_activeColor = this.m_activeColor;
    rv.m_w00  = this.m_w00;
    rv.m_w000 = this.m_w000;
    rv.m_b00  = this.m_b00;
    rv.m_b000 = this.m_b000;
    rv.m_enPassant = this.m_enPassant;
    rv.m_promotionListener = this.m_promotionListener;
    rv.m_halfMoveClock = this.m_halfMoveClock;
    
    return rv;
  }
  
  protected IPromotionListener.PromoteToPieceKind raisePromotionEvent()
  {
    IPromotionListener.PromoteToPieceKind rv = IPromotionListener.PromoteToPieceKind.QUEEN;      
    if (m_promotionListener != null)
    {
       rv = m_promotionListener.getPiece(new PromotionEvent(this,m_activeColor));
    }
    
    return rv;
  }
  
  final protected void setCastles(boolean p_w00,
                                  boolean p_w000,
                                  boolean p_b00,
                                  boolean p_b000)
  {
    m_w00  = p_w00;
    m_w000 = p_w000;
    m_b00  = p_b00;
    m_b000 = p_b000;
  }
  
  final protected void setColor(IColor p_activeColor)
  {
    m_activeColor = p_activeColor;  
  }
  
  final protected void setEnpassant(ISquare p_enPassant)
  {
    m_enPassant = p_enPassant;  
  }
  
  final protected void setHalfMoveClock(int p_halfMoveCount)
  {
    m_halfMoveClock = p_halfMoveCount;    
  }
  
  private IPiece checkPromotion(IPiece p_piece, ISquare p_to)
  {
    //Todo: raise event to pick piece to promote to.
    IPiece rv = null;    
    
    if (p_piece.getKind().equals(IPiece.PieceKind.PAWN))
    {
      if (p_to.getRank().getVal().equals(IRank.ChessboardRank.RANK1) ||
          p_to.getRank().getVal().equals(IRank.ChessboardRank.RANK8))
      {
        IPromotionListener.PromoteToPieceKind pieceKind = raisePromotionEvent();
        PromotionPieceBox box = new PromotionPieceBox();
        rv = box.createPiece(m_pieceBox, pieceKind, m_activeColor);
      }
    }
    
    return rv;
  }
  
  private ISquare findKing(Position p_position, IColor p_kingColor)
  {
    //Todo: consider kepping kings placement part of the object's state.
    ISquare rv = null;
    
    for (Map.Entry<ISquare,IPiece> sqp: p_position.m_pieces.entrySet())
    {
      IPiece p = sqp.getValue();
      if (p.getKind().equals(IPiece.PieceKind.KING) && 
          p.getColor().equals(p_kingColor))
      {
        rv = sqp.getKey();
        break;
      }
    }
    
    return rv;
  }

  private String generateRepetiotionId()
  {
    StringBuilder sb;
    //  First we represent the pieces location on the board
    //as strings array to insure order independently from
    //IBoard implementation. (a1.index=0 .. h8.index=63)
    String[] strBoard;
    int i;
    ISquare sq;
    IPiece p;
    //  Although the position string representation for threefold repetition 
    //is releated to the FEN format, it is not FEN!
    FENTranslator fen;
    
    fen = NotationTranslator.getInstance().getFENTranslator();
    sb = new StringBuilder();
    
    strBoard = new String[64];
    for (IRank.ChessboardRank cbr: IRank.ChessboardRank.values())
    {
      for (IFile.ChessboardFile cbf: IFile.ChessboardFile.values())
      {
        i = cbr.getOrdinal()*8 + cbf.getOrdinal();
        sq = m_board.getSquare(m_board.getFile(cbf), m_board.getRank(cbr));
        p = getPiece(sq);
        strBoard[i] = (p != null) ? fen.getPieceNotation(p) : "*";
      }
    }
    
    for (i=0; i<64; i++)
    {
      sb.append(strBoard[i]);      
    }
    sb.append(" "); //Space seperator      
    
    sb.append(fen.getActiveColorNotation(m_activeColor));
    sb.append(" ");
    
    sb.append(fen.getCastlingNotation(m_w00, m_w000, m_b00, m_b000));
    sb.append(" ");
    
    sb.append(fen.getSquareNotation(m_enPassant));

    return sb.toString();
  }

  private boolean isLegalMoveExsist()
  {
    boolean rv = false;
    ISquare currSq = null;
    IPiece currPiece;
    ISquare[] currPieceMoves = null;
    int i;
    IPosition draft;
    
    draft = this.makeClone();
    //  This is the only reason why to work on cloned position,
    //Position instance can't control the behavior of the listener
    //more than that listener usally will pop a dialog.
    //  The default promotion implementation(queen) is enough to test
    //if after a move the king is under a check.
    draft.clearPromotionListener();
    
    for (Map.Entry<ISquare,IPiece> sqp: m_pieces.entrySet())
    {
      currSq = sqp.getKey();
      currPiece = sqp.getValue();

      if (currPiece.getColor().equals(m_activeColor))
      {
        currPieceMoves = currPiece.generateSlides(currSq, this);
        for (i=0; i<currPieceMoves.length; i++)      
        {            
          try
          {
            //  We can create draft only once because Position::move() 
            //doesn't change the position status but works 
            //on copy of the position.
            draft.move(currSq,currPieceMoves[i]);
            rv = true;
            break;
          }
          catch (Exception excp) {/*Illegal move, check!*/}          
        }
        if (true == rv)
        {
          break;
        }
      }
    }
    
    return rv;
  }
  
  private void repositionPieces(IPiece p_piece, ISquare p_from, ISquare p_to)
  {
    ISquare e1 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEe),
                                   m_board.getRank(IRank.ChessboardRank.RANK1));
    ISquare g1 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEg),
                                   m_board.getRank(IRank.ChessboardRank.RANK1));
    ISquare h1 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEh),
                                   m_board.getRank(IRank.ChessboardRank.RANK1));
    ISquare f1 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEf),
                                   m_board.getRank(IRank.ChessboardRank.RANK1));    
    ISquare c1 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEc),
                                   m_board.getRank(IRank.ChessboardRank.RANK1));
    ISquare a1 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEa),
                                   m_board.getRank(IRank.ChessboardRank.RANK1));
    ISquare d1 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEd),
                                   m_board.getRank(IRank.ChessboardRank.RANK1));    
    ISquare e8 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEe),
                                   m_board.getRank(IRank.ChessboardRank.RANK8));
    ISquare g8 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEg),
                                   m_board.getRank(IRank.ChessboardRank.RANK8));
    ISquare h8 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEh),
                                   m_board.getRank(IRank.ChessboardRank.RANK8));
    ISquare f8 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEf),
                                   m_board.getRank(IRank.ChessboardRank.RANK8));    
    ISquare c8 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEc),
                                   m_board.getRank(IRank.ChessboardRank.RANK8));
    ISquare a8 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEa),
                                   m_board.getRank(IRank.ChessboardRank.RANK8));
    ISquare d8 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEd),
                                   m_board.getRank(IRank.ChessboardRank.RANK8));

    m_pieces.remove(p_from);
    m_pieces.remove(p_to);
    m_pieces.put(p_to, p_piece);

    if (p_piece.getKind() == IPiece.PieceKind.KING)
    {
      IPiece rook;
      if (p_piece.getColor().getColor() == IColor.ChessColor.WHITE)
      {
        if (p_from.equals(e1) && p_to.equals(g1))
        {
          rook = m_pieces.get(h1);
          m_pieces.put(f1, rook);
          m_pieces.remove(h1);
        }
        else if (p_from.equals(e1) && p_to.equals(c1))
        {
          rook = m_pieces.get(a1);
          m_pieces.put(d1, rook);
          m_pieces.remove(a1);
        }       
      }
      else  //black king
      {
        if (p_from.equals(e8) && p_to.equals(g8))
        {
          rook = m_pieces.get(h8);
          m_pieces.put(f8, rook);
          m_pieces.remove(h8);
        }
        else if (p_from.equals(e8) && p_to.equals(c8))
        {
          rook = m_pieces.get(a8);
          m_pieces.put(d8, rook);
          m_pieces.remove(a8);
        }              
      }
    }
    else if (p_piece.getKind() == IPiece.PieceKind.PAWN)
    {
      if (p_to.equals(m_enPassant))
      {
        ISquare actualPawnSquare;        
        if (p_piece.getColor().getColor() == IColor.ChessColor.WHITE)
        {
          actualPawnSquare = m_board.getSquare(p_to.getFile(),
                                               m_board.decRank(p_to.getRank()));         
        }
        else //balck pawn is capturing en passant
        {
          actualPawnSquare = m_board.getSquare(p_to.getFile(),
                                               m_board.incRank(p_to.getRank()));
        }
        m_pieces.remove(actualPawnSquare);
      }
    }
  }
  
  private void setFlags(IPiece p_piece, ISquare p_from, ISquare p_to)
  {
    ISquare h1 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEh),
                                   m_board.getRank(IRank.ChessboardRank.RANK1));
    ISquare a1 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEa),
                                   m_board.getRank(IRank.ChessboardRank.RANK1));
    ISquare h8 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEh),
                                   m_board.getRank(IRank.ChessboardRank.RANK8));
    ISquare a8 = m_board.getSquare(m_board.getFile(IFile.ChessboardFile.FILEa),
                                   m_board.getRank(IRank.ChessboardRank.RANK8));

    m_enPassant = null;   
    if (p_to.equals(h1))
    {
      m_w00 = false;
    }
    else if (p_to.equals(a1))
    {
      m_w000 = false;
    }
    else if (p_to.equals(h8))
    {
      m_b00 = false;
    }
    else if (p_to.equals(a8))
    {
      m_b000 = false;        
    }
    if (p_piece.getKind() == IPiece.PieceKind.KING)
    {
      if (p_piece.getColor().getColor() == IColor.ChessColor.WHITE)
      {
        m_w00 = false;
        m_w000 = false;
      }
      else  //black king
      {
        m_b00 = false;
        m_b000 = false;        
      }
    }
    else if (p_piece.getKind() == IPiece.PieceKind.ROOK)
    {
      if (p_piece.getColor().getColor() == IColor.ChessColor.WHITE)
      {
        if (p_from.equals(h1))
        {
          m_w00 = false;
        }
        else if (p_from.equals(a1))
        {
          m_w000 = false;
        }          
      }
      else  //black rook
      {
        if (p_from.equals(h8))
        {
          m_b00 = false;
        }
        else if (p_from.equals(a8))
        {
          m_b000 = false;
        }                 
      }
    }
    else if (p_piece.getKind() == IPiece.PieceKind.PAWN)
    {
      IRank epRank;
      if (p_piece.getColor().getColor() == IColor.ChessColor.WHITE)
      {
        if (p_from.getRank().getVal() == IRank.ChessboardRank.RANK2 && 
            p_to.getRank().getVal() == IRank.ChessboardRank.RANK4)
        {
          epRank = m_board.getRank(IRank.ChessboardRank.RANK3);
          m_enPassant = m_board.getSquare(p_from.getFile(),epRank);          
        }
      }
      else //black pawn
      {
        if (p_from.getRank().getVal() == IRank.ChessboardRank.RANK7 && 
            p_to.getRank().getVal() == IRank.ChessboardRank.RANK5)
        {
          epRank = m_board.getRank(IRank.ChessboardRank.RANK6);
          m_enPassant = m_board.getSquare(p_from.getFile(),epRank);          
        }        
      }
    }
  }
          
  private void setPawns()
  {
    IRank rankWhites = m_board.getRank(IRank.ChessboardRank.RANK2);
    IRank rankBlacks = m_board.getRank(IRank.ChessboardRank.RANK7);
    IPiece whitePawn = m_pieceBox.createWhitePawn();
    IPiece blackPawn = m_pieceBox.createBlackPawn();
    IFile f;
    
    for (IFile.ChessboardFile cbf: IFile.ChessboardFile.values())
    {
      f = m_board.getFile(cbf);
      m_pieces.put(m_board.getSquare(f,rankWhites),whitePawn);      
      m_pieces.put(m_board.getSquare(f,rankBlacks),blackPawn);      
    }    
  }
  
  private void setBishops()
  {
    IRank rankWhites = m_board.getRank(IRank.ChessboardRank.RANK1);
    IRank rankBlacks = m_board.getRank(IRank.ChessboardRank.RANK8);
    IPiece whiteBishop = m_pieceBox.createWhiteBishop();
    IPiece blackBishop = m_pieceBox.createBlackBishop();
    IFile cFile = m_board.getFile(IFile.ChessboardFile.FILEc);
    IFile fFile = m_board.getFile(IFile.ChessboardFile.FILEf);

     
    m_pieces.put(m_board.getSquare(cFile,rankWhites),whiteBishop);      
    m_pieces.put(m_board.getSquare(fFile,rankWhites),whiteBishop);      
    
    m_pieces.put(m_board.getSquare(cFile,rankBlacks),blackBishop);      
    m_pieces.put(m_board.getSquare(fFile,rankBlacks),blackBishop);      
  }

  private void setRooks()
  {
    IRank rankWhites = m_board.getRank(IRank.ChessboardRank.RANK1);
    IRank rankBlacks = m_board.getRank(IRank.ChessboardRank.RANK8);
    IPiece whiteRook = m_pieceBox.createWhiteRook();
    IPiece blackRook = m_pieceBox.createBlackRook();
    IFile aFile = m_board.getFile(IFile.ChessboardFile.FILEa);
    IFile hFile = m_board.getFile(IFile.ChessboardFile.FILEh);

     
    m_pieces.put(m_board.getSquare(aFile,rankWhites),whiteRook);      
    m_pieces.put(m_board.getSquare(hFile,rankWhites),whiteRook);      
    
    m_pieces.put(m_board.getSquare(aFile,rankBlacks),blackRook);      
    m_pieces.put(m_board.getSquare(hFile,rankBlacks),blackRook);      
  }

  private void setQueens()
  {
    IRank rankWhites = m_board.getRank(IRank.ChessboardRank.RANK1);
    IRank rankBlacks = m_board.getRank(IRank.ChessboardRank.RANK8);
    IPiece whiteQueen = m_pieceBox.createWhiteQueen();
    IPiece blackQueen = m_pieceBox.createBlackQueen();
    IFile dFile = m_board.getFile(IFile.ChessboardFile.FILEd);
     
    m_pieces.put(m_board.getSquare(dFile,rankWhites),whiteQueen);      
    
    m_pieces.put(m_board.getSquare(dFile,rankBlacks),blackQueen);      
  }

  private void setKings()
  {
    IRank rankWhites = m_board.getRank(IRank.ChessboardRank.RANK1);
    IRank rankBlacks = m_board.getRank(IRank.ChessboardRank.RANK8);
    IPiece whiteKing = m_pieceBox.createWhiteKing();
    IPiece blackKing = m_pieceBox.createBlackKing();
    IFile eFile = m_board.getFile(IFile.ChessboardFile.FILEe);
     
    m_pieces.put(m_board.getSquare(eFile,rankWhites),whiteKing);      
    
    m_pieces.put(m_board.getSquare(eFile,rankBlacks),blackKing);      
  }

  private void setKnights()
  {
    IRank rankWhites = m_board.getRank(IRank.ChessboardRank.RANK1);
    IRank rankBlacks = m_board.getRank(IRank.ChessboardRank.RANK8);
    IPiece whiteKnight = m_pieceBox.createWhiteKnight();
    IPiece blackKnight = m_pieceBox.createBlackKnight();
    IFile bFile = m_board.getFile(IFile.ChessboardFile.FILEb);
    IFile gFile = m_board.getFile(IFile.ChessboardFile.FILEg);

     
    m_pieces.put(m_board.getSquare(bFile,rankWhites),whiteKnight);      
    m_pieces.put(m_board.getSquare(gFile,rankWhites),whiteKnight);      
    
    m_pieces.put(m_board.getSquare(bFile,rankBlacks),blackKnight);      
    m_pieces.put(m_board.getSquare(gFile,rankBlacks),blackKnight);      
  }
  
  private void switchColor()
  {
    m_activeColor = m_activeColor.equals(m_colorFactory.getWhite()) ? 
                        m_colorFactory.getBlack() : 
                        m_colorFactory.getWhite();
  }

  private class PromotionPieceBox
  {    
    public PromotionPieceBox()
    {     
    }
    
    public IPiece createPiece(IPieceBox p_box,
                              IPromotionListener.PromoteToPieceKind p_promotionKind,
                              IColor p_color)
    {
      IPiece.PieceKind kind = IPiece.PieceKind.QUEEN;
      if (p_promotionKind == IPromotionListener.PromoteToPieceKind.QUEEN)
      {
        kind = IPiece.PieceKind.QUEEN;
      }
      else if (p_promotionKind == IPromotionListener.PromoteToPieceKind.ROOK)
      {
        kind = IPiece.PieceKind.ROOK;
      }
      else if (p_promotionKind == IPromotionListener.PromoteToPieceKind.BISHOP)
      {
        kind = IPiece.PieceKind.BISHOP;
      }
      else if (p_promotionKind == IPromotionListener.PromoteToPieceKind.KNIGHT)
      {
        kind = IPiece.PieceKind.KNIGHT;
      }
      
      return p_box.createPiece(kind, p_color);
    }
  }
}
