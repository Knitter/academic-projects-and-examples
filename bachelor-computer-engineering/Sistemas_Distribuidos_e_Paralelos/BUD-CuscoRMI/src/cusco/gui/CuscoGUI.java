/* 
 * Project: 	Trabalho Pratico SDP
 * File:		CuscoGUI.java
 * Created on:	11/Abr/2005
 * Description:	
 *
 * (C)2005 Vitor Carreira
 */
package cusco.gui;
import cusco.Cusco;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.text.NumberFormatter;
import rmi.CuscoServices;
import rmi.Notifiable;

/**
 * Classe que representa a interface gráfica. Implementa a interface GUIHandler.
 * @author   	<a href="mailto:vitor.carreira@gmail.com">Vitor Carreira</a>
 * @version   1.0  $Revision$  $Date$
 */
public class CuscoGUI extends JFrame implements Notifiable {
	public static final Integer BUSCA_DEFAULT_PORT = new Integer(0);
	public static final Integer SECURITAS_DEFAULT_PORT = new Integer(0);
	
	private JTextField jtfIP;
	private JFormattedTextField jtfPort;
	private JButton jbAddIP;
	private JButton jbRemoveIP;
	private JTextField jtfLogin;
	private JPasswordField jtfPassword;
	private JTextField jtfSecuritasIP;
	private JFormattedTextField jtfSecuritasPort;
	private JTextField jtfPattern;
	private JButton jbSearch;
	private JButton jbStop;
	private JList jListServers;
	private DefaultListModel servers;
	private Set serverNames;
	
	private JTable jtResults;
	private ResultTableModel tableModel;

	private boolean doReset;
	
	private JCheckBox check = new JCheckBox("Utilizar expressoes regulares");
	
	private CuscoServices cusco;
	private CuscoGUI stupidGUI;

	/**
	 * Constroi a interface grafica.
	 */
	public CuscoGUI(String titulo, int largura, int altura) {
		super(titulo);
		setSize(largura, altura);
		criarInterface();
		this.serverNames = new HashSet();
		doReset = false;
		stupidGUI = this;
	}

	/**
	 * Compatibilidade com o JBuilder
	 */
	public void jbInit() {
		try {
			criarInterface();
		} catch (Exception e) {
			System.err.println(e);
		}

	}

	public void criarInterface() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		// Cria os componentes
		jtfIP = new JTextField(15);

		NumberFormat nf = NumberFormat.getInstance();
		nf.setGroupingUsed(false);

		jtfPort = new JFormattedTextField(new NumberFormatter(nf));
		jtfPort.setColumns(6);
		jtfPort.setValue(BUSCA_DEFAULT_PORT);
		
		servers = new DefaultListModel();
		jListServers = new JList(servers);		
	    jListServers.setBackground(Color.white);
	    jListServers.setBorder(BorderFactory.createLineBorder(Color.black));
	    jListServers.setVisibleRowCount(8);
		
		jbAddIP = new JButton();
	    jbAddIP.setActionCommand("Adicionar");
	    jbAddIP.setMnemonic('A');
	    jbAddIP.setText("Adicionar");
	    jbAddIP.setEnabled(false);

	    jbRemoveIP = new JButton();
	    jbRemoveIP.setActionCommand("Remover");
	    jbRemoveIP.setMnemonic('R');
	    jbRemoveIP.setText("Remover");
	    jbRemoveIP.setEnabled(false);

	    jtfLogin = new JTextField(8);
	    
	    jtfPassword = new JPasswordField(8);

	    jtfSecuritasIP = new JTextField(15);

		jtfSecuritasPort = new JFormattedTextField(new NumberFormatter(nf));
		jtfSecuritasPort.setColumns(6);
		jtfSecuritasPort.setValue(SECURITAS_DEFAULT_PORT);

		jtfPattern = new JTextField(15);
		
		jbSearch = new JButton();
	    jbSearch.setMnemonic('Q');
	    jbSearch.setText("Pesquisar");
	    jbSearch.setEnabled(false);
		
