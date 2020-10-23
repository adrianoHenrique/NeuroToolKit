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

		// Pegando conteúdo do arquivo em linhas;
		lines = Files.lines(Paths.get(patch));
		// Inserindo as linhas na string com o separador \r\n
		xml = lines.collect(Collectors.joining(System.lineSeparator()));
		lines.close();

		Writer writer = Files.newBufferedWriter(Paths.get("C:\\Users\\User\\Desktop\\relatorio.csv"));
		CSVWriter csv = new CSVWriter(writer, ';', '"', '"', "\n");
		csv.writeNext(new String[] { "Tipo", "Quantidade", "Variaveis" });
		csv.writeAll(getRegistros(xml));
		csv.close();
		writer.close();

	}

	public static List<String[]> getRegistros(String xml) {
		List<String[]> listaCSV = new ArrayList<String[]>();
		String[] prefixos = { "PROP_", "VI_", "FLX_","RGR_", "CALC_", "RET_", "FLAG_" };

		for (String prefixo : prefixos) {
			Elements elements = Jsoup.parse(xml).getElementsByAttributeValueStarting("name", prefixo);
			String variaveis = "";
			List<String> listaVar = new ArrayList<String>();
			
			for (Element x : elements) {
				String validacao = x.attr("name");
				if (!listaVar.contains(validacao)) {
					listaVar.add(validacao);
					variaveis += x.attr("name") + "#@#";
				}
			}
			if(!variaveis.isEmpty()) {
				variaveis = variaveis.substring(0, variaveis.length() - 3);
			
				String qtd = String.valueOf(variaveis.split("#@#").length);

				listaCSV.add(new String[] { prefixo.replace("_", ""), qtd, variaveis });
			}
			
		}

		return listaCSV;
	}

}
