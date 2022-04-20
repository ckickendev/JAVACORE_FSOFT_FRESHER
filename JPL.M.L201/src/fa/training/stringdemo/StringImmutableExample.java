package fa.training.stringdemo;

public class StringImmutableExample {
	public void demonstrateStringImmutable() {
		System.out.println("demonstrateStringImmutable() !!!");
		String s1 = "Java"; 
		String s2 = s1; 
		System.out.println(s1 == s2); 
		s1 = "Python";
		System.out.println(s1 == s2);
		System.out.println(s2);
	}	

}
