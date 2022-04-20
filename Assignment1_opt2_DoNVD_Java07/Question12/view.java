package DayOne.Assignment1_opt2_DoNVD_Java07.Question12;

import java.io.FileNotFoundException;

public class view {
	public static void main(String[] args) throws FileNotFoundException {
		Handle handle = new Handle();
		handle.handleRead();
		handle.checkAndPrintList();
//		System.out.print(handle.checkPhone("905223245"));
//		System.out.print(handle.checkPhone("905869357"));
//		System.out.print(handle.checkPhone("919515090"));
	}
}
