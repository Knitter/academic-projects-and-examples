<?xml version="1.0" encoding="ISO-8859-1"?>
<!--
Document   : GerirAprovacoes
Created on : 12/Fev/2008, 15:07:48
Author     : ei10608
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="ISO-8859-1"/>
    <f:view>
        <webuijsf:page binding="#{AlterarRequisicao.page1}" id="page1">
            <webuijsf:html binding="#{AlterarRequisicao.html1}" id="html1">
                <webuijsf:head binding="#{AlterarRequisicao.head1}" id="head1">
                    <webuijsf:link binding="#{AlterarRequisicao.link1}" id="link1" url="/resources/stylesheet.css"/>
                    <webuijsf:link binding="#{AlterarRequisicao.link2}" id="link2" url="/resources/layout6.css"/>
                </webuijsf:head>
                <webuijsf:body binding="#{AlterarRequisicao.body1}" id="body1">
                    <br/>
                    <br/>
                    <webuijsf:form binding="#{AlterarRequisicao.form1}" id="form1">
                        <div id="container">
                            <!-- This clearing element should immediately follow the #mainContent div in order to force the #container div to contain all child floats -->
                            <!-- end #container -->
                            <webuijsf:panelLayout binding="#{AlterarRequisicao.headerPanel}" id="headerPanel" panelLayout="flow" styleClass="header">
                                <webuijsf:staticText binding="#{AlterarRequisicao.staticText1}" escape="false" id="staticText1" text="&lt;h1&gt;Requisições&lt;/h1&gt;"/>
                                <webuijsf:staticText binding="#{AlterarRequisicao.staticText16}" escape="false" id="staticText16" text="Aplicação de Requisições Online&#xa;&lt;br/&gt;&#xa;&lt;br/&gt;"/>
                            </webuijsf:panelLayout>
                            <webuijsf:panelLayout binding="#{AlterarRequisicao.leftSidebarPanel}" id="leftSidebarPanel" panelLayout="flow" styleClass="leftSidebar">
                                <br/>
                                <webuijsf:hyperlink actionExpression="#{AlterarRequisicao.linkCriarRequisicao_action}"
                                    binding="#{AlterarRequisicao.linkCriarRequisicao}" id="linkCriarRequisicao" text="Criar Requisição" url="/faces/index.jsp"/>
                                <br/>
                                <br/>
                                <webuijsf:hyperlink actionExpression="#{AlterarRequisicao.linkRascunhos_action}" binding="#{AlterarRequisicao.linkRascunhos}"
                                    id="linkRascunhos" text="Meus Rascunhos" url="/faces/Rascunhos.jsp"/>
                                <br/>
                                <br/>
                                <webuijsf:hyperlink actionExpression="#{AlterarRequisicao.linkMinhasRequisicoes_action}"
                                    binding="#{AlterarRequisicao.linkMinhasRequisicoes}" id="linkMinhasRequisicoes" text="Minhas Requisições" url="/faces/MinhasRequisicoes.jsp"/>
                                <br/>
                                <br/>
                                <webuijsf:hyperlink binding="#{AlterarRequisicao.linkNotificacoes}" id="linkNotificacoes" text="Notificações" url="/faces/Notificacoes.jsp"/>
                                <br/>
                                <br/>
                                <webuijsf:hyperlink actionExpression="#{AlterarRequisicao.linkRequisicoesExistentes_action}"
                                    binding="#{AlterarRequisicao.linkRequisicoesExistentes}" id="linkRequisicoesExistentes" text="Requisições Existentes" url="/faces/secureAprovador/RequisicoesExistentes.jsp"/>
                                <br/>
                                <br/>
                                <webuijsf:hyperlink actionExpression="#{AlterarRequisicao.linkNovas_action}" binding="#{AlterarRequisicao.linkNovas}"
                                    id="linkNovas" text="Requisições Pendentes" url="/faces/secureAprovador/RequisicoesPendentes.jsp"/>
                                <br/>
                                <br/>
                                <webuijsf:hyperlink actionExpression="#{AlterarRequisicao.linkLogout_action}" binding="#{AlterarRequisicao.linkLogout}"
                                    id="linkLogout" text="Sair" url="/logout.jsp"/>
                            </webuijsf:panelLayout>
                            <webuijsf:panelLayout binding="#{AlterarRequisicao.mainContentPanel}" id="mainContentPanel" panelLayout="flow" styleClass="mainContent">
                                <webuijsf:staticText binding="#{AlterarRequisicao.staticText11}" escape="false" id="staticText11" text="&lt;h2&gt;Alterar Requisição&lt;/h2&gt;"/>
                                <webuijsf:label binding="#{AlterarRequisicao.lblID}" id="lblID" text="ID:"/>
                                <webuijsf:staticText binding="#{AlterarRequisicao.txtID}" id="txtID" text="#{SessionBean1.requisicaoActiva.id}"/>
                                <br/>
                                <br/>
                                <webuijsf:dropDown binding="#{AlterarRequisicao.listRemetentes}" id="listRemetentes" items="#{AlterarRequisicao.colaboradores}"
                                    label="Remetente:" valueChangeListenerExpression="#{AlterarRequisicao.listRemetentes_processValueChange}"/>
                                <br/>
                                <br/>
                                <webuijsf:textField binding="#{AlterarRequisicao.txtAssunto}" id="txtAssunto" label="Assunto:" text="#{SessionBean1.requisicaoActiva.assunto}"/>
                                <br/>
                                <br/>
                                <webuijsf:label binding="#{AlterarRequisicao.lblDestino}" id="lblDestino" text="Destino:"/>
                                <webuijsf:staticText binding="#{AlterarRequisicao.txtDestino}" id="txtDestino" text="#{SessionBean1.requisicaoActiva.destino}"/>
                                <br/>
                                <br/>
                                <webuijsf:label binding="#{AlterarRequisicao.lblDataDesejavel}" id="lblDataDesejavel" text="Data desejável de satisfação:"/>
                                <webuijsf:staticText binding="#{AlterarRequisicao.txtDataDesejavel}" id="txtDataDesejavel" text="#{SessionBean1.requisicaoActiva.dataConclusao}"/>
                                <br/>
                                <br/>
                                <webuijsf:label binding="#{AlterarRequisicao.lblDataSubmissao}" id="lblDataSubmissao" text="Data de submissão:"/>
                                <webuijsf:staticText binding="#{AlterarRequisicao.txtDataSubmissao}" id="txtDataSubmissao" text="#{SessionBean1.requisicaoActiva.dataConclusao}"/>
                                <br/>
                                <br/>
                                <webuijsf:label binding="#{AlterarRequisicao.lblAutorUltimaAlt}" id="lblAutorUltimaAlt" text="Autor da última alteração:"/>
                                <webuijsf:staticText binding="#{AlterarRequisicao.txtAutorUltimaAltNome}" id="txtAutorUltimaAltNome" text="#{SessionBean1.requisicaoActiva.ultimoAlterador.nome}"/>
                                <webuijsf:staticText binding="#{AlterarRequisicao.txtAutorUltimaAltApelido}" id="txtAutorUltimaAltApelido" text="#{SessionBean1.requisicaoActiva.ultimoAlterador.apelido}"/>
                                <br/>
                                <br/>
                                <webuijsf:label binding="#{AlterarRequisicao.lblDataUltimaAlt}" id="lblDataUltimaAlt" text="Data da última alteração:"/>
                                <webuijsf:staticText binding="#{AlterarRequisicao.txtDataUltimaAlt}" id="txtDataUltimaAlt" text="#{SessionBean1.requisicaoActiva.ultimaAlteracao}"/>
                                <br/>
                                <br/>
                                <webuijsf:label binding="#{AlterarRequisicao.lblEstadoActual}" id="lblEstadoActual" text="Estado Actual:"/>
                                <webuijsf:staticText binding="#{AlterarRequisicao.txtEstadoActual}" id="txtEstadoActual" text="#{SessionBean1.requisicaoActiva.estado}"/>
                                <br/>
                                <br/>
                                <webuijsf:table augmentTitle="false" binding="#{AlterarRequisicao.tableProdutos}" id="tableProdutos" title="Produtos" width="0">
                                    <webuijsf:tableRowGroup binding="#{AlterarRequisicao.tableRowGroup2}" id="tableRowGroup2" rows="10"
                                        sourceData="#{SessionBean1.produtosRequisicaoActiva}" sourceVar="currentRow">
                                        <webuijsf:tableColumn binding="#{AlterarRequisicao.tableColumn4}" headerText="produto" id="tableColumn4" sort="produto">
                                            <webuijsf:staticText binding="#{AlterarRequisicao.staticText2}" id="staticText2" text="#{currentRow.value['produto']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn binding="#{AlterarRequisicao.tableColumn5}" headerText="quantidade" id="tableColumn5" sort="quantidade">
                                            <webuijsf:staticText binding="#{AlterarRequisicao.staticText3}" id="staticText3" text="#{currentRow.value['quantidade']}"/>
                                        </webuijsf:tableColumn>
                                    </webuijsf:tableRowGroup>
                                </webuijsf:table>
                                <br/>
                                <br/>
                                <webuijsf:button actionExpression="#{AlterarRequisicao.btnCancel_action}" binding="#{AlterarRequisicao.btnCancel}"
                                    id="btnCancel" text="Cancelar"/>
                                <webuijsf:button actionExpression="#{AlterarRequisicao.btnGuardar_action}" binding="#{AlterarRequisicao.btnGuardar}"
                                    id="btnGuardar" text="Guardar"/>
                                <br/>
                                <br/>
                            </webuijsf:panelLayout>
                            <br class="clearfloat"/>
                            <webuijsf:panelLayout binding="#{AlterarRequisicao.footerPanel}" id="footerPanel" panelLayout="flow" style="text-align: right" styleClass="footer">
                                <webuijsf:staticText binding="#{AlterarRequisicao.txtFooter}" escape="false" id="txtFooter"
                                    style="color: olive; font-family: Arial,Helvetica,sans-serif; font-size: 12px; text-align: right" text="&#xa;&lt;br/&gt;ESTG Leiria&#xa;&lt;br/&gt;&#xa;&lt;br/&gt;"/>
                            </webuijsf:panelLayout>
                        </div>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
