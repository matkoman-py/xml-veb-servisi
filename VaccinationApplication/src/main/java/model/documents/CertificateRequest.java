package model.documents;

import java.util.Date;

import model.Patient;

public class CertificateRequest {
	private Patient patient;
	private String reason;
	private String city;
	private Date date;
	public CertificateRequest(Patient patient, String reason, String city, Date date) {
		super();
		this.patient = patient;
		this.reason = reason;
		this.city = city;
		this.date = date;
	}
	public CertificateRequest() {
		super();
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
}
