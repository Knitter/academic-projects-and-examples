/**
 * 
 */
package buscas;

import bud.exceptions.AccessDeniedException;
import bud.exceptions.ServerErrorException;
import bud.exceptions.SessionExpiredException;
import bud.exceptions.WrongFoldersNumber;
import bud.exceptions.WrongServerMessage;
import bud.exceptions.WrongServerWelcomeException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;


/**
 * Uma instancia de AuthorizationClient e' responsavel pelo pedido de autorizacao ao servico
 * <em>Securitas<em>.<br>Apos a criacao com sucesso do objecto e' possivel obter as pastas atraves do 
 * metodo <code>getFolders()</code>.
 * 
 * @author  Knitter
 */
public class AuthorizationClient {
	
	private static final int TIMEOUT = 3000;
	
	private Socket openToSecuritas;
	private String folders[];
	private String line;
	
	/**
	 * Controi um objecto que, caso a autorizacao se termine com sucesso, contera as pastas 
	 * onde podem ser feitas as pesquisas para a sessao indicada.
	 * 
	 * @param ipSecuritas String representativa do ip onde se encontra o servidor de autorizacao.
	 * @param portoSecuritas Porto onde se encontra o servidor de autorizacao.
	 * @param sessionID Identificador da sessao obtido numa autenticacao anterior.
	 * 
	 * @throws ServerErrorException 
	 *         No caso da comunicacao com o servidor de autenticacao falhar.
	 */
	public AuthorizationClient(String ipSecuritas, int portoSecuritas, String sessionID) 
	throws SessionExpiredException, AccessDeniedException, WrongServerWelcomeException, 
	WrongServerMessage,	WrongFoldersNumber, ServerErrorException {
		
		BufferedReader in = null;
		BufferedWriter out = null;
		try {
			openToSecuritas = new Socket(InetAddress.getByName(ipSecuritas), portoSecuritas);	
			
			in = new BufferedReader(new InputStreamReader(openToSecuritas.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(openToSecuritas.getOutputStream()));
			
			openToSecuritas.setSoTimeout(TIMEOUT);
			if(!in.readLine().endsWith("OK"))
				throw new WrongServerWelcomeException("Securitas nao enviou mensagem de boas-vindas correcta");
			
			out.write("AUTORIZACAO\r\n");
			out.flush();
			out.write("SESSIONID|"+ sessionID + "\r\n");
			out.flush();
			
			if((line = in.readLine()).equals("SESSION_EXPIRED"))
				throw new SessionExpiredException("Sessao enviada expirou");
			else
				if(line.equals("ACCESS_DENIED"))
					throw new AccessDeniedException("Acesso negado");
			
			if(!line.matches("FOLDERS\\|\\d+"))
				throw new WrongServerMessage("Servidor enviou " + line + " quando era esperado o nr de pastas");
			
			String nrMessage[] = line.split("\\|");
			int folderNr = Integer.parseInt(nrMessage[1]);
			
			int count  = 0;
			folders = new String[folderNr];
			String mix[];
			
			while(!(line = in.readLine()).equals("END_FOLDERS") && count < folderNr) {
				if(!line.matches("F\\d+\\|.+"))
					throw new WrongServerMessage("Servidor enviou " + line + " quando era esperada uma pasta");
				mix = line.split("\\|");
				folders[count++] = mix[1];
			}
			
			if((!line.equals("END_FOLDERS") && count == folderNr) || (line.equals("END_FOLDERS") && count != folderNr))
				throw new WrongFoldersNumber("Numero de pastas enviadas nao corresponde ao especificado");
			
		} catch(SocketTimeoutException e) {
			System.err.println("Timeout de ligacao buscas-securitas");
		}catch (UnknownHostException e) {
			throw new ServerErrorException("Servidor de autenticacao desconhecido");
		} catch (IOException e) {
			throw new ServerErrorException("Falha de IO na comunicacao com o servidor de autenticacao");
		} finally {
			if(in != null)
				try {
					in.close();
				} catch (IOException e) {
					System.err.println("IOException, impossivel fechar stream de leitura");
				}
				if(out != null)
					try {
						out.close();
					} catch (IOException e) {
						System.err.println("IOException, impossivel fechar stream de escrita");
					}	
		}
	}
	
	/**
	 * Permite obter as pastas onde sera possivel efectuar pesquisas.
	 * 
	 * @return  Uma copia defensiva do vector de pastas.
	 * @uml.property  name="folders"
	 */
	public String[] getFolders() {//two bits towards paranoia
		if(folders == null)
			return null;
		String[] copy = new String[folders.length];
		for(int z = 0; z < folders.length; z++)
			copy[z] = new String(folders[z]);
		return copy;
	}
	
}
