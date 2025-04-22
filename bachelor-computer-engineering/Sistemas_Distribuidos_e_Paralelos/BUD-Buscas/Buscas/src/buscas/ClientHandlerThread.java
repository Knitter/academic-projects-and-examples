package buscas;

import bud.exceptions.AccessDeniedException;
import bud.exceptions.ClientWithoutServerException;
import bud.exceptions.NullOutputStreamException;
import bud.exceptions.ServerErrorException;
import bud.exceptions.SessionExpiredException;
import bud.exceptions.SessionIDFormatException;
import bud.exceptions.WrongClientMessage;
import bud.exceptions.WrongFoldersNumber;
import bud.exceptions.WrongServerMessage;
import bud.exceptions.WrongServerWelcomeException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.GregorianCalendar;

/**
 * Entidade responsavel por receber e tratar o pedidos dos varios clientes.
 * 
 * @author  Knitter
 */
public class ClientHandlerThread extends Thread implements SearchOwner{
	
	private static final int TIMEOUT = 10000;
	private static final int SEARCH_TIMEOUT = 1000;
	
	private ServerSocket connection;
	private boolean stopedByUser = false;
	private boolean finished = false;
	private boolean deathHasArrived = false;
	private Scanner scanner;
	private BufferedReader in = null;
	private BufferedWriter out = null;
	private String ipSecuritas;
	private int portoSecuritas;
	private Server playgraound;
	
	/**
	 * Construtor que permite iniciar os valores a serem usados pela execucao da thread
	 * 
	 * @param playground Servidor onde esta thread se encontra a correr.
	 * @param conn Socket de servidor onde serao esperadas ligacoes a tratar.
	 * @param ipSecuritas IP do servico <em>Securitas<em>.
	 * @param portoSecuritas Porto do servico <em>Securitas<em>.
	 * 
	 * @throws ClientWithoutServerException
	 * 								      Caso o servidor passado seja nulo.
	 */
	public ClientHandlerThread(Server playground, ServerSocket conn, String ipSecuritas, int portoSecuritas) {
		connection = conn;
		this.ipSecuritas = ipSecuritas;
		this.portoSecuritas = portoSecuritas;
		if(playground == null)
			throw new ClientWithoutServerException();
		this.playgraound = playground;
	}
	
	/**
	 * Metodo a execuar pela thread.
	 */
	public void run() {
		Socket client = null;
		while(!deathHasArrived) {//we're feeling very very happy today!
			try {
				client = connection.accept();
				clientHandler(client);
			} catch(NullPointerException e) {
				System.err.println("NullPointerException, cliente fechado abruptamente");
			}catch (IOException e) {
				System.err.println("IOException, falha ao tentar aceitar a ligacao");
			} catch (SessionIDFormatException e) {
				try {
					out.write("INVALID_SESSIONID\r\n");
					out.flush();
				} catch (IOException e1) {
					System.err.println("IOException, impossivel comunicar com o cliente");
				}			
			} catch (WrongClientMessage e) {
				try {
					out.write("WRONG_MESSAGE\r\n");
					out.flush();
				} catch (IOException e1) {
					System.err.println("IOException, impossivel comunicar com o cliente");
				}
			} finally {
				if(in != null)
					try {
						in.close();
						in = null;
					} catch (IOException e1) {
						System.err.println("IOException, impossivel fechar stream de leitura");
					}
					
					if(out != null)
						try {
							out.close();
							out = null;
						} catch (IOException e) {
							System.err.println("IOException, impossivel fechar stream de escrita");
						}
			}
		}
	}
	
