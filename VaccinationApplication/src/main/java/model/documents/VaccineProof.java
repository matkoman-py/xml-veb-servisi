package model.documents;

import java.util.Date;

import model.Patient;
import model.VaccinationInfo;

public class VaccineProof {
	
	private String idOfProof;
	private Patient patient;
	private VaccinationInfo firstDose;
	private VaccinationInfo secondDose;
	private Date date;
	private String qrCode;
	public VaccineProof() {
		super();
	}
	public VaccineProof(String idOfProof, Patient patient, VaccinationInfo firstDose, VaccinationInfo secondDose,
			Date date, String qrCode) {
		super();
		this.idOfProof = idOfProof;
		this.patient = patient;
		this.firstDose = firstDose;
		this.secondDose = secondDose;
		this.date = date;
		this.qrCode = qrCode;
	}
	public String getQrCode() {
		return qrCode;
	}
	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}
	public String getIdOfProof() {
		return idOfProof;
	}
	public void setIdOfProof(String idOfProof) {
		this.idOfProof = idOfProof;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public VaccinationInfo getFirstDose() {
		return firstDose;
	}
	public void setFirstDose(VaccinationInfo firstDose) {
		this.firstDose = firstDose;
	}
	public VaccinationInfo getSecondDose() {
		return secondDose;
	}
	public void setSecondDose(VaccinationInfo secondDose) {
		this.secondDose = secondDose;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
}
