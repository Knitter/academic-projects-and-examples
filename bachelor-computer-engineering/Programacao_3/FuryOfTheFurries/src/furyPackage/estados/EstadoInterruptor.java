package furyPackage.estados;

import furyPackage.Interruptor;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public abstract class EstadoInterruptor {

    private Interruptor interruptor;

    public static final int DESLIGADO = 0;
    public static final int LIGADO = 1;

    public EstadoInterruptor(Interruptor interruptor) {
        this.interruptor = interruptor;
    }

    public abstract void ligar(long tempo);

    public Interruptor getInterruptor(){
        return interruptor;
    }

}
