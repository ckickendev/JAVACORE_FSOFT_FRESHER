package fa.training.streamfilterdemo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import fa.training.model.Person;

public class PersonFilterMapExample {
public void filterAndMap() {
		
		System.out.println("filterAndMap() !!!");
		List<Person> personList = Arrays.asList(
				new Person("Peter", 30), 
				new Person("Smith", 20),
				new Person("Mary", 40));
		
		String name = personList.stream()
                .filter(x -> "Peter".equals(x.getName()))
                .map(Person::getName)                        
                .findAny()
                .orElse("");
 
        System.out.println("Name : " + name);
 
        List<String> collect = personList.stream()
                .map(Person::getName)
                .collect(Collectors.toList());
 
        collect.forEach(System.out::println);
	}

}
