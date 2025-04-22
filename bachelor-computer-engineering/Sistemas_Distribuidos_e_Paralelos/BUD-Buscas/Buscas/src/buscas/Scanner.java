package buscas;

import bud.exceptions.NullOutputStreamException;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * Entidade responsavel por efectuar pesquisas de ficheiros sob determinado padrao.
 * As pesquisas podem ser levadas a cabo com ou sem a utilizacao de expressoes regulares
 * 
 * @see java.util.regex.Matcher
 * @see java.util.regex.Pattern
 * 
 * @author  Knitter
 */
public class Scanner extends Thread{
	
	private String padrao;
	private boolean stopedByUser = false;
	private SearchOwner owner;
	private String[] folders;
	private Pattern pattern;
	private Matcher matcher;
	
	/**
	 * Permite criar uma entidade de pesquisa.
	 * 
	 * @param owner Objecto que pretende proporcionar um servico de pesquisa e que deve receber a notificacao 
	 * dos ficheiros e/ou pastas encontrados.
	 * 
	 * @param padrao Padrao pelo qual se fara a pesquisa.
	 * @param folders Conjunto inicial de pastas onde tera inicio a pesquisa.
	 * @param useRegular Indicacao da utilizacao de expressoes regulares na pesquisa.
	 */
	public Scanner(SearchOwner owner, String padrao, String[] folders, boolean useRegular) {
		this.owner = owner;
		this.folders = folders;
		if(useRegular)
			this.padrao = padrao;
		else
			this.padrao = ".*" + padrao.replace(".", "\\.").replace("*", ".*").replace("?", ".") + ".*";
		try {
			pattern = Pattern.compile(this.padrao);
		} catch(PatternSyntaxException e) {
			
		}
	}
	
	public void run() {
		for(int z = 0; z < folders.length && !stopedByUser; z++) {
			scan(folders[z]);
		}
		try {
			if(!stopedByUser)
				owner.searchFinished();
		} catch (NullOutputStreamException e) {
			System.err.println("IOException, impossivel dizer ao cliente que a pesquisa terminou");
		}
	}
	
	/**
	 * Metodo recursivo de pesquisa.
	 * 
	 * @param origem Pasta onde tera lugar a pesquisa.
	 */
	private void scan(String origem) {
		File file = new File(origem);
		File list[] = file.listFiles();
		
		if(list != null) {
			for(int z = 0; z < list.length && !stopedByUser; z++) {
				if(list[z].isDirectory())
					scan(list[z].getAbsolutePath());
				matcher = pattern.matcher(list[z].getName());
				if(matcher.matches()) {
					owner.result(list[z]);
				}				
			}
		}
	}
	
	/**
	 * Metodo que permite parar a pesquisa.
	 */
	public void stopSearch() {
		stopedByUser = true;
	}
}
