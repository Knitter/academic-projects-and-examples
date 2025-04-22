/**
 * 
 */
package cusco;

import bud.exceptions.LoginFailedException;
import bud.exceptions.ServerErrorException;
import bud.exceptions.WrongServerMessage;
import bud.exceptions.WrongServerWelcomeException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;


/**
 * @author  Knitter
 */
public class AutenticationClient {
	
	String sessionId;
	Socket conn = null;
	
	public AutenticationClient(String login, String password, InetSocketAddress securitas) 
		throws WrongServerWelcomeException, LoginFailedException, ServerErrorException, WrongServerMessage {
		
		BufferedReader in = null;
		BufferedWriter out = null;
		String line = null;
		
		try {
			conn = new Socket(securitas.getAddress(), securitas.getPort());
			in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
			
			if(!in.readLine().endsWith("OK"))
				throw new WrongServerWelcomeException("Mensagem de boas vindas invalida");
			
			out.write("AUTENTICACAO\r\n");
			out.write("LOGIN|" + login + "\r\n");
			out.write("PASW|" + password + "\r\n");
			out.flush();
			
			if((line = in.readLine()).equals("LOGIN_FAILED"))
				throw new LoginFailedException("Falha no login");
			
			if(!line.matches("SESSIONID\\|.+:.+"))
				throw new WrongServerMessage("Servidor securitas enviou identificador de sessao invalido");
			
			sessionId = line.substring(10);
			
		} catch (IOException e) {
			throw new ServerErrorException("Falha de IO na comunicacao com o servidor de autenticacao");
		}
	}
	
	/**
	 * @return  Returns the sessionId.
	 * @uml.property  name="sessionId"
	 */
	public String getSessionId() {
		return sessionId;
	}

}
