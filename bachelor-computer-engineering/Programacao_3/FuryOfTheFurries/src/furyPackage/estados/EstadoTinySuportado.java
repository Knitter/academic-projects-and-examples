/* Generated by Together */

package furyPackage.estados;

import furyPackage.ObjectoDoNivel;
import furyPackage.Suportavel;
import furyPackage.Tiny;
import jge2d.ResultadoColisao;
import jge2d.jogo.movimentos.MovimentoTinySuportado;
import jge2d.jogo.movimentos.MovimentoVelocidadeComSentido;

/**
 * Define o comportamento do Tiny com um movimento suportado
 */
public final class EstadoTinySuportado extends EstadoTinyComMovimento {

    public EstadoTinySuportado(Tiny heroi, MovimentoTinySuportado movimento) {
        super(heroi, movimento);
    }

    /**
     * Faz o Tiny saltar
     */
    public void moverCima(long tempo){
        desSuportar(tempo);
        getHeroi().mudarEstadoActual(EstadoTiny.LIVRE);
        ((EstadoTinyLivre)getHeroi().getEstadoActual()).saltar(tempo);
    }

    /**
     * Entra no modo de selec��o
     */
    public void moverBaixo(long tempo) {
        getThisMovimento().setSentidoDeslocamento(MovimentoVelocidadeComSentido.PARADO);
        getHeroi().getSprite().setAnimacao(getHeroi().getHabilidadeActual().getAnimacaoSeleccao(), true, tempo);
        getHeroi().setNomeAnimacaoAnterior(Habilidade.NOME_SELECT);
        getHeroi().mudarEstadoActual(EstadoTiny.SELECCAO);
        getHeroi().seleccionarHabilidadeSeleccao();
    }

    /**
     * Faz o Tiny andar para a direita
     */
    public void moverDireita(long tempo){
        getHeroi().getOrientacaoActual().moverDireita(tempo);
    }

    /**
     * Faz o Tiny andar para a esquerda
     */
    public void moverEsquerda(long tempo){
        getHeroi().getOrientacaoActual().moverEsquerda(tempo);
    }

    public void parar(long tempo) {
        getThisMovimento().setSentidoDeslocamento(MovimentoVelocidadeComSentido.PARADO);
        getHeroi().getSprite().setAnimacao(getHeroi().getHabilidadeActual().getAnimacaoFrente(), true, tempo);
        getHeroi().setNomeAnimacaoAnterior(Habilidade.NOME_FRENTE);
        getHeroi().getNivel().adicionarRemovivel(getHeroi());
    }

    public MovimentoTinySuportado getThisMovimento() {
        return (MovimentoTinySuportado) getMovimento();
    }

    /**
     * Trata a colis�o com objectos de suporte do tiny, e passa o tiny para o estado suportado atribu�ndo-lhe a plataforma que o suporta
     */
    public void trataColisao(Suportavel plataforma, ResultadoColisao resultado) {
        getThisMovimento().setPosicaoActual(resultado.resultadoObjecto1.pontoArraste, resultado.tempoColisao);
    }

    /**
     * diagonalDireita
     *
     * @param tempo long
     */
    public void diagonalDireita(long tempo) {
        moverCima(tempo);
        getHeroi().getEstadoActual().moverDireita(tempo);
    }

    /**
     * diagonalEsquerda
     *
     * @param tempo long
     */
    public void diagonalEsquerda(long tempo) {
        moverCima(tempo);
        getHeroi().getEstadoActual().moverEsquerda(tempo);
    }

    public void aterrar(Suportavel plataforma, ResultadoColisao resultado) {
        getThisMovimento().setPosicaoActual(resultado.resultadoObjecto1.pontoArraste, resultado.tempoColisao);
        getHeroi().getSprite().setMovimento(getThisMovimento());
        getHeroi().getOrientacaoActual().pararAnimacaoFrente(resultado.tempoColisao);
        getHeroi().getOrientacaoActual().pararAnimacaoDireita(resultado.tempoColisao);
        getHeroi().getOrientacaoActual().pararAnimacaoEsquerda(resultado.tempoColisao);
        ((EstadoTinyLivre)getHeroi().getEstado(EstadoTiny.LIVRE)).mudarSubEstado(SubEstadoLivre.MEIO);
        plataforma.suportar(getHeroi(), resultado);
        getHeroi().setPlataforma(plataforma);
        getHeroi().getCorda().actualizarMovimentoDoDono(resultado.tempoColisao);
        getHeroi().getNivel().adicionarIteravel(getHeroi());
        getHeroi().getNivel().actualizarTeclado(resultado.tempoColisao);
    }

    /**
     * iterar
     *
     * @param tempo long
     */
    public void iterar(long tempo) {
        if (getHeroi().getSprite().getUltimaPosicao().getX() > ((ObjectoDoNivel)getHeroi().getPlataforma()).getSprite().getUltimaPosicao().getX() + ((ObjectoDoNivel)getHeroi().getPlataforma()).getSprite().getWidth() ||
            getHeroi().getSprite().getUltimaPosicao().getX() + getHeroi().getSprite().getWidth() < ((ObjectoDoNivel)getHeroi().getPlataforma()).getSprite().getUltimaPosicao().getX()) {

            desSuportar(tempo);
            getHeroi().cair(tempo);
        }
    }

    public void desSuportar(long tempo) {
        getHeroi().getPlataforma().desSuportar(tempo);
    }
}
