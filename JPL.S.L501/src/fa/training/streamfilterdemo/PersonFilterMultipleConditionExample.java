package fa.training.streamfilterdemo;

import java.util.Arrays;
import java.util.List;

import fa.training.model.Person;

public class PersonFilterMultipleConditionExample {
	public void filterMultipleCondition() {

		System.out.println("filterMultipleCondition() !!!");

		List<Person> personList = Arrays.asList(new Person("Peter", 30), new Person("Smith", 20),
				new Person("Mary", 40));

		Person person1 = personList.stream().filter((p) -> "Peter".equals(p.getName()) && 30 == p.getAge()).findAny()
				.orElse(null);

		System.out.println("Person 1 :" + person1);

		Person person2 = personList.stream().filter(p -> {
			if ("Peter".equals(p.getName()) && 30 == p.getAge()) {
				return true;
			}
			return false;
		}).findAny().orElse(null);

		System.out.println("Person 1 :" + person2);
	}

}
