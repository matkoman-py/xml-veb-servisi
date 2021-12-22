package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("PATIENT")
public class Patient extends User {
	
	@Column(nullable = false, unique = true)
	private String idNumber;
	
	@Column(nullable = false, unique = true)
	private String passportNumber;
	
	@Column(nullable = true, unique = true)
	private String homePhone;
	
	@Column(nullable = true, unique = true)
	private String mobilePhone;
	
	@Column(nullable = false)
	private String parentName;
	
	@Column(nullable = false)
	private String address;
	
	@Column(nullable = false)
	private String city;
	
	@Column(nullable = false)
	private String state;
	
	@Column(nullable = false)
	private String nationality;
	
	@Column(nullable = false)
	private String birthplace;
	
	public Patient(String email, String password, String name, String surname, Date birthday, UserType type, Gender gender,
			String idNumber, String passportNumber, String homePhone, String mobilePhone, String parentName, String address, String city, String state,
			String nationality, String birthplace) {
		super(email, password, name, surname, birthday, type, gender);
		this.idNumber = idNumber;
		this.passportNumber = passportNumber;
		this.homePhone = homePhone;
		this.mobilePhone = mobilePhone;
		this.parentName = parentName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.nationality = nationality;
		this.birthplace = birthplace;
	}

	public Patient() {
		super();
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}
	
	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getBirthplace() {
		return birthplace;
	}

	public void setBirthplace(String birthplace) {
		this.birthplace = birthplace;
	}
	
}
