package DayOne.Assignment1_opt2_DoNVD_Java07;

import java.util.Scanner;

public class Question7 {
	public static void main(String a[]) {
		System.out.print("Enter string S: ");
		Scanner scanner = new Scanner(System.in);
		String s = scanner.nextLine();
		System.out.println("Original string: " + s);
		reserve(s);
		chuhoa(s);
		chuthuong(s);
		demkity(s);
		System.out.print("Enter n: ");
		int n = Integer.valueOf(scanner.nextLine());
		System.out.print("Enter m: ");
		int m = Integer.valueOf(scanner.nextLine());
		converSubString(s, n, m);
	}

	public static void reserve(String s) {
		StringBuffer sb = new StringBuffer(s);
		sb.reverse();
		String text = sb.toString();
		System.out.println("Question a. ");
		System.out.println("Reversed string: " + text);
	}

	public static void chuhoa(String s) {
		char[] charArray = s.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			if (charArray[i] >= 97 && charArray[i] <= 122) {
				charArray[i] -= 32;
			}
		}
		String text = String.valueOf(charArray);
		System.out.println("Question b: ");
		System.out.println("S to uppercase: " + text);
	}

	public static void chuthuong(String s) {
		char[] charArray = s.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			if (charArray[i] >= 65 && charArray[i] <= 90) {
				charArray[i] += 32;
			}
		}
		String text = String.valueOf(charArray);
		System.out.println("Question c: ");
		System.out.println("S to lowercase: " + text);
	}

	public static void demkity(String str) {
		System.out.println("Question d: ");
		int counter[] = new int[256];
		int len = str.length();
		for (int i = 0; i < len; i++) {
			counter[str.charAt(i)]++;
		}
		char array[] = new char[str.length()];
		for (int i = 0; i < len; i++) {
			array[i] = str.charAt(i);
			int flag = 0;
			for (int j = 0; j <= i; j++) {
				if (str.charAt(i) == array[j])
					flag++;
			}
			if (flag == 1) {
				System.out.println("Number appear of " + str.charAt(i) + " in string :" + counter[str.charAt(i)]);
			}
		}
	}
	
	
	public static void converSubString(String str, int n,int  m) {
		char array[] = new char[m-n+1];
		System.out.println("Question e: ");
		for (int i = 0; i < m-n+1; i++) {
			System.out.print("Array[i]" + str.charAt(i+n));
			array[i] = str.charAt(i+n);
		}
		System.out.print("Substring: \"");
		for(char a: array) {
			System.out.print(a);
		}
		System.out.print("\"");
	}
}
