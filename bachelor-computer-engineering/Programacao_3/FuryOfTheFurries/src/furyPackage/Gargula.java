package furyPackage;

import jge2d.Ponto;

/**
 * <p><b>Title:</b> Fury of the Tiny
 * <p><b>Description:</b> G�rgula
 * <p><b>Copyright:</b> Copyright (c) 2005
 * <p><b>Company:</b> 4thFloor Corporation
 * @author S�rgio Lopes<br>Ruben Pedro
 * @version 5.0
 */
public class Gargula extends FixoResistente {
    /**
     * Tiro da g�rgula
     */
    private TiroGargula tiro;

    /**
     * Cad�ncia do tiro da g�rgula
     */
    private int cadencia;

    /**
     * Guarda o tempo do �ltimo tiro disparado
     */
    private long tempoLastFire;

    /**
     * @param capacidadeResistencia - Define a capacidade de resist�ncia de uma G�rgula
     * @param cadencia - Frequ�ncia com que o tiro da g�rgula � disparado
     * @param tiro - Tiro da g�rgula
     */
    public Gargula(String nome, Ponto posicao, Nivel nivel, int capacidadeResistencia, int cadencia, TiroGargula tiro) {
        super(nome, posicao, nivel, capacidadeResistencia);
        this.cadencia = cadencia;
        this.tiro = tiro;
    }

    /**
     * Lan�a um tiro de g�rgula
     */
    public void disparar(long tempo) {
        new TiroGargula(tiro).lancar(tempo);
   }

    /**
     * Itera a g�rgula disparando tiros consoante a sua cad�ncia
     */
    public void iterar(long tempo) {
        if (tempo - tempoLastFire >= cadencia) {
            tempoLastFire = tempo;
            disparar(tempo);
        }
    }



/////////////////////////// Getters & Setters //////////////////////////////////

    public int getCadencia() {
        return cadencia;
    }

    public TiroGargula getTiro() {
        return tiro;
    }
}
