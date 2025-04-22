/* 
 * Project: 	Trabalho Pratico SDP
 * File:		ResultTableModel.java
 * Created on:	11/Abr/2005
 * Description:	
 *
 * (C)2005 Vitor Carreira
 */
package cusco.gui;

import java.util.Arrays;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import javax.swing.table.AbstractTableModel;

/**
 * Modelo utilizado para representar os resultados de uma pesquisa.
 * @author  	<a href="mailto:vitor.carreira@gmail.com">Vitor Carreira</a>
 * @version  1.0  $Revision$  $Date$
 */
public class ResultTableModel extends AbstractTableModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5628009261421198264L;
	
	private String[] columnNames = {"Localização", "Caminho", "Data [Hora]", "Tamanho"};
	/**
	 */
	private FileInfo[] orderedIndexes;
	private LinkedList results;
	private Comparator comparator;
	private boolean ascending;
	private int previousColumn;
	
	public ResultTableModel() {
		this.results = new LinkedList();
		this.orderedIndexes = new FileInfo[0];
		this.comparator = null;
		this.ascending = true;
		this.previousColumn = -1;
	}
	
	/* (non-Javadoc)
	 * @see javax.swing.table.TableModel#getColumnName(int)
	 */
	public String getColumnName(int column) {
		if (column >=0 && column < columnNames.length)
			return columnNames[column];
		return null;
	}
	
	/* (non-Javadoc)
	 * @see javax.swing.table.TableModel#getColumnCount()
	 */
	public int getColumnCount() {
		return columnNames.length;
	}
	
	/* (non-Javadoc)
	 * @see javax.swing.table.TableModel#getRowCount()
	 */
	public int getRowCount() {
		return results.size();
	}
	
	/* (non-Javadoc)
	 * @see javax.swing.table.TableModel#getValueAt(int, int)
	 */
	public Object getValueAt(int rowIndex, int columnIndex) {
		if (rowIndex < 0 || rowIndex >= results.size() || 
				columnIndex < 0 || columnIndex >= columnNames.length)
			return null;
		FileInfo info = orderedIndexes[rowIndex];
		switch (columnIndex) {
		case 0:
			return info.ip;
		case 1:
			return info.absolutePath;
		case 2:
			return info.lastModified;
		case 3:		
			return info.size == -1 ? "<DIR>" : String.valueOf(info.size);
		default:
			return null;
		}
	}
	
	public Class getColumnClass(int c) {
		switch (c) {
		case 0:
		case 1:
		case 3:
			return String.class;
		case 2:
			return GregorianCalendar.class;
		default:
			return null;
		}
	}
	
	/**
	 * Adiciona uma nova entrada à tabela.
	 * @param entry entrada a adicionar
	 */
	public void addEntry(FileInfo entry) {
		results.add(entry);
		updateIndexes();
		if (comparator != null)
			fireTableDataChanged();
		else
			fireTableRowsInserted(results.size()-1, results.size()-1);
	}
	
	public void clear() {
		int size = results.size();
		results.clear();
		if (size > 0)
			fireTableRowsDeleted(0, size-1);
	}
	
	public void sortBy(int column) {
		if (previousColumn != -1) {
			ascending = previousColumn == column ? !ascending : true;
		}
		switch(column) {
		case 0:
			comparator = ascending ? 
					FileInfo.orderByAscendingIP :
						FileInfo.orderByDescendingIP;
			break;
		case 1:
			comparator = ascending ? 
					FileInfo.orderByAscendingAbsolutePath :
						FileInfo.orderByDescendingAbsolutePath;
			break;
		case 2:
			comparator = ascending ? 
					FileInfo.orderByAscendingLastModified :
						FileInfo.orderByDescendingLastModified;
			break;
		case 3:
			comparator = ascending ? 
					FileInfo.orderByAscendingSize :
						FileInfo.orderByDescendingSize;
			break;
		default:
			throw new IllegalArgumentException("Invalid column ID: " +
					column);
		}
		previousColumn = column;
		Arrays.sort(orderedIndexes, comparator);		
		fireTableDataChanged();
		
	}
	
	private void updateIndexes() {			
		orderedIndexes = (FileInfo[])
		results.toArray(new FileInfo[results.size()]);
		if (comparator != null) {
			Arrays.sort(orderedIndexes, comparator);
		}
	}
	
}
