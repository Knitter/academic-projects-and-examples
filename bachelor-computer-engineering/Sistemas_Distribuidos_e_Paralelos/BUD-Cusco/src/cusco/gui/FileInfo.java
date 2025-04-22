/* 
 * Project: 	Trabalho Pratico SDP
 * File:		FileInfo.java
 * Created on:	11/Abr/2005
 * Description:	
 *
 * (C)2005 Vitor Carreira
 */
package cusco.gui;

import java.util.Comparator;
import java.util.GregorianCalendar;

/**
 * Classe que contém a informação relativa a um ficheiro ou pasta.
 * 
 * @author	<a href="mailto:vitor.carreira@gmail.com">Vitor Carreira</a>
 * @version 1.0
 * 
 * $Revision$
 * $Date$
 */
public class FileInfo {
	
	/**
	 * Caminho absoluto.
	 */
	public String absolutePath;
	
	/**
	 * Data da última alteração.
	 */
	public GregorianCalendar lastModified;
	
	/**
	 *  Tamanho. Caso se trate de uma pasta o tamanho deverá ser -1.
	 */
	public long size;
	
	/**
	 * IP ou nome da máquina onde o recurso se encontra localizado. 
	 */
	public String ip;
	
	
	/**
	 * Verdade caso se trate de um pasta; falso caso contrário.
	 * Este atributo é preenchido automaticamente a partir do valor de size.
	 */
	private boolean isDirectory;
	
		
	public static Comparator orderByAscendingIP = 
		new FileInfoComparator(3, true);

	public static Comparator orderByDescendingIP = 
		new FileInfoComparator(3, false);

	
	public static Comparator orderByAscendingAbsolutePath = 
		new FileInfoComparator(0, true);
	
	public static Comparator orderByDescendingAbsolutePath = 
		new FileInfoComparator(0, false);
	
	public static Comparator orderByAscendingLastModified = 
		new FileInfoComparator(1, true);
	
	public static Comparator orderByDescendingLastModified = 
		new FileInfoComparator(1, false);
	
	public static Comparator orderByAscendingSize = 
		new FileInfoComparator(2, true);
	
	public static Comparator orderByDescendingSize = 
		new FileInfoComparator(2, false);
	
	/**
	 * Cria uma nova instância de <code>FileInfo</code> para representar uma 
	 * pasta.
	 * @param absolutePath o caminho absoluto do ficheiro
	 * @param lastModified a data da última modificação
	 * @param ip IP ou nome da máquina onde o recurso se encontra localizado
	 */
	public FileInfo(String absolutePath, GregorianCalendar lastModified, String ip) {
		this(absolutePath, lastModified, ip, -1);
	}	

	/**
	 * Cria uma nova instância de <code>FileInfo</code> para representar um
	 * ficheiro.
	 * @param absolutePath o caminho absoluto do ficheiro
	 * @param lastModified a data da última modificação
	 * @param ip IP ou nome da máquina onde o recurso se encontra localizado
	 * @param size o tamanho do ficheiro
	 */
	public FileInfo(String absolutePath, GregorianCalendar lastModified, 
			String ip, long size) {
		this.absolutePath = absolutePath;
		this.lastModified = lastModified;
		this.size = size;
		this.ip = ip;
		this.isDirectory = size == -1;		
	}
	
	private static int compareLongs(long l1, long l2) {
		if (l1 < l2)
			return -1;
		if (l1 == l2)
			return 0;
		return 1;
	}
	
	private static class FileInfoComparator implements Comparator {
		private int field;
		private boolean ascending;
		
		public FileInfoComparator(int field, boolean ascending) {
			this.field = field;			
			this.ascending = ascending;
		}
		public int compare(Object o1, Object o2) {
			// Force cast or throw class cast exception
			FileInfo fi1 = (FileInfo)o1;
			FileInfo fi2 = (FileInfo)o2;
			if (fi1.isDirectory && !fi2.isDirectory)
				return -1;
			if (fi2.isDirectory && !fi1.isDirectory)
				return 1;
			
			int ret = 0;
			switch (field) {
				case 0:
					ret = fi1.absolutePath.compareTo(fi2.absolutePath);
					break;
				case 1:
					ret = compareLongs(fi1.lastModified.getTimeInMillis(), 
							fi2.lastModified.getTimeInMillis());
					break;
				case 2:
					ret = compareLongs(fi1.size, fi2.size);
					break;
				case 3:
					ret = fi1.ip.compareTo(fi2.ip);
					break;					
			}
			return ascending ? ret : -ret;			
		}			
	};
}
