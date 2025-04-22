/*
 * 4ª etapa do trabalho de SDP
 * Autor: Sérgio Lopes, ei10635
 */
package rmi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.Vector;

import com.martiansoftware.jsap.FlaggedOption;
import com.martiansoftware.jsap.JSAP;
import com.martiansoftware.jsap.JSAPException;
import com.martiansoftware.jsap.JSAPResult;
import com.martiansoftware.jsap.QualifiedSwitch;

import cusco.gui.FileInfo;

/**
 * Implementacao de um cliente rmi para o servico Cusco.
 * 
 * @author Knitter
 *
 */
public class ClientRMI implements Notifiable{
	
	private static Notifiable notify;
	
	/**
	 * Nao faz sentido permitir a criacao de objectos do tipo ClientRMI
	 */
	private ClientRMI() {
	}
	
	public void errorMessage(String title, String message) throws RemoteException {
		System.out.println(title + ": " + message);
		
	}
	
	public void infoMessage(String message) throws RemoteException {
		System.out.println(message);
		
	}
	
	public void foundItem(FileInfo entry) throws RemoteException {
		if(entry != null) {
			String mesgAlteracao = entry.lastModified.get(GregorianCalendar.DAY_OF_MONTH ) + "/" + 
			(entry.lastModified.get(GregorianCalendar.MONTH) + 1) + "/" + entry.lastModified.get(GregorianCalendar.YEAR) +
			" , " + entry.lastModified.get(GregorianCalendar.HOUR_OF_DAY) + ":" + 
			entry.lastModified.get(GregorianCalendar.MINUTE) + ":" + entry.lastModified.get(GregorianCalendar.SECOND);
			
			String message = "IP: " + entry.ip + "\n" + "Caminho Absoluto: " + entry.absolutePath + "\n" + 
			"Ultima Alteracao: " + mesgAlteracao + "\nTamanho: " + (entry.size < 0L ? "<DIR>" : String.valueOf(entry.size));
			
			System.out.println(message);
		}
	}
	
