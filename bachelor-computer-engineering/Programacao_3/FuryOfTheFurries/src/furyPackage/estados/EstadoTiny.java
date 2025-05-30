/* Generated by Together */

package furyPackage.estados;

import furyPackage.Tiny;

/**
 * Estado em que o Tiny pode estar
 */
public abstract class EstadoTiny extends DetentorDoTiny {

    private static int b = 0;
    public static final int SELECCAO = b++;
    public static final int SUPORTADO = b++;
    public static final int LIVRE = b++;
    public static final int PENDURADO = b++;

    public EstadoTiny() {
    }

    public EstadoTiny(Tiny heroi) {
        super(heroi);
    }

    public abstract void moverCima(long tempo);

    public abstract void moverBaixo(long tempo);

    public abstract void moverDireita(long tempo);

    public abstract void moverEsquerda(long tempo);

    public abstract void diagonalDireita(long tempo);

    public abstract void diagonalEsquerda(long tempo);

    public abstract void parar(long tempo);

    public abstract void iterar(long tempo);

    public abstract void desSuportar(long tempo);

}
