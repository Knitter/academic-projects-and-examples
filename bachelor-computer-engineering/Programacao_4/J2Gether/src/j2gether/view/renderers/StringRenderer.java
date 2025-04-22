package j2gether.view.renderers;

import java.awt.*;
import javax.swing.*;
import j2gether.config.Propriedades;

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
public class StringRenderer extends MyRenderer{

    public StringRenderer() {
        super();
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if(value != null)
            setText((String)value);
        else
            setText(Propriedades.SCORES_NO_NAME);
        return this;
    }

}
