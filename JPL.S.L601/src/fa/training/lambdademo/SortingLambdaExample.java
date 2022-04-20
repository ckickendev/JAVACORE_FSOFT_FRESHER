package fa.training.lambdademo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import fa.training.model.User;

public class SortingLambdaExample {
	private static List<User> getUsers() {
		List<User> users = new ArrayList<User>();
		users.add(new User("Peter", 5000, 33));
		users.add(new User("Mary", 2000, 20));
		users.add(new User("John", 1500, 10));
		users.add(new User("Ivan", 2300, 55));
		return users;
	}

	public void showUserInfoSortByName() {
		List<User> users = getUsers();
		System.out.println("Before Sort");
		for (User user : users) {
			System.out.println(user);
		}

		System.out.println("After Sort");
		System.out.println("Sort by name");
		users.sort((user1, user2) -> user1.getName().compareTo(user2.getName()));
		users.forEach((user) -> System.out.println(user));
	}

	public void showUserInfoSortBySalary() {
		List<User> users = getUsers();
		System.out.println("Before Sort");
		for (User user : users) {
			System.out.println(user);
		}

		System.out.println("After Sort");
		Comparator<User> salaryComparator = (o1, o2) -> (o1.getSalary() > o2.getSalary() ? 1 : -1);
		users.sort(salaryComparator);
		// display data
		System.out.println("Sort by salary");
		users.forEach((user) -> System.out.println(user));
	}

	public void showUserInfoSortBySalaryReverse() {
		List<User> users = getUsers();
		System.out.println("Before Sort");
		for (User user : users) {
			System.out.println(user);
		}

		System.out.println("After Sort");
		// Sort by salary
		Comparator<User> salaryComparator = (o1, o2) -> (o1.getSalary() > o2.getSalary() ? 1 : -1);
		users.sort(salaryComparator.reversed());
		// display data
		System.out.println("Sort by salary, reverse order");
		users.forEach((user) -> System.out.println(user));
	}

}
