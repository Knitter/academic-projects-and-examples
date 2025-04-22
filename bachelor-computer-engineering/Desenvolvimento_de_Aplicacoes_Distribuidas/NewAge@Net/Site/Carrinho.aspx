<%@ Page Language="C#" MasterPageFile="~/MasterPage.master" AutoEventWireup="true" CodeFile="Carrinho.aspx.cs" Inherits="Cliente_Carrinho" Title="NewAge@Net - Carrinho de Compras" %>
<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
    <table border="0" cellpadding="0" cellspacing="0" width="95%">
        <tr>
            <td style="font-weight: bold; width: 70%; font-family: Arial, Verdana; height: 14px;
                background-color: #5d7b9d; text-align: center; color: white;">
                Carrinho de Compras</td>
            <td align="right" style="width: 30%; height: 14px; background-color: #5d7b9d">
                <img src="images/allblueheader.png" /></td>
        </tr>
    </table>
    <br />
    <asp:GridView ID="gridCarrinho" runat="server" AllowPaging="True" AutoGenerateColumns="False"
        DataKeyNames="IDProduto" DataSourceID="objdsCarrinho" CellPadding="4" ForeColor="#333333" GridLines="None" OnRowDeleted="gridCarrinho_RowDeleted" OnRowCommand="gridCarrinho_RowCommand" Width="95%">
        <Columns>
            <asp:BoundField DataField="Codigo" HeaderText="Codigo" ReadOnly="True" SortExpression="Codigo" />
            <asp:BoundField DataField="Nome" HeaderText="Nome" ReadOnly="True" SortExpression="Nome" />
            <asp:BoundField DataField="Quantidade" HeaderText="Quantidade" SortExpression="Quantidade" />
            <asp:BoundField DataField="Disponibilidade" HeaderText="Disponibilidade" ReadOnly="True"
                SortExpression="Disponibilidade" />
            <asp:BoundField DataField="PrecoUnitario" HeaderText="Pre&#231;o Unit&#225;rio" ReadOnly="True"
                SortExpression="PrecoUnitario" />
            <asp:TemplateField>
                <ItemTemplate>
                <asp:ImageButton ID="btnIncrementar" runat="server" ImageUrl="~/images/edit_add.png" CommandName="incrementar" CommandArgument=<%#Eval("IDProduto")%> CausesValidation="False" /> <br />
                <asp:ImageButton ID="btnDecrementar" runat="server" ImageUrl="~/images/edit_remove.png" CommandName="decrementar" CommandArgument=<%#Eval("IDProduto")%> CausesValidation="False" />
                </ItemTemplate>
            </asp:TemplateField>
            <asp:CommandField ShowDeleteButton="True" ButtonType="Image" DeleteImageUrl="~/images/cancel.png" />
        </Columns>
        <FooterStyle BackColor="#5D7B9D" Font-Bold="True" ForeColor="White" />
        <RowStyle BackColor="#F7F6F3" ForeColor="#333333" />
        <EditRowStyle BackColor="#999999" />
        <SelectedRowStyle BackColor="#E2DED6" Font-Bold="True" ForeColor="#333333" />
        <PagerStyle BackColor="#284775" ForeColor="White" HorizontalAlign="Center" />
        <HeaderStyle BackColor="#E2DED6" Font-Bold="True" ForeColor="White" />
        <AlternatingRowStyle BackColor="White" ForeColor="#284775" />
    </asp:GridView>
    <asp:Panel ID="Panel1" runat="server" Height="13px" HorizontalAlign="Right" Width="95%">
        <asp:Label ID="lblTotalCarrinho" runat="server"></asp:Label></asp:Panel>
    <asp:Panel ID="painelCarroVazio" runat="server" BackColor="#E9ECF1" Height="20px" Width="95%" Font-Names="areal, verdana" HorizontalAlign="Center">
        O seu carrinho de compras encontra-se vazio.</asp:Panel>
    <br />
    <asp:Panel ID="painelUserNaoAutenticado" runat="server" BackColor="#E9ECF1" Height="20px" Width="95%" Font-Names="arial, verdana" ForeColor="Red" HorizontalAlign="Left">
        Não se encontra ligado, se prosseguir com a compra será levado a registar-se como
        cliente. Se já é cliente efectue o login antes de prosseguir com a sua compra.</asp:Panel>
    <br />
    <asp:LoginView ID="LoginView1" runat="server">
        <LoggedInTemplate>
        <asp:Button ID="btnAnularCarro" runat="server" BackColor="White" BorderColor="#507CD1" BorderStyle="Solid" BorderWidth="1px" Font-Names="Verdana" ForeColor="#284E98" Text="Anular" OnClick="btnAnularCarro_Click" />
        <asp:Button ID="btnGuardarCarro" runat="server" BackColor="White" BorderColor="#507CD1" BorderStyle="Solid" BorderWidth="1px" Font-Names="Verdana" ForeColor="#284E98" Text="Guardar" OnClick="btnGuardarCarro_Click" />
        <asp:Button ID="btnComprar" runat="server" BackColor="White" BorderColor="#507CD1" BorderStyle="Solid" BorderWidth="1px" Font-Names="Verdana" ForeColor="#284E98" Text="Comprar" OnClick="btnComprar_Click" />
        &nbsp;&nbsp;&nbsp;
        <asp:Button ID="btnContinuar" runat="server" BackColor="White" BorderColor="#507CD1" BorderStyle="Solid" BorderWidth="1px" Font-Names="Verdana" ForeColor="#284E98" Text="Continuar a comprar" OnClick="btnContinuar_Click" CausesValidation="False" />
        </LoggedInTemplate>
        <AnonymousTemplate><asp:Button ID="btnComprarAnonym" runat="server" BackColor="White" BorderColor="#507CD1" BorderStyle="Solid" BorderWidth="1px" Font-Names="Verdana" ForeColor="#284E98" Text="Comprar" OnClick="btnComprarAnonym_Click" />
        </AnonymousTemplate>
    </asp:LoginView>
    <asp:ObjectDataSource ID="objdsCarrinho" runat="server" DeleteMethod="removerProduto"
        OnObjectCreating="objdsCarrinho_ObjectCreating" OnObjectDisposing="objdsCarrinho_ObjectDisposing"
        SelectMethod="obterTodosProdutos" TypeName="CarroCompras">
        <DeleteParameters>
            <asp:Parameter Name="idProduto" Type="Int32" />
        </DeleteParameters>
    </asp:ObjectDataSource>
    &nbsp;&nbsp;
</asp:Content>

