package model;

public class SocialCare {
	private boolean isUser;
	private String municipality;
	public SocialCare(boolean isUser, String municipality) {
		super();
		this.isUser = isUser;
		this.municipality = municipality;
	}
	public SocialCare() {
		super();
	}
	public boolean isUser() {
		return isUser;
	}
	public void setUser(boolean isUser) {
		this.isUser = isUser;
	}
	public String getMunicipality() {
		return municipality;
	}
	public void setMunicipality(String municipality) {
		this.municipality = municipality;
	}
	
}
