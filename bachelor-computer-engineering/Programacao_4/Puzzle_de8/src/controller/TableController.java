package controller;

import javax.swing.table.AbstractTableModel;
import model.Puzzle;

/**
 * <p>Title: Puzzle de 8</p>
 * <p>Description: Implementação do puzzle de 8 - ficha 2</p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: .none</p>
 * @author Knitter
 * @version 1.0
 */

public class TableController extends AbstractTableModel implements PuzzleListener{

  private Puzzle puzzle;

  public TableController(Puzzle puzzle) {
    this.puzzle = puzzle;
    puzzle.addPuzzleListener(this);
  }

  public void puzzleChanged() {
    fireTableDataChanged();
  }

  public int getRowCount() {
    return puzzle.getLinhas();
  }

  public int getColumnCount() {
    return puzzle.getColunas();
  }

  public Object getValueAt(int linha, int coluna) {
    return puzzle.getPecaEm(linha, coluna);
  }
}