using System;
using System.Data;
using System.Configuration;
using System.Web;
using System.Web.Security;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Web.UI.WebControls.WebParts;
using System.Web.UI.HtmlControls;
using System.Net.Mail;

/// <summary>
/// Summary description for Utils
/// </summary>
public abstract class Utils {

	public static String ENTIDADE = "21555";
	public static String ESTADO_ENVIO_CONCLUIDO = "C";
	public static String ESTADO_ENVIO_PENDENTE = "P";
	public static String ESTADO_PAGAMENTO_CONCLUIDO = "C";
	public static String ESTADO_PAGAMENTO_PENDENTE = "P";

	private static String MAIL_EMPRESA = "info.newage@sapo.pt";
	/// <summary>
	/// Permite gerar uma referencia aleatória.
	/// </summary>
	/// <returns>A referencia gerada</returns>
	public static String gerarReferenciaAleatoria() {
		char[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
		String resultado = "";

		Random r = new Random(DateTime.Now.GetHashCode());

		for (int i = 0; i < 9; i++) {
			resultado += digits[r.Next(9)].ToString();
		}

		return resultado;
	}

	/// <summary>
	/// Permite enviar mensagens para o endereco de e-mail especifico.
	/// </summary>
	/// <param name="subject">Assunto do e-mail</param>
	/// <param name="to">Endereco destino</param>
	/// <param name="htmlMessage">HTML que constitui a mensagem</param>
	public static void sendMail(String subject, String to, String htmlMessage) {
		MailMessage mail = new MailMessage();
		mail.To.Add(to);
		mail.From = new MailAddress(MAIL_EMPRESA);
		mail.Subject = subject;
		mail.Body = htmlMessage;
		SmtpClient client = new SmtpClient();
		client.Host =  "localhost";
		client.Send(mail);
	}
}
