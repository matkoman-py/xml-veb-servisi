package model.documents;

import java.util.Date;

import model.NationalityStatus;
import model.Patient;

public class Interest {
	private NationalityStatus nationalityStatus;
	private Patient patient;
	private String state;
	private String manufacturer;
	private boolean givingBlood;
	private Date date;
	public Interest(NationalityStatus nationalityStatus, Patient patient, String state, String manufacturer,
			boolean givingBlood, Date date) {
		super();
		this.nationalityStatus = nationalityStatus;
		this.patient = patient;
		this.state = state;
		this.manufacturer = manufacturer;
		this.givingBlood = givingBlood;
		this.date = date;
	}
	public Interest() {
		super();
	}
	public NationalityStatus getNationalityStatus() {
		return nationalityStatus;
	}
	public void setNationalityStatus(NationalityStatus nationalityStatus) {
		this.nationalityStatus = nationalityStatus;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public boolean isGivingBlood() {
		return givingBlood;
	}
	public void setGivingBlood(boolean givingBlood) {
		this.givingBlood = givingBlood;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
}
