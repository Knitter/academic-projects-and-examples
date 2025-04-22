package j2gether.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.borland.jbcl.layout.VerticalFlowLayout;
import j2gether.audio.PlaySounds;
import j2gether.config.Propriedades;
import j2gether.model.J2Gether;
import j2gether.utilsp4.ImageLoader;
import j2gether.view.adapters.JTableAdapter;
import j2gether.view.listeners.J2GetherEvent;
import j2gether.view.listeners.J2GetherListener;
import j2gether.view.renderers.CellRenderer;



/**
 * <p>Title: J2Gether</p>
 *
 * <p>Description: Primeiro trabalho prático P4</p>
 *
 * <p>Copyright: Copyright (c) 2005</p>
 *
 * <p>Company: 4thFloor</p>
 *
 * @author Sérgio Lopes, Ruben Pedro
 * @version 1.0
 */
public class J2GetherFrame extends JFrame implements J2GetherListener {

    /**
     * Instancia de J2Gether
     */
    private J2Gether jogo;

    /**
     * Tabela responsável por apresentar o tabuleiro de jogo
     */
    private JTable tabuleiro = new JTable();

    /**
     * Item do menu File
     */
    private JMenuItem save;

    /**
     * Item do menu Audio
     */
    private JCheckBoxMenuItem optionMusic;

    /**
     * Item do menu Audio
     */
    private JCheckBoxMenuItem optionSound;

    /**
     * Barra de estado
     */
    private JLabel statusBar = new JLabel();

    /**
     * Label de apresentaçao da pontuação obtida até ao momento
     */
    private JTextField textPontuacaoActual = new JTextField();

    /**
     * Label da pontuação referente à jogada actualmente seleccionada
     */
    private JTextField textPontuacaoJogada = new JTextField();

    /**
     * Botão de undo
     */
    private JButton buttonUndo = new JButton("<<==");

    /**
     * Botão de redo
     */
    private JButton buttonRedo = new JButton("==>>");

    /**
     * Botão que selecciona a jogada com mais peças
     */
    private JButton buttonWizard = new JButton(ImageLoader.getLoader().getIcon("wizard.png"));

    /**
     * Estados do audio do jogo
     */
    private EstadoSom[] sons = {new EstadoSomLigado("/j2gether/sons/"), new EstadoSomDesligado("/j2gether/sons/")};

    /**
     * Estado actual do audio de jogo
     */
    private int estadoSom;

    /**
     * Caminho base onde se encontram os ficheiros de audio
     */
    private PlaySounds music = new PlaySounds("/j2gether/sons/");

    /**
     * Nome do ficheiro de múusica de fundo
     */
    private static final String MUSIC_NAME = "shamlock.mid";

