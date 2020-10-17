package br.com.neurotech.xsl.models;

import java.util.List;

public class OutputBuilder {
	protected List<Blocos> blocos;

	public OutputBuilder(List<Blocos> blocos) {
		super();
		this.blocos = blocos;
	}

	public OutputBuilder() {
		// TODO Auto-generated constructor stub
	}

	public List<Blocos> getBlocos() {
		return blocos;
	}

	public void setBlocos(List<Blocos> blocos) {
		this.blocos = blocos;
	}

	@Override
	public String toString() {
		return "OutputBuilder [blocos=" + blocos + "]";
	}
	
	
}
