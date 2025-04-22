package p4tex.p4utils;

/**
 * Programação IV (C) 2001
 * Interface que descreve o funcionamento de um iterador simples.
 *
 * @author J. Magno e V. Carreira
 * @version 1.0
 */
public interface Iterador {
    /**	Excepção propagada quando se acede a elemento inválido.   */
    public static final java.util.NoSuchElementException
        ELEMENTO_INVALIDO = new java.util.NoSuchElementException();

    /**	Verifica se pode avancar para o proximo elemento.
            @return true caso ainda existam elementos a percorrer;
            false caso contrário	*/
    public boolean podeAvancar();

    /**	Devolve o próximo elemento.
            Caso não exista lança a excepção ELEMENTO_INVALIDO
            @return o próximo elemento   */
    public Object avancar();

    /**	Coloca o iterador no nó inicial da lista   */
    public void reiniciar();

    /**	Devolve o elemento actual.
            Caso não exista lança a excepção ELEMENTO_INVALIDO
            @return o elemento actual   */
    public Object corrente();
}
