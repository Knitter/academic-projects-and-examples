package j2gether.view.adapters;

import javax.swing.table.AbstractTableModel;
import j2gether.model.J2Gether;
import j2gether.view.listeners.J2GetherEvent;
import j2gether.view.listeners.J2GetherListener;


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
public class JTableAdapter extends AbstractTableModel implements J2GetherListener {

    private J2Gether jogo;

    public JTableAdapter(J2Gether jogo) {
        this.jogo = jogo;
        jogo.addJ2GetherListener(this);
    }

    public int getColumnCount() {
        return jogo.getWidth();
    }

    public int getRowCount() {
        return jogo.getHeight();
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        return jogo.getValueAt(rowIndex, columnIndex);
    }

    public void j2getherChanged(J2GetherEvent e) {
        fireTableDataChanged();
    }

}
