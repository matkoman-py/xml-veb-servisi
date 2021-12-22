package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;



@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public class User {
	
	@Column(nullable = false, unique = true)
	private String email;
	
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String surname;
	
	@Column(nullable = false)
	private Date birthday;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "type", insertable = false, updatable = false)
	private UserType type;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "gender", insertable = false, updatable = false)
	private Gender gender;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public UserType getType() {
		return type;
	}

	public void setType(UserType type) {
		this.type = type;
	}
	
	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public User(String email, String password, String name, String surname, Date birthday, UserType type, Gender gender) {
		super();
		this.email = email;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.birthday = birthday;
		this.type = type;
		this.gender = gender;
	}

	public User() {
		super();
	}
	
	
}
