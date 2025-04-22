package furyPackage;

import furyPackage.estados.EstadoMartelo;
import furyPackage.estados.EstadoMarteloAMartelar;
import furyPackage.estados.EstadoMarteloArrumado;
import furyPackage.estados.HabilidadeMartelo;
import jge2d.AnimacaoSprite;
import jge2d.Ponto;
import jge2d.ResultadoColisao;

/**
 * <p><b>Title:</b> Fury of the Tiny
 * <p><b>Description:</b> Martelo
 * <p><b>Copyright:</b> Copyright (c) 2005
 * <p><b>Company:</b> 4thFloor Corporation
 * @author Sérgio Lopes<br>Ruben Pedro
 * @version 5.0
 */
public class Martelo extends ObjectoDoNivel implements Removivel, Iteravel {

    /**
    * Guarda o número de iterações que o martelo permanece visível no nível
    */
   private final int LIMITE_ITERACOES = 3;

   /**
    * Animação de um martelo
    */
   private AnimacaoSprite animacaoMartelo;

   /**
    * Estados possíveis de um martelo. Este pode estar arrumado ou a martelar
    */
   private EstadoMartelo[] estados = new EstadoMartelo[] {new EstadoMarteloArrumado(this), new EstadoMarteloAMartelar(this)};

   private HabilidadeMartelo habilidadeMartelo;

   /**
    * Número de iterações ocorridas desde que o martelo apareceu no nível
    */
    private int iteracaoActual;

    /**
     * Offset à posição do martelo
     */
    private Ponto offset;

    /**
     * Estado actual do martelo
     */
    private int estadoActual;

	private static final int ARRUMADO = 0;
   	private static final int DESARRUMADO = 1;

    public Martelo(String nome, Ponto posicao, Nivel nivel, AnimacaoSprite animacao, HabilidadeMartelo habilidadeMartelo, Ponto offset) {
        super(nome, posicao, nivel);
        this.habilidadeMartelo = habilidadeMartelo;
        this.offset = offset;
        animacaoMartelo = animacao;
     }

    /**
     * Reproduz um novo martelo
     */
    public Martelo(Martelo martelo, Ponto posicao) {
        this(martelo.getNome(), posicao, martelo.getNivel(), martelo.getAnimacao(), martelo.getHabilidadeMartelo(), martelo.getOffset());
    }

    /**
     * Incrementa o número de iterações actual
     */
    public void incrementarIteracaoActual() {
        iteracaoActual++;
    }

    /**
     * Manda o estado actual do martelo martelar
     */
    public void martelar(long tempo) {
        estados[estadoActual].martelar(tempo);
        estadoActual = Martelo.DESARRUMADO;
    }

    /**
     * Remove o martelo do nível
     */
    public void removerDoNivel() {
        getSprite().removeSpriteColisionListener(this, "trataColisao");
        getNivel().getMapa().removeSprite(getSprite());
        getNivel().removerIteraveis(this);
    }

    /**
     * Itera o martelo incrementando e verificando o número de iterações actuais, arruma-o e remove-o do nível quando este chega ao limite de iterações
     */
    public void iterar(long tempo) {
        incrementarIteracaoActual();
        getSprite().colocarEm(new Ponto(habilidadeMartelo.getHeroi().getSprite().getUltimaPosicao().getX() + offset.getX(), habilidadeMartelo.getHeroi().getSprite().getUltimaPosicao().getY() + offset.getY()), tempo);
        if (iteracaoActual > LIMITE_ITERACOES)
            getNivel().adicionarRemovivel(this);
            mudarEstado(Martelo.ARRUMADO);
    }

    /**
     * Muda o estado actual do martelo
     */
    private void mudarEstado(int estado) {
        estadoActual = estado;
    }

    /**
     * Dá uma martelada numa plataforma destrutivel pelo martelo
     */
    public void trataColisao(PlataformaDestrutivelMartelo plataforma, ResultadoColisao resultado) {
        plataforma.quebrar(resultado.tempoColisao);
        getSprite().removeSpriteColisionListener(this, "trataColisao");
    }



/////////////////////////// Getters & Setters //////////////////////////////////

    public AnimacaoSprite getAnimacao() {
        return animacaoMartelo;
    }

    public int getIteracaoActual() {
        return iteracaoActual;
    }

    public HabilidadeMartelo getHabilidadeMartelo() {
        return habilidadeMartelo;
    }

    public Ponto getOffset() {
        return offset;
    }

    public AnimacaoSprite getAnimacaoMartelo() {
        return animacaoMartelo;
    }
}
