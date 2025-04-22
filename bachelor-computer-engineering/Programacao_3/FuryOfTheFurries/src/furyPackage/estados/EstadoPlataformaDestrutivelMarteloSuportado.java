package furyPackage.estados;

import furyPackage.PlataformaDestrutivelMartelo;

/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2005</p>
 *
 * <p>Company: </p>
 *
 * @author not attributable
 * @version 1.0
 */
public abstract class EstadoPlataformaDestrutivelMarteloSuportado extends EstadoPlataformaDestrutivelMartelo {

    public static final int SEM_SUPORTADO = 0;
    public static final int COM_SUPORTADO = 1;

    public EstadoPlataformaDestrutivelMarteloSuportado(PlataformaDestrutivelMartelo plataforma) {
        super(plataforma);
    }

    public abstract void desSuportar(long tempo);
}
