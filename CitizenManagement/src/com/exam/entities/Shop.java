package com.exam.entities;

import java.util.Date;

public class Shop extends Citizen{
	private String Domain;
	/**
	 * 	@author DoNVD
	 *	@version 1.0
	 *	@birthday 2001_05_20
	 *	@ex create_constructor_Shop
	 */
	public Shop(String citizenID, String name, String address, String phone, Date pCRDate, int type, String domain) {
		super(citizenID, name, address, phone, pCRDate, type);
		Domain = domain;
	}

	public String getDomain() {
		return Domain;
	}

	public void setDomain(String domain) {
		Domain = domain;
	}
	/**
	 * 	@author DoNVD
	 *	@version 1.0
	 *	@birthday 2001_05_20
	 *	@ex override_showinfo_method
	 */
	@Override
	public void ShowInfo() {
		super.ShowInfo();
		System.out.println(", Domain ="+ Domain);
	}
	
}
