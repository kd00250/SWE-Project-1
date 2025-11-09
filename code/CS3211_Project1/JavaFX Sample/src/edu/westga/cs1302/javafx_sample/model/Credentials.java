package edu.westga.cs1302.javafx_sample.model;

/**
 * The Credentials enum class
 * 
 * @author CS3211
 * @version Fall 2025
 */
public enum Credentials {
	
	CREWMATE_USERNAME("PirateBob"),
	CREWMATE_PASSWORD("password123"),
	QUARTERMASTER_USERNAME("MasterTim"),
	QUARTERMASTER_PASSWORD("red5");
	
	private final String value;
	
	/**
	 * Constructor for enum Credentials
	 * 
	 * @param value the value of the user
	 */
	Credentials(String value) {
		this.value = value;
	}
	
	/**
	 * Gets the value of the Credential
	 * 
	 * @return the value of the credential
	 */
	public String getValue() {
		return this.value;
	}
}
