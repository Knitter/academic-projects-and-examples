<%@ Page Language="C#" MasterPageFile="~/MasterPage.master" AutoEventWireup="true" CodeFile="CriarUtilizador.aspx.cs" Inherits="CriarUtilizador" Title="NewAge@Net - Criar Utilizador" %>
<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
    <table border="0" cellpadding="0" cellspacing="0" width="95%">
        <tr>
            <td style="font-weight: bold; width: 70%; font-family: Arial, Verdana; height: 14px;
                background-color: #5d7b9d; text-align: center; color: white;">
                Registar novo Utilizador</td>
            <td align="right" style="width: 30%; height: 14px; background-color: #5d7b9d">
                <img src="images/allblueheader.png" /></td>
        </tr>
    </table>
    <br />
    <asp:Panel ID="painelNota" runat="server" Height="20px" Width="95%" BackColor="#E9ECF1" Font-Bold="False">
        <span style="font-weight: bold;">Nota:</span> O seu carrinho temporário estará disponível depois de se registar.</asp:Panel>
    &nbsp;&nbsp;<asp:CreateUserWizard ID="PainelCriarUtilizador" runat="server" BackColor="#F7F6F3"
        BorderColor="#E6E2D8" BorderStyle="Solid" BorderWidth="1px" Font-Names="Verdana"
        Font-Size="0.8em" CreateUserButtonText="registar" OnCreatedUser="PainelCriarUtilizador_CreatedUser" Width="95%" DuplicateEmailErrorMessage="O e-mail indicado já se encontra em uso. Por favor indique um e-mail diferente." DuplicateUserNameErrorMessage="Por favor introduza um nome de utilizador diferente." InvalidAnswerErrorMessage="Por favor introduza uma resposta de segurança diferente." InvalidEmailErrorMessage="Por favor introduza um e-mail válido." InvalidPasswordErrorMessage="Tamanho mínimo de palavra chaves: {0}. Caracteres não alfanuméricos necessários: {1}." InvalidQuestionErrorMessage="Por favor introduza uma questão de segurança diferente." UnknownErrorMessage="A sua conta não foi criada. Por favor tente novamente." CancelDestinationPageUrl="~/Default.aspx">
        <WizardSteps>
            <asp:CreateUserWizardStep runat="server" ID="Step1">
                <ContentTemplate>
                    <table border="0" style="font-size: 100%; font-family: Verdana" width="100%">
                        <tr>
                            <td align="center" colspan="2" style="font-weight: bold; color: white; background-color: #5d7b9d; height: 18px;">
                                Dados de Acesso</td>
                        </tr>
                        <tr>
                            <td align="right" style="width: 124px; height: 26px">
                                <asp:Label ID="UserNameLabel" runat="server" AssociatedControlID="UserName">nome de utilizador:</asp:Label></td>
                            <td style="width: 339px; height: 26px;">
                                <asp:TextBox ID="Username" runat="server"></asp:TextBox>
                                <asp:RequiredFieldValidator ID="UserNameRequired" runat="server" ControlToValidate="UserName"
                                    ErrorMessage="User Name is required." ToolTip="User Name is required." ValidationGroup="CreateUserWizard1">*</asp:RequiredFieldValidator>
                            </td>
                        </tr>
                        <tr>
                            <td align="right" style="width: 124px">
                                <asp:Label ID="PasswordLabel" runat="server" AssociatedControlID="Password">palavra-passe:</asp:Label></td>
                            <td style="width: 339px">
                                <asp:TextBox ID="Password" runat="server" TextMode="Password"></asp:TextBox>
                                <asp:RequiredFieldValidator ID="PasswordRequired" runat="server" ControlToValidate="Password"
                                    ErrorMessage="Password is required." ToolTip="Password is required." ValidationGroup="CreateUserWizard1">*</asp:RequiredFieldValidator>
                            </td>
                        </tr>
                        <tr>
                            <td align="right" style="height: 26px; width: 124px;">
                                <asp:Label ID="ConfirmPasswordLabel" runat="server" AssociatedControlID="ConfirmPassword">repita palavra-passe:</asp:Label></td>
                            <td style="height: 26px; width: 339px;">
                                <asp:TextBox ID="ConfirmPassword" runat="server" TextMode="Password"></asp:TextBox>
                                <asp:RequiredFieldValidator ID="ConfirmPasswordRequired" runat="server" ControlToValidate="ConfirmPassword"
                                    ErrorMessage="Confirm Password is required." ToolTip="Confirm Password is required."
                                    ValidationGroup="CreateUserWizard1">*</asp:RequiredFieldValidator>
                            </td>
                        </tr>
                        <tr>
                            <td align="right" style="width: 124px">
                                <asp:Label ID="EmailLabel" runat="server" AssociatedControlID="Email">e-mail:</asp:Label></td>
                            <td style="width: 339px">
                                <asp:TextBox ID="Email" runat="server"></asp:TextBox>
                                <asp:RequiredFieldValidator ID="EmailRequired" runat="server" ControlToValidate="Email"
                                    ErrorMessage="E-mail is required." ToolTip="E-mail is required." ValidationGroup="CreateUserWizard1">*</asp:RequiredFieldValidator>
                            </td>
                        </tr>
                        <tr>
                            <td align="right" style="width: 124px">
                                <asp:Label ID="QuestionLabel" runat="server" AssociatedControlID="Question">questão de segurança:</asp:Label></td>
                            <td style="width: 339px">
                                <asp:TextBox ID="Question" runat="server"></asp:TextBox>
                                <asp:RequiredFieldValidator ID="QuestionRequired" runat="server" ControlToValidate="Question"
                                    ErrorMessage="Security question is required." ToolTip="Security question is required."
                                    ValidationGroup="CreateUserWizard1">*</asp:RequiredFieldValidator>
                            </td>
                        </tr>
                        <tr>
                            <td align="right" style="width: 124px">
                                <asp:Label ID="AnswerLabel" runat="server" AssociatedControlID="Answer">resposta de segurança:</asp:Label></td>
                            <td style="width: 339px">
                                <asp:TextBox ID="Answer" runat="server"></asp:TextBox>
                                <asp:RequiredFieldValidator ID="AnswerRequired" runat="server" ControlToValidate="Answer"
                                    ErrorMessage="Security answer is required." ToolTip="Security answer is required."
                                    ValidationGroup="CreateUserWizard1">*</asp:RequiredFieldValidator>
                            </td>
                        </tr>
                        <tr>
                            <td align="right" style="height: 14px; width: 124px;">
                            </td>
                            <td style="height: 14px; width: 339px;">
                            </td>
                        </tr>
                        <tr>
                            <td align="center" colspan="2" style="font-weight: bold; color: white; background-color: #5d7b9d; height: 18px;">
                                Dados Pessoais</td>
                        </tr>
                        <tr>
                            <td align="right" style="height: 26px; width: 124px;">
                                nome:</td>
                            <td style="height: 26px; width: 339px;">
                                <asp:TextBox ID="txtNome" runat="server"></asp:TextBox>
                                <asp:RequiredFieldValidator ID="NomeRequired" runat="server" ErrorMessage="RequiredFieldValidator" ControlToValidate="txtNome" ValidationGroup="CreateUserWizard1">*</asp:RequiredFieldValidator></td>
                        </tr>
                        <tr>
                            <td align="right" style="height: 26px; width: 124px;">
                                apelido:</td>
                            <td style="height: 26px; width: 339px;">
                                <asp:TextBox ID="txtApelido" runat="server"></asp:TextBox>
                                <asp:RequiredFieldValidator ID="ApelidoRequired" runat="server" ErrorMessage="RequiredFieldValidator" ControlToValidate="txtApelido" ValidationGroup="CreateUserWizard1">*</asp:RequiredFieldValidator></td>
                        </tr>
                        <tr>
                            <td align="right" style="width: 124px">
                                contribuinte:</td>
                            <td style="width: 339px">
                                <asp:TextBox ID="txtContribuinte" runat="server"></asp:TextBox>
                                <asp:RequiredFieldValidator ID="RequiredFieldValidator1" runat="server" ErrorMessage="RequiredFieldValidator" ControlToValidate="txtContribuinte" ValidationGroup="CreateUserWizard1">*</asp:RequiredFieldValidator></td>
                        </tr>
                        <tr>
                            <td align="right" valign="top" style="width: 124px">
                                endereço:</td>
                            <td style="width: 339px">
                                <asp:TextBox ID="txtEndereco" runat="server" Rows="4" TextMode="MultiLine" Columns="35"></asp:TextBox>
                                <asp:RequiredFieldValidator ID="RequiredFieldValidator2" runat="server" ControlToValidate="txtEndereco"
                                    ErrorMessage="RequiredFieldValidator" ValidationGroup="CreateUserWizard1">*</asp:RequiredFieldValidator></td>
                        </tr>
                        <tr>
                            <td align="right" style="width: 124px">
                                código postal:</td>
                            <td style="width: 339px">
                                <asp:TextBox ID="txtCodigoPostal" runat="server" Width="40px" OnTextChanged="txtCodigoPostal_TextChanged" AutoPostBack="True"></asp:TextBox>
                                -
                                <asp:TextBox ID="txtCodigoSuplementar" runat="server" Width="28px"></asp:TextBox>
                                <asp:DropDownList ID="cbxLocalidade" runat="server" DataSourceID="SqlDataSourceLocalidades" DataTextField="Localidade" DataValueField="Codigo" OnSelectedIndexChanged="cbxLocalidade_SelectedIndexChanged" AutoPostBack="True">
                                </asp:DropDownList>
                                <asp:RequiredFieldValidator ID="RequiredFieldValidator3" runat="server" ControlToValidate="txtCodigoPostal"
                                    ErrorMessage="RequiredFieldValidator" ValidationGroup="CreateUserWizard1">*</asp:RequiredFieldValidator></td>
                        </tr>
                        <tr>
                            <td align="right" style="width: 124px">
                                telefone:</td>
                            <td style="width: 339px">
                                <asp:TextBox ID="txtTelefone" runat="server"></asp:TextBox></td>
                        </tr>
                        <tr>
                            <td align="right" style="width: 124px">
                                telemóvel:</td>
                            <td style="width: 339px">
                                <asp:TextBox ID="txtTelemovel" runat="server"></asp:TextBox></td>
                        </tr>
                        <tr>
                            <td align="right" style="width: 124px; height: 14px">
                            </td>
                            <td style="width: 339px; height: 14px;">
                            </td>
                        </tr>
                        <tr>
                            <td align="center" colspan="2">
                                <asp:CompareValidator ID="PasswordCompare" runat="server" ControlToCompare="Password"
                                    ControlToValidate="ConfirmPassword" Display="Dynamic" ErrorMessage="A palavra passe e a repetição não são iguais."
                                    ValidationGroup="CreateUserWizard1"></asp:CompareValidator>
                            </td>
                        </tr>
                        <tr>
                            <td align="center" colspan="2" style="color: red">
                                <asp:Literal ID="ErrorMessage" runat="server" EnableViewState="False"></asp:Literal>
                            </td>
                        </tr>
                    </table>
                </ContentTemplate>
            </asp:CreateUserWizardStep>
            <asp:CompleteWizardStep runat="server" AllowReturn="False" ID="Step2">
                <ContentTemplate>
                    <table border="0" style="font-size: 100%; font-family: Verdana" width="100%">
                        <tr>
                            <td align="center" colspan="2" style="font-weight: bold; color: white; background-color: #5d7b9d; height: 18px;">
                                Sucesso!</td>
                        </tr>
                        <tr>
                            <td>
                                A sua conta foi criada com sucesso.</td>
                        </tr>
                        <tr>
                            <td align="right" colspan="2">
                                <asp:Button ID="ContinueButton" runat="server" BackColor="White" BorderColor="#507CD1"
                                    BorderStyle="Solid" BorderWidth="1px" CausesValidation="False" CommandName="Continue"
                                    Font-Names="Verdana" ForeColor="#284E98" Text="continuar" ValidationGroup="btnCriarUtilizador" OnClick="ContinueButton_Click" />
                            </td>
                        </tr>
                    </table>
                </ContentTemplate>
            </asp:CompleteWizardStep>
        </WizardSteps>
        <SideBarStyle BackColor="#5D7B9D" Font-Size="0.9em" VerticalAlign="Top" BorderWidth="0px" />
        <TitleTextStyle BackColor="#5D7B9D" Font-Bold="True" ForeColor="White" />
        <SideBarButtonStyle Font-Names="Verdana" ForeColor="White" BorderWidth="0px" />
        <NavigationButtonStyle BackColor="#FFFBFF" BorderColor="#CCCCCC" BorderStyle="Solid"
            BorderWidth="1px" Font-Names="Verdana" ForeColor="#284775" />
        <HeaderStyle BackColor="#5D7B9D" BorderStyle="Solid"
            Font-Bold="True" Font-Size="0.9em" ForeColor="White" HorizontalAlign="Center" />
        <CreateUserButtonStyle BackColor="#FFFBFF" BorderColor="#CCCCCC" BorderStyle="Solid"
            BorderWidth="1px" Font-Names="Verdana" ForeColor="#284775" />
        <ContinueButtonStyle BackColor="#FFFBFF" BorderColor="#CCCCCC" BorderStyle="Solid"
            BorderWidth="1px" Font-Names="Verdana" ForeColor="#284775" />
        <StepStyle BorderWidth="0px" />
    </asp:CreateUserWizard>
    <asp:SqlDataSource ID="SqlDataSourceLocalidades" runat="server" ConnectionString="<%$ ConnectionStrings:ConnectionString %>"
        SelectCommand="SELECT  [ID], [Codigo], [Localidade] FROM [CodigoPostal] ORDER BY [Localidade]"></asp:SqlDataSource>
</asp:Content>

