package fa.training.stringdemo;

public class StringCountNumberOfWord {
	public void demonstrateCountWord() {
		System.out.println("demonstrateCountWord() !!!");
		
		countNumberOfWords("My name is Admin");
		countNumberOfWords("I love Java Programming");
		countNumberOfWords("This is not properly formatted data");
	}
	
	private static void countNumberOfWords(String str) {		
		String trimmedLine = str.trim();
		int count = trimmedLine.isEmpty() ? 0 : 
						trimmedLine.split("\\s+").length;
		System.out.println(count);
	}

}
