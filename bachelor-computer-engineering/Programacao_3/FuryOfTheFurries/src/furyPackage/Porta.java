package furyPackage;

import furyPackage.estados.EstadoPorta;
import furyPackage.estados.EstadoPortaAberta;
import furyPackage.estados.EstadoPortaFechada;
import jge2d.Ponto;
import jge2d.ResultadoColisao;

/**
 * <p><b>Title:</b> Fury of the Tiny
 * <p><b>Description:</b> Agrupa as diferentes portas existentes
 * <p><b>Copyright:</b> Copyright (c) 2005
 * <p><b>Company:</b> 4thFloor Corporation
 * @author Sérgio Lopes<br>Ruben Pedro
 * @version 5.0
 */
public abstract class Porta extends Activavel {
    /**
     * Plataformas constituíntes da porta
     */
    private PlataformaMovelEnganchavel[] plataformas;

    /**
     * Estados possíveis da porta (aberta ou fechada)
     */
    private EstadoPorta[] estados = {new EstadoPortaFechada(this), new EstadoPortaAberta(this)};

    /**
     * Estado actual da porta
     */
    private int estadoActual;

    /**
     * @param plataformas - Plataformas móveis engancháveis que constituem a porta
     */
    public Porta(String nome, Ponto posicao, Nivel nivel, PlataformaMovelEnganchavel[] plataformas) {
        super(nome, posicao, nivel);
        this.plataformas = plataformas;
        estadoActual = EstadoPorta.FECHADA;
    }

    /**
    * Activa a porta deslocando as respectivas plataformas móveis engancháveis
    */
    public void abrir(long tempo) {
        estados[estadoActual].abrir(tempo);
    }

    public void activar(Tiny heroi, ResultadoColisao resultadoA) {
    }

    /**
     * Muda o estado actual da porta
     *
     * @param novoEstado int
     */
    public void mudarEstadoActual(int novoEstado) {
        estadoActual = novoEstado;
    }

    public abstract void moverPlataformas(long tempo);



/////////////////////////// Getters & Setters //////////////////////////////////

    public int getNumeroDePlataformas() {
        return plataformas.length;
    }

    public PlataformaMovelEnganchavel getPlataforma(int index) {
        return plataformas[index];
    }
}
