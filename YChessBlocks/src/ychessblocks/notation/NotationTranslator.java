/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ychessblocks.notation;


/**
 *
 * @author Yair
 */
public final class NotationTranslator 
{
  private static NotationTranslator m_instance = new NotationTranslator();
  private SANTranslator m_san;
  private FENTranslator m_fen;
  
  private NotationTranslator()
  {
    m_san = new SANTranslator();
    m_fen = new FENTranslator();
  }
  
  public static NotationTranslator getInstance()
  {
    return m_instance;
  }

  public FENTranslator getFENTranslator()
  {
    return m_fen;
  }
  
  public SANTranslator getStandradAlgebricNotationTranslator()
  {
    return m_san;
  }
}
