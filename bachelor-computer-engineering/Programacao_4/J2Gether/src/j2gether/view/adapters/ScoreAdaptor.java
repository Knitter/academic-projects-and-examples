package j2gether.view.adapters;

import javax.swing.table.AbstractTableModel;
import j2gether.model.Score;
import j2gether.view.listeners.ScoreListener;

/**
 * <p>Title: J2Gether</p>
 *
 * <p>Description: Primeiro trabalho prático P4</p>
 *
 * <p>Copyright: Copyright (c) 2005</p>
 *
 * <p>Company: 4thFloor</p>
 *
 * @author Sérgio Lopes, Ruben Pedro
 * @version 1.0
 */
public class ScoreAdaptor extends AbstractTableModel implements ScoreListener{

    private Score score;

    public ScoreAdaptor(Score score) {
        this.score = score;
        this.score.addScoreListener(this);
    }

    /**
     * Returns the number of columns in the model.
     *
     * @return the number of columns in the model
     * @todo Implement this javax.swing.table.TableModel method
     */
    public int getColumnCount() {
        return 3;
    }

    /**
     * Returns the number of rows in the model.
     *
     * @return the number of rows in the model
     * @todo Implement this javax.swing.table.TableModel method
     */
    public int getRowCount() {
        return score.getSize();
    }

    /**
     * Returns the value for the cell at <code>columnIndex</code> and
     * <code>rowIndex</code>.
     *
     * @param rowIndex the row whose value is to be queried
     * @param columnIndex the column whose value is to be queried
     * @return the value Object at the specified cell
     * @todo Implement this javax.swing.table.TableModel method
     */
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == 0)
            return new Integer(rowIndex + 1);
         if (columnIndex == 1)
            return score.getScoreNameAt(rowIndex);
        if (columnIndex == 2)
            return new Double(score.getScoreValueAt(rowIndex));
         return null;

    }

    public void scoreChanged() {
        fireTableDataChanged();
    }

}
