package DayOne.Assignment1_opt2_DoNVD_Java07;

import java.util.Scanner;

public class Question5 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a = ");
		int a = scanner.nextInt();
		System.out.print("Enterg b = ");
		int b = scanner.nextInt();
		System.out.println("USCLN of " + a + " and " + b + " is: " + USCLN(a, b));
		System.out.println("BSCNN of " + a + " and " + b + " is: " + BSCNN(a, b));
	}

	public static int USCLN(int a, int b) {
		int temp1 = a;
		int temp2 = b;
		while (temp1 != temp2) {
			if (temp1 > temp2) {
				temp1 -= temp2;
			} else {
				temp2 -= temp1;
			}
		}
		int uscln = temp1;
		return uscln;
	}

	public static int BSCNN(int a, int b) {
		return (a * b) / USCLN(a, b);
	}
}
