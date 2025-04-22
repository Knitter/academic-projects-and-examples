package furyPackage;

import jge2d.Ponto;

/**
 * <p><b>Title:</b> Fury of the Tiny
 * <p><b>Description:</b> Gárgula
 * <p><b>Copyright:</b> Copyright (c) 2005
 * <p><b>Company:</b> 4thFloor Corporation
 * @author Sérgio Lopes<br>Ruben Pedro
 * @version 5.0
 */
public class Gargula extends FixoResistente {
    /**
     * Tiro da gárgula
     */
    private TiroGargula tiro;

    /**
     * Cadência do tiro da gárgula
     */
    private int cadencia;

    /**
     * Guarda o tempo do último tiro disparado
     */
    private long tempoLastFire;

    /**
     * @param capacidadeResistencia - Define a capacidade de resistência de uma Gárgula
     * @param cadencia - Frequência com que o tiro da gárgula é disparado
     * @param tiro - Tiro da gárgula
     */
    public Gargula(String nome, Ponto posicao, Nivel nivel, int capacidadeResistencia, int cadencia, TiroGargula tiro) {
        super(nome, posicao, nivel, capacidadeResistencia);
        this.cadencia = cadencia;
        this.tiro = tiro;
    }

    /**
     * Lança um tiro de gárgula
     */
    public void disparar(long tempo) {
        new TiroGargula(tiro).lancar(tempo);
   }

    /**
     * Itera a gárgula disparando tiros consoante a sua cadência
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
