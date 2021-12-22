package model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Vaccine {
	
	@Column(nullable = false, unique = true)
	private String name;
	
	@Column(nullable = false, unique = true)
	private String manufacturer;
	
	@Column(nullable = false)
	private int quantity;
	
	@Column(nullable = true)
	private String sideEffects;
	
	public Vaccine(String name, String manufacturer, int quantity, String sideEffects) {
		super();
		this.name = name;
		this.manufacturer = manufacturer;
		this.quantity = quantity;
		this.sideEffects = sideEffects;
	}

	public Vaccine() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getSideEffects() {
		return sideEffects;
	}

	public void setSideEffects(String sideEffects) {
		this.sideEffects = sideEffects;
	}
	
}
