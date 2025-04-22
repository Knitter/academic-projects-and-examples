using System;
using System.Data;
using System.Configuration;
using System.Web;
using System.Web.Security;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Web.UI.WebControls.WebParts;
using System.Web.UI.HtmlControls;

/// <summary>
/// Summary description for InjectionWorker
/// </summary>
public class InjectionWorker {
		
		private String destinationURL;
		private String xml;
		

		public InjectionWorker(String xml, String destinationURL) {
			this.xml = xml;
			this.destinationURL = destinationURL;
		}

		public void run() {
			try {
				Service node = new Service();
				node.RecData(xml);
			} catch (Exception ex) {
				//ignore
			}
		}
}
