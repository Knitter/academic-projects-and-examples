<%@ Page Language="C#" MasterPageFile="~/MasterPage.master" AutoEventWireup="true" CodeFile="RecuperarPassword.aspx.cs" Inherits="RecuperarPassword" Title="NewAge@Net - Recuperar Password" %>
<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
<span class="style2">
    </span>
    <table border="0" cellpadding="0" cellspacing="0" width="95%">
        <tr>
            <td style="font-weight: bold; width: 70%; color: white; font-family: Arial, Verdana;
                height: 14px; background-color: #5d7b9d; text-align: center">
        Login Incorrecto</td>
            <td align="right" style="width: 30%; height: 14px; background-color: #5d7b9d">
                <img src="images/allblueheader.png" /></td>
        </tr>
    </table>
    <br />
    <div style="width: 95%; text-align: left">
    Não foi possível efectuar o login com os dados fornecidos. Por favor corriga os
        dados de autenticação.<br />
        <br />
        Se se esqueceu da palavra-passe uso o sistema de recuperação:</div>
    <br />
    <asp:PasswordRecovery ID="PasswordRecovery" runat="server"
        BorderPadding="4" Font-Names="Verdana"
        Font-Size="0.8em" AnswerRequiredErrorMessage="A resposta é necessária." QuestionLabelText="Pergunta de segurança:" QuestionTitleText="Confirmação de Identidade" SubmitButtonText="Recuperar Palavra-passe" SuccessText="A sua palavra-passe foi enviada" UserNameFailureText="Não nos foi possível aceder à sua informação. Por favor tente novamente." UserNameInstructionText="" UserNameLabelText="Utilizador:" UserNameRequiredErrorMessage="O utilizador é necessário." UserNameTitleText="" Width="95%" OnSendMailError="PasswordRecovery_SendMailError">
        <InstructionTextStyle Font-Italic="True" ForeColor="Black" />
        <SuccessTextStyle Font-Bold="True" ForeColor="#5D7B9D" />
        <TextBoxStyle Font-Size="0.8em" />
        <TitleTextStyle BackColor="#5D7B9D" Font-Bold="True" Font-Size="0.9em" ForeColor="White" />
        <SubmitButtonStyle BackColor="#FFFBFF" BorderColor="#CCCCCC" BorderStyle="Solid" BorderWidth="1px"
            Font-Names="Verdana" Font-Size="0.8em" ForeColor="#284775" />
        <UserNameTemplate>
            <table border="0" cellpadding="4" cellspacing="0" style="border-collapse: collapse; text-align: center;"
                width="100%">
                <tr>
                    <td>
                        <table border="0" cellpadding="0">
                            <tr>
                                <td align="right">
                                    <asp:Label ID="UserNameLabel" runat="server" AssociatedControlID="UserName">Utilizador:</asp:Label></td>
                                <td style="width: 329px">
                                    <asp:TextBox ID="UserName" runat="server" Font-Size="0.8em"></asp:TextBox>
                                    <asp:RequiredFieldValidator ID="UserNameRequired" runat="server" ControlToValidate="UserName"
                                        ErrorMessage="O utilizador é necessário." ToolTip="O utilizador é necessário."
                                        ValidationGroup="PasswordRecovery">*</asp:RequiredFieldValidator>
                                    <asp:Button ID="SubmitButton" runat="server" BackColor="#FFFBFF" BorderColor="#CCCCCC"
                                        BorderStyle="Solid" BorderWidth="1px" CommandName="Submit" Font-Names="Verdana"
                                        Font-Size="0.8em" ForeColor="#284775" Text="Recuperar Palavra-passe" ValidationGroup="PasswordRecovery" /></td>
                            </tr>
                            <tr>
                                <td align="center" colspan="2" style="color: red">
                                    <asp:Literal ID="FailureText" runat="server" EnableViewState="False"></asp:Literal>
                                </td>
                            </tr>
                            <tr>
                                <td align="right" colspan="2" style="height: 12px">
                                    &nbsp;</td>
                            </tr>
                        </table>
                    </td>
                </tr>
            </table>
        </UserNameTemplate>
    </asp:PasswordRecovery>
    <br />
    <asp:Panel ID="Panel1" runat="server" BackColor="#E9ECF1" Height="20px" Width="95%" HorizontalAlign="Left">
        Se ainda não é cliente por favor
        <asp:HyperLink ID="lnkRegistar" runat="server" NavigateUrl="~/CriarUtilizador.aspx">registe-se</asp:HyperLink>.</asp:Panel>
</asp:Content>

