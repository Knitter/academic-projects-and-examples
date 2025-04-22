package furyPackage;

import furyPackage.estados.EstadoCampoMagnetico;
import furyPackage.estados.EstadoCampoMagneticoComTiny;
import furyPackage.estados.EstadoCampoMagneticoSemTiny;
import furyPackage.estados.Habilidade;
import jge2d.Ponto;
import jge2d.ResultadoColisao;

/**
 * <p><b>Title:</b> Fury of the Tiny
 * <p><b>Description:</b> Agrupa os campos magnéticos
 * <p><b>Copyright:</b> Copyright (c) 2005
 * <p><b>Company:</b> 4thFloor Corporation
 * @author Sérgio Lopes<br>Ruben Pedro
 * @version 5.0
 */public abstract class CampoMagnetico extends Activavel implements Iteravel, Removivel {

    /**
     * Habilidade que um campo magnético disponibiliza
     */
    private Habilidade habilidade;

    private Tiny heroi;

    /**
     * Estado actual do campo magnético
     * Este pode ter um Tiny ou não
     */
    private int estadoActual;

    /**
     * Estados possíveis de um campo magnético
     */
    private EstadoCampoMagnetico[] estados = {new EstadoCampoMagneticoSemTiny(this), new EstadoCampoMagneticoComTiny(this)};

    /**
     * Lado do campo magnético por onde entra o Tiny
     */
    private int ladoDeEntrada;

    /**
     * Nenhum lado de entrada/saída
     */
    private static final int NENHUM = 0;

    public CampoMagnetico() {
    }

    /**
     * @param habilidade - Habilidade associada ao campo magnético
     */
    public CampoMagnetico(String nome, Ponto posicao, Nivel nivel, Habilidade habilidade) {
        super(nome, posicao, nivel);
        this.habilidade = habilidade;
    }

    /**
     * Muda o estado actual do campo magnético
     */
    public void mudarEstado(int novoEstado) {
        estadoActual = novoEstado;
    }

    /**
     * Pede à habilidade para alterar a sua disponibilidade
     */
    public void alterarDisponibilidade(Tiny heroi, long tempo){
        habilidade.alterarDisponibilidade();
    }

    /**
     * Activa o campo magnético
     */
    public void activar(Tiny heroi, ResultadoColisao resultado) {
        estados[estadoActual].activar(heroi, resultado);
        this.heroi = heroi;
    }

    /**
     * Verifica se o Tiny sai do campo magnético pelo lado oposto que entrou. Caso afirmativo altera a disponibilidade da respectiva habilidade
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
     * Pára de ser iterado
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
