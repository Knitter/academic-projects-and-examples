package furyPackage;

import jge2d.AnimacaoSprite;
import jge2d.Ponto;
import jge2d.Sprite;
import jge2d.jogo.movimentos.MovimentoEvent;
import jge2d.jogo.movimentos.MovimentoListener;
import jge2d.jogo.movimentos.MovimentoSegmentoRectaUnidireccional;

/**
 * <p><b>Title:</b> Fury of the Tiny
 * <p><b>Description:</b> Explosão de um objecto
 * <p><b>Copyright:</b> Copyright (c) 2005
 * <p><b>Company:</b> 4thFloor Corporation
 * @author Sérgio Lopes<br>Ruben Pedro
 * @version 5.0
 */
public class Explosao extends ObjectoDoNivel implements MovimentoListener {

    private static final String PARADO = "explodir";

    /**
     * @param animacao - Animação da explosao 
     */
    public Explosao(String nome, Ponto posicao, Nivel nivel, long tempo, AnimacaoSprite animacao) {
        super(nome, posicao, nivel);
        setSprite(new Sprite(nome, this, new MovimentoSegmentoRectaUnidireccional(posicao, new Ponto(posicao.getX() + 1, posicao.getY()), 2, tempo)));
        getSprite().adicionarAnimacao(PARADO, animacao);
        getSprite().setAnimacao(PARADO, false, tempo);
        getSprite().getMovimento().addMovimentoListener(this);
        nivel.getMapa().addSprite(getSprite());

    }

    /**
     * Remove a explosão do nível quando esta acaba de explodir
     *
     * @param movimentoEvent MovimentoEvent
     */
    public void movimentoAcabou(MovimentoEvent movimentoEvent) {
        getNivel().getMapa().removeSprite(getSprite());
    }

}
