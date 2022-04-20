package fa.training.abstraction;

import java.util.Scanner;

public class Manager extends Employee{
	private double wage;
    private double basicSalary;
 
    @Override
    public double calcSalary() {
        return wage * basicSalary;
    }
 
    @Override
    public void inputData(Scanner scanner) {
        /*
         * Call inputData method from parent class.
         */
        super.inputData(scanner);
 
        System.out.println("Enter wage: ");
        wage = Double.parseDouble(scanner.nextLine());
 
        System.out.println("Enter basic salary: ");
        basicSalary = Double.parseDouble(scanner.nextLine());
 
        System.out.println("---------------------------");
    }
 
    @Override
    public void display() {
        // Call method of parent class
        super.display();
        System.out.print("\t\t" + wage + "\t\t" + basicSalary + "\t\t" + 
								this.calcSalary() + "\n");
    }

}
