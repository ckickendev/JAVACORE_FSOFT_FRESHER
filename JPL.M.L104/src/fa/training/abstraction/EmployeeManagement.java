package fa.training.abstraction;

import java.util.Scanner;

public class EmployeeManagement {
	public static void main(String[] args) {
		 
        Employee employees[] = new Employee[3];
        ProductionStaff productionStaff = new ProductionStaff();
        DailyStaff dailyStaff = new DailyStaff();
        Manager manager = new Manager();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Employee 1");
        productionStaff.inputData(scanner);
 
        System.out.println("Employee 2");
        dailyStaff.inputData(scanner);
 
        System.out.println("Employee 3");
        manager.inputData(scanner);
 
        Employee.setCompanyName("FPT");
 
        // Push to existed array
        employees[0] = productionStaff;
        employees[1] = dailyStaff;
        employees[2] = manager;
 
        for (Employee employee : employees) {
            employee.display();
        }
        scanner.close();
    }

}

