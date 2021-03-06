package com.exam.entities;

import java.util.Date;

public class Employee extends Citizen{
	private String Job;
	private String Company;
	/**
	 * 	@author DoNVD
	 *	@version 1.0
	 *	@birthday 2001_05_20
	 *	@ex create_constructor_employee
	 */
	public Employee(String citizenID, String name, String address, String phone, Date pCRDate, int type,Date plan, String job,
			String company) {
		super(citizenID, name, address, phone, pCRDate, type,plan);
		Job = job;
		Company = company;
	}
	public String getJob() {
		return Job;
	}
	public void setJob(String job) {
		Job = job;
	}
	public String getCompany() {
		return Company;
	}
	public void setCompany(String company) {
		Company = company;
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
		System.out.println(", Job ="+ Job+ ", Company="+ Company);
	}
	
}
