/* Generated by Together */

package furyPackage.estados;

import java.util.Hashtable;
import furyPackage.Suportavel;
import furyPackage.Tiny;
import furyPackage.collisionPackage.AterrarTiny;
import furyPackage.collisionPackage.Colidivel;
import furyPackage.collisionPackage.PararSaltoDoTinyPelosLados;
import furyPackage.collisionPackage.PararSaltoDoTinyPorCima;
import jge2d.ResultadoColisao;
import jge2d.jogo.movimentos.MovimentoTinyLivre;
import jge2d.jogo.movimentos.MovimentoVelocidadeComSentido;

/**
 * Define o comportamento do Tiny com um movimento livre
 */
public final class EstadoTinyLivre extends EstadoTinyComMovimento {

    private SubEstadoLivre[] subEstados = new SubEstadoLivre[] {new SubEstadoLivreMeio(this), new SubEstadoLivreEsquerdo(this), new SubEstadoLivreDireito(this)};
    private int subEstadoActual = SubEstadoLivre.MEIO;
    private Hashtable tabelaColisoes = new Hashtable();

    public EstadoTinyLivre(Tiny heroi, MovimentoTinyLivre movimento) {
        super(heroi, movimento);

        tabelaColisoes.put(new Integer(ResultadoColisao.COLISAO_POR_BAIXO), new PararSaltoDoTinyPorCima());
        tabelaColisoes.put(new Integer(ResultadoColisao.COLISAO_POR_CIMA), new AterrarTiny());
        PararSaltoDoTinyPelosLados aux = new PararSaltoDoTinyPelosLados();
        tabelaColisoes.put(new Integer(ResultadoColisao.COLISAO_POR_ESQUERDA), aux);
        tabelaColisoes.put(new Integer(ResultadoColisao.COLISAO_POR_DIREITA), aux);
        tabelaColisoes.put(new Integer(ResultadoColisao.COLISAO_POR_DENTRO), aux);
    }

    public void saltar(long tempo) {
        getHeroi().getSprite().setAnimacao(getHeroi().getHabilidadeActual().getAnimacaoSalto(), true, tempo);
        getHeroi().setNomeAnimacaoAnterior(Habilidade.NOME_HOP);
        getMovimento().setPosicaoActual(getHeroi().getSprite().getUltimaPosicao(), tempo);
        getHeroi().getSprite().setMovimento(getMovimento());
        getHeroi().getCorda().actualizarMovimentoDoDono(tempo);
        getThisMovimento().saltar();
        getHeroi().getNivel().adicionarRemovivel(getHeroi());
    }

    public void moverCima(long tempo){
    }

    public void moverBaixo(long tempo){
    }

    /**
     * Desloca o Tiny para a direita
     */
    public void moverDireita(long tempo){
        subEstados[subEstadoActual].moverDireita(tempo);
    }

    /**
     * Desloca o Tiny para a esquerda
     */
    public void moverEsquerda(long tempo){
        subEstados[subEstadoActual].moverEsquerda(tempo);
    }

    public void parar(long tempo){
        getThisMovimento().setSentidoDeslocamento(MovimentoVelocidadeComSentido.PARADO);
        getHeroi().getSprite().setAnimacao(getHeroi().getHabilidadeActual().getAnimacaoSalto(), true, tempo);
        getHeroi().setNomeAnimacaoAnterior(Habilidade.NOME_HOP);
        subEstadoActual = SubEstadoLivre.MEIO;
    }

    public MovimentoTinyLivre getThisMovimento() {
        return (MovimentoTinyLivre) getMovimento();
    }

    /**
     * Trata a colis�o com objectos de suporte do tiny, e passa o tiny para o estado suportado atribu�ndo-lhe a plataforma que o suporta
     */
    public void trataColisao(Suportavel plataforma, ResultadoColisao resultado){
        ((Colidivel)tabelaColisoes.get(new Integer(resultado.resultadoObjecto1.tipoColisao))).trataColisao(resultado);
    }

    /**
     * diagonalDireita
     *
     * @param tempo long
     */
    public void diagonalDireita(long tempo) {
        moverDireita(tempo);
    }

    /**
     * diagonalEsquerda
     *
     * @param tempo long
     */
    public void diagonalEsquerda(long tempo) {
        moverEsquerda(tempo);
    }

    /**
     * iterar
     *
     * @param tempo long
     */
    public void iterar(long tempo) {
    }

    public int getSubEstadoActual() {
        return subEstadoActual;
    }

    public SubEstadoLivre getSubEstado(int subEstado) {
        return subEstados[subEstado];
    }

    public void mudarSubEstado(int novoSubEstado) {
        subEstadoActual = novoSubEstado;
    }

    public void desSuportar(long tempo) {
    }

}
