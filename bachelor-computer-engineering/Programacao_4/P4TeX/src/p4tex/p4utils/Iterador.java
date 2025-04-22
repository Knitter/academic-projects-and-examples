package p4tex.p4utils;

/**
 * Programa��o IV (C) 2001
 * Interface que descreve o funcionamento de um iterador simples.
 *
 * @author J. Magno e V. Carreira
 * @version 1.0
 */
public interface Iterador {
    /**	Excep��o propagada quando se acede a elemento inv�lido.   */
    public static final java.util.NoSuchElementException
        ELEMENTO_INVALIDO = new java.util.NoSuchElementException();

    /**	Verifica se pode avancar para o proximo elemento.
            @return true caso ainda existam elementos a percorrer;
            false caso contr�rio	*/
    public boolean podeAvancar();

    /**	Devolve o pr�ximo elemento.
            Caso n�o exista lan�a a excep��o ELEMENTO_INVALIDO
            @return o pr�ximo elemento   */
    public Object avancar();

    /**	Coloca o iterador no n� inicial da lista   */
    public void reiniciar();

    /**	Devolve o elemento actual.
            Caso n�o exista lan�a a excep��o ELEMENTO_INVALIDO
            @return o elemento actual   */
    public Object corrente();
}
