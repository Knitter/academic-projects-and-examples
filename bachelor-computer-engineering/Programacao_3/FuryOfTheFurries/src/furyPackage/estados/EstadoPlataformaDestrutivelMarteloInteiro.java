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

public class EstadoPlataformaDestrutivelMarteloInteiro extends EstadoPlatafomaDestrutivelMarteloVisual {

    public EstadoPlataformaDestrutivelMarteloInteiro(PlataformaDestrutivelMartelo plataforma) {
        super(plataforma);
    }

    /**
     * mudarImagem
     *
     * @param tempo long
     */
    public void quebrar(long tempo) {
        getPlataforma().getSprite().setAnimacao(EstadoPlatafomaDestrutivelMarteloVisual.INTEIRO, false, tempo);
    }

}
