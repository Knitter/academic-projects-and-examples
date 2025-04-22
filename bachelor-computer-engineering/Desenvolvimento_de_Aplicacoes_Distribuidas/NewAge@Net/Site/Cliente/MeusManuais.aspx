<%@ Page Language="C#" MasterPageFile="~/MasterPage.master" AutoEventWireup="true" CodeFile="MeusManuais.aspx.cs" Inherits="Cliente_MeuManuais" Title="New Age @ Net - Meus Manuais" %>
<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
    <table border="0" cellpadding="0" cellspacing="0" width="95%">
        <tr>
            <td style="font-weight: bold; width: 70%; color: white; font-family: Arial, Verdana;
                height: 14px; background-color: #5d7b9d; text-align: center">
                Manuais Disponíveis</td>
            <td align="right" style="width: 30%; height: 14px; background-color: #5d7b9d">
                <img src="../images/allblueheader.png" /></td>
        </tr>
    </table>
    <br />
    <asp:GridView ID="GridView1" runat="server" AllowPaging="True" AllowSorting="True"
        AutoGenerateColumns="False" CellPadding="4" DataSourceID="dsManuais" ForeColor="#333333"
        GridLines="None" Width="95%" OnRowCommand="GridView1_RowCommand" DataKeyNames="ID">
        <FooterStyle BackColor="#5D7B9D" Font-Bold="True" ForeColor="White" />
        <Columns>
            <asp:BoundField DataField="Codigo" HeaderText="C&#243;digo" SortExpression="Codigo" />
            <asp:BoundField DataField="Nome" HeaderText="Nome do Produto" SortExpression="Nome" />
            <asp:ButtonField CommandName="GetManual" DataTextField="Expr1" HeaderText="Manual" />
        </Columns>
        <RowStyle BackColor="#F7F6F3" ForeColor="#333333" />
        <EditRowStyle BackColor="#999999" />
        <SelectedRowStyle BackColor="#E2DED6" Font-Bold="True" ForeColor="#333333" />
        <PagerStyle BackColor="#284775" ForeColor="White" HorizontalAlign="Center" />
        <HeaderStyle BackColor="#5D7B9D" Font-Bold="True" ForeColor="White" HorizontalAlign="Left" />
        <AlternatingRowStyle BackColor="White" ForeColor="#284775" />
    </asp:GridView>
    <br />
    <asp:SqlDataSource ID="dsManuais" runat="server" ConnectionString="<%$ ConnectionStrings:ConnectionString %>"
        SelectCommand="SELECT Produto.Codigo, Produto.Nome, Manual.Nome AS Expr1, Manual.Tipo, Manual.tamanho, Manual.ID FROM Manual INNER JOIN Pertencer ON Manual.ID = Pertencer.IDManual INNER JOIN Produto ON Pertencer.IDProduto = Produto.ID INNER JOIN LinhaVenda ON Produto.ID = LinhaVenda.IDProduto INNER JOIN Venda ON LinhaVenda.IDVenda = Venda.ID WHERE (Venda.IDCliente = @IDCliente)" OnSelecting="dsManuais_Selecting">
        <SelectParameters>
            <asp:SessionParameter Name="IDCliente" SessionField="IDClienteAut" />
        </SelectParameters>
    </asp:SqlDataSource>
</asp:Content>

