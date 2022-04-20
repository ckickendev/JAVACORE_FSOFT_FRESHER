package fa.training.hashmapdemo;

import java.util.HashMap;
import java.util.Map;

import fa.training.model.Employee;

public class HashMapCreationExample {
	public void createHashMap() {
		 
		System.out.println("createHashMap() !!!");
 
		Map<String, Integer> numberMapping = new HashMap<>();
 
		numberMapping.put("One", 1);
		numberMapping.put("Two", 2);
		numberMapping.put("Three", 3);
 
		// Add a new key-value pair only if the key does not exist in 
		// the HashMap, or is mapped to `null`
		numberMapping.putIfAbsent("Four", 4);
 
		System.out.println(numberMapping);
	}
 
	/**
	 * Create a HashMap that contains employees
	 * 
	 */
	public void createEmployeeMap() {
		System.out.println("createEmployeeMap() !!!");
		
		Map<Integer, Employee> employeesMap = new HashMap<>();
 
		employeesMap.put(1001, new Employee(1001, "Peter", "London"));
		employeesMap.put(1002, new Employee(1002, "David", "New York"));
		employeesMap.put(1003, new Employee(1003, "Jack Ma", "Hong Kong"));
 
		System.out.println(employeesMap);
	}

}
