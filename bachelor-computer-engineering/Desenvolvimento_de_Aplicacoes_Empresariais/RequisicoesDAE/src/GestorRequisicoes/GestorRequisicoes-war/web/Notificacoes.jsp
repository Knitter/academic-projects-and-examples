<?xml version="1.0" encoding="UTF-8"?>
<!--
Document   : MinhasRequisicoes
Created on : 13/Fev/2008, 19:07:31
Author     : Knitter
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page binding="#{Notificacoes.page1}" id="page1">
            <webuijsf:html binding="#{Notificacoes.html1}" id="html1">
                <webuijsf:head binding="#{Notificacoes.head1}" id="head1">
                    <webuijsf:link binding="#{Notificacoes.link1}" id="link1" url="/resources/stylesheet.css"/>
                    <webuijsf:link binding="#{Notificacoes.link2}" id="link2" url="/resources/layout6.css"/>
                </webuijsf:head>
                <webuijsf:body binding="#{Notificacoes.body1}" id="body1">
                    <br/>
                    <webuijsf:form binding="#{Notificacoes.form1}" id="form1">
                        <div id="container">
                            <!-- This clearing element should immediately follow the #mainContent div in order to force the #container div to contain all child floats -->
                            <webuijsf:panelLayout binding="#{Notificacoes.headerPanel}" id="headerPanel" panelLayout="flow" styleClass="header">
                                <webuijsf:staticText binding="#{Notificacoes.staticText1}" escape="false" id="staticText1" text="&lt;h1&gt;Requisições&lt;/h1&gt;"/>
                                <webuijsf:staticText binding="#{Notificacoes.staticText16}" escape="false" id="staticText16" text="Aplicação de Requisições Online&#xa;&lt;br/&gt;&#xa;&lt;br/&gt;"/>
                            </webuijsf:panelLayout>
                            <!-- end #container -->
                            <webuijsf:panelLayout binding="#{Notificacoes.leftSidebarPanel}" id="leftSidebarPanel" panelLayout="flow" styleClass="leftSidebar">
                                <br/>
                                <webuijsf:hyperlink actionExpression="#{Notificacoes.linkCriar_action}" binding="#{Notificacoes.linkCriar}" id="linkCriar"
                                    text="Criar Requisição" url="/faces/index.jsp"/>
                                <br/>
                                <br/>
                                <webuijsf:hyperlink actionExpression="#{Notificacoes.linkRascunhos_action}" binding="#{Notificacoes.linkRascunhos}"
                                    id="linkRascunhos" text="Meus Rascunhos" url="/faces/Rascunhos.jsp"/>
                                <br/>
                                <br/>
                                <webuijsf:hyperlink actionExpression="#{Notificacoes.linkMinhasReqs_action}" binding="#{Notificacoes.linkMinhasReqs}"
                                    id="linkMinhasReqs" text="Minhas Requisições" url="/faces/MinhasRequisicoes.jsp"/>
                                <br/>
                                <br/>
                                <webuijsf:hyperlink binding="#{Notificacoes.linkNotificacoes}" id="linkNotificacoes" text="Notificações"
                                    url="/faces/Notificacoes.jsp" visible="false"/>
                                <br/>
                                <br/>
                                <jsp:scriptlet>
                                    if (request.isUserInRole("Aprovador")) {
                                </jsp:scriptlet>
                                <webuijsf:hyperlink binding="#{Notificacoes.linkExistentesAprovador}" id="linkExistentesAprovador" text="Requisições Existentes" url="/faces/secureAprovador/RequisicoesExistentes.jsp"/>
                                <br/>
                                <br/>
                                <webuijsf:hyperlink actionExpression="#{Notificacoes.linkPendentesAprovador_action}"
                                    binding="#{Notificacoes.linkPendentesAprovador}" id="linkPendentesAprovador" text="Requisições Pendentes" url="/faces/secureAprovador/RequisicoesPendentes.jsp"/>
                                <br/>
                                <br/>
                                <jsp:scriptlet>
                                    }else if (request.isUserInRole("Responsavel")) {
                                </jsp:scriptlet>
                                <webuijsf:hyperlink binding="#{Notificacoes.linkExistentesResponsavel}" id="linkExistentesResponsavel"
                                    text="Requisições Existentes" url="/faces/secureResponsavel/RequisicoesExistentes.jsp"/>
                                <br/>
                                <br/>
                                <webuijsf:hyperlink actionExpression="#{Notificacoes.linkPendentesResponsavel_action}"
                                    binding="#{Notificacoes.linkPendentesResponsavel}" id="linkPendentesResponsavel" text="Requisições Pendentes" url="/faces/secureResponsavel/RequisicoesPorServir.jsp"/>
                                <br/>
                                <br/>
                                <jsp:scriptlet>
                                    }
                                </jsp:scriptlet>
                                <webuijsf:hyperlink actionExpression="#{Notificacoes.linkSair_action}" binding="#{Notificacoes.linkSair}" id="linkSair"
                                    text="Sair" url="/logout.jsp"/>
                                <br/>
                                <br/>
                            </webuijsf:panelLayout>
                            <webuijsf:panelLayout binding="#{Notificacoes.mainContentPanel}" id="mainContentPanel" panelLayout="flow" styleClass="mainContent">
                                <webuijsf:staticText binding="#{Notificacoes.staticText11}" escape="false" id="staticText11" text="&lt;h2&gt;Notificações&lt;/h2&gt;"/>
                                <webuijsf:table augmentTitle="false" binding="#{Notificacoes.table1}" id="table1" width="0">
                                    <webuijsf:tableRowGroup binding="#{Notificacoes.tableRowGroup1}" id="tableRowGroup1" rows="10"
                                        sourceData="#{Notificacoes.notificacoes}" sourceVar="currentRow">
                                        <webuijsf:tableColumn binding="#{Notificacoes.colID}" headerText="id" id="colID" sort="id">
                                            <webuijsf:staticText binding="#{Notificacoes.staticText2}" id="staticText2" text="#{currentRow.value['id']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn binding="#{Notificacoes.colData}" headerText="Data" id="colData" sort="dataCriacao">
                                            <webuijsf:staticText binding="#{Notificacoes.staticText3}" id="staticText3" text="#{currentRow.value['dataCriacao']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn binding="#{Notificacoes.colAssunto}" headerText="Assunto" id="colAssunto" sort="assunto">
                                            <webuijsf:staticText binding="#{Notificacoes.staticText4}" id="staticText4" text="#{currentRow.value['assunto']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn binding="#{Notificacoes.colCorpo}" headerText="Mensagem" id="colCorpo" sort="corpo">
                                            <webuijsf:staticText binding="#{Notificacoes.staticText10}" id="staticText10" text="#{currentRow.value['corpo']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn binding="#{Notificacoes.colApagar}" id="colApagar">
                                            <webuijsf:imageHyperlink actionExpression="#{Notificacoes.linkApagar_action}" binding="#{Notificacoes.linkApagar}"
                                                id="linkApagar" imageURL="/resources/apagar.png" text=""/>
                                        </webuijsf:tableColumn>
                                    </webuijsf:tableRowGroup>
                                </webuijsf:table>
                            </webuijsf:panelLayout>
                            <br class="clearfloat"/>
                            <webuijsf:panelLayout binding="#{Notificacoes.footerPanel}" id="footerPanel" panelLayout="flow" style="text-align: right" styleClass="footer">
                                <webuijsf:staticText binding="#{Notificacoes.txtFooter}" escape="false" id="txtFooter"
                                    style="color: olive; font-family: Arial,Helvetica,sans-serif; font-size: 12px; text-align: right" text="&#xa;&lt;br/&gt;ESTG Leiria&#xa;&lt;br/&gt;&#xa;&lt;br/&gt;"/>
                            </webuijsf:panelLayout>
                        </div>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
