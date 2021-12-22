package model.documents;

import java.util.Date;
import java.util.List;

import model.ManufacturerInfo;

public class VaccineReport {
	private Date fromDate;
	private Date toDate;
	private int numberOfInterests;
	private int digitalCertificatesRequested;
	private int digitalCertificatesApproved;
	private int numberOfAllVaccines;
	private int firstDoseNumber;
	private int secondDoseNumber;
	private int thirdDoseNumber;
	private Date issuingDate;
	private List<ManufacturerInfo> manufacturers;
	
	public VaccineReport(Date fromDate, Date toDate, int numberOfInterests, int digitalCertificatesRequested,
			int digitalCertificatesApproved, int numberOfAllVaccines, int firstDoseNumber, int secondDoseNumber,
			int thirdDoseNumber, Date issuingDate, List<ManufacturerInfo> manufacturers) {
		super();
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.numberOfInterests = numberOfInterests;
		this.digitalCertificatesRequested = digitalCertificatesRequested;
		this.digitalCertificatesApproved = digitalCertificatesApproved;
		this.numberOfAllVaccines = numberOfAllVaccines;
		this.firstDoseNumber = firstDoseNumber;
		this.secondDoseNumber = secondDoseNumber;
		this.thirdDoseNumber = thirdDoseNumber;
		this.issuingDate = issuingDate;
		this.manufacturers = manufacturers;
	}
	
	public VaccineReport() {
		super();
	}
	
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	public int getNumberOfInterests() {
		return numberOfInterests;
	}
	public void setNumberOfInterests(int numberOfInterests) {
		this.numberOfInterests = numberOfInterests;
	}
	public int getDigitalCertificatesRequested() {
		return digitalCertificatesRequested;
	}
	public void setDigitalCertificatesRequested(int digitalCertificatesRequested) {
		this.digitalCertificatesRequested = digitalCertificatesRequested;
	}
	public int getDigitalCertificatesApproved() {
		return digitalCertificatesApproved;
	}
	public void setDigitalCertificatesApproved(int digitalCertificatesApproved) {
		this.digitalCertificatesApproved = digitalCertificatesApproved;
	}
	public int getNumberOfAllVaccines() {
		return numberOfAllVaccines;
	}
	public void setNumberOfAllVaccines(int numberOfAllVaccines) {
		this.numberOfAllVaccines = numberOfAllVaccines;
	}
	public int getFirstDoseNumber() {
		return firstDoseNumber;
	}
	public void setFirstDoseNumber(int firstDoseNumber) {
		this.firstDoseNumber = firstDoseNumber;
	}
	public int getSecondDoseNumber() {
		return secondDoseNumber;
	}
	public void setSecondDoseNumber(int secondDoseNumber) {
		this.secondDoseNumber = secondDoseNumber;
	}
	public int getThirdDoseNumber() {
		return thirdDoseNumber;
	}
	public void setThirdDoseNumber(int thirdDoseNumber) {
		this.thirdDoseNumber = thirdDoseNumber;
	}
	public Date getIssuingDate() {
		return issuingDate;
	}
	public void setIssuingDate(Date issuingDate) {
		this.issuingDate = issuingDate;
	}
	public List<ManufacturerInfo> getManufacturers() {
		return manufacturers;
	}
	public void setManufacturers(List<ManufacturerInfo> manufacturers) {
		this.manufacturers = manufacturers;
	}
	
}
