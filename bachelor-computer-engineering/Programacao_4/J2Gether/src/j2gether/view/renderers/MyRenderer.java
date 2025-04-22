package j2gether.view.renderers;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;

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
public abstract class MyRenderer extends JLabel implements TableCellRenderer{

    public MyRenderer() {
        setOpaque(true);
    }
}
