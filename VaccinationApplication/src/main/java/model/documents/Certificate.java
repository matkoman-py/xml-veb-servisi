package model.documents;

import model.Patient;
import model.VaccinationInfo;

public class Certificate {
	private String qrCode;
	private String certificateId;
	private Patient patient;
	private VaccinationInfo firstDose;
	private VaccinationInfo secondDose;
	public Certificate(String qrCode, String certificateId, Patient patient, VaccinationInfo firstDose,
			VaccinationInfo secondDose) {
		super();
		this.qrCode = qrCode;
		this.certificateId = certificateId;
		this.patient = patient;
		this.firstDose = firstDose;
		this.secondDose = secondDose;
	}
	public Certificate() {
		super();
	}
	public String getQrCode() {
		return qrCode;
	}
	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}
	public String getCertificateId() {
		return certificateId;
	}
	public void setCertificateId(String certificateId) {
		this.certificateId = certificateId;
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
	
}
