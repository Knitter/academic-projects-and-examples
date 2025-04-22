package genx.listas;

public interface IteradorListaDupla extends Iterador
{
	/** Verifica se o objecto corrente n�o � o primeiro elemento */
	boolean podeRecuar();

	/** Devolve o objecto corrente e recua para o anterior
		@throws java.lang.NoSuchElementException caso n�o possa avancar
		@see #ELEMENTOINVALIDO
		@see #podeRecuar */
	Object recuar();
}
