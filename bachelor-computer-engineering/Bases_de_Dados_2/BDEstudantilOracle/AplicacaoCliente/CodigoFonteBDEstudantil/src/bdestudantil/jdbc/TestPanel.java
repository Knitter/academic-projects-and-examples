package bdestudantil.jdbc;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import bdestudantil.MainFrame;

public class TestPanel extends JPanel {
    JPanel contentPane;
    JTextArea areaEntrada = new JTextArea();
    JTextArea areaResultados = new JTextArea();
    JPanel painelResultados = new JPanel();
    JPanel painelEntrada = new JPanel();
    JPanel panelBotoes = new JPanel();
    JButton buttonGet = new JButton();
    JButton buttonClear = new JButton();
    FlowLayout flowLayout1 = new FlowLayout();
    BorderLayout borderLayout2 = new BorderLayout();
    BorderLayout borderLayout3 = new BorderLayout();
    JTextField estadoLigacao = new JTextField();
    JMenuItem setupConnection = new JMenuItem();
    JScrollPane jScrollPane1;
    JToolBar tool = new JToolBar();
    JButton jButton1 = new JButton();
    JButton jButton2 = new JButton();
    JButton jButton3 = new JButton();
    JButton jButton4 = new JButton();
    MainFrame owner;
    public TestPanel(MainFrame owner) {
        this.owner=owner;
        try{
            jbInit();
        }catch(Exception ex){
            ex.printStackTrace();
        }

    }

    private void jbInit() throws Exception {
        setLayout(new BorderLayout());
        areaEntrada.setPreferredSize(new Dimension(70, 100));
        areaEntrada.setText("");
        areaEntrada.setLineWrap(true);
        areaResultados.setPreferredSize(new Dimension(70, 300));
        areaResultados.setText("");
        areaResultados.setLineWrap(true);
        areaResultados.setEditable(false);
        buttonGet.setText("Processar");
        buttonGet.addActionListener(new MainFrame_buttonGet_actionAdapter(this));
        buttonClear.setText("Limpar");
        buttonClear.addActionListener(new MainFrame_buttonClear_actionAdapter(this));
        panelBotoes.setLayout(flowLayout1);
        painelEntrada.setLayout(borderLayout2);
        painelResultados.setLayout(borderLayout3);
        estadoLigacao.setPreferredSize(new Dimension(200, 20));
        estadoLigacao.setEditable(false);
        estadoLigacao.setText("");
        setupConnection.setActionCommand("setupConnection");
        setupConnection.setText("Configurar ligacao");
        jButton1.setText("UserTables");
        jButton2.setText("unknown");
        jButton3.setText("unknown");
        jButton4.setText("unknown");
        tool.setFloatable(false);
        panelBotoes.add(estadoLigacao);
        panelBotoes.add(buttonClear);
        panelBotoes.add(buttonGet);
        painelEntrada.add(areaEntrada, java.awt.BorderLayout.CENTER);

        jScrollPane1 = new JScrollPane();

        jScrollPane1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setAutoscrolls(true);
        jScrollPane1.getViewport().add(areaResultados);

        areaResultados.setAutoscrolls(false);

        painelResultados.add(jScrollPane1);

        add(painelEntrada, BorderLayout.NORTH);
        add(painelResultados, BorderLayout.CENTER);
        add(panelBotoes, BorderLayout.SOUTH);
    }

    /**
     * File | Exit action performed.
     *
     * @param actionEvent ActionEvent
     */
    void jMenuFileExit_actionPerformed(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void buttonClear_actionPerformed(ActionEvent e) {
        areaResultados.setText("");
        areaEntrada.setText("");
    }

    public void buttonGet_actionPerformed(ActionEvent e) {
        try {
            Connection c = ConfiguracaoLigacao.getConf().getCon();
            if (!c.isClosed()) {
                Statement s = c.createStatement();
                s.execute(areaEntrada.getText());
                ResultSet r = s.getResultSet();
                /*encontrar forma correcta de ver os resultados!*/
                areaResultados.setText("");
                while (r.next()) {
                    areaResultados.append(r.getString(1));
                    areaResultados.append("\n");
                }
            }
        } catch (SQLException ex) {
            areaResultados.setText("");
            areaResultados.append(ex.getMessage());
            System.out.println(ex);
        }catch (NullPointerException ex) {
            System.out.println(ex);
            estadoLigacao.setText("Configura a ligacao!");
        }
    }
}


class MainFrame_buttonGet_actionAdapter implements ActionListener {
    private TestPanel adaptee;
    MainFrame_buttonGet_actionAdapter(TestPanel adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.buttonGet_actionPerformed(e);
    }
}


class MainFrame_buttonClear_actionAdapter implements ActionListener {
    private TestPanel adaptee;
    MainFrame_buttonClear_actionAdapter(TestPanel adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.buttonClear_actionPerformed(e);
    }
}
