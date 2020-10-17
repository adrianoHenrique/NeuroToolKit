package br.com.neurotech.xsl.xsl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import br.com.neurotech.xsl.models.Blocos;
import br.com.neurotech.xsl.models.Fields;
import br.com.neurotech.xsl.models.OutputBuilder;

public class XslConstructor {

	public static OutputBuilder generateXsl(String gtwBuiderSchema)
			throws ParserConfigurationException, UnsupportedEncodingException, SAXException, IOException {

		DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		Document document = db.parse(new ByteArrayInputStream(gtwBuiderSchema.getBytes("UTF-8")));

		NodeList nodeBlocos = document.getDocumentElement().getElementsByTagName("ns2:blocos");

		List<Blocos> listBlocos = new ArrayList<Blocos>();

		for (int i = 0; i < nodeBlocos.getLength(); i++) {
			Node itemBloco = nodeBlocos.item(i);

			NodeList infoNodes = itemBloco.getChildNodes();

			Blocos bloco = new Blocos();

			List<Fields> listField = new ArrayList<Fields>();

			for (int j = 0; j < infoNodes.getLength(); j++) {
				Node itemInfo = infoNodes.item(j);

				String campoInfo = itemInfo.getNodeName();

				if (campoInfo.equals("ns2:blocoDescription")) {
					bloco.setBlocoDescription(itemInfo.getTextContent());
				} else if (campoInfo.equals("ns2:blocoId")) {
					bloco.setBlocoId(itemInfo.getTextContent());
				} else if (campoInfo.equals("ns2:descricaoDetalhada")) {
					bloco.setDescricaoDetalhada(itemInfo.getTextContent());
				} else if (campoInfo.equals("ns2:fields")) {

					NodeList fieldNodes = itemInfo.getChildNodes();

					System.out.println(fieldNodes.getLength());

					Fields field = new Fields();

					for (int k = 0; k < fieldNodes.getLength(); k++) {
						Node itemField = fieldNodes.item(k);

						String campoField = itemField.getNodeName();

						if (campoField.equals("ns2:description")) {
							field.setDescription(itemField.getTextContent());
						} else if (campoField.equals("ns2:mask")) {
							field.setMask(itemField.getTextContent());
						} else if (campoField.equals("ns2:missing")) {
							field.setMissing(itemField.getTextContent());
						} else if (campoField.equals("ns2:name")) {
							field.setName(itemField.getTextContent());
						} else if (campoField.equals("ns2:type")) {
							field.setType(itemField.getTextContent());
						} else if (campoField.equals("ns2:descricaoDetalhada")) {
							field.setDescricaoDetalhada(itemField.getTextContent());
							listField.add(field);
							field = new Fields();
						}
					}

				} else if (campoInfo.equals("ns2:isUnico")) {
					bloco.setIsUnico(itemInfo.getTextContent());
				}
				
				if(j == infoNodes.getLength() - 1) {
					bloco.setFields(listField);
					listField = new ArrayList<Fields>();
				}
				
			}

			listBlocos.add(bloco);

		}

		return new OutputBuilder(listBlocos);
	}

}
