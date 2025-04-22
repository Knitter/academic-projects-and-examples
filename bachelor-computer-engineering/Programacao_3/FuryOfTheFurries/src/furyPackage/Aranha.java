package furyPackage;

import jge2d.AnimacaoSprite;
import jge2d.Ponto;
import jge2d.Sprite;
import jge2d.jogo.movimentos.MovimentoVerticalBidireccional;

/**
 * <p><b>Title:</b> Fury of the Tiny
 * <p><b>Description:</b> Aranha
 * <p><b>Copyright:</b> Copyright (c) 2005
 * <p><b>Company:</b> 4thFloor Corporation
 * @author Sérgio Lopes<br>Ruben Pedro
 * @version 5.0
 */
public final class Aranha extends MovelResistente {

    private static final String MOVER = "mover";

    public Aranha(String nome, Ponto posicao, Nivel nivel, double velocidade, double deslocamento, int capacidadeResistencia, long tempo) {
        super(nome, posicao, nivel, velocidade, deslocamento, capacidadeResistencia);
        setSprite(new Sprite(nome, this));
        getSprite().addSpriteColisionListener(this, "trataColisao");
        getSprite().adicionarAnimacao(MOVER, new AnimacaoSprite(nivel.getImagem("aranha"), new int[] {}, new int[] {1,2}, new int[] {}, 0, 100, 0));
        getSprite().setAnimacao(MOVER, false, tempo);
        nivel.getMapa().addSprite(getSprite());
    }

    public void reiniciar(long tempo) {
        getSprite().setMovimento(new MovimentoVerticalBidireccional(getPosicao(), getDeslocamento(), getVelocidade(), tempo));
    }

}
