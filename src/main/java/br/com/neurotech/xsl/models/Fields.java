package br.com.neurotech.xsl.models;

public class Fields {
	protected String description;
	protected String mask;
	protected String missing;
	protected String name;
	protected String type;
	protected String descricaoDetalhada;

	public Fields(String description, String mask, String missing, String name, String type,
			String descricaoDetalhada) {
		super();
		this.description = description;
		this.mask = mask;
		this.missing = missing;
		this.name = name;
		this.type = type;
		this.descricaoDetalhada = descricaoDetalhada;
	}

	public Fields() {
		// TODO Auto-generated constructor stub
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public String getDescricaoDetalhada() {
		return descricaoDetalhada;
	}

	public void setDescricaoDetalhada(String descricaoDetalhada) {
		this.descricaoDetalhada = descricaoDetalhada;
	}

	@Override
	public String toString() {
		return "Fields [description=" + description + ", mask=" + mask + ", missing=" + missing + ", name=" + name
				+ ", type=" + type + ", descricaoDetalhada=" + descricaoDetalhada + "]";
	}
	
	

}
