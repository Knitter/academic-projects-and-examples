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
import cusco.gui.ClientHandler;
import cusco.gui.FileInfo;
import cusco.gui.GUIHandler;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.GregorianCalendar;

/**
 * Aplicacao cliente - Cusco. Implementa a interface ClientHandler. C�digo a alterar pelos alunos.
 * @author  	<a href="mailto:vitor.carreira@gmail.com">Vitor Carreira</a>
 * @version  1.0  $Revision$  $Date$
 */
public class Cusco implements ClientHandler {
	
	// Acesso ao interface gr�fico
	private GUIHandler gui;;
	
	private static final int TIMEOUT = 15000;
	private static final int SEARCH_TIMEOUT = 25000; 
	private boolean running = true;
	private BufferedReader in = null;
	private BufferedWriter out = null;
	private String sessionId = null;
	private InetSocketAddress securitas = null;
	
	/**
	 * Constroi uma inst�ncia do cliente.
	 * @param gui interface para o cliente
	 */
	public Cusco(GUIHandler gui) {
		this.gui = gui;
	}
	
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
			InetSocketAddress securitas, InetSocketAddress[] servers, boolean useRegex) {
		
		AutenticationClient autentication = null;
		
		this.securitas = securitas;
		
		try {
			autentication = new AutenticationClient(login, password, securitas);
			if(autentication == null) {
				gui.showErrorMessage("Erro na Autenticacao", "Autenticacao falhou\nImpossivel obter identificador da sessao");
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
					gui.showErrorMessage("Erro no Buscas", "Erro de comunicacao com o servidor de buscas");
					continue;
				}
				
				out = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
				out.write("SESSIONID|" + sessionId + "\r\n");
				out.flush();
				
				if(!(line = in.readLine()).equals("FOLDERS_OK")) {
					if( line.equals("INVALID_SESSION")) {
						gui.showErrorMessage("Erro na autenticacao", "Sessao invalida");
						continue;
					}
					
					if(line.equals("AUTHORIZATION_SERVER_ERROR")) {
						gui.showErrorMessage("Erro na autenticacao", "Erro no servidor de autenticacao");
						continue;
					}
					
					if(line.equals("ACCESS_DENIED")) {
						gui.showErrorMessage("Erro na autenticacao", "Acesso negado");
						continue;
					}
					
					if(line.equals("WRONG_MESSAGE")) {
						gui.showErrorMessage("Erro de comunicacao", "Erro no servidor de Buscas");
						continue;
					}
					
					gui.showErrorMessage("Erro", "Erro desconhecido");
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
						gui.showErrorMessage("Erro de Comunicacao", "Informacoes do ficheiro nao correspondem ao protocolo");
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
						gui.addFileEntry(info);
				}
				
				/* Fechar socket no fim do tratamento do servidor */
				conn.close();
				in.close();
				out.close();
				in = null;
				out = null;
			}
			if(z == servers.length && running)
				gui.showInfoMessage("Pesquisa terminada com sucesso");
			
		} catch (SocketTimeoutException e) {
			gui.showErrorMessage("Erro de timeout", "Servidor de buscas nao respondeu a tempo");
		} catch (IOException e) {
			gui.showErrorMessage("Erro", "Erro de I/O");
		} catch (WrongServerWelcomeException e) {
			gui.showErrorMessage("Erro do servidor", "Erro na comunicacao com o servidor de buscas");
		} catch (LoginFailedException e) {
			gui.showErrorMessage("Erro de autenticacao", "Login falhou");
		} catch (ServerErrorException e) {
			gui.showErrorMessage("Erro de autenticacao", "Erro de comunicacao com o servidor de autenticacao");
		} catch (WrongServerMessage e) {
			gui.showErrorMessage("Erro de autenticacao", "Erro ao obter o identificar de sessao");
		} finally {
			if(autentication != null)
				try {
					if(autentication != null)
						new LogoutClient(sessionId, securitas);
				} catch (LogoutFailedException e) {
					gui.showErrorMessage("Erro de logout", "Logout falhou");
				} catch (WrongServerWelcomeException e) {
					gui.showErrorMessage("Erro de logout", "Erro na comunicacao com o servidor de autenticacao");
				} catch (WrongServerMessage e) {
					gui.showErrorMessage("Erro de logout", "Erro na comunicacao com o servidor de autenticacao");
				} catch (ServerErrorException e) {
					gui.showErrorMessage("Erro de logout", "Erro na comunicacao com o servidor de autenticacao");
				}
		}
	}
	
	/**
	 * M�todo chamado quando na interface gr�fica se interrompe a opera��o de 
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
	 * M�todo chamado quando a interface gr�fica termina.
	 */
	public void close() {
		stop();
	}
}
