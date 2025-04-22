/*
 * 4ª etapa do trabalho de SDP
 * Autor: Sérgio Lopes, ei10635
 */
package rmi;

import java.net.InetSocketAddress;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Interface que define os metodos disponiveis remotamente pelo Cusco
 * 
 * @author Knitter
 *
 */
public interface CuscoServices extends Remote {
	
	/**
	 * Metodo que permite iniciar uma pesquisa
	 * 
	 * @param login Utilizador que pretende efectuar a pesquisa
	 * @param password Palavra-chave do utilizador
	 * @param pattern Padrao de pesquisa
	 * @param securitas IP do servidor securitas
	 * @param servers Conjinto de maquinas onde sera efectuada a pesquisa
	 * @param useRegex Indica se sera usado o suporta para expressoes regulares
	 * @param n Objecto que pretende obter notificacao dos progressos da pesquisa
	 * @throws RemoteException
	 */
	void search(String login, String password, String pattern, 
			InetSocketAddress securitas, InetSocketAddress[] servers, boolean useRegex, Notifiable n) throws RemoteException;
	
	/**
	 * Metodo invocado pelo cliente para parar a pesquisa
	 * 
	 * @throws RemoteException
	 */
	void stop() throws RemoteException;
	
	/**
	 * Metodo invocado pelo cliente para indicar que este foi fechado
	 * 
	 * @throws RemoteException
	 */
	void close() throws RemoteException;
}
