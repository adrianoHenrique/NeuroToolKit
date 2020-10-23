package tests;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.apache.http.client.ClientProtocolException;
import org.xml.sax.SAXException;

import br.com.neurotech.xsl.gtw.GateawayBuilderSchemaRequest;

public class TestGtwReturn {
	@SuppressWarnings("unused")
	public static void main(String[] args)
			throws ClientProtocolException, IOException, ParserConfigurationException, SAXException, TransformerException {
		GateawayBuilderSchemaRequest gtw = new GateawayBuilderSchemaRequest();
		gtw.setUrl("");
		gtw.setLogin("");
		gtw.setSenha("");
		gtw.setCostCenterId("");
		gtw.setSiteId("");

		String gtwBuilderSchema = gtw.getOutputs();
		
		
		//OutputBuilder output = XslConstructor.generateXsl(gtwBuilderSchema);

		//System.out.println(output.toString());
	}
}
