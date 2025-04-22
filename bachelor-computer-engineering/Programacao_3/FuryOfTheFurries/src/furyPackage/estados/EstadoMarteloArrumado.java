package furyPackage.estados;

import furyPackage.Martelo;
import jge2d.Ponto;
import jge2d.Sprite;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class EstadoMarteloArrumado extends EstadoMartelo {

    private static final String PARADO = "parado";

    public EstadoMarteloArrumado(Martelo martelo) {
        super(martelo);
    }

    /**
     * martelar
     *
     * @param tempo long
     */
    public void martelar(long tempo) {
        getMartelo().setSprite(new Sprite(getMartelo().getNome(), getMartelo(), new Ponto(getMartelo().getHabilidadeMartelo().getHeroi().getSprite().getUltimaPosicao().getX() + getMartelo().getOffset().getX(),
                                                                                          getMartelo().getHabilidadeMartelo().getHeroi().getSprite().getUltimaPosicao().getY() + getMartelo().getOffset().getY())));
        getMartelo().getSprite().adicionarAnimacao(PARADO,getMartelo().getAnimacaoMartelo());
        getMartelo().getSprite().adicionarAnimacao(PARADO, getMartelo().getAnimacaoMartelo());
        getMartelo().getSprite().addSpriteColisionListener(getMartelo(), "trataColisao");
        getMartelo().getSprite().setAnimacao(PARADO, false, tempo);
        getMartelo().getNivel().getMapa().addSprite(getMartelo().getSprite());

    }

}