	public void searchFinished() throws RemoteException {
		UnicastRemoteObject.exportObject(notify);
		System.exit(0);//what!? Just leaving
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JSAP parser = new JSAP();
		
		FlaggedOption cusco = new FlaggedOption("cusco").setStringParser(JSAP.STRING_PARSER).setRequired(true).setShortFlag('c').setLongFlag("cusco");
		FlaggedOption login = new FlaggedOption("login").setStringParser(JSAP.STRING_PARSER).setRequired(true).setShortFlag('l').setLongFlag("login");
		FlaggedOption password = new FlaggedOption("password").setStringParser(JSAP.STRING_PARSER).setRequired(true).setShortFlag('p').setLongFlag("password"); 
		FlaggedOption pattern = new FlaggedOption("pattern").setStringParser(JSAP.STRING_PARSER).setRequired(true).setShortFlag('t').setLongFlag("pattern");
		FlaggedOption useRegex = new FlaggedOption("useRegex").setStringParser(JSAP.STRING_PARSER).setRequired(true).setShortFlag('u').setLongFlag("useRegex");
		FlaggedOption securitas = new FlaggedOption("securitas").setStringParser(JSAP.STRING_PARSER).setRequired(true).setShortFlag('s').setLongFlag("securitas");
		FlaggedOption buscas = new FlaggedOption("buscas").setStringParser(JSAP.STRING_PARSER).setRequired(true).setShortFlag('b').setLongFlag("buscas");
		
		cusco.setHelp("endereco do servico de nomes <ip>");
		login.setHelp("login no qual se pretende correr o servidor <porto>");
		password.setHelp("numero maximo de threads a criar <numero>");
		pattern.setHelp("padrao de pesquisa a usar <padrao>");
		useRegex.setHelp("usar expressoes regulares <sim/nao>");
		securitas.setHelp("endereco do servidor Securitas <ip:porto>");
		buscas.setHelp("ficheiro com a lista de servidores de buscas");
		
		parser.setHelp("Indique o o login, a palavra-chave, o padrao de pesquisa a usar, se pretende usar expressoes regulares" +
		" o ip e o porto do servidor de autenticacao e a lista de servidores onde pretende efectuar a pesquisa");
		
		parser.setUsage("--cusco[-c] <ip> - ip do servidor rmi do cusco\n" +
				"--login[-l] <login> – para indicar o utilizador\n" +
				"--password[-p] <palavra-chave> – para especificar a palavra-chave a utilizar\n" +
				"--pattern[-t] <padrao> - para indicar o padrao de pesquisa\n" +
				"--useRege-u] <sim/nao> - para indicar se pretende usar expressoes regulares na pesquisa\n" +				
				"--securitas[-s] <ip:porto> – para especificar a localização do serviço Securitas\n" + 
		"--buscas[-b] <ficheiro> - ficheiro com a lista de servidores onse sera efectuada a busca");
		
		try {
			parser.registerParameter(cusco);
			parser.registerParameter(login);
			parser.registerParameter(password);
			parser.registerParameter(pattern);
			parser.registerParameter(useRegex);
			parser.registerParameter(securitas);
			parser.registerParameter(buscas);
			
			JSAPResult arguments = parser.parse(args);
			
			if (!arguments.success()) {
				System.err.println();
				for (Iterator errors = arguments.getErrorMessageIterator();//lets just hammmer the user
				errors.hasNext();) {
					System.err.println("Error: " + errors.next());
				}
				System.err.println();
				System.err.println("Utilizacao: java " + ServerRMI.class.getName());
				System.err.println("                 " + parser.getUsage());
				System.err.println();
				System.err.println(parser.getHelp());
				return;
			}
			
			if(!arguments.getString("securitas").matches("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}:\\d{1,5}")) {
				System.err.println("Ip ou porto invalidos do servidor de autenticacao");
				return;
			}
			
			String[] securitasInfo = arguments.getString("securitas").split(":");
			BufferedReader reader = new BufferedReader(new FileReader(new File(arguments.getString("buscas"))));
			String loginInfo = arguments.getString("login");
			String passInfo = arguments.getString("password");
			String cuscoInfo = arguments.getString("cusco");
			String patternInfo = arguments.getString("pattern");
			String useRegexInfo = arguments.getString("useRegex");
			
			Vector v = new Vector();
			String[] mix;
			String line;
			while((line = reader.readLine()) != null) {
				line = line.trim();
				if(!line.matches("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}:\\d{1,5}")) {
					System.err.println("erro no ficheiro de servidores de buscas, linha ignorada");
					continue;
				}
				
				mix = line.split(":");
				v.add(new InetSocketAddress(mix[0], Integer.parseInt(mix[1])));
			}
			
			notify = new ClientRMI();
			UnicastRemoteObject.exportObject(notify);
			CuscoServices server;
			server = (CuscoServices) Naming.lookup("rmi://" + cuscoInfo + "/ei10635");
			server.search(loginInfo, passInfo, patternInfo, new InetSocketAddress(securitasInfo[0], 
					Integer.parseInt(securitasInfo[1])), (InetSocketAddress[])v.toArray(new InetSocketAddress[1]), (useRegexInfo.equals("sim")? true : false), notify);
			
		} catch (JSAPException e) {
			System.err.println("Parser error");
		} catch (RemoteException e) {
			System.err.println("Remore Object error");
		} catch (MalformedURLException e) {
			System.err.println("URL error");
		} catch (NotBoundException e) {
			System.err.println("Servidor rmi nao encontrado, lookup falhou");
		} catch (FileNotFoundException e) {
			System.err.println("Ficheiro de servidores de buscas nao existe");
		} catch (IOException e) {
			System.err.println("Erro de I/O");
		}
	}
}