    public J2GetherFrame() {
        try {
            music.loadMusic(MUSIC_NAME);
            jbInit();
            restart(J2Gether.INITIAL_HEIGHT, J2Gether.INITIAL_WIDTH, J2Gether.INITIAL_NUM_COLORS, J2Gether.INITIAL_MODE);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    /**
     * Component initialization.
     *
     * @throws java.lang.Exception
     */
    private void jbInit() throws Exception {
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        WindowAdapter wa = new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                optionExit_actionPerformed(null);
            }
        };
        addWindowListener(wa);

        // Menus
        JMenuBar menuBar = new JMenuBar();
        JMenu menu, subMenu;
        JMenuItem item;

        menu = new JMenu(Propriedades.FILE);
        menu.setMnemonic(Propriedades.FILE.charAt(0));
        menu.add(item = new JMenuItem(Propriedades.NEW_GAME, Propriedades.NEW_GAME.charAt(0)));
        item.addActionListener(new J2GetherFrame_optionNewGame_actionAdapter(this));
        menu.addSeparator();
        menu.add(item = new JMenuItem(Propriedades.LOAD, Propriedades.LOAD.charAt(0)));
        item.addActionListener(new J2GetherFrame_optionLoad_actionAdapter(this));
        menu.add(save = new JMenuItem(Propriedades.SAVE, Propriedades.SAVE.charAt(0)));
        save.addActionListener(new J2GetherFrame_optionSave_actionAdapter(this));
        menu.addSeparator();
        menu.add(item = new JMenuItem(Propriedades.SCORES, Propriedades.SCORES.charAt(0)));
        item.addActionListener(new J2GetherFrame_optionScore_actionAdapter(this));
        menu.addSeparator();
        menu.add(item = new JMenuItem(Propriedades.EXIT, Propriedades.EXIT.charAt(0)));
        item.addActionListener(new J2GetherFrame_optionExit_ActionAdapter(this));
        menuBar.add(menu);
        menu = new JMenu(Propriedades.OPTION);
        menu.setMnemonic(Propriedades.OPTION.charAt(0));
        subMenu = new JMenu(Propriedades.DIMENSION);
        subMenu.setMnemonic(Propriedades.DIMENSION.charAt(0));
        subMenu.add(item = new JMenuItem(Propriedades.EASY, Propriedades.EASY.charAt(0)));
        item.addActionListener(new J2GetherFrame_optionEasy_actionAdapter(this));
        subMenu.add(item = new JMenuItem(Propriedades.NORMAL, Propriedades.NORMAL.charAt(0)));
        item.addActionListener(new J2GetherFrame_optionNormal_actionAdapter(this));
        subMenu.add(item = new JMenuItem(Propriedades.EXPERT, Propriedades.EXPERT.charAt(0)));
        item.addActionListener(new J2GetherFrame_optionExpert_actionAdapter(this));
        subMenu.addSeparator();
        subMenu.add(item = new JMenuItem(Propriedades.COSTUM + "...", Propriedades.COSTUM.charAt(0)));
        item.addActionListener(new J2GetherFrame_optionCustom_actionAdapter(this));
        menu.add(subMenu);
        subMenu = new JMenu(Propriedades.COLORS);
        subMenu.setMnemonic(Propriedades.COLORS.charAt(0));
        subMenu.add(item = new JMenuItem(Propriedades.COLORS_3, KeyEvent.VK_3));
        item.addActionListener(new J2GetherFrame_option3Colours_actionAdapter(this));
        subMenu.add(item = new JMenuItem(Propriedades.COLORS_4, KeyEvent.VK_4));
        item.addActionListener(new J2GetherFrame_option4Colours_actionAdapter(this));
        subMenu.add(item = new JMenuItem(Propriedades.COLORS_5, KeyEvent.VK_5));
        item.addActionListener(new J2GetherFrame_option5Colours_actionAdapter(this));
        menu.add(subMenu);
        subMenu = new JMenu(Propriedades.ALGORITHM);
        subMenu.setMnemonic(Propriedades.ALGORITHM.charAt(0));
        subMenu.add(item = new JMenuItem(Propriedades.RECURSIVE, Propriedades.RECURSIVE.charAt(0)));
        item.addActionListener(new J2GetherFrame_optionRecursive_actionAdapter(this));
        subMenu.add(item = new JMenuItem(Propriedades.ITERATIVE, Propriedades.ITERATIVE.charAt(0)));
        item.addActionListener(new J2GetherFrame_optionIterative_actionAdapter(this));
        menu.add(subMenu);
        menu.addSeparator();
        menu.add(criarAudioMenu());
        menu.addSeparator();
        menu.add(criarMenuLookNFeel());
        menuBar.add(menu);
        menu = new JMenu(Propriedades.HELP);
        menu.setMnemonic(Propriedades.HELP.charAt(0));
        menu.add(item = new JMenuItem(Propriedades.RULES, Propriedades.RULES.charAt(0)));
        item.addActionListener(new J2GetherFrame_optionRules_actionAdapter(this));
        item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
        menu.addSeparator();
        menu.add(item = new JMenuItem(Propriedades.ABOUT, Propriedades.ABOUT.charAt(0)));
        item.addActionListener(new J2GetherFrame_optionAbout_ActionAdapter(this));
        menuBar.add(menu);
        setJMenuBar(menuBar);

        // GUI
        JPanel panel = new JPanel(new VerticalFlowLayout(VerticalFlowLayout.MIDDLE));

        panel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
        panel.add(new JLabel(Propriedades.LABEL_ACTUAL_SCORE));
        panel.add(textPontuacaoActual);
        panel.add(Box.createVerticalStrut(8));
        panel.add(new JLabel(Propriedades.LABEL_PLAY_SCORE));
        panel.add(textPontuacaoJogada);
        panel.add(Box.createVerticalStrut(8));
        panel.add(buttonWizard);
        getContentPane().add(panel, BorderLayout.EAST);

        JPanel panelAux = new JPanel(new BorderLayout());
        panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel.add(buttonUndo);
        panel.add(buttonRedo);
        panelAux.add(panel, BorderLayout.NORTH);
        panel = new JPanel(new VerticalFlowLayout(VerticalFlowLayout.MIDDLE));
        panel.add(tabuleiro);
        panelAux.add(panel, BorderLayout.CENTER);
        panelAux.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
        getContentPane().add(panelAux, BorderLayout.CENTER);
        getContentPane().add(statusBar, BorderLayout.SOUTH);

        textPontuacaoActual.setBackground(Color.green);
        textPontuacaoActual.setDisabledTextColor(Color.black);
        textPontuacaoActual.setEnabled(false);
        textPontuacaoActual.setFont(new java.awt.Font("Dialog", Font.BOLD, 12));
        textPontuacaoActual.setHorizontalAlignment(SwingConstants.TRAILING);

        textPontuacaoJogada.setBackground(Color.green);
        textPontuacaoJogada.setDisabledTextColor(Color.black);
        textPontuacaoJogada.setEnabled(false);
        textPontuacaoJogada.setFont(new java.awt.Font("Dialog", Font.BOLD, 12));
        textPontuacaoJogada.setHorizontalAlignment(SwingConstants.TRAILING);

        buttonUndo.setEnabled(false);
        buttonUndo.setFocusPainted(false);
        buttonUndo.setFont(new java.awt.Font("Dialog", Font.BOLD, 12));
        buttonUndo.addActionListener(new J2GetherFrame_buttonUndo_actionAdapter(this));
        buttonRedo.setEnabled(false);
        buttonRedo.setFocusPainted(false);
        buttonRedo.setFont(new java.awt.Font("Dialog", Font.BOLD, 12));
        buttonRedo.addActionListener(new J2GetherFrame_buttonRedo_actionAdapter(this));

        buttonWizard.setFocusPainted(false);
        buttonWizard.addActionListener(new J2GetherFrame_buttonWizard_actionAdapter(this));

        statusBar.setBorder(BorderFactory.createEtchedBorder());
        statusBar.setPreferredSize(new Dimension(49, 25));

        tabuleiro.setIntercellSpacing(new Dimension(0, 0));
        tabuleiro.setRowHeight(32);
        tabuleiro.setShowHorizontalLines(false);
        tabuleiro.setShowVerticalLines(false);
        tabuleiro.addMouseListener(new J2GetherFrame_tabuleiro_mouseAdapter(this));

        setResizable(false);
        setIconImage(ImageLoader.getLoader().getImage("icon.png"));
    }

