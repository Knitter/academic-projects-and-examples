package furyPackage;

import jge2d.AnimacaoSprite;
import jge2d.Ponto;
import jge2d.ResultadoColisao;
import jge2d.Sprite;

/**
 * <p><b>Title:</b> Fury of the Tiny
 * <p><b>Description:</b> Teleporte
 * <p><b>Copyright:</b> Copyright (c) 2005
 * <p><b>Company:</b> 4thFloor Corporation
 * @author Sérgio Lopes<br>Ruben Pedro
 * @version 5.0
 */
public final class Teleporte extends Activavel {

    /**
     * Ponto para onde será teleportado o Tiny
     */
    private Ponto destino;

    private static final String PARADO = "parado";

    public Teleporte(String nome, Ponto posicao, Nivel nivel, Ponto destino, long tempo) {
        super(nome, posicao, nivel);
        this.destino = destino;
        setSprite(new Sprite(nome, this, posicao));
        getSprite().adicionarAnimacao(PARADO, new AnimacaoSprite(nivel.getImagem("teleporte"), new int[] {}, new int[] {1, 2, 3, 4}, new int[] {}, 0, 100, 0));
        getSprite().setAnimacao(PARADO, false, tempo);
        nivel.getMapa().addSprite(getSprite());
    }

    /**
     * Coloca o tiny no ponto de destino
     */
    public void teleportar(Tiny heroi, long tempo) {
        heroi.getCorda().remover(tempo);
        heroi.getSprite().getMovimento().setPosicaoActual(destino, tempo);
        heroi.cair(tempo);
    }

    /**
     * Activa o teleporte
     */
    public void activar(Tiny heroi, ResultadoColisao resultado) {
        teleportar(heroi, resultado.tempoColisao);
    }



/////////////////////////// Getters & Setters //////////////////////////////////

    public Ponto getDestino() {
        return destino;
    }
}
