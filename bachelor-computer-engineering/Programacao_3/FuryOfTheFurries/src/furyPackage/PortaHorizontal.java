package furyPackage;

import jge2d.Ponto;
import jge2d.jogo.movimentos.MovimentoHorizontalUnidireccional;

/**
 * <p><b>Title:</b> Fury of the Tiny
 * <p><b>Description:</b> Porta Horizontal
 * <p><b>Copyright:</b> Copyright (c) 2005
 * <p><b>Company:</b> 4thFloor Corporation
 * @author Sérgio Lopes<br>Ruben Pedro
 * @version 5.0
 */
public final class PortaHorizontal extends Porta {

    public PortaHorizontal(String nome, Ponto posicao, Nivel nivel, double velocidade, double deslocamento, long tempo) {
        super(nome, posicao, nivel, new PlataformaMovelEnganchavel[] {
              new PlataformaMovelEnganchavel("plataforma1_" + nome, new Ponto(posicao.getX() + nivel.getImagem("plataformaPorta").getWidth(), posicao.getY()), nivel, velocidade, -deslocamento, tempo),
              new PlataformaMovelEnganchavel("plataforma2_" + nome, new Ponto(posicao.getX() + 2 * nivel.getImagem("plataformaPorta").getWidth(), posicao.getY()), nivel, velocidade, deslocamento, tempo)
              }
        );
    }

    /**
     * Desloca todas as plataformas constituíntes da porta 
     */
    public void moverPlataformas(long tempo) {
        for (int i = 0; i < getNumeroDePlataformas(); i++)
            getPlataforma(i).getSprite().setMovimento(new MovimentoHorizontalUnidireccional(getPlataforma(i).getPosicao(), getPlataforma(i).getDeslocamento(), getPlataforma(i).getVelocidade(), tempo));
    }

}
