package fa.training.stringbufferdemo;

public class StringBufferExample {
	public void demonstrateStringBuffer() {
		System.out.println("demonstrateStringBuffer() !!!");
		
		StringBuffer buffer = new StringBuffer();

        buffer.append("Hello World!");
        System.out.println(buffer.toString());
         
      
        buffer.delete(5, 11);
        System.out.println(buffer.toString());
         
        buffer.deleteCharAt(5);
        System.out.println(buffer.toString());
         
        buffer.insert(0, "World ");
        System.out.println(buffer.toString());
         
        System.out.println("Index of Hello: " + buffer.indexOf("Hello"));
        System.out.println(); // Empty line         
         
        StringBuffer newBuffer = new StringBuffer("This is a Hello World string. Hello!");
         
        System.out.println("Index of Hello: " + newBuffer.indexOf("Hello"));
        System.out.println("Last index of Hello: " + 
							newBuffer.lastIndexOf("Hello"));
         
        newBuffer.replace(0, 4, "That here");
        System.out.println(newBuffer.toString());
         
        newBuffer.setCharAt(newBuffer.length() - 1, '?');
        System.out.println(newBuffer.toString());
         
        // You can reverse the StringBuffer as well!
        newBuffer.reverse();
        System.out.println(newBuffer.toString());
        comparePerformance();
		
	}
	private static void comparePerformance() {
		long startTime;
		String str = "";
		StringBuffer buffer = new StringBuffer();

		// Using String
		startTime = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			str += "extra";
		}
		System.out.println("Time using String: " + (System.currentTimeMillis() - startTime) + " ms.");

		// Using StringBuffer
		startTime = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			buffer.append("extra");
		}
		System.out.println("Time using StringBuffer: " + (System.currentTimeMillis() - startTime) + " ms.");
	}

}
