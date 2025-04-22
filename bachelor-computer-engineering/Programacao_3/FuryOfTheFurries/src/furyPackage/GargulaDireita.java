package furyPackage;

import jge2d.AnimacaoSprite;
import jge2d.Ponto;
import jge2d.Sprite;

/**
 * <p><b>Title:</b> Fury of the Tiny
 * <p><b>Description:</b> G�rgula Direita
 * <p><b>Copyright:</b> Copyright (c) 2005
 * <p><b>Company:</b> 4thFloor Corporation
 * @author S�rgio Lopes<br>Ruben Pedro
 * @version 5.0
 */
public final class GargulaDireita extends Gargula {

    private static final String PARADO = "parado";

    /**
     * @param capacidadeResistencia - Define a capacidade de resist�ncia de uma G�rgula Direita
     * @param cadencia - Frequ�ncia com que o tiro da g�rgula direita � disparado
     */
    public GargulaDireita(String nome, Ponto posicao, Nivel nivel, int capacidadeResistencia, int cadencia, long tempo) {
        super(nome, posicao, nivel, capacidadeResistencia, cadencia, new TiroGargulaDireito("tiro_" + nome, new Ponto(posicao.getX() + 16, posicao.getY() + 20), nivel, 50, nivel.getMapa().getWidth() + 100));
        setSprite(new Sprite(nome, this, posicao));
        getSprite().addSpriteColisionListener(this, "trataColisao");
        getSprite().adicionarAnimacao(PARADO, new AnimacaoSprite(nivel.getImagem("gargula"), new int[] {}, new int[] {2}, new int[] {}, 0, 1000, 0));
        getSprite().setAnimacao(PARADO, false, tempo);
        nivel.getMapa().addSprite(getSprite());
    }
}
