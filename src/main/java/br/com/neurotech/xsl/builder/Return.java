package br.com.neurotech.xsl.builder;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("return")
public class Return {
	protected String date;
	protected String logId;
	protected String message;
	protected String status;
	protected List<Bloco> blocos;
	protected Site site;

	public Return(String date, String logId, String message, String status, List<Bloco> blocos, Site site) {
		super();
		this.date = date;
		this.logId = logId;
		this.message = message;
		this.status = status;
		this.blocos = blocos;
		this.site = site;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getLogId() {
		return logId;
	}

	public void setLogId(String logId) {
		this.logId = logId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Bloco> getBlocos() {
		return blocos;
	}

	public void setBlocos(List<Bloco> blocos) {
		this.blocos = blocos;
	}

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

}
