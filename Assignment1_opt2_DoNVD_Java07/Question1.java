package DayOne.Assignment1_opt2_DoNVD_Java07;

import java.util.Scanner;

public class Question1 {
	public static void main(String[] args) {
		System.out.print("Enter your height: ");
		Scanner ip = new Scanner(System.in);
		int height = Integer.valueOf(ip.nextLine());
		for(int i=1; i<height+1; i++) {
			for(int j=1; j<i+1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
