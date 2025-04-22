package furyPackage.estados;

public abstract class SubEstadoPendurado {

    private EstadoTinyPenduradoNaCorda estadoPendurado;

    private static int b = 0;
    public static final int MEIO = b++;
    public static final int ESQUERDO = b++;
    public static final int DIREITO = b++;
    public static final int CIMA = b++;
    public static final int BAIXO = b++;

    public SubEstadoPendurado(EstadoTinyPenduradoNaCorda estado) {
        this.estadoPendurado = estado;
    }

    public EstadoTinyPenduradoNaCorda getEstadoPendurado() {
        return estadoPendurado;
    }

    /**
     * Desloca o Tiny para a direita
     */
    public abstract void pararDireita(long tempo);

    /**
     * Desloca o Tiny para a esquerda
     */
    public abstract void pararEsquerda(long tempo);

    /**
     * Desloca o Tiny para baixo
     */
    public abstract void pararBaixo(long tempo);

    /**
     * Puxa a corda para cima
     */
    public abstract void moverCima(long tempo);

    /**
     * Puxa a corda para baixo
     */
    public abstract void moverBaixo(long tempo);

    /**
     * Balança o Tiny para a direita
     */
    public abstract void moverDireita(long tempo);

    /**
     * Balança o Tiny para a esquerda
     */
    public abstract void moverEsquerda(long tempo);

}
