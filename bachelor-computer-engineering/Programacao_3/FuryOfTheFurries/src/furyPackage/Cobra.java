package furyPackage;

import furyPackage.estados.EstadoCobra;
import furyPackage.estados.EstadoCobraAparecida;
import furyPackage.estados.EstadoCobraEscondida;
import jge2d.AnimacaoSprite;
import jge2d.Ponto;
import jge2d.Sprite;


/**
 * <p><b>Title:</b> Fury of the Tiny
 * <p><b>Description:</b> Cobra
 * <p><b>Copyright:</b> Copyright (c) 2005
 * <p><b>Company:</b> 4thFloor Corporation
 * @author Sérgio Lopes<br>Ruben Pedro
 * @version 5.0
 */
public final class Cobra extends FixoResistente {
    /**
     * Distância de segurança da cobra
     */
    private double distanciaSeguranca;

    /**
     * Tiny
     */
    private Tiny comida;

    /**
     * Estados possíveis da cobra. Esta pode estar escondida ou aparecer para atacar o Tiny
     */
    private EstadoCobra[] estados = {new EstadoCobraEscondida(this), new EstadoCobraAparecida(this)};

    /**
     * Estado actual da cobra
     */
    private int estadoActual;

    public static final String ESCONDER = "esconder";
    public static final String ATACAR = "atacar";

    /**
     * @param capacidadeResistencia - Define a capacidade de resistência da cobra
     * @param distanciaSeguranca - Define o raio de acção da cobra
     */
    public Cobra(String nome, Ponto posicao, Nivel nivel, double distanciaSeguranca, int capacidadeResistencia, long tempo, Tiny heroi) {
        super(nome, posicao, nivel, capacidadeResistencia);
        this.distanciaSeguranca = distanciaSeguranca;
        comida = heroi;
        estadoActual = EstadoCobra.ESCONDIDA;
        setSprite(new Sprite(nome, this, posicao));
        getSprite().addSpriteColisionListener(this, "trataColisao");
        getSprite().adicionarAnimacao(ESCONDER, new AnimacaoSprite(nivel.getImagem("cobra"), new int[] {}, new int[] {7}, new int[] {}, 0, 1000, 0));
        getSprite().adicionarAnimacao(ATACAR, new AnimacaoSprite(nivel.getImagem("cobra"), new int[] {}, new int[] {7,6,5,4,3,2,1,1,1,2,3,4,5,6}, new int[] {4,5,6}, 0, 50, 50));
        getSprite().setAnimacao(ESCONDER, false, tempo);
        nivel.getMapa().addSprite(getSprite());
    }

    /**
     * Verifica invasões ao raio de segurança da cobra
     */
    private boolean violouDistanciaSeguranca() {
        if (Math.abs(comida.getSprite().getUltimaPosicao().getX() - getSprite().getUltimaPosicao().getX()) < distanciaSeguranca &&
            Math.abs(comida.getSprite().getUltimaPosicao().getY() - getSprite().getUltimaPosicao().getY()) < distanciaSeguranca)
            return true;
        return false;
    }

    /**
     * Itera a cobra verificando a distância de segurança para fazer com que esta apareça
     */
    public void iterar(long tempo) {
        if (violouDistanciaSeguranca())
            aparecer(tempo);
        else
            desaparecer(tempo);
    }

    /**
     * Faz a cobra atacar, aparecendo
     */
    private void aparecer(long tempo){
        estados[estadoActual].aparecer(tempo);
    }

    /**
     * Faz a cobra esconder-se
     */
    private void desaparecer(long tempo) {
        estados[estadoActual].desaparecer(tempo);
    }



/////////////////////////// Getters & Setters //////////////////////////////////

    public void mudarEstado(int novoEstado) {
        estadoActual = novoEstado;
    }

}
