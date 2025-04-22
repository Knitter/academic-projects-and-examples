package furyPackage;

import java.util.LinkedList;
import jge2d.AnimacaoSprite;
import jge2d.Ponto;
import jge2d.ResultadoColisao;
import jge2d.Sprite;

/**
 * <p><b>Title:</b> Fury of the Tiny
 * <p><b>Description:</b> Chave
 * <p><b>Copyright:</b> Copyright (c) 2005
 * <p><b>Company:</b> 4thFloor Corporation
 * @author S�rgio Lopes<br>Ruben Pedro
 * @version 5.0
 */
public final class Chave extends Activavel implements Removivel {

    private static final String PARADO = "parado";

    /**
     * Lista que guarda todos os c�digos das fechaduras que uma chave consegue abrir
     */
    private LinkedList codigosFechadura;

    /**
     * @param codigosFechadura - Lista com todos os c�digos de fechadura que a chave pode abrir
     */
    public Chave(String nome, Ponto posicao, Nivel nivel, LinkedList codigosFechadura, long tempo) {
        super(nome, posicao, nivel);
        this.codigosFechadura = codigosFechadura;
        setSprite(new Sprite(nome, this, posicao));
        getSprite().adicionarAnimacao(PARADO, new AnimacaoSprite(nivel.getImagem("chave"), new int[] {}, new int[] {1}, new int[] {}, 0, 1000, 0));
        getSprite().setAnimacao(PARADO, false, tempo);
        nivel.getMapa().addSprite(getSprite());
    }

    /**
     * Verifica se a chave pode ou n�o abrir uma fechadura, pesquisando o c�digo da fechadura na sua lista de c�digos de fechaduras
     * @param codigo - C�digo de fechadura a pesquisar
     */
    public boolean pesquisarCodigo(String codigo) {
        return codigosFechadura.contains(codigo);
    }

    /**
     * Pede ao Tiny para adicionar-se ao seu saco de chaves 
     */
    public void activar(Tiny heroi, ResultadoColisao resultado) {
        heroi.adicionarChave(this);
        removerDoNivel();
    }

    /**
     * Remove a chave do n�vel
     */
    public void removerDoNivel(){
        getNivel().getMapa().removeSprite(getSprite());
    }

}
