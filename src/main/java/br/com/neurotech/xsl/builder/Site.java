package br.com.neurotech.xsl.builder;

import java.util.List;

public class Site {
	protected List<Input> inputs;
	protected String siteChannel;
	protected String siteDescription;
	protected String siteHasIPAuthentication;
	protected String siteId;
	protected String siteIndividual;
	protected String sitePublic;
	protected String siteVersion;
	protected String URLHML;
	protected String URLPRD;
	protected String valueChannel;

	public Site(List<Input> inputs, String siteChannel, String siteDescription, String siteHasIPAuthentication,
			String siteId, String siteIndividual, String sitePublic, String siteVersion, String uRLHML, String uRLPRD,
			String valueChannel) {
		super();
		this.inputs = inputs;
		this.siteChannel = siteChannel;
		this.siteDescription = siteDescription;
		this.siteHasIPAuthentication = siteHasIPAuthentication;
		this.siteId = siteId;
		this.siteIndividual = siteIndividual;
		this.sitePublic = sitePublic;
		this.siteVersion = siteVersion;
		URLHML = uRLHML;
		URLPRD = uRLPRD;
		this.valueChannel = valueChannel;
	}

	public List<Input> getInputs() {
		return inputs;
	}

	public void setInputs(List<Input> inputs) {
		this.inputs = inputs;
	}

	public String getSiteChannel() {
		return siteChannel;
	}

	public void setSiteChannel(String siteChannel) {
		this.siteChannel = siteChannel;
	}

	public String getSiteDescription() {
		return siteDescription;
	}

	public void setSiteDescription(String siteDescription) {
		this.siteDescription = siteDescription;
	}

	public String getSiteHasIPAuthentication() {
		return siteHasIPAuthentication;
	}

	public void setSiteHasIPAuthentication(String siteHasIPAuthentication) {
		this.siteHasIPAuthentication = siteHasIPAuthentication;
	}

	public String getSiteId() {
		return siteId;
	}

	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}

	public String getSiteIndividual() {
		return siteIndividual;
	}

	public void setSiteIndividual(String siteIndividual) {
		this.siteIndividual = siteIndividual;
	}

	public String getSitePublic() {
		return sitePublic;
	}

	public void setSitePublic(String sitePublic) {
		this.sitePublic = sitePublic;
	}

	public String getSiteVersion() {
		return siteVersion;
	}

	public void setSiteVersion(String siteVersion) {
		this.siteVersion = siteVersion;
	}

	public String getURLHML() {
		return URLHML;
	}

	public void setURLHML(String uRLHML) {
		URLHML = uRLHML;
	}

	public String getURLPRD() {
		return URLPRD;
	}

	public void setURLPRD(String uRLPRD) {
		URLPRD = uRLPRD;
	}

	public String getValueChannel() {
		return valueChannel;
	}

	public void setValueChannel(String valueChannel) {
		this.valueChannel = valueChannel;
	}

}
