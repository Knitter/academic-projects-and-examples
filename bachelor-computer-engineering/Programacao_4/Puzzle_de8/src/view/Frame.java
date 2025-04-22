package view;

/**
 * <p>Title: Puzzle de 8</p>
 * <p>Description: Implementação do puzzle de 8 - ficha 2</p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: .none</p>
 * @author Knitter
 * @version 1.0
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import model.Puzzle;
import controller.PuzzleListener;
import controller.TableController;
import controller.CellRenderer;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.util.ResourceBundle;
import config.Languages;

public class Frame extends JFrame implements PuzzleListener{
  JPanel mainPanel;
  JMenuBar menuBar = new JMenuBar();
  JMenu menuFile = new JMenu();
  JMenuItem menuFileExit = new JMenuItem();
  JMenu menuHelp = new JMenu();
  JMenuItem menuHelpAbout = new JMenuItem();
  BorderLayout borderLayoutMainPanel = new BorderLayout();
  JPanel toolPanel = new JPanel();
  JLabel lblRow = new JLabel();
  JTextField txtFieldRow = new JTextField();
  JLabel lblColumn = new JLabel();
  JTextField txtFieldColumn = new JTextField();
  JButton buttonMove = new JButton();
  JPanel gamePanel = new JPanel();
  BorderLayout borderLayoutGamePanel = new BorderLayout();
  JTextArea txtArea = new JTextArea();
  JMenuItem menuScramble = new JMenuItem();
  JMenu menuPerseverance = new JMenu();
  JMenuItem menuSave = new JMenuItem();
  JMenuItem menuLoad = new JMenuItem();
  FlowLayout flowLayoutToolPanel = new FlowLayout();
  FlowLayout flowLayoutTablePanel = new FlowLayout();

  /**
   * Knitter
   * */
  private Puzzle puzzle = new Puzzle();
  JTable table = new JTable(new TableController(puzzle));
  JMenu menuMudarPuzzle = new JMenu();
  JMenuItem menuImagemOriginal = new JMenuItem();
  JMenuItem menuImagemB3n = new JMenuItem();
  JMenuItem menuImagemXico = new JMenuItem();
  JMenuItem menuImagem1 = new JMenuItem();
  JMenuItem menuImagem2 = new JMenuItem();
  JMenuItem menuImagem3 = new JMenuItem();
  JPanel tablePanel = new JPanel();
  JMenuItem menuMoreImages = new JMenuItem();
  JMenuItem menuScore = new JMenuItem();
  JMenuItem menuRules = new JMenuItem();
  JMenuItem menuHowTo = new JMenuItem();

  //Construct the frame
  public Frame() {
    enableEvents(AWTEvent.WINDOW_EVENT_MASK);
    try {
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }
  //Component initialization
  private void jbInit() throws Exception  {
    mainPanel = (JPanel) this.getContentPane();
    buttonMove.setPreferredSize(new Dimension(64, 25));
    buttonMove.setToolTipText("");
    buttonMove.setText(Languages.LBL_MOVE);
    buttonMove.addActionListener(new Frame_buttonMove_actionAdapter(this));
    mainPanel.setLayout(borderLayoutMainPanel);
    this.setSize(new Dimension(Languages.WINDOW_WIDTH, Languages.WINDOW_HEIGHT));
    this.setTitle(Languages.WINDOW_TITLE);
    menuFile.setText(Languages.MENU_FILE);
    menuFileExit.setText(Languages.OPTION_EXIT);
    menuFileExit.addActionListener(new Frame_menuFileExit_ActionAdapter(this));
    menuHelp.setText(Languages.MENU_HELP);
    menuHelpAbout.setText(Languages.OPTION_ABOUT);
    menuHelpAbout.addActionListener(new Frame_menuHelpAbout_ActionAdapter(this));
    lblRow.setText(Languages.LBL_LINE + ":");
    txtFieldRow.setPreferredSize(new Dimension(30, 21));
    txtFieldRow.setText("0");
    lblColumn.setText(Languages.LBL_COLUMN + ":");
    txtFieldColumn.setPreferredSize(new Dimension(30, 21));
    txtFieldColumn.setText("0");
    gamePanel.setLayout(borderLayoutGamePanel);
    txtArea.setText("jTextArea1");
    menuScramble.setActionCommand("Scramble");
    menuScramble.setText(Languages.OPTION_SCRAMBLE);
    menuScramble.addActionListener(new Frame_menuScramble_actionAdapter(this));
    menuPerseverance.setActionCommand("Perseverance");
    menuPerseverance.setText(Languages.MENU_PERSEVERANCE);
    menuSave.setActionCommand("Save");
    menuSave.setText(Languages.OPTION_SAVE);
    menuSave.addActionListener(new Frame_menuSave_actionAdapter(this));
    menuLoad.setActionCommand("Load");
    menuLoad.setText(Languages.OPTION_LOAD);
    menuLoad.addActionListener(new Frame_menuLoad_actionAdapter(this));
    txtArea.setFont(new java.awt.Font("Monospaced", 1, 20));
    txtArea.setEditable(false);
    table.setAutoscrolls(false);
    table.setDebugGraphicsOptions(0);
    table.setMaximumSize(new Dimension(282, 282));
    table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    table.setColumnSelectionAllowed(true);
    table.setRowHeight(Languages.IMAGE_SIZE);
    table.addMouseListener(new Frame_table_mouseAdapter(this));
    menuMudarPuzzle.setActionCommand("MudarPuzzle");
    menuMudarPuzzle.setText(Languages.MENU_CHANGE_PUZZLE_IMAGE);
    menuImagemOriginal.setText(Languages.OPTION_ORIGINAL);
    menuImagemOriginal.addActionListener(new Frame_menuImagemOriginal_actionAdapter(this));
    menuImagemB3n.setText(Languages.OPTION_B3N);
    menuImagemB3n.addActionListener(new Frame_menuImagemB3n_actionAdapter(this));
    menuImagemXico.setText(Languages.OPTION_X1C0);
    menuImagemXico.addActionListener(new Frame_menuImagemXico_actionAdapter(this));
    menuImagem1.setText(Languages.OPTION_IMAGE1);
    menuImagem2.setText(Languages.OPTION_IMAGE2);
    menuImagem3.setText(Languages.OPTION_IMAGE3);
    menuImagem1.addActionListener(new Frame_menuImagem1_actionAdapter(this));
    menuImagem2.addActionListener(new Frame_menuImagem2_actionAdapter(this));
    menuImagem3.addActionListener(new Frame_menuImagem3_actionAdapter(this));
    toolPanel.setLayout(flowLayoutToolPanel);
    flowLayoutToolPanel.setAlignment(FlowLayout.CENTER);
    tablePanel.setLayout(flowLayoutTablePanel);
    menuMoreImages.setActionCommand("MoreImages");
    menuMoreImages.setText(Languages.OPTION_MORE);
    menuMoreImages.addActionListener(new Frame_menuMoreImages_actionAdapter(this));
    menuScore.setActionCommand("Score");
    menuScore.setText(Languages.OPTION_SCORE);
    menuScore.addActionListener(new Frame_menuScore_actionAdapter(this));
    menuRules.setActionCommand("Rules");
    menuRules.setText(Languages.OPTION_RULES);
    menuRules.addActionListener(new Frame_menuRules_actionAdapter(this));
    menuHowTo.setActionCommand("HowTo");
    menuHowTo.setText(Languages.OPTION_ADD_IMAGES);
    menuHowTo.addActionListener(new Frame_menuHowTo_actionAdapter(this));
    toolPanel.add(lblRow, null);
    menuFile.add(menuMudarPuzzle);
    menuFile.add(menuScramble);
    menuFile.add(menuScore);
    menuFile.addSeparator();
    menuFile.add(menuFileExit);
    menuHelp.add(menuHelpAbout);
    menuHelp.add(menuRules);
    menuHelp.add(menuHowTo);
    menuBar.add(menuFile);
    menuBar.add(menuPerseverance);
    menuBar.add(menuHelp);
    mainPanel.add(toolPanel, BorderLayout.NORTH);
    toolPanel.add(txtFieldRow, null);
    toolPanel.add(lblColumn, null);
    toolPanel.add(txtFieldColumn, null);
    toolPanel.add(buttonMove, null);
    mainPanel.add(gamePanel,  BorderLayout.CENTER);
    gamePanel.add(txtArea,  BorderLayout.SOUTH);
    menuPerseverance.add(menuSave);
    menuPerseverance.add(menuLoad);
    menuMudarPuzzle.add(menuImagemOriginal);
    menuMudarPuzzle.addSeparator();
    menuMudarPuzzle.add(menuImagemB3n);
    menuMudarPuzzle.add(menuImagemXico);
    menuMudarPuzzle.add(menuImagem1);
    menuMudarPuzzle.add(menuImagem2);
    menuMudarPuzzle.add(menuImagem3);
    menuMudarPuzzle.add(menuMoreImages);
    gamePanel.add(tablePanel, BorderLayout.NORTH);
    tablePanel.add(table, null);
    this.setJMenuBar(menuBar);

    /**
     * Knitter INIT
     * */
    txtArea.setText(puzzle.toString());
    puzzle.addPuzzleListener(this);
    table.setDefaultRenderer(Object.class, new CellRenderer());
    int x = -1, count = table.getColumnModel().getColumnCount();
    while (++x < count)
      table.getColumnModel().getColumn(x).setPreferredWidth(Languages.IMAGE_SIZE);
  }
  //File | Exit action performed
  public void menuFileExit_actionPerformed(ActionEvent e) {
    System.exit(0);
  }
  //Help | About action performed
  public void menuHelpAbout_actionPerformed(ActionEvent e) {
    Frame_AboutBox dlg = new Frame_AboutBox(this);
    Dimension dlgSize = dlg.getPreferredSize();
    Dimension frmSize = getSize();
    Point loc = getLocation();
    dlg.setLocation((frmSize.width - dlgSize.width) / 2 + loc.x, (frmSize.height - dlgSize.height) / 2 + loc.y);
    dlg.setModal(true);
    dlg.pack();
    dlg.show();
  }
  //Overridden so we can exit when window is closed
  protected void processWindowEvent(WindowEvent e) {
    super.processWindowEvent(e);
    if (e.getID() == WindowEvent.WINDOW_CLOSING) {
      menuFileExit_actionPerformed(null);
    }
  }

  public void puzzleChanged() {
    txtArea.setText(puzzle.toString());
  }

  void buttonMove_actionPerformed(ActionEvent e) {
    if(puzzle.mover(Integer.parseInt(txtFieldRow.getText()) ,Integer.parseInt(txtFieldColumn.getText()))) {
      puzzle.incNumMovimentos();
      verificarFimJogo();
    }
  }

  void table_mouseClicked(MouseEvent e) {
    if(puzzle.mover(table.rowAtPoint(e.getPoint()), table.columnAtPoint(e.getPoint()))) {
      puzzle.incNumMovimentos();
      verificarFimJogo();
    }
  }

  void menuScramble_actionPerformed(ActionEvent e) {
    puzzle.scranble();
  }

  void menuSave_actionPerformed(ActionEvent e) {
    JFileChooser option = new JFileChooser();
    FileOutputStream save = null;
    if (option.showSaveDialog(this) == JFileChooser.APPROVE_OPTION)
      try {
        ObjectOutputStream out = new ObjectOutputStream(save = new FileOutputStream(option.getSelectedFile()));
        out.writeObject(puzzle);
      }
      catch (IOException ex) {
      }
    finally {
      if (save != null)
        try {
          save.close();
        }
        catch (IOException ex1) {
        }
    }
  }

  void menuLoad_actionPerformed(ActionEvent e) {
    JFileChooser option = new JFileChooser();
    FileInputStream open = null;
    if (option.showOpenDialog(this) == JFileChooser.APPROVE_OPTION)
      try {
        ObjectInputStream in = new ObjectInputStream(open = new FileInputStream(option.getSelectedFile()));
        puzzle = (Puzzle) in.readObject();
        puzzle.addPuzzleListener(this);
        table.setModel(new TableController(puzzle));
        table.setDefaultRenderer(Object.class, new CellRenderer());
        for (int x = 0; x < table.getColumnModel().getColumnCount(); x++)
          table.getColumnModel().getColumn(x).setPreferredWidth(Languages.IMAGE_SIZE);
        puzzle.firePuzzleChanged();
      }
      catch (ClassNotFoundException ex2) {
      }
      catch (IOException ex) {
      }
    finally {
      if (open != null)
        try {
          open.close();
        }
        catch (IOException ex1) {
        }
    }
  }
  /**
   * Verifica se o jogo terminou
   * */
  private void verificarFimJogo() {
    if (puzzle.isConcluido()) {
      new JOptionPane().showMessageDialog(this, "Jogo terminado com " + puzzle.getNumMovimentos() + " jogadas");
      puzzle.resetNumMovimentos();
    }
  }

  /**
   * Altera as imagens do puzzle
   * */
  private void mudarPuzzle(int valorBase) {
    puzzle = new Puzzle(valorBase);
    puzzle.addPuzzleListener(this);
    table.setModel(new TableController(puzzle));
    table.setDefaultRenderer(Object.class, new CellRenderer());
    for (int x = 0; x < table.getColumnModel().getColumnCount(); x++)
      table.getColumnModel().getColumn(x).setPreferredWidth(Languages.IMAGE_SIZE);
    puzzle.firePuzzleChanged();
  }

  /**
   * Cara do B3N
   * */
  void menuImagemB3n_actionPerformed(ActionEvent e) {
    mudarPuzzle(9);
  }

  void menuImagemXico_actionPerformed(ActionEvent e) {
    mudarPuzzle(25);
  }

  void menuImagem1_actionPerformed(ActionEvent e) {
    mudarPuzzle(17);
  }

  void menuImagem2_actionPerformed(ActionEvent e) {
    mudarPuzzle(41);
  }

  void menuImagem3_actionPerformed(ActionEvent e) {
    new JOptionPane().showMessageDialog(this, "Por implementar");
  }

  void menuImagemOriginal_actionPerformed(ActionEvent e) {
    mudarPuzzle(1);
  }

  void menuRules_actionPerformed(ActionEvent e) {
     new JOptionPane().showMessageDialog(this, "Por implementar");
  }

  void menuHowTo_actionPerformed(ActionEvent e) {
    new JOptionPane().showMessageDialog(this, "Por implementar");
  }

  void menuScore_actionPerformed(ActionEvent e) {
    new JOptionPane().showMessageDialog(this, "Por implementar");
  }

  void menuMoreImages_actionPerformed(ActionEvent e) {
    JOptionPane input = new JOptionPane();
    input.setWantsInput(true);
    input.showInputDialog(this, Languages.TXT_INSERT);
    try {
      //mudarPuzzle(Integer.parseInt( (String) input.getInputValue()));
      System.out.println(input.getValue());
    }
    catch (NumberFormatException ex) {
      System.out.println(input.getValue());
      new JOptionPane().showMessageDialog(this,  Languages.TXT_NUMBER_ERROR);
    }

  }
}

