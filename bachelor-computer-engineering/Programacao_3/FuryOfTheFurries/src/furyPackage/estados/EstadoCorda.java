/* Generated by Together */

package furyPackage.estados;

import furyPackage.Activavel;
import furyPackage.Corda;
import furyPackage.Enganchavel;
import furyPackage.Suportavel;
import jge2d.Ponto;
import jge2d.ResultadoColisao;

public abstract class EstadoCorda {

    private Corda corda;
    private static int b = 0;
    public static final int ARRECADADA = b++;
    public static final int SOLTA = b++;
    public static final int ENGANCHADA = b++;

    public EstadoCorda() {
    }

    public EstadoCorda(Corda corda) {
        this.corda = corda;
    }

    public Corda getCorda() {
        return corda;
    }

    public abstract void lancar(Ponto destino, long tempo);

    public abstract void trataColisao(Enganchavel enganchado, ResultadoColisao resultado);

    public abstract void trataColisao(Suportavel plataforma, ResultadoColisao resultado);

    public abstract void trataColisao(Activavel activavel, ResultadoColisao resultado);

    public abstract void actualizarMovimentoDoDono(long tempo);

    public abstract void remover(long tempo);

}
