/* Generated by Together */

package furyPackage.estados;

import furyPackage.Tiny;

/**
 * Agrupa objectos sem representa��o gr�fica no n�vel mas que possuem um Tiny
 */
public abstract class DetentorDoTiny {

    private Tiny heroi;

    public DetentorDoTiny() {
    }

    public DetentorDoTiny(Tiny heroi) {
        this.heroi = heroi;
    }

    public Tiny getHeroi() {
        return heroi;
    }

    public void setHeroi(Tiny heroi) {
        this.heroi = heroi;
    }

}
