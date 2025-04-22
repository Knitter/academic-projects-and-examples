<?xml version="1.0" encoding="ISO-8859-1"?>
<!--
Document   : index
Created on : 12/Fev/2008, 11:37:11
Author     : ei10608
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="ISO-8859-1"/>
    <f:view>
        <webuijsf:page binding="#{index.page1}" id="page1">
            <webuijsf:html binding="#{index.html1}" id="html1">
                <webuijsf:head binding="#{index.head1}" id="head1">
                    <webuijsf:link binding="#{index.link1}" id="link1" url="/resources/stylesheet.css"/>
                    <webuijsf:link binding="#{index.link2}" id="link2" url="/resources/layout6.css"/>
                </webuijsf:head>
                <webuijsf:body binding="#{index.body1}" id="body1">
                    <br/>
                    <webuijsf:form binding="#{index.form1}" id="form1">
                        <div id="container" style="width: 764px">
                            <!-- This clearing element should immediately follow the #mainContent div in order to force the #container div to contain all child floats -->
                            <webuijsf:panelLayout binding="#{index.headerPanel}" id="headerPanel" panelLayout="flow" styleClass="header">
                                <webuijsf:staticText binding="#{index.staticText1}" escape="false" id="staticText1" text="&lt;h1&gt;Requisições&lt;/h1&gt;"/>
                                <webuijsf:staticText binding="#{index.staticText16}" escape="false" id="staticText16" text="Aplicação de Requisições Online&#xa;&lt;br/&gt;&#xa;&lt;br/&gt;"/>
                            </webuijsf:panelLayout>
                            <!-- end #container -->
                            <webuijsf:panelLayout binding="#{index.leftSidebarPanel}" id="leftSidebarPanel" panelLayout="flow" styleClass="leftSidebar">
                                <br/>
                                <webuijsf:hyperlink actionExpression="#{index.linkCriarRequisicao_action}" binding="#{index.linkCriarRequisicao}"
                                    id="linkCriarRequisicao" text="Criar Requisição" url="/faces/index.jsp"/>
                                <br/>
                                <br/>
                                <webuijsf:hyperlink actionExpression="#{index.linkRascunhos_action}" binding="#{index.linkRascunhos}" id="linkRascunhos"
                                    text="Meus Rascunhos" url="/faces/Rascunhos.jsp"/>
                                <br/>
                                <br/>
                                <webuijsf:hyperlink actionExpression="#{index.linkListaRequisicoes_action}" binding="#{index.linkListaRequisicoes}"
                                    id="linkListaRequisicoes" text="Minhas Requisições" url="/faces/MinhasRequisicoes.jsp"/>
                               <br/>
                               <br/>
                               <webuijsf:hyperlink binding="#{index.linkNotificacao}" id="linkNotificacao" text="Notificações" url="/faces/Notificacoes.jsp"/>
                                <br/>
                                <br/>
                                <jsp:scriptlet>
                                    if (request.isUserInRole("Aprovador")) {
                                </jsp:scriptlet>
                                <webuijsf:hyperlink binding="#{index.linkRequisicoesExistentes}" id="linkRequisicoesExistentes" text="Requisições Existentes" url="/faces/secureAprovador/RequisicoesExistentes.jsp"/>
                                <br/>
                                <br/>
                                <webuijsf:hyperlink actionExpression="#{index.linkAprovador_action}" binding="#{index.linkAprovador}" id="linkAprovador"
                                    text="Requisicões Pendentes" url="/faces/secureAprovador/RequisicoesPendentes.jsp"/>
                                <br/>
                                <br/>
                                <jsp:scriptlet>
                                    }else if (request.isUserInRole("Responsavel")) {
                                </jsp:scriptlet>
                                <webuijsf:hyperlink binding="#{index.linkRequisicoesExistentes}" id="linkRequisicoesExistentes" text="Requisições Existentes" url="/faces/secureResponsavel/RequisicoesExistentes.jsp"/>
                                <br/>
                                <br/>
                                <webuijsf:hyperlink actionExpression="#{index.linkResponsavel_action}" binding="#{index.linkResponsavel}" id="linkResponsavel"
                                    text="Requisições Pendentes" url="/faces/secureResponsavel/RequisicoesPorServir.jsp"/>
                                <br/>
                                <br/>
                                <jsp:scriptlet>
                                    }
                                </jsp:scriptlet>
                                <webuijsf:hyperlink actionExpression="#{index.linkSair_action}" binding="#{index.linkSair}" id="linkSair" text="Sair" url="/logout.jsp"/>
                                <br/>
                                <br/>
                            </webuijsf:panelLayout>
                            <webuijsf:panelLayout binding="#{index.mainContentPanel}" id="mainContentPanel" panelLayout="flow" style="height: 100%; width: 100%" styleClass="mainContent">
                                <webuijsf:staticText binding="#{index.staticTextTitulo}" escape="false" id="staticTextTitulo" text="&lt;h2&gt;Criar Requisição&lt;/h2&gt;&#xa;"/>
                                <webuijsf:panelLayout binding="#{index.layoutPanelDestino}" id="layoutPanelDestino" panelLayout="flow" style="font-family: 'Verdana','Arial','Helvetica',sans-serif; font-size: 18px; font-style: normal; font-weight: normal; height: 33px; vertical-align: text-top; width: 518px">
                                    <webuijsf:dropDown binding="#{index.dropDownDestino}" id="dropDownDestino"
                                        items="#{index.dropDownDestinoDefaultOptions.options}" label="Destino:" labelLevel="3" style="font-family: Verdana,Arial,Helvetica,sans-serif; font-size: 18px; height: 100%; vertical-align: top; width: 100%"/>
                                </webuijsf:panelLayout>
                                <webuijsf:calendar binding="#{index.calendarDataPretendida}" id="calendarDataPretendida" label="Data pretendida:"/>
                                <webuijsf:panelLayout binding="#{index.layoutPanelAssunto}" id="layoutPanelAssunto" panelLayout="flow" style="font-family: Verdana,Arial,Helvetica,sans-serif; font-style: normal; font-weight: normal; vertical-align: text-top">
                                    <webuijsf:textArea binding="#{index.textAreaAssunto}" columns="25" id="textAreaAssunto" label="Assunto:" labelLevel="3"
                                        rows="5" style="font-family: Verdana,Arial,Helvetica,sans-serif; font-style: normal; font-weight: normal"/>
                                </webuijsf:panelLayout>
                                <webuijsf:panelLayout binding="#{index.layoutPanelSpacer1}" id="layoutPanelSpacer1" panelLayout="flow" style="height: 20px; width: 100%"/>
                                <webuijsf:panelLayout binding="#{index.layoutPanelBotoesSub}" id="layoutPanelBotoesSub" style="height: 30px; width: 100%">
                                    <webuijsf:checkbox binding="#{index.checkboxRascunho}" id="checkboxRascunho" label="Rascunho" style="left: 50px; top: 0px"/>
                                    <webuijsf:button actionExpression="#{index.buttonCriar_action}" binding="#{index.buttonCriar}" id="buttonCriar"
                                        style="left: 300px; top: 0px; position: absolute" text="Criar"/>
                                    <webuijsf:button actionExpression="#{index.buttonLimpar_action}" binding="#{index.buttonLimpar}" id="buttonLimpar"
                                        reset="true" style="left: 355px; top: 0px; position: absolute" text="Limpar"/>
                                </webuijsf:panelLayout>
                                <webuijsf:panelLayout binding="#{index.layoutPanelSpacer}" id="layoutPanelSpacer" panelLayout="flow" style="height: 20px; width: 100%"/>
                            </webuijsf:panelLayout>
                            <br class="clearfloat"/>
                            <webuijsf:panelLayout binding="#{index.footerPanel}" id="footerPanel" panelLayout="flow" style="text-align: right" styleClass="footer">
                                <webuijsf:staticText binding="#{index.txtFooter}" escape="false" id="txtFooter"
                                    style="color: olive; font-family: Arial,Helvetica,sans-serif; font-size: 12px; text-align: right" text="&#xa;&lt;br/&gt;ESTG Leiria&#xa;&lt;br/&gt;&#xa;&lt;br/&gt;"/>
                            </webuijsf:panelLayout>
                        </div>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
