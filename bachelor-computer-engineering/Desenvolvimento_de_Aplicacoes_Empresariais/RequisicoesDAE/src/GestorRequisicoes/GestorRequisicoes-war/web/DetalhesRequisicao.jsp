<?xml version="1.0" encoding="ISO-8859-1"?>
<!--
Document   : GerirAprovacoes
Created on : 12/Fev/2008, 15:07:48
Author     : ei10608
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="ISO-8859-1"/>
    <f:view>
        <webuijsf:page binding="#{DetalhesRequisicao.page1}" id="page1">
            <webuijsf:html binding="#{DetalhesRequisicao.html1}" id="html1">
                <webuijsf:head binding="#{DetalhesRequisicao.head1}" id="head1">
                    <webuijsf:link binding="#{DetalhesRequisicao.link1}" id="link1" url="/resources/stylesheet.css"/>
                    <webuijsf:link binding="#{DetalhesRequisicao.link2}" id="link2" url="/resources/layout6.css"/>
                </webuijsf:head>
                <webuijsf:body binding="#{DetalhesRequisicao.body1}" id="body1">
                    <br/>
                    <br/>
                    <webuijsf:form binding="#{DetalhesRequisicao.form1}" id="form1">
                        <div id="container">
                            <!-- This clearing element should immediately follow the #mainContent div in order to force the #container div to contain all child floats -->
                            <!-- end #container -->
                            <webuijsf:panelLayout binding="#{DetalhesRequisicao.headerPanel}" id="headerPanel" panelLayout="flow" styleClass="header">
                                <webuijsf:staticText binding="#{DetalhesRequisicao.staticText1}" escape="false" id="staticText1" text="&lt;h1&gt;Requisições&lt;/h1&gt;"/>
                                <webuijsf:staticText binding="#{DetalhesRequisicao.staticText16}" escape="false" id="staticText16" text="Aplicação de Requisições Online&#xa;&lt;br/&gt;&#xa;&lt;br/&gt;"/>
                            </webuijsf:panelLayout>
                            <webuijsf:panelLayout binding="#{DetalhesRequisicao.leftSidebarPanel}" id="leftSidebarPanel" panelLayout="flow" styleClass="leftSidebar">
                                <br/>
                                <webuijsf:hyperlink binding="#{DetalhesRequisicao.linkCriarRequisicao}" id="linkCriarRequisicao" text="Criar Requisição" url="/faces/index.jsp"/>
                                <br/>
                                <br/>
                                <webuijsf:hyperlink binding="#{DetalhesRequisicao.linkRascunhos}" id="linkRascunhos" text="Meus Rascunhos" url="/faces/Rascunhos.jsp"/>
                                <br/>
                                <br/>
                                <webuijsf:hyperlink binding="#{DetalhesRequisicao.linkMinhasRequisicoes}" id="linkMinhasRequisicoes" text="Minhas Requisições" url="/faces/MinhasRequisicoes.jsp"/>
                                <br/>
                                <br/>
                                <webuijsf:hyperlink binding="#{DetalhesRequisicao.linkNotificacoes}" id="linkNotificacoes" text="Notificações" url="/faces/Notificacoes.jsp"/>
                                <br/>
                                <br/>
                                <jsp:scriptlet>
                                    if (request.isUserInRole("Aprovador")) {
                                </jsp:scriptlet>
                                <webuijsf:hyperlink binding="#{DetalhesRequisicao.linkRequisicoesExistentes}" id="linkRequisicoesExistentes"
                                    text="Requisições Existentes" url="/faces/secureAprovador/RequisicoesExistentes.jsp"/>
                                <br/>
                                <br/>
                                <webuijsf:hyperlink binding="#{DetalhesRequisicao.linkNovas}" id="linkNovas" text="Requisições Pendentes" url="/faces/secureAprovador/RequisicoesPendentes.jsp"/>
                                <br/>
                                <br/>
                                <jsp:scriptlet>
                                    }else if (request.isUserInRole("Responsavel")) {
                                </jsp:scriptlet>
                                <webuijsf:hyperlink binding="#{DetalhesRequisicao.linkRequisicoesExistentesResponsavel}"
                                    id="linkRequisicoesExistentesResponsavel" text="Requisições Existentes" url="/faces/secureResponsavel/RequisicoesExistentes.jsp"/>
                                <br/>
                                <br/>
                                <webuijsf:hyperlink binding="#{DetalhesRequisicao.linkRequisicoesPendentes}" id="linkRequisicoesPendentes"
                                    text="Requisições Pendentes" url="/faces/secureResponsavel/RequisicoesPorServir.jsp"/>
                                <br/>
                                <br/>
                                <jsp:scriptlet>
                                    }
                                </jsp:scriptlet>
                                <webuijsf:hyperlink binding="#{DetalhesRequisicao.linkLogout}" id="linkLogout" text="Sair" url="/logout.jsp"/>
                                <br/>
                                <br/>
                            </webuijsf:panelLayout>
                            <webuijsf:panelLayout binding="#{DetalhesRequisicao.mainContentPanel}" id="mainContentPanel" panelLayout="flow" styleClass="mainContent">
                                <webuijsf:staticText binding="#{DetalhesRequisicao.staticText11}" escape="false" id="staticText11" text="&lt;h2&gt;Detalhes da Requisição&lt;/h2&gt;"/>
                                <webuijsf:label binding="#{DetalhesRequisicao.lblID}" id="lblID" text="ID:"/>
                                <webuijsf:staticText binding="#{DetalhesRequisicao.txtID}" id="txtID" text="#{SessionBean1.requisicaoActiva.id}"/>
                                <br/>
                                <br/>
                                <webuijsf:label binding="#{DetalhesRequisicao.lblRemetente}" id="lblRemetente" text="Remetente:"/>
                                <webuijsf:staticText binding="#{DetalhesRequisicao.txtRemetenteNome}" id="txtRemetenteNome" text="#{SessionBean1.requisicaoActiva.requerente.nome}"/>
                                <webuijsf:staticText binding="#{DetalhesRequisicao.txtRemetenteApelido}" id="txtRemetenteApelido" text="#{SessionBean1.requisicaoActiva.requerente.apelido}"/>
                                <br/>
                                <br/>
                                <webuijsf:label binding="#{DetalhesRequisicao.lblAssunto}" id="lblAssunto" text="Assunto:"/>
                                <webuijsf:staticText binding="#{DetalhesRequisicao.txtAssunto}" id="txtAssunto" text="#{SessionBean1.requisicaoActiva.assunto}"/>
                                <br/>
                                <br/>
                                <webuijsf:label binding="#{DetalhesRequisicao.lblDestino}" id="lblDestino" text="Destino:"/>
                                <webuijsf:staticText binding="#{DetalhesRequisicao.txtDestino}" id="txtDestino" text="#{SessionBean1.requisicaoActiva.destino}"/>
                                <br/>
                                <br/>
                                <webuijsf:label binding="#{DetalhesRequisicao.lblDataDesejavel}" id="lblDataDesejavel" text="Data desejável de satisfação:"/>
                                <webuijsf:staticText binding="#{DetalhesRequisicao.txtDataDesejavel}" id="txtDataDesejavel" text="#{SessionBean1.requisicaoActiva.dataConclusao}"/>
                                <br/>
                                <br/>
                                <webuijsf:label binding="#{DetalhesRequisicao.lblDataSubmissao}" id="lblDataSubmissao" text="Data de submissão:"/>
                                <webuijsf:staticText binding="#{DetalhesRequisicao.txtDataSubmissao}" id="txtDataSubmissao" text="#{SessionBean1.requisicaoActiva.dataConclusao}"/>
                                <br/>
                                <br/>
                                <webuijsf:label binding="#{DetalhesRequisicao.lblAutorUltimaAlt}" id="lblAutorUltimaAlt" text="Autor da última alteração:"/>
                                <webuijsf:staticText binding="#{DetalhesRequisicao.txtAutorUltimaAltNome}" id="txtAutorUltimaAltNome" text="#{SessionBean1.requisicaoActiva.ultimoAlterador.nome}"/>
                                <webuijsf:staticText binding="#{DetalhesRequisicao.txtAutorUltimaAltApelido}" id="txtAutorUltimaAltApelido" text="#{SessionBean1.requisicaoActiva.ultimoAlterador.apelido}"/>
                                <br/>
                                <br/>
                                <webuijsf:label binding="#{DetalhesRequisicao.lblDataUltimaAlt}" id="lblDataUltimaAlt" text="Data da última alteração:"/>
                                <webuijsf:staticText binding="#{DetalhesRequisicao.txtDataUltimaAlt}" id="txtDataUltimaAlt" text="#{SessionBean1.requisicaoActiva.ultimaAlteracao}"/>
                                <br/>
                                <br/>
                                <webuijsf:label binding="#{DetalhesRequisicao.lblEstadoActual}" id="lblEstadoActual" text="Estado Actual:"/>
                                <webuijsf:staticText binding="#{DetalhesRequisicao.txtEstadoActual}" id="txtEstadoActual" text="#{SessionBean1.requisicaoActiva.estado}"/>
                                <br/>
                                <br/>
                                <webuijsf:table augmentTitle="false" binding="#{DetalhesRequisicao.tableProdutos}" id="tableProdutos" title="Produtos" width="422">
                                    <webuijsf:tableRowGroup binding="#{DetalhesRequisicao.tableRowGroup2}" id="tableRowGroup2" rows="10"
                                        sourceData="#{DetalhesRequisicao.linhasRequisicao}" sourceVar="currentRow">
                                        <webuijsf:tableColumn binding="#{DetalhesRequisicao.tableColumn1}" headerText="id" id="tableColumn1" sort="id" visible="false">
                                            <webuijsf:staticText binding="#{DetalhesRequisicao.staticText6}" id="staticText6" text="#{currentRow.value['id']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn binding="#{DetalhesRequisicao.tableColumn2}" headerText="Produto" id="tableColumn2" sort="produto" width="235">
                                            <webuijsf:staticText binding="#{DetalhesRequisicao.staticText7}" id="staticText7" text="#{currentRow.value['produto']}"/>
                                        </webuijsf:tableColumn>
                                        <webuijsf:tableColumn binding="#{DetalhesRequisicao.tableColumn3}" headerText="Quantidade pedida" id="tableColumn3" sort="quantidade">
                                            <webuijsf:staticText binding="#{DetalhesRequisicao.staticText12}" id="staticText12" text="#{currentRow.value['quantidade']}"/>
                                        </webuijsf:tableColumn>
                                    </webuijsf:tableRowGroup>
                                </webuijsf:table>
                                <br/>
                                <br/>
                            </webuijsf:panelLayout>
                            <br class="clearfloat"/>
                            <webuijsf:panelLayout binding="#{DetalhesRequisicao.footerPanel}" id="footerPanel" panelLayout="flow" style="text-align: right" styleClass="footer">
                                <webuijsf:staticText binding="#{DetalhesRequisicao.txtFooter}" escape="false" id="txtFooter"
                                    style="color: olive; font-family: Arial,Helvetica,sans-serif; font-size: 12px; text-align: right" text="&#xa;&lt;br/&gt;ESTG Leiria&#xa;&lt;br/&gt;&#xa;&lt;br/&gt;"/>
                            </webuijsf:panelLayout>
                        </div>
                    </webuijsf:form>
                </webuijsf:body>
            </webuijsf:html>
        </webuijsf:page>
    </f:view>
</jsp:root>
