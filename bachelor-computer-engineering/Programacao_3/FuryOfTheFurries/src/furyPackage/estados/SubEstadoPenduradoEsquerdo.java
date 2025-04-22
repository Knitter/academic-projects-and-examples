package furyPackage.estados;

public class SubEstadoPenduradoEsquerdo extends SubEstadoPendurado {

    public SubEstadoPenduradoEsquerdo(EstadoTinyPenduradoNaCorda estado) {
        super(estado);
    }

    /**
     * moverDireita
     *
     * @param tempo long
     */
    public void pararDireita(long tempo) {
        getEstadoPendurado().getSubEstado(SubEstadoPendurado.MEIO).pararEsquerda(tempo);
    }

    /**
     * moverEsquerda
     *
     * @param tempo long
     */
    public void pararEsquerda(long tempo) {
    }

    public void pararBaixo(long tempo) {
        getEstadoPendurado().getSubEstado(SubEstadoPendurado.MEIO).pararBaixo(tempo);
    }

    /**
     * Puxa a corda para cima
     */
    public void moverCima(long tempo){
        getEstadoPendurado().getSubEstado(SubEstadoPendurado.MEIO).moverCima(tempo);
    }

    /**
     * Puxa a corda para baixo
     */
    public void moverBaixo(long tempo){
        getEstadoPendurado().getSubEstado(SubEstadoPendurado.MEIO).moverBaixo(tempo);
    }

    /**
     * Balança o Tiny para a direita
     */
    public void moverDireita(long tempo){
        getEstadoPendurado().getSubEstado(SubEstadoPendurado.MEIO).moverDireita(tempo);
    }

    /**
     * Balança o Tiny para a esquerda
     */
    public void moverEsquerda(long tempo){
    }

}
