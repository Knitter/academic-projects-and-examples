package furyPackage.estados;

import jge2d.jogo.movimentos.MovimentoVelocidadeComSentido;

public class SubEstadoLivreMeio extends SubEstadoLivre {

    public SubEstadoLivreMeio(EstadoTinyLivre estado) {
        super(estado);
    }

    /**
     * Desloca o Tiny para a direita
     */
    public void moverDireita(long tempo){
        getEstadoLivre().getThisMovimento().setSentidoDeslocamento(MovimentoVelocidadeComSentido.SENTIDO_DIREITA);
        getEstadoLivre().getHeroi().getSprite().setAnimacao(getEstadoLivre().getHeroi().getHabilidadeActual().getAnimacaoSaltoDireito(), true, tempo);
        getEstadoLivre().getHeroi().setNomeAnimacaoAnterior(Habilidade.NOME_FLY_DIREITA);
        getEstadoLivre().getHeroi().aRebolar();
    }

    /**
     * Desloca o Tiny para a esquerda
     */
    public void moverEsquerda(long tempo){
        getEstadoLivre().getThisMovimento().setSentidoDeslocamento(MovimentoVelocidadeComSentido.SENTIDO_ESQUERDA);
        getEstadoLivre().getHeroi().getSprite().setAnimacao(getEstadoLivre().getHeroi().getHabilidadeActual().getAnimacaoSaltoEsquerdo(), true, tempo);
        getEstadoLivre().getHeroi().setNomeAnimacaoAnterior(Habilidade.NOME_FLY_ESQUERDA);
        getEstadoLivre().getHeroi().aRebolar();
    }

}
