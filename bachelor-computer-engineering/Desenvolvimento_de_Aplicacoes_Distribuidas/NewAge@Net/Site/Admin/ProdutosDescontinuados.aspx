<%@ Page Language="C#" MasterPageFile="~/MasterPage.master" AutoEventWireup="true" CodeFile="ProdutosDescontinuados.aspx.cs" Inherits="Admin_ProdutosDescontinuados" Title="s" %>
<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
    <table border="0" cellpadding="0" cellspacing="0" width="95%">
        <tr>
            <td style="font-weight: bold; width: 70%; color: white; font-family: Arial, Verdana;
                height: 14px; background-color: #5d7b9d; text-align: center">
                Lista de Produtos Descontinuados</td>
            <td align="right" style="width: 30%; height: 14px; background-color: #5d7b9d">
                <img src="../images/allblueheader.png" /></td>
        </tr>
    </table>
    <br />
    <asp:GridView ID="GridView1" runat="server" AllowPaging="True" AllowSorting="True"
        CellPadding="4" DataKeyNames="ID" DataSourceID="dsProdutos" ForeColor="#333333"
        GridLines="None" PageSize="20" Width="95%" AutoGenerateColumns="False">
        <FooterStyle BackColor="#5D7B9D" Font-Bold="True" ForeColor="White" />
        <Columns>
            <asp:BoundField DataField="Codigo" HeaderText="Codigo" SortExpression="Codigo" />
            <asp:BoundField DataField="Nome" HeaderText="Nome" SortExpression="Nome" />
            <asp:BoundField DataField="Descricao" HeaderText="Descricao" SortExpression="Descricao" />
            <asp:BoundField DataField="ImagemURL" HeaderText="ImagemURL" SortExpression="ImagemURL" />
            <asp:BoundField DataField="Preco" HeaderText="Preco" SortExpression="Preco" />
            <asp:BoundField DataField="StockMinimo" HeaderText="StockMinimo" SortExpression="StockMinimo" />
            <asp:BoundField DataField="Stock" HeaderText="Stock" SortExpression="Stock" />
            <asp:CheckBoxField DataField="Activo" HeaderText="Activo" SortExpression="Activo" />
            <asp:CommandField ShowEditButton="True" />
        </Columns>
        <RowStyle BackColor="#F7F6F3" ForeColor="#333333" />
        <EditRowStyle BackColor="#999999" />
        <SelectedRowStyle BackColor="#E2DED6" Font-Bold="True" ForeColor="#333333" />
        <PagerStyle BackColor="#284775" ForeColor="White" HorizontalAlign="Center" />
        <HeaderStyle BackColor="#5D7B9D" Font-Bold="True" ForeColor="White" />
        <AlternatingRowStyle BackColor="White" ForeColor="#284775" />
    </asp:GridView>
    <asp:SqlDataSource ID="dsProdutos" runat="server" ConnectionString="<%$ ConnectionStrings:ConnectionString %>"
        SelectCommand="SELECT [ID], [Nome], [Codigo], [Preco], [Stock], [StockMinimo], [Descricao], [Activo], [ImagemURL] FROM [Produto] WHERE ([Activo] = 0)"
        UpdateCommand="UPDATE [Produto] SET [Nome] = @Nome, [Codigo] = @Codigo, [Preco] = @Preco, [Stock] = @Stock, [StockMinimo] = @StockMinimo, [Descricao] = @Descricao, [Activo] = @Activo, [ImagemURL] = @ImagemURL WHERE [ID] = @ID">
        <UpdateParameters>
            <asp:Parameter Name="Nome" Type="String" />
            <asp:Parameter Name="Codigo" Type="String" />
            <asp:Parameter Name="Preco" Type="Decimal" />
            <asp:Parameter Name="Stock" Type="Int32" />
            <asp:Parameter Name="StockMinimo" Type="Int32" />
            <asp:Parameter Name="Descricao" Type="String" />
            <asp:Parameter Name="Activo" Type="Boolean" />
            <asp:Parameter Name="ImagemURL" Type="String" />
            <asp:Parameter Name="ID" Type="Int32" />
        </UpdateParameters>
    </asp:SqlDataSource>
</asp:Content>

