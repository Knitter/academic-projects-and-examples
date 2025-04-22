package genx.gui.properties;

import javax.swing.*;

import com.borland.jbcl.layout.*;

/**
 * <p>Title: GenX</p>
 *
 * <p>Description: Aplicação que permite gerir árvores genealógicas</p>
 *
 * <p>Copyright: Copyright (c) 2005</p>
 *
 * <p>Company: 4thFloor</p>
 *
 * @author Sérgio Lopes, Ruben Pedro
 * @version 1.0
 */
public abstract class PropertiesInspector extends JPanel {

    private Object owner;

    public PropertiesInspector(Object owner) {
        this.owner = owner;
        setLayout(new VerticalFlowLayout());
    }

    public Object getOwner() {
        return owner;
    }

    public void setOwner(Object owner) {
        this.owner = owner;
    }

}
