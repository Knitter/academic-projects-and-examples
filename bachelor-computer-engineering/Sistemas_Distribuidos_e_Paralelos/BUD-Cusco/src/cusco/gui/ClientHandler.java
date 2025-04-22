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
 * Interface que define as operações invocadas pela interface gráfica. A 
 * implementação destes métodos fica a cargo do cliente.
 * 
 * @author	<a href="mailto:vitor.carreira@gmail.com">Vitor Carreira</a>
 * @version 1.0
 * 
 * $Revision$
 * $Date$
 */
public interface ClientHandler {
	/**
	 * Método chamado pela interface gráfica quando o cliente clica em Pesquisar.
	 * O método termina quando a operação de pesquisar for considerada concluída.
	 * 
	 * @param login login de acesso ao serviço Securitas
	 * @param password senha de acesso ao serviço Securitas
	 * @param pattern padrão a pesquisar
	 * @param securitas localização do serviço "Securitas" (ip + porto)
	 * @param servers array com a localização dos serviços "Buscas" (ip+porto)
	 */
	public void search(String login, String password, String pattern, 
			InetSocketAddress securitas, InetSocketAddress[] servers, boolean useRegex);

	/**
	 * Método chamado quando o cliente pretende interromper a operação de pesquisa.
	 */
	public void stop();

	
	/**
	 * Método chamado quando o cliente pretende sair.
	 */
	public void close();
}
