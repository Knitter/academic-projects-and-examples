package furyPackage;

import jge2d.AnimacaoSprite;
import jge2d.Ponto;
import jge2d.Sprite;
import jge2d.jogo.movimentos.MovimentoHorizontalBidireccional;

/**
 * <p><b>Title:</b> Fury of the Tiny
 * <p><b>Description:</b> Telef�rico
 * <p><b>Copyright:</b> Copyright (c) 2005
 * <p><b>Company:</b> 4thFloor Corporation
 * @author S�rgio Lopes<br>Ruben Pedro
 * @version 5.0
 */
public final class Teleferico extends MovelEnganchavel {

    private static final String PARADO = "parado";

    public Teleferico(String nome, Ponto posicao, Nivel nivel, double deslocamento, double velocidade, long tempo) {
        super(nome, posicao, nivel, velocidade, deslocamento);
        setSprite(new Sprite(nome, this, new MovimentoHorizontalBidireccional(posicao, deslocamento, velocidade, tempo)));
        getSprite().adicionarAnimacao(PARADO, new AnimacaoSprite(nivel.getImagem("teleferico"), new int[] {}, new int[] {1}, new int[] {}, 0, 1000, 0));
        getSprite().setAnimacao(PARADO, false, tempo);
        nivel.getMapa().addSprite(getSprite());
    }
}
