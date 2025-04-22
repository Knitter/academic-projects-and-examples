/*
 * 4ª etapa do trabalho de SDP
 * Autor: Sérgio Lopes, ei10635
 */
package rmi;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;

import cusco.Cusco;


/**
 * Servidor RMI. Responsavel por tornar disponivel o objecto remoto Cusco.
 * @author Knitter
 *
 */
public class ServerRMI {

	/**
	 * Nao faz entido criar instancias de ServerRMI
	 */
	private ServerRMI() {
		super();
	}

	/**
	 * Metodo main
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			CuscoServices cusco = new Cusco();
			Naming.bind("/ei10635", cusco);
		} catch (RemoteException e) {
			System.err.println(e.getMessage());
		} catch (MalformedURLException e) {
			System.err.println(e.getMessage());
		} catch (AlreadyBoundException e) {
			System.err.println(e.getMessage());
		}
	}

}
