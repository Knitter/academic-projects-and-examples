/*
 * 4ª etapa do trabalho de SDP
 * Autor: Sérgio Lopes, ei10635
 */
package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

import cusco.gui.FileInfo;

/**
 * Interface que define a forma de comunicacao com os objectos que pretendem ser notificados 
 * dos eventos gerados pelo pedido de pesquisa.
 * 
 * @author Knitter
 *
 */
public interface Notifiable extends Remote {

	/**
	 * Metodo invocado pelo servidor para enviar mensagens de erro aos clientes
	 * 
	 * @param title Tipo de erro
	 * @param message Mensagem de erro
	 * @throws RemoteException
	 */
	void errorMessage(String title, String message) throws RemoteException;
	
	/**
	 * Metodo invocado pelo servidor para enviara mensagens informativas aos clientes
	 * 
	 * @param message Mensagem a mostrar
	 * @throws RemoteException
	 */
	void infoMessage(String message)throws RemoteException;
	
	/**
	 * Metodo invocado pelo servidor sempre que for encontrado um elemento que satisfaca a pesquisa
	 * 
	 * @param entry Elemento encontrado
	 * @throws RemoteException
	 */
	void foundItem(FileInfo entry)throws RemoteException;
	
	/**
	 * Metodo invocado para indicar o fim da pesquisa
	 * 
	 * @throws RemoteException
	 */
	void searchFinished() throws RemoteException;
}
