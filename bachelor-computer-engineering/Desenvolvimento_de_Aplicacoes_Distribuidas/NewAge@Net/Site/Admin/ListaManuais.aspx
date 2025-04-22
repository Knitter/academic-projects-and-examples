<%@ Page Language="C#" MasterPageFile="~/MasterPage.master" AutoEventWireup="true" CodeFile="ListaManuais.aspx.cs" Inherits="Admin_ListaManuais" Title="NewAge@Net - Lista de Manuais" %>
<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
    <table border="0" cellpadding="0" cellspacing="0" width="95%">
        <tr>
            <td style="font-weight: bold; width: 70%; color: white; font-family: Arial, Verdana;
                height: 14px; background-color: #5d7b9d; text-align: center">
                Lista de Manuais</td>
            <td align="right" style="width: 30%; height: 14px; background-color: #5d7b9d">
                <img src="../images/allblueheader.png" /></td>
        </tr>
    </table>
    <br />
    <asp:GridView ID="GridView1" runat="server" AllowPaging="True" AllowSorting="True"
        AutoGenerateColumns="False" CellPadding="4" DataSourceID="dsManuais" ForeColor="#333333"
        GridLines="None" Width="95%" DataKeyNames="IDManual" OnRowCommand="GridView1_RowCommand">
        <FooterStyle BackColor="#5D7B9D" Font-Bold="True" ForeColor="White" />
        <RowStyle BackColor="#F7F6F3" ForeColor="#333333" />
        <EditRowStyle BackColor="#999999" />
        <SelectedRowStyle BackColor="#E2DED6" Font-Bold="True" ForeColor="#333333" />
        <PagerStyle BackColor="#284775" ForeColor="White" HorizontalAlign="Center" />
        <HeaderStyle BackColor="#5D7B9D" Font-Bold="True" ForeColor="White" HorizontalAlign="Left" />
        <AlternatingRowStyle BackColor="White" ForeColor="#284775" />
        <Columns>
            <asp:BoundField DataField="Codigo" HeaderText="C&#243;digo" SortExpression="Codigo" />
            <asp:BoundField DataField="Nome" HeaderText="Produto" SortExpression="Nome" />
            <asp:BoundField DataField="IDManual" HeaderText="ID do Manual" InsertVisible="False"
                SortExpression="IDManual" />
            <asp:ButtonField CommandName="Download" DataTextField="NomeManual" HeaderText="Manual" />
            <asp:ButtonField ButtonType="Image" CommandName="Remover" ImageUrl="~/images/cancel.png"
                Text="Remover" />
        </Columns>
    </asp:GridView>
    <asp:SqlDataSource ID="dsManuais" runat="server" ConnectionString="<%$ ConnectionStrings:ConnectionString %>"
        SelectCommand="SELECT Produto.ID, Produto.Nome, Produto.Codigo, Manual.ID AS IDManual, Manual.Nome AS NomeManual FROM Pertencer INNER JOIN Produto ON Pertencer.IDProduto = Produto.ID INNER JOIN Manual ON Pertencer.IDManual = Manual.ID">
    </asp:SqlDataSource>
</asp:Content>

