package furyPackage;

import furyPackage.estados.EstadoInterruptor;
import furyPackage.estados.EstadoInterruptorDesligado;
import furyPackage.estados.EstadoInterruptorLigado;
import jge2d.AnimacaoSprite;
import jge2d.Ponto;
import jge2d.ResultadoColisao;
import jge2d.Sprite;

/**
 * <p><b>Title:</b> Fury of the Tiny
 * <p><b>Description:</b> Interruptor
 * <p><b>Copyright:</b> Copyright (c) 2005
 * <p><b>Company:</b> 4thFloor Corporation
 * @author Sérgio Lopes<br>Ruben Pedro
 * @version 5.0
 */
public final class Interruptor extends ActivavelComPorta {

    /**
    * Estado actual do interruptor
    */
   private int estadoActual;

    /**
    * Estados possíveis do interruptor
    */
    private EstadoInterruptor[] estados = {new EstadoInterruptorDesligado(this), new EstadoInterruptorLigado(this)};

    public static final String DESLIGADO_DIREITA = "desligadoDireita";
    public static final String LIGADO_DIREITA = "ligadoDireita";
    public static final String DESLIGADO_ESQUERDA = "desligadoEsquerda";
    public static final String LIGADO_ESQUERDA = "ligadoEsquerda";

    /**
     * @param porta - Porta associada ao interruptor 
     */
    public Interruptor(String nome, Ponto posicao,  Nivel nivel, Porta porta, long tempo) {
        super(nome, posicao, nivel, porta);
        estadoActual = EstadoInterruptor.DESLIGADO;
        setSprite(new Sprite(nome, this, posicao));
        getSprite().adicionarAnimacao(DESLIGADO_ESQUERDA, new AnimacaoSprite(nivel.getImagem("interruptor"), new int[] {}, new int[] {2}, new int[] {}, 0, 1000, 0));
        getSprite().adicionarAnimacao(LIGADO_ESQUERDA, new AnimacaoSprite(nivel.getImagem("interruptor"), new int[] {}, new int[] {1}, new int[] {}, 0, 1000, 0));
        getSprite().setAnimacao(DESLIGADO_ESQUERDA, false, tempo);
        nivel.getMapa().addSprite(getSprite());
    }

    /**
     * Activa o interruptor e abre a porta
     */
    public void ligar(long tempo) {
        estados[estadoActual].ligar(tempo);
    }

    /**
     * Muda o estado actual do Interruptor 
     */
    public void mudarEstadoActual(int estado){
        estadoActual = estado;
    }

    /**
     * Activa o interruptor, abrindo a respectiva porta 
     */
    public void activar(Tiny heroi, ResultadoColisao resultado) {
        ligar(resultado.tempoColisao);
    }

}
