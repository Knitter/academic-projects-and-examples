<%@ Page Language="C#" MasterPageFile="~/MasterPage.master" AutoEventWireup="true" CodeFile="EditarProduto.aspx.cs" Inherits="detalhesProduto" Title="NewAge@Net - Detalhes do Produto" %>
<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
    <table border="0" cellpadding="0" cellspacing="0" width="95%">
        <tr>
            <td style="font-weight: bold; width: 70%; color: white; font-family: Arial, Verdana;
                height: 14px; background-color: #5d7b9d; text-align: center">
                Detalhes do Produto</td>
            <td align="right" style="width: 30%; height: 14px; background-color: #5d7b9d">
                <img src="../images/allblueheader.png" /></td>
        </tr>
    </table>
    &nbsp;<asp:DetailsView ID="tblDetalhes" runat="server" AutoGenerateRows="False" CellPadding="4"
        CssClass="detalhes" DataSourceID="dsDetalhes" ForeColor="#333333" GridLines="None"
        Height="50px" DefaultMode="Edit" DataKeyNames="ID" Width="95%" OnItemUpdating="tblDetalhes_ItemUpdating">
        <FooterStyle BackColor="#5D7B9D" Font-Bold="True" ForeColor="White" />
        <CommandRowStyle BackColor="#E2DED6" Font-Bold="True" />
        <EditRowStyle BackColor="#FCFCFC" />
        <RowStyle BackColor="#F7F6F3" ForeColor="#333333" />
        <PagerStyle BackColor="#284775" ForeColor="White" HorizontalAlign="Center" />
        <FieldHeaderStyle BackColor="#E9ECF1" Font-Bold="True" Width="100px" />
        <HeaderStyle BackColor="#5D7B9D" Font-Bold="True" ForeColor="White" />
        <AlternatingRowStyle BackColor="White" ForeColor="#284775" />
        <Fields>
            <asp:BoundField DataField="ID" HeaderText="ID" InsertVisible="False" ReadOnly="True"
                SortExpression="ID" />
            <asp:BoundField DataField="Nome" HeaderText="Nome" SortExpression="Nome" >
                <ControlStyle Width="99%" />
            </asp:BoundField>
            <asp:BoundField DataField="Codigo" HeaderText="C&#243;digo" SortExpression="Codigo" />
            <asp:BoundField DataField="Descricao" HeaderText="Descri&#231;&#227;o" SortExpression="Descricao" >
                <ControlStyle Width="99%" />
            </asp:BoundField>
            <asp:TemplateField HeaderText="Imagem">
                <EditItemTemplate>
                    <asp:FileUpload ID="FileUpload1" runat="server" Filename='<%# Bind("ImagemURL") %>' />
                </EditItemTemplate>
            </asp:TemplateField>
            <asp:BoundField DataField="Preco" HeaderText="Pre&#231;o" SortExpression="Preco" />
            <asp:BoundField DataField="Stock" HeaderText="Stock" SortExpression="Stock" />
            <asp:BoundField DataField="StockMinimo" HeaderText="Stock M&#237;nimo" SortExpression="StockMinimo" />
            <asp:TemplateField HeaderText="Categoria">
                <InsertItemTemplate>
                    &nbsp;
                </InsertItemTemplate>
                <EditItemTemplate>
                    <asp:DropDownList ID="DropDownList1" runat="server" DataSourceID="dsCategorias" DataTextField="Nome"
                        DataValueField="ID" SelectedValue='<%# Bind("IDCategoria") %>'>
                    </asp:DropDownList>
                </EditItemTemplate>
            </asp:TemplateField>
            <asp:CommandField CancelText="Cancelar" ShowEditButton="True" UpdateText="Guardar Altera&#231;&#245;es" />
        </Fields>
    </asp:DetailsView>
    <asp:SqlDataSource ID="dsDetalhes" runat="server" ConnectionString="<%$ ConnectionStrings:ConnectionString %>"
        SelectCommand="SELECT [ID], [Nome], [Codigo], [Preco], [Stock], [StockMinimo], [Descricao], [ImagemURL], [IDCategoria] FROM [Produto] WHERE ([ID] = @ID)" UpdateCommand="UPDATE [Produto] SET [Nome] = @Nome, [Codigo] = @Codigo, [Preco] = @Preco, [Stock] = @Stock, [StockMinimo] = @StockMinimo, [Descricao] = @Descricao, [ImagemURL] = @ImagemURL, [IDCategoria] = @IDCategoria WHERE [ID] = @ID">
        <SelectParameters>
            <asp:QueryStringParameter Name="ID" QueryStringField="id" Type="Int32" />
        </SelectParameters>
        <UpdateParameters>
            <asp:Parameter Name="Nome" Type="String" />
            <asp:Parameter Name="Codigo" Type="String" />
            <asp:Parameter Name="Preco" Type="Decimal" />
            <asp:Parameter Name="Stock" Type="Int32" />
            <asp:Parameter Name="StockMinimo" Type="Int32" />
            <asp:Parameter Name="Descricao" Type="String" />
            <asp:Parameter Name="ImagemURL" Type="String" />
            <asp:Parameter Name="IDCategoria" Type="Int32" />
            <asp:Parameter Name="ID" Type="Int32" />
        </UpdateParameters>
    </asp:SqlDataSource>
</asp:Content>

