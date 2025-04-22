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

public class EstadoInterruptorLigado extends EstadoInterruptor {

    public EstadoInterruptorLigado(Interruptor interruptor) {
        super(interruptor);
    }

    public void ligar(long tempo){
    }

}
