package controller;

import javax.swing.JLabel;
import javax.swing.table.TableCellRenderer;
import java.awt.Component;
import javax.swing.JTable;
import java.awt.Color;

/**
 * <p>Title: Puzzle de 8</p>
 * <p>Description: Implementação do puzzle de 8 - ficha 2</p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: .none</p>
 * @author Knitter
 * @version 1.0
 */

public class CellRenderer extends JLabel implements TableCellRenderer{

  public CellRenderer() {
    setBackground(Color.BLACK);
    setOpaque(true);
  }

  /**
   * Returns the component used for drawing the cell.
   *
   * @param table the <code>JTable</code> that is asking the renderer to
   *   draw; can be <code>null</code>
   * @param value the value of the cell to be rendered. It is up to the
   *   specific renderer to interpret and draw the value. For example, if
   *   <code>value</code> is the string "true", it could be rendered as a
   *   string or it could be rendered as a check box that is checked.
   *   <code>null</code> is a valid value
   * @param isSelected true if the cell is to be rendered with the
   *   selection highlighted; otherwise false
   * @param hasFocus if true, render cell appropriately. For example, put
   *   a special border on the cell, if the cell can be edited, render in
   *   the color used to indicate editing
   * @param row the row index of the cell being drawn. When drawing the
   *   header, the value of <code>row</code> is -1
   * @param column the column index of the cell being drawn
   * @return Component
   * @todo Implement this javax.swing.table.TableCellRenderer method
   */
  public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
    setIcon(ImageLoader.getLoader().getIcon(value != null ? "Peca" + value + ".JPG" : "PecaVazia.JPG"));
    return this;
  }
}