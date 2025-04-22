package furyPackage.collisionPackage;

import furyPackage.Tiny;
import jge2d.ResultadoColisao;
import jge2d.jogo.movimentos.MovimentoTinyPenduradoNaCorda;

public class PararTinyNaCorda implements Colidivel {

    public PararTinyNaCorda() {
    }

    public void trataColisao(ResultadoColisao resultado) {
        Tiny heroi = (Tiny)resultado.resultadoObjecto1.objecto;
        ((MovimentoTinyPenduradoNaCorda)heroi.getMovimentoActual()).setPosicoes(heroi.getCorda().getThisMovimento().getUltimaPosicao(), resultado.resultadoObjecto1.pontoArraste, resultado.tempoColisao);
        heroi.getPlataforma().adicionarSuportadoAosIteraveis (heroi);
    }
}
