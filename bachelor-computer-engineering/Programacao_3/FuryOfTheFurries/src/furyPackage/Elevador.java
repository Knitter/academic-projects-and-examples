package furyPackage;

import jge2d.AnimacaoSprite;
import jge2d.Ponto;
import jge2d.Sprite;
import jge2d.jogo.movimentos.MovimentoVerticalBidireccional;

/**
 * <p><b>Title:</b> Fury of the Tiny
 * <p><b>Description:</b> Elevador
 * <p><b>Copyright:</b> Copyright (c) 2005
 * <p><b>Company:</b> 4thFloor Corporation
 * @author Sérgio Lopes<br>Ruben Pedro
 * @version 5.0
 */
public final class Elevador extends MovelEnganchavel {

    private static final String PARADO = "parado";

    public Elevador(String nome, Ponto posicao, Nivel nivel, double deslocamento, double velocidade, long tempo) {
        super(nome, posicao, nivel, velocidade, deslocamento);
        setSprite(new Sprite(nome, this, new MovimentoVerticalBidireccional(posicao, deslocamento, velocidade, tempo)));
        getSprite().adicionarAnimacao(PARADO, new AnimacaoSprite(nivel.getImagem("elevador"), new int[] {}, new int[] {1}, new int[] {}, 0, 1000, 0));
        getSprite().setAnimacao(PARADO, false, tempo);
        nivel.getMapa().addSprite(getSprite());
    }

}
