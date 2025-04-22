package furyPackage;

import jge2d.Ponto;
import jge2d.jogo.movimentos.MovimentoVerticalUnidireccional;

/**
 * <p><b>Title:</b> Fury of the Tiny
 * <p><b>Description:</b> Porta Vertical
 * <p><b>Copyright:</b> Copyright (c) 2005
 * <p><b>Company:</b> 4thFloor Corporation
 * @author Sérgio Lopes<br>Ruben Pedro
 * @version 5.0
 */
public final class PortaVertical extends Porta {

    public PortaVertical(String nome, Ponto posicao, Nivel nivel, double velocidade, double deslocamento, long tempo) {
        super(nome, posicao, nivel, new PlataformaMovelEnganchavel[] {
              new PlataformaMovelEnganchavel("plataforma1_" + nome, new Ponto(posicao.getX(), posicao.getY() + nivel.getImagem("plataformaPorta").getHeight()), nivel, velocidade, -deslocamento, tempo),
              new PlataformaMovelEnganchavel("plataforma2_" + nome, new Ponto(posicao.getX(), posicao.getY() + 2 * nivel.getImagem("plataformaPorta").getHeight()), nivel, velocidade, deslocamento, tempo)
              }
        );
    }

    /**
     * Desloca todas as plataformas constituíntes da porta 
     */
    public void moverPlataformas(long tempo) {
        for (int i = 0; i < getNumeroDePlataformas(); i++)
            getPlataforma(i).getSprite().setMovimento(new MovimentoVerticalUnidireccional(getPlataforma(i).getPosicao(), getPlataforma(i).getDeslocamento(), getPlataforma(i).getVelocidade(), tempo));
    }

}
