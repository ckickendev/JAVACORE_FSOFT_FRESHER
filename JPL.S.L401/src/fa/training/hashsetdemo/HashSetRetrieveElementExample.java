package fa.training.hashsetdemo;

import java.util.HashSet;
import java.util.Set;

public class HashSetRetrieveElementExample {
	public void retrieveElements() {

		System.out.println("retrieveElements() !!!");

		Set<String> brands = new HashSet<>();

		brands.add("Wilson");
		brands.add("Nike");
		brands.add("Volvo");
		brands.add("Kia");
		brands.add("Lenovo");

		if (brands.contains("Wilson")) {
			System.out.println("The set contains the Wilson element");
		} else {
			System.out.println("The set does not contain the Wilson element");
		}

		if (brands.contains("Apple")) {
			System.out.println("The set contains the Apple element");
		} else {
			System.out.println("The set does not contain the Apple element");
		}

		brands.clear();
		if (brands.isEmpty()) {
			System.out.println("The set does not contain any elements.");
		}
	}

}
