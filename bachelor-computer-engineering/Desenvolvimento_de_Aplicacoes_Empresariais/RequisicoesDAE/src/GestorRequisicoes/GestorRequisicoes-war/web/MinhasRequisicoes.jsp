<?xml version="1.0" encoding="UTF-8"?>
<!--
Document   : MinhasRequisicoes
Created on : 13/Fev/2008, 19:07:31
Author     : Knitter
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page binding="#{MinhasRequisicoes.page1}" id="page1">
            <webuijsf:html binding="#{MinhasRequisicoes.html1}" id="html1">
                <webuijsf:head binding="#{MinhasRequisicoes.head1}" id="head1">
                    <webuijsf:link binding="#{MinhasRequisicoes.link1}" id="link1" url="/resources/stylesheet.css"/>
                    <webuijsf:link binding="#{MinhasRequisicoes.link2}" id="link2" url="/resources/layout6.css"/>
                </webuijsf:head>
                <webuijsf:body binding="#{MinhasRequisicoes.body1}" id="body1">
                    <br/>
                    <webuijsf:form binding="#{MinhasRequisicoes.form1}" id="form1">
                        <div id="container">
                            <!-- This clearing element should immediately follow the #mainContent div in order to force the #container div to contain all child floats -->
                            <webuijsf:panelLayout binding="#{MinhasRequisicoes.headerPanel}" id="headerPanel" panelLayout="flow" styleClass="header">
                                <webuijsf:staticText binding="#{MinhasRequisicoes.staticText1}" escape="false" id="staticText1" text="&lt;h1&gt;Requisições&lt;/h1&gt;"/>
                                <webuijsf:staticText binding="#{MinhasRequisicoes.staticText16}" escape="false" id="staticText16" text="Aplicação de Requisições Online&#xa;&lt;br/&gt;&#xa;&lt;br/&gt;"/>
                            </webuijsf:panelLayout>
                            <!-- end #container -->
                            <webuijsf:panelLayout binding="#{MinhasRequisicoes.leftSidebarPanel}" id="leftSidebarPanel" panelLayout="flow" styleClass="leftSidebar">
                                <br/>
                                <webuijsf:hyperlink actionExpression="#{MinhasRequisicoes.linkCriar_action}" binding="#{MinhasRequisicoes.linkCriar}"
                                    id="linkCriar" text="Criar Requisição" url="/faces/index.jsp"/>
                                <br/>
                                <br/>
                                <webuijsf:hyperlink actionExpression="#{MinhasRequisicoes.linkRascunhos_action}" binding="#{MinhasRequisicoes.linkRascunhos}"
                                    id="linkRascunhos" text="Meus Rascunhos" url="/faces/Rascunhos.jsp"/>
                                <br/>
                                <br/>
                                <webuijsf:hyperlink actionExpression="#{MinhasRequisicoes.linkMinhasReqs_action}" binding="#{MinhasRequisicoes.linkMinhasReqs}"
                                    id="linkMinhasReqs" text="Minhas Requisições" url="/faces/MinhasRequisicoes.jsp"/>
                                <br/>
                                <br/>
                                <webuijsf:hyperlink binding="#{MinhasRequisicoes.linkNotificacoes}" id="linkNotificacoes" text="Notifcações" url="/faces/Notificacoes.jsp"/>
                                <br/>
                                <br/>
                                <jsp:scriptlet>
                                    if (request.isUserInRole("Aprovador")) {
                                </jsp:scriptlet>
                                <webuijsf:hyperlink binding="#{MinhasRequisicoes.linkExistentesAprovador}" id="linkExistentesAprovador"
                                    text="Requisições Existentes" url="/faces/secureAprovador/RequisicoesExistentes.jsp"/>
                                <br/>
                                <br/>
                                <webuijsf:hyperlink actionExpression="#{MinhasRequisicoes.linkPendentesAprovador_action}"
                                    binding="#{MinhasRequisicoes.linkPendentesAprovador}" id="linkPendentesAprovador" text="Requisições Pendentes" url="/faces/secureAprovador/RequisicoesPendentes.jsp"/>
                                <br/>
                                <br/>
                                <jsp:scriptlet>
                                    }else if (request.isUserInRole("Responsavel")) {
                                </jsp:scriptlet>
                                <webuijsf:hyperlink binding="#{MinhasRequisicoes.linkExistentesResponsavel}" id="linkExistentesResponsavel"
                                    text="Requisições Existentes" url="/faces/secureResponsavel/RequisicoesExistentes.jsp"/>
                                <br/>
                                <br/>
                                <webuijsf:hyperlink actionExpression="#{MinhasRequisicoes.linkPendentesResponsavel_action}"
                                    binding="#{MinhasRequisicoes.linkPendentesResponsavel}" id="linkPendentesResponsavel" text="Requisições Pendentes" url="/faces/secureResponsavel/RequisicoesPorServir.jsp"/>
                                <br/>
                                <br/>
                                <jsp:scriptlet>
                                    }
                                </jsp:scriptlet>
                                <webuijsf:hyperlink actionExpression="#{MinhasRequisicoes.linkSair_action}" binding="#{MinhasRequisicoes.linkSair}"
                                    id="linkSair" text="Sair" url="/logout.jsp"/>
                                <br/>
                                <br/>
                            </webuijsf:panelLayout>
                            <webuijsf:panelLayout binding="#{MinhasRequisicoes.mainContentPanel}" id="mainContentPanel" panelLayout="flow" styleClass="mainContent">
                                <webuijsf:staticText binding="#{MinhasRequisicoes.staticText11}" escape="false" id="staticText11" text="&lt;h2&gt;Minhas Requisições&lt;/h2&gt;"/>
                                <webuijsf:table augmentTitle="false" binding="#{MinhasRequisicoes.table1}" id="table1" width="0">
                                    <webuijsf:tableRowGroup binding="#{MinhasRequisicoes.tableRowGroup1}" id="tableRowGroup1" rows="10"
                                        sourceData="#{MinhasRequisicoes.requisicoes}" sourceVar="currentRow">
                                        <webuijsf:tableColumn binding="#{MinhasRequisicoes.colID}" headerText="id" id="colID" sort="id" visible="false">
                                            <webuijsf:staticText binding="#{MinhasRequisicoes.staticText5}" id="staticText5" text="#{currentRow.value['id']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn binding="#{MinhasRequisicoes.colData}" headerText="Data" id="colData" sort="dataRequisicao">
                                            <webuijsf:staticText binding="#{MinhasRequisicoes.staticText6}" id="staticText6" text="#{currentRow.value['dataRequisicao']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn binding="#{MinhasRequisicoes.colRequerente}" headerText="Requerente" id="colRequerente" sort="requerente">
                                            <webuijsf:staticText binding="#{MinhasRequisicoes.staticText7}" id="staticText7" text="#{currentRow.value['requerente']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn binding="#{MinhasRequisicoes.colAssunto}" headerText="Assunto" id="colAssunto" sort="assunto">
                                            <webuijsf:staticText binding="#{MinhasRequisicoes.staticText8}" id="staticText8" text="#{currentRow.value['assunto']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn binding="#{MinhasRequisicoes.colEstado}" headerText="Estado" id="colEstado" sort="estado">
                                            <webuijsf:staticText binding="#{MinhasRequisicoes.staticText9}" id="staticText9" text="#{currentRow.value['estado']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn binding="#{MinhasRequisicoes.colVer}" id="colVer">
                                            <webuijsf:imageHyperlink actionExpression="#{MinhasRequisicoes.linkVer_action}"
                                                binding="#{MinhasRequisicoes.linkVer}" id="linkVer" imageURL="/resources/ver.png" text=""/>
                                        </webuijsf:tableColumn>
                                    </webuijsf:tableRowGroup>
                                </webuijsf:table>
                            </webuijsf:panelLayout>
                            <br class="clearfloat"/>
                            <webuijsf:panelLayout binding="#{MinhasRequisicoes.footerPanel}" id="footerPanel" panelLayout="flow" style="text-align: right" styleClass="footer">
                                <webuijsf:staticText binding="#{MinhasRequisicoes.txtFooter}" escape="false" id="txtFooter"
                                    style="color: olive; font-family: Arial,Helvetica,sans-serif; font-size: 12px; text-align: right" text="&#xa;&lt;br/&gt;ESTG Leiria&#xa;&lt;br/&gt;&#xa;&lt;br/&gt;"/>
                            </webuijsf:panelLayout>
                        </div>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
