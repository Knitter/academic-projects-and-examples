package furyPackage.estados;

public class SubEstadoLivreEsquerdo extends SubEstadoLivre {

    public SubEstadoLivreEsquerdo(EstadoTinyLivre estado) {
        super(estado);
    }

    /**
     * moverDireita
     *
     * @param tempo long
     */
    public void moverDireita(long tempo) {
        getEstadoLivre().getSubEstado(SubEstadoLivre.MEIO).moverDireita(tempo);
        getEstadoLivre().mudarSubEstado(SubEstadoLivre.MEIO);
    }

    /**
     * moverEsquerda
     *
     * @param tempo long
     */
    public void moverEsquerda(long tempo) {
    }
}
