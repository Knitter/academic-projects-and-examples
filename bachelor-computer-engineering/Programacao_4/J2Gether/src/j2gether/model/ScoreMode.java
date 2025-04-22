package j2gether.model;

/**
 * <p>Title: J2Gether</p>
 *
 * <p>Description: Primeiro trabalho prático P4</p>
 *
 * <p>Copyright: Copyright (c) 2005</p>
 *
 * <p>Company: 4thFloor</p>
 *
 * @author Sérgio Lopes, Ruben Pedro
 * @version 1.0
 */
public final class ScoreMode {

    private int numLinhasTabuleiro;
    private int numColunasTabuleiro;
    private int numCores;

	/**
	 * Constrói um ScoreMode que contém as informações do jogo actual
	 *
	 * @param numLinhasTabuleiro número de linhas do jogo actual
	 * @param numColunasTabuleiro número de colunas do jogo actual
	 * @param numCores número de cores usadas no jogo actual
	 */
    public ScoreMode(int numLinhasTabuleiro, int numColunasTabuleiro, int numCores)
	{
        this.numLinhasTabuleiro = numLinhasTabuleiro;
        this.numColunasTabuleiro = numColunasTabuleiro;
        this.numCores = numCores;
    }

    /**
     * Obtém o número de linhas do tabuleiro
     *
     * @return o número de linhas do tabuleiro que corresponde à pontuação a construir
     */
    public int getNumLinhasTabuleiro() {
        return numLinhasTabuleiro;
    }

    /**
     * Obtém o número de cores do tabuleiro
     *
     * @return o número de cores utilizadas no tabuleiro que corresponde à pontuação a construir
     */
    public int getNumCores() {
        return numCores;
    }

    /**
     * Obtém o número de colunas do tabuleiro
     *
     * @return o número de colunas do tabuleiro que corresponde à pontuação a construir
     */
    public int getNumColunasTabuleiro() {
        return numColunasTabuleiro;
    }
}
