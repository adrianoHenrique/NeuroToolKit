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

		String[] cabecalho = { "Tipo", "Quantidade", "Variaveis" };

		List<String[]> listaCsv = new ArrayList<String[]>();
		listaCsv.add(getProps(xml));
		
		Writer writer = Files.newBufferedWriter(Paths.get("C:\\Users\\User\\Desktop\\relatorio.csv"));
		
		CSVWriter csv = new CSVWriter(writer, ';', '"', '"', "\n");
		csv.writeNext(cabecalho);
		csv.writeAll(listaCsv);
		
		csv.flush();
		csv.close();
		writer.close();
	

	}

	public static String[] getProps(String xml) {
		Elements Inputs = Jsoup.parse(xml).getElementsByTag("Input");
		String qtd = String.valueOf(Inputs.size());
		String variaveis = "";
		for (Element x : Inputs) {
			variaveis += x.attr("name") + "#@#";
		}
		variaveis = variaveis.substring(0, variaveis.length() - 3);
		return new String[] { "PROP", qtd, variaveis };
	}
}
