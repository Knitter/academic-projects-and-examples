package furyPackage.estados;

import furyPackage.Cobra;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class EstadoCobraEscondida extends EstadoCobra{

    public EstadoCobraEscondida(Cobra cobra) {
        super(cobra);
    }

    public void aparecer(long tempo) {
        getCobra().getSprite().setAnimacao(Cobra.ATACAR, false, tempo);
        getCobra().mudarEstado(EstadoCobra.APARECIDA);
    }

    public void desaparecer(long tempo) {
    }


}
