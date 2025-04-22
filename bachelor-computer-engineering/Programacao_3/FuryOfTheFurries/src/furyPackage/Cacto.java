package furyPackage;

import jge2d.AnimacaoSprite;
import jge2d.Ponto;
import jge2d.ResultadoColisao;
import jge2d.Sprite;

/**
 * <p><b>Title:</b> Fury of the Tiny
 * <p><b>Description:</b> Cacto
 * <p><b>Copyright:</b> Copyright (c) 2005
 * <p><b>Company:</b> 4thFloor Corporation
 * @author Sérgio Lopes<br>Ruben Pedro
 * @version 5.0
 */
public final class Cacto extends FixoDestruidor {

    private static final String PARADO = "parado";

    public Cacto(String nome, Ponto posicao, Nivel nivel, long tempo) {
        super(nome, posicao, nivel);
        setSprite(new Sprite(nome, this, posicao));
        getSprite().addSpriteColisionListener(this, "trataColisao");
        getSprite().adicionarAnimacao(PARADO, new AnimacaoSprite(nivel.getImagem("cacto"), new int[] {}, new int[] {1}, new int[] {}, 0, 1000, 0));
        getSprite().setAnimacao(PARADO, false, tempo);
        nivel.getMapa().addSprite(getSprite());
    }

    /**
     * Trata a colisão com o Tiny.
     * Quando o Tiny colide com o cacto, morre.
     */
    public void trataColisao(Tiny heroi, ResultadoColisao resultado){
        heroi.morrer();
    }
}
