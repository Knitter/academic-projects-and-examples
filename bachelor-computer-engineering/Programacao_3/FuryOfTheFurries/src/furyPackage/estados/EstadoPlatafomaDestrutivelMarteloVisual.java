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

public abstract class EstadoPlatafomaDestrutivelMarteloVisual extends EstadoPlataformaDestrutivelMartelo {

    public static final String INTEIRO = "inteiro";
    public static final String AMASSADO = "amassado";
    public static final String EM_CACOS = "emCacos";

    public EstadoPlatafomaDestrutivelMarteloVisual(PlataformaDestrutivelMartelo plataforma) {
        super(plataforma);
    }

    public abstract void quebrar(long tempo);

}
