package DayOne.Assignment1_opt2_DoNVD_Java07;

import java.util.Scanner;

public class Question4 {
	public static void main(String[] args) {
		System.out.print("Enter n: ");
		Scanner ip = new Scanner(System.in);
		int num = Integer.valueOf(ip.nextLine());
		int tong = 0;
		int tich = 1;
		int count =0;
		int temp = num;
		int digit =0;
		while(num > 0) {
			num = num / 10;
            count++;
		}
		while(temp > 0)
        {
            digit = temp % 10;
            tong += digit;
            tich *= digit;
            temp = temp / 10;
            count--;
        }
		System.out.println("Tong = " + tong);
		System.out.println("Tich = " + tich);
		
	}
}
