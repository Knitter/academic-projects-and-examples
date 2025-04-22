package buscas;

import java.util.Iterator;

import com.martiansoftware.jsap.FlaggedOption;
import com.martiansoftware.jsap.JSAP;
import com.martiansoftware.jsap.JSAPException;
import com.martiansoftware.jsap.JSAPResult;

/**
 * Ponto de entrada do programa.<br>
 * Classe responsavel pelo inicio do sistema, recepcao, parsing e tratamento de parametros e 
 * criacao do servidor
 * 
 * @author Knitter
 */
public class Buscas {

	/**
	 * 
	 */
	private Buscas() {//nao faz sentido permitir a criacao de objectos do tipo Buscas
		super();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JSAP parser = new JSAP();
		
		FlaggedOption porto = new FlaggedOption("porto").setStringParser(JSAP.INTEGER_PARSER).setRequired(true).setShortFlag('p').setLongFlag("porto");
		FlaggedOption maxThreads = new FlaggedOption("maxThreads").setStringParser(JSAP.INTEGER_PARSER).setRequired(true).setShortFlag('m').setLongFlag("max");; 
		FlaggedOption securitas = new FlaggedOption("securitas").setStringParser(JSAP.STRING_PARSER).setRequired(true).setShortFlag('s').setLongFlag("securitas");;
		
		porto.setHelp("porto no qual se pretende correr o servidor <porto>");
		maxThreads.setHelp("numero maximo de threads a criar <numero>");
		securitas.setHelp("endereco do servidor Securitas <ip:porto>");
		
		parser.setHelp("Indique o porto onde quer registar o servidor, o numero maximo de threads que \npretende que o servidor" +
				"crie e a localizacao do servidor de autenticacao, Securitas.");
		parser.setUsage("--porto[-p] <porto> – para indicar o porto onde o servidor é registado\n" +
				"--maxThreads[-m] <número máximo de threads> – para especificar o número máximo threads a criar\n" +
				"--securitas[-s] <ip:porto> – para especificar a localização do serviço Securitas.");
		
		try {
			parser.registerParameter(porto);
			parser.registerParameter(maxThreads);
			parser.registerParameter(securitas);
		} catch (JSAPException e) {
			System.exit(-3);
		}
		
		JSAPResult arguments = parser.parse(args);
		
        if (!arguments.success()) {
            System.err.println();
            for (Iterator errors = arguments.getErrorMessageIterator();//lets just hammmer the user
                    errors.hasNext();) {
                System.err.println("Error: " + errors.next());
            }
            System.err.println();
            System.err.println("Utilizacao: java " + Buscas.class.getName());
            System.err.println("                 " + parser.getUsage());
            System.err.println();
            System.err.println(parser.getHelp());
            System.exit(-5);
        }
			
		if(!arguments.getString("securitas").matches("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}:\\d{1,5}")) {
            System.err.println("Ip ou porto invalidos");
            System.exit(-4);
		}
		
		String endereco[] = arguments.getString("securitas").split(":");
		
		new Server(endereco[0], Integer.parseInt(endereco[1]), 1205, arguments.getInt("maxThreads"));
	}

}
