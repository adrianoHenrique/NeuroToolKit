package br.com.neurotech.xsl.builder;

public class Input {
	protected String description;
	protected String mask;
	protected String missing;
	protected String name;
	protected String type;

	public Input(String description, String mask, String missing, String name, String type) {
		super();
		this.description = description;
		this.mask = mask;
		this.missing = missing;
		this.name = name;
		this.type = type;
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

}
