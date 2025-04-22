package furyPackage.estados;

public abstract class SubEstadoLivre {

    private EstadoTinyLivre estadoLivre;

    private static int b = 0;
    public static final int MEIO = b++;
    public static final int ESQUERDO = b++;
    public static final int DIREITO = b++;

    public SubEstadoLivre(EstadoTinyLivre estado) {
        this.estadoLivre = estado;
    }

    public EstadoTinyLivre getEstadoLivre() {
        return estadoLivre;
    }

    /**
     * Desloca o Tiny para a direita
     */
    public abstract void moverDireita(long tempo);
    /**
     * Desloca o Tiny para a esquerda
     */
    public abstract void moverEsquerda(long tempo);
}
