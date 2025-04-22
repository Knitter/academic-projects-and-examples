package furyPackage;

import java.util.Hashtable;
import furyPackage.collisionPackage.Colidivel;
import furyPackage.collisionPackage.EngancharCordaCima;
import furyPackage.collisionPackage.EngancharCordaDireita;
import furyPackage.collisionPackage.EngancharCordaEsquerda;
import furyPackage.collisionPackage.SuportavelRemoverCorda;
import jge2d.Ponto;
import jge2d.ResultadoColisao;

/**
 * <p><b>Title:</b> Fury of the Tiny
 * <p><b>Description:</b> Agrupa objectos fixos do nível que são engancháveis e suportáveis
 * <p><b>Copyright:</b> Copyright (c) 2005
 * <p><b>Company:</b> 4thFloor Corporation
 * @author Sérgio Lopes<br>Ruben Pedro
 * @version 5.0
 */
public abstract class FixoEnganchavel extends ObjectoDoNivel implements Enganchavel, Plataforma {

    private Tiny heroi;
    private Hashtable tabelaColisoes = new Hashtable();

    public FixoEnganchavel() {
    }

    public FixoEnganchavel(String nome, Ponto posicao, Nivel nivel) {
        super(nome, posicao, nivel);

        SuportavelRemoverCorda removerCorda = new SuportavelRemoverCorda();
        tabelaColisoes.put(new Integer(ResultadoColisao.COLISAO_POR_DENTRO), removerCorda);
        tabelaColisoes.put(new Integer(ResultadoColisao.COLISAO_POR_BAIXO), removerCorda);
        tabelaColisoes.put(new Integer(ResultadoColisao.COLISAO_POR_DIREITA), new EngancharCordaDireita());
        tabelaColisoes.put(new Integer(ResultadoColisao.COLISAO_POR_ESQUERDA), new EngancharCordaEsquerda());
        tabelaColisoes.put(new Integer(ResultadoColisao.COLISAO_POR_CIMA), new EngancharCordaCima());
    }

    /**
     * Suporta o Tiny
     */
    public void suportar(Tiny heroi, ResultadoColisao resultado) {
        this.heroi = heroi;
    }

    /**
     * Deixa de suportar o Tiny
     */
    public void desSuportar(long tempo) {
        heroi = null;
    }

    /**
     * Pede ao objecto enganchável para se enganchar
     */
    public void enganchar(Corda corda, ResultadoColisao resultado) {
        ((Colidivel)tabelaColisoes.get(new Integer(resultado.resultadoObjecto2.tipoColisao))).trataColisao(resultado);
        corda.getHeroi().getSprite().setMovimento(corda.getHeroi().getMovimentoActual());
        corda.getSprite().getMovimento().setPosicaoRelativa(null, resultado.tempoColisao);
    }

    public void desenganchar(Corda corda, long tempo) {
    }

    public void adicionarSuportadoAosIteraveis(Tiny heroi) {
    }



/////////////////////////// Getters & Setters //////////////////////////////////

    public Tiny getSuportado() {
        return heroi;
    }
}
