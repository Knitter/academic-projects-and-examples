package furyPackage;

import java.util.Hashtable;
import furyPackage.collisionPackage.Colidivel;
import furyPackage.collisionPackage.ColisaoDefault;
import furyPackage.collisionPackage.TinyAbrirFechadura;
import jge2d.AnimacaoSprite;
import jge2d.Ponto;
import jge2d.ResultadoColisao;
import jge2d.Sprite;

/**
 * <p><b>Title:</b> Fury of the Tiny
 * <p><b>Description:</b> Fechadura
 * <p><b>Copyright:</b> Copyright (c) 2005
 * <p><b>Company:</b> 4thFloor Corporation
 * @author Sérgio Lopes<br>Ruben Pedro
 * @version 5.0
 */
public final class Fechadura extends ActivavelComPorta implements Suportavel {

    private static final String PARADO = "parado";
    private Hashtable tabelaColisoes = new Hashtable();

    /**
     * Código da fechadura
     */
    private String codigo;

    /**
     * Objecto ao qual a fechadura está a dar suporte
     */
    private Tiny heroi;

    /**
     * @param codigo - Código da chave que abre a porta
     * @param porta - Porta associada à fechadura
     */
    public Fechadura(String nome, Ponto posicao, Nivel nivel, String codigo, Porta porta, long tempo) {
        super(nome, posicao, nivel, porta);
        this.codigo = codigo;
        setSprite(new Sprite(nome, this, posicao));
        getSprite().adicionarAnimacao(PARADO, new AnimacaoSprite(nivel.getImagem("fechadura"), new int[] {}, new int[] {1}, new int[] {}, 0, 1000, 0));
        getSprite().setAnimacao(PARADO, false, tempo);
        nivel.getMapa().addSprite(getSprite());

        ColisaoDefault colisaoDefault = new ColisaoDefault();
        TinyAbrirFechadura tinyAbrirFechadura = new TinyAbrirFechadura();
        tabelaColisoes.put(new Integer(ResultadoColisao.COLISAO_POR_ESQUERDA), tinyAbrirFechadura);
        tabelaColisoes.put(new Integer(ResultadoColisao.COLISAO_POR_DIREITA), tinyAbrirFechadura);
        tabelaColisoes.put(new Integer(ResultadoColisao.COLISAO_POR_CIMA), colisaoDefault);
        tabelaColisoes.put(new Integer(ResultadoColisao.COLISAO_POR_BAIXO), colisaoDefault);
        tabelaColisoes.put(new Integer(ResultadoColisao.COLISAO_POR_DENTRO), colisaoDefault);
    }

    /**
     * Verifica se uma chave pode abrir a porta
     */
    public boolean verificarChave(Chave chave) {
        return chave.pesquisarCodigo(codigo);
    }

    /**
     * Activa a fechadura abrindo a respectiva porta
     */
    public void activar(Tiny heroi, ResultadoColisao resultado) {
        ((Colidivel)tabelaColisoes.get(new Integer(resultado.resultadoObjecto1.tipoColisao))).trataColisao(resultado);
    }

    /**
     * Suporta o Tiny
     **/
    public void suportar(Tiny heroi, ResultadoColisao resultado) {
        this.heroi = heroi;
    }

    /**
     * Deixa de suporta o Tiny
     */
    public void desSuportar(long tempo) {
        heroi = null;
    }

    public void adicionarSuportadoAosIteraveis(Tiny heroi) {
    }



/////////////////////////// Getters & Setters //////////////////////////////////

    public Tiny getSuportado() {
        return heroi;
    }
}
