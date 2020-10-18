package br.com.neurotech.extrator;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.opencsv.CSVWriter;

public class ExtratorVariaveisXML {

	public static void main(String[] args) throws IOException {

		String patch = "C:\\Users\\User\\Desktop\\xml_politica.xml";
		Stream<String> lines;
		String xml = "";

		// Pegando conte�do do arquivo em linhas;
		lines = Files.lines(Paths.get(patch));
		// Inserindo as linhas na string com o separador \r\n
		xml = lines.collect(Collectors.joining(System.lineSeparator()));
		lines.close();

		List<String[]> listaCsv = new ArrayList<String[]>();
		for (String tipo : new String[] { "PROP", "VI", "FLUXO", "FUNCTION", "DB", "GATEWAY", "REGRA", "RET", "FLAG",
				"CALC" }) {
			listaCsv.add(getRegistros(xml, tipo));
		}

		Writer writer = Files.newBufferedWriter(Paths.get("C:\\Users\\User\\Desktop\\relatorio.csv"));
		CSVWriter csv = new CSVWriter(writer, ';', '"', '"', "\n");
		csv.writeNext(new String[] { "Tipo", "Quantidade", "Variaveis" });
		csv.writeAll(listaCsv);
		csv.close();
		writer.close();

	}

	public static String[] getRegistros(String xml, String tipo) {
		Elements elements = null;

		if (tipo.equals("PROP")) {
			elements = Jsoup.parse(xml).getElementsByTag("Input");
		} else if (tipo.equals("VI")) {
			elements = Jsoup.parse(xml).getElementsByTag("Parameters").first().getElementsByAttributeValueStarting("name", "VI_");
		} else if (tipo.equals("FLUXO")) {
			elements = Jsoup.parse(xml).getElementsByAttributeValue("path", "/FLOWS").first()
					.getElementsByTag("DRObject");
		} else if (tipo.equals("FUNCTION")) {
			elements = Jsoup.parse(xml).getElementsByTag("Function");
		} else if (tipo.equals("DB")) {
			elements = Jsoup.parse(xml).getElementsByTag("DB");
		} else if (tipo.equals("GATEWAY")) {
			elements = Jsoup.parse(xml).getElementsByTag("Gateway");
		} else if (tipo.equals("REGRA")) {
			elements = Jsoup.parse(xml).getElementsByAttributeValueStarting("name", "RGR_");
		} else if (tipo.equals("RET")) {
			elements = Jsoup.parse(xml).getElementsByAttributeValueStarting("name", "RET_");
		} else if (tipo.equals("FLAG")) {
			elements = Jsoup.parse(xml).getElementsByAttributeValueStarting("name", "FLAG_");
		} else if (tipo.equals("CALC")) {
			elements = Jsoup.parse(xml).getElementsByAttributeValueStarting("name", "CALC_");
		}

		String qtd = String.valueOf(elements.size());
		String variaveis = "";
		for (Element x : elements) {
			variaveis += x.attr("name") + "#@#";
		}
		variaveis = variaveis.substring(0, variaveis.length() - 3);
		return new String[] { tipo, qtd, variaveis };
	}

}
