package genx.gui;

import java.beans.*;
import java.io.*;
import java.util.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import componenteGeneologia.*;
import genx.gui.properties.*;
import genx.gui.representations.*;
import genx.gui.save.*;
import genx.gui.selections.*;
import genx.listas.*;
import genx.modelo.*;
import genx.modelo.eventos.*;
import genx.utils.*;

/**
 * <p>Title: GenX</p>
 *
 * <p>Description: Aplicação que permite gerir árvores genealógicas</p>
 *
 * <p>Copyright: Copyright (c) 2005</p>
 *
 * <p>Company: 4thFloor</p>
 *
 * @author Sérgio Lopes, Ruben Pedro
 * @version 1.0
 */
public class GenXFrame extends JFrame implements ArvoreGeneologicaListener, RelacionamentoListener {

    private ArvoreGeneologica arvore = new ArvoreGeneologica();

    private JPanel contentPane;
    private PainelBase painelBase = new PainelBase();
    private JSplitPane splitPane = new JSplitPane();

    private JToggleButton buttonAddPessoaMasculina = new JToggleButton(ImageLoader.getLoader().getIcon("/genx/imagens/btnAddPessoaMale.png"));
    private JToggleButton buttonAddPessoaFeminina = new JToggleButton(ImageLoader.getLoader().getIcon("/genx/imagens/btnAddPessoaFemale.png"));
    private JToggleButton buttonAssociationAsc = new JToggleButton(ImageLoader.getLoader().getIcon("/genx/imagens/association.png"));
    private JToggleButton buttonAssociationDesc = new JToggleButton(ImageLoader.getLoader().getIcon("/genx/imagens/child.png"));

    private PropertiesArvore propertiesArvore = new PropertiesArvore(arvore);
    private PropertiesPessoa propertiesPessoa = new PropertiesPessoa(splitPane);
    private PropertiesRelacionamento propertiesRelacionamento = new PropertiesRelacionamento(splitPane);

    private SelectionGroup seleccao;
    private Point posicaoAddRepresentacao;

    private Cursor cursorDefault = new Cursor(Cursor.DEFAULT_CURSOR);
    private Cursor cursorAddFemale = Toolkit.getDefaultToolkit().createCustomCursor(ImageLoader.getLoader().getImage("/genx/imagens/addPessoaFemale.png"), new Point(11,11), "cursorFemale");
    private Cursor cursorAddMale = Toolkit.getDefaultToolkit().createCustomCursor(ImageLoader.getLoader().getImage("/genx/imagens/addPessoaMale.png"), new Point(11,11), "cursorMale");
    private Cursor cursorAssociation = Toolkit.getDefaultToolkit().createCustomCursor(ImageLoader.getLoader().getImage("/genx/imagens/association.png"), new Point(11,11), "cursorAssociation");
    private Cursor cursorChildAssociation = Toolkit.getDefaultToolkit().createCustomCursor(ImageLoader.getLoader().getImage("/genx/imagens/child.png"), new Point(11,11), "cursorChildAssociation");

    private boolean dirtyBit = true;

