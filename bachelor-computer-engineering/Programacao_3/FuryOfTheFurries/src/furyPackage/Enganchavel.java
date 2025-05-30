/* Generated by Together */

package furyPackage;

import jge2d.ResultadoColisao;

/**
 * Define o comportamento para objectos que permitem a uma corda enganchar-se
 */
public interface Enganchavel {

    /**
     * Trata a colis�o com uma corda
     * @param corda - Corda com a qual o objecto enganchavel engancha
     */
    void enganchar(Corda corda, ResultadoColisao resultado);

    void desenganchar(Corda corda, long tempo);
}
