package fa.training.hashsetdemo;

import java.util.HashSet;
import java.util.Set;

public class HashSetCreationExample {
	public void createHashSet() {

		System.out.println("createHashSet() !!!");
		Set<String> brands = new HashSet<>();
		brands.add("Wilson");
		brands.add("Nike");
		brands.add("Volvo");
		brands.add("IBM");
		brands.add("IBM");

		int nOfElements = brands.size();

		System.out.format("The set contains %d elements%n", nOfElements);
		System.out.println(brands);
	}

}
