package furyPackage;

import furyPackage.estados.*;
import jge2d.AnimacaoSprite;
import jge2d.Ponto;
import jge2d.ResultadoColisao;
import jge2d.Sprite;

/**
 * <p><b>Title:</b> Fury of the Tiny
 * <p><b>Description:</b> Plataforma Destrutivel pelo Martelo
 * <p><b>Copyright:</b> Copyright (c) 2005
 * <p><b>Company:</b> 4thFloor Corporation
 * @author Sérgio Lopes<br>Ruben Pedro
 * @version 5.0
 */
public final class PlataformaDestrutivelMartelo extends FixoEnganchavel implements Removivel {

    /**
     * Número de marteladas que a plataforma destrutível pelo martelo já recebeu
     */
    private int numeroMarteladas;

    /**
     * Estados possíveis que a plataforma destrutível pelo martelo pode estar (com suportado ou sem suportado) 
     */
    private EstadoPlataformaDestrutivelMarteloSuportado[] estados = new EstadoPlataformaDestrutivelMarteloSuportado[] {new EstadoPlataformaDestrutivelMarteloSemSuportado(this), new EstadoPlataformaDestrutivelMarteloComSuportado(this)};

    /**
     * Estados possíveis que a plataforma destrutível pelo martelo toma à medida que vai sendo destruída (depende do número de marteladas que já recebeu) 
     */
    private EstadoPlatafomaDestrutivelMarteloVisual[] estadosVisuais = new EstadoPlatafomaDestrutivelMarteloVisual[] {new EstadoPlataformaDestrutivelMarteloInteiro(this), new EstadoPlataformaDestrutivelMarteloAmassado(this), new EstadoPlataformaDestrutivelMarteloEmCacos(this), new EstadoPlataformaDestrutivelMarteloDestruido(this) };

    /**
     * Estado actual da plataforma destrutível pelo martelo 
     */
    private int estadoActual;

    /**
     * @param numMarteladas - Número de marteladas com que a plataforma destrutível pelo martelo se inicia 
     */
    public PlataformaDestrutivelMartelo(String nome, Ponto posicao, Nivel nivel, int numMarteladas, long tempo) {
        super(nome, posicao, nivel);
        if (numeroMarteladas > 0 || numeroMarteladas <= 2)
            numeroMarteladas = numMarteladas;
        setSprite(new Sprite(nome, this, posicao));
        getSprite().adicionarAnimacao(EstadoPlatafomaDestrutivelMarteloVisual.INTEIRO, new AnimacaoSprite(nivel.getImagem("plataformaDestrutivel"), new int[] {}, new int[] {1}, new int[] {}, 0, 1000, 0));
        getSprite().adicionarAnimacao(EstadoPlatafomaDestrutivelMarteloVisual.AMASSADO, new AnimacaoSprite(nivel.getImagem("plataformaDestrutivel"), new int[] {}, new int[] {2}, new int[] {}, 0, 1000, 0));
        getSprite().adicionarAnimacao(EstadoPlatafomaDestrutivelMarteloVisual.EM_CACOS, new AnimacaoSprite(nivel.getImagem("plataformaDestrutivel"), new int[] {}, new int[] {3}, new int[] {}, 0, 1000, 0));
        nivel.getMapa().addSprite(getSprite());
        estadoActual = EstadoPlataformaDestrutivelMarteloSuportado.SEM_SUPORTADO;
        estadosVisuais[numeroMarteladas].quebrar(tempo);
    }

    /**
     * Incrementa o número de marteladas recebidas e altera o aspecto visual da plataforma destrutível pelo martelo
     */
    public void quebrar(long tempo) {
        estadosVisuais[++numeroMarteladas].quebrar(tempo);
    }

    /**
     * Remove a plataforma destrutível pelo martelo do nível
     */
    public void removerDoNivel() {
        getNivel().getMapa().removeSprite(getSprite());
    }

    /**
     * Passa a plataforma destrutível pelo martelo para o estado suportável 
     */
    public void suportar(Tiny heroi, ResultadoColisao resultado) {
        estadoActual = EstadoPlataformaDestrutivelMarteloSuportado.COM_SUPORTADO;
        super.suportar(heroi, resultado);
    }

    /**
     * Deixa de suportar o Tiny 
     */
    public void desSuportar(long tempo){
        estadoActual = EstadoPlataformaDestrutivelMarteloSuportado.SEM_SUPORTADO;
        super.desSuportar(tempo);
    }

    /**
     * Devolve o estado actual da plataforma 
     */
    public EstadoPlataformaDestrutivelMarteloSuportado getEstadoActual() {
        return estados[estadoActual];
    }

}