	/**
	 * Permite tratar a comunicacao com os clientes.
	 * O metodo cumpre o protocolo definido para a comunicacao com o servico <em>Buscas<em>.
	 * 
	 * @param clientConn Socket de comunicacao com o cliente.
	 * 
	 * @throws SessionIDFormatException
	 * 									Caso o identificador da sessao nao cumpra a formatacao esperada.
	 * @throws WrongClientMessage
	 * 									Caso o cliente envie mensagens que nao respeitem o protocolo.
	 */
	private void clientHandler(Socket clientConn) throws SessionIDFormatException, WrongClientMessage {
		String line;
		
		try {
			clientConn.setSoTimeout(TIMEOUT);
			playgraound.entering();
			out = new BufferedWriter(new OutputStreamWriter(clientConn.getOutputStream()));
			out.write("Bem vindo ao Buscas. Ligacao OK\r\n");
			out.flush();
			
			in = new BufferedReader(new InputStreamReader(clientConn.getInputStream()));
	
			if(!(line = in.readLine()).matches("SESSIONID\\|.{8}:.{8}"))//remover os 8's!relativo ao sizeof de int em C
				throw new SessionIDFormatException("Formato de sessao invalido, recebido " + line);
			
			String mix[] = line.split("\\|");
			
			AuthorizationClient client = new AuthorizationClient(ipSecuritas, portoSecuritas, mix[1]);
			String folders[] = client.getFolders();
			client = null;
			out.write("FOLDERS_OK\r\n");
			out.flush();
			
			if(!(line = in.readLine()).matches("PATTERN\\|.+\\|(true|false)"))
				throw new WrongClientMessage("Cliente enviou " + line + " quando era esperado padrao de pesquisa");
			
			mix = line.split("\\|");
			scanner = new Scanner(this, mix[1], folders, Boolean.parseBoolean(mix[2]));
			scanner.start();
			
			clientConn.setSoTimeout(SEARCH_TIMEOUT);//reduce timeout to be used for thread control
													//on bit out of my grasp
			while(!stopedByUser && !finished) { 
				try {
					if((line = in.readLine()).equals("STOP")) {
						stopedByUser = true;
						scanner.stopSearch();
					}
				} catch(SocketTimeoutException e) {
					//ignore
				}
			}
			
			if(stopedByUser)
				out.write("SCAN_STOPED_BY_USER\r\n");
			
			out.flush();
			
		} catch(SocketTimeoutException e) {
			System.err.println("Timeout de ligacao buscas-cusco");
		} catch (IOException e) {
			System.err.println("IOException, impossivel comunicar com o cliente");
		} catch (SessionExpiredException e) {
			try {
				out.write("SESSION_EXPIRED\r\n");
				out.flush();
				System.err.println(e.getMessage());
			} catch (IOException e1) {
				System.err.println("IOException, impossivel comunicar com o cliente");
			}
		} catch (AccessDeniedException e) {
			try {
				out.write("ACCESS_DENIED\r\n");
				out.flush();
				System.err.println(e.getMessage());
			} catch (IOException e1) {
				System.err.println("IOException, impossivel comunicar com o cliente");	
			}
		} catch (WrongServerWelcomeException e) {
			try {
				out.write("AUTHORIZATION_SERVER_ERROR\r\n");
				out.flush();
				System.err.println(e.getMessage());
			} catch (IOException e1) {
				System.err.println("IOException, impossivel comunicar com o cliente");
			}
		} catch (WrongServerMessage e) {
			try {
				out.write("AUTHORIZATION_SERVER_ERROR\r\n");
				out.flush();
				System.err.println(e.getMessage());
			} catch (IOException e1) {
				System.err.println("IOException, impossivel comunicar com o cliente");
			}
		} catch (WrongFoldersNumber e) {
			try {
				out.write("AUTHORIZATION_SERVER_ERROR\r\n");
				out.flush();
				System.err.println(e.getMessage());
			} catch (IOException e1) {
				System.err.println("IOException, impossivel comunicar com o cliente");
			}
		} catch (ServerErrorException e) {
			try {
				out.write("AUTHORIZATION_SERVER_ERROR\r\n");
				out.flush();
				System.err.println(e.getMessage());
			} catch (IOException e1) {
				System.err.println("IOException, impossivel comunicar com o cliente");
			}
		} finally {
			deathHasArrived = playgraound.leaving(this);
			System.err.println("Death:" + deathHasArrived);
			System.err.println("Active count: "+ Thread.activeCount());
		}
	}
	/**
	 * Implementacao dos metodos da interface <code>SearchOwner</code>.
	 */
	public void result(File result) {
		try {			
			GregorianCalendar g = new GregorianCalendar();
			g.setTimeInMillis(result.lastModified());
			String date = g.get(GregorianCalendar.DAY_OF_MONTH) + "/" + g.get(GregorianCalendar.MONTH) + "/" 
			+ g.get(GregorianCalendar.YEAR) + ";" + g.get(GregorianCalendar.HOUR_OF_DAY) + ":" 
			+ g.get(GregorianCalendar.MINUTE) + ":" + g.get(GregorianCalendar.SECOND);
			
			String mesg = "FOUND|" + result.getAbsolutePath() + "|" + date + "|" + Long.toString(result.length()) + 
			"|" + (result.isDirectory()?"true":"false") + "\r\n";
			
			out.write(mesg);
			out.flush();
		} catch (IOException e) {
			System.err.println("IOException, impossivel enviar resultado de pesquisa ao cliente");
		}	
	}
	
	/**
	 * Implementacao dos metodos da interface <code>SearchOwner</code>.
	 * @see SearchOwner
	 */
	public void searchFinished() throws NullOutputStreamException {
		if(out == null)
			throw new NullOutputStreamException();
		finished = true;
		try {
			out.write("SCAN_FINISHED\r\n");
			out.flush();
		} catch (IOException e) {
			System.err.println("IOException, impossivel escrever SCAN_FINISHED para o cliente");
		}
	}
}
