<%@ Page Language="C#" MasterPageFile="~/MasterPage.master" AutoEventWireup="true" CodeFile="AreaPessoal.aspx.cs" Inherits="Cliente_AreaPessoal" Title="NewAge@Net - Área Pessoal" %>
<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
    <table border="0" cellpadding="0" cellspacing="0" width="95%">
        <tr>
            <td style="font-weight: bold; width: 70%; color: white; font-family: Arial, Verdana;
                height: 14px; background-color: #5d7b9d; text-align: center">
                Área Pessoal</td>
            <td align="right" style="width: 30%; height: 14px; background-color: #5d7b9d">
                <img src="../images/allblueheader.png" /></td>
        </tr>
    </table>
    <br />
    <asp:DetailsView ID="DetailsView1" runat="server" AutoGenerateRows="False" CellPadding="4"
        DataKeyNames="ID,Expr1" DataSourceID="dsUtilizador" ForeColor="#333333" GridLines="None"
        Height="50px" Width="95%" CssClass="areaPessoal">
        <FooterStyle BackColor="#5D7B9D" Font-Bold="True" ForeColor="White" />
        <CommandRowStyle BackColor="#E2DED6" Font-Bold="True" />
        <EditRowStyle BackColor="#999999" />
        <RowStyle BackColor="#F7F6F3" ForeColor="#333333" />
        <PagerStyle BackColor="#284775" ForeColor="White" HorizontalAlign="Center" />
        <Fields>
            <asp:TemplateField HeaderText="Nome" SortExpression="Nome">
                <EditItemTemplate>
                    <asp:TextBox ID="TextBox1" runat="server" Text='<%# Bind("Nome") %>'></asp:TextBox>
                    <asp:RequiredFieldValidator ID="RequiredFieldValidator1" runat="server" ControlToValidate="TextBox1"
                        ErrorMessage="O nome é obrigatório"></asp:RequiredFieldValidator>
                </EditItemTemplate>
                <InsertItemTemplate>
                    <asp:TextBox ID="TextBox1" runat="server" Text='<%# Bind("Nome") %>'></asp:TextBox>
                </InsertItemTemplate>
                <ItemTemplate>
                    <asp:Label ID="Label2" runat="server" Text='<%# Bind("Nome") %>'></asp:Label>
                </ItemTemplate>
            </asp:TemplateField>
            <asp:TemplateField HeaderText="Apelido" SortExpression="Apelido">
                <EditItemTemplate>
                    <asp:TextBox ID="TextBox2" runat="server" Text='<%# Bind("Apelido") %>'></asp:TextBox>
                    <asp:RequiredFieldValidator ID="RequiredFieldValidator2" runat="server" ControlToValidate="TextBox2"
                        ErrorMessage="O apelido é obrigatório"></asp:RequiredFieldValidator>
                </EditItemTemplate>
                <InsertItemTemplate>
                    <asp:TextBox ID="TextBox2" runat="server" Text='<%# Bind("Apelido") %>'></asp:TextBox>
                </InsertItemTemplate>
                <ItemTemplate>
                    <asp:Label ID="Label3" runat="server" Text='<%# Bind("Apelido") %>'></asp:Label>
                </ItemTemplate>
            </asp:TemplateField>
            <asp:TemplateField HeaderText="Telefone" SortExpression="Telefone">
                <EditItemTemplate>
                    <asp:TextBox ID="TextBox3" runat="server" Text='<%# Bind("Telefone") %>'></asp:TextBox>
                    <asp:RangeValidator ID="RangeValidator1" runat="server" ControlToValidate="TextBox3"
                        ErrorMessage="O número de telefone tem de ter 9 dígitos inteiros." MaximumValue="999999999"
                        MinimumValue="100000000" Type="Integer"></asp:RangeValidator>
                </EditItemTemplate>
                <InsertItemTemplate>
                    <asp:TextBox ID="TextBox3" runat="server" Text='<%# Bind("Telefone") %>'></asp:TextBox>
                </InsertItemTemplate>
                <ItemTemplate>
                    <asp:Label ID="Label4" runat="server" Text='<%# Bind("Telefone") %>'></asp:Label>
                </ItemTemplate>
            </asp:TemplateField>
            <asp:TemplateField HeaderText="Telem&#243;vel" SortExpression="Telemovel">
                <EditItemTemplate>
                    <asp:TextBox ID="TextBox4" runat="server" Text='<%# Bind("Telemovel") %>'></asp:TextBox>
                    <asp:RangeValidator ID="RangeValidator2" runat="server" ControlToValidate="TextBox4"
                        ErrorMessage="O número de telemóvel tem de ter 9 dígitos inteiros." MaximumValue="999999999"
                        MinimumValue="100000000" Type="Integer"></asp:RangeValidator>
                </EditItemTemplate>
                <InsertItemTemplate>
                    <asp:TextBox ID="TextBox4" runat="server" Text='<%# Bind("Telemovel") %>'></asp:TextBox>
                </InsertItemTemplate>
                <ItemTemplate>
                    <asp:Label ID="Label5" runat="server" Text='<%# Bind("Telemovel") %>'></asp:Label>
                </ItemTemplate>
            </asp:TemplateField>
            <asp:TemplateField HeaderText="N&#250;mero de Contribuinte" SortExpression="NumContribuinte">
                <EditItemTemplate>
                    <asp:TextBox ID="TextBox5" runat="server" Text='<%# Bind("NumContribuinte") %>'></asp:TextBox>
                    <asp:RangeValidator ID="RangeValidator3" runat="server" ControlToValidate="TextBox5"
                        ErrorMessage="O número de contribuinte tem de ter 9 dígitos numéricos." MaximumValue="999999999"
                        MinimumValue="100000000" Type="Integer"></asp:RangeValidator>
                </EditItemTemplate>
                <InsertItemTemplate>
                    <asp:TextBox ID="TextBox5" runat="server" Text='<%# Bind("NumContribuinte") %>'></asp:TextBox>
                </InsertItemTemplate>
                <ItemTemplate>
                    <asp:Label ID="Label6" runat="server" Text='<%# Bind("NumContribuinte") %>'></asp:Label>
                </ItemTemplate>
            </asp:TemplateField>
            <asp:TemplateField HeaderText="Endere&#231;o" SortExpression="Endereco">
                <EditItemTemplate>
                    <asp:TextBox ID="TextBox6" runat="server" Text='<%# Bind("Endereco") %>'></asp:TextBox>
                    <asp:RequiredFieldValidator ID="RequiredFieldValidator3" runat="server" ControlToValidate="TextBox6"
                        ErrorMessage="O endereço é obrigatório"></asp:RequiredFieldValidator>
                </EditItemTemplate>
                <InsertItemTemplate>
                    <asp:TextBox ID="TextBox6" runat="server" Text='<%# Bind("Endereco") %>'></asp:TextBox>
                </InsertItemTemplate>
                <ItemTemplate>
                    <asp:Label ID="Label7" runat="server" Text='<%# Bind("Endereco") %>'></asp:Label>
                </ItemTemplate>
            </asp:TemplateField>
            <asp:TemplateField HeaderText="C&#243;digo Postal">
                <EditItemTemplate>
                    <asp:DropDownList ID="DropDownList1" runat="server" DataSourceID="dsCodigosPostais"
                        DataTextField="CodigoPostal" DataValueField="ID" SelectedValue='<%# Bind("IDCodigoPostal") %>'>
                    </asp:DropDownList>
                </EditItemTemplate>
                <ItemTemplate>
                    <asp:Label ID="Label1" runat="server" Text='<%# Eval("CodigoPostal") %>'></asp:Label>
                </ItemTemplate>
            </asp:TemplateField>
            <asp:TemplateField HeaderText="C&#243;digo Suplementar" SortExpression="CodigoSuplementar">
                <EditItemTemplate>
                    <asp:TextBox ID="TextBox7" runat="server" Text='<%# Bind("CodigoSuplementar") %>'></asp:TextBox>
                    <asp:RangeValidator ID="RangeValidator7" runat="server" ErrorMessage="O código suplementar tem um máximo de 3 dígitos inteiros."
                        MaximumValue="999" MinimumValue="0" Type="Integer" ControlToValidate="TextBox7"></asp:RangeValidator>
                </EditItemTemplate>
                <InsertItemTemplate>
                    <asp:TextBox ID="TextBox7" runat="server" Text='<%# Bind("CodigoSuplementar") %>'></asp:TextBox>
                </InsertItemTemplate>
                <ItemTemplate>
                    <asp:Label ID="Label8" runat="server" Text='<%# Bind("CodigoSuplementar") %>'></asp:Label>
                </ItemTemplate>
            </asp:TemplateField>
            <asp:TemplateField HeaderText="Localidade" SortExpression="Localidade">
                <EditItemTemplate>
                    <asp:Label ID="Label1" runat="server" Text='<%# Eval("Localidade") %>'></asp:Label>
                </EditItemTemplate>
                <InsertItemTemplate>
                    <asp:TextBox ID="TextBox8" runat="server" Text='<%# Bind("Localidade") %>'></asp:TextBox>
                </InsertItemTemplate>
                <ItemTemplate>
                    <asp:Label ID="Label9" runat="server" Text='<%# Bind("Localidade") %>'></asp:Label>
                </ItemTemplate>
            </asp:TemplateField>
            <asp:CommandField ShowEditButton="True" EditText = "Alterar Dados Pessoais" CancelText="Cancelar" UpdateText="Guardar Altera&#231;&#245;es" />
        </Fields>
        <FieldHeaderStyle BackColor="#E9ECF1" Font-Bold="True" Width="170px" />
        <HeaderStyle BackColor="#5D7B9D" Font-Bold="True" ForeColor="White" />
        <AlternatingRowStyle BackColor="White" ForeColor="#284775" />
    </asp:DetailsView>
    &nbsp;&nbsp;&nbsp; &nbsp; &nbsp;&nbsp;&nbsp;<asp:ChangePassword ID="ChangePassword1" runat="server" BackColor="#F7F6F3"
        BorderColor="#E6E2D8" BorderPadding="4" BorderStyle="Solid" BorderWidth="1px"
        CancelButtonText="Cancelar" ChangePasswordButtonText="Alterar" ChangePasswordFailureText="Palavra-passe incorrecta ou nova palavra-passe inválida. A nova palavra-passe tem de ter pelo menos {0} caracteres e {1} caracter não-alfanumérico."
        ChangePasswordTitleText="Alterar Palavra-Passe" ConfirmNewPasswordLabelText="Confirmar:"
        ConfirmPasswordCompareErrorMessage="Enganou-se a repetir a palavra-passe." ConfirmPasswordRequiredErrorMessage="O campo de confirmação é obrigatório."
        ContinueButtonText="Continuar" CssClass="areaPessoal" Font-Names="Verdana" Font-Size="12px"
        NewPasswordLabelText="Nova Palavra-Passe:" NewPasswordRegularExpressionErrorMessage="Introduza uma palavra-passe diferente."
        NewPasswordRequiredErrorMessage="O campo nova palavra-passe é obrigatório." PasswordLabelText="Palavra-Passe:"
        PasswordRequiredErrorMessage="O campo palavra-passe é obrigatório." SuccessText="A sua palavra-passe foi alterada!"
        SuccessTitleText="Palavra Passe Alterada." Width="95%">
        <CancelButtonStyle BackColor="#FFFBFF" BorderColor="#CCCCCC" BorderStyle="Solid"
            BorderWidth="1px" Font-Names="Verdana" Font-Size="0.8em" ForeColor="#284775" />
        <InstructionTextStyle Font-Italic="True" ForeColor="Black" />
        <PasswordHintStyle Font-Italic="True" ForeColor="#888888" />
        <ChangePasswordButtonStyle BackColor="#FFFBFF" BorderColor="#CCCCCC" BorderStyle="Solid"
            BorderWidth="1px" Font-Names="Verdana" Font-Size="0.8em" ForeColor="#284775" />
        <ContinueButtonStyle BackColor="#FFFBFF" BorderColor="#CCCCCC" BorderStyle="Solid"
            BorderWidth="1px" Font-Names="Verdana" Font-Size="0.8em" ForeColor="#284775" />
        <TitleTextStyle BackColor="#5D7B9D" Font-Bold="True" Font-Size="0.9em" ForeColor="White" />
        <TextBoxStyle Font-Size="0.8em" />
    </asp:ChangePassword>
    <asp:SqlDataSource ID="dsUtilizador" runat="server" ConnectionString="<%$ ConnectionStrings:ConnectionString %>" OnSelecting="dsUtilizador_Selecting" SelectCommand="SELECT Codigo + ' - ' + Localidade AS CodigoPostal, Cliente.ID, Cliente.Nome, Cliente.Apelido, Cliente.Telefone, Cliente.Telemovel, Cliente.NumContribuinte, Cliente.Endereco, Cliente.CodigoSuplementar, Cliente.IDCodigoPostal, Cliente.Activo, Cliente.ExternalID, CodigoPostal.ID AS Expr1, CodigoPostal.Codigo, CodigoPostal.Localidade FROM Cliente LEFT OUTER JOIN CodigoPostal ON Cliente.IDCodigoPostal = CodigoPostal.ID WHERE (Cliente.ExternalID = @ExternalID)" UpdateCommand="UPDATE Cliente&#13;&#10;SET Nome = @nome, Apelido = @apelido, Telefone = @Telefone, Telemovel = @Telemovel, NumContribuinte = @NumContribuinte, Endereco = @Endereco, CodigoSuplementar = @CodigoSuplementar, IDCodigoPostal = @IDCodigoPostal&#13;&#10;WHERE ID = @ID">
        <SelectParameters>
            <asp:ProfileParameter DefaultValue="" Name="ExternalID" PropertyName="guid" Type="String" />
        </SelectParameters>
        <UpdateParameters>
            <asp:Parameter Name="nome" />
            <asp:Parameter Name="apelido" />
            <asp:Parameter Name="Telefone" />
            <asp:Parameter Name="Telemovel" />
            <asp:Parameter Name="NumContribuinte" />
            <asp:Parameter Name="Endereco" />
            <asp:Parameter Name="CodigoSuplementar" />
            <asp:Parameter Name="IDCodigoPostal" />
        </UpdateParameters>
    </asp:SqlDataSource>
    <asp:SqlDataSource ID="dsCodigosPostais" runat="server" ConnectionString="<%$ ConnectionStrings:ConnectionString %>"
        SelectCommand="SELECT Codigo + ' - ' + Localidade AS CodigoPostal, [ID], [Codigo], [Localidade] FROM [CodigoPostal]">
    </asp:SqlDataSource>
</asp:Content>

