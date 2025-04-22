<%@ Page Language="C#" MasterPageFile="~/MasterPage.master" AutoEventWireup="true" CodeFile="CriarProdutos.aspx.cs" Inherits="Admin_GerirProdutos" Title="NewAge@Net - Criar Produtos" %>
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
    <br />
    <asp:DetailsView ID="DetailsView1" runat="server" AutoGenerateRows="False" CellPadding="4"
        DataKeyNames="ID" DataSourceID="dsProdutos" DefaultMode="Insert" ForeColor="#333333"
        GridLines="None" Height="50px" Width="95%" OnItemInserted="DetailsView1_ItemInserted" OnItemInserting="DetailsView1_ItemInserting">
        <FooterStyle BackColor="#5D7B9D" Font-Bold="True" ForeColor="White" />
        <CommandRowStyle BackColor="#E2DED6" Font-Bold="True" />
        <EditRowStyle BackColor="#FCFCFC" />
        <RowStyle BackColor="#F7F6F3" ForeColor="#333333" />
        <PagerStyle BackColor="#284775" ForeColor="White" HorizontalAlign="Center" />
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
                    &nbsp;
                </EditItemTemplate>
                <InsertItemTemplate>
                    <asp:FileUpload ID="FileUpload1" Filename='<%# Bind("ImagemURL") %>' runat="server" />
                </InsertItemTemplate>
            </asp:TemplateField>
            <asp:BoundField DataField="Preco" HeaderText="Pre&#231;o" SortExpression="Preco" />
            <asp:BoundField DataField="Stock" HeaderText="Stock" SortExpression="Stock" />
            <asp:BoundField DataField="StockMinimo" HeaderText="Stock M&#237;nimo" SortExpression="StockMinimo" />
            <asp:TemplateField HeaderText="Categoria">
                <InsertItemTemplate>
                    <asp:DropDownList ID="DropDownList1" runat="server" DataSourceID="dsCategorias" DataTextField="Nome"
                        DataValueField="ID" SelectedValue='<%# Bind("IDCategoria") %>'>
                    </asp:DropDownList>
                </InsertItemTemplate>
            </asp:TemplateField>
            <asp:CommandField CancelText="Cancelar" InsertText="Criar" ShowInsertButton="True" />
        </Fields>
        <FieldHeaderStyle BackColor="#E9ECF1" Font-Bold="True" Width="100px" />
        <HeaderStyle BackColor="#5D7B9D" Font-Bold="True" ForeColor="White" />
        <AlternatingRowStyle BackColor="White" ForeColor="#284775" />
    </asp:DetailsView>
    <asp:SqlDataSource ID="dsProdutos" runat="server" ConnectionString="<%$ ConnectionStrings:ConnectionString %>"
        DeleteCommand="DELETE FROM [Produto] WHERE [ID] = @ID" InsertCommand="INSERT INTO [Produto] ([Nome], [Codigo], [Preco], [Stock], [StockMinimo], [Descricao], [IDCategoria], [ImagemURL], [Activo]) VALUES (@Nome, @Codigo, @Preco, @Stock, @StockMinimo, @Descricao, @IDCategoria, @ImagemURL, 1)"
        SelectCommand="SELECT [ID], [Nome], [Codigo], [Preco], [Stock], [StockMinimo], [Descricao], [IDCategoria], [ImagemURL] FROM [Produto] WHERE ([Activo] = @Activo)"
        UpdateCommand="UPDATE [Produto] SET [Nome] = @Nome, [Codigo] = @Codigo, [Preco] = @Preco, [Stock] = @Stock, [StockMinimo] = @StockMinimo, [Descricao] = @Descricao, [IDCategoria] = @IDCategoria, [ImagemURL] = @ImagemURL WHERE [ID] = @ID">
        <DeleteParameters>
            <asp:Parameter Name="ID" Type="Int32" />
        </DeleteParameters>
        <UpdateParameters>
            <asp:Parameter Name="Nome" Type="String" />
            <asp:Parameter Name="Codigo" Type="String" />
            <asp:Parameter Name="Preco" Type="Decimal" />
            <asp:Parameter Name="Stock" Type="Int32" />
            <asp:Parameter Name="StockMinimo" Type="Int32" />
            <asp:Parameter Name="Descricao" Type="String" />
            <asp:Parameter Name="IDCategoria" Type="Int32" />
            <asp:Parameter Name="ImagemURL" Type="String" />
            <asp:Parameter Name="ID" Type="Int32" />
        </UpdateParameters>
        <SelectParameters>
            <asp:Parameter DefaultValue="TRUE" Name="Activo" Type="Boolean" />
        </SelectParameters>
        <InsertParameters>
            <asp:Parameter Name="Nome" Type="String" />
            <asp:Parameter Name="Codigo" Type="String" />
            <asp:Parameter Name="Preco" Type="Decimal" />
            <asp:Parameter Name="Stock" Type="Int32" />
            <asp:Parameter Name="StockMinimo" Type="Int32" />
            <asp:Parameter Name="Descricao" Type="String" />
            <asp:Parameter Name="IDCategoria" Type="Int32" />
            <asp:Parameter Name="ImagemURL" Type="String" />
        </InsertParameters>
    </asp:SqlDataSource>
    <asp:SqlDataSource ID="dsCategorias" runat="server" ConnectionString="<%$ ConnectionStrings:ConnectionString %>"
        SelectCommand="SELECT [ID], [Nome], [IDCategoriaPai], [Activa] FROM [Categoria] WHERE (([Activa] = @Activa) AND ([IDCategoriaPai] IS NOT NULL))">
        <SelectParameters>
            <asp:Parameter DefaultValue="true" Name="Activa" Type="Boolean" />
        </SelectParameters>
    </asp:SqlDataSource>
</asp:Content>