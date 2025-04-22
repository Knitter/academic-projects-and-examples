package buscas;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.UnknownHostException;


/**
 * Entidade que representa o servidor hibrido.
 * 
 * @author Knitter
 */
public class Server {
	
	private static final int MINTHREADS = 2;
	private static final int BACKLOG = 50;
	
	private ServerSocket server;
	private int threadOcupadas = 0;
	private int threadLivres = 0;
	private int threadNr = 0;
	private int threadMin;
	private int threadMax;
	private String ipSecuritas;
	private int portoSecuritas;
	
	/**
	 * Permite criar um servidor definindo o ip e porto do servico <em>Securitas<em>, um porto local e um numero 
	 * maximo de thread a executar no servidor.
	 * 
	 * @param ipSecuritas IP do servico <em>Securitas<em>.
	 * @param portoSecuritas Porto de escuta remoto do servico <em>Securitas<em>.
	 * @param porto Porto local onde ficara registado o servico <em>Buscas<em>.
	 * @param threadMax Numero maximo de threads a excutar no servidor. Este sera o numero 
	 * maximo de clientes que poderam ser tratados em simultaneo pelo servidor.
	 */
	public Server(String ipSecuritas, int portoSecuritas,int porto, int threadMax) {
		this(ipSecuritas, portoSecuritas, porto, (MINTHREADS < threadMax ? MINTHREADS : threadMax), threadMax);
	}
	
	/**
	 * Permite criar um servidor definindo o ip e porto do servico <em>Securitas<em>, um porto local, um numero minimo e  
	 * maximo de thread a executar no servidor.<br>
	 * Este contrutor e' utilizado por todos os outros.
	 * 
	 * @param ipSecuritas IP do servico <em>Securitas<em>.
	 * @param portoSecuritas Porto de escuta remoto do servico <em>Securitas<em>.
	 * @param porto Porto local onde ficara registado o servico <em>Buscas<em>.
	 * @param threadMin Numero minimo de threads a excutar no servidor.
	 * @param threadMax Numero maximo de threads a excutar no servidor. Este sera o numero 
	 * maximo de clientes que poderam ser tratados em simultaneo pelo servidor.
	 */
	public Server(String ipSecuritas, int portoSecuritas, int porto, int threadMin, int threadMax) {
		threadNr = threadLivres = this.threadMin = threadMin;
		this.threadMax =	threadMax;
		this.ipSecuritas = ipSecuritas;
		this.portoSecuritas = portoSecuritas;
		
		try {
			server = new ServerSocket(porto, BACKLOG, InetAddress.getByName("localhost"));
		} catch (UnknownHostException e) {
			System.err.println("UnknownHostException, impossivel criar socket de servidor");
			System.exit(-1);
		} catch (IOException e) {
			System.err.println("IOException, impossivel criar socket de servidor");
			System.exit(-2);
		}
		
		for(int z = 0; z < threadMin; z++)
			new ClientHandlerThread(this, server, ipSecuritas, portoSecuritas).start();
	}
	
	/**
	 * Metodo invocado pela thread que trata o cliente para indicar que esta se encontra
	 * ocupada a tratar um cliente permitindo assim ao servidor manter um registo do numero de
	 * livres e ocupadas.
	 *  
	 */
	synchronized public void entering() {
		System.err.println("Entering\nlivres/ocupadas antes: " + threadLivres + "/" + threadOcupadas);
		if(threadLivres == 0 && threadNr >= threadMin && threadNr < threadMax) {
			new ClientHandlerThread(this, server, ipSecuritas, portoSecuritas).start();
			threadNr++;
			threadLivres++;
			System.err.println("Criar thread");
		}
		threadLivres--;
		threadOcupadas++;
		System.err.println("livres/ocupadas depois: " + threadLivres + "/" + threadOcupadas);
		
	}
	
	/**
	 * Metodo invocado pela thread que trata o cliente para indicar que esta se encontra
	 * livre para tratar outros clientes permitindo assim ao servidor manter um registo do numero de
	 * livres e ocupadas.<br>
	 * Caso a thread nao seja necessaria o servidor indica que esta pode terminar a sua execucao.
	 * 
	 * @param player ClientHandlerThread que terminou o processamento de pedidos.
	 * @return boolean que indica se a thread pode terminar a sua execucao ou se devera continuar 'a espera de novos
	 * pedidos de clientes.
	 */
	synchronized  public boolean leaving(ClientHandlerThread player) {//every bit counts on this one
		System.err.println("Leaving\nlivres/ocupadas antes: " + threadLivres + "/" + threadOcupadas);
		if(threadLivres == 0 && threadOcupadas == threadMax) {
			threadLivres++;
			threadOcupadas--;
			return false;
		}
		else
			if(threadLivres != 0 && threadNr > threadMin) {
				threadOcupadas--;
				threadNr--;
				return true;
			}
		
		return false;
	}
}
