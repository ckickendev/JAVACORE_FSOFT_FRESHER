package DayOne.Assignment1_opt2_DoNVD_Java07;

import java.util.Scanner;

public class Question6 {
	public static void convertBinary(int num) {
		int binary[] = new int[40];
		int index = 0;
		while (num > 0) {
			binary[index++] = num % 2;
			num = num / 2;
		}
		for (int i = index - 1; i >= 0; i--) {
			System.out.print(binary[i]);
		}
		System.out.println();
	}

	public static void main(String a[]) {
		System.out.print("Enter value: ");
		Scanner scanner = new Scanner(System.in);
		int converNumber = Integer.valueOf(scanner.nextLine());
		System.out.print("Value binary of " + converNumber + " is ");
		convertBinary(converNumber);
	}
}
