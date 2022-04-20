package fa.training.sortingdemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListSortingExample {
	public void sortArrayList() {
		System.out.println("sortArrayList() !!!");
 
		List<String> fruits = new ArrayList<String>();
 
		fruits.add("Pineapple");
		fruits.add("Apple");
		fruits.add("Orange");
		fruits.add("Banana");
 
		Collections.sort(fruits);
 
		int i = 0;
		for (String temp : fruits) {
			System.out.println("fruits " + ++i + " : " + temp);
		}
	}

}
