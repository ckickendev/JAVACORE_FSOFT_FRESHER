package com.exam.entities;
import java.util.Date;

public class Citizen {
	private String CitizenID;
	private String Name;
	private String Address;
	private String Phone;
	private Date PCRDate;
	private int type;
	
	/**
	 * 	@author DoNVD
	 *	@version 1.0
	 *	@birthday 2001_05_20
	 *	@ex create_constructor_citizen
	 */
	public Citizen(String citizenID, String name, String address, String phone, Date pCRDate, int type) {
		super();
		CitizenID = citizenID;
		Name = name;
		Address = address;
		Phone = phone;
		PCRDate = pCRDate;
		this.type = type;
	}
	public String getCitizenID() {
		return CitizenID;
	}
	public void setCitizenID(String citizenID) {
		CitizenID = citizenID;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public Date getPCRDate() {
		return PCRDate;
	}
	public void setPCRDate(Date pCRDate) {
		PCRDate = pCRDate;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	/**
	 * 	@author DoNVD
	 *	@version 1.0
	 *	@birthday 2001_05_20
	 *	@ex create_showinfo_function
	 */
	public void ShowInfo() {
		System.out.print("Citizen : CitizenID=" + CitizenID + ", Name=" + Name + ", Address=" + Address + ", Phone=" + Phone
				+ ", PCRDate=" + PCRDate + ", type=" + type);
	}
	
	
}
