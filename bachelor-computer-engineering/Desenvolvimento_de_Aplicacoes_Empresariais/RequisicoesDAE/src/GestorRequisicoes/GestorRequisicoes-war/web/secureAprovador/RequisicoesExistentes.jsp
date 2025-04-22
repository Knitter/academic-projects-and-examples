<?xml version="1.0" encoding="UTF-8"?>
<!--
Document   : GerirAprovacoes
Created on : 12/Fev/2008, 15:07:48
Author     : ei10608
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page binding="#{secureAprovador$RequisicoesExistentes.page1}" id="page1">
            <webuijsf:html binding="#{secureAprovador$RequisicoesExistentes.html1}" id="html1">
                <webuijsf:head binding="#{secureAprovador$RequisicoesExistentes.head1}" id="head1">
                    <webuijsf:link binding="#{secureAprovador$RequisicoesExistentes.link1}" id="link1" url="/resources/stylesheet.css"/>
                    <webuijsf:link binding="#{secureAprovador$RequisicoesExistentes.link2}" id="link2" url="/resources/layout6.css"/>
                </webuijsf:head>
                <webuijsf:body binding="#{secureAprovador$RequisicoesExistentes.body1}" id="body1">
                    <br/>
                    <br/>
                    <webuijsf:form binding="#{secureAprovador$RequisicoesExistentes.form1}" id="form1">
                        <div id="container">
                            <!-- This clearing element should immediately follow the #mainContent div in order to force the #container div to contain all child floats -->
                            <webuijsf:panelLayout binding="#{secureAprovador$RequisicoesExistentes.headerPanel}" id="headerPanel" panelLayout="flow" styleClass="header">
                                <webuijsf:staticText binding="#{secureAprovador$RequisicoesExistentes.staticText1}" escape="false" id="staticText1" text="&lt;h1&gt;Requisições&lt;/h1&gt;"/>
                                <webuijsf:staticText binding="#{secureAprovador$RequisicoesExistentes.staticText16}" escape="false" id="staticText16" text="Aplicação de Requisições Online&#xa;&lt;br/&gt;&#xa;&lt;br/&gt;"/>
                            </webuijsf:panelLayout>
                            <!-- end #container -->
                            <webuijsf:panelLayout binding="#{secureAprovador$RequisicoesExistentes.leftSidebarPanel}" id="leftSidebarPanel" panelLayout="flow" styleClass="leftSidebar">
                                <br/>
                                <webuijsf:hyperlink actionExpression="#{secureAprovador$RequisicoesExistentes.linkCriarRequisicao_action}"
                                    binding="#{secureAprovador$RequisicoesExistentes.linkCriarRequisicao}" id="linkCriarRequisicao" text="Criar Requisição" url="/faces/index.jsp"/>
                                <br/>
                                <br/>
                                <webuijsf:hyperlink actionExpression="#{secureAprovador$RequisicoesExistentes.linkRascunhos_action}"
                                    binding="#{secureAprovador$RequisicoesExistentes.linkRascunhos}" id="linkRascunhos" text="Meus Rascunhos" url="/faces/Rascunhos.jsp"/>
                                <br/>
                                <br/>
                                <webuijsf:hyperlink actionExpression="#{secureAprovador$RequisicoesExistentes.linkMinhasRequisicoes_action}"
                                    binding="#{secureAprovador$RequisicoesExistentes.linkMinhasRequisicoes}" id="linkMinhasRequisicoes"
                                    text="Minhas Requisições" url="/faces/MinhasRequisicoes.jsp"/>
                                <br/>
                                <br/>
                                <webuijsf:hyperlink binding="#{secureAprovador$RequisicoesExistentes.linkNotificacoes}" id="linkNotificacoes"
                                    text="Notificações" url="/faces/Notificacoes.jsp"/>
                                <br/>
                                <br/>
                                <webuijsf:hyperlink actionExpression="#{secureAprovador$RequisicoesExistentes.linkRequisicoesExistentes_action}"
                                    binding="#{secureAprovador$RequisicoesExistentes.linkRequisicoesExistentes}" id="linkRequisicoesExistentes"
                                    text="Requisições Existentes" url="/faces/secureAprovador/RequisicoesExistentes.jsp"/>
                                <br/>
                                <br/>
                                <webuijsf:hyperlink actionExpression="#{secureAprovador$RequisicoesExistentes.linkNovas_action}"
                                    binding="#{secureAprovador$RequisicoesExistentes.linkNovas}" id="linkNovas" text="Requisições Pendentes" url="/faces/secureAprovador/RequisicoesPendentes.jsp"/>
                                <br/>
                                <br/>
                                <webuijsf:hyperlink actionExpression="#{secureAprovador$RequisicoesExistentes.linkLogout_action}"
                                    binding="#{secureAprovador$RequisicoesExistentes.linkLogout}" id="linkLogout" text="Sair" url="/logout.jsp"/>
                            </webuijsf:panelLayout>
                            <webuijsf:panelLayout binding="#{secureAprovador$RequisicoesExistentes.mainContentPanel}" id="mainContentPanel" panelLayout="flow" styleClass="mainContent">
                                <webuijsf:staticText binding="#{secureAprovador$RequisicoesExistentes.staticText11}" escape="false" id="staticText11" text="&lt;h2&gt;Requisições Existentes&lt;/h2&gt;"/>
                                <webuijsf:table augmentTitle="#{secureAprovador$RequisicoesExistentes.objectDataProvider1}"
                                    binding="#{secureAprovador$RequisicoesExistentes.tableExistentes}" id="tableExistentes" width="0">
                                    <webuijsf:tableRowGroup binding="#{secureAprovador$RequisicoesExistentes.tableRowGroup1}" id="tableRowGroup1" rows="10"
                                        sourceData="#{secureAprovador$RequisicoesExistentes.todasRequisicoesExceptoRascunhos}" sourceVar="currentRow">
                                        <webuijsf:tableColumn binding="#{secureAprovador$RequisicoesExistentes.colID}" headerText="id" id="colID" sort="id" visible="false">
                                            <webuijsf:staticText binding="#{secureAprovador$RequisicoesExistentes.staticText4}" id="staticText4" text="#{currentRow.value['id']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn binding="#{secureAprovador$RequisicoesExistentes.colData}" headerText="Data" id="colData" sort="dataRequisicao">
                                            <webuijsf:staticText binding="#{secureAprovador$RequisicoesExistentes.staticText5}" id="staticText5" text="#{currentRow.value['dataRequisicao']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn binding="#{secureAprovador$RequisicoesExistentes.colRequerente}" headerText="Requerente"
                                            id="colRequerente" sort="requerente">
                                            <webuijsf:staticText binding="#{secureAprovador$RequisicoesExistentes.staticText8}" id="staticText8" text="#{currentRow.value['requerente']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn binding="#{secureAprovador$RequisicoesExistentes.colAssunto}" headerText="Assunto" id="colAssunto" sort="assunto">
                                            <webuijsf:staticText binding="#{secureAprovador$RequisicoesExistentes.staticText9}" id="staticText9" text="#{currentRow.value['assunto']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn binding="#{secureAprovador$RequisicoesExistentes.colEstado}" headerText="Estado" id="colEstado" sort="estado">
                                            <webuijsf:staticText binding="#{secureAprovador$RequisicoesExistentes.staticText10}" id="staticText10" text="#{currentRow.value['estado']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn binding="#{secureAprovador$RequisicoesExistentes.colVer}" id="colVer">
                                            <webuijsf:imageHyperlink actionExpression="#{secureAprovador$RequisicoesExistentes.linkVer_action}"
                                                binding="#{secureAprovador$RequisicoesExistentes.linkVer}" id="linkVer" imageURL="/resources/ver.png" text=""/>
                                        </webuijsf:tableColumn>
                                    </webuijsf:tableRowGroup>
                                    <br/>
                                </webuijsf:table>
                            </webuijsf:panelLayout>
                            <br class="clearfloat"/>
                            <webuijsf:panelLayout binding="#{secureAprovador$RequisicoesExistentes.footerPanel}" id="footerPanel" panelLayout="flow"
                                style="text-align: right" styleClass="footer">
                                <webuijsf:staticText binding="#{secureAprovador$RequisicoesExistentes.txtFooter}" escape="false" id="txtFooter"
                                    style="color: olive; font-family: Arial,Helvetica,sans-serif; font-size: 12px; text-align: right" text="&#xa;&lt;br/&gt;ESTG Leiria&#xa;&lt;br/&gt;&#xa;&lt;br/&gt;"/>
                            </webuijsf:panelLayout>
                        </div>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