class Frame_menuFileExit_ActionAdapter implements ActionListener {
  Frame adaptee;

  Frame_menuFileExit_ActionAdapter(Frame adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.menuFileExit_actionPerformed(e);
  }
}

class Frame_menuHelpAbout_ActionAdapter implements ActionListener {
  Frame adaptee;

  Frame_menuHelpAbout_ActionAdapter(Frame adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.menuHelpAbout_actionPerformed(e);
  }
}

class Frame_buttonMove_actionAdapter implements java.awt.event.ActionListener {
  Frame adaptee;

  Frame_buttonMove_actionAdapter(Frame adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.buttonMove_actionPerformed(e);
  }
}

class Frame_table_mouseAdapter extends java.awt.event.MouseAdapter {
  Frame adaptee;

  Frame_table_mouseAdapter(Frame adaptee) {
    this.adaptee = adaptee;
  }
  public void mouseClicked(MouseEvent e) {
    adaptee.table_mouseClicked(e);
  }
}

class Frame_menuScramble_actionAdapter implements java.awt.event.ActionListener {
  Frame adaptee;

  Frame_menuScramble_actionAdapter(Frame adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.menuScramble_actionPerformed(e);
  }
}

class Frame_menuSave_actionAdapter implements java.awt.event.ActionListener {
  Frame adaptee;

