package buscas;

import java.io.File;

import bud.exceptions.NullOutputStreamException;

/**
 * Representacao de objecto que disponibiliza o servico de pesquisa.<br>
 * Quando determinado objecto pretende iniciar uma thread de pesquisa deve
 * implementar interface <code>SearchOwner</code> de forma a que lhe possam ser 
 * comunicados os resultados encontrados e quando terminou a pesquisa pedida.
 * 
 * @author knitter
 */
public interface SearchOwner {
	
	/**
	 * Metodo que permite ao objecto que efectua a pesquisa reportar os resultados.
	 *  
	 * @param result Uma abstracao que representa o ficheiro encontrado
	 */
	void result(File result);
	
	/**
	 * Permite indicar que a pesquisa terminou.<br>
	 * 
	 * @throws NullOutputStreamException
	 *         Se a stream de escrita nao for valida.
	 */
	void searchFinished() throws NullOutputStreamException;
}
