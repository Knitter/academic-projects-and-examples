<?xml version="1.0" encoding="UTF-8"?>
<!--
Document   : Rascunhos
Created on : 13/Fev/2008, 19:07:54
Author     : Knitter
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page binding="#{Rascunhos.page1}" id="page1">
            <webuijsf:html binding="#{Rascunhos.html1}" id="html1">
                <webuijsf:head binding="#{Rascunhos.head1}" id="head1">
                    <webuijsf:link binding="#{Rascunhos.link1}" id="link1" url="/resources/stylesheet.css"/>
                    <webuijsf:link binding="#{Rascunhos.link2}" id="link2" url="/resources/layout6.css"/>
                </webuijsf:head>
                <webuijsf:body binding="#{Rascunhos.body1}" id="body1">
                    <br/>
                    <webuijsf:form binding="#{Rascunhos.form1}" id="form1">
                        <div id="container">
                            <!-- This clearing element should immediately follow the #mainContent div in order to force the #container div to contain all child floats -->
                            <webuijsf:panelLayout binding="#{Rascunhos.headerPanel}" id="headerPanel" panelLayout="flow" styleClass="header">
                                <webuijsf:staticText binding="#{Rascunhos.staticText1}" escape="false" id="staticText1" text="&lt;h1&gt;Requisições&lt;/h1&gt;"/>
                                <webuijsf:staticText binding="#{Rascunhos.staticText16}" escape="false" id="staticText16" text="Aplicação de Requisições Online&#xa;&lt;br/&gt;&#xa;&lt;br/&gt;"/>
                            </webuijsf:panelLayout>
                            <!-- end #container -->
                            <webuijsf:panelLayout binding="#{Rascunhos.leftSidebarPanel}" id="leftSidebarPanel" panelLayout="flow" styleClass="leftSidebar">
                                <br/>
                                <webuijsf:hyperlink actionExpression="#{Rascunhos.linkCriar_action}" binding="#{Rascunhos.linkCriar}" id="linkCriar"
                                    text="Criar Requisição" url="/faces/index.jsp"/>
                                <br/>
                                <br/>
                                <webuijsf:hyperlink binding="#{Rascunhos.linkRascunhos}" id="linkRascunhos" text="Meus Rascunhos" url="/faces/Rascunhos.jsp"/>
                                <br/>
                                <br/>
                                <webuijsf:hyperlink binding="#{Rascunhos.linkMinhasRequisicoes}" id="linkMinhasRequisicoes" text="Minhas Requisições"
                                    url="/faces/MinhasRequisicoes.jsp" visible="false"/>
                                <br/>
                                <br/>
                                <webuijsf:hyperlink binding="#{Rascunhos.linkNotificacoes}" id="linkNotificacoes" text="Notificações" url="/faces/Notificacoes.jsp"/>
                                <br/>
                                <br/>
                                <jsp:scriptlet>
                                    if (request.isUserInRole("Aprovador")) {
                                </jsp:scriptlet>
                                <webuijsf:hyperlink binding="#{Rascunhos.linkRequisicoesExistentesAprovador}" id="linkRequisicoesExistentesAprovador"
                                    text="Requisições Existentes" url="/faces/secureAprovador/RequisicoesExistentes.jsp"/>
                                <br/>
                                <br/>
                                <webuijsf:hyperlink binding="#{Rascunhos.linkRequisicoesPendentesAprovador}" id="linkRequisicoesPendentesAprovador"
                                    text="Requisições Pendentes" url="/faces/secureAprovador/ResquisicoesPendentes.jsp"/>
                                <br/>
                                <br/>
                                <jsp:scriptlet>
                                    }else if (request.isUserInRole("Responsavel")) {
                                </jsp:scriptlet>
                                <webuijsf:hyperlink binding="#{Rascunhos.linkRequisicoesExistentesResponsavel}" id="linkRequisicoesExistentesResponsavel"
                                    text="Requisições Existentes" url="/faces/secureResponsavel/RequisicoesExistentes.jsp"/>
                                <br/>
                                <br/>
                                <webuijsf:hyperlink binding="#{Rascunhos.linkRequisicoesPendentesResponsavel}" id="linkRequisicoesPendentesResponsavel"
                                    text="Requisições Pendentes" url="/faces/secureResponsavel/RequisicoesPorServir.jsp"/>
                                <br/>
                                <br/>
                                <jsp:scriptlet>
                                    }
                                </jsp:scriptlet>
                                <webuijsf:hyperlink actionExpression="#{Rascunhos.linkSair_action}" binding="#{Rascunhos.linkSair}" id="linkSair" text="Sair" url="/logout.jsp"/>
                                <br/>
                                <br/>
                            </webuijsf:panelLayout>
                            <webuijsf:panelLayout binding="#{Rascunhos.mainContentPanel}" id="mainContentPanel" panelLayout="flow" styleClass="mainContent">
                                <webuijsf:staticText binding="#{Rascunhos.staticText11}" escape="false" id="staticText11" text="&lt;h2&gt;Meus Rascunhos&lt;/h2&gt;"/>
                                <webuijsf:table augmentTitle="false" binding="#{Rascunhos.tabelaRascunhos}" id="tabelaRascunhos" width="0">
                                    <webuijsf:tableRowGroup binding="#{Rascunhos.tableRowGroup1}" id="tableRowGroup1" rows="10"
                                        sourceData="#{Rascunhos.rascunhos}" sourceVar="currentRow">
                                        <webuijsf:tableColumn binding="#{Rascunhos.colID}" headerText="id" id="colID" sort="id" visible="false">
                                            <webuijsf:staticText binding="#{Rascunhos.staticText5}" id="staticText5" text="#{currentRow.value['id']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn binding="#{Rascunhos.colData}" headerText="Data" id="colData" sort="dataRequisicao">
                                            <webuijsf:staticText binding="#{Rascunhos.staticText6}" id="staticText6" text="#{currentRow.value['dataRequisicao']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn binding="#{Rascunhos.colRequerente}" headerText="Requerente" id="colRequerente" sort="requerente">
                                            <webuijsf:staticText binding="#{Rascunhos.staticText8}" id="staticText8" text="#{currentRow.value['requerente']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn binding="#{Rascunhos.colAssunto}" headerText="Assunto" id="colAssunto" sort="assunto">
                                            <webuijsf:staticText binding="#{Rascunhos.staticText7}" id="staticText7" text="#{currentRow.value['assunto']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn binding="#{Rascunhos.colSubmeter}" id="colSubmeter">
                                            <webuijsf:imageHyperlink actionExpression="#{Rascunhos.linkSubmeter_action}" binding="#{Rascunhos.linkSubmeter}"
                                                id="linkSubmeter" imageURL="/resources/aprovar.png" text="" toolTip="Submeter"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn binding="#{Rascunhos.colApagar}" id="colApagar">
                                            <webuijsf:imageHyperlink actionExpression="#{Rascunhos.linkApagar_action}" binding="#{Rascunhos.linkApagar}"
                                                id="linkApagar" imageURL="/resources/cancel.png" text="" toolTip="Apagar"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn binding="#{Rascunhos.colVer}" id="colVer">
                                            <webuijsf:imageHyperlink actionExpression="#{Rascunhos.linkVer_action}" binding="#{Rascunhos.linkVer}" id="linkVer"
                                                imageURL="/resources/ver.png" text=""/>
                                        </webuijsf:tableColumn>
                                    </webuijsf:tableRowGroup>
                                </webuijsf:table>
                            </webuijsf:panelLayout>
                            <br class="clearfloat"/>
                            <webuijsf:panelLayout binding="#{Rascunhos.footerPanel}" id="footerPanel" panelLayout="flow" style="text-align: right" styleClass="footer">
                                <webuijsf:staticText binding="#{Rascunhos.txtFooter}" escape="false" id="txtFooter"
                                    style="color: olive; font-family: Arial,Helvetica,sans-serif; font-size: 12px; text-align: right" text="&#xa;&lt;br/&gt;ESTG Leiria&#xa;&lt;br/&gt;&#xa;&lt;br/&gt;"/>
                            </webuijsf:panelLayout>
                        </div>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
