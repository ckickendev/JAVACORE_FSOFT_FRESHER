package fa.training.streamfilterdemo;

import java.util.Arrays;
import java.util.List;

import fa.training.model.Person;

public class PersonFilterExample {
	private static Person findPersonByName(List<Person> personList, String name) {
		Person result = null;
		for (Person person : personList) {
			if (name.equals(person.getName())) {
				result = person;
			}
		}
		return result;
	}

	public void showPerson() {
		System.out.println("Filter a collection using traditional method.");
		List<Person> personList = Arrays.asList(new Person("Peter", 30), new Person("Smith", 20),
				new Person("Mary", 40));

		Person result = findPersonByName(personList, "Peter");
		System.out.println(result);
	}

	public void showPersonWithStreamFilter() {
		System.out.println("showPersonWithStreamFilter.");

		List<Person> personList = Arrays.asList(new Person("Peter", 30), new Person("Smith", 20),
				new Person("Mary", 40));

		String name = "Peter";
		Person person1 = personList.stream() // Convert to steam
				.filter(x -> name.equals(x.getName())).findAny().orElse(null);

		System.out.println(person1);

		Person person2 = personList.stream().filter(x -> "Tom".equals(x.getName())).findAny().orElse(null);

		System.out.println(person2);
	}

}
