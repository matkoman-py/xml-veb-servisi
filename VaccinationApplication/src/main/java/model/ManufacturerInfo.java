package model;

public class ManufacturerInfo {
	private String manufacturer;
	private int givenDoses;
	public ManufacturerInfo(String manufacturer, int givenDoses) {
		super();
		this.manufacturer = manufacturer;
		this.givenDoses = givenDoses;
	}
	public ManufacturerInfo() {
		super();
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public int getGivenDoses() {
		return givenDoses;
	}
	public void setGivenDoses(int givenDoses) {
		this.givenDoses = givenDoses;
	}
	
}
