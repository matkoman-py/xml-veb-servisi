package model;

import java.util.Date;

public class TemporaryContraindication {
	private Date date;
	private String diagnosis;
	private boolean commisionDecision;
	public TemporaryContraindication(Date date, String diagnosis, boolean commisionDecision) {
		super();
		this.date = date;
		this.diagnosis = diagnosis;
		this.commisionDecision = commisionDecision;
	}
	public TemporaryContraindication() {
		super();
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getDiagnosis() {
		return diagnosis;
	}
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	public boolean isCommisionDecision() {
		return commisionDecision;
	}
	public void setCommisionDecision(boolean commisionDecision) {
		this.commisionDecision = commisionDecision;
	}
	
}
