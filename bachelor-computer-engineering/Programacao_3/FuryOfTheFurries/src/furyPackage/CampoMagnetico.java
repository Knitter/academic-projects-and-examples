package furyPackage;

import furyPackage.estados.EstadoCampoMagnetico;
import furyPackage.estados.EstadoCampoMagneticoComTiny;
import furyPackage.estados.EstadoCampoMagneticoSemTiny;
import furyPackage.estados.Habilidade;
import jge2d.Ponto;
import jge2d.ResultadoColisao;

/**
 * <p><b>Title:</b> Fury of the Tiny
 * <p><b>Description:</b> Agrupa os campos magn�ticos
 * <p><b>Copyright:</b> Copyright (c) 2005
 * <p><b>Company:</b> 4thFloor Corporation
 * @author S�rgio Lopes<br>Ruben Pedro
 * @version 5.0
 */public abstract class CampoMagnetico extends Activavel implements Iteravel, Removivel {

    /**
     * Habilidade que um campo magn�tico disponibiliza
     */
    private Habilidade habilidade;

    private Tiny heroi;

    /**
     * Estado actual do campo magn�tico
     * Este pode ter um Tiny ou n�o
     */
    private int estadoActual;

    /**
     * Estados poss�veis de um campo magn�tico
     */
    private EstadoCampoMagnetico[] estados = {new EstadoCampoMagneticoSemTiny(this), new EstadoCampoMagneticoComTiny(this)};

    /**
     * Lado do campo magn�tico por onde entra o Tiny
     */
    private int ladoDeEntrada;

    /**
     * Nenhum lado de entrada/sa�da
     */
    private static final int NENHUM = 0;

    public CampoMagnetico() {
    }

    /**
     * @param habilidade - Habilidade associada ao campo magn�tico
     */
    public CampoMagnetico(String nome, Ponto posicao, Nivel nivel, Habilidade habilidade) {
        super(nome, posicao, nivel);
        this.habilidade = habilidade;
    }

    /**
     * Muda o estado actual do campo magn�tico
     */
    public void mudarEstado(int novoEstado) {
        estadoActual = novoEstado;
    }

    /**
     * Pede � habilidade para alterar a sua disponibilidade
     */
    public void alterarDisponibilidade(Tiny heroi, long tempo){
        habilidade.alterarDisponibilidade();
    }

    /**
     * Activa o campo magn�tico
     */
    public void activar(Tiny heroi, ResultadoColisao resultado) {
        estados[estadoActual].activar(heroi, resultado);
        this.heroi = heroi;
    }

    /**
     * Verifica se o Tiny sai do campo magn�tico pelo lado oposto que entrou. Caso afirmativo altera a disponibilidade da respectiva habilidade
     */
    public void iterar(long tempo) {
       int ladoDeSaida = NENHUM;

       if (heroi.getSprite().getUltimaPosicao().getX() > getSprite().getUltimaPosicao().getX() + getSprite().getWidth())
           ladoDeSaida = ResultadoColisao.COLISAO_POR_DIREITA;
       else if (heroi.getSprite().getUltimaPosicao().getX() + heroi.getSprite().getWidth() < getSprite().getUltimaPosicao().getX())
           ladoDeSaida = ResultadoColisao.COLISAO_POR_ESQUERDA;

        if (ladoDeSaida != NENHUM) {
           estadoActual = EstadoCampoMagnetico.CAMPO_SEM_TINY;
           getNivel().adicionarRemovivel(this);
           if (ladoDeEntrada == ladoDeSaida)
               alterarDisponibilidade(heroi, tempo);
       }

    }

    /**
     * P�ra de ser iterado
     */
    public void removerDoNivel() {
        getNivel().removerIteraveis(this);
    }



/////////////////////////// Getters & Setters //////////////////////////////////

    public Habilidade getHabilidade() {
        return habilidade;
    }

    public void setLadoDeEntrada(int ladoDeEntrada) {
        this.ladoDeEntrada = ladoDeEntrada;
    }
}
