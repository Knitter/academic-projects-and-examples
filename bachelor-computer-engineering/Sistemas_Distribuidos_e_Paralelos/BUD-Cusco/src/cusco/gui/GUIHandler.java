/* 
 * Project: 	Trabalho Pratico SDP
 * File:		GUIHandler.java
 * Created on:	11/Abr/2005
 * Description:	
 *
 * (C)2005 Vitor Carreira
 */
package cusco.gui;

/**
 * Interface que define as opera��es que permitem ao cliente comunicar com 
 * a interface gr�fica.
 *  
 * @author	<a href="mailto:vitor.carreira@gmail.com">Vitor Carreira</a>
 * @version 1.0
 * 
 * $Revision$
 * $Date$
 */
public interface GUIHandler {
	/**
	 * M�todo que apresenta uma caixa de di�logo com uma mensagem de erro.
	 * @param title t�tulo da caixa de di�logo
	 * @param message mensagem de erro a mostrar 
	 */
	public void showErrorMessage(String title, String message);
		
	/**
	 * M�todo que apresenta uma caixa de di�logo com uma mensagem informativa.
	 * @param message mensagem informativa a mostrar 
	 */
	public void showInfoMessage(String message);

	
	/**
	 * M�todo que adiciona uma entrada � lista de ficheiros/pastas encontrados.
	 * @param entry entrada a adicionar
	 */
	public void addFileEntry(FileInfo entry);	
}
