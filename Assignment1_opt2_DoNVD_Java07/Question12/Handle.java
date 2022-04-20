package DayOne.Assignment1_opt2_DoNVD_Java07.Question12;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Handle {
	ArrayList<Student> students = new ArrayList<Student>();

	public void handleRead() throws FileNotFoundException {
		String line = "";
		String splitBy = ",";
		try {
			// parsing a CSV file into BufferedReader class constructor
			BufferedReader br = new BufferedReader(new FileReader(
					"C:\\\\Users\\\\theso\\\\eclipse-workspace\\\\JavaFsoft\\\\src\\\\DayOne\\\\Assignment1_opt2_DoNVD_Java07\\\\Question12\\\\bai12.csv"));
			while ((line = br.readLine()) != null) // returns a Boolean value
			{
				String[] employee = line.split(splitBy); // use comma as separator
				Student student = new Student(employee[0], employee[1], employee[2], employee[3],
						Integer.valueOf(employee[4]));
				students.add(student);
			}
			printList();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void printList() {
		System.out.println("a. List student from file");
		for(Student x: students) {
			System.out.println(x);
		}
	}
	
	public void checkAndPrintList() {
		System.out.println("b. List student from file and checked");
		int line = 1;
		for(Student x: students) {
			if(checkPhone(x.getStdPhone())== true & checkMail(x.getStdEmail())== true) {
				System.out.println(x);
			}else {
				if(checkPhone(x.getStdPhone())==false && checkMail(x.getStdEmail())== false) {
					System.out.println("Line "+ line+ ": Co loi sai dinh dang StdPhone, StdEmail");
				}else if(checkPhone(x.getStdPhone()) == false) {
					System.out.println(x.getStdPhone());
					System.out.println("Line "+ line+ ": Co loi sai dinh dang StdPhone");
				}else {
					System.out.println("Line "+ line+ ": Co loi sai dinh dang StdEmail");
				}
			}
			line++;
		}
	}

	public boolean checkPhone(String phone) {
		String regex = "\\d{9}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}";
		return phone.matches(regex);
	}

	public boolean checkMail(String email) {
		String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		return email.matches(regex);
	}

	public ArrayList<Student> getStudents() {
		return students;
	}

	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}
	
}
