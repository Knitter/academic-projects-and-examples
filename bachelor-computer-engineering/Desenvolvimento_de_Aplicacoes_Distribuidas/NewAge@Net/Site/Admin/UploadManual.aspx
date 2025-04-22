<%@ Page Language="C#" MasterPageFile="~/MasterPage.master" AutoEventWireup="true" CodeFile="UploadManual.aspx.cs" Inherits="Admin_Criar_Manual" Title="New Age @ Net - Upload de Manuais" %>
<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
    <table border="0" cellpadding="0" cellspacing="0" width="95%">
        <tr>
            <td style="font-weight: bold; width: 70%; color: white; font-family: Arial, Verdana;
                height: 14px; background-color: #5d7b9d; text-align: center">
                Upload de Manuais</td>
            <td align="right" style="width: 30%; height: 14px; background-color: #5d7b9d">
                <img src="../images/allblueheader.png" /></td>
        </tr>
    </table>
    <br />
    <asp:DropDownList ID="DropDownList1" runat="server" DataSourceID="dsProduto" DataTextField="Expr1"
        DataValueField="ID">
    </asp:DropDownList>&nbsp;
    <br />
    <br />
    <asp:FileUpload ID="FileUpload1" runat="server" />
    <br />
    <br />
    <asp:Button ID="btnUpload" runat="server" Text="Upload Manual" OnClick="btnUpload_Click" />
    <asp:SqlDataSource ID="dsProduto" runat="server" ConnectionString="<%$ ConnectionStrings:ConnectionString %>"
        SelectCommand="SELECT Codigo + ' : ' + Nome AS Expr1, ID FROM Produto ORDER BY Codigo">
    </asp:SqlDataSource>
</asp:Content>

