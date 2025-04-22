<%@ Page Language="C#" MasterPageFile="~/MasterPage.master" AutoEventWireup="true" CodeFile="GerirNotificacoes.aspx.cs" Inherits="Admin_GerirNotificacoes" Title="New Age @ Net - Gerir Notificações" %>
<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
    &nbsp;<table border="0" cellpadding="0" cellspacing="0" width="95%">
        <tr>
            <td style="font-weight: bold; width: 70%; color: white; font-family: Arial, Verdana;
                height: 14px; background-color: #5d7b9d; text-align: center">
                Notificações</td>
            <td align="right" style="width: 30%; height: 14px; background-color: #5d7b9d">
                <img src="../images/allblueheader.png" /></td>
        </tr>
    </table>
    <br />
    <asp:GridView ID="GridView1" runat="server" AllowPaging="True" AllowSorting="True"
        AutoGenerateColumns="False" CellPadding="4" DataKeyNames="IDNotificacao" DataSourceID="dsNotificacoes"
        ForeColor="#333333" GridLines="None" OnRowCommand="GridView1_RowCommand" Width="95%">
        <FooterStyle BackColor="#5D7B9D" Font-Bold="True" ForeColor="White" />
        <Columns>
            <asp:BoundField DataField="IDNotificacao" HeaderText="ID" InsertVisible="False" ReadOnly="True"
                SortExpression="IDNotificacao" />
            <asp:BoundField DataField="DataCriacao" HeaderText="Data de Cria&#231;&#227;o" SortExpression="DataCriacao" />
            <asp:BoundField DataField="EstadoNotificacao" HeaderText="Estado" SortExpression="EstadoNotificacao" />
            <asp:BoundField DataField="Nome" HeaderText="Produto" SortExpression="Nome" />
            <asp:BoundField DataField="Codigo" HeaderText="C&#243;digo do Produto" SortExpression="Codigo" />
            <asp:ButtonField CommandName="Resolver" Text="Resolver" />
        </Columns>
        <RowStyle BackColor="#F7F6F3" ForeColor="#333333" />
        <EditRowStyle BackColor="#999999" />
        <SelectedRowStyle BackColor="#E2DED6" Font-Bold="True" ForeColor="#333333" />
        <PagerStyle BackColor="#284775" ForeColor="White" HorizontalAlign="Center" />
        <HeaderStyle BackColor="#5D7B9D" Font-Bold="True" ForeColor="White" />
        <AlternatingRowStyle BackColor="White" ForeColor="#284775" />
    </asp:GridView>
    <asp:SqlDataSource ID="dsNotificacoes" runat="server" ConnectionString="<%$ ConnectionStrings:ConnectionString %>"
        SelectCommand="SELECT Notificacao.ID AS IDNotificacao, Notificacao.DataCriacao, Notificacao.Estado AS EstadoNotificacao, Produto.Nome, Produto.Codigo FROM Notificar INNER JOIN Produto ON Notificar.IDProduto = Produto.ID INNER JOIN Notificacao ON Notificar.IDNotificacao = Notificacao.ID&#13;&#10;WHERE Notificacao.Estado = 'A'" UpdateCommand="UPDATE Notificacao&#13;&#10;SET Notificacao.Estado = 'F'&#13;&#10;WHERE ID = @ID">
        <UpdateParameters>
            <asp:Parameter Name="ID" />
        </UpdateParameters>
    </asp:SqlDataSource>
</asp:Content>

