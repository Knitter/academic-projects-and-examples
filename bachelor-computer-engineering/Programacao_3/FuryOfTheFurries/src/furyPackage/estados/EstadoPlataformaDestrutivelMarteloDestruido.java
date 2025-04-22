package furyPackage.estados;

import furyPackage.PlataformaDestrutivelMartelo;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class EstadoPlataformaDestrutivelMarteloDestruido extends EstadoPlatafomaDestrutivelMarteloVisual {

    public EstadoPlataformaDestrutivelMarteloDestruido(PlataformaDestrutivelMartelo plataforma) {
        super(plataforma);
    }

    /**
     * mudarImagem
     *
     * @param tempo long
     */
    public void quebrar(long tempo) {
        getPlataforma().getEstadoActual().desSuportar(tempo);
        getPlataforma().removerDoNivel();
    }

}
