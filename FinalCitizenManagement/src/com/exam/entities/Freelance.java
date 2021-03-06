package com.exam.entities;

import java.util.Date;

public class Freelance extends Citizen{
	private String Job;
	/**
	 * 	@author DoNVD
	 *	@version 1.0
	 *	@birthday 2001_05_20
	 *	@ex create_constructor_Freelance
	 */
	public Freelance(String citizenID, String name, String address, String phone, Date pCRDate,int type,Date plan, String job) {
		super(citizenID, name, address, phone, pCRDate, type, plan);
		Job = job;
	}

	public String getJob() {
		return Job;
	}

	public void setJob(String job) {
		Job = job;
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
		System.out.println(", Job ="+ Job);
	}
	
}
