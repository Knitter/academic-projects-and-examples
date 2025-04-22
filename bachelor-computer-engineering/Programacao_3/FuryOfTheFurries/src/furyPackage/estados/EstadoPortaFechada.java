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

public class EstadoPortaFechada extends EstadoPorta {

    public EstadoPortaFechada(Porta porta) {
        super(porta);
    }

    public void abrir(long tempo){
        getPorta().moverPlataformas(tempo);
        getPorta().mudarEstadoActual(EstadoPorta.ABERTA);
    }

}