		jbStop = new JButton();
	    jbStop.setMnemonic('P');
	    jbStop.setText("Parar");
	    jbStop.setEnabled(false);
	    
	    tableModel = new ResultTableModel();
	    jtResults = new JTable(tableModel);
	    jtResults.setEnabled(false);
	    jtResults.setColumnSelectionAllowed(false);
	    jtResults.getTableHeader().setReorderingAllowed(false);
	    jtResults.getTableHeader().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                TableColumnModel columnModel = jtResults.getColumnModel();
                int viewColumn = columnModel.getColumnIndexAtX(e.getX()); 
                int column = jtResults.convertColumnIndexToModel(viewColumn); 
                if(e.getClickCount() == 1 && column != -1) {
                	tableModel.sortBy(column);
                }
             }
	    	
	    });
	    DefaultTableCellRenderer dateRenderer = new DefaultTableCellRenderer() {
	    	StringBuffer sb = new StringBuffer();
	    	
	    	public void setValue(Object value) {
	    		if (value == null)
	    			setText("");
	    		else
	    			setText(formatDate((GregorianCalendar)value));
	    		
	    	}
	    	
	    	private String formatDate(GregorianCalendar date) {
	    		sb.setLength(0);
	    		
	    		sb.append(date.get(Calendar.YEAR)).append('.');
	    		padding(sb, date.get(Calendar.MONTH)+1).append('.');
	    		padding(sb, date.get(Calendar.DAY_OF_MONTH)).append("  [");
	    		
	    		padding(sb, date.get(Calendar.HOUR_OF_DAY)).append(':');
	    		padding(sb, date.get(Calendar.MINUTE)).append(':');
	    		padding(sb, date.get(Calendar.SECOND)).append(']');
	    		
	    		return sb.toString();
	    	}
	    	
	    	private StringBuffer padding(StringBuffer sb, int value) {
	    		if (value < 10)
	    			sb.append('0').append(value);
	    		else
	    			sb.append(value);
	    		return sb;
	    	}
	    };
	    jtResults.setDefaultRenderer(GregorianCalendar.class, dateRenderer);

	    TableCellRenderer aux = jtResults.getTableHeader().getDefaultRenderer();
	    if (aux instanceof DefaultTableCellRenderer)
	    	((DefaultTableCellRenderer)aux).setToolTipText("Clique para ordenar. Volte a clicar para inverter a ordem.");

	    // Cria borders para reutilizacao
   	    Border border1 = BorderFactory.createEmptyBorder(5,5,5,5);
	    Border border2 = BorderFactory.createEmptyBorder(5,5,5,5);


	    // Cria painel da esquerda
	    JPanel jpLeft = new JPanel();
	    JPanel jpInnerLeft = new JPanel();

	    BorderLayout borderLayout1 = new BorderLayout();
	    GridLayout gridLayout1 = new GridLayout();
	    gridLayout1.setColumns(2);
	    gridLayout1.setRows(4);

	    JLabel jLabel1 = new JLabel("Login: ");
	    jLabel1.setDisplayedMnemonic('L');
	    jLabel1.setLabelFor(jtfLogin);

		JLabel jLabel2 = new JLabel("Senha: ");
		jLabel2.setLabelFor(jtfPassword);
		jLabel2.setDisplayedMnemonic('S');

		JLabel jLabel3 = new JLabel("IP Securitas: ");
		jLabel3.setDisplayedMnemonic('I');
		jLabel3.setLabelFor(jtfSecuritasIP);

		
		JLabel jLabel4 = new JLabel("Porto Securitas: ");
	    jLabel4.setDisplayedMnemonic('T');
	    jLabel4.setLabelFor(jtfSecuritasPort);
	    
	    jpInnerLeft.setLayout(gridLayout1);
	    jpLeft.setLayout(borderLayout1);
	    jpLeft.setBorder(border1);
	    jpInnerLeft.add(jLabel1, null);
	    jpInnerLeft.add(jtfLogin, null);
	    jpInnerLeft.add(jLabel2, null);
	    jpInnerLeft.add(jtfPassword, null);
	    jpInnerLeft.add(jLabel3, null);
	    jpInnerLeft.add(jtfSecuritasIP, null);
	    jpInnerLeft.add(jLabel4, null);
	    jpInnerLeft.add(jtfSecuritasPort, null);
	    jpLeft.add(jpInnerLeft,  BorderLayout.NORTH);
	    

	    // Cria painel da direita
	    JPanel jpRigth = new JPanel();
	    BorderLayout borderLayout2 = new BorderLayout();

	    jpRigth.setBorder(border1);
	    jpRigth.setLayout(borderLayout2);
	    	    
	    JLabel jLabel5 = new JLabel("IP/Porto: ");
	    jLabel5.setDisplayedMnemonic('O');
	    jLabel5.setLabelFor(jtfIP);

	    JPanel jPanel1 = new JPanel();
	    FlowLayout flowLayout1 = new FlowLayout();
	    jPanel1.setLayout(flowLayout1);
	    jPanel1.add(jLabel5, null);
	    jPanel1.add(jtfIP, null);
	    jPanel1.add(jtfPort, null);
	    
	    
	    JPanel jPanel2 = new JPanel();
	    FlowLayout flowLayout2 = new FlowLayout();
	    jPanel2.setLayout(flowLayout2);
	    jPanel2.add(jbAddIP, null);
	    jPanel2.add(jbRemoveIP, null);
	    
	    
	    JPanel jPanel3 = new JPanel();
	    GridLayout gridLayout2 = new GridLayout();
	    gridLayout2.setColumns(1);
	    gridLayout2.setRows(2);
	    jPanel3.setLayout(gridLayout2);
	    jPanel3.add(jPanel1, null);
	    jPanel3.add(jPanel2, null);
	    
	    jpRigth.add(new JLabel("Servidores Busca:"), BorderLayout.NORTH);
	    jpRigth.add(jListServers, BorderLayout.CENTER);
	    jpRigth.add(jPanel3, BorderLayout.SOUTH);
	    
	    // Cria splitpane do topo
	    JSplitPane jSplitTopo = new JSplitPane();
	    jSplitTopo.setDividerLocation(220);
		jSplitTopo.setOneTouchExpandable(true);
	    jSplitTopo.add(jpLeft, JSplitPane.LEFT);
	    jSplitTopo.add(jpRigth, JSplitPane.BOTTOM);
	    
	    
	    // Cria painel de pesquisa
	    JPanel jPanel4 = new JPanel();
	    FlowLayout flowLayout3 = new FlowLayout(FlowLayout.LEFT);
	    jPanel4.setLayout(flowLayout3);
	    jPanel4.setBorder(BorderFactory.createLineBorder(Color.black));
	    
	    JLabel jLabel6 = new JLabel("Nome a pesquisar: ");	    
	    jLabel6.setDisplayedMnemonic('N');
	    jLabel6.setLabelFor(jtfPattern);
	    
	    jPanel4.add(jLabel6, null);
	    jPanel4.add(jtfPattern, null);
	    jPanel4.add(jbSearch, null);
	    jPanel4.add(jbStop, null);
	    
	    /* Knitter added */
	    jPanel4.add(check, null);

	    // Cria painel do centro
	    JPanel jpCentro = new JPanel();	    
	    BorderLayout borderLayout3 = new BorderLayout();
	    jpCentro.setLayout(borderLayout3);
	    jpCentro.add(jSplitTopo, BorderLayout.CENTER);
	    jpCentro.add(jPanel4, BorderLayout.SOUTH);
	    
	    
	    // Cria painel de baixo	    
		JScrollPane jScrollPane1 = new JScrollPane();
		jScrollPane1.getViewport().add(jtResults, null);
		
		
		JSplitPane jSplitBaixo = new JSplitPane();
	    jSplitBaixo.setOrientation(JSplitPane.VERTICAL_SPLIT);
	    jSplitBaixo.setBorder(BorderFactory.createLineBorder(Color.black));
	    jSplitBaixo.add(jpCentro, JSplitPane.TOP);
	    jSplitBaixo.add(jScrollPane1, JSplitPane.BOTTOM);    
	    jSplitBaixo.setDividerLocation(250);

	    getContentPane().add(jSplitBaixo, BorderLayout.CENTER);
	    
	    // Activa eventos
	    jbAddIP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addServer();
			}
		});
	    
	    jbRemoveIP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeServer();
			}
		});
	    
	    jbSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (jListServers.getSelectedIndex() == -1) {
					try {
						errorMessage("Pesquisar", "Tem de seleccionar pelo menos 1 servidor.");
					} catch (RemoteException e1) {
						System.err.println("Nao foi possivel mostrar mensagem de erro. " + e1.getMessage());
					}
					return;					
				}
				jListServers.setEnabled(false);
				jtfIP.setEditable(false);
				jtfPort.setEditable(false);				
				jbRemoveIP.setEnabled(false);
				jbAddIP.setEnabled(false);
				
				jtfLogin.setEditable(false);
				jtfPassword.setEditable(false);
				jtfSecuritasIP.setEditable(false);
				jtfSecuritasPort.setEditable(false);				
				jtfPattern.setEditable(false);
				
				jbStop.setEnabled(true);
				jtResults.setEnabled(true);
				
				final String login = jtfLogin.getText().trim();
				final String passw = new String(jtfPassword.getPassword());
				final String pattern = jtfPattern.getText().trim(); 
				final InetSocketAddress securitas = 
					new InetSocketAddress(
						jtfSecuritasIP.getText().trim(),
						((Number)jtfSecuritasPort.getValue()).intValue());
				
				Object[] selectedServers = jListServers.getSelectedValues();
				final InetSocketAddress[] servers = 
					new InetSocketAddress[selectedServers.length];
				String[] aux;
				for (int i=0;i<servers.length;i++) {
					aux = ((String)selectedServers[i]).split(":");
					servers[i] = new InetSocketAddress(aux[0], 
							Integer.parseInt(aux[1]));					
				}				
				Thread t = new Thread() {
					public void run() {
						doReset = true;
						tableModel.clear();
						try {
							cusco.search(login, passw, pattern, securitas, servers, false, stupidGUI);
						} catch (RemoteException e) {
							//ignore
						}
						jbSearch.setEnabled(false);
						
						if (doReset)
							resetButtons();
					}
				};
				t.start();
			}
		});
	    
	    jbStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					cusco.stop();
				} catch (RemoteException e1) {
					//ignore
				}
				doReset = false;
				resetButtons();
			}
		});
	    
	    
		jtfPattern.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					jbSearch.doClick();
				}
			}
		});
				
		jListServers.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Object[] selectedItens = jListServers.getSelectedValues();
				switch (selectedItens.length) {
					case 0:
						return;
					case 1:
						String[] itens = ((String)selectedItens[0]).split(":");
						jtfIP.setText(itens[0]);
						jtfPort.setValue(new Integer(itens[1]));
						jbRemoveIP.setEnabled(true);
						break;
					default:
						jtfIP.setText("");
						jtfPort.setValue(BUSCA_DEFAULT_PORT);
						jbRemoveIP.setEnabled(false);						
				}
		 	}
		});

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				try {
					cusco.close();
				} catch (RemoteException e1) {
					//ignore
				}
				setVisible(false);
				dispose();
				System.exit(1);
			}
		});
		
		DocumentListener serversListener = new DocumentListener() {
			public void removeUpdate(DocumentEvent e) {
				updateServersButton();
			}
			public void insertUpdate(DocumentEvent e) {
				updateServersButton();
			}
			public void changedUpdate(DocumentEvent e) {
				updateServersButton();
			}
		};
						
		jtfIP.getDocument().addDocumentListener(serversListener);
		jtfPort.getDocument().addDocumentListener(serversListener);

		DocumentListener searchListener = new DocumentListener() {
			public void removeUpdate(DocumentEvent e) {
				updateSearchButton();
			}
			public void insertUpdate(DocumentEvent e) {
				updateSearchButton();
			}
			public void changedUpdate(DocumentEvent e) {
				updateSearchButton();
			}
		};
		jtfLogin.getDocument().addDocumentListener(searchListener);
		jtfPassword.getDocument().addDocumentListener(searchListener);
		jtfSecuritasIP.getDocument().addDocumentListener(searchListener);
		jtfSecuritasPort.getDocument().addDocumentListener(searchListener);
		jtfPattern.getDocument().addDocumentListener(searchListener);
		
		/*Para testar*/
		jtfLogin.setText("ei10635");
		jtfPassword.setText("xpto");
		jtfSecuritasIP.setText("192.168.234.244");
		jtfSecuritasPort.setValue(new Integer(1204));
		jtfPort.setValue(new Integer(1205));
		jtfIP.setText("localhost");
		jtfPattern.setText("asdf");
	}
	
	/*Para testar*/
	private void doAClick() {
		jbAddIP.doClick();
	}

	/**
	 * Método que apresenta uma caixa de diálogo com uma mensagem de erro.
	 * 
	 * @param title título da caixa de diálogo
	 * @param message mensagem de erro a mostrar
	 * 
	 * @see rmi.Notifiable
	 */
	public void errorMessage(String title, String message) throws RemoteException {
		JOptionPane.showMessageDialog(this, message, title, JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * Método que apresenta uma caixa de diálogo com uma mensagem informativa.
	 * 
	 * @param message mensagem informativa a mostrar
	 * 
	 * @see rmi.Notifiable
	 */
	public void infoMessage(String message) throws RemoteException {
		JOptionPane.showMessageDialog(this, message, this.getTitle(), JOptionPane.INFORMATION_MESSAGE);
	}
	
	/**
	 * Método que adiciona uma entrada à lista de ficheiros/pastas encontrados.
	 * 
	 * @param entry entrada a adicionar
	 * 
	 * @see rmi.Notifiable
	 */
	public void foundItem(FileInfo entry) throws RemoteException {
		if (jtResults.isEnabled())
			tableModel.addEntry(entry);				
	}
	
	public void searchFinished() throws RemoteException {
		//do nothing
	}
	
	/**
	 * Função main.
	 */
	public static void main(String[] args) {
		CuscoGUI gui = new CuscoGUI("Cusco", 700, 500);
		try {
			CuscoServices cusco = new Cusco();
			Naming.bind("/ei10635", cusco);
			gui.cusco = cusco;
			UnicastRemoteObject.exportObject(gui);
			// Centra a janela
			Dimension screenWidth = Toolkit.getDefaultToolkit().getScreenSize();
			Dimension frameSize = gui.getSize();
			gui.setLocation((screenWidth.width - frameSize.width)/2, (screenWidth.height - frameSize.height)/2);
			gui.setVisible(true);
		} catch (RemoteException e) {
			System.err.println("Impossivel efectuar o bind do objecto remoto.\n" + e.getMessage());
		} catch (MalformedURLException e) {
			System.err.println("Impossivel efectuar o bind do objecto remoto.\n" + e.getMessage());
		} catch (AlreadyBoundException e) {
			try {
				gui.cusco = (CuscoServices)Naming.lookup("/ei10635");
				System.err.println("already bound" + e.getMessage());
			} catch (MalformedURLException e1) {
				System.err.println("Impossivel efectuar o lookup do objecto remoto.\n" + e.getMessage());
			} catch (RemoteException e1) {
				System.err.println("Impossivel efectuar o lookup do objecto remoto.\n" + e.getMessage());
			} catch (NotBoundException e1) {
				System.err.println("Impossivel efectuar o lookup do objecto remoto.\n" + e.getMessage());
			}
		}

	}

	/**
	 * Função que verifica se a string passada por parâmetro é um ip válido.
	 * @param ip string contendo um ip ou nome de uma máquina
	 * @return true caso o ip seja válido; false caso contrário 
	 */
	private boolean isIPValid(String ip) {
		try {
			Inet4Address.getByName(ip);
		} catch (UnknownHostException e) {
			return false;
		}
		return true;
	}
	
	/**
	 * Função que verifica se o conteúdo das caixas para gestão dos servidores
	 * "Busca" contêm valores válidos.
	 */
	private void updateServersButton() {
		String ip = jtfIP.getText().trim();
		
		int value = ((Number)jtfPort.getValue()).intValue(); 
		
		boolean enable =  ip.length() != 0 && value > 0 && value <= 65535;
		
		jbAddIP.setEnabled(enable);
		jbRemoveIP.setEnabled(false);
	}

	/**
	 * Função que verifica se o conteúdo das caixas permite realizar uma 
	 * operação de pesquisa
	 */
	private void updateSearchButton() {
		String ip = jtfSecuritasIP.getText().trim();
		int value = ((Number)jtfSecuritasPort.getValue()).intValue();
		String login = jtfLogin.getText().trim();
		char[] pass = jtfPassword.getPassword();
		String pattern = jtfPattern.getText().trim();
		
		boolean enable =  
			login.length() != 0 && pass.length != 0 &&
			pattern.length() != 0 && servers.size() != 0 &&
			ip.length() != 0 &&	value > 0 && value <= 65535;		
		
		jbSearch.setEnabled(enable);
	}
	
	private void resetButtons() {
		jListServers.setEnabled(true);
		jtfIP.setEditable(true);
		jtfPort.setEditable(true);				
		
		jtfLogin.setEditable(true);
		jtfPassword.setEditable(true);
		jtfSecuritasIP.setEditable(true);
		jtfSecuritasPort.setEditable(true);
		jtfPattern.setEditable(true);
				
		jbStop.setEnabled(false);
		jbRemoveIP.setEnabled(false);
		
		updateServersButton();
		jbSearch.setEnabled(true);
		jtResults.setEnabled(false);
	}
	
	/**
	 * Método que adiciona uma entrada à lista de servidores
	 */
	public void addServer() {
		String s = jtfIP.getText().trim();
		try {
			InetAddress addr = InetAddress.getByName(s);
			int port = ((Number)jtfPort.getValue()).intValue();
			String servername = addr.getCanonicalHostName(); 
			String entry = servername + ":" + port;
			if (serverNames.contains(servername)) {
				errorMessage("IP inválido", "Endereço IP duplicado.");
				return;			
			}
			serverNames.add(servername);
			servers.addElement(entry);
			
			jtfIP.setText("");
			jtfPort.setValue(BUSCA_DEFAULT_PORT);
			jbAddIP.setEnabled(false);
			jbRemoveIP.setEnabled(false);
			jListServers.clearSelection();
			
			if (servers.size() == 1)
				updateSearchButton();
		} catch (UnknownHostException e) {
			try {
				errorMessage("IP inválido", "O endereço IP " + s + "não é válido.");
			} catch (RemoteException e1) {
				System.err.println("Nao foi possivel mostrar mensagem de erro. " + e1.getMessage());
			}
		} catch (RemoteException e) {
			System.err.println("Nao foi possivel mostrar mensagem de erro. " + e.getMessage());
		}		
	}
	
	/**
	 * Método que remove uma entrada da lista de servidores
	 */
	private void removeServer() {
		int index = jListServers.getSelectedIndex();
		String[] itens = ((String)servers.remove(index)).split(":");
		serverNames.remove(itens[0]);

		jbRemoveIP.setEnabled(false);
		jListServers.clearSelection();
			
		if (servers.size() == 0)
			updateSearchButton();
	}
}
