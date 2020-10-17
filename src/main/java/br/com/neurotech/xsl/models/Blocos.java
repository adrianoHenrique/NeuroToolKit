package br.com.neurotech.xsl.models;

import java.util.List;

public class Blocos {
	protected String blocoDescription;
	protected String blocoId;
	protected String descricaoDetalhada;
	protected List<Fields> fields;
	protected String isUnico;

	public Blocos(String blocoDescription, String blocoId, String descricaoDetalhada,
			List<Fields> fields, String isUnico) {
		super();
		this.blocoDescription = blocoDescription;
		this.blocoId = blocoId;
		this.descricaoDetalhada = descricaoDetalhada;
		this.fields = fields;
		this.isUnico = isUnico;
	}

	public Blocos() {
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

	public List<Fields> getFields() {
		return fields;
	}

	public void setFields(List<Fields> fields) {
		this.fields = fields;
	}

	public String getIsUnico() {
		return isUnico;
	}

	public void setIsUnico(String isUnico) {
		this.isUnico = isUnico;
	}

	@Override
	public String toString() {
		return "Blocos [blocoDescription=" + blocoDescription + ", blocoId=" + blocoId + ", descricaoDetalhada="
				+ descricaoDetalhada + ", fields=" + fields + ", isUnico=" + isUnico + "]";
	}
	
	

}
