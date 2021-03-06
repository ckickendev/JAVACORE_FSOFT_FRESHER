package com.exam.run;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.exam.dao.CitizenDAO;
import com.exam.entities.Citizen;
import com.exam.entities.Employee;
import com.exam.entities.Freelance;
import com.exam.entities.Shop;
import com.exam.exception.InputException;
import com.exam.read.ReadFile;
import com.exam.utils.Validator;

public class View {
	static Validator val = new Validator();

	public static void main(String[] args) throws InputException, SQLException {
		CitizenDAO citizenDAO = new CitizenDAO();
		int choice;
		do {
			menu();
			choice = val.checkInputIntLimit(1, 4);
			switch(choice){
				case 1: {
					citizenDAO.addToDatabase();
					break;
				}
				case 2:{
					List<Citizen> citizens = citizenDAO.getAllCitizen();
					for(Citizen x : citizens) {
						if(x instanceof Freelance) {
							Freelance freelance = (Freelance) x;
							freelance.ShowInfo();
						}else if(x instanceof Shop) {
							Shop shop = (Shop) x;
							shop.ShowInfo();
						}else if(x instanceof Employee) {
							Employee em = (Employee) x;
							em.ShowInfo();
						}
					}
					break;
				}
				case 3: {
					System.out.print("Enter ID to update: ");
					String id = val.checkInputString();
					if(citizenDAO.checkCitizenID(id) == 0) {
						System.out.println("Citizen " + id + " does not exist");
					}else {
						citizenDAO.updateBackOne(id);
					}
				}
			}
		}while(choice != 4);
		
	}

	public static void menu() {
		System.out.println("=========Management Citizen=============");
		System.out.println("1. Add to database");
		System.out.println("2. Show all info");
		System.out.println("3. Update citizen");
		System.out.println("4. Exit");
		System.out.println("Enter your select: ");
	}
}
