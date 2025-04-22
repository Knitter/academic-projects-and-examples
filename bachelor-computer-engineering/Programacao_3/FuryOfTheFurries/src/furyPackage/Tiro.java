package furyPackage;

import jge2d.AnimacaoSprite;
import jge2d.Ponto;
import jge2d.ResultadoColisao;
import jge2d.Sprite;
import jge2d.jogo.movimentos.MovimentoHorizontalUnidireccional;

/**
 * <p><b>Title:</b> Fury of the Tiny
 * <p><b>Description:</b> Agrupa todos os tiros existentes no jogo
 * <p><b>Copyright:</b> Copyright (c) 2005
 * <p><b>Company:</b> 4thFloor Corporation
 * @author Sérgio Lopes<br>Ruben Pedro
 * @version 5.0
 */
public class Tiro extends ObjectoMovel implements Removivel {

    private static final String PARADO = "parado";

    /**
     * Nome da animação do tiro
     */
    private AnimacaoSprite animacao;

    public Tiro(String nome, Ponto posicao, Nivel nivel, double velocidade, double deslocamento, AnimacaoSprite animacao) {
        super(nome, posicao, nivel, velocidade, deslocamento);
        this.animacao = animacao;
    }

    public Tiro(Tiro tiro, Ponto posicao) {
        this(tiro.getNome(), posicao, tiro.getNivel(), tiro.getVelocidade(), tiro.getDeslocamento(), tiro.getAnimacao());
    }

    /**
     * Remove um tiro do nível
     */
    public void removerDoNivel() {
        getSprite().removeSpriteColisionListener(this, "trataColisao");
        getNivel().getMapa().removeSprite(getSprite());
        getNivel().removerTiro(this);
    }

    /**
     * Manda remover o tiro do nível
     */
    public void explodir(long tempo) {
        removerDoNivel();
    }

    /**
     * Lança um novo tiro
     */
    public void lancar(long tempo){
        setSprite(new Sprite(getNome(), this, new MovimentoHorizontalUnidireccional(getPosicao(), getDeslocamento(), getVelocidade(), tempo)));
        getSprite().addSpriteColisionListener(this, "trataColisao");
        getSprite().adicionarAnimacao(PARADO, animacao);
        getSprite().setAnimacao(PARADO, false, tempo);
        getNivel().getMapa().addSprite(getSprite());
        getNivel().adicionarTiro(this);
    }

    /**
     * Trata a colisão com um objecto activável
     */
    public void trataColisao(Activavel activavel, ResultadoColisao resultado ){
        explodir(resultado.tempoColisao);
    }

    /**
     * Trata a colisão com um objecto de suporte
     */
    public void trataColisao(Suportavel plataforma, ResultadoColisao resultado){
        explodir(resultado.tempoColisao);
    }



/////////////////////////// Getters & Setters //////////////////////////////////

    public AnimacaoSprite getAnimacao() {
        return animacao;
    }

}
