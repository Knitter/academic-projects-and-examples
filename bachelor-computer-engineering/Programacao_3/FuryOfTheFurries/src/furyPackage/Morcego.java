package furyPackage;

import java.util.Hashtable;
import furyPackage.collisionPackage.Colidivel;
import furyPackage.collisionPackage.ColisaoDefault;
import furyPackage.collisionPackage.DestruidorRemoverCorda;
import furyPackage.collisionPackage.MovelEngancharCordaCima;
import jge2d.AnimacaoSprite;
import jge2d.Ponto;
import jge2d.ResultadoColisao;
import jge2d.Sprite;

/**
 * <p><b>Title:</b> Fury of the Tiny
 * <p><b>Description:</b> Morcego
 * <p><b>Copyright:</b> Copyright (c) 2005
 * <p><b>Company:</b> 4thFloor Corporation
 * @author Sérgio Lopes<br>Ruben Pedro
 * @version 5.0
 */
public final class Morcego extends MovelDeslocamentoDuploResistente implements Enganchavel {

    private static final String MOVER = "mover";

    private Hashtable tabelaColisoesEnganchar = new Hashtable();
    private Hashtable tabelaColisoesDestruidor = new Hashtable();

    public Morcego(String nome, Ponto posicao, Nivel nivel, Ponto posicaoRetorno, double velocidade, int capacidadeResistencia, long tempo) {
        super(nome, posicao, posicaoRetorno, nivel, velocidade, posicaoRetorno.getX(), capacidadeResistencia);
        setSprite(new Sprite(nome, this));
        getSprite().addSpriteColisionListener(this, "trataColisao");
        getSprite().adicionarAnimacao(MOVER, new AnimacaoSprite(nivel.getImagem("morcego"), new int[] {}, new int[] {1,2,3,4,3,2}, new int[] {}, 0, 75, 0));
        getSprite().setAnimacao(MOVER, false, tempo);
        nivel.getMapa().addSprite(getSprite());

        DestruidorRemoverCorda removerCorda = new DestruidorRemoverCorda();
        ColisaoDefault colisaoDefault = new ColisaoDefault();
        tabelaColisoesEnganchar.put(new Integer(ResultadoColisao.COLISAO_POR_DENTRO), colisaoDefault);
        tabelaColisoesEnganchar.put(new Integer(ResultadoColisao.COLISAO_POR_BAIXO), colisaoDefault);
        tabelaColisoesEnganchar.put(new Integer(ResultadoColisao.COLISAO_POR_DIREITA), colisaoDefault);
        tabelaColisoesEnganchar.put(new Integer(ResultadoColisao.COLISAO_POR_ESQUERDA), colisaoDefault);
        tabelaColisoesEnganchar.put(new Integer(ResultadoColisao.COLISAO_POR_CIMA), new MovelEngancharCordaCima());

        tabelaColisoesDestruidor.put(new Integer(ResultadoColisao.COLISAO_POR_DENTRO), removerCorda);
        tabelaColisoesDestruidor.put(new Integer(ResultadoColisao.COLISAO_POR_BAIXO), removerCorda);
        tabelaColisoesDestruidor.put(new Integer(ResultadoColisao.COLISAO_POR_DIREITA), removerCorda);
        tabelaColisoesDestruidor.put(new Integer(ResultadoColisao.COLISAO_POR_ESQUERDA), removerCorda);
        tabelaColisoesDestruidor.put(new Integer(ResultadoColisao.COLISAO_POR_CIMA), colisaoDefault);
    }

    /**
     * Engancha a corda no morcego
     */
    public void enganchar(Corda corda, ResultadoColisao resultado) {
        ((Colidivel)tabelaColisoesEnganchar.get(new Integer(resultado.resultadoObjecto2.tipoColisao))).trataColisao(resultado);
    }

    /**
     * Desengancha a corda do morcego
     */
    public void desenganchar(Corda corda, long tempo) {
        corda.getHeroi().getMovimentoActual().setPosicaoRelativa(null, tempo);
    }

    /**
     * Trata a colisão com a corda, quer como um enganchável (engancha por baixo), quer como um destruidor (remove a corda se ela colidir nos restantes lados). 
     */
    public void trataColisao(Corda corda, ResultadoColisao resultado){
        ((Colidivel)tabelaColisoesDestruidor.get(new Integer(resultado.resultadoObjecto1.tipoColisao))).trataColisao(resultado);
    }
}
