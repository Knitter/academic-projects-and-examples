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
public class EstadoPlataformaDestrutivelMarteloComSuportado extends EstadoPlataformaDestrutivelMarteloSuportado{

    public EstadoPlataformaDestrutivelMarteloComSuportado(PlataformaDestrutivelMartelo plataforma) {
        super(plataforma);
    }

    public void desSuportar(long tempo) {
        getPlataforma().getSuportado().deixarDeEstarSuportado(tempo);
        getPlataforma().desSuportar(tempo);
    }

}
