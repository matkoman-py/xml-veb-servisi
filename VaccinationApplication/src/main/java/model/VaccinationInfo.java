package model;

import java.util.Date;

public class VaccinationInfo {
	private String institution;
	private Vaccine vaccine;
	private Date date;
	private Arm arm;
	private String vaccineSeries;
	public VaccinationInfo(String institution, Vaccine vaccine, Date date, Arm arm, String vaccineSeries) {
		super();
		this.institution = institution;
		this.vaccine = vaccine;
		this.date = date;
		this.arm = arm;
		this.vaccineSeries = vaccineSeries;
	}
	public VaccinationInfo() {
		super();
	}
	
	public String getInstitution() {
		return institution;
	}
	public void setInstitution(String institution) {
		this.institution = institution;
	}
	public Vaccine getVaccine() {
		return vaccine;
	}
	public void setVaccine(Vaccine vaccine) {
		this.vaccine = vaccine;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Arm getArm() {
		return arm;
	}
	public void setArm(Arm arm) {
		this.arm = arm;
	}
	public String getVaccineSeries() {
		return vaccineSeries;
	}
	public void setVaccineSeries(String vaccineSeries) {
		this.vaccineSeries = vaccineSeries;
	}
	
}
