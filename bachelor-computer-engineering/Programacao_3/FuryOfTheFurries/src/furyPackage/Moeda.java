package furyPackage;

import jge2d.AnimacaoSprite;
import jge2d.Ponto;
import jge2d.ResultadoColisao;
import jge2d.Sprite;

/**
 * <p><b>Title:</b> Fury of the Tiny
 * <p><b>Description:</b> Moeda
 * <p><b>Copyright:</b> Copyright (c) 2005
 * <p><b>Company:</b> 4thFloor Corporation
 * @author Sérgio Lopes<br>Ruben Pedro
 * @version 5.0
 */
public class Moeda extends Activavel implements Removivel {

    private static final String PARADO = "parado";

    public Moeda(String nome, Ponto posicao, Nivel nivel, long tempoActual) {
        super(nome, posicao, nivel);
        setSprite(new Sprite(nome, this, posicao));
        getSprite().adicionarAnimacao(PARADO, new AnimacaoSprite(nivel.getImagem("moeda"), new int[] {}, new int[] {1}, new int[] {}, 0, 1000, 0));
        getSprite().setAnimacao(PARADO, false, tempoActual);
        nivel.getMapa().addSprite(getSprite());
    }

    /**
     * Pede ao Tiny para apanhar a moeda e incrementar o seu número de moedas apanhadas 
     */
    public void activar(Tiny heroi, ResultadoColisao resultado) {
        heroi.incrementarMoedasApanhadas();
        removerDoNivel();
    }

    /**
     * Remove a moeda do nível
     */
    public void removerDoNivel(){
        getNivel().getMapa().removeSprite(getSprite());
    }
}
