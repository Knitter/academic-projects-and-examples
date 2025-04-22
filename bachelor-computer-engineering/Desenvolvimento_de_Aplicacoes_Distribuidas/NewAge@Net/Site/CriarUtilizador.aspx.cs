using System;
using System.Data;
using System.Configuration;
using System.Collections;
using System.Web;
using System.Web.Security;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Web.UI.WebControls.WebParts;
using System.Web.UI.HtmlControls;
using System.Data.SqlClient;
using System.Diagnostics;

public partial class CriarUtilizador : System.Web.UI.Page {
	protected void Page_Load(object sender, EventArgs e) {
		if(Session["ComCompra"] != null) {
			Session["ComCompra"] = null;
		} else {
			painelNota.Visible = false;
		}
		Session["ComCompra"] = null;
	}

	protected void cbxLocalidade_SelectedIndexChanged(object sender, EventArgs e) {
		((TextBox)PainelCriarUtilizador.CreateUserStep.ContentTemplateContainer.FindControl("txtCodigoPostal")).Text = ((DropDownList)sender).SelectedValue.ToString();

	}

	protected void txtCodigoPostal_TextChanged(object sender, EventArgs e) {
		DropDownList cbx = (DropDownList)PainelCriarUtilizador.CreateUserStep.ContentTemplateContainer.FindControl("cbxLocalidade");
		TextBox txt = (TextBox)sender;

		if (cbx.Items.FindByValue(txt.Text.Trim()) != null)
			cbx.SelectedValue = txt.Text;
		else
			txt.Text = "";
	}

	protected void PainelCriarUtilizador_CreatedUser(object sender, EventArgs e) {
		TextBox tbNome = (TextBox)PainelCriarUtilizador.CreateUserStep.ContentTemplateContainer.FindControl("txtNome");
		TextBox tbApelido = (TextBox)PainelCriarUtilizador.CreateUserStep.ContentTemplateContainer.FindControl("txtApelido");
		TextBox tbContribuinte = (TextBox)PainelCriarUtilizador.CreateUserStep.ContentTemplateContainer.FindControl("txtContribuinte");
		TextBox tbEndereco = (TextBox)PainelCriarUtilizador.CreateUserStep.ContentTemplateContainer.FindControl("txtEndereco");
		TextBox tbCodigoSuplementar = (TextBox)PainelCriarUtilizador.CreateUserStep.ContentTemplateContainer.FindControl("txtCodigoSuplementar");
		DropDownList cbxLocalidade = (DropDownList)PainelCriarUtilizador.CreateUserStep.ContentTemplateContainer.FindControl("cbxLocalidade");
		TextBox tbTelefone = (TextBox)PainelCriarUtilizador.CreateUserStep.ContentTemplateContainer.FindControl("txtTelefone");
		TextBox tbTelemovel = (TextBox)PainelCriarUtilizador.CreateUserStep.ContentTemplateContainer.FindControl("txtTelemovel");
		TextBox tbUsername = (TextBox)PainelCriarUtilizador.CreateUserStep.ContentTemplateContainer.FindControl("Username");
		TextBox tbEmail = (TextBox)PainelCriarUtilizador.CreateUserStep.ContentTemplateContainer.FindControl("Email");
		TextBox tbCodipoPostal = (TextBox)PainelCriarUtilizador.CreateUserStep.ContentTemplateContainer.FindControl("txtCodigoPostal");

		MembershipUser user = Membership.GetUser(tbUsername.Text);
		String userUniqueidentifier = user.ProviderUserKey.ToString();

		Roles.AddUserToRole(user.UserName, "Cliente");

		SqlConnection conn1 = new SqlConnection(ConfigurationManager.ConnectionStrings["ConnectionString"].ToString());
		try {
			String query = "INSERT INTO Cliente(Nome, Apelido, Telefone, Telemovel, NumContribuinte, Endereco, CodigoSuplementar, IDCodigoPostal, Activo, ExternalID)" +
							"VALUES(@Nome, @Apelido, @Telefone, @Telemovel, @NumContribuinte, @Endereco, @CodigoSuplementar, @IDCodigoPostal, 1, @ExternalID)";
			SqlCommand cmd = new SqlCommand(query, conn1);
			cmd.CommandType = CommandType.Text;

			DataView dvLocalidades = (DataView)SqlDataSourceLocalidades.Select(DataSourceSelectArguments.Empty);

			dvLocalidades.RowFilter = "Codigo LIKE '" + cbxLocalidade.SelectedValue + "' AND Localidade LIKE '" + cbxLocalidade.SelectedItem + "'";

			String idCP = "";
			foreach (DataRowView d in dvLocalidades) {
				idCP = d["ID"].ToString();
				break;
			}

			conn1.Open();
			cmd.Parameters.AddWithValue("@Nome", tbNome.Text.Trim());
			cmd.Parameters.AddWithValue("@Apelido", tbApelido.Text.Trim());
			cmd.Parameters.AddWithValue("@Telefone", tbTelefone.Text.Trim());
			cmd.Parameters.AddWithValue("@Telemovel", tbTelemovel.Text.Trim());
			cmd.Parameters.AddWithValue("@NumContribuinte", tbContribuinte.Text.Trim());
			cmd.Parameters.AddWithValue("@Endereco", tbEndereco.Text.Trim());
			cmd.Parameters.AddWithValue("@CodigoSuplementar", tbCodigoSuplementar.Text.Trim());
			if (idCP.Length > 0) {
				cmd.Parameters.AddWithValue("@IDCodigoPostal", idCP);
			} else {
				cmd.Parameters.AddWithValue("@IDCodigoPostal", DBNull.Value);
			}
			cmd.Parameters.AddWithValue("@ExternalID", userUniqueidentifier);


			cmd.ExecuteNonQuery();

		} catch (SqlException exp) {
			Debug.WriteLine(exp.Message);
			abortRegistration(user.UserName);
		} finally {
			conn1.Close();
		}
	}

	private void abortRegistration(String username) {
		Membership.DeleteUser(username);
		Response.Redirect("ErroRegisto.aspx");
	}
	protected void ContinueButton_Click(object sender, EventArgs e) {
		if (Session["ComCompra"] != null) {
			Session["ComCompra"] = null;
			Response.Redirect("Cliente/ConfirmarCompra.aspx");
		} else {
			Response.Redirect("Default.aspx");
		}
	}
}
