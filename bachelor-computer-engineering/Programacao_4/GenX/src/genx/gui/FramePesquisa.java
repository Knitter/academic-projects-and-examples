package genx.gui;

import java.util.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import com.borland.jbcl.layout.*;
import com.toedter.calendar.*;
import genx.listas.*;
import genx.modelo.*;

/**
 * <p>Title: GenX</p>
 *
 * <p>Description: Aplicação que permite gerir árvores genealógicas</p>
 *
 * <p>Copyright: Copyright (c) 2005</p>
 *
 * <p>Company: 4thFloor</p>
 *
 * @author not attributable
 * @version 1.0
 */
public class FramePesquisa extends JDialog {
    private ArvoreGeneologica arvore;
    private QuickSearch quickSearch = new QuickSearch();

    private JTabbedPane tabbedPane = new JTabbedPane();
    private JTextField inputNome = new JTextField();
    private JTextField inputingNome = new JTextField();
    private JDateChooser dateChooser = new JDateChooser();
    private JList listaResultadosNome = new JList();
    private JList listaResultadosData = new JList();

    private static final String NO_RESULTS = "** NÃO FORAM ENCONTRADOS RESULTADOS **";
    private static final String NO_INPUT = "** POR FAVOR ESPECIFIQUE UM NOME **";

    public static final int PESQUISA_NOME = 0;
    public static final int PESQUISA_DATA = 1;

    public FramePesquisa(Frame owner, ArvoreGeneologica arvore, int tabIndex) {
        super(owner, "Pesquisar", true);
        try {
            jbInit();
            this.arvore = arvore;
            tabbedPane.setSelectedIndex(tabIndex);
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    if (tabbedPane.getSelectedIndex() == 0)
                        inputingNome.requestFocus();
                    else
                        dateChooser.getSpinner().requestFocus();
                }
            });
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        JPanel aPanel1;
        JPanel aPanel2;
        JButton aButton;
        JLabel aLabel;
        FlowLayout aFlowLayout = new FlowLayout(FlowLayout.LEFT);

        setSize(new Dimension(500, 400));
        setResizable(false);
        getContentPane().setLayout(new BorderLayout());

        aButton = new JButton("OK");
        ActionListener btnOKActionListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        };
        aButton.addActionListener(btnOKActionListener);

        aPanel1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        aPanel1.add(aButton);
        getContentPane().add(aPanel1, BorderLayout.SOUTH);

        VerticalFlowLayout vf = new VerticalFlowLayout();
        vf.setVgap(0);
        aPanel1 = new JPanel(vf);

        aLabel = new JLabel("Pesquisa Rápida:");
        aLabel.setPreferredSize(new Dimension(90, 20));
        aPanel2 = new JPanel(aFlowLayout);
        aPanel2.add(aLabel);
        inputingNome.setPreferredSize(new Dimension(250, 20));
        inputingNome.getDocument().addDocumentListener(new FramePesquisa_inputingNome_keyAdapter(this));
        aPanel2.add(inputingNome);
        aPanel1.add(aPanel2);

        aLabel = new JLabel("Consultar Nomes:");
        aLabel.setPreferredSize(new Dimension(90, 20));
        aPanel2 = new JPanel(aFlowLayout);
        aPanel2.add(aLabel);
        inputNome.setPreferredSize(new Dimension(250, 20));
        inputNome.addKeyListener(new FramePesquisa_inputNome_keyAdapter(this));
        aPanel2.add(inputNome);
        aButton = new JButton("Pesquisar");
        aButton.addActionListener(new FramePesquisa_buttonPesquisarNome_actionAdapter(this));
        aPanel2.add(aButton);
        aPanel1.add(aPanel2);

        aPanel2 = new JPanel(new BorderLayout());
        aPanel2.add(aPanel1, BorderLayout.NORTH);
        aPanel2.add(new JScrollPane(listaResultadosNome), BorderLayout.CENTER);
        tabbedPane.add(aPanel2, "Nome");

        aPanel2 = new JPanel(aFlowLayout);
        aPanel2.add(new JLabel("Escolha a Data"));
        aPanel2.add(dateChooser);
        aButton = new JButton("Pesquisar");
        aButton.addActionListener(new FramePesquisa_buttonPesquisarData_actionAdapter(this));
        aPanel2.add(aButton);

        aPanel1 = new JPanel(new BorderLayout());
        aPanel1.add(aPanel2, BorderLayout.NORTH);
        aPanel1.add(new JScrollPane(listaResultadosData), BorderLayout.CENTER);
        tabbedPane.add(aPanel1, "Data");

        getContentPane().add(tabbedPane, BorderLayout.CENTER);
    }

    public void centrar() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = getSize();
        if (frameSize.height > screenSize.height) {
            frameSize.height = screenSize.height;
        }
        if (frameSize.width > screenSize.width) {
            frameSize.width = screenSize.width;
        }
        setLocation( (screenSize.width - frameSize.width) / 2,
                          (screenSize.height - frameSize.height) / 2);
    }

    public void buttonPesquisarNome_actionPerformed(ActionEvent e) {
        Iterador it = arvore.consultarPorNome(inputNome.getText());
        Vector v = new Vector();

        if (inputNome.getText().equals(""))
            v.add(NO_INPUT);
        else {
            while (it.podeAvancar())
                v.add(it.avancar());

            if (v.isEmpty())
                v.add(NO_RESULTS);
        }
        listaResultadosNome.setListData(v);
    }

    public void buttonPesquisarData_actionPerformed(ActionEvent e) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(dateChooser.getDate());
        Iterador it = arvore.consultarPessoasVivasEm(calendar);

        Vector v = new Vector();
        while (it.podeAvancar())
            v.add(it.avancar());

        if (v.isEmpty())
            v.add(NO_RESULTS);

        listaResultadosData.setListData(v);
    }

    private void refreshList(Iterador it) {

        Vector v = new Vector();

        if (inputingNome.getText().equals(""))
            v.add(NO_INPUT);
        else {
            while (it.podeAvancar())
                v.add(it.avancar());

            if (v.isEmpty())
                v.add(NO_RESULTS);
        }
        listaResultadosNome.setListData(v);
    }

    public void inputingNomeSearch_keyAdapter(KeyEvent e) {
        refreshList(quickSearch.getNext());

    }

    public void resetLstaResultados() {
        refreshList(quickSearch.getBack());
    }

    private class QuickSearch {
        private ListaSimplesCircularBaseFim listaResultados = new ListaSimplesCircularBaseFim();
        private ListaDuplaCircularBaseFim listaUndos = new ListaDuplaCircularBaseFim();

        private Iterador getNext() {
            Iterador it = listaResultados.iteradorLista();
            ListaSimplesCircularBaseFim aux = new ListaSimplesCircularBaseFim();

            while (it.podeAvancar())
                aux.inserir(it.avancar());

            listaUndos.inserir(aux);

            it = arvore.consultarPorNomeOnTheFly(inputingNome.getText(), listaResultados);

            listaResultados.removerTodos();
            while (it.podeAvancar())
                listaResultados.inserir(it.avancar());

            return listaResultados.iteradorLista();
        }

        private Iterador getBack() {
            listaResultados =((ListaSimplesCircularBaseFim) listaUndos.removerUltimo());
            return listaResultados.iteradorLista();
        }
    }
}

