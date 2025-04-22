package furyPackage;

import jge2d.AnimacaoSprite;
import jge2d.Ponto;
import jge2d.Sprite;

/**
 * <p><b>Title:</b> Fury of the Tiny
 * <p><b>Description:</b> Plataforma M�vel Enganchavel
 * <p><b>Copyright:</b> Copyright (c) 2005
 * <p><b>Company:</b> 4thFloor Corporation
 * @author S�rgio Lopes<br>Ruben Pedro
 * @version 5.0
 */
public final class PlataformaMovelEnganchavel extends MovelEnganchavel {

    private static final String PARADO = "parado";

    public PlataformaMovelEnganchavel(String nome, Ponto posicao, Nivel nivel, double velocidade, double deslocamento, long tempo) {
        super(nome, posicao, nivel, velocidade, deslocamento);
        setSprite(new Sprite(nome, this, posicao));
        getSprite().adicionarAnimacao(PARADO, new AnimacaoSprite(nivel.getImagem("plataformaPorta"), new int[] {}, new int[] {1}, new int[] {}, 0, 1000, 0));
        getSprite().setAnimacao(PARADO, false, tempo);
        nivel.getMapa().addSprite(getSprite());
    }

}
