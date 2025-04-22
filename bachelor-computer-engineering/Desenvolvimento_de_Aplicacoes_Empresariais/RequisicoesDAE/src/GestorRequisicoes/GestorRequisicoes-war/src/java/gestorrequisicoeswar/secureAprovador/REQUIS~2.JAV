/*
 * RequisicoesPendentes.java
 *
 * Created on 12/Fev/2008, 15:07:48
 * Copyright ei10608
 */
package gestorrequisicoeswar.secureAprovador;

import com.sun.data.provider.impl.ObjectDataProvider;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.component.Body;
import com.sun.webui.jsf.component.Form;
import com.sun.webui.jsf.component.Head;
import com.sun.webui.jsf.component.Html;
import com.sun.webui.jsf.component.Hyperlink;
import com.sun.webui.jsf.component.ImageHyperlink;
import com.sun.webui.jsf.component.Link;
import com.sun.webui.jsf.component.Page;
import com.sun.webui.jsf.component.PanelLayout;
import com.sun.webui.jsf.component.StaticText;
import com.sun.webui.jsf.component.Table;
import com.sun.webui.jsf.component.TableColumn;
import com.sun.webui.jsf.component.TableRowGroup;
import gestorrequisicoeswar.ApplicationBean1;
import gestorrequisicoeswar.RequestBean1;
import gestorrequisicoeswar.SessionBean1;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.FacesException;
import top.domain.ejbs.ControladorRequisicaoRemote;
import top.domain.entities.Requisicao;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class RequisicoesPendentes extends AbstractPageBean {   
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
    private StaticText staticText11 = new StaticText();

    public StaticText getStaticText11() {
        return staticText11;
    }

    public void setStaticText11(StaticText st) {
        this.staticText11 = st;
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
    private Hyperlink linkRequisicoesPendentes = new Hyperlink();

    public Hyperlink getLinkRequisicoesPendentes() {
        return linkRequisicoesPendentes;
    }

    public void setLinkRequisicoesPendentes(Hyperlink h) {
        this.linkRequisicoesPendentes = h;
    }
    private Hyperlink linkLogout = new Hyperlink();

    public Hyperlink getLinkLogout() {
        return linkLogout;
    }

    public void setLinkLogout(Hyperlink h) {
        this.linkLogout = h;
    }
    private Hyperlink linkCriarRequisicao = new Hyperlink();

    public Hyperlink getLinkCriarRequisicao() {
        return linkCriarRequisicao;
    }

    public void setLinkCriarRequisicao(Hyperlink h) {
        this.linkCriarRequisicao = h;
    }
    private Hyperlink linkMinhasRequisicoes = new Hyperlink();

    public Hyperlink getLinkMinhasRequisicoes() {
        return linkMinhasRequisicoes;
    }

    public void setLinkMinhasRequisicoes(Hyperlink h) {
        this.linkMinhasRequisicoes = h;
    }
    private Hyperlink linkRascunhos = new Hyperlink();

    public Hyperlink getLinkRascunhos() {
        return linkRascunhos;
    }

    public void setLinkRascunhos(Hyperlink h) {
        this.linkRascunhos = h;
    }
    private Table tablePendentes = new Table();

    public Table getTablePendentes() {
        return tablePendentes;
    }

    public void setTablePendentes(Table t) {
        this.tablePendentes = t;
    }
    private TableRowGroup tableRowGroup1 = new TableRowGroup();

    public TableRowGroup getTableRowGroup1() {
        return tableRowGroup1;
    }

    public void setTableRowGroup1(TableRowGroup trg) {
        this.tableRowGroup1 = trg;
    }
    private ObjectDataProvider objectDataProvider1 = new ObjectDataProvider();

    public ObjectDataProvider getObjectDataProvider1() {
        return objectDataProvider1;
    }

    public void setObjectDataProvider1(ObjectDataProvider odp) {
        this.objectDataProvider1 = odp;
    }

    // </editor-fold>

    @EJB ControladorRequisicaoRemote rjb;
    private TableColumn colAssunto = new TableColumn();
    
    public TableColumn getColAssunto() {
        return colAssunto;
    }

    public void setColAssunto(TableColumn tc) {
        this.colAssunto = tc;
    }
    private StaticText staticText6 = new StaticText();

    public StaticText getStaticText6() {
        return staticText6;
    }

    public void setStaticText6(StaticText st) {
        this.staticText6 = st;
    }
    private TableColumn colData = new TableColumn();

    public TableColumn getColData() {
        return colData;
    }

    public void setColData(TableColumn tc) {
        this.colData = tc;
    }
    private StaticText staticText7 = new StaticText();

    public StaticText getStaticText7() {
        return staticText7;
    }

    public void setStaticText7(StaticText st) {
        this.staticText7 = st;
    }
    private TableColumn colRequerente = new TableColumn();

    public TableColumn getColRequerente() {
        return colRequerente;
    }

    public void setColRequerente(TableColumn tc) {
        this.colRequerente = tc;
    }
    private StaticText staticText2 = new StaticText();

    public StaticText getStaticText2() {
        return staticText2;
    }

    public void setStaticText2(StaticText st) {
        this.staticText2 = st;
    }
    private TableColumn colAprovar = new TableColumn();

    public TableColumn getColAprovar() {
        return colAprovar;
    }

    public void setColAprovar(TableColumn tc) {
        this.colAprovar = tc;
    }
    private ImageHyperlink linkAprovar = new ImageHyperlink();

    public ImageHyperlink getLinkAprovar() {
        return linkAprovar;
    }

    public void setLinkAprovar(ImageHyperlink ih) {
        this.linkAprovar = ih;
    }
    private TableColumn colReprovar = new TableColumn();

    public TableColumn getColReprovar() {
        return colReprovar;
    }

    public void setColReprovar(TableColumn tc) {
        this.colReprovar = tc;
    }
    private ImageHyperlink linkReprovar = new ImageHyperlink();

    public ImageHyperlink getLinkReprovar() {
        return linkReprovar;
    }

    public void setLinkReprovar(ImageHyperlink ih) {
        this.linkReprovar = ih;
    }
    private TableColumn colApagar = new TableColumn();

    public TableColumn getColApagar() {
        return colApagar;
    }

    public void setColApagar(TableColumn tc) {
        this.colApagar = tc;
    }
    private ImageHyperlink linkApagar = new ImageHyperlink();

    public ImageHyperlink getLinkApagar() {
        return linkApagar;
    }

    public void setLinkApagar(ImageHyperlink ih) {
        this.linkApagar = ih;
    }
    private TableColumn colAlterar = new TableColumn();

    public TableColumn getColAlterar() {
        return colAlterar;
    }

    public void setColAlterar(TableColumn tc) {
        this.colAlterar = tc;
    }
    private ImageHyperlink linkAlterar = new ImageHyperlink();

    public ImageHyperlink getLinkAlterar() {
        return linkAlterar;
    }

    public void setLinkAlterar(ImageHyperlink ih) {
        this.linkAlterar = ih;
    }
    private TableColumn colID = new TableColumn();

    public TableColumn getColID() {
        return colID;
    }

    public void setColID(TableColumn tc) {
        this.colID = tc;
    }
    private StaticText staticText3 = new StaticText();

    public StaticText getStaticText3() {
        return staticText3;
    }

    public void setStaticText3(StaticText st) {
        this.staticText3 = st;
    }
    private Hyperlink linkRequisicoesExistentes = new Hyperlink();

    public Hyperlink getLinkRequisicoesExistentes() {
        return linkRequisicoesExistentes;
    }

    public void setLinkRequisicoesExistentes(Hyperlink h) {
        this.linkRequisicoesExistentes = h;
    }
    private TableColumn colVer = new TableColumn();

    public TableColumn getColVer() {
        return colVer;
    }

    public void setColVer(TableColumn tc) {
        this.colVer = tc;
    }
    private ImageHyperlink linkVer = new ImageHyperlink();

    public ImageHyperlink getLinkVer() {
        return linkVer;
    }

    public void setLinkVer(ImageHyperlink ih) {
        this.linkVer = ih;
    }
    private Hyperlink linkNotificacoes = new Hyperlink();

    public Hyperlink getLinkNotificacoes() {
        return linkNotificacoes;
    }

    public void setLinkNotificacoes(Hyperlink h) {
        this.linkNotificacoes = h;
    }
    
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public RequisicoesPendentes() {
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
        
        //getImageHyperlink1().setImageURL(imageURL);
            
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
    
    public List<Requisicao> getRequisicoesPendentes(){
        return rjb.getRequisicoesPendentes();
    }

    public String linkAprovar_action() {
        rjb.aprovar(getRowId());
        return null;
    }

    public String linkApagar_action() {
        rjb.apagar(getRowId());
        
        return null;
    }
    
    public Integer getRowId(){
        return (Integer)getValue("#{currentRow.value['id']}");
    }

    public String linkReprovar_action() {
        rjb.reprovar(getRowId());
        return null;
    }

    public String linkAlterar_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        getSessionBean1().setRequisicaoActiva(rjb.getRequisicaoActiva(getRowId()));

        return "ALTERAR";
    }

    public String linkVer_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        
        getSessionBean1().setRequisicaoActiva(rjb.getRequisicaoActiva(getRowId()));
        
        return "VER";
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

    public String linkMinhasRequisicoes_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        return null;
    }

    public String linkRequisicoesExistentes_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        return null;
    }

    public String linkRequisicoesPendentes_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        return null;
    }

    public String linkLogout_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        return null;
    }
}

