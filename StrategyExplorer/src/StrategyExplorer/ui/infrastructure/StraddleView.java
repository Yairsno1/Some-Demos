/*
 * StraddleView.java
 *
 * Created on 3 מרץ 2006, 18:19
 */

package StrategyExplorer.ui.infrastructure;

/**
 *
 * @author  Yair
 */

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import java.util.Vector;

import StrategyExplorer.CallOpt;
import StrategyExplorer.IOptionInf;
import StrategyExplorer.OptionPosition;
import StrategyExplorer.PutOpt;
import StrategyExplorer.Strategy;

public class StraddleView
{  
  private JPanel m_pnl;
  private double m_spread;
  private JTable m_tbl;
  private DefaultTableModel m_tblModel;
  private JFormattedTextField m_ftxtCost;
  private RangeSpinners m_rngRange;
  private Strategy m_strategy;
  
  /** Creates a new instance of StraddleView */
  public StraddleView(double p_from, double p_to, double p_spread) 
  {
    m_pnl = new JPanel();      
    m_pnl.setLayout(new BorderLayout());    
    createTable();
    createController();
    setRangeH(p_to);
    setRangeL(p_from);
    m_spread = p_spread;
    m_rngRange.setStep(m_spread);    
    buildRows();
    m_strategy = new Strategy();
  }
   
  public Strategy getStrategy()
  {
    int i;
    int sz = 0;
    double strike;
    IOptionInf call = null;
    IOptionInf put = null;
    long qty = 0;
    
    m_strategy.reset();
    sz = m_tblModel.getRowCount();
    for (i=0; i<sz; i++)
    {
      strike = ((Double)m_tblModel.getValueAt(i, 1)).doubleValue();    
      call = new CallOpt(strike);
      put = new PutOpt(strike);
      
      qty = ((Long)m_tblModel.getValueAt(i, 0)).longValue();
      if (qty != 0)
      {
        m_strategy.add(new OptionPosition(call,qty));
      }
      qty = ((Long)m_tblModel.getValueAt(i, 2)).longValue();
      if (qty != 0)
      {
        m_strategy.add(new OptionPosition(put,qty));
      }      
    }
    m_strategy.setCost((new Double(m_ftxtCost.getValue().toString())).doubleValue());
    return m_strategy;    
  }
    
  public JPanel getPanel()
  {
    return m_pnl;    
  }
  
  public void setPrefferdSize(Dimension p_size)
  {
    m_tbl.setPreferredScrollableViewportSize(p_size);        
  }
  
  private void createTable()
  {
    Vector tblHdr = null;
    TableColumn col = null;
    
    m_tblModel = new StraddleModel();
    tblHdr = new Vector();
    tblHdr.add(new String("Call"));
    tblHdr.add(new String("Strike"));
    tblHdr.add(new String("Put"));
    m_tblModel.setColumnIdentifiers(tblHdr);            
    m_tbl = new JTable(m_tblModel);    
    JScrollPane scrlPane = new JScrollPane(m_tbl);
    col = m_tbl.getColumnModel().getColumn(0);
    col.setCellEditor(new QtyEditor());
    col.setCellRenderer(new StraddleView.OptQtyCellRenderer());
    col = m_tbl.getColumnModel().getColumn(1);
    col.setCellRenderer(new StraddleView.OptStrikeCellRenderer());
    col = m_tbl.getColumnModel().getColumn(2);
    col.setCellEditor(new QtyEditor());
    col.setCellRenderer(new StraddleView.OptQtyCellRenderer());
    m_pnl.add(scrlPane,BorderLayout.CENTER);       
  }
  
