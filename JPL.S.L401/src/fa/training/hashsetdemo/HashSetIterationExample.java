package fa.training.hashsetdemo;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetIterationExample {
	public void hashSetIterator() {
		 
		System.out.println("hashSetIterator() !!!");
 
		Set<String> brands = new HashSet<>();
 
		brands.add("Wilson");
		brands.add("Nike");
		brands.add("Volvo");
		brands.add("Kia");
		brands.add("Lenovo");
 
		Iterator<String> it = brands.iterator();
 
		while (it.hasNext()) {
			String element = it.next();
			System.out.println(element);
		}
 
	}

}
