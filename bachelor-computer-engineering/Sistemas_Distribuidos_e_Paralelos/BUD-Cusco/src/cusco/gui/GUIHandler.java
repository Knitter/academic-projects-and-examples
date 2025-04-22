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
 * Interface que define as operações que permitem ao cliente comunicar com 
 * a interface gráfica.
 *  
 * @author	<a href="mailto:vitor.carreira@gmail.com">Vitor Carreira</a>
 * @version 1.0
 * 
 * $Revision$
 * $Date$
 */
public interface GUIHandler {
	/**
	 * Método que apresenta uma caixa de diálogo com uma mensagem de erro.
	 * @param title título da caixa de diálogo
	 * @param message mensagem de erro a mostrar 
	 */
	public void showErrorMessage(String title, String message);
		
	/**
	 * Método que apresenta uma caixa de diálogo com uma mensagem informativa.
	 * @param message mensagem informativa a mostrar 
	 */
	public void showInfoMessage(String message);

	
	/**
	 * Método que adiciona uma entrada à lista de ficheiros/pastas encontrados.
	 * @param entry entrada a adicionar
	 */
	public void addFileEntry(FileInfo entry);	
}
