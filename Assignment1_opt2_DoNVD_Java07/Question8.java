package DayOne.Assignment1_opt2_DoNVD_Java07;

import java.util.Scanner;

public class Question8 {
	public static void main(String[] a) {
		int n, sum = 0;
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.print("Enter size: ");
			n = scanner.nextInt();
		} while (n < 0);
		int array[] = new int[n];

		System.out.println("Enter array: ");
		for (int i = 0; i < n; i++) {
			System.out.print("Enter index " + i + " : ");
			array[i] = scanner.nextInt();
		}
		System.out.println("b. Sum of pos and -: " + duongle(array));
		System.out.println("c. Find k: \nEnter k: ");
		int k = scanner.nextInt();
		findk(k, array);
		sort(array);
		System.out.print("d. After sort: ");
		System.out.print("[");
		for(int x: array) {
			System.out.print(" "+x);
		}
		System.out.println("]");
		chen(array);
	}

	public static int duongle(int[] a) {
		int sum = 0;
		for (int x : a) {
			if (x > 0 & x % 2 == 1) {
				sum += x;
			}
		}
		return sum;
	}

	public static void findk(int k, int[] arr) {
		int isFind = 0;
		int index = 0;
		for (int x : arr) {
			index += 1;
			if (x == k) {
				System.out.print("Find k at " + index);
				isFind = 1;
				System.out.println();
			}
		}
		if (isFind == 0) {
			System.out.println("Cannot find out k");
		}

	}

	public static void sort(int[] arr) {
		int n = arr.length;
		int temp = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < (n - i); j++) {
				if (arr[j - 1] > arr[j]) {
					// swap elements
					temp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
	
	public static void chen(int[] arr) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("e. Enter p to insert: ");
		int p = scanner.nextInt();
		int[] arrnew = new int[arr.length+1]; 
		for(int i=0; i<arr.length; i++) {
			arrnew[i] = arr[i];
		}
		arrnew[arrnew.length-1] = p;
		sort(arrnew);
		System.out.println("New array: ");
		System.out.print("[");
		for(int x: arrnew) {
			System.out.print(" "+x);
		}
		System.out.println("]");
		arr = arrnew;
	}
}
