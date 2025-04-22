/**
 * 
 */
package cusco;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

import bud.exceptions.LogoutFailedException;
import bud.exceptions.ServerErrorException;
import bud.exceptions.WrongServerMessage;
import bud.exceptions.WrongServerWelcomeException;

/**
 * @author Knitter
 *
 */
public class LogoutClient {
	
	public LogoutClient(String sessionid, InetSocketAddress securitas) throws LogoutFailedException, 
	WrongServerWelcomeException, WrongServerMessage, ServerErrorException {
		
		BufferedReader in = null;
		BufferedWriter out = null;
		String line = null;
		Socket conn = null;
		
		try {
			conn = new Socket(securitas.getAddress(), securitas.getPort());
			in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
			
			if(!in.readLine().endsWith("OK"))
				throw new WrongServerWelcomeException("Mensagem de boas vindas invalida");
			
			out.write("LOGOUT\r\n");
			out.write("SESSID|" + sessionid + "\r\n");
			out.flush();
			
			if((line = in.readLine()).equals("LOGOUT_FAILED"))
				throw new LogoutFailedException("Falha no logout");
			
			if(!line.equals("SUCCESS"))
				throw new WrongServerMessage("Mensagem desconhecida ao efectuar logout");
			
		} catch (IOException e) {
			throw new ServerErrorException("Erro na ligacao ao servidor de autenticacao");
		} finally {
			try {
				if(conn != null) {
					conn.close();
					conn = null;
				}
		
				if(in != null) {
					in.close();
					in = null;
				}
				if(out != null) {
					out.close();
					out = null;
				}
			} catch (IOException e) {
				//ignore
			} 
		}
	}
}
