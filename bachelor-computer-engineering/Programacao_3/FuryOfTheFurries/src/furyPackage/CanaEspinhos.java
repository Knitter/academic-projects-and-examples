package furyPackage;

import java.util.Hashtable;
import furyPackage.collisionPackage.ArrastarTiny;
import furyPackage.collisionPackage.Colidivel;
import furyPackage.collisionPackage.ColisaoDefault;
import furyPackage.collisionPackage.MatarTiny;
import jge2d.AnimacaoSprite;
import jge2d.Ponto;
import jge2d.ResultadoColisao;
import jge2d.Sprite;

/**
 * <p><b>Title:</b> Fury of the Tiny
 * <p><b>Description:</b> Cana de Espinhos
 * <p><b>Copyright:</b> Copyright (c) 2005
 * <p><b>Company:</b> 4thFloor Corporation
 * @author Sérgio Lopes<br>Ruben Pedro
 * @version 5.0
 */
public final class CanaEspinhos extends FixoDestruidor {

    private static final String PARADO = "parado";
    private Hashtable tabelaColisoes = new Hashtable();

    public CanaEspinhos(String nome, Ponto posicao, Nivel nivel, long tempo) {
        super(nome, posicao, nivel);
        setSprite(new Sprite(nome, this, posicao));
        getSprite().addSpriteColisionListener(this, "trataColisao");
        getSprite().adicionarAnimacao(PARADO, new AnimacaoSprite(nivel.getImagem("canaEspinhos"), new int[] {}, new int[] {1}, new int[] {}, 0, 1000, 0));
        getSprite().setAnimacao(PARADO, false, tempo);
        nivel.getMapa().addSprite(getSprite());

        ArrastarTiny arrastarTiny = new ArrastarTiny();
        tabelaColisoes.put(new Integer(ResultadoColisao.COLISAO_POR_CIMA), arrastarTiny);
        tabelaColisoes.put(new Integer(ResultadoColisao.COLISAO_POR_ESQUERDA), arrastarTiny);
        tabelaColisoes.put(new Integer(ResultadoColisao.COLISAO_POR_DIREITA), arrastarTiny);
        tabelaColisoes.put(new Integer(ResultadoColisao.COLISAO_POR_BAIXO), new MatarTiny());
        tabelaColisoes.put(new Integer(ResultadoColisao.COLISAO_POR_DENTRO), new ColisaoDefault());
    }

    /**
     * Trata a colisão com o Tiny.
     * Quando a colisão resulta por cima da cana o Tiny morre
     */
   public void trataColisao(Tiny heroi, ResultadoColisao resultado){
       ((Colidivel)tabelaColisoes.get(new Integer(resultado.resultadoObjecto1.tipoColisao))).trataColisao(resultado);
   }

}
