package furyPackage.estados;

import jge2d.jogo.movimentos.MovimentoTinyPenduradoNaCorda;

public class SubEstadoPenduradoMeio extends SubEstadoPendurado {

    public SubEstadoPenduradoMeio(EstadoTinyPenduradoNaCorda estado) {
        super(estado);
    }

    /**
     * Desloca o Tiny para a direita
     */
    public void pararDireita(long tempo){
        getEstadoPendurado().parar(tempo);
        getEstadoPendurado().mudarSubEstado(SubEstadoPendurado.DIREITO);
    }

    /**
     * Desloca o Tiny para a esquerda
     */
    public void pararEsquerda(long tempo){
        getEstadoPendurado().parar(tempo);
        getEstadoPendurado().mudarSubEstado(SubEstadoPendurado.ESQUERDO);
    }

    public void pararBaixo(long tempo) {
        getEstadoPendurado().parar(tempo);
        getEstadoPendurado().mudarSubEstado(SubEstadoPendurado.BAIXO);
    }

    /**
     * Puxa a corda para cima
     */
    public void moverCima(long tempo){
        getEstadoPendurado().getHeroi().getNivel().adicionarIteravel(getEstadoPendurado().getHeroi());
        getEstadoPendurado().getThisMovimento().setAproximacaoCentro(MovimentoTinyPenduradoNaCorda.APROXIMAR_CENTRO);
    }

    /**
     * Puxa a corda para baixo
     */
    public void moverBaixo(long tempo){
        getEstadoPendurado().getHeroi().getNivel().adicionarIteravel(getEstadoPendurado().getHeroi());
        getEstadoPendurado().getThisMovimento().setAproximacaoCentro(MovimentoTinyPenduradoNaCorda.AFASTAR_CENTRO);
    }

    /**
     * Balança o Tiny para a direita
     */
    public void moverDireita(long tempo){
        getEstadoPendurado().getHeroi().getNivel().adicionarIteravel(getEstadoPendurado().getHeroi());
        getEstadoPendurado().getThisMovimento().setSentidoRotacao(MovimentoTinyPenduradoNaCorda.SENTIDO_CONTRA_PONTEIRO_RELOGIO);
    }

    /**
     * Balança o Tiny para a esquerda
     */
    public void moverEsquerda(long tempo){
        getEstadoPendurado().getHeroi().getNivel().adicionarIteravel(getEstadoPendurado().getHeroi());
        getEstadoPendurado().getThisMovimento().setSentidoRotacao(MovimentoTinyPenduradoNaCorda.SENTIDO_PONTEIRO_RELOGIO);
    }

}
