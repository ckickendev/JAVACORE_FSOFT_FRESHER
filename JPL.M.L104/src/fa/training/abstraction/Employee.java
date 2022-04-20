package fa.training.abstraction;

import java.util.Scanner;

public abstract class Employee {
	private String name;
	private String dob;
	private String address;
	private static String companyName;
	public abstract double calcSalary();
	protected void inputData(Scanner scanner) {
        System.out.println("Enter name: ");
        name = scanner.nextLine();
        System.out.println("Enter birth date: ");
        dob = scanner.nextLine();
        System.out.println("Address: ");
        address = scanner.nextLine();
    }

	public void display() {
		System.out.print(name + "\t\t" + dob + "\t\t" + address +
				 "\t\t" + companyName);

	};
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public static String getCompanyName() {
        return companyName;
    }
 
    public static void setCompanyName(String companyName) {
        Employee.companyName = companyName;
    }
}
