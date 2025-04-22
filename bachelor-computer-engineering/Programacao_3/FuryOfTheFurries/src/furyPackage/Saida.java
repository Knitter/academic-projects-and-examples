package furyPackage;

import jge2d.AnimacaoSprite;
import jge2d.Ponto;
import jge2d.ResultadoColisao;
import jge2d.Sprite;

/**
 * <p><b>Title:</b> Fury of the Tiny
 * <p><b>Description:</b> Sa�da
 * <p><b>Copyright:</b> Copyright (c) 2005
 * <p><b>Company:</b> 4thFloor Corporation
 * @author S�rgio Lopes<br>Ruben Pedro
 * @version 5.0
 */
public final class Saida extends Activavel {

    private static final String PARADO = "parado";

    public Saida(String nome, Ponto posicao, Nivel nivel, long tempo) {
        super(nome, posicao, nivel);
        setSprite(new Sprite(nome, this, posicao));
        getSprite().adicionarAnimacao(PARADO, new AnimacaoSprite(nivel.getImagem("saida"), new int[] {}, new int[] {1}, new int[] {}, 0, 1000, 0));
        getSprite().setAnimacao(PARADO, false, tempo);
        nivel.getMapa().addSprite(getSprite());
    }

    /**
     * Pede ao n�vel para terminar
     */
    public void sair() {
        getNivel().terminarNivel();
    }

    /**
     * Sai de um n�vel
     */
    public void activar(Tiny heroi, ResultadoColisao resultado) {
        sair();
    }
}
