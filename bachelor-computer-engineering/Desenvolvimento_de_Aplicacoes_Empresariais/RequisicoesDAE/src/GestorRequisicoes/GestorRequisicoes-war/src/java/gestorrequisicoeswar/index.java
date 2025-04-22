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
import com.sun.webui.jsf.component.Calendar;
import com.sun.webui.jsf.component.Checkbox;
import com.sun.webui.jsf.component.DropDown;
import com.sun.webui.jsf.component.Form;
import com.sun.webui.jsf.component.Head;
import com.sun.webui.jsf.component.Html;
import com.sun.webui.jsf.component.Hyperlink;
import com.sun.webui.jsf.component.Link;
import com.sun.webui.jsf.component.Listbox;
import com.sun.webui.jsf.component.Page;
import com.sun.webui.jsf.component.PanelLayout;
import com.sun.webui.jsf.component.StaticText;
import com.sun.webui.jsf.component.Table;
import com.sun.webui.jsf.component.TextArea;
import com.sun.webui.jsf.model.DefaultOptionsList;
import com.sun.webui.jsf.model.SingleSelectOptionsList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.FacesException;
import javax.faces.context.FacesContext;
import top.domain.ejbs.ControladorColaboradorRemote;
import top.domain.ejbs.ControladorProdutoRemote;
import top.domain.ejbs.ControladorRequisicaoRemote;
import top.domain.entities.Colaborador;
import top.domain.entities.Produto;
import top.domain.entities.Requisicao;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class index extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
    private int __placeholder;

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
        //listDataProvider1.setList(getProdutos());
        List<Produto> pedreiro = getProdutos();
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
    private Table tableProdutos = new Table();
    private DropDown dropDownDestino = new DropDown();

    public DropDown getDropDownDestino() {
        return dropDownDestino;
    }

    public void setDropDownDestino(DropDown dd) {
        this.dropDownDestino = dd;
    }
    private SingleSelectOptionsList dropDownDestinoDefaultOptions = new SingleSelectOptionsList();

    public SingleSelectOptionsList getDropDownDestinoDefaultOptions() {
        return dropDownDestinoDefaultOptions;
    }

    public void setDropDownDestinoDefaultOptions(SingleSelectOptionsList ssol) {
        this.dropDownDestinoDefaultOptions = ssol;
    }
    private PanelLayout layoutPanelDestino = new PanelLayout();

    public PanelLayout getLayoutPanelDestino() {
        return layoutPanelDestino;
    }

    public void setLayoutPanelDestino(PanelLayout pl) {
        this.layoutPanelDestino = pl;
    }
    private PanelLayout layoutPanelAssunto = new PanelLayout();

    public PanelLayout getLayoutPanelAssunto() {
        return layoutPanelAssunto;
    }

    public void setLayoutPanelAssunto(PanelLayout pl) {
        this.layoutPanelAssunto = pl;
    }
    private Listbox listboxProdutosTodos = new Listbox();

    public Listbox getListboxProdutosTodos() {
        return listboxProdutosTodos;
    }

    public void setListboxProdutosTodos(Listbox l) {
        this.listboxProdutosTodos = l;
    }
    private Listbox listboxProdutosRequeridos = new Listbox();

    public Listbox getListboxProdutosRequeridos() {
        return listboxProdutosRequeridos;
    }

    public void setListboxProdutosRequeridos(Listbox l) {
        this.listboxProdutosRequeridos = l;
    }
    private DefaultOptionsList listboxProdutosRequeridosDefaultOptions = new DefaultOptionsList();

    public DefaultOptionsList getListboxProdutosRequeridosDefaultOptions() {
        return listboxProdutosRequeridosDefaultOptions;
    }

    public void setListboxProdutosRequeridosDefaultOptions(DefaultOptionsList dol) {
        this.listboxProdutosRequeridosDefaultOptions = dol;
    }
    private Button buttonAddAll = new Button();

    public Button getButtonAddAll() {
        return buttonAddAll;
    }

    public void setButtonAddAll(Button b) {
        this.buttonAddAll = b;
    }
    private Button buttonRemoveAll = new Button();

    public Button getButtonRemoveAll() {
        return buttonRemoveAll;
    }

    public void setButtonRemoveAll(Button b) {
        this.buttonRemoveAll = b;
    }
    private Button buttonRemove = new Button();

    public Button getButtonRemove() {
        return buttonRemove;
    }

    public void setButtonRemove(Button b) {
        this.buttonRemove = b;
    }
    private Button buttonAdd = new Button();

    public Button getButtonAdd() {
        return buttonAdd;
    }

    public void setButtonAdd(Button b) {
        this.buttonAdd = b;
    }
    private TextArea textAreaAssunto = new TextArea();

    public TextArea getTextAreaAssunto() {
        return textAreaAssunto;
    }

    public void setTextAreaAssunto(TextArea ta) {
        this.textAreaAssunto = ta;
    }
    private PanelLayout layoutPanelListas = new PanelLayout();

    public PanelLayout getLayoutPanelListas() {
        return layoutPanelListas;
    }

    public void setLayoutPanelListas(PanelLayout pl) {
        this.layoutPanelListas = pl;
    }
    private PanelLayout layoutPanelProdutosRequeridos = new PanelLayout();

    public PanelLayout getLayoutPanelProdutosRequeridos() {
        return layoutPanelProdutosRequeridos;
    }

    public void setLayoutPanelProdutosRequeridos(PanelLayout pl) {
        this.layoutPanelProdutosRequeridos = pl;
    }
    private PanelLayout layoutPanelSubListas = new PanelLayout();

    public PanelLayout getLayoutPanelSubListas() {
        return layoutPanelSubListas;
    }

    public void setLayoutPanelSubListas(PanelLayout pl) {
        this.layoutPanelSubListas = pl;
    }
    private PanelLayout layoutPanelButoes = new PanelLayout();

    public PanelLayout getLayoutPanelButoes() {
        return layoutPanelButoes;
    }

    public void setLayoutPanelButoes(PanelLayout pl) {
        this.layoutPanelButoes = pl;
    }
    private PanelLayout layoutPanelProdutosTodos = new PanelLayout();

    public PanelLayout getLayoutPanelProdutosTodos() {
        return layoutPanelProdutosTodos;
    }

    public void setLayoutPanelProdutosTodos(PanelLayout pl) {
        this.layoutPanelProdutosTodos = pl;
    }
    private PanelLayout layoutSubPanelProdutos = new PanelLayout();

    public PanelLayout getLayoutSubPanelProdutos() {
        return layoutSubPanelProdutos;
    }

    public void setLayoutSubPanelProdutos(PanelLayout pl) {
        this.layoutSubPanelProdutos = pl;
    }
    private PanelLayout layoutPanelBotoesSub = new PanelLayout();

    public PanelLayout getLayoutPanelBotoesSub() {
        return layoutPanelBotoesSub;
    }

    public void setLayoutPanelBotoesSub(PanelLayout pl) {
        this.layoutPanelBotoesSub = pl;
    }
    private Button buttonCriar = new Button();

    public Button getButtonCriar() {
        return buttonCriar;
    }

    public void setButtonCriar(Button b) {
        this.buttonCriar = b;
    }
    private Button buttonLimpar = new Button();

    public Button getButtonLimpar() {
        return buttonLimpar;
    }

    public void setButtonLimpar(Button b) {
        this.buttonLimpar = b;
    }
    private Checkbox checkboxRascunho = new Checkbox();

    public Checkbox getCheckboxRascunho() {
        return checkboxRascunho;
    }

    public void setCheckboxRascunho(Checkbox c) {
        this.checkboxRascunho = c;
    }
    private PanelLayout layoutPanelSpacer = new PanelLayout();

    public PanelLayout getLayoutPanelSpacer() {
        return layoutPanelSpacer;
    }

    public void setLayoutPanelSpacer(PanelLayout pl) {
        this.layoutPanelSpacer = pl;
    }

    // </editor-fold>
    @EJB ControladorRequisicaoRemote requisitador;
    @EJB ControladorColaboradorRemote patrao;
    @EJB ControladorProdutoRemote armazem;
    
    private Calendar calendarDataPretendida = new Calendar();

    public Calendar getCalendarDataPretendida() {
        return calendarDataPretendida;
    }

    public void setCalendarDataPretendida(Calendar c) {
        this.calendarDataPretendida = c;
    }
    private Hyperlink linkRequisicoesExistentes = new Hyperlink();

    public Hyperlink getLinkRequisicoesExistentes() {
        return linkRequisicoesExistentes;
    }

    public void setLinkRequisicoesExistentes(Hyperlink h) {
        this.linkRequisicoesExistentes = h;
    }
    private PanelLayout layoutPanelSpacer1 = new PanelLayout();

    public PanelLayout getLayoutPanelSpacer1() {
        return layoutPanelSpacer1;
    }

    public void setLayoutPanelSpacer1(PanelLayout pl) {
        this.layoutPanelSpacer1 = pl;
    }
    private Hyperlink linkNotificacao = new Hyperlink();

    public Hyperlink getLinkNotificacao() {
        return linkNotificacao;
    }

    public void setLinkNotificacao(Hyperlink h) {
        this.linkNotificacao = h;
    }

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public index() {
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
        
    }

    /**
     * <p>Callback method that is called after the component tree has been
     * restored, but before any event processing takes place.  This method
     * will <strong>only</strong> be called on a postback request that
     * is processing a form submit.  Customize this method to allocate
     * resources that will be required in your event handlers.</p>
     */
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

    public String buttonCriar_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        try {
            String who = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
            Colaborador requerente = patrao.findByUsername(who);
            //Destino destino = new Destino();
            String assunto = textAreaAssunto.getText().toString();
            boolean rascunho = checkboxRascunho.isChecked();
            //rreq.criar(requerente, new Date(), null, "requisicao 123", false);
            this.getSessionBean1().setListaDeProdutos(this.getProdutos());
            
            this.getSessionBean1().setRequisicaoActiva(requisitador.criar(requerente, calendarDataPretendida.getSelectedDate(), null, assunto, rascunho));
      
            
        } catch (Exception exception) {
            System.out.print("Caught this: "+exception);
            return null;
        }
       return "newReqStep2";
    }

    public String linkCriarRequisicao_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        return null;
    }

    public String linkRascunhos_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        return null;
    }

    public String linkListaRequisicoes_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        return null;
    }

    public String linkSair_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        return null;
    }

    public String buttonAddAll_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        return null;
    }

    public String buttonAdd_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        this.listboxProdutosRequeridos.setItems(this.listboxProdutosTodos.getSelected());
        return null;
        
    }

    public String buttonRemove_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        return null;
    }

    public String buttonRemoveAll_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        return null;
    }

    public String buttonLimpar_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        return null;
    }
    
    public List<Produto> getProdutos(){      
        return armazem.getProdutos();
    }

}

