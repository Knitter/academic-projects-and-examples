package furyPackage;

import furyPackage.estados.Habilidade;
import jge2d.AnimacaoSprite;
import jge2d.Ponto;
import jge2d.Sprite;

/**
 * <p><b>Title:</b> Fury of the Tiny
 * <p><b>Description:</b> Campo Magnético Amarelo
 * <p><b>Copyright:</b> Copyright (c) 2005
 * <p><b>Company:</b> 4thFloor Corporation
 * @author Sérgio Lopes<br>Ruben Pedro
 * @version 5.0
 */
public final class CampoMagneticoAmarelo extends CampoMagnetico {

    private static final String PARADO = "parado";

    public CampoMagneticoAmarelo(String nome, Ponto posicao, Nivel nivel, long tempo, Habilidade habilidade) {
        super(nome, posicao, nivel, habilidade);
        setSprite(new Sprite(nome, this, posicao));
        getSprite().adicionarAnimacao(PARADO, new AnimacaoSprite(nivel.getImagem("campoMagnetico"), new int[] {}, new int[] {3,4}, new int[] {}, 0, 500, 0));
        getSprite().setAnimacao(PARADO, false, tempo);
        nivel.getMapa().addSprite(getSprite());
    }

    /**
     * Pede à habilidade para alterar a sua disponibilidade e remove a habilidade actual do Tiny se corresponder à mesma
     */
    public void alterarDisponibilidade(Tiny heroi, long tempo) {
        super.alterarDisponibilidade(heroi, tempo);
        heroi.corrigirHabilidadeActual(Habilidade.FOGO, tempo);
    }

}
