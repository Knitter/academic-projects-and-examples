package furyPackage.estados;

public class SubEstadoLivreDireito extends SubEstadoLivre {

    public SubEstadoLivreDireito(EstadoTinyLivre estado) {
        super(estado);
    }

    /**
     * moverDireita
     *
     * @param tempo long
     */
    public void moverDireita(long tempo) {
    }

    /**
     * moverEsquerda
     *
     * @param tempo long
     */
    public void moverEsquerda(long tempo) {
        getEstadoLivre().getSubEstado(SubEstadoLivre.MEIO).moverEsquerda(tempo);
        getEstadoLivre().mudarSubEstado(SubEstadoLivre.MEIO);
    }
}
