<?xml version="1.0" encoding="UTF-8"?>
<!--
Document   : GerirAprovacoes
Created on : 12/Fev/2008, 15:07:48
Author     : ei10608
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page binding="#{secureResponsavel$RequisicoesExistentes.page1}" id="page1">
            <webuijsf:html binding="#{secureResponsavel$RequisicoesExistentes.html1}" id="html1">
                <webuijsf:head binding="#{secureResponsavel$RequisicoesExistentes.head1}" id="head1">
                    <webuijsf:link binding="#{secureResponsavel$RequisicoesExistentes.link1}" id="link1" url="/resources/stylesheet.css"/>
                    <webuijsf:link binding="#{secureResponsavel$RequisicoesExistentes.link2}" id="link2" url="/resources/layout6.css"/>
                </webuijsf:head>
                <webuijsf:body binding="#{secureResponsavel$RequisicoesExistentes.body1}" id="body1">
                    <br/>
                    <br/>
                    <webuijsf:form binding="#{secureResponsavel$RequisicoesExistentes.form1}" id="form1">
                        <div id="container">
                            <!-- This clearing element should immediately follow the #mainContent div in order to force the #container div to contain all child floats -->
                            <webuijsf:panelLayout binding="#{secureResponsavel$RequisicoesExistentes.headerPanel}" id="headerPanel" panelLayout="flow" styleClass="header">
                                <webuijsf:staticText binding="#{secureResponsavel$RequisicoesExistentes.staticText1}" escape="false" id="staticText1" text="&lt;h1&gt;Requisições&lt;/h1&gt;"/>
                                <webuijsf:staticText binding="#{secureResponsavel$RequisicoesExistentes.staticText16}" escape="false" id="staticText16" text="Aplicação de Requisições Online&#xa;&lt;br/&gt;&#xa;&lt;br/&gt;"/>
                            </webuijsf:panelLayout>
                            <!-- end #container -->
                            <webuijsf:panelLayout binding="#{secureResponsavel$RequisicoesExistentes.leftSidebarPanel}" id="leftSidebarPanel" panelLayout="flow" styleClass="leftSidebar">
                                <br/>
                                <webuijsf:hyperlink actionExpression="#{secureResponsavel$RequisicoesExistentes.linkCriarRequisicao_action}"
                                    binding="#{secureResponsavel$RequisicoesExistentes.linkCriarRequisicao}" id="linkCriarRequisicao" text="Criar Requisição" url="/faces/index.jsp"/>
                                <br/>
                                <br/>
                                <webuijsf:hyperlink actionExpression="#{secureResponsavel$RequisicoesExistentes.linkRascunhos_action}"
                                    binding="#{secureResponsavel$RequisicoesExistentes.linkRascunhos}" id="linkRascunhos" text="Meus Rascunhos" url="/faces/Rascunhos.jsp"/>
                                <br/>
                                <br/>
                                <webuijsf:hyperlink actionExpression="#{secureResponsavel$RequisicoesExistentes.linkMinhasRequisicoes_action}"
                                    binding="#{secureResponsavel$RequisicoesExistentes.linkMinhasRequisicoes}" id="linkMinhasRequisicoes"
                                    text="Minhas Requisições" url="/faces/MinhasRequisicoes.jsp"/>
                                <br/>
                                <br/>
                                <webuijsf:hyperlink actionExpression="#{secureResponsavel$RequisicoesExistentes.linkRequisicoesExistentes_action}"
                                    binding="#{secureResponsavel$RequisicoesExistentes.linkRequisicoesExistentes}" id="linkRequisicoesExistentes"
                                    text="Requisições Existentes" url="/faces/secureResponsavel/RequisicoesExistentes.jsp"/>
                                <br/>
                                <br/>
                                <webuijsf:hyperlink actionExpression="#{secureResponsavel$RequisicoesExistentes.linkNovas_action}"
                                    binding="#{secureResponsavel$RequisicoesExistentes.linkNovas}" id="linkNovas" text="Requisições Pendentes" url="/faces/secureResponsavel/RequisicoesPendentes.jsp"/>
                                <br/>
                                <br/>
                                <webuijsf:hyperlink actionExpression="#{secureResponsavel$RequisicoesExistentes.linkLogout_action}"
                                    binding="#{secureResponsavel$RequisicoesExistentes.linkLogout}" id="linkLogout" text="Sair" url="/logout.jsp"/>
                            </webuijsf:panelLayout>
                            <webuijsf:panelLayout binding="#{secureResponsavel$RequisicoesExistentes.mainContentPanel}" id="mainContentPanel" panelLayout="flow" styleClass="mainContent">
                                <webuijsf:staticText binding="#{secureResponsavel$RequisicoesExistentes.staticText11}" escape="false" id="staticText11" text="&lt;h2&gt;Requisições Existentes&lt;/h2&gt;"/>
                                <webuijsf:table augmentTitle="#{secureResponsavel$RequisicoesExistentes.objectDataProvider1}"
                                    binding="#{secureResponsavel$RequisicoesExistentes.tableExistentes}" id="tableExistentes" width="0">
                                    <webuijsf:tableRowGroup binding="#{secureResponsavel$RequisicoesExistentes.tableRowGroup1}" id="tableRowGroup1" rows="10"
                                        sourceData="#{secureResponsavel$RequisicoesExistentes.todasRequisicoesExceptoRascunhos}" sourceVar="currentRow">
                                        <webuijsf:tableColumn binding="#{secureResponsavel$RequisicoesExistentes.colID}" headerText="id" id="colID" sort="id" visible="false">
                                            <webuijsf:staticText binding="#{secureResponsavel$RequisicoesExistentes.staticText4}" id="staticText4" text="#{currentRow.value['id']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn binding="#{secureResponsavel$RequisicoesExistentes.colData}" headerText="Data" id="colData" sort="dataRequisicao">
                                            <webuijsf:staticText binding="#{secureResponsavel$RequisicoesExistentes.staticText5}" id="staticText5" text="#{currentRow.value['dataRequisicao']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn binding="#{secureResponsavel$RequisicoesExistentes.colRequerente}" headerText="Requerente"
                                            id="colRequerente" sort="requerente">
                                            <webuijsf:staticText binding="#{secureResponsavel$RequisicoesExistentes.staticText8}" id="staticText8" text="#{currentRow.value['requerente']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn binding="#{secureResponsavel$RequisicoesExistentes.colAssunto}" headerText="Assunto"
                                            id="colAssunto" sort="assunto">
                                            <webuijsf:staticText binding="#{secureResponsavel$RequisicoesExistentes.staticText9}" id="staticText9" text="#{currentRow.value['assunto']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn binding="#{secureResponsavel$RequisicoesExistentes.colEstado}" headerText="Estado" id="colEstado" sort="estado">
                                            <webuijsf:staticText binding="#{secureResponsavel$RequisicoesExistentes.staticText10}" id="staticText10" text="#{currentRow.value['estado']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn binding="#{secureResponsavel$RequisicoesExistentes.colVer}" id="colVer">
                                            <webuijsf:imageHyperlink actionExpression="#{secureResponsavel$RequisicoesExistentes.linkVer_action}"
                                                binding="#{secureResponsavel$RequisicoesExistentes.linkVer}" id="linkVer" imageURL="/resources/ver.png" text=""/>
                                        </webuijsf:tableColumn>
                                    </webuijsf:tableRowGroup>
                                    <br/>
                                </webuijsf:table>
                            </webuijsf:panelLayout>
                            <br class="clearfloat"/>
                            <webuijsf:panelLayout binding="#{secureResponsavel$RequisicoesExistentes.footerPanel}" id="footerPanel" panelLayout="flow"
                                style="text-align: right" styleClass="footer">
                                <webuijsf:staticText binding="#{secureResponsavel$RequisicoesExistentes.txtFooter}" escape="false" id="txtFooter"
                                    style="color: olive; font-family: Arial,Helvetica,sans-serif; font-size: 12px; text-align: right" text="&#xa;&lt;br/&gt;ESTG Leiria&#xa;&lt;br/&gt;&#xa;&lt;br/&gt;"/>
                            </webuijsf:panelLayout>
                        </div>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
