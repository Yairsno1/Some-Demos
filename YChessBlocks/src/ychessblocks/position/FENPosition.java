/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ychessblocks.position;

import ychessblocks.board.*;
import ychessblocks.piece.*;
import ychessblocks.notation.FENTranslator;
import ychessblocks.notation.NotationTranslator;

import java.util.*;

/**
 *
 * @author Yair
 */
public class FENPosition  extends PuzzlePosition
{
  public FENPosition()
  {
    super();
  }
  
  public void set(String p_fenString) throws IllegalKingException,
                                             IllegalPawnException,
                                             IllegalTurnException,
                                             IllegalArgumentException
  {
    final int FEN_FIELDS_NUM = 6;
    String[] fields;
    FENTranslator fen = null;
    
    if (p_fenString != null)
    {
      fields = p_fenString.split(" ");
      if (fields.length == FEN_FIELDS_NUM)
      {
        fen = NotationTranslator.getInstance().getFENTranslator();
        
      }
      else
      {
        throw new IllegalArgumentException("Illegal FEN string, must contain exactly 6 fields");
      }
    }
    else
    {
      throw new IllegalArgumentException("FEN string parameter can't be null");
    }
    
  }  
  
  private HashMap<String,IPiece> createPieceMap()
  {
    HashMap<String,IPiece> rv;
    IPieceBox pbox = PieceBox.getInstance();
    
    rv = new HashMap<>();
    
    rv.put("K",pbox.createWhiteKing());
    rv.put("k",pbox.createBlackKing());
    rv.put("Q",pbox.createWhiteQueen());
    rv.put("q",pbox.createBlackQueen());
    rv.put("R",pbox.createWhiteRook());
    rv.put("r",pbox.createBlackRook());
    rv.put("N",pbox.createWhiteKnight());
    rv.put("n",pbox.createBlackKnight());
    rv.put("B",pbox.createWhiteBishop());
    rv.put("b",pbox.createBlackBishop());
    rv.put("P",pbox.createWhitePawn());
    rv.put("p",pbox.createBlackPawn());
    
    return rv;
  }
  
  private ISquarePiece[] fetchPieces(String p_placementField) throws IllegalArgumentException
  {
    ISquarePiece[] rv;
    ArrayList<ISquarePiece> placement;
    String[] ranks;
    IBoard board = Board.getInstance();
    IRank r;
    int i;
    HashMap<String,IPiece> pieceMap = this.createPieceMap();
    
    placement = new ArrayList<>();
    
    ranks = p_placementField.split("/");
    if (ranks.length == 8)
    {
      r = board.getRank(IRank.ChessboardRank.RANK8);
      for (i=8; i>0; i++)
      {
        try
        {
        fetchRankPieces(ranks[i],r,pieceMap,placement);
        }
        catch (Exception excp)
        {
          throw excp;
        }
        if (r.getVal() != IRank.ChessboardRank.RANK1)
        {
          r = board.decRank(r);
        }
      }
    }
    else
    {
      throw new IllegalArgumentException("Placement field is not valid");
    }
     
    rv = new ISquarePiece[placement.size()];
   
    return placement.toArray(rv);    
  }
  
  private void fetchRankPieces(String p_rankStr,
                               IRank p_rank, 
                               HashMap<String,IPiece> p_pieceMap,
                               ArrayList<ISquarePiece> p_rankPlacement) throws IllegalArgumentException
  {
    int emptyCount;
    int i;
    IFile f;
    IBoard board = Board.getInstance();
    int k;
    IPiece p;
    
    f = board.getFile(IFile.ChessboardFile.FILEa);
    for (i=0; i<p_rankStr.length(); i++)
    {
      if (p_rankStr.charAt(i) != '8') //not empty rank
      {
        if (p_rankStr.charAt(i) >= '1' && p_rankStr.charAt(i) <= '7')
        {
          emptyCount = Integer.parseInt(String.valueOf(p_rankStr.charAt(i)));
          for (k=0; k<emptyCount; k++)
          {
            try
            {
              f = board.incFile(f);
            }
            catch (Exception excp)
            {
              throw new IllegalArgumentException("Placement field is not valid");
            }
          }
        }
        else
        {
          p = p_pieceMap.get(p_rankStr.substring(i,i+1));
          if (p != null)
          {
            p_rankPlacement.add(new SquarePiece(board.getSquare(f, p_rank),p));
            if (f.getVal() != IFile.ChessboardFile.FILEh)
            {
              f = board.incFile(f);
            }
          }
          else
          {
            throw new IllegalArgumentException("Placement field is not valid");
          }
        }
      }
    }
  }
  
}