    /**
     * Centra a janela no ecan
     */
    public void centerFrame() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = getSize();
        if (frameSize.height > screenSize.height) {
            frameSize.height = screenSize.height;
        }
        if (frameSize.width > screenSize.width) {
            frameSize.width = screenSize.width;
        }
        setLocation((screenSize.width - frameSize.width) / 2,
                          (screenSize.height - frameSize.height) / 2);
    }

    /**
     * Cria uma instância de um menu para alterar o Look & Feel do jogo
     *
     * @return Instância do menu Look & Feel
     */
    private JMenu criarMenuLookNFeel() {
        JMenu menu = new JMenu("Look & Feel");
        menu.setMnemonic(KeyEvent.VK_L);
        ButtonGroup btnGroup = new ButtonGroup();

        final JFrame me = this;
        ActionListener radioListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    UIManager.setLookAndFeel(e.getActionCommand());
                    SwingUtilities.updateComponentTreeUI(me);
                    pack();
                } catch (Exception ex) {
                    System.err.println("Não foi possível alterar a GUI: " + ex);
                }
            }
        };
        JRadioButtonMenuItem rbMenuItem = new JRadioButtonMenuItem("Java Look & Feel");
        if (UIManager.getSystemLookAndFeelClassName().compareTo("javax.swing.plaf.metal.MetalLookAndFeel") == 0)
            rbMenuItem.setSelected(true);
        rbMenuItem.setActionCommand("javax.swing.plaf.metal.MetalLookAndFeel");
        rbMenuItem.setMnemonic(KeyEvent.VK_J);
        rbMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, KeyEvent.ALT_MASK));
        rbMenuItem.setToolTipText("Java Look & Feel");
        rbMenuItem.addActionListener(radioListener);
        btnGroup.add(rbMenuItem);
        menu.add(rbMenuItem);

        rbMenuItem = new JRadioButtonMenuItem("Motif/CDE Look & Feel");
        if (UIManager.getSystemLookAndFeelClassName().compareTo("com.sun.java.swing.plaf.motif.MotifLookAndFeel") == 0)
            rbMenuItem.setSelected(true);
        rbMenuItem.setActionCommand("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
        rbMenuItem.setMnemonic(KeyEvent.VK_C);
        rbMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, KeyEvent.ALT_MASK));
        rbMenuItem.setToolTipText("Motif/CDE Look & Feel");
        rbMenuItem.addActionListener(radioListener);
        btnGroup.add(rbMenuItem);
        menu.add(rbMenuItem);

        rbMenuItem = new JRadioButtonMenuItem("Windows Look & Feel");
        if (UIManager.getSystemLookAndFeelClassName().compareTo("com.sun.java.swing.plaf.windows.WindowsLookAndFeel") == 0)
            rbMenuItem.setSelected(true);
        rbMenuItem.setActionCommand("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        rbMenuItem.setMnemonic(KeyEvent.VK_W);
        rbMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3, KeyEvent.ALT_MASK));
        rbMenuItem.setToolTipText("Win32 Look & Feel");
        rbMenuItem.addActionListener(radioListener);
        btnGroup.add(rbMenuItem);
        menu.add(rbMenuItem);

        return menu;
    }

    /**
     * Cria uma instância de um menu para alterar o audio do jogo
     *
     * @return Instância do menu de audio
     */
    private JMenu criarAudioMenu() {
        JMenu menu = new JMenu(Propriedades.AUDIO);
        menu.setMnemonic(Propriedades.AUDIO.charAt(0));

        ActionListener checkMusicListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (optionMusic.isSelected())
                    music.loop(MUSIC_NAME);
                else
                    music.stop(MUSIC_NAME);
            }
        };
        ActionListener checkSoundListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                alterarEstadoSom();
            }
        };
        optionMusic = new JCheckBoxMenuItem(Propriedades.MUSIC, true);
        optionMusic.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, KeyEvent.CTRL_MASK));
        optionMusic.addActionListener(checkMusicListener);
        menu.add(optionMusic);

        optionSound = new JCheckBoxMenuItem(Propriedades.SOUNDS, true);
        optionSound.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_MASK));
        optionSound.addActionListener(checkSoundListener);
        menu.add(optionSound);

        return menu;
    }

    /**
     * Método que recria um jogo com novos parametros
     *
     * @param altura   - Altura do tabuleiro
     * @param largura  - Largura do tabuleiro
     * @param numCores - Número de cores usadas para criar o tabuleiro
     * @param modoJogo - Modo de selecção de peças que o jogo vai utilizar
     */
    public void restart(int altura, int largura, int numCores, int modoJogo) {
        jogo = new J2Gether(altura, largura, numCores, modoJogo);
        restart();
    }

    /**
     * Método que reinicia um jogo com os parametros actuais
     */
    public void restart() {
        jogo.addJ2GetherListener(this);
        tabuleiro.setModel(new JTableAdapter(jogo));
        tabuleiro.setDefaultRenderer(Object.class, new CellRenderer());
        for (int i = 0; i < tabuleiro.getColumnModel().getColumnCount(); i++)
            tabuleiro.getColumnModel().getColumn(i).setPreferredWidth(32);
        tabuleiro.setEnabled(true);
        setTitle("J2Gether (" + Propriedades.MODE + " " + jogo.getNomeModo() + ")");
        buttonWizard.setEnabled(true);
        save.setEnabled(true);
        pack();
        sons[estadoSom].play(EstadoSom.SND_START);
        textPontuacaoActual.setText(Double.toString(jogo.getPontuacao()));
        textPontuacaoJogada.setText(Double.toString(jogo.getPontuacaoJogada()));
        desactivarBotoesUndoRedo();
    }

    /**
     * Permite alternar entre os estados de som, ligado ou desligado
     */
    private void alterarEstadoSom() {
        estadoSom = (++estadoSom) % 2;
    }

    /**
     * Desactiva os controlos do jogo para impedir que o jogador continue a jogar um jogo terminado
     */
    private void desactivarJogo() {
        tabuleiro.setEnabled(false);
        buttonWizard.setEnabled(false);
        desactivarBotoesUndoRedo();
        save.setEnabled(false);
    }

    /**
     * Desactiva os botões de undo e redo
     */
    private void desactivarBotoesUndoRedo() {
        buttonUndo.setEnabled(false);
        buttonRedo.setEnabled(false);
    }

    /**
     * Método invocado sempre que existam alterações no tabuleiro de jogo. Responsável
     * pelo controlo de eventos do jogo, toque de sons, mensagens, etc.
     *
     * @param e - Objecto com informações sobre o estado do jogo
     */
    public void j2getherChanged(J2GetherEvent e) {
        statusBar.setText("");
        buttonUndo.setEnabled(jogo.undoAllowed());
        buttonRedo.setEnabled(jogo.redoAllowed());
        textPontuacaoActual.setText(Double.toString(jogo.getPontuacao()));
        textPontuacaoJogada.setText(Double.toString(jogo.getPontuacaoJogada()));

        if (e.hasPecasSelected())
            sons[estadoSom].play(EstadoSom.SND_PLOP);
        else
        if (e.isDroped())
            sons[estadoSom].play(EstadoSom.SND_DROP);
        else
        if (e.isInvalida()) {
            statusBar.setText(Propriedades.INVALID_MOVE_MESSAGE);
            sons[estadoSom].play(EstadoSom.SND_WRONG);
        }
        if (e.perdeu()) {
            desactivarJogo();
            sons[estadoSom].play(EstadoSom.SND_LOSE);
            new JOptionPane().showMessageDialog(this, Propriedades.LOSE_MESSAGE + " " + jogo.getPontuacaoFinal());
            enterScoreName();
        } else
        if (e.ganhou()) {
            desactivarJogo();
            sons[estadoSom].play(EstadoSom.SND_WIN);
            new JOptionPane().showMessageDialog(this, Propriedades.WIN_MESSAGE + " " + jogo.getPontuacao());
            enterScoreName();
        }
    }

    /**
     * Método responsável pela introdução dos nomes e pontuações dos jogadores
     */
    private void enterScoreName() {
        if (jogo.getScores().isInsertableScore(jogo.getPontuacaoFinal())) {
            String nome;
            if ((nome = new JOptionPane().showInputDialog(this, Propriedades.INSERT_NAME_MESSAGE)) != null) {
                jogo.getScores().updateScores(nome, jogo.getPontuacaoFinal());
                jogo.getScores().saveScore();
                optionScore_actionPerformed(null);
            }
        }
    }

    /*
     * Invoca a melhor jogada
     *
     * @param e ActionEvent
     */
    public void buttonWizard_actionPerformed(ActionEvent e) {
        jogo.wizard();
        sons[estadoSom].play(EstadoSom.SND_FOOT);
        textPontuacaoJogada.setText(Double.toString(jogo.getPontuacaoJogada()));
    }

    /**
     * Manda executar um undo
     */
    public void buttonUndo_actionPerformed(ActionEvent e) {
        sons[estadoSom].play(EstadoSom.SND_UNDO_REDO);
        jogo.undo();
    }

    /**
     * Manda executar um redo
     */
    public void buttonRedo_actionPerformed(ActionEvent e) {
        sons[estadoSom].play(EstadoSom.SND_UNDO_REDO);
        jogo.redo();
    }

    public J2Gether getJogo() {
        return jogo;
    }

    public void optionScore_actionPerformed(ActionEvent e) {
        J2GetherFrame_Score dlg = new J2GetherFrame_Score(this);
        Dimension dlgSize = dlg.getPreferredSize();
        Dimension frmSize = getSize();
        Point loc = getLocation();
        try {
        dlg.setLocation((frmSize.width - dlgSize.width) / 2 + loc.x,(frmSize.height - dlgSize.height) / 2 + loc.y);
        dlg.pack();
        dlg.show();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    void optionExit_actionPerformed(ActionEvent actionEvent) {
        if (JOptionPane.showConfirmDialog(J2GetherFrame.this, Propriedades.EXIT_DLG_MESSAGE, "J2Gether", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            dispose();
            System.exit(0);
        }
    }

    void optionAbout_actionPerformed(ActionEvent actionEvent) {
        J2GetherFrame_AboutBox dlg = new J2GetherFrame_AboutBox(this);
        Dimension dlgSize = dlg.getPreferredSize();
        Dimension frmSize = getSize();
        Point loc = getLocation();
        dlg.setLocation((frmSize.width - dlgSize.width) / 2 + loc.x,
                        (frmSize.height - dlgSize.height) / 2 + loc.y);
        dlg.setModal(true);
        dlg.pack();
        dlg.show();
    }

    public void optionRules_actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(this, Propriedades.RULES_TEXT, Propriedades.RULES_WINDOW_TITLE, JOptionPane.INFORMATION_MESSAGE);
    }

    public void tabuleiro_mousePressed(MouseEvent e) {
        if(tabuleiro.isEnabled())
            jogo.jogar(tabuleiro.rowAtPoint(e.getPoint()), tabuleiro.columnAtPoint(e.getPoint()));
    }

    public void optionNewGame_actionPerformed(ActionEvent e) {
        restart(jogo.getHeight(), jogo.getWidth(), jogo.getNumCores(), jogo.getModoActual());
    }

    public void optionEasy_actionPerformed(ActionEvent e) {
        restart(10, 10, jogo.getNumCores(), jogo.getModoActual());
        centerFrame();
    }

    public void optionNormal_actionPerformed(ActionEvent e) {
        restart(10, 15, jogo.getNumCores(), jogo.getModoActual());
        centerFrame();
    }

    public void optionExpert_actionPerformed(ActionEvent e) {
        restart(15, 15, jogo.getNumCores(), jogo.getModoActual());
        centerFrame();
    }

    public void option3Colours_actionPerformed(ActionEvent e) {
        restart(jogo.getHeight(), jogo.getWidth(), 3, jogo.getModoActual());
    }

    public void option4Colours_actionPerformed(ActionEvent e) {
        restart(jogo.getHeight(), jogo.getWidth(), 4, jogo.getModoActual());
    }

    public void option5Colours_actionPerformed(ActionEvent e) {
        restart(jogo.getHeight(), jogo.getWidth(), 5, jogo.getModoActual());
    }

    public void optionRecursive_actionPerformed(ActionEvent e) {
        jogo.alterarModo(J2Gether.ModoJ2Gether.RECURSIVO);
        setTitle("J2Gether (" + Propriedades.MODE + " " + jogo.getNomeModo() + ")");
    }

    public void optionIterative_actionPerformed(ActionEvent e) {
        jogo.alterarModo(J2Gether.ModoJ2Gether.ITERATIVO);
        setTitle("J2Gether (" + Propriedades.MODE + " " + jogo.getNomeModo() + ")");
    }

    public void optionSave_actionPerformed(ActionEvent e) {
        JFileChooser op = new JFileChooser();
        if (op.showSaveDialog(this) == JFileChooser.APPROVE_OPTION)
            jogo.save(op.getSelectedFile());
    }

    public void optionLoad_actionPerformed(ActionEvent e) {
        JFileChooser op = new JFileChooser();
        if (op.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            jogo = J2Gether.load(op.getSelectedFile());
            restart();
        }
    }

    public void optionCustom_actionPerformed(ActionEvent e) {
        J2GetherFrame_Custom dlg = new J2GetherFrame_Custom(this);
        Point loc = getLocation();
        dlg.setLocation((getSize().width - dlg.getPreferredSize().width) / 2 + loc.x,
                        (getSize().height - dlg.getPreferredSize().height) / 2 + loc.y);
        dlg.pack();
        dlg.show();
    }

}



///////// Action Listeners /////////////////////////////////////////////////////

class J2GetherFrame_buttonUndo_actionAdapter implements ActionListener {
    private J2GetherFrame adaptee;
    J2GetherFrame_buttonUndo_actionAdapter(J2GetherFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.buttonUndo_actionPerformed(e);
    }
}

class J2GetherFrame_buttonRedo_actionAdapter implements ActionListener {
    private J2GetherFrame adaptee;
    J2GetherFrame_buttonRedo_actionAdapter(J2GetherFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.buttonRedo_actionPerformed(e);
    }
}

class J2GetherFrame_optionCustom_actionAdapter implements ActionListener {
    private J2GetherFrame adaptee;
    J2GetherFrame_optionCustom_actionAdapter(J2GetherFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.optionCustom_actionPerformed(e);
    }
}


class J2GetherFrame_optionLoad_actionAdapter implements ActionListener {
    private J2GetherFrame adaptee;
    J2GetherFrame_optionLoad_actionAdapter(J2GetherFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.optionLoad_actionPerformed(e);
    }
}


class J2GetherFrame_optionIterative_actionAdapter implements ActionListener {
    private J2GetherFrame adaptee;
    J2GetherFrame_optionIterative_actionAdapter(J2GetherFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.optionIterative_actionPerformed(e);
    }
}


class J2GetherFrame_optionSave_actionAdapter implements ActionListener {
    private J2GetherFrame adaptee;
    J2GetherFrame_optionSave_actionAdapter(J2GetherFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.optionSave_actionPerformed(e);
    }
}


class J2GetherFrame_optionRecursive_actionAdapter implements ActionListener {
    private J2GetherFrame adaptee;
    J2GetherFrame_optionRecursive_actionAdapter(J2GetherFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.optionRecursive_actionPerformed(e);
    }
}


class J2GetherFrame_option5Colours_actionAdapter implements ActionListener {
    private J2GetherFrame adaptee;
    J2GetherFrame_option5Colours_actionAdapter(J2GetherFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.option5Colours_actionPerformed(e);
    }
}


class J2GetherFrame_option4Colours_actionAdapter implements ActionListener {
    private J2GetherFrame adaptee;
    J2GetherFrame_option4Colours_actionAdapter(J2GetherFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.option4Colours_actionPerformed(e);
    }
}


class J2GetherFrame_option3Colours_actionAdapter implements ActionListener {
    private J2GetherFrame adaptee;
    J2GetherFrame_option3Colours_actionAdapter(J2GetherFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.option3Colours_actionPerformed(e);
    }
}


class J2GetherFrame_optionExpert_actionAdapter implements ActionListener {
    private J2GetherFrame adaptee;
    J2GetherFrame_optionExpert_actionAdapter(J2GetherFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.optionExpert_actionPerformed(e);
    }
}


class J2GetherFrame_optionEasy_actionAdapter implements ActionListener {
    private J2GetherFrame adaptee;
    J2GetherFrame_optionEasy_actionAdapter(J2GetherFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.optionEasy_actionPerformed(e);
    }
}


class J2GetherFrame_optionNewGame_actionAdapter implements ActionListener {
    private J2GetherFrame adaptee;
    J2GetherFrame_optionNewGame_actionAdapter(J2GetherFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.optionNewGame_actionPerformed(e);
    }
}


class J2GetherFrame_optionNormal_actionAdapter implements ActionListener {
    private J2GetherFrame adaptee;
    J2GetherFrame_optionNormal_actionAdapter(J2GetherFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.optionNormal_actionPerformed(e);
    }
}


class J2GetherFrame_buttonWizard_actionAdapter implements ActionListener {
    private J2GetherFrame adaptee;
    J2GetherFrame_buttonWizard_actionAdapter(J2GetherFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.buttonWizard_actionPerformed(e);
    }
}


class J2GetherFrame_optionExit_ActionAdapter implements ActionListener {
    private J2GetherFrame adaptee;

    J2GetherFrame_optionExit_ActionAdapter(J2GetherFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent actionEvent) {
        adaptee.optionExit_actionPerformed(actionEvent);
    }
}


class J2GetherFrame_optionAbout_ActionAdapter implements ActionListener {
    private J2GetherFrame adaptee;

    J2GetherFrame_optionAbout_ActionAdapter(J2GetherFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent actionEvent) {
        adaptee.optionAbout_actionPerformed(actionEvent);
    }
}

class J2GetherFrame_optionScore_actionAdapter implements ActionListener {
    private J2GetherFrame adaptee;
    J2GetherFrame_optionScore_actionAdapter(J2GetherFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.optionScore_actionPerformed(e);
    }
}

class J2GetherFrame_optionRules_actionAdapter implements ActionListener {
    private J2GetherFrame adaptee;
    J2GetherFrame_optionRules_actionAdapter(J2GetherFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.optionRules_actionPerformed(e);
    }
}


///////// Mouse Adapters ///////////////////////////////////////////////////////

class J2GetherFrame_tabuleiro_mouseAdapter extends MouseAdapter {
    private J2GetherFrame adaptee;
    J2GetherFrame_tabuleiro_mouseAdapter(J2GetherFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void mousePressed(MouseEvent e) {
        adaptee.tabuleiro_mousePressed(e);
    }
}
