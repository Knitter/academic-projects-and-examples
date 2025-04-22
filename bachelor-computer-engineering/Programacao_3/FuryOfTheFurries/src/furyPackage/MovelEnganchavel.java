package furyPackage;

import java.util.Hashtable;
import furyPackage.collisionPackage.Colidivel;
import furyPackage.collisionPackage.MovelEngancharCordaCima;
import furyPackage.collisionPackage.MovelEngancharCordaDireita;
import furyPackage.collisionPackage.MovelEngancharCordaEsquerda;
import furyPackage.collisionPackage.SuportavelRemoverCorda;
import jge2d.Ponto;
import jge2d.ResultadoColisao;

/**
 * <p><b>Title:</b> Fury of the Tiny
 * <p><b>Description:</b> Agrupa os objectos móveis que permiem à corda enganchar-de e oferecem suporte ao tiny
 * <p><b>Copyright:</b> Copyright (c) 2005
 * <p><b>Company:</b> 4thFloor Corporation
 * @author Sérgio Lopes<br>Ruben Pedro
 * @version 5.0
 */
public abstract class MovelEnganchavel extends ObjectoMovel implements Enganchavel, Plataforma {

    /**
     * Tiny ao qual estão a dar suporte
     */
    private Tiny heroi;

    private Hashtable tabelaColisoes = new Hashtable();

    public MovelEnganchavel() {
    }

    public MovelEnganchavel(String nome, Ponto posicao, Nivel nivel, double velocidade, double deslocamento) {
        super(nome, posicao, nivel, velocidade, deslocamento);

        SuportavelRemoverCorda removerCorda = new SuportavelRemoverCorda();
        tabelaColisoes.put(new Integer(ResultadoColisao.COLISAO_POR_DENTRO), removerCorda);
        tabelaColisoes.put(new Integer(ResultadoColisao.COLISAO_POR_BAIXO), removerCorda);
        tabelaColisoes.put(new Integer(ResultadoColisao.COLISAO_POR_DIREITA), new MovelEngancharCordaDireita());
        tabelaColisoes.put(new Integer(ResultadoColisao.COLISAO_POR_ESQUERDA), new MovelEngancharCordaEsquerda());
        tabelaColisoes.put(new Integer(ResultadoColisao.COLISAO_POR_CIMA), new MovelEngancharCordaCima());
    }

    /**
     * Suporta o Tiny
     */
    public void suportar(Tiny heroi, ResultadoColisao resultado) {
        heroi.getMovimentoActual().setPosicaoActual(resultado.resultadoObjecto1.pontoArraste, resultado.tempoColisao);
        heroi.getMovimentoActual().setPosicaoRelativa(getSprite().getMovimento(), resultado.tempoColisao);
        this.heroi = heroi;
    }

    /**
     * Deixa de suportar o Tiny
     */
    public void desSuportar(long tempo) {
        heroi.getMovimentoActual().setPosicaoRelativa(null, tempo);
        heroi = null;
    }

    /**
     * Trata a colisão com a corda
     */
    public void enganchar(Corda corda, ResultadoColisao resultado){
        ((Colidivel)tabelaColisoes.get(new Integer(resultado.resultadoObjecto2.tipoColisao))).trataColisao(resultado);
    }

    /**
     * Desengancha a corda
     */
    public void desenganchar(Corda corda, long tempo) {
        corda.getHeroi().getMovimentoActual().setPosicaoRelativa(null, tempo);
    }

    /**
     * Adiciona o Tiny aos iteráveis para que este não estoire com a restrição dos ângulos da corda
     */
    public void adicionarSuportadoAosIteraveis(Tiny heroi) {
        getNivel().adicionarIteravel(heroi);
    }



/////////////////////////// Getters & Setters //////////////////////////////////

    public Tiny getSuportado() {
        return heroi;
    }
}