  Frame_menuSave_actionAdapter(Frame adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.menuSave_actionPerformed(e);
  }
}

class Frame_menuLoad_actionAdapter implements java.awt.event.ActionListener {
  Frame adaptee;

  Frame_menuLoad_actionAdapter(Frame adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.menuLoad_actionPerformed(e);
  }
}

class Frame_menuImagemB3n_actionAdapter implements java.awt.event.ActionListener {
  Frame adaptee;

  Frame_menuImagemB3n_actionAdapter(Frame adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.menuImagemB3n_actionPerformed(e);
  }
}

class Frame_menuImagemXico_actionAdapter implements java.awt.event.ActionListener {
  Frame adaptee;

  Frame_menuImagemXico_actionAdapter(Frame adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.menuImagemXico_actionPerformed(e);
  }
}

class Frame_menuImagem1_actionAdapter implements java.awt.event.ActionListener {
  Frame adaptee;

  Frame_menuImagem1_actionAdapter(Frame adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.menuImagem1_actionPerformed(e);
  }
}

class Frame_menuImagem2_actionAdapter implements java.awt.event.ActionListener {
  Frame adaptee;

  Frame_menuImagem2_actionAdapter(Frame adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.menuImagem2_actionPerformed(e);
  }
}

class Frame_menuImagem3_actionAdapter implements java.awt.event.ActionListener {
  Frame adaptee;

  Frame_menuImagem3_actionAdapter(Frame adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.menuImagem3_actionPerformed(e);
  }
}

class Frame_menuImagemOriginal_actionAdapter implements java.awt.event.ActionListener {
  Frame adaptee;

  Frame_menuImagemOriginal_actionAdapter(Frame adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.menuImagemOriginal_actionPerformed(e);
  }
}

class Frame_menuRules_actionAdapter implements java.awt.event.ActionListener {
  Frame adaptee;

  Frame_menuRules_actionAdapter(Frame adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.menuRules_actionPerformed(e);
  }
}

class Frame_menuHowTo_actionAdapter implements java.awt.event.ActionListener {
  Frame adaptee;

  Frame_menuHowTo_actionAdapter(Frame adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.menuHowTo_actionPerformed(e);
  }
}

class Frame_menuScore_actionAdapter implements java.awt.event.ActionListener {
  Frame adaptee;

  Frame_menuScore_actionAdapter(Frame adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.menuScore_actionPerformed(e);
  }
}

class Frame_menuMoreImages_actionAdapter implements java.awt.event.ActionListener {
  Frame adaptee;

  Frame_menuMoreImages_actionAdapter(Frame adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.menuMoreImages_actionPerformed(e);
  }
}
