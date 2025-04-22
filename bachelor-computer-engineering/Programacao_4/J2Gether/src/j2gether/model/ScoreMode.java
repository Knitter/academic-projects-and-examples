package j2gether.model;

/**
 * <p>Title: J2Gether</p>
 *
 * <p>Description: Primeiro trabalho pr�tico P4</p>
 *
 * <p>Copyright: Copyright (c) 2005</p>
 *
 * <p>Company: 4thFloor</p>
 *
 * @author S�rgio Lopes, Ruben Pedro
 * @version 1.0
 */
public final class ScoreMode {

    private int numLinhasTabuleiro;
    private int numColunasTabuleiro;
    private int numCores;

	/**
	 * Constr�i um ScoreMode que cont�m as informa��es do jogo actual
	 *
	 * @param numLinhasTabuleiro n�mero de linhas do jogo actual
	 * @param numColunasTabuleiro n�mero de colunas do jogo actual
	 * @param numCores n�mero de cores usadas no jogo actual
	 */
    public ScoreMode(int numLinhasTabuleiro, int numColunasTabuleiro, int numCores)
	{
        this.numLinhasTabuleiro = numLinhasTabuleiro;
        this.numColunasTabuleiro = numColunasTabuleiro;
        this.numCores = numCores;
    }

    /**
     * Obt�m o n�mero de linhas do tabuleiro
     *
     * @return o n�mero de linhas do tabuleiro que corresponde � pontua��o a construir
     */
    public int getNumLinhasTabuleiro() {
        return numLinhasTabuleiro;
    }

    /**
     * Obt�m o n�mero de cores do tabuleiro
     *
     * @return o n�mero de cores utilizadas no tabuleiro que corresponde � pontua��o a construir
     */
    public int getNumCores() {
        return numCores;
    }

    /**
     * Obt�m o n�mero de colunas do tabuleiro
     *
     * @return o n�mero de colunas do tabuleiro que corresponde � pontua��o a construir
     */
    public int getNumColunasTabuleiro() {
        return numColunasTabuleiro;
    }
}
