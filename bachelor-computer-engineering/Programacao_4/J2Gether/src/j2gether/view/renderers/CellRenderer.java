package j2gether.view.renderers;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import j2gether.model.Peca;
import j2gether.utilsp4.ImageLoader;


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
public class CellRenderer extends JLabel implements TableCellRenderer {

    public CellRenderer() {
    }

    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {

        if (((Peca) value).isIncolor())
            setIcon(ImageLoader.getLoader().getIcon("empty.gif"));
        else {
            if (((Peca) value).isCandidata())
                setIcon(ImageLoader.getLoader().getIcon("small" + value +
                        ".gif"));
            else
                setIcon(ImageLoader.getLoader().getIcon("ball" + value + ".gif"));
        }
        return this;
    }

}
