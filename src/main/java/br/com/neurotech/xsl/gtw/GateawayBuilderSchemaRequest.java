package br.com.neurotech.xsl.gtw;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class GateawayBuilderSchemaRequest {
	protected String login;
	protected String senha;
	protected String costCenterId;
	protected String siteId;
	protected String url;

	public GateawayBuilderSchemaRequest() {

	}

	public GateawayBuilderSchemaRequest(String login, String senha, String costCenterId, String siteId, String url) {
		super();
		this.login = login;
		this.senha = senha;
		this.costCenterId = costCenterId;
		this.siteId = siteId;
		this.url = url;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setCostCenterId(String costCenterId) {
		this.costCenterId = costCenterId;
	}

	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getLogin() {
		return login;
	}

	public String getSenha() {
		return senha;
	}

	public String getCostCenterId() {
		return costCenterId;
	}

	public String getSiteId() {
		return siteId;
	}

	public String getUrl() {
		return url;
	}

	public String getOutputs() throws ClientProtocolException, IOException, ParserConfigurationException, SAXException, TransformerException {

		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost post = new HttpPost(this.url);
		post.setHeader("Accept-Encoding", "gzip,deflate");
		post.setHeader("Content-Type", "text/xml;charset=UTF-8");
		post.setEntity(new StringEntity(inputXml()));

		CloseableHttpResponse httpResponse = client.execute(post);

		String response = EntityUtils.toString(httpResponse.getEntity());
		
		DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		Document document = db.parse(new ByteArrayInputStream(response.getBytes("UTF-8")));

		NodeList nodeList= document.getDocumentElement().getElementsByTagName("return");
		
		for(int i = 0; i < nodeList.getLength(); i++) {
			Node elem = nodeList.item(i);
			StringWriter buf = new StringWriter();
			Transformer xform = TransformerFactory.newInstance().newTransformer();
			xform.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
			xform.setOutputProperty(OutputKeys.INDENT, "yes");
			xform.transform(new DOMSource(elem), new StreamResult(buf));
			response = buf.toString();
		}
		
		

		return response.replace("ns2:", "");
	}
	
	public String inputXml() {
		return "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:web=\"http://webservice.gateway2.neurotech.com.br\">\r\n"
				+ "   <soapenv:Header/>\r\n" + "   <soapenv:Body>\r\n" + "      <web:gatewayBuilderSchema>\r\n"
				+ "         <web:pLogin>" + this.login + "</web:pLogin>\r\n" + "         <web:pPassword>" + this.senha
				+ "</web:pPassword>\r\n" + "         <web:pCostCenterId>" + this.costCenterId + "</web:pCostCenterId>\r\n"
				+ "         <web:pSite>" + this.siteId + "</web:pSite>\r\n" + "      </web:gatewayBuilderSchema>\r\n"
				+ "   </soapenv:Body>\r\n" + "</soapenv:Envelope>";
	}

}
