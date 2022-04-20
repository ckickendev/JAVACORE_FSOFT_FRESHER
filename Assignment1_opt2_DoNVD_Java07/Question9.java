package DayOne.Assignment1_opt2_DoNVD_Java07;

import java.util.Scanner;

public class Question9 {
	public static void main(String[] a) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter n: ");
		int n = scanner.nextInt();
		System.out.print("Enter m: ");
		int m = scanner.nextInt();
		int[][] arr = new int[n][m];
		System.out.println("a. Enter for array: ");
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				System.out.print("Enter value in array[" +i+"]["+ j +"] : ");
				arr[i][j] = scanner.nextInt();
			}
		}
		int tich = 1;
		for(int i=0; i<m; i++) {
			if(arr[0][i] %3 ==0) {
				tich*=arr[0][i];
			}
		}
		System.out.println("b. Volume: " + tich);
		int[] arrmax = new int[n];
		int index=0;
		for(int i=0; i<n; i++) {
			int max = arr[i][0];
			for(int j=0; j<m; j++) {
				if(max < arr[i][j]) {
					max = arr[i][j];
				}
			}
			arrmax[index] =max;
			index++;
		}
		System.out.print("c. Array: [");
		for(int x: arrmax) {
			System.out.print(" "+ x + " ");
		}
		System.out.print("]");
	}
}
