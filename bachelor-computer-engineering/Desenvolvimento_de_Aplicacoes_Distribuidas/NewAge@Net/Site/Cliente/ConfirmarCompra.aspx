<%@ Page Language="C#" MasterPageFile="~/MasterPage.master" AutoEventWireup="true" CodeFile="ConfirmarCompra.aspx.cs" Inherits="ConfirmarCompra" Title="New Age @ Net - Confimar Compra" %>
<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
    <table border="0" cellpadding="0" cellspacing="0" width="95%">
        <tr>
            <td style="font-weight: bold; width: 70%; color: white; font-family: Arial, Verdana;
                height: 14px; background-color: #5d7b9d; text-align: center">
                Confirme a sua encomenda</td>
            <td align="right" style="width: 30%; height: 14px; background-color: #5d7b9d">
                <img src="images/allblueheader.png" /></td>
        </tr>
    </table>
    <br />
    <asp:GridView ID="GridView1" runat="server" AutoGenerateColumns="False" CellPadding="4" DataSourceID="objdsCarrinho" ForeColor="#333333" GridLines="None" Width="95%">
        <FooterStyle BackColor="#5D7B9D" Font-Bold="True" ForeColor="White" />
        <Columns>
            <asp:BoundField DataField="Codigo" HeaderText="Codigo" ReadOnly="True" SortExpression="Codigo" />
            <asp:BoundField DataField="Nome" HeaderText="Nome" ReadOnly="True" SortExpression="Nome" />
            <asp:BoundField DataField="Quantidade" HeaderText="Quantidade" SortExpression="Quantidade" />
            <asp:BoundField DataField="Disponibilidade" HeaderText="Disponibilidade" ReadOnly="True"
                SortExpression="Disponibilidade" />
            <asp:BoundField DataField="PrecoUnitario" HeaderText="PrecoUnitario" ReadOnly="True"
                SortExpression="PrecoUnitario" />
            <asp:BoundField DataField="SubTotal" HeaderText="SubTotal" ReadOnly="True" SortExpression="SubTotal" />
        </Columns>
        <RowStyle BackColor="#F7F6F3" ForeColor="#333333" />
        <EditRowStyle BackColor="#999999" />
        <SelectedRowStyle BackColor="#E2DED6" Font-Bold="True" ForeColor="#333333" />
        <PagerStyle BackColor="#284775" ForeColor="White" HorizontalAlign="Center" />
        <HeaderStyle BackColor="#5D7B9D" Font-Bold="True" ForeColor="White" />
        <AlternatingRowStyle BackColor="White" ForeColor="#284775" />
    </asp:GridView>
    <asp:Panel ID="painelTotal" runat="server" Height="17px" HorizontalAlign="Right" Width="95%">
        <br />
        <span style="font-weight: bold;">Total:</span>
        <asp:Label ID="lblTotal" runat="server" Text="Label"></asp:Label></asp:Panel>
    <br />
    <asp:Panel ID="painelDadosFalta" runat="server" Height="50px" HorizontalAlign="Left"
        Width="95%" Visible="False">
        Não possui número de contribuinte definido. Se desejar acrescente um número de contribuinte
        válido.<br />
        <br />
        Número de Contribuinte:
        <asp:TextBox ID="txtContrib" runat="server" Columns="9" MaxLength="9"></asp:TextBox></asp:Panel>
    <br />
    <asp:Panel ID="painelPagamento" runat="server" Height="34px" Width="95%" HorizontalAlign="Left" CssClass=".topline">
        <asp:Label ID="Label1" runat="server" Font-Bold="True" Text="Forma de pagamento:"></asp:Label>
        <asp:RadioButton ID="rbMultibanco" runat="server" Text="Multibanco" GroupName="TipoPagamento" AutoPostBack="True" OnCheckedChanged="rbMultibanco_CheckedChanged" />
        <asp:RadioButton ID="rbVisa" runat="server" Text="Visa" GroupName="TipoPagamento" AutoPostBack="True" OnCheckedChanged="rbVisa_CheckedChanged" />
        <br />
        <span style="font-size: 10px;">Nota: No pagamento por multibanco a encomenda será despacha após cobrança válida.<br />
        </span>
        </asp:Panel>
    <br />
    <asp:Panel ID="painelPagamento1" runat="server" Height="40px" HorizontalAlign="Left"
        Width="95%" Font-Names="Arial,Verdana" Visible="False"><table border="0" cellpadding="0" cellspacing="0">
            <tr>
                <td style="width: 20%; font-family: Arial, Verdana;
                height: 24px; text-align: left">
        Entidade:</td>
                <td align="right" style="width: 70%; height: 24px; font-family: Arial, Verdana; text-align: left;">
                    <asp:Label ID="lblEntidade" runat="server"></asp:Label></td>
            </tr>
            <tr>
                <td style="width: 20%; font-family: Arial, Verdana; text-align: left; height: 24px;">
        Referência:</td>
                <td align="right" style="width: 70%; font-family: Arial, Verdana; height: 24px; text-align: left">
                    <asp:Label ID="lblReferencia" runat="server"></asp:Label></td>
            </tr>
        </table>
    </asp:Panel>
    <asp:Panel ID="painelPagamento2" runat="server" Height="105px" HorizontalAlign="Left"
        Width="95%" Visible="False">
        <table border="0" cellpadding="0" cellspacing="0">
            <tr>
                <td style="width: 20%; font-family: Arial, Verdana;
                height: 24px; text-align: left">
                    Titular:</td>
                <td align="right" style="width: 70%; height: 24px; font-family: Arial, Verdana; text-align: left;">
                    <asp:TextBox ID="txtNome" runat="server" Width="266px"></asp:TextBox>
                    <asp:RequiredFieldValidator ID="RequiredFieldValidator1" runat="server" ControlToValidate="txtNome">*</asp:RequiredFieldValidator></td>
            </tr>
            <tr>
                <td style="width: 20%; font-family: Arial, Verdana; text-align: left">
                    Número Cartão:</td>
                <td align="right" style="width: 70%; font-family: Arial, Verdana; height: 24px; text-align: left">
                    <asp:TextBox ID="txtVisaNum" runat="server" Width="168px" Columns="15" MaxLength="15"></asp:TextBox>
                    <asp:RequiredFieldValidator ID="RequiredFieldValidator2" runat="server" ControlToValidate="txtVisaNum">*</asp:RequiredFieldValidator></td>
            </tr>
            <tr>
                <td style="width: 20%; font-family: Arial, Verdana; text-align: left; height: 24px;">
                    Data expiração:</td>
                <td align="right" style="width: 70%; font-family: Arial, Verdana; height: 24px; text-align: left">
                    <asp:TextBox ID="txtDataDia" runat="server" Width="25px" Columns="2" MaxLength="2"></asp:TextBox>
                    -
                    <asp:TextBox ID="txtDataMes" runat="server" Width="25px" Columns="2" MaxLength="2"></asp:TextBox>
                    -
                    <asp:TextBox ID="txtDataAno" runat="server" Columns="4" MaxLength="4"></asp:TextBox>
                    <asp:RequiredFieldValidator ID="RequiredFieldValidator5" runat="server" ControlToValidate="txtDataAno">*</asp:RequiredFieldValidator>&nbsp;
                    (dd-mm-aaaa)</td>
            </tr>
            <tr>
                <td style="width: 20%; font-family: Arial, Verdana; text-align: left">
                    CVV2:</td>
                <td align="right" style="width: 70%; font-family: Arial, Verdana; height: 24px; text-align: left">
                    <asp:TextBox ID="txtCVV" runat="server" Columns="3" MaxLength="3"></asp:TextBox>
                    <asp:RequiredFieldValidator ID="RequiredFieldValidator4" runat="server" ControlToValidate="txtCVV">*</asp:RequiredFieldValidator></td>
            </tr>
        </table>
    </asp:Panel>
    <br />
    <asp:Panel ID="painelForaStock" runat="server" Font-Names="arial, verdana" ForeColor="Red"
        Height="36px" HorizontalAlign="Left" Width="95%" Visible="False">
        Na sua compra existem produtos esgotados. Se decidir continuar com a compra será
        criada uma encomenda para satisfazer o seu pedido.</asp:Panel>
    <br />
    <asp:Panel ID="painelBotoes" runat="server" Height="31px" Width="95%" HorizontalAlign="Right">
        <asp:Button ID="btnConfirmar" runat="server" BackColor="White" BorderColor="#507CD1"
            BorderStyle="Solid" BorderWidth="1px" Font-Names="Verdana" ForeColor="#284E98"
            OnClick="btnConfirmar_Click" Text="Confirmar" />
        <asp:Button ID="btnCancelar" runat="server" BackColor="White" BorderColor="#507CD1"
            BorderStyle="Solid" BorderWidth="1px" Font-Names="Verdana" ForeColor="#284E98"
            OnClick="btnCancelar_Click" Text="Cancelar" CausesValidation="False" /></asp:Panel>
    <asp:ObjectDataSource ID="objdsCarrinho" runat="server" DeleteMethod="removerProduto"
        SelectMethod="obterTodosProdutos" TypeName="CarroCompras" OnObjectCreating="objdsCarrinho_ObjectCreating" OnObjectDisposing="objdsCarrinho_ObjectDisposing">
        <DeleteParameters>
            <asp:Parameter Name="idProduto" Type="Int32" />
        </DeleteParameters>
    </asp:ObjectDataSource>
</asp:Content>

