package model.documents;

import java.util.Date;

import model.Patient;
import model.Profession;
import model.SocialCare;
import model.TemporaryContraindication;
import model.User;
import model.VaccinationInfo;
import model.WorkStatus;

public class VaccineConsent {
	
	private Patient patient;
	private WorkStatus workStatus;
	private Profession profession;
	private SocialCare socialCare;
	private boolean givenConsent;
	private String vaccineName;
	private Date date;
	
	
	private String vaccinationPunct;
	private User healthcareWorker;
	private VaccinationInfo firstDose;
	private VaccinationInfo secondDose;
	private TemporaryContraindication temporaryContraindication;

	public VaccineConsent(Patient patient, WorkStatus workStatus, Profession profession, SocialCare socialCare,
			boolean givenConsent, String vaccineName, Date date) {
		super();
		this.patient = patient;
		this.workStatus = workStatus;
		this.profession = profession;
		this.socialCare = socialCare;
		this.givenConsent = givenConsent;
		this.vaccineName = vaccineName;
		this.date = date;
	}

	public VaccineConsent() {
		super();
	}

	public VaccineConsent(Patient patient, WorkStatus workStatus, Profession profession, SocialCare socialCare,
			boolean givenConsent, String vaccineName, Date date, String vaccinationPunct,
			User healthcareWorker, VaccinationInfo firstDose, VaccinationInfo secondDose,
			TemporaryContraindication temporaryContraindication) {
		super();
		this.patient = patient;
		this.workStatus = workStatus;
		this.profession = profession;
		this.socialCare = socialCare;
		this.givenConsent = givenConsent;
		this.vaccineName = vaccineName;
		this.date = date;
		this.vaccinationPunct = vaccinationPunct;
		this.healthcareWorker = healthcareWorker;
		this.firstDose = firstDose;
		this.secondDose = secondDose;
		this.temporaryContraindication = temporaryContraindication;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public WorkStatus getWorkStatus() {
		return workStatus;
	}

	public void setWorkStatus(WorkStatus workStatus) {
		this.workStatus = workStatus;
	}

	public Profession getProfession() {
		return profession;
	}

	public void setProfession(Profession profession) {
		this.profession = profession;
	}

	public SocialCare getSocialCare() {
		return socialCare;
	}

	public void setSocialCare(SocialCare socialCare) {
		this.socialCare = socialCare;
	}

	public boolean isGivenConsent() {
		return givenConsent;
	}

	public void setGivenConsent(boolean givenConsent) {
		this.givenConsent = givenConsent;
	}

	public String getVaccineName() {
		return vaccineName;
	}

	public void setVaccineName(String vaccineName) {
		this.vaccineName = vaccineName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getVaccinationPunct() {
		return vaccinationPunct;
	}

	public void setVaccinationPunct(String vaccinationPunct) {
		this.vaccinationPunct = vaccinationPunct;
	}

	public User getHealthcareWorker() {
		return healthcareWorker;
	}

	public void setHealthcareWorker(User healthcareWorker) {
		this.healthcareWorker = healthcareWorker;
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

	public TemporaryContraindication getTemporaryContraindication() {
		return temporaryContraindication;
	}

	public void setTemporaryContraindication(TemporaryContraindication temporaryContraindication) {
		this.temporaryContraindication = temporaryContraindication;
	}
	
	
}
