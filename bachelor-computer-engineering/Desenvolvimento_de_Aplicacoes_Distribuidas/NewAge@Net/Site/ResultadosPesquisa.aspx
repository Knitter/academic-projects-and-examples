<%@ Page Language="C#" MasterPageFile="~/MasterPage.master" AutoEventWireup="true" CodeFile="ResultadosPesquisa.aspx.cs" Inherits="index" Title="New Age @ Net - Resultados da Pesquisa" %>

<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
    <table border="0" cellpadding="0" cellspacing="0" width="95%">
        <tr>
            <td style="font-weight: bold; width: 70%; color: white; font-family: Arial, Verdana;
                height: 14px; background-color: #5d7b9d; text-align: center">
    <asp:Label ID="lblTituloPesquisa" runat="server" Font-Names="verdana,arial,sans serif" Font-Size="14px" CssClass="content-title" Font-Bold="True" ForeColor="White"></asp:Label></td>
            <td align="right" style="width: 30%; height: 14px; background-color: #5d7b9d">
                <img src="images/allblueheader.png" /></td>
        </tr>
    </table>
    &nbsp;&nbsp;
    <br />
    <asp:GridView ID="gridProdutos" runat="server" AutoGenerateColumns="False"
        DataSourceID="dsResultadosPesquisa" GridLines="None" AllowPaging="True" AllowSorting="True" PageSize="20" CssClass="produtos" DataKeyNames="IDProduto" OnRowCommand="gridProdutos_RowCommand" Width="95%">
        <Columns>
            <asp:HyperLinkField DataTextField="ImagemURL" DataTextFormatString="&lt;img class=&quot;produtos&quot; src=&quot;images/produtos/{0:c}&quot;&gt;" DataNavigateUrlFields="IDProduto" DataNavigateUrlFormatString="~/DetalhesProduto.aspx?id={0}">
                <ItemStyle CssClass="produtos-left" />
            </asp:HyperLinkField>
            <asp:HyperLinkField DataTextField="Nome" DataNavigateUrlFields="IDProduto" DataNavigateUrlFormatString="~/DetalhesProduto.aspx?id={0}">
                <ControlStyle CssClass="produtos-nome" />
                <ItemStyle CssClass="produtos-nome" />
            </asp:HyperLinkField>
            <asp:BoundField DataField="Codigo" SortExpression="Codigo" DataFormatString="&lt;p class=&quot;produto-codigo&quot;&gt;C&#243;digo&lt;/p&gt; {0:c}" >
                <ControlStyle CssClass="produtos" />
                <ItemStyle CssClass="produtos-codigo" Width="30px" />
                <HeaderStyle CssClass="produtos" />
                <FooterStyle CssClass="produtos" />
            </asp:BoundField>
            <asp:BoundField DataField="Preco" SortExpression="Preco" DataFormatString="&lt;p class=&quot;produto-preco&quot;&gt;Pre&#231;o&lt;/p&gt; {0:F2}€" HtmlEncode="False" >
                <ControlStyle CssClass="produtos" />
                <ItemStyle CssClass="produtos-preco" Width="30px" />
                <HeaderStyle CssClass="produtos" />
                <FooterStyle CssClass="produtos" />
            </asp:BoundField>
            <asp:ButtonField ButtonType="Image" ImageUrl="~/images/button_in_cart.gif" Text="Adicionar ao Carrinho" CommandName="AddToCart">
                <FooterStyle VerticalAlign="Middle" />
                <ControlStyle CssClass="produtos-carrinho" />
                <ItemStyle CssClass="produtos-carrinho" />
            </asp:ButtonField>
            <asp:ButtonField ButtonType="Image" CommandName="EditProduto" ImageUrl="~/images/edit.jpg"
                Text="Button">
                <ItemStyle CssClass="produtos-administrador" Width="15px" />
            </asp:ButtonField>
            <asp:ButtonField ButtonType="Image" CommandName="Delete" ImageUrl="~/images/cancel.png"
                Text="Button">
                <ItemStyle CssClass="produtos-administrador" Width="20px" />
            </asp:ButtonField>
        </Columns>
        <RowStyle CssClass="produtos" />
    </asp:GridView>
    <asp:SqlDataSource ID="dsResultadosPesquisa" runat="server" ConnectionString="<%$ ConnectionStrings:ConnectionString %>"
        SelectCommand="SELECT Produto.ID AS IDProduto, Produto.Nome, Produto.Codigo, Produto.Preco, ImagemURL, Produto.Stock FROM Produto WHERE (CHARINDEX(@Nome, Produto.Nome) <> 0) AND (Produto.Activo = @Activo)">
        <SelectParameters>
            <asp:QueryStringParameter DefaultValue="" Name="Nome" QueryStringField="nome" />
            <asp:Parameter DefaultValue="TRUE" Name="Activo" Type="Boolean" />
        </SelectParameters>
    </asp:SqlDataSource>
</asp:Content>

