package bdestudantil;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;

import bdestudantil.jdbc.ConfiguracaoLigacao;
import bdestudantil.jdbc.SetupConnection;
import bdestudantil.jdbc.TestPanel;

/**
 * <p>Title: Base de Dados Estudantil</p>
 *
 * <p>Description: 3ª Fase do Trabalho de Base de Dados II</p>
 *
 * <p>Copyright: Copyright (c) 2005</p>
 *
 * <p>Company: ESTG</p>
 *
 * @author Nelson Rodrigues 10608 e Sérgio Lopes nº10635
 * @version 1.02
 */
public class MainFrame extends JFrame {
    public final static int INSERIR=1;
    public final static int EDITAR=2;
    public final static int CONSULTAR=3;
    public final static int REMOVER=4;

    public MainFrame() {
        try {
            mainFrameInit();
            contentPaneInit();
            jToolBarInit();
            statusBarInit();
            mainMenuInit();
            appInit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void appInit() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    //--Frame-------------------------------------------------------------------
    private void mainFrameInit(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(new Dimension(800, 750));
        setTitle("Base de Dados Estudantil");
    }

    JPanel contentPane;
    private void contentPaneInit(){
        contentPane = (JPanel) getContentPane();
        contentPane.setLayout(new BorderLayout());
    }

    JMenuBar jMenuBar = new JMenuBar();
    JMenu jMenuFile = new JMenu();
    JMenuItem jMenuFileExit = new JMenuItem();
    JMenu jMenuHelp = new JMenu();
    JMenuItem jMenuHelpAbout = new JMenuItem();
    private void jMenuBarInit(){
        jMenuFile.setText("Ficheiro");
        jMenuFileExit.setText("Sair");
        jMenuFileExit.addActionListener(new MainFrame_jMenuFileExit_ActionAdapter(this));
        jMenuHelp.setText("Ajuda");
        jMenuHelpAbout.setText("Acerca");
        jMenuHelpAbout.addActionListener(new MainFrame_jMenuHelpAbout_ActionAdapter(this));

        jMenuBar.add(jMenuFile);
        jMenuFile.add(jMenuFileExit);
        jMenuBar.add(Box.createHorizontalGlue());
        jMenuBar.add(jMenuHelp);
        jMenuHelp.add(jMenuHelpAbout);
        setJMenuBar(jMenuBar);
    }

    JToolBar jToolBar = new JToolBar();
    JButton jButtonLogon = new JButton();
    JButton jButtonLogoff = new JButton();
    JButton jButtonConfigure = new JButton();
    JButton jButtonExit = new JButton();
    private void jToolBarInit(){
        jButtonLogon.setText("Log on");
        jButtonLogon.addActionListener(new MainFrame_jButtonLogon_actionAdapter(this));

        jButtonLogoff.setText("Log off");
        jButtonLogoff.addActionListener(new MainFrame_jButtonLogoff_actionAdapter(this));

        JButton jButtonConfigure = new JButton();
        jButtonConfigure.setText("Configurar ligação");

        jButtonExit.setText("Sair");
        jButtonExit.addActionListener(new MainFrame_jMenuFileExit_ActionAdapter(this));

        jToolBar.add(jButtonLogon);
        jToolBar.add(jButtonLogoff);
        jToolBar.add(jButtonConfigure);
        jButtonLogoff.setVisible(false);

        jButtonConfigure.addActionListener(new MainFrame_jButtonConfigure_actionAdapter(this));
        jToolBar.add(Box.createHorizontalGlue());

        jToolBar.add(jButtonExit);
        jToolBar.setFloatable(false);
        contentPane.add(jToolBar, java.awt.BorderLayout.NORTH);
    }

    JLabel statusBar = new JLabel();
    private void statusBarInit(){
        statusBar.setText("ligação fechada");
        contentPane.add(statusBar, BorderLayout.SOUTH);
    }


    //--TabbedPane--------------------------------------------------------------
    JTabbedPane jTabbedPane = new JTabbedPane();
    private void mainMenuInit() throws Exception {
        jTabbedPane.setTabPlacement(JTabbedPane.LEFT);
        contentPane.add(jTabbedPane, java.awt.BorderLayout.CENTER);
        jPanelInternosInit();
        jTabbedPane.setIconAt(0, new ImageIcon(bdestudantil.MainFrame.class.getResource("resources/images/hat.PNG")));
    }

    JTabbedPane jTabbedInternos = new JTabbedPane();
    private void jPanelInternosInit(){
        jTabbedPane.add(jTabbedInternos, "Internos");
        jPanelAlunosInit();
    }

    //--Inserir/Consultar/Editar/Remover----------------------------------------
    JPanel jPanelAlunos           = new JPanel();
    JPanel jPanelAreaAlunos       = new JPanel();
    JPanel jPanelButtonsAlunos    = new JPanel();
    JButton jButtonInserirAluno   = new JButton("Inserir alunos");
    JButton jButtonConsultarAluno = new JButton("Consultar alunos inseridos");

    private void jPanelAlunosInit(){
        jButtonInserirAluno.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new AreaAluno(jPanelAreaAlunos, ConfiguracaoLigacao.getConf().getCon());
            }
        });
        jButtonConsultarAluno.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new AreaResultados(jPanelAreaAlunos, ConfiguracaoLigacao.getConf().getCon());
            }
        });

        jPanelAlunos.setLayout(new BorderLayout());
        jTabbedInternos.add(jPanelAlunos, "Alunos");
        jPanelAlunos.add(jPanelButtonsAlunos, BorderLayout.NORTH);
        jPanelButtonsAlunos.add(jButtonInserirAluno);
        jPanelButtonsAlunos.add(jButtonConsultarAluno);
        jPanelAlunos.add(jPanelAreaAlunos, BorderLayout.CENTER);
    }

     //--Actions------------------------------------------------------------------------------------------------------------------
    void jMenuFileExit_actionPerformed(ActionEvent actionEvent) {
        System.exit(0);
    }

    void jMenuHelpAbout_actionPerformed(ActionEvent actionEvent) {
        MainFrame_AboutBox dlg = new MainFrame_AboutBox(this);
        Dimension dlgSize = dlg.getPreferredSize();
        Dimension frmSize = getSize();
        Point loc = getLocation();
        dlg.setLocation((frmSize.width - dlgSize.width) / 2 + loc.x, (frmSize.height - dlgSize.height) / 2 + loc.y);
        dlg.setModal(true);
        dlg.pack();
        dlg.setVisible(true);
    }

    public void logon() {
        try {
            ConfiguracaoLigacao c = ConfiguracaoLigacao.getConf();
            c.setCon(DriverManager.getConnection("jdbc:oracle:thin:@" + ConfiguracaoLigacao.getConf().getIp() + ":" + c.getPort() + ":" + c.getBd(), c.getUser(), c.getPass()));
            statusBar.setText(c.getCon().isClosed() ? "ligação fechada" : "ligação aberta");
            jButtonLogon.setVisible(false);
            jButtonLogoff.setVisible(true);
        } catch (SQLException ex) {
            statusBar.setText("erro na configuração da ligação!");
        }
    }

    public void jButtonConfigure_actionPerformed(ActionEvent e) {
        new SetupConnection(this);
    }

    public void jButtonLogon_actionPerformed(ActionEvent e) {
        logon();
    }

    public void jButtonLogoff_actionPerformed(ActionEvent e) {
        logoff();
    }

    public void logoff() {
        ConfiguracaoLigacao c = ConfiguracaoLigacao.getConf();
        try {
            if(c.getCon()!=null){
                c.getCon().close();
                statusBar.setText("ligação fechada");
                jButtonLogon.setVisible(true);
                jButtonLogoff.setVisible(false);
            }
        } catch (SQLException ex) {
            statusBar.setText("erro ao fechar a ligação!");
        }
    }
}

class MainFrame_jButtonLogon_actionAdapter implements ActionListener {
    private MainFrame adaptee;
    MainFrame_jButtonLogon_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jButtonLogon_actionPerformed(e);
    }
}

class MainFrame_jButtonLogoff_actionAdapter implements ActionListener {
    private MainFrame adaptee;
    MainFrame_jButtonLogoff_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jButtonLogoff_actionPerformed(e);
    }
}

class MainFrame_jButtonConfigure_actionAdapter implements ActionListener {
    private MainFrame adaptee;
    MainFrame_jButtonConfigure_actionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jButtonConfigure_actionPerformed(e);
    }
}


class MainFrame_jMenuFileExit_ActionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_jMenuFileExit_ActionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent actionEvent) {
        adaptee.jMenuFileExit_actionPerformed(actionEvent);
    }
}


class MainFrame_jMenuHelpAbout_ActionAdapter implements ActionListener {
    MainFrame adaptee;

    MainFrame_jMenuHelpAbout_ActionAdapter(MainFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent actionEvent) {
        adaptee.jMenuHelpAbout_actionPerformed(actionEvent);
    }
}
