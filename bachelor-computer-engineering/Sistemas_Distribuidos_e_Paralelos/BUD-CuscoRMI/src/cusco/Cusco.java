/* 
 * Project: 	Trabalho Pratico SDP
 * File:		Cusco.java
 * Created on:	11/Abr/2005
 * Description:	
 *
 * (C)2005 Vitor Carreira
 */
package cusco;

import bud.exceptions.LoginFailedException;
import bud.exceptions.LogoutFailedException;
import bud.exceptions.ServerErrorException;
import bud.exceptions.WrongServerMessage;
import bud.exceptions.WrongServerWelcomeException;
import cusco.gui.FileInfo;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.GregorianCalendar;
import rmi.CuscoServices;
import rmi.Notifiable;

/**
 * Aplicacao cliente - Cusco. Implementa a interface CuscoServices.
 * @author   	<a href="mailto:vitor.carreira@gmail.com">Vitor Carreira</a>
 * @version   1.0  $Revision$  $Date$
 */
public class Cusco extends UnicastRemoteObject implements CuscoServices {
	
	private static final int TIMEOUT = 15000;
	private static final int SEARCH_TIMEOUT = 25000; 
	private boolean running = true;
	private BufferedReader in = null;
	private BufferedWriter out = null;
	private String sessionId = null;
	
	private Notifiable notify;
	/**
	 * Constroi uma instância do cliente.
	 * @param gui interface para o cliente
	 */
	public Cusco() throws RemoteException {
		super();
	}
	
	
	
	/**
	 * Método chamado pela interface gráfica quando o cliente clica em Pesquisar.
	 * O método termina quando a operação de pesquisar for considerada concluída.
	 * 
	 * @param login login de acesso ao serviço Securitas
	 * @param password senha de acesso ao serviço Securitas
	 * @param pattern padrão a pesquisar
	 * @param securitas localização do serviço "Securitas" (ip + porto)
	 * @param servers array com a localização dos serviços "Buscas" (ip+porto) 
	 * @param useRegex "booleano" que indica se a pesquisa utilizara ou nao expressoes regulares
	 * @param n objecto remoto que pretende receber os resultados da pesquisa que invocou. 
	 * 			Cliente que invovou o metodo remoto de pesquisa.
	 */
	
	public void search(String login, String password, String pattern, 
			InetSocketAddress securitas, InetSocketAddress[] servers, boolean useRegex, Notifiable n) throws RemoteException {
		if(n == null)
			throw new IllegalArgumentException();
		notify = n;
		search(login, password, pattern, securitas, servers, useRegex);
	}
	
