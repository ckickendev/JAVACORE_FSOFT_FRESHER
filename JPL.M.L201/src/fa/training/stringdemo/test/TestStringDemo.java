package fa.training.stringdemo.test;

import fa.training.stringdemo.StringCountNumberOfWord;
import fa.training.stringdemo.StringImmutableExample;
import fa.training.stringdemo.StringMethodExample;

public class TestStringDemo {
	public static void main(String[] args) {
		StringImmutableExample stringImmutable = new StringImmutableExample();
		StringMethodExample stringMethod = new StringMethodExample();
		StringCountNumberOfWord countWord = new StringCountNumberOfWord();
		stringImmutable.demonstrateStringImmutable();
		System.out.println();
		stringMethod.demonstrateStringMethod();
		System.out.println();
		countWord.demonstrateCountWord();
		System.out.println();
	}

}
