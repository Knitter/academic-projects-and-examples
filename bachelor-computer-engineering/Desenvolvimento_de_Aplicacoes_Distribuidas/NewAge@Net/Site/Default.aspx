<%@ Page Language="C#" MasterPageFile="~/MasterPage.master" AutoEventWireup="true" CodeFile="Default.aspx.cs" Inherits="index" Title="New Age @ Net" %>

<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
    <asp:Panel ID="painelTitulo" runat="server" Height="1px" Width="95%">
    <table border="0" cellpadding="0" cellspacing="0" width="100%" id="tabelaTitulo">
        <tr>
            <td style="font-weight: bold; width: 70%; color: white; font-family: Arial, Verdana;
                height: 14px; background-color: #5d7b9d; text-align: center">
    <asp:Label ID="lblCategoria" runat="server" Font-Names="verdana,arial,sans serif" Font-Size="14px" CssClass="content-title"></asp:Label></td>
            <td align="right" style="width: 30%; height: 14px; background-color: #5d7b9d">
                <img src="images/allblueheader.png" /></td>
        </tr>
    </table>
    </asp:Panel>
    &nbsp;&nbsp;
    <asp:GridView ID="gridProdutos" runat="server" AutoGenerateColumns="False"
        DataSourceID="dsProdutos" GridLines="None" AllowPaging="True" AllowSorting="True" PageSize="5" CssClass="produtos" DataKeyNames="ID" OnRowCommand="gridProdutos_RowCommand" Width="95%">
        <Columns>
            <asp:HyperLinkField DataTextField="ImagemURL" DataTextFormatString="&lt;img class=&quot;produtos&quot; src=&quot;images/produtos/{0:c}&quot;&gt;" DataNavigateUrlFields="ID" DataNavigateUrlFormatString="~/DetalhesProduto.aspx?id={0}">
                <ItemStyle CssClass="produtos-left" />
            </asp:HyperLinkField>
            <asp:HyperLinkField DataTextField="Nome" DataNavigateUrlFields="ID" DataNavigateUrlFormatString="~/DetalhesProduto.aspx?id={0}">
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
                <ItemStyle CssClass="produtos-carrinho" Width="40px" />
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
    <asp:SqlDataSource ID="dsProdutos" runat="server" ConnectionString="<%$ ConnectionStrings:ConnectionString %>"
        SelectCommand="SELECT [ID], [Nome], [Codigo], [Preco], [Stock], [ImagemURL], [IDCategoria], [Descricao], [StockMinimo] FROM [Produto] WHERE (([IDCategoria] = @IDCategoria) AND ([Activo] = @Activo))" DeleteCommand="DELETE FROM [Produto] WHERE [ID] = @ID" InsertCommand="INSERT INTO [Produto] ([Nome], [Codigo], [Preco], [Stock], [ImagemURL], [IDCategoria], [Descricao], [StockMinimo]) VALUES (@Nome, @Codigo, @Preco, @Stock, @ImagemURL, @IDCategoria, @Descricao, @StockMinimo)" UpdateCommand="UPDATE [Produto] SET [Nome] = @Nome, [Codigo] = @Codigo, [Preco] = @Preco, [Stock] = @Stock, [ImagemURL] = @ImagemURL, [IDCategoria] = @IDCategoria, [Descricao] = @Descricao, [StockMinimo] = @StockMinimo WHERE [ID] = @ID">
        <SelectParameters>
            <asp:QueryStringParameter Name="IDCategoria" QueryStringField="id" Type="Int32" />
            <asp:Parameter DefaultValue="true" Name="Activo" Type="Boolean" />
        </SelectParameters>
        <DeleteParameters>
            <asp:Parameter Name="ID" Type="Int32" />
        </DeleteParameters>
        <UpdateParameters>
            <asp:Parameter Name="Nome" Type="String" />
            <asp:Parameter Name="Codigo" Type="String" />
            <asp:Parameter Name="Preco" Type="Decimal" />
            <asp:Parameter Name="Stock" Type="Int32" />
            <asp:Parameter Name="ImagemURL" Type="String" />
            <asp:Parameter Name="IDCategoria" Type="Int32" />
            <asp:Parameter Name="Descricao" Type="String" />
            <asp:Parameter Name="StockMinimo" Type="Int32" />
            <asp:Parameter Name="ID" Type="Int32" />
        </UpdateParameters>
        <InsertParameters>
            <asp:Parameter Name="Nome" Type="String" />
            <asp:Parameter Name="Codigo" Type="String" />
            <asp:Parameter Name="Preco" Type="Decimal" />
            <asp:Parameter Name="Stock" Type="Int32" />
            <asp:Parameter Name="ImagemURL" Type="String" />
            <asp:Parameter Name="IDCategoria" Type="Int32" />
            <asp:Parameter Name="Descricao" Type="String" />
            <asp:Parameter Name="StockMinimo" Type="Int32" />
        </InsertParameters>
    </asp:SqlDataSource>
</asp:Content>

