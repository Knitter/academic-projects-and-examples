/* Generated by Together */

package furyPackage.collisionPackage;

import furyPackage.Corda;
import jge2d.ResultadoColisao;

public class DestruidorRemoverCorda implements Colidivel {

    public DestruidorRemoverCorda() {
    }

    public void trataColisao(ResultadoColisao resultado) {
        ((Corda)resultado.resultadoObjecto2.objecto).remover(resultado.tempoColisao);
    }
}
