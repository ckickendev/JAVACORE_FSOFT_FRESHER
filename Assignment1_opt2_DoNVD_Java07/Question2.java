package DayOne.Assignment1_opt2_DoNVD_Java07;

import java.util.Scanner;

public class Question2 {
	public static void main(String[] args) {
		System.out.print("Enter n: ");
		Scanner ip = new Scanner(System.in);
		int n = Integer.valueOf(ip.nextLine());
		double sum = 0;
		for(double i=1; i<n+1; i++) {
			sum+= 1/i;
		}
		System.out.print("S = "+ sum);
	}
}
