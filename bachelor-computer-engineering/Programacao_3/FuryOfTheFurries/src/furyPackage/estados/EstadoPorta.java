package furyPackage.estados;

import furyPackage.Porta;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public abstract class EstadoPorta {

    /**
     * Estado da porta
     */
    public static final int FECHADA = 0;
    public static final int ABERTA = 1;

    private Porta porta;

    public EstadoPorta(Porta porta) {
        this.porta = porta;
    }

    public Porta getPorta(){
        return porta;
    }

    public abstract void abrir(long tempo);
}