    public GenXFrame() {
        try {
            jbInit();
            arvore.addArvoreGeneologicaListener(this);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        JMenuBar aMenuBar = new JMenuBar();
        JMenu aMenu;
        JMenuItem aMenuItem;
        JToolBar aToolBar = new JToolBar();
        JPanel aPanel;
        JButton aButton;
        JPopupMenu aPopupMenu = new JPopupMenu();

        setTitle("GenX");
        setSize(new Dimension(800, 600));

        WindowAdapter wa = new WindowAdapter()  {
            public void windowClosing(WindowEvent evt)  {
                menuFileExit_actionPerformed(null);
            }
        };
        addWindowListener(wa);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        PropertyChangeListener pcl = new PropertyChangeListener()  {
            public void propertyChange(PropertyChangeEvent evt) {
                if (evt.getPropertyName().equals("dividerLocation")) {
                    Dimension dim = new Dimension(((Integer)evt.getNewValue()).intValue() - 1, 300);
                    propertiesArvore.setPreferredSize(dim);
                    propertiesPessoa.setPreferredSize(dim);
                    propertiesRelacionamento.setPreferredSize(dim);
                }
            }
        };
        splitPane.addPropertyChangeListener(pcl);

        contentPane = (JPanel) getContentPane();
        contentPane.setLayout(new BorderLayout());

        aMenu = new JMenu("Ficheiro");
        aMenuItem = new JMenuItem("Nova Árvore", ImageLoader.getLoader().getIcon("/genx/imagens/iconNew.png"));
        aMenuItem.addActionListener(new GenXFrame_menuFileNew_actionAdapter(this));
        aMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_MASK));
        aMenu.add(aMenuItem);
        aMenu.addSeparator();
        aMenuItem = new JMenuItem("Carregar Árvore", ImageLoader.getLoader().getIcon("/genx/imagens/iconOpen.png"));
        aMenuItem.addActionListener(new GenXFrame_menuFileLoad_actionAdapter(this));
        aMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_MASK));
        aMenu.add(aMenuItem);
        aMenuItem = new JMenuItem("Gravar Árvore", ImageLoader.getLoader().getIcon("/genx/imagens/iconSave.png"));
        aMenuItem.addActionListener(new GenXFrame_menuFileSave_actionAdapter(this));
        aMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_MASK));
        aMenu.add(aMenuItem);
        aMenu.addSeparator();
        aMenuItem = new JMenuItem("Sair");
        aMenuItem.addActionListener(new GenXFrame_menuFileExit_ActionAdapter(this));
        aMenu.add(aMenuItem);
        aMenuBar.add(aMenu);
        aMenu = new JMenu("Ajuda");
        aMenuItem = new JMenuItem("Sobre...");
        aMenuItem.addActionListener(new GenXFrame_menuHelpAbout_ActionAdapter(this));
        aMenu.add(aMenuItem);
        aMenuBar.add(aMenu);
        setJMenuBar(aMenuBar);

        aToolBar.setFloatable(false);
        aButton = new JButton(ImageLoader.getLoader().getIcon("/genx/imagens/iconNew.png"));
        aButton.setToolTipText("Nova Árvore");
        aButton.addActionListener(new GenXFrame_buttonNew_actionAdapter(this));
        aToolBar.add(aButton);
        aButton = new JButton(ImageLoader.getLoader().getIcon("/genx/imagens/iconOpen.png"));
        aButton.setToolTipText("Carregar Árvore");
        aButton.addActionListener(new GenXFrame_buttonOpen_actionAdapter(this));
        aToolBar.add(aButton);
        aButton = new JButton(ImageLoader.getLoader().getIcon("/genx/imagens/iconSave.png"));
        aButton.setToolTipText("Gravar Árvore");
        aButton.addActionListener(new GenXFrame_buttonSave_actionAdapter(this));
        aToolBar.add(aButton);
        aToolBar.addSeparator();
        aButton = new JButton(ImageLoader.getLoader().getIcon("/genx/imagens/findByName.png"));
        aButton.setToolTipText("Procurar pessoas através do nome");
        aButton.addActionListener(new GenXFrame_buttonFindByName_actionAdapter(this));
        aToolBar.add(aButton);
        aButton = new JButton(ImageLoader.getLoader().getIcon("/genx/imagens/findByDate.png"));
        aButton.setToolTipText("Procurar pessoas vivas numa determinada data");
        aButton.addActionListener(new GenXFrame_buttonFindByDate_actionAdapter(this));
        aToolBar.add(aButton);
        aToolBar.addSeparator();
        aButton = new JButton(ImageLoader.getLoader().getIcon("/genx/imagens/recycler.png"));
        aButton.setToolTipText("Apagar objectos seleccionados");
        aButton.addActionListener(new GenXFrame_buttonTrash_actionAdapter(this));
        aToolBar.add(aButton);
        aToolBar.addSeparator();
        buttonAddPessoaMasculina.setToolTipText("Adicionar uma pessoa masculina");
        buttonAddPessoaMasculina.addActionListener(new GenXFrame_buttonAddPessoaMasculina_actionAdapter(this));
        aToolBar.add(buttonAddPessoaMasculina);
        buttonAddPessoaFeminina.setToolTipText("Adicionar uma pessoa feminina");
        buttonAddPessoaFeminina.addActionListener(new GenXFrame_buttonAddPessoaFeminina_actionAdapter(this));
        aToolBar.add(buttonAddPessoaFeminina);
        aToolBar.addSeparator();
        buttonAssociationAsc.setToolTipText("Criar relacionamento entre duas pessoas");
        buttonAssociationAsc.addActionListener(new GenXFrame_buttonAssociationAsc_actionAdapter(this));
        aToolBar.add(buttonAssociationAsc);
        buttonAssociationDesc.setToolTipText("Criar filiação");
        buttonAssociationDesc.addActionListener(new GenXFrame_buttonAssociationDesc_actionAdapter(this));
        aToolBar.add(buttonAssociationDesc);
        aPanel = new JPanel();
        aPanel.add(aToolBar);
        contentPane.add(aPanel, java.awt.BorderLayout.NORTH);
        aMenuItem = new JMenuItem("Adicionar Pessoa de Sexo Masculino", ImageLoader.getLoader().getScaledIcon("/genx/imagens/addPessoaMale.png", 16, 16));
        aMenuItem.addActionListener(new GenXFrame_menuAddMacho_actionAdapter(this));
        aPopupMenu.add(aMenuItem);
        aMenuItem = new JMenuItem("Adicionar Pessoa de Sexo Feminino", ImageLoader.getLoader().getScaledIcon("/genx/imagens/addPessoaFemale.png", 16, 16));
        aMenuItem.addActionListener(new GenXFrame_menuAddFemea_actionAdapter(this));
        aPopupMenu.add(aMenuItem);
        aPopupMenu.addSeparator();
        aMenuItem = new JMenuItem("Pesquisar Pessoas por Nome", ImageLoader.getLoader().getScaledIcon("/genx/imagens/findByName.png", 16, 16));
        aMenuItem.addActionListener(new GenXFrame_menuFindByName_actionAdapter(this));
        aPopupMenu.add(aMenuItem);
        aMenuItem = new JMenuItem("Pesquisar Pessoas Vivas por Data", ImageLoader.getLoader().getScaledIcon("/genx/imagens/findByDate.png", 16, 16));
        aMenuItem.addActionListener(new GenXFrame_menuFindByDate_actionAdapter(this));
        aPopupMenu.add(aMenuItem);
        painelBase.setPopupMenu(aPopupMenu);

        splitPane.setLeftComponent(propertiesArvore);
        splitPane.setRightComponent(painelBase);
        contentPane.add(splitPane, java.awt.BorderLayout.CENTER);

        painelBase.getPainelContentor().addMouseListener(new GenXFrame_painelBase_mouseAdapter(this));
        painelBase.adicionarAtalhoTeclado("Delete", KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0), new GenXFrame_painelBase_Delete_actionAdapter(this));
        painelBase.adicionarAtalhoTeclado("SelectAll", KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_MASK), new GenXFrame_painelBase_SelectAll_actionAdapter(this));
    }

    public void pessoaAdded(ArvoreGeneologicaEvent event) {
        RepresentacaoPessoa p = new RepresentacaoPessoa(event.getPessoa1(), arvore);
        p.addRepresentacaoListener(propertiesPessoa);
        painelBase.addComponent(p, posicaoAddRepresentacao);
        painelBase.unselectAll();
        p.select();
        propertiesPessoa.seleccionarNome();
        dirtyBit = false;
    }

    public void pessoaRemoved(ArvoreGeneologicaEvent event) {
         painelBase.removeComponent(painelBase.getComponent(event.getPessoa1()));
         dirtyBit = false;
    }

    public void relacionamentoParentAdded(ArvoreGeneologicaEvent event) {
        RepresentacaoPessoa p1 = (RepresentacaoPessoa) painelBase.getComponent(event.getPessoa1());
        RepresentacaoPessoa p2 = (RepresentacaoPessoa) painelBase.getComponent(event.getPessoa2());
        RepresentacaoRelacionamento r = new RepresentacaoRelacionamento(event.getRelacionamento(), arvore);
        r.addRepresentacaoListener(propertiesRelacionamento);
        painelBase.addComponent(r, new Point((p1.getX() + p2.getX()) / 2, p1.getY() + 50));
        Association associacao1 = new Association(p1, r);
        Association associacao2 = new Association(p2, r);
        r.adicionarAssociacaoAscendente(((Pessoa)p1.getOwner()).getSexo(), associacao1);
        r.adicionarAssociacaoAscendente(((Pessoa)p2.getOwner()).getSexo(), associacao2);
        painelBase.unselectAll();
        r.select();
        despressionarToggleButtons();
        event.getRelacionamento().addRelacionamentoListener(this);
        dirtyBit = false;
    }

    public void relacionamentoChildAdded(ArvoreGeneologicaEvent event) {
        RepresentacaoRelacionamento r = (RepresentacaoRelacionamento)painelBase.getComponent(event.getRelacionamento());
        ChildAssociation associacao = new ChildAssociation(painelBase.getComponent(event.getPessoa1()), r);
        ((RepresentacaoPessoa)painelBase.getComponent(event.getPessoa1())).setAssociacaoDescendente(associacao);
        despressionarToggleButtons();
        event.getRelacionamento().addRelacionamentoListener(this);
        dirtyBit = false;
    }

    public void relacionamentoChanged(ArvoreGeneologicaEvent event) {
        RepresentacaoRelacionamento r = (RepresentacaoRelacionamento)painelBase.getComponent(event.getRelacionamento());
        Association associacao = new Association(painelBase.getComponent(event.getPessoa1()), r);
        r.adicionarAssociacaoAscendente(event.getPessoa1().getSexo(), associacao);
        despressionarToggleButtons();
        dirtyBit = false;
    }

    public void relacionamentoRemoved(ArvoreGeneologicaEvent event) {
        painelBase.removeComponent(painelBase.getComponent(event.getRelacionamento()));
        dirtyBit = false;
    }

    public void dataInicioChanged(RelacionamentoEvent event) {
    }

    public void dataFimChanged(RelacionamentoEvent event) {
    }

    public void filhoAdded(RelacionamentoEvent event) {
    }

    public void filhoRemoved(RelacionamentoEvent event) {
        ((RepresentacaoPessoa)painelBase.getComponent(event.getFilho())).removerAssociacaoDescendente();
        dirtyBit = false;
    }

    public void progenitorAdded(RelacionamentoEvent event) {
    }

    public void progenitorRemoved(RelacionamentoEvent event) {
        ((RepresentacaoRelacionamento)painelBase.getComponent(event.getSource())).removerAssociacaoAscendente(event.getNovoProgenitorFeminino() == null ? Pessoa.SEXO_FEMININO : Pessoa.SEXO_MASCULINO);
        dirtyBit = false;
    }

    public void progenitorChanged(RelacionamentoEvent event) {
    }

    private void buttonsAssociationPressed(SelectionGroup s) {
        if (buttonAssociationAsc.isSelected() || buttonAssociationDesc.isSelected()) {
            Iterator it = painelBase.getPainelContentor().consultComponents();
            it = painelBase.getPainelContentor().consultComponents();
            seleccao = s;
            while (it.hasNext())
                ( (Representacao) it.next()).addRepresentacaoListener(seleccao);
        }
    }

    private void despressionarToggleButtons() {
        removeListenersDasRepresentacoes();
        unselectAllButtons();
    }

    private void removeListenersDasRepresentacoes() {
        Iterator it = painelBase.getPainelContentor().consultComponents();
        while (it.hasNext())
            ( (Representacao) it.next()).removeRepresentacaoListener(seleccao);
    }

    private void unselectAllButtons() {
        buttonAssociationDesc.setSelected(false);
        buttonAssociationAsc.setSelected(false);
        buttonAddPessoaMasculina.setSelected(false);
        buttonAddPessoaFeminina.setSelected(false);
        setCursor(cursorDefault);
    }

    public void selectAllComponents() {
        painelBase.selectAll();
    }

    private boolean saveArvore() {
        JFileChooser file;
        File f;
        if (arvore.validarArvore()) {
            file = new JFileChooser();
            file.showSaveDialog(this);
            if ( (f = file.getSelectedFile()) != null) {
                new SaveGenX(arvore, painelBase.getPainelContentor().consultComponents()).save(f);
                dirtyBit = true;
                return true;
            }
        }
        else
            new JOptionPane().showMessageDialog(this, "Árvore inválida!\nPor favor verifique a sua consistência.");

        return false;
    }

    private boolean podeDescartarArvore() {
        if (dirtyBit)
            return true;

        int op = JOptionPane.showConfirmDialog(this, "A árvore foi alterada. Deseja Gravar?", "Atenção", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
        if (op == JOptionPane.YES_OPTION)
            return saveArvore();
        else if (op == JOptionPane.NO_OPTION)
            return true;
        return false;
    }



///////// Action Performers ////////////////////////////////////////////////////

    public void menuFileNew_actionPerformed(ActionEvent e) {
        if (podeDescartarArvore()) {
            painelBase.removeAllComponents();
            arvore = new ArvoreGeneologica();
            arvore.addArvoreGeneologicaListener(this);
            splitPane.setLeftComponent(propertiesArvore = new PropertiesArvore(arvore));
            Pessoa.resetNumeroPessoas();
            dirtyBit = true;
        }
    }

    public void menuFileLoad_actionPerformed(ActionEvent e) {
        if (podeDescartarArvore()) {
            JFileChooser fileChooser;
            File file;
            SaveGenX loadGenX;
            Iterador it;
            SaveRepresentacaoPessoa saveRP;
            RepresentacaoPessoa rp;
            SaveRepresentacaoRelacionamento saveRR;
            RepresentacaoRelacionamento rr;

            fileChooser = new JFileChooser();
            fileChooser.showOpenDialog(this);
            if ( (file = fileChooser.getSelectedFile()) != null) {
                painelBase.removeAllComponents();
                loadGenX = SaveGenX.load(file);
                arvore = loadGenX.getArvore();
                arvore.addArvoreGeneologicaListener(this);
                dirtyBit = true;
                it = loadGenX.getListaPessoas();
                while (it.podeAvancar()) {
                    saveRP = (SaveRepresentacaoPessoa) it.avancar();

                    rp = new RepresentacaoPessoa(saveRP.getPessoa(), loadGenX.getArvore());
                    rp.setBorder(BorderFactory.createLineBorder(Color.gray, 2));
                    rp.addRepresentacaoListener(propertiesPessoa);
                    painelBase.addComponent(rp, saveRP.getPosicao());
                }

                it = loadGenX.getListaRelacionamentos();
                while (it.podeAvancar()) {
                    saveRR = (SaveRepresentacaoRelacionamento) it.avancar();

                    rr = new RepresentacaoRelacionamento(saveRR.getRelacionamento(), loadGenX.getArvore());
                    rr.setBorder(BorderFactory.createLineBorder(Color.gray, 2));
                    rr.addRepresentacaoListener(propertiesRelacionamento);
                    painelBase.addComponent(rr, saveRR.getPosicao());
                }

                it = loadGenX.getListaPessoas();
                while (it.podeAvancar()) {
                    saveRP = (SaveRepresentacaoPessoa) it.avancar();
                    if (saveRP.getAssociacao() != null)
                        ( (RepresentacaoPessoa) painelBase.getComponent(saveRP.getPessoa())).setAssociacaoDescendente(new ChildAssociation(painelBase.
                            getComponent(saveRP.getAssociacao().getBegin()), painelBase.getComponent(saveRP.getAssociacao().getEnd())));
                }

                it = loadGenX.getListaRelacionamentos();
                while (it.podeAvancar()) {
                    saveRR = (SaveRepresentacaoRelacionamento) it.avancar();
                    if (saveRR.getAssociacao(Pessoa.SEXO_MASCULINO) != null)
                        ( (RepresentacaoRelacionamento) painelBase.getComponent(saveRR.getRelacionamento())).adicionarAssociacaoAscendente(Pessoa.
                            SEXO_MASCULINO,
                            new Association(painelBase.getComponent(saveRR.getAssociacao(Pessoa.SEXO_MASCULINO).getBegin()),
                                            painelBase.getComponent(saveRR.getAssociacao(Pessoa.SEXO_MASCULINO).getEnd())));
                    if (saveRR.getAssociacao(Pessoa.SEXO_FEMININO) != null)
                        ( (RepresentacaoRelacionamento) painelBase.getComponent(saveRR.getRelacionamento())).adicionarAssociacaoAscendente(Pessoa.
                            SEXO_FEMININO,
                            new Association(painelBase.getComponent(saveRR.getAssociacao(Pessoa.SEXO_FEMININO).getBegin()),
                                            painelBase.getComponent(saveRR.getAssociacao(Pessoa.SEXO_FEMININO).getEnd())));

                }
                splitPane.setLeftComponent(propertiesArvore = new PropertiesArvore(arvore));
            }
        }
    }

    public void menuFileSave_actionPerformed(ActionEvent e) {
        saveArvore();
    }

    void menuFileExit_actionPerformed(ActionEvent actionEvent) {
        if (podeDescartarArvore())  {
            dispose();
            System.exit(0);
        }
    }

    void menuHelpAbout_actionPerformed(ActionEvent actionEvent) {
        GenXFrame_AboutBox dlg = new GenXFrame_AboutBox(this);
        Dimension dlgSize = dlg.getPreferredSize();
        Dimension frmSize = getSize();
        Point loc = getLocation();
        dlg.setLocation( (frmSize.width - dlgSize.width) / 2 + loc.x,
                        (frmSize.height - dlgSize.height) / 2 + loc.y);
        dlg.setModal(true);
        dlg.pack();
        dlg.show();
    }

    public void buttonNew_actionPerformed(ActionEvent e) {
        menuFileNew_actionPerformed(e);
    }

    public void buttonOpen_actionPerformed(ActionEvent e) {
        menuFileLoad_actionPerformed(e);
    }

    public void buttonSave_actionPerformed(ActionEvent e) {
        menuFileSave_actionPerformed(e);
    }

    public void buttonFindByName_actionPerformed(ActionEvent e) {
        despressionarToggleButtons();
        FramePesquisa fp = new FramePesquisa(this, arvore, FramePesquisa.PESQUISA_NOME);
        fp.centrar();
        fp.show();
    }

    public void buttonFindByDate_actionPerformed(ActionEvent e) {
        despressionarToggleButtons();
        FramePesquisa fp = new FramePesquisa(this, arvore, FramePesquisa.PESQUISA_DATA);
        fp.centrar();
        fp.show();
    }

    public void buttonTrash_actionPerformed(EventObject e) {
        if (JOptionPane.showConfirmDialog(this, "Deseja remover os elementos seleccionados?", "Atenção", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
            ListaSimplesCircularBaseFim l = new ListaSimplesCircularBaseFim();
            Iterator it = painelBase.consultComponents();
            Representacao r = null;
            while (it.hasNext()) {
                r = (Representacao) it.next();
                if (r.isSelected())
                    l.inserir(r);
            }
            Iterador it2 = l.iteradorLista();
            while (it2.podeAvancar())
                ((Representacao) it2.avancar()).remover();
            splitPane.setLeftComponent(propertiesArvore);
            buttonAssociationDesc.setSelected(false);
            buttonAssociationAsc.setSelected(false);
            buttonAddPessoaMasculina.setSelected(false);
            buttonAddPessoaFeminina.setSelected(false);
            despressionarToggleButtons();
        }
    }

    public void buttonAddPessoaMasculina_actionPerformed(ActionEvent e) {
        removeListenersDasRepresentacoes();
        buttonAssociationDesc.setSelected(false);
        buttonAssociationAsc.setSelected(false);
        buttonAddPessoaFeminina.setSelected(false);
        if(buttonAddPessoaMasculina.isSelected() )
            setCursor(cursorAddMale);
        else
            unselectAllButtons();
    }

    public void buttonAddPessoaFeminina_actionPerformed(ActionEvent e) {
        removeListenersDasRepresentacoes();
        buttonAssociationDesc.setSelected(false);
        buttonAssociationAsc.setSelected(false);
        buttonAddPessoaMasculina.setSelected(false);
        if(buttonAddPessoaFeminina.isSelected() )
            setCursor(cursorAddFemale);
        else
            unselectAllButtons();
    }

    public void buttonAssociationAsc_actionPerformed(ActionEvent e) {
        removeListenersDasRepresentacoes();
        buttonsAssociationPressed(new SelectionGroupAscendente(arvore));
        buttonAssociationDesc.setSelected(false);
        buttonAddPessoaMasculina.setSelected(false);
        buttonAddPessoaFeminina.setSelected(false);
        if(buttonAssociationAsc.isSelected())
            setCursor(cursorAssociation);
        else
            unselectAllButtons();
    }

    public void buttonAssociationDesc_actionPerformed(ActionEvent e) {
        removeListenersDasRepresentacoes();
        buttonsAssociationPressed(new SelectionGroupDescendente(arvore));
        buttonAssociationAsc.setSelected(false);
        buttonAddPessoaMasculina.setSelected(false);
        buttonAddPessoaFeminina.setSelected(false);
        if(buttonAssociationDesc.isSelected())
            setCursor(cursorChildAssociation);
        else
            unselectAllButtons();
    }

    public void menuAddMacho_actionPerformed(ActionEvent e) {
        arvore.addPessoa(new Pessoa(Pessoa.SEXO_MASCULINO));
    }

    public void menuAddFemea_actionPerformed(ActionEvent e) {
        arvore.addPessoa(new Pessoa(Pessoa.SEXO_FEMININO));
    }

    public void menuFindByName_actionPerformed(ActionEvent e) {
        buttonFindByName_actionPerformed(e);
    }

    public void menuFindByDate_actionPerformed(ActionEvent e) {
        buttonFindByDate_actionPerformed(e);
    }

    public void painelBase_mouseClicked(MouseEvent e) {
        posicaoAddRepresentacao = new Point(e.getPoint());
        if (getCursor().getName().equals(cursorAddMale.getName()))
            arvore.addPessoa(new Pessoa(Pessoa.SEXO_MASCULINO));
        else {
            if (getCursor().getName().equals(cursorAddFemale.getName()))
                arvore.addPessoa(new Pessoa(Pessoa.SEXO_FEMININO));
            else {
                painelBase.unselectAll();
                splitPane.setLeftComponent(propertiesArvore);
            }
        }
        despressionarToggleButtons();
    }

}



///////// Action Adapters //////////////////////////////////////////////////////

class GenXFrame_menuFileNew_actionAdapter
    implements ActionListener {
    private GenXFrame adaptee;
    GenXFrame_menuFileNew_actionAdapter(GenXFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.menuFileNew_actionPerformed(e);
    }
}

class GenXFrame_menuFileLoad_actionAdapter
    implements ActionListener {
    private GenXFrame adaptee;
    GenXFrame_menuFileLoad_actionAdapter(GenXFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.menuFileLoad_actionPerformed(e);
    }
}

class GenXFrame_menuFileSave_actionAdapter implements ActionListener {

    private GenXFrame adaptee;
    GenXFrame_menuFileSave_actionAdapter(GenXFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.menuFileSave_actionPerformed(e);
    }
}

class GenXFrame_menuFileExit_ActionAdapter
    implements ActionListener {
    GenXFrame adaptee;

    GenXFrame_menuFileExit_ActionAdapter(GenXFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent actionEvent) {
        adaptee.menuFileExit_actionPerformed(actionEvent);
    }
}

class GenXFrame_menuHelpAbout_ActionAdapter
    implements ActionListener {
    GenXFrame adaptee;

    GenXFrame_menuHelpAbout_ActionAdapter(GenXFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent actionEvent) {
        adaptee.menuHelpAbout_actionPerformed(actionEvent);
    }
}

class GenXFrame_buttonNew_actionAdapter
    implements ActionListener {
    private GenXFrame adaptee;
    GenXFrame_buttonNew_actionAdapter(GenXFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.buttonNew_actionPerformed(e);
    }
}

class GenXFrame_buttonOpen_actionAdapter
    implements ActionListener {
    private GenXFrame adaptee;
    GenXFrame_buttonOpen_actionAdapter(GenXFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.buttonOpen_actionPerformed(e);
    }
}

class GenXFrame_buttonSave_actionAdapter
    implements ActionListener {
    private GenXFrame adaptee;
    GenXFrame_buttonSave_actionAdapter(GenXFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.buttonSave_actionPerformed(e);
    }
}

class GenXFrame_buttonFindByName_actionAdapter implements ActionListener {
    private GenXFrame adaptee;
    GenXFrame_buttonFindByName_actionAdapter(GenXFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.buttonFindByName_actionPerformed(e);
    }
}

class GenXFrame_buttonFindByDate_actionAdapter implements ActionListener {
    private GenXFrame adaptee;
    GenXFrame_buttonFindByDate_actionAdapter(GenXFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.buttonFindByDate_actionPerformed(e);
    }
}

class GenXFrame_buttonTrash_actionAdapter
    implements ActionListener {
    private GenXFrame adaptee;
    GenXFrame_buttonTrash_actionAdapter(GenXFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.buttonTrash_actionPerformed(e);
    }
}

class GenXFrame_buttonAddPessoaMasculina_actionAdapter
    implements ActionListener {
    private GenXFrame adaptee;
    GenXFrame_buttonAddPessoaMasculina_actionAdapter(GenXFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.buttonAddPessoaMasculina_actionPerformed(e);
    }
}

class GenXFrame_buttonAddPessoaFeminina_actionAdapter
    implements ActionListener {
    private GenXFrame adaptee;
    GenXFrame_buttonAddPessoaFeminina_actionAdapter(GenXFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.buttonAddPessoaFeminina_actionPerformed(e);
    }
}

class GenXFrame_buttonAssociationAsc_actionAdapter
    implements ActionListener {
    private GenXFrame adaptee;
    GenXFrame_buttonAssociationAsc_actionAdapter(GenXFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.buttonAssociationAsc_actionPerformed(e);
    }
}

class GenXFrame_buttonAssociationDesc_actionAdapter
    implements ActionListener {
    private GenXFrame adaptee;
    GenXFrame_buttonAssociationDesc_actionAdapter(GenXFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.buttonAssociationDesc_actionPerformed(e);
    }
}

class GenXFrame_menuAddMacho_actionAdapter
    implements ActionListener {
    private GenXFrame adaptee;
    GenXFrame_menuAddMacho_actionAdapter(GenXFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.menuAddMacho_actionPerformed(e);
    }
}

class GenXFrame_menuAddFemea_actionAdapter
    implements ActionListener {
    private GenXFrame adaptee;
    GenXFrame_menuAddFemea_actionAdapter(GenXFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.menuAddFemea_actionPerformed(e);
    }
}

class GenXFrame_menuFindByName_actionAdapter
    implements ActionListener {
    private GenXFrame adaptee;
    GenXFrame_menuFindByName_actionAdapter(GenXFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.menuFindByName_actionPerformed(e);
    }
}

class GenXFrame_menuFindByDate_actionAdapter
    implements ActionListener {
    private GenXFrame adaptee;
    GenXFrame_menuFindByDate_actionAdapter(GenXFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.menuFindByDate_actionPerformed(e);
    }
}

class GenXFrame_painelBase_mouseAdapter
    extends MouseAdapter {
    private GenXFrame adaptee;
    GenXFrame_painelBase_mouseAdapter(GenXFrame adaptee) {
        this.adaptee = adaptee;
    }

    public void mouseClicked(MouseEvent e) {
        adaptee.painelBase_mouseClicked(e);
    }
}

class GenXFrame_painelBase_actionAdapter implements Action {
    private GenXFrame adaptee;
    GenXFrame_painelBase_actionAdapter(GenXFrame adaptee) {
        this.adaptee = adaptee;
    }

    public GenXFrame getAdaptee() {
        return adaptee;
    }

    public void actionPerformed(ActionEvent e) {}
    public void addPropertyChangeListener(PropertyChangeListener listener) {}
    public Object getValue(String key) {return null;}
    public boolean isEnabled() {return true;}
    public void putValue(String key, Object value) {}
    public void removePropertyChangeListener(PropertyChangeListener listener) {}
    public void setEnabled(boolean b) {}
}

class GenXFrame_painelBase_Delete_actionAdapter extends
    GenXFrame_painelBase_actionAdapter {
    GenXFrame_painelBase_Delete_actionAdapter(GenXFrame adaptee) {
        super(adaptee);
    }

    public void actionPerformed(ActionEvent e) {
        getAdaptee().buttonTrash_actionPerformed(e);
    }
}

class GenXFrame_painelBase_SelectAll_actionAdapter extends
    GenXFrame_painelBase_actionAdapter {
    GenXFrame_painelBase_SelectAll_actionAdapter(GenXFrame adaptee) {
        super(adaptee);
    }

    public void actionPerformed(ActionEvent e) {
        getAdaptee().selectAllComponents();
    }
}
