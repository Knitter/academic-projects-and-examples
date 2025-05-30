/* Generated by Together */

package furyPackage.collisionPackage;

import furyPackage.Corda;
import furyPackage.ObjectoDoNivel;
import jge2d.Ponto;
import jge2d.ResultadoColisao;
import jge2d.Sprite;

public class EngancharCordaCima extends EngancharCorda {

    public EngancharCordaCima() {
    }

    public void trataColisao(ResultadoColisao resultado) {
        Corda corda = (Corda)resultado.resultadoObjecto1.objecto;
        Sprite sprite = ((ObjectoDoNivel)resultado.resultadoObjecto2.objecto).getSprite();
        corda.setPontoDeEnganche(new Ponto(corda.getSprite().getUltimaPosicao().getX(), sprite.getUltimaPosicao().getY() + sprite.getHeight() + 1));
        super.trataColisao(resultado);
    }

}
