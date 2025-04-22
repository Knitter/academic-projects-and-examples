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

public class EstadoCobraAparecida extends EstadoCobra{

    public EstadoCobraAparecida(Cobra cobra) {
        super(cobra);
    }

    public void aparecer(long tempo) {
    }

    public void desaparecer(long tempo) {
        getCobra().getSprite().setAnimacao(Cobra.ESCONDER, true, tempo);
        getCobra().mudarEstado(EstadoCobra.ESCONDIDA);
    }

}