class FramePesquisa_buttonPesquisarData_actionAdapter
    implements ActionListener {
    private FramePesquisa adaptee;
    FramePesquisa_buttonPesquisarData_actionAdapter(FramePesquisa adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.buttonPesquisarData_actionPerformed(e);
    }
}

class FramePesquisa_buttonPesquisarNome_actionAdapter
    implements ActionListener {
    private FramePesquisa adaptee;
    FramePesquisa_buttonPesquisarNome_actionAdapter(FramePesquisa adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.buttonPesquisarNome_actionPerformed(e);
    }
}

class FramePesquisa_inputNome_keyAdapter
    extends KeyAdapter {
    private FramePesquisa adaptee;
    FramePesquisa_inputNome_keyAdapter(FramePesquisa adaptee) {
        this.adaptee = adaptee;
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == KeyEvent.VK_ENTER)
            adaptee.buttonPesquisarNome_actionPerformed(null);
    }
}

class FramePesquisa_inputingNome_keyAdapter
    implements DocumentListener {
    private FramePesquisa adaptee;
    FramePesquisa_inputingNome_keyAdapter(FramePesquisa adaptee) {
        this.adaptee = adaptee;
    }

    public void changedUpdate(DocumentEvent e) {
    }

    public void insertUpdate(DocumentEvent e) {
        adaptee.inputingNomeSearch_keyAdapter(null);
    }

    public void removeUpdate(DocumentEvent e) {
        adaptee.resetLstaResultados();
        adaptee.inputingNomeSearch_keyAdapter(null);
    }
}
