package fa.training.lambdademo;

public class FunctionalInterfaceExample {
	public void calculateSquare() {
		System.out.println("Calculate Square, Functional Interface !!!");
		int a = 10;
		Square s = (int x) -> x * x;
		int result = s.calculate(a);
		System.out.println(result);
	}

	@FunctionalInterface
	interface Square {
		int calculate(int x);
	}

}
