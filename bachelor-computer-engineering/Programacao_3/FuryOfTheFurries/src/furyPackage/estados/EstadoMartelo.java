package furyPackage.estados;

import furyPackage.Martelo;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public abstract class EstadoMartelo {

    private Martelo martelo;

    public EstadoMartelo(Martelo martelo) {
        this.martelo = martelo;
    }

    public Martelo  getMartelo() {
        return martelo;
    }

    public abstract void martelar(long tempo);

}
