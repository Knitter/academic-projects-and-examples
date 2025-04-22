<%@ Page Language="C#" MasterPageFile="~/MasterPage.master" AutoEventWireup="true" CodeFile="ErroSMTP.aspx.cs" Inherits="ErroSMTP" Title="NewAge@Net - Erro de SMTP" %>
<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
    <table border="0" cellpadding="0" cellspacing="0" width="95%">
        <tr>
            <td style="font-weight: bold; width: 70%; color: white; font-family: Arial, Verdana;
                height: 14px; background-color: #5d7b9d; text-align: center">
                Erro de SMTP</td>
            <td align="right" style="width: 30%; height: 14px; background-color: #5d7b9d">
                <img src="images/allblueheader.png" /></td>
        </tr>
    </table>
    <asp:Panel ID="Panel1" runat="server" Height="50px" HorizontalAlign="Left" Width="95%">
        Ocorreu um erro ao enviar o e-mail, por favor tente mais tarde.<br />
        <br />
        Se o problema persistir contacte um administrador.</asp:Panel>
    <asp:Panel ID="Panel2" runat="server" Height="7px" HorizontalAlign="Right" Width="95%">
        <asp:HyperLink ID="HyperLink1" runat="server" NavigateUrl="~/Default.aspx">Continuar</asp:HyperLink></asp:Panel>
</asp:Content>

