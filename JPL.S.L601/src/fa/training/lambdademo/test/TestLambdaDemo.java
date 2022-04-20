package fa.training.lambdademo.test;

import fa.training.lambdademo.FunctionalInterfaceExample;
import fa.training.lambdademo.SortingLambdaExample;

public class TestLambdaDemo {
	public static void main(String[] args) {
		SortingLambdaExample sortLambda = new SortingLambdaExample();
		FunctionalInterfaceExample funcInterface = new FunctionalInterfaceExample();
		sortLambda.showUserInfoSortByName();
		sortLambda.showUserInfoSortBySalary();
		sortLambda.showUserInfoSortBySalaryReverse();
		funcInterface.calculateSquare();
	}

}
