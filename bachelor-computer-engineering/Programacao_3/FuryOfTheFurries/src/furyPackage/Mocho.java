package furyPackage;

import jge2d.AnimacaoSprite;
import jge2d.Ponto;
import jge2d.Sprite;

/**
 * <p><b>Title:</b> Fury of the Tiny
 * <p><b>Description:</b> Mocho
 * <p><b>Copyright:</b> Copyright (c) 2005
 * <p><b>Company:</b> 4thFloor Corporation
 * @author Sérgio Lopes<br>Ruben Pedro
 * @version 5.0
 */
public final class Mocho extends MovelDeslocamentoDuploResistente {

    private static final String MOVER = "mover";

    public Mocho(String nome, Ponto posicao, Nivel nivel, Ponto posicaoFinal, double velocidade, int capacidadeResistencia, long tempo) {
        super(nome, posicao, posicaoFinal, nivel, velocidade, posicaoFinal.getX(), capacidadeResistencia);
        setSprite(new Sprite(nome, this));
        getSprite().addSpriteColisionListener(this, "trataColisao");
        getSprite().adicionarAnimacao(MOVER, new AnimacaoSprite(nivel.getImagem("mocho"), new int[] {}, new int[] {1,2,3,4,5,4,3,2}, new int[] {}, 0, 75, 0));
        getSprite().setAnimacao(MOVER, false, tempo);
        nivel.getMapa().addSprite(getSprite());
    }

}
