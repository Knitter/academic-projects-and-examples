package furyPackage;

import jge2d.AnimacaoSprite;
import jge2d.Ponto;
import jge2d.Sprite;

/**
 * <p><b>Title:</b> Fury of the Tiny
 * <p><b>Description:</b> Gárgula Esquerda
 * <p><b>Copyright:</b> Copyright (c) 2005
 * <p><b>Company:</b> 4thFloor Corporation
 * @author Sérgio Lopes<br>Ruben Pedro
 * @version 5.0
 */
public final class GargulaEsquerda extends Gargula {

    private static final String PARADO = "parado";

    /**
     * @param capacidadeResistencia - Define a capacidade de resistência de uma Gárgula Esquerda
     * @param cadencia - Frequência com que o tiro da gárgula esquerda é disparado
     */
    public GargulaEsquerda(String nome, Ponto posicao, Nivel nivel, int capacidadeResistencia, int cadencia, long tempo) {
        super(nome, posicao, nivel, capacidadeResistencia, cadencia, new TiroGargulaEsquerdo("tiro_" + nome, new Ponto(posicao.getX(), posicao.getY() + 20), nivel, 50, nivel.getMapa().getWidth() - 100));
        setSprite(new Sprite(nome, this, posicao));
        getSprite().addSpriteColisionListener(this, "trataColisao");
        getSprite().adicionarAnimacao(PARADO, new AnimacaoSprite(nivel.getImagem("gargula"), new int[] {}, new int[] {1}, new int[] {}, 0, 1000, 0));
        getSprite().setAnimacao(PARADO, false, tempo);
        nivel.getMapa().addSprite(getSprite());
    }
}
