package br.com.neurotech.xsl.builder;

public class Field {
	protected String blocoDescription;
	protected String mask;
	protected String missing;
	protected String name;
	protected String type;
	protected String descricaoDestalhada;

	public Field(String blocoDescription, String mask, String missing, String name, String type,
			String descricaoDestalhada) {
		super();
		this.blocoDescription = blocoDescription;
		this.mask = mask;
		this.missing = missing;
		this.name = name;
		this.type = type;
		this.descricaoDestalhada = descricaoDestalhada;
	}

	public String getBlocoDescription() {
		return blocoDescription;
	}

	public void setBlocoDescription(String blocoDescription) {
		this.blocoDescription = blocoDescription;
	}

	public String getMask() {
		return mask;
	}

	public void setMask(String mask) {
		this.mask = mask;
	}

	public String getMissing() {
		return missing;
	}

	public void setMissing(String missing) {
		this.missing = missing;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescricaoDestalhada() {
		return descricaoDestalhada;
	}

	public void setDescricaoDestalhada(String descricaoDestalhada) {
		this.descricaoDestalhada = descricaoDestalhada;
	}

}
