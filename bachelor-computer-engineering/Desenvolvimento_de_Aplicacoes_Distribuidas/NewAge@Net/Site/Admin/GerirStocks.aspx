<%@ Page Language="C#" MasterPageFile="~/MasterPage.master" AutoEventWireup="true" CodeFile="GerirStocks.aspx.cs" Inherits="Admin_GerirStocks" Title="NewAge@Net - Gestão de Stocks" %>
<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
    <table border="0" cellpadding="0" cellspacing="0" width="95%">
        <tr>
            <td style="font-weight: bold; width: 70%; color: white; font-family: Arial, Verdana;
                height: 14px; background-color: #5d7b9d; text-align: center">
                Gestão de Stocks</td>
            <td align="right" style="width: 30%; height: 14px; background-color: #5d7b9d">
                <img src="../images/allblueheader.png" /></td>
        </tr>
    </table>
    <br />
    <asp:GridView ID="GridView1" runat="server" AllowPaging="True" AllowSorting="True"
        AutoGenerateColumns="False" CellPadding="4" DataKeyNames="ID" DataSourceID="dsStock"
        ForeColor="#333333" GridLines="None" Width="95%">
        <FooterStyle BackColor="#5D7B9D" Font-Bold="True" ForeColor="White" />
        <Columns>
            <asp:BoundField DataField="ID" HeaderText="ID" InsertVisible="False" ReadOnly="True"
                SortExpression="ID" />
            <asp:BoundField DataField="Nome" HeaderText="Nome" ReadOnly="True" SortExpression="Nome" />
            <asp:BoundField DataField="Codigo" HeaderText="Codigo" ReadOnly="True" SortExpression="Codigo" />
            <asp:BoundField DataField="StockMinimo" HeaderText="Stock M&#237;nimo" SortExpression="StockMinimo" />
            <asp:BoundField DataField="Stock" HeaderText="Stock Existente" SortExpression="Stock" />
            <asp:CommandField ShowEditButton="True" />
        </Columns>
        <RowStyle BackColor="#F7F6F3" ForeColor="#333333" />
        <EditRowStyle BackColor="#999999" />
        <SelectedRowStyle BackColor="#E2DED6" Font-Bold="True" ForeColor="#333333" />
        <PagerStyle BackColor="#284775" ForeColor="White" HorizontalAlign="Center" />
        <HeaderStyle BackColor="#5D7B9D" Font-Bold="True" ForeColor="White" />
        <AlternatingRowStyle BackColor="White" ForeColor="#284775" />
    </asp:GridView>
    <asp:SqlDataSource ID="dsStock" runat="server" ConnectionString="<%$ ConnectionStrings:ConnectionString %>"
        SelectCommand="SELECT [ID], [Nome], [Codigo], [Stock], [StockMinimo] FROM [Produto] WHERE (([Activo] = 1) AND ([Stock] <= StockMinimo))"
        UpdateCommand="UPDATE [Produto] SET [Stock] = @Stock, [StockMinimo] = @StockMinimo WHERE [ID] = @ID">
        <UpdateParameters>
            <asp:Parameter Name="Stock" Type="Int32" />
            <asp:Parameter Name="StockMinimo" Type="Int32" />
            <asp:Parameter Name="ID" Type="Int32" />
        </UpdateParameters>
    </asp:SqlDataSource>
</asp:Content>

