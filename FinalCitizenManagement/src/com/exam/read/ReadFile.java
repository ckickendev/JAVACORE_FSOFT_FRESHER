package com.exam.read;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.exam.entities.Citizen;
import com.exam.entities.Employee;
import com.exam.entities.Freelance;
import com.exam.entities.Shop;

public class ReadFile {
	ArrayList<Citizen> citizens = new ArrayList<Citizen>();

	public ArrayList<Citizen> handleRead() throws FileNotFoundException, NumberFormatException, ParseException {
		String line = "";
		String splitBy = ",";
		try {
			BufferedReader br = new BufferedReader(new FileReader(
					"C:\\Users\\theso\\eclipse-workspace\\JPL\\FinalCitizenManagement\\src\\com\\exam\\read\\data.csv"));
			while ((line = br.readLine()) != null)
			{
				String[] data = line.split(splitBy); // use comma as separator
				if(Integer.valueOf(data[0]) == 1) {
//					String citizenID, String name, String address, String phone, Date pCRDate,int type, String job
					Freelance freelance = new Freelance(data[1], data[2], data[3], data[4], new SimpleDateFormat("MM/dd/yyyy").parse(data[5]), Integer.valueOf(data[0]),new SimpleDateFormat("MM/dd/yyyy").parse(data[9]), data[6]);
					citizens.add(freelance);
				}else if(Integer.valueOf(data[0]) == 2) {
//					String citizenID, String name, String address, String phone, Date pCRDate, int type, String domain
					Shop shop = new Shop(data[1], data[2], data[3], data[4], new SimpleDateFormat("MM/dd/yyyy").parse(data[5]), Integer.valueOf(data[0]),new SimpleDateFormat("MM/dd/yyyy").parse(data[9]), data[7]);
					citizens.add(shop);
				}else if(Integer.valueOf(data[0]) == 3){
//					String citizenID, String name, String address, String phone, Date pCRDate, int type, String job,String company
					Employee employee = new Employee(data[1], data[2], data[3], data[4], new SimpleDateFormat("MM/dd/yyyy").parse(data[5]), Integer.valueOf(data[0]),new SimpleDateFormat("MM/dd/yyyy").parse(data[9]), data[6], data[8]);
					citizens.add(employee);
				}
			}
//			for(Citizen x : citizens) {
//				x.ShowInfo();
//			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return citizens;
	}
	
//	public static void main(String[] args) throws FileNotFoundException, NumberFormatException, ParseException {
//		new ReadFile().handleRead();
//	}
//	

	public boolean checkPhone(String phone) {
		String regex = "\\d{9}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}";
		return phone.matches(regex);
	}

	public boolean checkMail(String email) {
		String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		return email.matches(regex);
	}

	public ArrayList<Citizen> getCitizens() {
		return citizens;
	}

	public void setStudents(ArrayList<Citizen> citizens) {
		this.citizens = citizens;
	}
}
