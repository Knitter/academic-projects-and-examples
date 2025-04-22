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
public abstract class EstadoPlataformaDestrutivelMartelo {

    private PlataformaDestrutivelMartelo plataforma;

    public EstadoPlataformaDestrutivelMartelo(PlataformaDestrutivelMartelo plataforma) {
        this.plataforma = plataforma;
    }

    public PlataformaDestrutivelMartelo getPlataforma() {
        return plataforma;
    }
}
