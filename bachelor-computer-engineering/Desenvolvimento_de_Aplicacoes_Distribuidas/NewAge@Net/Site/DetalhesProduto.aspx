<%@ Page Language="C#" MasterPageFile="~/MasterPage.master" AutoEventWireup="true" CodeFile="DetalhesProduto.aspx.cs" Inherits="detalhesProduto" Title="NewAge@Net - Detalhes do Produto" %>
<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
    <table border="0" cellpadding="0" cellspacing="0" width="95%">
        <tr>
            <td style="font-weight: bold; width: 70%; color: white; font-family: Arial, Verdana;
                height: 14px; background-color: #5d7b9d; text-align: center">
                Detalhes do Produto</td>
            <td align="right" style="width: 30%; height: 14px; background-color: #5d7b9d">
                <img src="images/allblueheader.png" /></td>
        </tr>
    </table>
    &nbsp;<asp:DetailsView ID="tblDetalhes" runat="server" AutoGenerateRows="False" CellPadding="4"
        CssClass="detalhes" DataSourceID="dsDetalhes" ForeColor="#333333" GridLines="None"
        Height="50px" OnItemCommand="tblDetalhes_ItemCommand" Width="95%">
        <FooterStyle BackColor="#5D7B9D" Font-Bold="True" ForeColor="White" />
        <CommandRowStyle BackColor="#E2DED6" Font-Bold="True" />
        <EditRowStyle BackColor="#999999" />
        <RowStyle BackColor="#F7F6F3" CssClass="detalhes" ForeColor="#333333" />
        <PagerStyle BackColor="#284775" ForeColor="White" HorizontalAlign="Center" />
        <Fields>
            <asp:BoundField DataField="Nome" HeaderText="Nome" SortExpression="Nome" />
            <asp:BoundField DataField="Descricao" SortExpression="Descricao">
                <ControlStyle CssClass="detalhes" />
                <ItemStyle CssClass="descricao" />
                <HeaderStyle CssClass="detalhes" />
            </asp:BoundField>
            <asp:BoundField DataField="Codigo" HeaderText="C&#243;digo" SortExpression="Codigo" />
            <asp:BoundField DataField="Preco" HeaderText="Pre&#231;o" SortExpression="Preco" />
            <asp:BoundField DataField="Stock" HeaderText="Stock" SortExpression="Stock" />
            <asp:ButtonField Text="Adicionar ao Carrinho" CommandName="AddToCart">
                <ItemStyle HorizontalAlign="Center" />
            </asp:ButtonField>
        </Fields>
        <FieldHeaderStyle BackColor="#E9ECF1" Font-Bold="True" />
        <HeaderStyle BackColor="#5D7B9D" Font-Bold="True" ForeColor="White" />
        <AlternatingRowStyle BackColor="White" ForeColor="#284775" />
    </asp:DetailsView>
    <asp:SqlDataSource ID="dsDetalhes" runat="server" ConnectionString="<%$ ConnectionStrings:ConnectionString %>"
        SelectCommand="SELECT ImagemURL, Produto.Nome, Produto.Codigo, Produto.Preco, Produto.Stock, Produto.Descricao FROM Produto WHERE (Produto.Activo = @Activo) AND (Produto.ID = @ID)">
        <SelectParameters>
            <asp:Parameter DefaultValue="True" Name="Activo" Type="Boolean" />
            <asp:QueryStringParameter Name="ID" QueryStringField="id" Type="Int32" />
        </SelectParameters>
    </asp:SqlDataSource>
</asp:Content>

