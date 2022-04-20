package fa.training.hashsetdemo;

import java.util.HashSet;
import java.util.Set;

public class HashSetRemoveElementExample {
	public void removeElements() {
		System.out.println("removeElements() !!!");

		Set<String> brands = new HashSet<>();

		brands.add("Wilson");
		brands.add("Nike");
		brands.add("Volvo");
		brands.add("Kia");
		brands.add("Lenovo");

		Set<String> brands2 = new HashSet<>();

		brands2.add("Wilson");
		brands2.add("Nike");
		brands2.add("Volvo");

		System.out.println(brands);

		brands.remove("Kia");
		brands.remove("Lenovo");

		System.out.println(brands);

		brands.removeAll(brands2);

		System.out.println(brands);

		if (brands.isEmpty()) {
			System.out.println("The brands set is empty");
		}
	}

}
