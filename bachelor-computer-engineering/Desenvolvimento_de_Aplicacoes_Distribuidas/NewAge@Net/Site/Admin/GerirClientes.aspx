<%@ Page Language="C#" MasterPageFile="~/MasterPage.master" AutoEventWireup="true" CodeFile="GerirClientes.aspx.cs" Inherits="Admin_GerirClientes" Title="NewAge@Net - Gerir Clientes" %>
<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
    <table border="0" cellpadding="0" cellspacing="0" width="95%">
        <tr>
            <td style="font-weight: bold; width: 70%; color: white; font-family: Arial, Verdana;
                height: 14px; background-color: #5d7b9d; text-align: center">
                Clientes</td>
            <td align="right" style="width: 30%; height: 14px; background-color: #5d7b9d">
                <img src="../images/allblueheader.png" /></td>
        </tr>
    </table>
    <br />
    <asp:GridView ID="GridView1" runat="server" AllowPaging="True" AllowSorting="True"
        AutoGenerateColumns="False" CellPadding="4" DataKeyNames="ID,UserName" DataSourceID="dsClientes"
        ForeColor="#333333" GridLines="None" Width="95%" OnRowDeleted="GridView1_RowDeleted" >
        <FooterStyle BackColor="#5D7B9D" Font-Bold="True" ForeColor="White" />
        <Columns>
            <asp:BoundField DataField="ID" HeaderText="ID" InsertVisible="False" ReadOnly="True"
                SortExpression="ID" />
            <asp:BoundField DataField="UserName" HeaderText="Nome de utilizador" SortExpression="UserName" >
                <ItemStyle Width="220px" />
            </asp:BoundField>
            <asp:BoundField DataField="Nome" HeaderText="Nome" ReadOnly="True" SortExpression="Nome" />
            <asp:BoundField DataField="Apelido" HeaderText="Apelido" ReadOnly="True" SortExpression="Apelido" />
            <asp:ButtonField ButtonType="Image" CommandName="Delete" ImageUrl="~/images/cancel.png"
                Text="Button">
                <ControlStyle CssClass="produtos-administrador" />
                <ItemStyle Width="32px" />
            </asp:ButtonField>
        </Columns>
        <RowStyle BackColor="#F7F6F3" ForeColor="#333333" />
        <EditRowStyle BackColor="#999999" />
        <SelectedRowStyle BackColor="#E2DED6" Font-Bold="True" ForeColor="#333333" />
        <PagerStyle BackColor="#284775" ForeColor="White" HorizontalAlign="Center" />
        <HeaderStyle BackColor="#5D7B9D" Font-Bold="True" ForeColor="White" HorizontalAlign="Left" />
        <AlternatingRowStyle BackColor="White" ForeColor="#284775" />
    </asp:GridView>
    <asp:SqlDataSource ID="dsClientes" runat="server" ConnectionString="<%$ ConnectionStrings:ConnectionString %>"
        DeleteCommand="DELETE FROM [Cliente] WHERE [ID] = @ID" InsertCommand="INSERT INTO [Cliente] ([Nome], [Apelido], [Telefone], [Telemovel], [NumContribuinte], [Endereco], [CodigoSuplementar], [IDCodigoPostal]) VALUES (@Nome, @Apelido, @Telefone, @Telemovel, @NumContribuinte, @Endereco, @CodigoSuplementar, @IDCodigoPostal)"
        SelectCommand="SELECT Cliente.ID, Cliente.Nome, Cliente.Apelido, Cliente.Telefone, Cliente.Telemovel, Cliente.NumContribuinte, Cliente.Endereco, Cliente.CodigoSuplementar, Cliente.IDCodigoPostal, aspnet_Users.UserName FROM Cliente INNER JOIN aspnet_Membership ON Cliente.ExternalID = aspnet_Membership.UserId INNER JOIN aspnet_Users ON aspnet_Membership.UserId = aspnet_Users.UserId INNER JOIN aspnet_UsersInRoles ON aspnet_UsersInRoles.UserId = aspnet_Users.UserId INNER JOIN aspnet_Roles ON aspnet_UsersInRoles.RoleId = aspnet_Roles.RoleId&#13;&#10;WHERE aspnet_Roles.RoleName = 'Cliente'"
        UpdateCommand="UPDATE [Cliente] SET [Nome] = @Nome, [Apelido] = @Apelido, [Telefone] = @Telefone, [Telemovel] = @Telemovel, [NumContribuinte] = @NumContribuinte, [Endereco] = @Endereco, [CodigoSuplementar] = @CodigoSuplementar, [IDCodigoPostal] = @IDCodigoPostal WHERE [ID] = @ID">
        <DeleteParameters>
            <asp:Parameter Name="ID" Type="Int32" />
        </DeleteParameters>
        <UpdateParameters>
            <asp:Parameter Name="Nome" Type="String" />
            <asp:Parameter Name="Apelido" Type="String" />
            <asp:Parameter Name="Telefone" Type="String" />
            <asp:Parameter Name="Telemovel" Type="String" />
            <asp:Parameter Name="NumContribuinte" Type="String" />
            <asp:Parameter Name="Endereco" Type="String" />
            <asp:Parameter Name="CodigoSuplementar" Type="String" />
            <asp:Parameter Name="IDCodigoPostal" Type="Int32" />
            <asp:Parameter Name="ID" Type="Int32" />
        </UpdateParameters>
        <InsertParameters>
            <asp:Parameter Name="Nome" Type="String" />
            <asp:Parameter Name="Apelido" Type="String" />
            <asp:Parameter Name="Telefone" Type="String" />
            <asp:Parameter Name="Telemovel" Type="String" />
            <asp:Parameter Name="NumContribuinte" Type="String" />
            <asp:Parameter Name="Endereco" Type="String" />
            <asp:Parameter Name="CodigoSuplementar" Type="String" />
            <asp:Parameter Name="IDCodigoPostal" Type="Int32" />
        </InsertParameters>
    </asp:SqlDataSource>
</asp:Content>

