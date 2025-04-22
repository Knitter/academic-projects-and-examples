package genx.gui.properties;

import javax.swing.*;

import com.borland.jbcl.layout.*;

/**
 * <p>Title: GenX</p>
 *
 * <p>Description: Aplica��o que permite gerir �rvores geneal�gicas</p>
 *
 * <p>Copyright: Copyright (c) 2005</p>
 *
 * <p>Company: 4thFloor</p>
 *
 * @author S�rgio Lopes, Ruben Pedro
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
