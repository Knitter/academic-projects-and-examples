/*
 * index.java
 *
 * Created on 12/Fev/2008, 11:37:12
 * Copyright ei10608
 */
package gestorrequisicoeswar;

import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.component.Body;
import com.sun.webui.jsf.component.Button;
import com.sun.webui.jsf.component.DropDown;
import com.sun.webui.jsf.component.Form;
import com.sun.webui.jsf.component.Head;
import com.sun.webui.jsf.component.Html;
import com.sun.webui.jsf.component.Hyperlink;
import com.sun.webui.jsf.component.Link;
import com.sun.webui.jsf.component.Page;
import com.sun.webui.jsf.component.PanelLayout;
import com.sun.webui.jsf.component.StaticText;
import com.sun.webui.jsf.component.Table;
import com.sun.webui.jsf.component.TableColumn;
import com.sun.webui.jsf.component.TableRowGroup;
import com.sun.webui.jsf.component.TextField;
import com.sun.webui.jsf.model.Option;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.FacesException;
import javax.faces.event.ValueChangeEvent;
import top.domain.ejbs.ControladorProdutoRemote;
import top.domain.entities.LinhaRequisicao;
import top.domain.entities.Produto;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class NewReqEmpStep2 extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
    private int __placeholder;

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }

    private Page page1 = new Page();
    
    public Page getPage1() {
        return page1;
    }
    
    public void setPage1(Page p) {
        this.page1 = p;
    }
    
    private Html html1 = new Html();
    
    public Html getHtml1() {
        return html1;
    }
    
    public void setHtml1(Html h) {
        this.html1 = h;
    }
    
    private Head head1 = new Head();
    
    public Head getHead1() {
        return head1;
    }
    
    public void setHead1(Head h) {
        this.head1 = h;
    }
    
    private Link link1 = new Link();
    
    public Link getLink1() {
        return link1;
    }
    
    public void setLink1(Link l) {
        this.link1 = l;
    }
    
    private Body body1 = new Body();
    
    public Body getBody1() {
        return body1;
    }
    
    public void setBody1(Body b) {
        this.body1 = b;
    }
    
    private Form form1 = new Form();
    
    public Form getForm1() {
        return form1;
    }
    
    public void setForm1(Form f) {
        this.form1 = f;
    }
    private Link link2 = new Link();

    public Link getLink2() {
        return link2;
    }

    public void setLink2(Link l) {
        this.link2 = l;
    }
    private PanelLayout headerPanel = new PanelLayout();

    public PanelLayout getHeaderPanel() {
        return headerPanel;
    }

    public void setHeaderPanel(PanelLayout pl) {
        this.headerPanel = pl;
    }
    private StaticText staticText1 = new StaticText();

    public StaticText getStaticText1() {
        return staticText1;
    }

    public void setStaticText1(StaticText st) {
        this.staticText1 = st;
    }
    private PanelLayout leftSidebarPanel = new PanelLayout();

    public PanelLayout getLeftSidebarPanel() {
        return leftSidebarPanel;
    }

    public void setLeftSidebarPanel(PanelLayout pl) {
        this.leftSidebarPanel = pl;
    }
    private PanelLayout footerPanel = new PanelLayout();

    public PanelLayout getFooterPanel() {
        return footerPanel;
    }

    public void setFooterPanel(PanelLayout pl) {
        this.footerPanel = pl;
    }
    private PanelLayout mainContentPanel = new PanelLayout();

    public PanelLayout getMainContentPanel() {
        return mainContentPanel;
    }

    public void setMainContentPanel(PanelLayout pl) {
        this.mainContentPanel = pl;
    }
    private StaticText staticTextTitulo = new StaticText();

    public StaticText getStaticTextTitulo() {
        return staticTextTitulo;
    }

    public void setStaticTextTitulo(StaticText st) {
        this.staticTextTitulo = st;
    }
    private StaticText staticText12 = new StaticText();

    public StaticText getStaticText12() {
        return staticText12;
    }

    public void setStaticText12(StaticText st) {
        this.staticText12 = st;
    }
    private StaticText staticText13 = new StaticText();

    public StaticText getStaticText13() {
        return staticText13;
    }

    public void setStaticText13(StaticText st) {
        this.staticText13 = st;
    }
    private StaticText staticText14 = new StaticText();

    public StaticText getStaticText14() {
        return staticText14;
    }

    public void setStaticText14(StaticText st) {
        this.staticText14 = st;
    }
    private StaticText staticText15 = new StaticText();

    public StaticText getStaticText15() {
        return staticText15;
    }

    public void setStaticText15(StaticText st) {
        this.staticText15 = st;
    }
    private StaticText staticText16 = new StaticText();

    public StaticText getStaticText16() {
        return staticText16;
    }

    public void setStaticText16(StaticText st) {
        this.staticText16 = st;
    }
    private StaticText txtFooter = new StaticText();

    public StaticText getTxtFooter() {
        return txtFooter;
    }

    public void setTxtFooter(StaticText st) {
        this.txtFooter = st;
    }
    private Hyperlink linkAprovador = new Hyperlink();

    public Hyperlink getLinkAprovador() {
        return linkAprovador;
    }

    public void setLinkAprovador(Hyperlink h) {
        this.linkAprovador = h;
    }
    private Hyperlink linkResponsavel = new Hyperlink();

    public Hyperlink getLinkResponsavel() {
        return linkResponsavel;
    }

    public void setLinkResponsavel(Hyperlink h) {
        this.linkResponsavel = h;
    }
    private Hyperlink linkSair = new Hyperlink();

    public Hyperlink getLinkSair() {
        return linkSair;
    }

    public void setLinkSair(Hyperlink h) {
        this.linkSair = h;
    }
    private Hyperlink linkRascunhos = new Hyperlink();

    public Hyperlink getLinkRascunhos() {
        return linkRascunhos;
    }

    public void setLinkRascunhos(Hyperlink h) {
        this.linkRascunhos = h;
    }
    private Hyperlink linkListaRequisicoes = new Hyperlink();

    public Hyperlink getLinkListaRequisicoes() {
        return linkListaRequisicoes;
    }

    public void setLinkListaRequisicoes(Hyperlink h) {
        this.linkListaRequisicoes = h;
    }
    private Hyperlink linkCriarRequisicao = new Hyperlink();

    public Hyperlink getLinkCriarRequisicao() {
        return linkCriarRequisicao;
    }

    public void setLinkCriarRequisicao(Hyperlink h) {
        this.linkCriarRequisicao = h;
    }
    private PanelLayout layoutPanelBotoesSub = new PanelLayout();

    public PanelLayout getLayoutPanelBotoesSub() {
        return layoutPanelBotoesSub;
    }

    public void setLayoutPanelBotoesSub(PanelLayout pl) {
        this.layoutPanelBotoesSub = pl;
    }
    private Button buttonConcluir = new Button();

    public Button getButtonConcluir() {
        return buttonConcluir;
    }

    public void setButtonConcluir(Button b) {
        this.buttonConcluir = b;
    }
    private Button buttonLimpar = new Button();

    public Button getButtonLimpar() {
        return buttonLimpar;
    }

    public void setButtonLimpar(Button b) {
        this.buttonLimpar = b;
    }
    private PanelLayout layoutPanelSpacer = new PanelLayout();

    public PanelLayout getLayoutPanelSpacer() {
        return layoutPanelSpacer;
    }

    public void setLayoutPanelSpacer(PanelLayout pl) {
        this.layoutPanelSpacer = pl;
    }
    private PanelLayout layoutPanelSpacer1 = new PanelLayout();

    public PanelLayout getLayoutPanelSpacer1() {
        return layoutPanelSpacer1;
    }

    public void setLayoutPanelSpacer1(PanelLayout pl) {
        this.layoutPanelSpacer1 = pl;
    }
    private PanelLayout layoutPanelSelecao = new PanelLayout();

    public PanelLayout getLayoutPanelSelecao() {
        return layoutPanelSelecao;
    }

    public void setLayoutPanelSelecao(PanelLayout pl) {
        this.layoutPanelSelecao = pl;
    }
    private DropDown dropDownProduto = new DropDown();

    public DropDown getDropDownProduto() {
        return dropDownProduto;
    }

    public void setDropDownProduto(DropDown dd) {
        this.dropDownProduto = dd;
    }
    private TextField textFieldQuantidade = new TextField();

    public TextField getTextFieldQuantidade() {
        return textFieldQuantidade;
    }

    public void setTextFieldQuantidade(TextField tf) {
        this.textFieldQuantidade = tf;
    }
    private Button buttonAdicionar = new Button();

    public Button getButtonAdicionar() {
        return buttonAdicionar;
    }

    public void setButtonAdicionar(Button b) {
        this.buttonAdicionar = b;
    }
    private PanelLayout layoutPanelListagem = new PanelLayout();

    public PanelLayout getLayoutPanelListagem() {
        return layoutPanelListagem;
    }

    public void setLayoutPanelListagem(PanelLayout pl) {
        this.layoutPanelListagem = pl;
    }
    private Table tableProdutos = new Table();

    public Table getTableProdutos() {
        return tableProdutos;
    }

    public void setTableProdutos(Table t) {
        this.tableProdutos = t;
    }
    private TableRowGroup tableRowGroup1 = new TableRowGroup();

    public TableRowGroup getTableRowGroup1() {
        return tableRowGroup1;
    }

    public void setTableRowGroup1(TableRowGroup trg) {
        this.tableRowGroup1 = trg;
    }
    private PanelLayout layoutPanelSpacer2 = new PanelLayout();

    public PanelLayout getLayoutPanelSpacer2() {
        return layoutPanelSpacer2;
    }

    public void setLayoutPanelSpacer2(PanelLayout pl) {
        this.layoutPanelSpacer2 = pl;
    }

    // </editor-fold>

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    @EJB ControladorProdutoRemote arm;
    LinkedList<LinhaRequisicao> dadosDaTabela = new LinkedList<LinhaRequisicao>();
    Produto activeProduct = new Produto();
    private TableColumn tableColumn4 = new TableColumn();

    public TableColumn getTableColumn4() {
        return tableColumn4;
    }

    public void setTableColumn4(TableColumn tc) {
        this.tableColumn4 = tc;
    }
    private StaticText staticText5 = new StaticText();

    public StaticText getStaticText5() {
        return staticText5;
    }

    public void setStaticText5(StaticText st) {
        this.staticText5 = st;
    }
    private TableColumn tableColumn5 = new TableColumn();

    public TableColumn getTableColumn5() {
        return tableColumn5;
    }

    public void setTableColumn5(TableColumn tc) {
        this.tableColumn5 = tc;
    }
    private StaticText staticText6 = new StaticText();

    public StaticText getStaticText6() {
        return staticText6;
    }

    public void setStaticText6(StaticText st) {
        this.staticText6 = st;
    }
    private TableColumn tableColumn6 = new TableColumn();

    public TableColumn getTableColumn6() {
        return tableColumn6;
    }

    public void setTableColumn6(TableColumn tc) {
        this.tableColumn6 = tc;
    }
    private StaticText staticText7 = new StaticText();

    public StaticText getStaticText7() {
        return staticText7;
    }

    public void setStaticText7(StaticText st) {
        this.staticText7 = st;
    }
    
    public NewReqEmpStep2() {
    }

    /**
     * <p>Callback method that is called whenever a page is navigated to,
     * either directly via a URL, or indirectly via page navigation.
     * Customize this method to acquire resources that will be needed
     * for event handlers and lifecycle methods, whether or not this
     * page is performing post back processing.</p>
     * 
     * <p>Note that, if the current request is a postback, the property
     * values of the components do <strong>not</strong> represent any
     * values submitted with this request.  Instead, they represent the
     * property values that were saved for this view when it was rendered.</p>
     */
    @Override
    public void init() {
        // Perform initializations inherited from our superclass
        super.init();
        // Perform application initialization that must complete
        // *before* managed components are initialized
        // TODO - add your own initialiation code here
            
        // <editor-fold defaultstate="collapsed" desc="Managed Component Initialization">
        // Initialize automatically managed components
        // *Note* - this logic should NOT be modified
        try {
            _init();
        } catch (Exception e) {
            log("Page1 Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e: new FacesException(e);
        }
        
        // </editor-fold>
        // Perform application initialization that must complete
        // *after* managed components are initialized
        // TODO - add your own initialization code here
        
        //this.dropDownProduto.setItems(this.getSessionBean1().getListaDeProdutos());
  
    }
    

    /**
     * <p>Callback method that is called after the component tree has been
     * restored, but before any event processing takes place.  This method
     * will <strong>only</strong> be called on a postback request that
     * is processing a form submit.  Customize this method to allocate
     * resources that will be required in your event handlers.</p>
     */
    @Override
    public void preprocess() {
    }

    /**
     * <p>Callback method that is called just before rendering takes place.
     * This method will <strong>only</strong> be called for the page that
     * will actually be rendered (and not, for example, on a page that
     * handled a postback and then navigated to a different page).  Customize
     * this method to allocate resources that will be required for rendering
     * this page.</p>
     */
    @Override
    public void prerender() {
    }

    /**
     * <p>Callback method that is called after rendering is completed for
     * this request, if <code>init()</code> was called (regardless of whether
     * or not this was the page that was actually rendered).  Customize this
     * method to release resources acquired in the <code>init()</code>,
     * <code>preprocess()</code>, or <code>prerender()</code> methods (or
     * acquired during execution of an event handler).</p>
     */
    @Override
    public void destroy() {
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected RequestBean1 getRequestBean1() {
        return (RequestBean1) getBean("RequestBean1");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected SessionBean1 getSessionBean1() {
        return (SessionBean1) getBean("SessionBean1");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     */
    protected ApplicationBean1 getApplicationBean1() {
        return (ApplicationBean1) getBean("ApplicationBean1");
    }

    public String linkAprovador_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        return null;
    }

    public String linkResponsavel_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        return null;
    }

    public String linkLogout_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        
        return null;
    }

    public String buttonAdicionar_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
       // Option selected = (Option)this.dropDownProduto.getSelected();
        LinhaRequisicao linha = new LinhaRequisicao();
        linha.setId((this.getSessionBean1().getRequisicaoActiva().getId()).longValue());        
        Produto produto = new Produto();
        produto.setNome(this.activeProduct.getNome());
        produto.setId(this.activeProduct.getId());
        produto.setCodigo(this.activeProduct.getCodigo());
        linha.setQuantidade(Integer.parseInt(this.textFieldQuantidade.getText().toString()));
        linha.setProduto(produto);
        this.dadosDaTabela.add(linha);
        //null pra nao sair da pagina
        return null;
    }
    
    public List<Option> getProdutos(){
        //String[] items = (String[])this.getSessionBean1().getListaDeProdutos().toArray();
        //return items; 
        List<Produto> b = this.getSessionBean1().getListaDeProdutos();
        List<Option> a = new LinkedList<Option>();
        
        for(Produto p:b){
            //System.out.print(p.getNome()+" <->");
            a.add(new Option(p));
        }
        return a;
    }
    public void dropDownProduto_processValueChange(ValueChangeEvent event) {
        
    //ControladorProdutoBean arm = new ControladorProdutoBean();
    //System.err.println((String)(event.getNewValue()));
    //this.activeProduct = arm.getProduto((String)(event.getNewValue()));
    
        String newValue = (String)event.getNewValue();
        newValue = newValue.substring(1, newValue.lastIndexOf(')'));
        //getSessionBean1().getRequisicaoActiva().getLinhasRequisicao().add(new LinhaRequisicao())setRequerente(arm.findByID(Long.parseLong(newValue)));
        this.activeProduct = arm.findByID(Long.parseLong(newValue));
        
    }
    public List<LinhaRequisicao> getDadosDaTabela(){
        return this.dadosDaTabela;
    }
}

