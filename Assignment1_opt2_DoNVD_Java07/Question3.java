package DayOne.Assignment1_opt2_DoNVD_Java07;

import java.util.Scanner;

public class Question3 {
	public static void main(String[] args) {
		System.out.print("Enter n: ");
		Scanner ip = new Scanner(System.in);
		int n = Integer.valueOf(ip.nextLine());
		double sum = 0;
		for(int i=1; i<n+1; i++) {
			int giaithua = 2*i-1;
			double tonggiaithua = 1;
			for(int j=1; j<giaithua+1; j++) {
				tonggiaithua *= j;
			}
			double plus = 1/tonggiaithua;
			sum+= plus;
		}
		System.out.print("S = "+ sum);
	}
}
