package furyPackage;

import jge2d.AnimacaoSprite;
import jge2d.Ponto;
import jge2d.Sprite;

/**
 * <p><b>Title:</b> Fury of the Tiny
 * <p><b>Description:</b> Plataforma Fixa Enganchavel
 * <p><b>Copyright:</b> Copyright (c) 2005
 * <p><b>Company:</b> 4thFloor Corporation
 * @author Sérgio Lopes<br>Ruben Pedro
 * @version 5.0
 */
public final class PlataformaFixaEnganchavel extends FixoEnganchavel {

    private static final String PARADO = "parado";

    public PlataformaFixaEnganchavel(String nome, Ponto posicao, Nivel nivel, long tempo) {
        super(nome, posicao, nivel);
        setSprite(new Sprite(nome, this, posicao));
        getSprite().adicionarAnimacao(PARADO, new AnimacaoSprite(nivel.getImagem("plataformaEnganchavel"), new int[] {} , new int[] {1}, new int[] {}, 0, 1000, 0));
        getSprite().setAnimacao(PARADO, false, tempo);
        nivel.getMapa().addSprite(getSprite());
    }
}