  private void createController()
  {
    JPanel pnlCost = null;
    JPanel pnlRange = null;
    JPanel pnlCtrl;
    
    pnlCost = new JPanel();
    pnlCost.setLayout(new GridLayout(1,2));
    JLabel lblCost = new JLabel("Cost:");
    lblCost.setHorizontalAlignment(SwingConstants.RIGHT);
    pnlCost.add(lblCost);
    m_ftxtCost = (new Decimal2TextWraper()).getTextField();
    m_ftxtCost.setValue(new Double(0.0F));
    pnlCost.add(m_ftxtCost);
    m_pnl.add(pnlCost,BorderLayout.NORTH);       

    pnlCtrl = new JPanel();
    pnlCtrl.setLayout(new BorderLayout());    
 
   JButton btnClear = new JButton("Clear");
    btnClear.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent p_ae)
      {
        btnClearActionPerformed(p_ae);
      }
    });
    pnlCtrl.add(btnClear,BorderLayout.NORTH);
    
    pnlRange = new JPanel();
    pnlRange.setLayout(new BorderLayout());
    m_rngRange = new RangeSpinners(RangeSpinners.CTRL_ORIENTATION_VERT);
    m_rngRange.getLowLabel().setText("Strike Range From:");
    m_rngRange.getLowLabel().setHorizontalAlignment(SwingConstants.RIGHT);
    m_rngRange.getHighLabel().setText("To:");
    m_rngRange.getHighLabel().setHorizontalAlignment(SwingConstants.RIGHT);
    m_rngRange.getStepLabel().setHorizontalAlignment(SwingConstants.RIGHT);
    pnlRange.add(m_rngRange.getPanel(),BorderLayout.CENTER);    
    
   JButton btnRefresh = new JButton("Refresh");
    btnRefresh.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent p_ae)
      {
        btnRefreshActionPerformed(p_ae);
      }
    });
    pnlRange.add(btnRefresh,BorderLayout.SOUTH);
    pnlCtrl.add(pnlRange,BorderLayout.CENTER);
    
    m_pnl.add(pnlCtrl,BorderLayout.SOUTH);           
  }
  
  private void buildRows()
  {
    long rows = 0;
    long i = 0;
    double strike = 0;
    
    m_spread = m_rngRange.getStep();
    rows = 1+ Math.round(((m_rngRange.getHigh() - m_rngRange.getLow()) / m_spread));
    m_tblModel.setRowCount((int)rows);
    strike = m_rngRange.getLow();
    for (i=0; i<rows; i++)
    {
      m_tblModel.setValueAt(new Double(strike), (int)i, 1);      
      strike += m_spread;
    }
   clear();
  }
  
  private void clear()
  {
    long rows = 0;
    long i = 0;

    rows = m_tblModel.getRowCount();
    for (i=0; i<rows; i++)
    {
      m_tblModel.setValueAt(new Long(0), (int)i, 0);      
      m_tblModel.setValueAt(new Long(0), (int)i, 2);      
    }
    m_ftxtCost.setValue(new Double(0.0F));
  }
  
  private void setRangeL(double p_val)
  {
    m_rngRange.setLow(p_val);
  }

  private void setRangeH(double p_val)
  {
    m_rngRange.setHigh(p_val);
  }
  
  //------------------------------------------------------------
  //-------------- Event Handlers ---------------------------
  public void btnRefreshActionPerformed(ActionEvent p_ae)
  {  
    buildRows();
  }

  public void btnClearActionPerformed(ActionEvent p_ae)
  {
    clear();    
  }
  
  //------------------------------------------------------------
  //------------------ Inner Classes -------------------------
  private class StraddleModel extends DefaultTableModel
  {
    public StraddleModel()
    {
      super();    
    }
    
    public boolean isCellEditable(int p_row ,int p_column)
    {
      return (p_column != 1);  
    }
    
  }
  
  private class QtyEditor extends AbstractCellEditor implements TableCellEditor
  {
    final RedGreenSpinner m_spnQty;
    
    public QtyEditor()
    {
      m_spnQty = new RedGreenSpinner();    
    }
    
      public Object getCellEditorValue()
      {
        return m_spnQty.getValue();    
      }
      
      public Component getTableCellEditorComponent(JTable table,
                                                                        Object value,
                                                                        boolean isSelected,
                                                                        int row,
                                                                        int column)
      {
        m_spnQty.setValue(value);
        return m_spnQty;          
      }
      
  }

  public class OptQtyCellRenderer extends RedGreenSpinner implements TableCellRenderer 
  {
      
    public Component getTableCellRendererComponent(JTable p_tbl, 
                                                                           Object p_val,
                                                                           boolean p_isSelected,
                                                                           boolean p_hasFocus,
                                                                           int p_row, int p_col)
    {
      setValue(p_val);    
      return this;
    }
      
  }

  public class OptStrikeCellRenderer extends DefaultTableCellRenderer 
  {
      
    public Component getTableCellRendererComponent(JTable p_tbl, 
                                                                           Object p_val,
                                                                           boolean p_isSelected,
                                                                           boolean p_hasFocus,
                                                                           int p_row, int p_col)
    {
      setValue(p_val);      
      setHorizontalAlignment(CENTER);
      return this;
    }
      
  }

  
}
