<%@ Page Language="C#" MasterPageFile="~/MasterPage.master" AutoEventWireup="true" CodeFile="CriarAdministrador.aspx.cs" Inherits="Admin_CriarAdministrador" Title="NewAge@Net - Criar Administrador" %>
<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
    <table border="0" cellpadding="0" cellspacing="0" width="95%">
        <tr>
            <td style="font-weight: bold; width: 70%; color: white; font-family: Arial, Verdana;
                height: 14px; background-color: #5d7b9d; text-align: center">
                Criar Novo Administrador</td>
            <td align="right" style="width: 30%; height: 14px; background-color: #5d7b9d">
                <img src="../images/allblueheader.png" /></td>
        </tr>
    </table>
    <br />
    <asp:CreateUserWizard ID="wizCriarAdministrador" runat="server" AnswerLabelText="Resposta de Segurança:"
        AnswerRequiredErrorMessage="A resposta de segurança é obrigatória." BackColor="#F7F6F3"
        BorderColor="#E6E2D8" BorderStyle="Solid" BorderWidth="1px" CancelButtonText="Cancelar"
        CompleteSuccessText="A sua conta foi criada com sucesso." ConfirmPasswordCompareErrorMessage="A palavra-passe e a confirmação têm de ser iguais."
        ConfirmPasswordLabelText="Confirmar palavra-passe:" ConfirmPasswordRequiredErrorMessage="A confirmação da palavra-passe é obrigatória."
        ContinueButtonText="Continuar" CreateUserButtonText="Criar Administrador" DuplicateEmailErrorMessage="O e-mail que introduziu já se encontra em uso. Introduza um e-mail diferente."
        DuplicateUserNameErrorMessage="Introduza um nome de utilizador diferente." EmailRegularExpressionErrorMessage="Introduza um e-mail diferente."
        EmailRequiredErrorMessage="O e-mail é obrigatório." FinishCompleteButtonText="Terminar"
        FinishPreviousButtonText="Anterior" Font-Names="Verdana" Font-Size="12px" InvalidAnswerErrorMessage="Introduza uma resposta diferente."
        InvalidEmailErrorMessage="Introduza um e-mail válido." InvalidPasswordErrorMessage="Número mínimo de caracteres: {0}. Non-alphanumeric characters required: {1}."
        InvalidQuestionErrorMessage="Introduza uma pergunta de segurança diferente."
        PasswordLabelText="Palavra-passe:" PasswordRegularExpressionErrorMessage="Introduza uma palavra-passe diferente."
        PasswordRequiredErrorMessage="A palavra-passe é obrigatória." QuestionLabelText="Pergunta de Segurança:"
        QuestionRequiredErrorMessage="A pergunta de segurança é obrigatória." StartNextButtonText="Próximo"
        StepNextButtonText="Próximo" StepPreviousButtonText="Anterior" UnknownErrorMessage="A sua conta não foi criada. Por favor tente novamente."
        UserNameLabelText="Nome de utilizador:" UserNameRequiredErrorMessage="O nome de utilizador é obrigatório." OnCreatedUser="CreateUserWizard1_CreatedUser" LoginCreatedUser="False" Width="95%">
        <WizardSteps>
            <asp:CreateUserWizardStep runat="server" Title="Criar Administrador">
            </asp:CreateUserWizardStep>
            <asp:CompleteWizardStep runat="server" Title="Administrador Criado">
            </asp:CompleteWizardStep>
        </WizardSteps>
        <SideBarStyle BackColor="#5D7B9D" BorderWidth="0px" Font-Size="0.9em" VerticalAlign="Top" />
        <TitleTextStyle BackColor="#5D7B9D" Font-Bold="True" ForeColor="White" />
        <SideBarButtonStyle BorderWidth="0px" Font-Names="Verdana" ForeColor="White" />
        <NavigationButtonStyle BackColor="#FFFBFF" BorderColor="#CCCCCC" BorderStyle="Solid"
            BorderWidth="1px" Font-Names="Verdana" ForeColor="#284775" />
        <HeaderStyle BackColor="#5D7B9D" BorderStyle="Solid" Font-Bold="True" Font-Size="0.9em"
            ForeColor="White" HorizontalAlign="Center" />
        <CreateUserButtonStyle BackColor="#FFFBFF" BorderColor="#CCCCCC" BorderStyle="Solid"
            BorderWidth="1px" Font-Names="Verdana" ForeColor="#284775" />
        <ContinueButtonStyle BackColor="#FFFBFF" BorderColor="#CCCCCC" BorderStyle="Solid"
            BorderWidth="1px" Font-Names="Verdana" ForeColor="#284775" />
        <StepStyle BorderWidth="0px" />
    </asp:CreateUserWizard>
</asp:Content>

