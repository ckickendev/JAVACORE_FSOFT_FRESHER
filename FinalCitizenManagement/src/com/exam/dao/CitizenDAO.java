package com.exam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.exam.entities.Citizen;
import com.exam.entities.Employee;
import com.exam.entities.Freelance;
import com.exam.entities.Shop;
import com.exam.exception.DateException;
import com.exam.read.ReadFile;
import com.exam.utils.DBUtils;


public class CitizenDAO {
	List<Citizen> citizens = new ArrayList<>();
	Connection connection;
	PreparedStatement preparedStatement = null;
	ResultSet results = null; 
	
	public void addToDatabase() throws SQLException {
		try {
			List<Citizen> citizens = new ReadFile().handleRead();
			for(Citizen x: citizens) {
				System.out.println(x);
				if(!x.getPhone().matches("^[0]{1}[0-9]{9,10}")) {
					System.out.println(x.getPhone());
					System.out.println("Phone number must start with 0 and have 10 or 11 number digit!!!");
					continue;
				}
				Date now = new Date();
				if(now.compareTo(x.getPCRDate())<0) {
					
				}
				if(checkCitizenID(x.getCitizenID()) == 1 ) {
					System.out.println("Citizen " + x.getCitizenID() + " has duplicate ID");
					continue;
				}
				if(x instanceof Freelance) {
					Freelance freelance = (Freelance) x;
					addFreelance(freelance);
				}else if(x instanceof Shop) {
					Shop shop = (Shop) x;
					addShop(shop);
				}else if(x instanceof Employee) {
					Employee em = (Employee) x;
					addEmployee(em);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateBackOne(String id) {
		try {
			connection = new DBUtils().getConnect();
			preparedStatement = connection.prepareStatement("update Citizen set InjectionPlanDate =datefromparts(year(InjectionPlanDate), month(InjectionPlanDate), day(InjectionPlanDate)-1) where CitizenID =?");
			preparedStatement.setString(1, id);
			preparedStatement.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
//		update t
//	    set RegisterDate = datefromparts(year(RegisterDate), month(RegisterDate), 2);
	}
	
	public int checkCitizenID(String id) {
//		System.out.println("Dang check id"+ id);
		int check =0;
		try {
			connection = new DBUtils().getConnect();
			preparedStatement = connection.prepareStatement("select * from Citizen where CitizenID =?");
			preparedStatement.setString(1, id);
			results = preparedStatement.executeQuery();
			if(results.next()) {
				check =1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}
	public void addFreelance(Freelance free) throws SQLException {
		try {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			connection = new DBUtils().getConnect();
			preparedStatement = connection.prepareStatement("insert into Citizen(Type, CitizenID, Name, Address, Phone, PCRDate,Job,InjectionPlanDate) values (?,?,?,?,?,?,?,?)");
			preparedStatement.setInt(1,free.getType());
			preparedStatement.setString(2,free.getCitizenID());
			preparedStatement.setString(3,free.getName());
			preparedStatement.setString(4,free.getAddress());
			preparedStatement.setString(5,free.getPhone());
			preparedStatement.setString(6,dateFormat.format(free.getPCRDate()));
			preparedStatement.setString(7,free.getJob());
			preparedStatement.setString(8, dateFormat.format(free.getInjectionPlanDate()));
			preparedStatement.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addShop(Shop citizen) throws SQLException {
		try {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			connection = new DBUtils().getConnect();
			preparedStatement = connection.prepareStatement("insert into Citizen(Type, CitizenID, Name, Address, Phone, PCRDate,Domain,InjectionPlanDate) values (?,?,?,?,?,?,?,?)");
			preparedStatement.setInt(1,citizen.getType());
			preparedStatement.setString(2,citizen.getCitizenID());
			preparedStatement.setString(3,citizen.getName());
			preparedStatement.setString(4,citizen.getAddress());
			preparedStatement.setString(5,citizen.getPhone());
			preparedStatement.setString(6,dateFormat.format(citizen.getPCRDate()));
			preparedStatement.setString(7,citizen.getDomain());
			preparedStatement.setString(8, dateFormat.format(citizen.getInjectionPlanDate()));
			preparedStatement.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addEmployee(Employee citizen) throws SQLException {
		try {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			connection = new DBUtils().getConnect();
			preparedStatement = connection.prepareStatement("insert into Citizen(Type, CitizenID, Name, Address, Phone, PCRDate,Job,Company,InjectionPlanDate) values (?,?,?,?,?,?,?,?,?)");
			preparedStatement.setInt(1,citizen.getType());
			preparedStatement.setString(2,citizen.getCitizenID());
			preparedStatement.setString(3,citizen.getName());
			preparedStatement.setString(4,citizen.getAddress());
			preparedStatement.setString(5,citizen.getPhone());
			preparedStatement.setString(6,dateFormat.format(citizen.getPCRDate()));
			preparedStatement.setString(7,citizen.getJob());
			preparedStatement.setString(8,citizen.getCompany());
			preparedStatement.setString(9, dateFormat.format(citizen.getInjectionPlanDate()));
			preparedStatement.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Citizen> getAllCitizen() {
		List<Citizen> citizens = new ArrayList<Citizen>();
		try {
			connection = new DBUtils().getConnect();
			preparedStatement = connection.prepareStatement("select * from Citizen");
			results = preparedStatement.executeQuery();
			if(results.next()) {
				if(Integer.valueOf(results.getString(0)) == 1) {
					Freelance free = new Freelance(results.getString(1),results.getString(2), results.getString(3), results.getString(4), new SimpleDateFormat("MM/dd/yyyy").parse(results.getString(5)), Integer.valueOf(results.getString(0)), new SimpleDateFormat("MM/dd/yyyy").parse(results.getString(9)), results.getString(6));
					citizens.add(free);
				}else if(Integer.valueOf(results.getString(0))==2) {
					Shop shop = new Shop(results.getString(1),results.getString(2), results.getString(3), results.getString(4), new SimpleDateFormat("MM/dd/yyyy").parse(results.getString(5)), Integer.valueOf(results.getString(0)), new SimpleDateFormat("MM/dd/yyyy").parse(results.getString(9)), results.getString(7));
					citizens.add(shop);
				}else if(Integer.valueOf(results.getString(0))==3) {
					Employee employee = new Employee(results.getString(1),results.getString(2), results.getString(3), results.getString(4), new SimpleDateFormat("MM/dd/yyyy").parse(results.getString(5)), Integer.valueOf(results.getString(0)), new SimpleDateFormat("MM/dd/yyyy").parse(results.getString(9)),results.getString(6), results.getString(8));
					citizens.add(employee);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return citizens;
	}
	
}
