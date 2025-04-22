package furyPackage;

import jge2d.Ponto;

/**
 * <p><b>Title:</b> Fury of the Tiny
 * <p><b>Description:</b> Classe que agrupa todos os objectos com velocidade
 * <p><b>Copyright:</b> Copyright (c) 2005
 * <p><b>Company:</b> 4thFloor Corporation
 * @author Sérgio Lopes<br>Ruben Pedro
 * @version 5.0
 */
public abstract class ObjectoComVelocidade extends ObjectoDoNivel {

    /**
     * Velocidade do deslocamento do objecto
     */
    private double velocidade;

    public ObjectoComVelocidade() {
    }

    /**
     * @param velocidade - Velocidade do objecto
     */
    public ObjectoComVelocidade(String nome, Ponto posicao, Nivel nivel, double velocidade) {
        super(nome, posicao, nivel);
        this.velocidade = velocidade;
    }

    public double getVelocidade() {
        return velocidade;
    }

}
