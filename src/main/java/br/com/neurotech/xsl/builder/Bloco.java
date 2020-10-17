package br.com.neurotech.xsl.builder;

import java.util.List;

public class Bloco {
	protected String blocoDescription;
	protected String blocoId;
	protected String descricaoDetalhada;
	protected List<Field> fields;
	protected String isUnico;

	public Bloco(String blocoDescription, String blocoId, String descricaoDetalhada, List<Field> fields,
			String isUnico) {
		super();
		this.blocoDescription = blocoDescription;
		this.blocoId = blocoId;
		this.descricaoDetalhada = descricaoDetalhada;
		this.fields = fields;
		this.isUnico = isUnico;
	}

	public String getBlocoDescription() {
		return blocoDescription;
	}

	public void setBlocoDescription(String blocoDescription) {
		this.blocoDescription = blocoDescription;
	}

	public String getBlocoId() {
		return blocoId;
	}

	public void setBlocoId(String blocoId) {
		this.blocoId = blocoId;
	}

	public String getDescricaoDetalhada() {
		return descricaoDetalhada;
	}

	public void setDescricaoDetalhada(String descricaoDetalhada) {
		this.descricaoDetalhada = descricaoDetalhada;
	}

	public List<Field> getFields() {
		return fields;
	}

	public void setFields(List<Field> fields) {
		this.fields = fields;
	}

	public String getIsUnico() {
		return isUnico;
	}

	public void setIsUnico(String isUnico) {
		this.isUnico = isUnico;
	}

}