	private void search(String login, String password, String pattern, 
			InetSocketAddress securitas, InetSocketAddress[] servers, boolean useRegex) throws RemoteException {
		
		AutenticationClient autentication = null;
		
		try {
			autentication = new AutenticationClient(login, password, securitas);
			if(autentication == null) {
				notify.errorMessage("Erro na Autenticacao", "Autenticacao falhou\nImpossivel obter identificador da sessao");
				return;
			}
			
			sessionId = autentication.getSessionId();
			
			String line = null;
			Socket conn = null;
			
			int z = 0;
			for(; z < servers.length && running; z++) {
				
				conn = new Socket(servers[z].getAddress(), servers[z].getPort());
				conn.setSoTimeout(TIMEOUT);
				
				in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				if(!in.readLine().endsWith("OK")) {
					notify.errorMessage("Erro no Buscas", "Erro de comunicacao com o servidor de buscas");
					continue;
				}
				
				out = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
				out.write("SESSIONID|" + sessionId + "\r\n");
				out.flush();
				
				if(!(line = in.readLine()).equals("FOLDERS_OK")) {
					if( line.equals("INVALID_SESSION")) {
						notify.errorMessage("Erro na autenticacao", "Sessao invalida");
						continue;
					}
					
					if(line.equals("AUTHORIZATION_SERVER_ERROR")) {
						notify.errorMessage("Erro na autenticacao", "Erro no servidor de autenticacao");
						continue;
					}
					
					if(line.equals("ACCESS_DENIED")) {
						notify.errorMessage("Erro na autenticacao", "Acesso negado");
						continue;
					}
					
					if(line.equals("WRONG_MESSAGE")) {
						notify.errorMessage("Erro de comunicacao", "Erro no servidor de Buscas");
						continue;
					}
					
					notify.errorMessage("Erro", "Erro desconhecido");
					continue;
				}	
				
				out.write("PATTERN|" + pattern + "|" + String.valueOf(useRegex) + "\r\n");
				out.flush();
				
				conn.setSoTimeout(SEARCH_TIMEOUT);
				while(true) {//thread bloqueada!
					try {
						line = in.readLine();
					}catch (SocketTimeoutException e) {
						continue;
					}
					
					if(line.equals("SCAN_FINISHED") || line.equals("SCAN_STOPED_BY_USER")) {
						out.write("AKG\r\n");
						out.flush();
						break;
					}
					
					if(!line.matches("FOUND\\|.+\\|\\d+/\\d+/\\d+;\\d+:\\d+:\\d+\\|\\d+\\|(true|false)")) {
						notify.errorMessage("Erro de Comunicacao", "Informacoes do ficheiro nao correspondem ao protocolo");
						break;
					}
								
/* Componentes da mensagem depois de separadas
found[1] => caminho absoluto;found[2] => data longa ;found[3] => tamanho;found[4] => isDirectory
--
longDate[0] => dia/mes/ano;longDate[1] => hora:minuto:segundo
--
horas[0] => hora;horas[1] => minuto;horas[2] => segundo
--
shortDate[0] => dia;shortDate[1] => mes;shortDate[2] => ano
*/
					
					String []found = line.split("\\|");
					String []longDate = found[2].split(";");
					String []horas = longDate[1].split(":");
					String []shortDate = longDate[0].split("/");
					
					FileInfo info = null;
					
					GregorianCalendar g = new GregorianCalendar(Integer.parseInt(shortDate[2]), 
							Integer.parseInt(shortDate[1]), Integer.parseInt(shortDate[0]), 
							Integer.parseInt(horas[0]), Integer.parseInt(horas[1]), Integer.parseInt(horas[2]));
					
					if(Boolean.parseBoolean(found[4]))
						info = new FileInfo(found[1], g, servers[z].getAddress().getHostAddress());
					else
						info = new FileInfo(found[1], g, servers[z].getAddress().getHostAddress(), Long.parseLong(found[3]));
					
					if(info != null)
						notify.foundItem(info);
				}
				
				/* Fechar socket no fim do tratamento do servidor */
				conn.close();
				in.close();
				out.close();
				in = null;
				out = null;
			}
			if(z == servers.length && running)
				notify.infoMessage("Pesquisa terminada com sucesso");
			notify.searchFinished();
		} catch (SocketTimeoutException e) {
			notify.errorMessage("Erro de timeout", "Servidor de buscas nao respondeu a tempo");
		} catch (IOException e) {
			notify.errorMessage("Erro", "Erro de I/O");
		} catch (WrongServerWelcomeException e) {
			notify.errorMessage("Erro do servidor", "Erro na comunicacao com o servidor de buscas");
		} catch (LoginFailedException e) {
			notify.errorMessage("Erro de autenticacao", "Login falhou");
		} catch (ServerErrorException e) {
			notify.errorMessage("Erro de autenticacao", "Erro de comunicacao com o servidor de autenticacao");
		} catch (WrongServerMessage e) {
			notify.errorMessage("Erro de autenticacao", "Erro ao obter o identificar de sessao");
		} finally {
			if(autentication != null)
				try {
					if(autentication != null)
						new LogoutClient(sessionId, securitas);
				} catch (LogoutFailedException e) {
					notify.errorMessage("Erro de logout", "Logout falhou");
				} catch (WrongServerWelcomeException e) {
					notify.errorMessage("Erro de logout", "Erro na comunicacao com o servidor de autenticacao");
				} catch (WrongServerMessage e) {
					notify.errorMessage("Erro de logout", "Erro na comunicacao com o servidor de autenticacao");
				} catch (ServerErrorException e) {
					notify.errorMessage("Erro de logout", "Erro na comunicacao com o servidor de autenticacao");
				}
		}
	}
	
	/**
	 * Método chamado quando se pretende interromper a operação de 
	 * pesquisa.
	 */
	public void stop() {
		if(running && out != null) {
			try {
				out.write("STOP\r\n");
				out.flush();
			} catch (IOException e) {
				//ignore or not
			}
			running = false;
		}
	}
	
	/**
	 * Método chamado quando o cliente que invocou uma pesquisa termina.
	 */
	public void close() {
		stop();
	}
}
