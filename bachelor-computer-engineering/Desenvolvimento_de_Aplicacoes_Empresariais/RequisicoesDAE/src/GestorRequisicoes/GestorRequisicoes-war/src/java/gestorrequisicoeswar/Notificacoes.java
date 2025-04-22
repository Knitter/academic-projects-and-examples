/*
 * MinhasRequisicoes.java
 *
 * Created on 13/Fev/2008, 19:07:31
 * Copyright Knitter
 */
package gestorrequisicoeswar;

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
import com.sun.webui.jsf.model.DefaultTableDataProvider;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.FacesException;
import javax.faces.context.FacesContext;
import top.domain.ejbs.ControladorColaboradorRemote;
import top.domain.ejbs.ControladorNotificacaoRemote;
import top.domain.ejbs.ControladorRequisicaoRemote;
import top.domain.entities.Colaborador;
import top.domain.entities.Notificacao;
import top.domain.entities.Requisicao;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class Notificacoes extends AbstractPageBean {
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
    private Hyperlink linkSair = new Hyperlink();

    public Hyperlink getLinkSair() {
        return linkSair;
    }

    public void setLinkSair(Hyperlink h) {
        this.linkSair = h;
    }
    private Hyperlink linkPendentesAprovador = new Hyperlink();

    public Hyperlink getLinkPendentesAprovador() {
        return linkPendentesAprovador;
    }

    public void setLinkPendentesAprovador(Hyperlink h) {
        this.linkPendentesAprovador = h;
    }
    private Hyperlink linkPendentesResponsavel = new Hyperlink();

    public Hyperlink getLinkPendentesResponsavel() {
        return linkPendentesResponsavel;
    }

    public void setLinkPendentesResponsavel(Hyperlink h) {
        this.linkPendentesResponsavel = h;
    }
    private Hyperlink linkRascunhos = new Hyperlink();

    public Hyperlink getLinkRascunhos() {
        return linkRascunhos;
    }

    public void setLinkRascunhos(Hyperlink h) {
        this.linkRascunhos = h;
    }
    private Hyperlink linkCriar = new Hyperlink();

    public Hyperlink getLinkCriar() {
        return linkCriar;
    }

    public void setLinkCriar(Hyperlink h) {
        this.linkCriar = h;
    }
    private Hyperlink linkMinhasReqs = new Hyperlink();

    public Hyperlink getLinkMinhasReqs() {
        return linkMinhasReqs;
    }

    public void setLinkMinhasReqs(Hyperlink h) {
        this.linkMinhasReqs = h;
    }
    private Table table1 = new Table();

    public Table getTable1() {
        return table1;
    }

    public void setTable1(Table t) {
        this.table1 = t;
    }
    private TableRowGroup tableRowGroup1 = new TableRowGroup();

    public TableRowGroup getTableRowGroup1() {
        return tableRowGroup1;
    }

    public void setTableRowGroup1(TableRowGroup trg) {
        this.tableRowGroup1 = trg;
    }

    // </editor-fold>

    @EJB ControladorColaboradorRemote rcolab;
    @EJB ControladorNotificacaoRemote rnot;
    private Hyperlink linkExistentesAprovador = new Hyperlink();

    public Hyperlink getLinkExistentesAprovador() {
        return linkExistentesAprovador;
    }

    public void setLinkExistentesAprovador(Hyperlink h) {
        this.linkExistentesAprovador = h;
    }
    private Hyperlink linkExistentesResponsavel = new Hyperlink();

    public Hyperlink getLinkExistentesResponsavel() {
        return linkExistentesResponsavel;
    }

    public void setLinkExistentesResponsavel(Hyperlink h) {
        this.linkExistentesResponsavel = h;
    }
    private TableColumn colID = new TableColumn();

    public TableColumn getColID() {
        return colID;
    }

    public void setColID(TableColumn tc) {
        this.colID = tc;
    }
    private StaticText staticText2 = new StaticText();

    public StaticText getStaticText2() {
        return staticText2;
    }

    public void setStaticText2(StaticText st) {
        this.staticText2 = st;
    }
    private TableColumn colData = new TableColumn();

    public TableColumn getColData() {
        return colData;
    }

    public void setColData(TableColumn tc) {
        this.colData = tc;
    }
    private StaticText staticText3 = new StaticText();

    public StaticText getStaticText3() {
        return staticText3;
    }

    public void setStaticText3(StaticText st) {
        this.staticText3 = st;
    }
    private TableColumn colAssunto = new TableColumn();

    public TableColumn getColAssunto() {
        return colAssunto;
    }

    public void setColAssunto(TableColumn tc) {
        this.colAssunto = tc;
    }
    private StaticText staticText4 = new StaticText();

    public StaticText getStaticText4() {
        return staticText4;
    }

    public void setStaticText4(StaticText st) {
        this.staticText4 = st;
    }
    private TableColumn colCorpo = new TableColumn();

    public TableColumn getColCorpo() {
        return colCorpo;
    }

    public void setColCorpo(TableColumn tc) {
        this.colCorpo = tc;
    }
    private StaticText staticText10 = new StaticText();

    public StaticText getStaticText10() {
        return staticText10;
    }

    public void setStaticText10(StaticText st) {
        this.staticText10 = st;
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
    public Notificacoes() {
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
    
    public List<Notificacao> getNotificacoes() {
        Colaborador c = rcolab.findByUsername(FacesContext.getCurrentInstance().getExternalContext().getRemoteUser());
        return c.getNotificacoes();
    }

    public String linkVer_action() {
        return "VER";
    }

    public String linkCriar_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        return null;
    }

    public String linkRascunhos_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        return null;
    }

    public String linkMinhasReqs_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        return null;
    }

    public String linkPendentesAprovador_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        return null;
    }

    public String linkPendentesResponsavel_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        return null;
    }

    public String linkSair_action() {
        // TODO: Process the action. Return value is a navigation
        // case name where null will return to the same page.
        return null;
    }
   
    public Long getRowId(){
        return Long.parseLong(getValue("#{currentRow.value['id']}").toString());
    }

    public String linkApagar_action() {
        rnot.apagar(getRowId());
        return null;
    }
}

