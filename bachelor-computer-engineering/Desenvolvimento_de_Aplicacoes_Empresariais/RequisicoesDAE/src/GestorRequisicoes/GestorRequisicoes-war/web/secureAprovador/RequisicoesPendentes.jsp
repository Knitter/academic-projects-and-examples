<?xml version="1.0" encoding="UTF-8"?>
<!--
Document   : GerirAprovacoes
Created on : 12/Fev/2008, 15:07:48
Author     : ei10608
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page binding="#{secureAprovador$RequisicoesPendentes.page1}" id="page1">
            <webuijsf:html binding="#{secureAprovador$RequisicoesPendentes.html1}" id="html1">
                <webuijsf:head binding="#{secureAprovador$RequisicoesPendentes.head1}" id="head1">
                    <webuijsf:link binding="#{secureAprovador$RequisicoesPendentes.link1}" id="link1" url="/resources/stylesheet.css"/>
                    <webuijsf:link binding="#{secureAprovador$RequisicoesPendentes.link2}" id="link2" url="/resources/layout6.css"/>
                </webuijsf:head>
                <webuijsf:body binding="#{secureAprovador$RequisicoesPendentes.body1}" id="body1">
                    <br/>
                    <br/>
                    <webuijsf:form binding="#{secureAprovador$RequisicoesPendentes.form1}" id="form1">
                        <div id="container">
                            <!-- This clearing element should immediately follow the #mainContent div in order to force the #container div to contain all child floats -->
                            <webuijsf:panelLayout binding="#{secureAprovador$RequisicoesPendentes.headerPanel}" id="headerPanel" panelLayout="flow" styleClass="header">
                                <webuijsf:staticText binding="#{secureAprovador$RequisicoesPendentes.staticText1}" escape="false" id="staticText1" text="&lt;h1&gt;Requisições&lt;/h1&gt;"/>
                                <webuijsf:staticText binding="#{secureAprovador$RequisicoesPendentes.staticText16}" escape="false" id="staticText16" text="Aplicação de Requisições Online&#xa;&lt;br/&gt;&#xa;&lt;br/&gt;"/>
                            </webuijsf:panelLayout>
                            <!-- end #container -->
                            <webuijsf:panelLayout binding="#{secureAprovador$RequisicoesPendentes.leftSidebarPanel}" id="leftSidebarPanel" panelLayout="flow" styleClass="leftSidebar">
                                <br/>
                                <webuijsf:hyperlink actionExpression="#{secureAprovador$RequisicoesPendentes.linkCriarRequisicao_action}"
                                    binding="#{secureAprovador$RequisicoesPendentes.linkCriarRequisicao}" id="linkCriarRequisicao" text="Criar Requisição" url="/faces/index.jsp"/>
                                <br/>
                                <br/>
                                <webuijsf:hyperlink actionExpression="#{secureAprovador$RequisicoesPendentes.linkRascunhos_action}"
                                    binding="#{secureAprovador$RequisicoesPendentes.linkRascunhos}" id="linkRascunhos" text="Meus Rascunhos" url="/faces/Rascunhos.jsp"/>
                                <br/>
                                <br/>
                                <webuijsf:hyperlink actionExpression="#{secureAprovador$RequisicoesPendentes.linkMinhasRequisicoes_action}"
                                    binding="#{secureAprovador$RequisicoesPendentes.linkMinhasRequisicoes}" id="linkMinhasRequisicoes" text="Minhas Requisições" url="/faces/MinhasRequisicoes.jsp"/>
                                <br/>
                                <br/>
                                <webuijsf:hyperlink binding="#{secureAprovador$RequisicoesPendentes.linkNotificacoes}" id="linkNotificacoes" text="Notificações" url="/faces/Notificacoes.jsp"/>
                                <br/>
                                <br/>
                                <webuijsf:hyperlink actionExpression="#{secureAprovador$RequisicoesPendentes.linkRequisicoesExistentes_action}"
                                    binding="#{secureAprovador$RequisicoesPendentes.linkRequisicoesExistentes}" id="linkRequisicoesExistentes"
                                    text="Requisições Existentes" url="/faces/secureAprovador/RequisicoesExistentes.jsp"/>
                                <br/>
                                <br/>
                                <webuijsf:hyperlink actionExpression="#{secureAprovador$RequisicoesPendentes.linkRequisicoesPendentes_action}"
                                    binding="#{secureAprovador$RequisicoesPendentes.linkRequisicoesPendentes}" id="linkRequisicoesPendentes"
                                    text="Requisições Pendentes" url="/faces/secureAprovador/RequisicoesPendentes.jsp"/>
                                <br/>
                                <br/>
                                <webuijsf:hyperlink actionExpression="#{secureAprovador$RequisicoesPendentes.linkLogout_action}"
                                    binding="#{secureAprovador$RequisicoesPendentes.linkLogout}" id="linkLogout" text="Sair" url="/logout.jsp"/>
                            </webuijsf:panelLayout>
                            <webuijsf:panelLayout binding="#{secureAprovador$RequisicoesPendentes.mainContentPanel}" id="mainContentPanel" panelLayout="flow" styleClass="mainContent">
                                <webuijsf:staticText binding="#{secureAprovador$RequisicoesPendentes.staticText11}" escape="false" id="staticText11" text="&lt;h2&gt;Requisições Pendentes&lt;/h2&gt;"/>
                                <webuijsf:table augmentTitle="#{secureAprovador$RequisicoesPendentes.objectDataProvider1}"
                                    binding="#{secureAprovador$RequisicoesPendentes.tablePendentes}" id="tablePendentes" width="17">
                                    <webuijsf:tableRowGroup binding="#{secureAprovador$RequisicoesPendentes.tableRowGroup1}" id="tableRowGroup1" rows="10"
                                        sourceData="#{secureAprovador$RequisicoesPendentes.requisicoesPendentes}" sourceVar="currentRow">
                                        <webuijsf:tableColumn binding="#{secureAprovador$RequisicoesPendentes.colID}" headerText="id" id="colID" sort="id"
                                            style="" visible="false">
                                            <webuijsf:staticText binding="#{secureAprovador$RequisicoesPendentes.staticText3}" id="staticText3" text="#{currentRow.value['id']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn binding="#{secureAprovador$RequisicoesPendentes.colData}" headerText="Data" id="colData" sort="dataRequisicao">
                                            <webuijsf:staticText binding="#{secureAprovador$RequisicoesPendentes.staticText7}" id="staticText7" text="#{currentRow.value['dataRequisicao']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn binding="#{secureAprovador$RequisicoesPendentes.colRequerente}" headerText="Requerente"
                                            id="colRequerente" sort="requerente">
                                            <webuijsf:staticText binding="#{secureAprovador$RequisicoesPendentes.staticText2}" id="staticText2" text="#{currentRow.value['requerente']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn binding="#{secureAprovador$RequisicoesPendentes.colAssunto}" headerText="Assunto" id="colAssunto" sort="assunto">
                                            <webuijsf:staticText binding="#{secureAprovador$RequisicoesPendentes.staticText6}" id="staticText6" text="#{currentRow.value['assunto']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn binding="#{secureAprovador$RequisicoesPendentes.colVer}" id="colVer">
                                            <webuijsf:imageHyperlink actionExpression="#{secureAprovador$RequisicoesPendentes.linkVer_action}"
                                                binding="#{secureAprovador$RequisicoesPendentes.linkVer}" id="linkVer" imageURL="/resources/ver.png" text=""/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn align="center" binding="#{secureAprovador$RequisicoesPendentes.colAprovar}" id="colAprovar" width="8">
                                            <webuijsf:imageHyperlink actionExpression="#{secureAprovador$RequisicoesPendentes.linkAprovar_action}"
                                                binding="#{secureAprovador$RequisicoesPendentes.linkAprovar}" id="linkAprovar" imageURL="/resources/aprovar.png"
                                                text="" toolTip="Aprovar"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn align="center" binding="#{secureAprovador$RequisicoesPendentes.colReprovar}" id="colReprovar" width="9">
                                            <webuijsf:imageHyperlink actionExpression="#{secureAprovador$RequisicoesPendentes.linkReprovar_action}"
                                                binding="#{secureAprovador$RequisicoesPendentes.linkReprovar}" id="linkReprovar"
                                                imageURL="/resources/reprovar.png" text="" toolTip="Reprovar"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn binding="#{secureAprovador$RequisicoesPendentes.colAlterar}" id="colAlterar">
                                            <webuijsf:imageHyperlink actionExpression="#{secureAprovador$RequisicoesPendentes.linkAlterar_action}"
                                                binding="#{secureAprovador$RequisicoesPendentes.linkAlterar}" id="linkAlterar" imageURL="/resources/alterar.png" text=""/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn binding="#{secureAprovador$RequisicoesPendentes.colApagar}" id="colApagar">
                                            <webuijsf:imageHyperlink actionExpression="#{secureAprovador$RequisicoesPendentes.linkApagar_action}"
                                                binding="#{secureAprovador$RequisicoesPendentes.linkApagar}" id="linkApagar" imageURL="/resources/apagar.png" text=""/>
                                        </webuijsf:tableColumn>
                                    </webuijsf:tableRowGroup>
                                    <br/>
                                </webuijsf:table>
                            </webuijsf:panelLayout>
                            <br class="clearfloat"/>
                            <webuijsf:panelLayout binding="#{secureAprovador$RequisicoesPendentes.footerPanel}" id="footerPanel" panelLayout="flow"
                                style="text-align: right" styleClass="footer">
                                <webuijsf:staticText binding="#{secureAprovador$RequisicoesPendentes.txtFooter}" escape="false" id="txtFooter"
                                    style="color: olive; font-family: Arial,Helvetica,sans-serif; font-size: 12px; text-align: right" text="&#xa;&lt;br/&gt;ESTG Leiria&#xa;&lt;br/&gt;&#xa;&lt;br/&gt;"/>
                            </webuijsf:panelLayout>
                        </div>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
