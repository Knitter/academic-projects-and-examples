<%@ Page Language="C#" MasterPageFile="~/MasterPage.master" AutoEventWireup="true" CodeFile="GerirVendas.aspx.cs" Inherits="Admin_GerirVendas" Title="New Age @ Net - Gerir Vendas" %>
<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
    <table border="0" cellpadding="0" cellspacing="0" width="95%">
        <tr>
            <td style="font-weight: bold; width: 70%; color: white; font-family: Arial, Verdana;
                height: 14px; background-color: #5d7b9d; text-align: center">
                Gestão de Vendas</td>
            <td align="right" style="width: 30%; height: 14px; background-color: #5d7b9d">
                <img src="../images/allblueheader.png" /></td>
        </tr>
    </table>
    <br />
    <asp:GridView ID="GridView1" runat="server" AllowPaging="True" AllowSorting="True"
        AutoGenerateColumns="False" CellPadding="4" DataKeyNames="ID" DataSourceID="dsVendas"
        ForeColor="#333333" GridLines="None" Width="95%" OnRowCommand="GridView1_RowCommand">
        <FooterStyle BackColor="#5D7B9D" Font-Bold="True" ForeColor="White" />
        <Columns>
            <asp:BoundField DataField="ID" HeaderText="ID" InsertVisible="False" ReadOnly="True"
                SortExpression="ID" />
            <asp:BoundField DataField="IDCliente" HeaderText="IDCliente" SortExpression="IDCliente" />
            <asp:BoundField DataField="Referencia" HeaderText="Refer&#234;ncia" SortExpression="Referencia" />
            <asp:BoundField DataField="DataVenda" HeaderText="Data de Cria&#231;&#227;o" SortExpression="DataVenda" />
            <asp:BoundField DataField="CustoTotal" HeaderText="Custo Total (€)" SortExpression="CustoTotal" />
            <asp:ButtonField CommandName="FinalizarVenda" Text="Finalizar" />
        </Columns>
        <RowStyle BackColor="#F7F6F3" ForeColor="#333333" />
        <EditRowStyle BackColor="#999999" />
        <SelectedRowStyle BackColor="#E2DED6" Font-Bold="True" ForeColor="#333333" />
        <PagerStyle BackColor="#284775" ForeColor="White" HorizontalAlign="Center" />
        <HeaderStyle BackColor="#5D7B9D" Font-Bold="True" ForeColor="White" />
        <AlternatingRowStyle BackColor="White" ForeColor="#284775" />
    </asp:GridView>
    <asp:SqlDataSource ID="dsVendas" runat="server" ConnectionString="<%$ ConnectionStrings:ConnectionString %>"
        SelectCommand="SELECT Referencia, DataVenda, CustoTotal, EstadoPagamento, ID, IDCliente FROM Venda WHERE (Referencia IS NOT NULL) AND (EstadoPagamento = 'P')" UpdateCommand="UPDATE Venda&#13;&#10;SET EstadoPagamento = 'C'&#13;&#10;WHERE ID = @ID">
        <UpdateParameters>
            <asp:Parameter Name="ID" />
        </UpdateParameters>
    </asp:SqlDataSource>
</asp:Content>

