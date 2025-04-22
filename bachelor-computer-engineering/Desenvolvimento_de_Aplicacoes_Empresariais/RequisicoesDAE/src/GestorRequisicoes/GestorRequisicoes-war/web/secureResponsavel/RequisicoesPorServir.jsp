<?xml version="1.0" encoding="UTF-8"?>
<!--
Document   : RequisicoesAntigas
Created on : 13/Fev/2008, 19:02:24
Author     : Knitter
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <webuijsf:page binding="#{secureResponsavel$RequisicoesPorServir.page1}" id="page1">
            <webuijsf:html binding="#{secureResponsavel$RequisicoesPorServir.html1}" id="html1">
                <webuijsf:head binding="#{secureResponsavel$RequisicoesPorServir.head1}" id="head1">
                    <webuijsf:link binding="#{secureResponsavel$RequisicoesPorServir.link1}" id="link1" url="/resources/stylesheet.css"/>
                    <webuijsf:link binding="#{secureResponsavel$RequisicoesPorServir.link2}" id="link2" url="/resources/layout6.css"/>
                </webuijsf:head>
                <webuijsf:body binding="#{secureResponsavel$RequisicoesPorServir.body1}" id="body1">
                    <br/>
                    <webuijsf:form binding="#{secureResponsavel$RequisicoesPorServir.form1}" id="form1">
                        <div id="container">
                            <!-- This clearing element should immediately follow the #mainContent div in order to force the #container div to contain all child floats -->
                            <!-- end #container -->
                            <webuijsf:panelLayout binding="#{secureResponsavel$RequisicoesPorServir.headerPanel}" id="headerPanel" panelLayout="flow" styleClass="header">
                                <webuijsf:staticText binding="#{secureResponsavel$RequisicoesPorServir.staticText1}" escape="false" id="staticText1" text="&lt;h1&gt;Requisições&lt;/h1&gt;"/>
                                <webuijsf:staticText binding="#{secureResponsavel$RequisicoesPorServir.staticText16}" escape="false" id="staticText16" text="Aplicação de Requisições Online&#xa;&lt;br/&gt;&#xa;&lt;br/&gt;"/>
                            </webuijsf:panelLayout>
                            <webuijsf:panelLayout binding="#{secureResponsavel$RequisicoesPorServir.leftSidebarPanel}" id="leftSidebarPanel" panelLayout="flow" styleClass="leftSidebar">
                                <br/>
                                <webuijsf:hyperlink binding="#{secureResponsavel$RequisicoesPorServir.linkCriar}" id="linkCriar" text="Criar Requisição" url="/faces/index.jsp"/>
                                <br/>
                                <br/>
                                <webuijsf:hyperlink binding="#{secureResponsavel$RequisicoesPorServir.linkRascunhos}" id="linkRascunhos" text="Meus Rascunhos" url="/faces/Rascunhos.jsp"/>
                                <br/>
                                <br/>
                                <webuijsf:hyperlink binding="#{secureResponsavel$RequisicoesPorServir.linkRequisicoes}" id="linkRequisicoes"
                                    text="Minhas Requisições" url="/faces/MinhasRequisicoes.jsp"/>
                                <br/>
                                <br/>
                                <webuijsf:hyperlink binding="#{secureResponsavel$RequisicoesPorServir.linkNotificacao}" id="linkNotificacao" text="Notificações" url="/faces/Notificacoes.jsp"/>
                                <br/>
                                <br/>
                                <webuijsf:hyperlink binding="#{secureResponsavel$RequisicoesPorServir.linkPendentes}" id="linkPendentes"
                                    text="Requisições Pendentes" url="/faces/secureResponsavel/RequisicoesPendentes.jsp"/>
                                <br/>
                                <br/>
                                <br/>
                                <webuijsf:hyperlink binding="#{secureResponsavel$RequisicoesPorServir.linkSair}" id="linkSair" text="Sair" url="/logout.jsp"/>
                                <br/>
                                <br/>
                            </webuijsf:panelLayout>
                            <webuijsf:panelLayout binding="#{secureResponsavel$RequisicoesPorServir.mainContentPanel}" id="mainContentPanel" panelLayout="flow" styleClass="mainContent">
                                <webuijsf:staticText binding="#{secureResponsavel$RequisicoesPorServir.staticText11}" escape="false" id="staticText11" text="&lt;h2&gt;Requisições Pendentes&lt;/h2&gt;"/>
                                <webuijsf:table augmentTitle="false" binding="#{secureResponsavel$RequisicoesPorServir.tabelaPendentes}" id="tabelaPendentes"
                                    paginateButton="true" paginationControls="true" width="304">
                                    <webuijsf:tableRowGroup binding="#{secureResponsavel$RequisicoesPorServir.tableRowGroup1}" id="tableRowGroup1" rows="5"
                                        sourceData="#{secureResponsavel$RequisicoesPorServir.requisicoesPendentes}" sourceVar="currentRow">
                                        <webuijsf:tableColumn binding="#{secureResponsavel$RequisicoesPorServir.colID}" headerText="id" id="colID" sort="id" visible="false">
                                            <webuijsf:staticText binding="#{secureResponsavel$RequisicoesPorServir.staticText4}" id="staticText4" text="#{currentRow.value['id']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn binding="#{secureResponsavel$RequisicoesPorServir.colData}" headerText="Data" id="colData" sort="dataRequisicao">
                                            <webuijsf:staticText binding="#{secureResponsavel$RequisicoesPorServir.staticText7}" id="staticText7" text="#{currentRow.value['dataRequisicao']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn binding="#{secureResponsavel$RequisicoesPorServir.colAssunto}" headerText="Assunto"
                                            id="colAssunto" sort="assunto">
                                            <webuijsf:staticText binding="#{secureResponsavel$RequisicoesPorServir.staticText2}" id="staticText2" text="#{currentRow.value['assunto']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn binding="#{secureResponsavel$RequisicoesPorServir.calAprovador}" headerText="Aprovador"
                                            id="calAprovador" sort="aprovador">
                                            <webuijsf:staticText binding="#{secureResponsavel$RequisicoesPorServir.staticText5}" id="staticText5" text="#{currentRow.value['aprovador']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn binding="#{secureResponsavel$RequisicoesPorServir.colSatisfeita}" id="colSatisfeita">
                                            <webuijsf:imageHyperlink actionExpression="#{secureResponsavel$RequisicoesPorServir.imglinkSatisfeita_action}"
                                                binding="#{secureResponsavel$RequisicoesPorServir.imglinkSatisfeita}" id="imglinkSatisfeita"
                                                imageURL="/resources/ok.png" text="Satisfeita" toolTip="Satisfeita"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn binding="#{secureResponsavel$RequisicoesPorServir.colParcialmente}" id="colParcialmente">
                                            <webuijsf:imageHyperlink actionExpression="#{secureResponsavel$RequisicoesPorServir.imglinkParcialmente_action}"
                                                binding="#{secureResponsavel$RequisicoesPorServir.imglinkParcialmente}" id="imglinkParcialmente"
                                                imageURL="/resources/parcialmente.png" text="Parcialmente" toolTip="Parcialmente Satisfeita"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn binding="#{secureResponsavel$RequisicoesPorServir.colNotificar}" id="colNotificar">
                                            <webuijsf:imageHyperlink actionExpression="#{secureResponsavel$RequisicoesPorServir.imglinkNotificar_action}"
                                                binding="#{secureResponsavel$RequisicoesPorServir.imglinkNotificar}" id="imglinkNotificar"
                                                imageURL="/resource/bell.png" text="Notificar" toolTip="Notificar Uitlizadores"/>
                                        </webuijsf:tableColumn>
                                    </webuijsf:tableRowGroup>
                                </webuijsf:table>
                            </webuijsf:panelLayout>
                            <br class="clearfloat"/>
                            <webuijsf:panelLayout binding="#{secureResponsavel$RequisicoesPorServir.footerPanel}" id="footerPanel" panelLayout="flow"
                                style="text-align: right" styleClass="footer">
                                <webuijsf:staticText binding="#{secureResponsavel$RequisicoesPorServir.txtFooter}" escape="false" id="txtFooter"
                                    style="color: olive; font-family: Arial,Helvetica,sans-serif; font-size: 12px; text-align: right" text="&#xa;&lt;br/&gt;ESTG Leiria&#xa;&lt;br/&gt;&#xa;&lt;br/&gt;"/>
                            </webuijsf:panelLayout>
                        </div>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
