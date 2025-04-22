package furyPackage.estados;

import furyPackage.Cobra;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public abstract class EstadoCobra {

    public static final int ESCONDIDA = 0;
    public static final int APARECIDA = 1;

    private Cobra cobra;

    public EstadoCobra(Cobra cobra) {
        this.cobra = cobra;
    }

    public Cobra getCobra() {
        return cobra;
    }

    public abstract void aparecer(long tempo);
    public abstract void desaparecer(long tempo);

}
