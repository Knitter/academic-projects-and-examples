package j2gether.view.renderers;

import java.awt.*;
import javax.swing.*;
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
public class IntegerRenderer extends MyRenderer{

    public IntegerRenderer() {
        super();
        setHorizontalAlignment(JLabel.CENTER);
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        switch(((Integer)value).intValue()) {
        case 1:
            setIcon(ImageLoader.getLoader().getIcon("first.gif"));
            break;
        case 2:
            setIcon(ImageLoader.getLoader().getIcon("second.gif"));
            break;
        case 3:
            setIcon(ImageLoader.getLoader().getIcon("third.gif"));
            break;
        case 10:
            setIcon(ImageLoader.getLoader().getIcon("last.gif"));
            break;
        default:
            setIcon(ImageLoader.getLoader().getIcon("all.gif"));
        }
        return this;
    }
}
