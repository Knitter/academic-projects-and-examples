/* 
 * Project: 	Trabalho Pratico SDP
 * File:		ClientHandler.java
 * Created on:	11/Abr/2005
 * Description:	
 *
 * (C)2005 Vitor Carreira
 */
package cusco.gui;

import java.net.InetSocketAddress;


/**
 * Interface que define as opera��es invocadas pela interface gr�fica. A 
 * implementa��o destes m�todos fica a cargo do cliente.
 * 
 * @author	<a href="mailto:vitor.carreira@gmail.com">Vitor Carreira</a>
 * @version 1.0
 * 
 * $Revision$
 * $Date$
 */
public interface ClientHandler {
	/**
	 * M�todo chamado pela interface gr�fica quando o cliente clica em Pesquisar.
	 * O m�todo termina quando a opera��o de pesquisar for considerada conclu�da.
	 * 
	 * @param login login de acesso ao servi�o Securitas
	 * @param password senha de acesso ao servi�o Securitas
	 * @param pattern padr�o a pesquisar
	 * @param securitas localiza��o do servi�o "Securitas" (ip + porto)
	 * @param servers array com a localiza��o dos servi�os "Buscas" (ip+porto)
	 */
	public void search(String login, String password, String pattern, 
			InetSocketAddress securitas, InetSocketAddress[] servers, boolean useRegex);

	/**
	 * M�todo chamado quando o cliente pretende interromper a opera��o de pesquisa.
	 */
	public void stop();

	
	/**
	 * M�todo chamado quando o cliente pretende sair.
	 */
	public void close();
}
