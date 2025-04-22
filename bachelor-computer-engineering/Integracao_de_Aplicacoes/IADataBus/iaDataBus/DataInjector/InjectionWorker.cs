using System;
using System.Collections.Generic;
using System.Text;
using DataInjector.NodeService;

namespace DataInjector {

	class InjectionWorker {

		private String destinationURL;

		private String date;
		private float temperatura;
		private float humidade;
		private float velocidadeVento;
		private float radiacao;
		private float pressao;

		public InjectionWorker(float temperatura, float humidade, float velocidadeVento, float radiacao,
													float pressao, String destinationURL, String date) {
			this.date = date;
			this.destinationURL = destinationURL;
			this.temperatura = temperatura;
			this.pressao = pressao;
			this.humidade = humidade;
			this.velocidadeVento = velocidadeVento;
			this.radiacao = radiacao;
			this.pressao = pressao;
		}

		public void run() {
			try {
				Service node = new Service();
				node.Url = destinationURL;
				String xmlDataTemperatura = "<message type=\"data\"><id>" + date + "</id><datatype>" +
																		"temperatura</datatype><datavalue>" + temperatura + "</datavalue>" +
																		"<trace></trace></message>";

				String xmlDataHumidade = "<message type=\"data\"><id>" + date + "</id><datatype>" +
																	"humidade</datatype><datavalue>" + humidade + "</datavalue>" +
																	"<trace></trace></message>";

				String xmlDataVelocidadeVento = "<message type=\"data\"><id>" + date + "</id><datatype>" +
																				"vento</datatype><datavalue>" + velocidadeVento + "</datavalue>" +
																				"<trace></trace></message>";

				String xmlDataRadicao = "<message type=\"data\"><id>" + date + "</id><datatype>" +
																"radiacao</datatype><datavalue>" + radiacao + "</datavalue><trace></trace></message>";

				String xmlDataPressao = "<message type=\"data\"><id>" + date + "</id><datatype>" +
																"pressao</datatype><datavalue>" + pressao + "</datavalue><trace></trace></message>";

				node.RecData(xmlDataTemperatura);
				node.RecData(xmlDataHumidade);
				node.RecData(xmlDataVelocidadeVento);
				node.RecData(xmlDataRadicao);
				node.RecData(xmlDataPressao);
			} catch (Exception ex) {
				//ignore
			}
		}
	}
}
