<?xml version="1.0" encoding="ISO-8859-1"?>
<!--
Document   : index
Created on : 12/Fev/2008, 11:37:11
Author     : ei10608
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="ISO-8859-1"/>
    <f:view>
        <webuijsf:page binding="#{NewReqEmpStep2.page1}" id="page1">
            <webuijsf:html binding="#{NewReqEmpStep2.html1}" id="html1">
                <webuijsf:head binding="#{NewReqEmpStep2.head1}" id="head1">
                    <webuijsf:link binding="#{NewReqEmpStep2.link1}" id="link1" url="/resources/stylesheet.css"/>
                    <webuijsf:link binding="#{NewReqEmpStep2.link2}" id="link2" url="/resources/layout6.css"/>
                </webuijsf:head>
                <webuijsf:body binding="#{NewReqEmpStep2.body1}" id="body1">
                    <br/>
                    <webuijsf:form binding="#{NewReqEmpStep2.form1}" id="form1">
                        <div id="container" style="width: 750px">
                            <!-- This clearing element should immediately follow the #mainContent div in order to force the #container div to contain all child floats -->
                            <webuijsf:panelLayout binding="#{NewReqEmpStep2.headerPanel}" id="headerPanel" panelLayout="flow" styleClass="header">
                                <webuijsf:staticText binding="#{NewReqEmpStep2.staticText1}" escape="false" id="staticText1" text="&lt;h1&gt;Requisições&lt;/h1&gt;"/>
                                <webuijsf:staticText binding="#{NewReqEmpStep2.staticText16}" escape="false" id="staticText16" text="Aplicação de Requisições Online&#xa;&lt;br/&gt;&#xa;&lt;br/&gt;"/>
                            </webuijsf:panelLayout>
                            <!-- end #container -->
                            <webuijsf:panelLayout binding="#{NewReqEmpStep2.leftSidebarPanel}" id="leftSidebarPanel" panelLayout="flow" styleClass="leftSidebar">
                                <br/>
                                <webuijsf:hyperlink binding="#{NewReqEmpStep2.linkCriarRequisicao}" id="linkCriarRequisicao" text="Criar Requisição" url="/faces/index.jsp"/>
                                <br/>
                                <br/>
                                <webuijsf:hyperlink binding="#{NewReqEmpStep2.linkRascunhos}" id="linkRascunhos" text="Meus Rascunhos" url="/faces/Rascunhos.jsp"/>
                                <br/>
                                <br/>
                                <webuijsf:hyperlink binding="#{NewReqEmpStep2.linkListaRequisicoes}" id="linkListaRequisicoes" text="Minhas Requisições" url="/faces/MinhasRequisicoes.jsp"/>
                                <br/>
                                <br/>
                                <jsp:scriptlet>
                                    if (request.isUserInRole("Aprovador")) {
                                </jsp:scriptlet>
                                <webuijsf:hyperlink actionExpression="#{NewReqEmpStep2.linkAprovador_action}" binding="#{NewReqEmpStep2.linkAprovador}"
                                    id="linkAprovador" text="Requisicões Pendentes" url="/faces/secureAprovador/RequisicoesPendentes.jsp"/>
                                <br/>
                                <br/>
                                <jsp:scriptlet>
                                    }else if (request.isUserInRole("Responsavel")) {
                                </jsp:scriptlet>
                                <webuijsf:hyperlink actionExpression="#{NewReqEmpStep2.linkResponsavel_action}" binding="#{NewReqEmpStep2.linkResponsavel}"
                                    id="linkResponsavel" text="Gerir Armazém" url="/faces/secureResponsavel/GerirArmazem.jsp"/>
                                <br/>
                                <br/>
                                <jsp:scriptlet>
                                    }
                                </jsp:scriptlet>
                                <webuijsf:hyperlink binding="#{NewReqEmpStep2.linkSair}" id="linkSair" text="Sair" url="/logout.jsp"/>
                                <br/>
                                <br/>
                            </webuijsf:panelLayout>
                            <webuijsf:panelLayout binding="#{NewReqEmpStep2.mainContentPanel}" id="mainContentPanel" panelLayout="flow"
                                style="height: 100%; width: 100%" styleClass="mainContent">
                                <webuijsf:staticText binding="#{NewReqEmpStep2.staticTextTitulo}" escape="false" id="staticTextTitulo" text="&lt;h2&gt;Criar Requisição: selecionar produtos&lt;/h2&gt;&#xa;"/>
                                <webuijsf:panelLayout binding="#{NewReqEmpStep2.layoutPanelSelecao}" id="layoutPanelSelecao" panelLayout="flow" style="width: 100%; height: 100%;">
                                    <webuijsf:dropDown binding="#{NewReqEmpStep2.dropDownProduto}" id="dropDownProduto" items="#{NewReqEmpStep2.produtos}" valueChangeListenerExpression="#{NewReqEmpStep2.dropDownProduto_processValueChange}"/>
                                    <webuijsf:textField binding="#{NewReqEmpStep2.textFieldQuantidade}" columns="5" id="textFieldQuantidade"/>
                                    <webuijsf:button actionExpression="#{NewReqEmpStep2.buttonAdicionar_action}" binding="#{NewReqEmpStep2.buttonAdicionar}"
                                        id="buttonAdicionar" text="Adicionar"/>
                                </webuijsf:panelLayout>
                                <webuijsf:panelLayout binding="#{NewReqEmpStep2.layoutPanelSpacer2}" id="layoutPanelSpacer2" panelLayout="flow" style="height: 20px; width: 100%"/>
                                <webuijsf:panelLayout binding="#{NewReqEmpStep2.layoutPanelListagem}" id="layoutPanelListagem" panelLayout="flow" style="width: 100%; height: 100%;">
                                    <webuijsf:table augmentTitle="false" binding="#{NewReqEmpStep2.tableProdutos}" id="tableProdutos" title="Table" width="0">
                                        <webuijsf:tableRowGroup binding="#{NewReqEmpStep2.tableRowGroup1}" id="tableRowGroup1" rows="10"
                                            sourceData="#{NewReqEmpStep2.dadosDaTabela}" sourceVar="currentRow">
                                            <webuijsf:tableColumn binding="#{NewReqEmpStep2.tableColumn4}" headerText="id" id="tableColumn4" sort="id" visible="false">
                                                <webuijsf:staticText binding="#{NewReqEmpStep2.staticText5}" id="staticText5" text="#{currentRow.value['id']}"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn binding="#{NewReqEmpStep2.tableColumn5}" headerText="produto" id="tableColumn5" sort="produto">
                                                <webuijsf:staticText binding="#{NewReqEmpStep2.staticText6}" id="staticText6" text="#{currentRow.value['produto']}"/>
                                            </webuijsf:tableColumn>
                                            <webuijsf:tableColumn binding="#{NewReqEmpStep2.tableColumn6}" headerText="quantidade" id="tableColumn6" sort="quantidade">
                                                <webuijsf:staticText binding="#{NewReqEmpStep2.staticText7}" id="staticText7" text="#{currentRow.value['quantidade']}"/>
                                            </webuijsf:tableColumn>
                                        </webuijsf:tableRowGroup>
                                    </webuijsf:table>
                                </webuijsf:panelLayout>
                                <webuijsf:panelLayout binding="#{NewReqEmpStep2.layoutPanelSpacer1}" id="layoutPanelSpacer1" panelLayout="flow" style="height: 20px; width: 100%"/>
                                <webuijsf:panelLayout binding="#{NewReqEmpStep2.layoutPanelBotoesSub}" id="layoutPanelBotoesSub" style="height: 30px; width: 100%">
                                    <webuijsf:button binding="#{NewReqEmpStep2.buttonLimpar}" id="buttonLimpar" reset="true" text="Limpar"/>
                                    <webuijsf:button binding="#{NewReqEmpStep2.buttonConcluir}" id="buttonConcluir"
                                        style="left: 300px; top: 0px; position: absolute" text="Concluir"/>
                                </webuijsf:panelLayout>
                                <webuijsf:panelLayout binding="#{NewReqEmpStep2.layoutPanelSpacer}" id="layoutPanelSpacer" panelLayout="flow" style="height: 20px; width: 100%"/>
                            </webuijsf:panelLayout>
                            <br class="clearfloat"/>
                            <webuijsf:panelLayout binding="#{NewReqEmpStep2.footerPanel}" id="footerPanel" panelLayout="flow" style="text-align: right" styleClass="footer">
                                <webuijsf:staticText binding="#{NewReqEmpStep2.txtFooter}" escape="false" id="txtFooter"
                                    style="color: olive; font-family: Arial,Helvetica,sans-serif; font-size: 12px; text-align: right" text="&#xa;&lt;br/&gt;ESTG Leiria&#xa;&lt;br/&gt;&#xa;&lt;br/&gt;"/>
                            </webuijsf:panelLayout>
                        </div>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
