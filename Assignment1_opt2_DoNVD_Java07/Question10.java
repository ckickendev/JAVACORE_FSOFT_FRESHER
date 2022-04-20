package DayOne.Assignment1_opt2_DoNVD_Java07;

import java.util.Arrays;

public class Question10 {
	public static void main(String[] args) {
		int num = 10;
		Test obj1 = new Test();
		obj1.setItem("changed");
		Test obj2 = new Test();
		int[] array = { 1, 2 }; // [1, 2]

		changeStuff(num, obj1, obj2, array);
		System.out.println(num);
		System.out.println(obj1.item);
		System.out.println(obj2.item);
		System.out.println(Arrays.toString(array));
	}

	public static void changeStuff(int a, Test b, Test c, int[] d) {
		a = a * 10;
		b = new Test();
		c.item = "changed";
		d[0] = 3;
	}

	public static class Test {
		public String item = "unchanged";
		public Test() {
			super();
		}
		public String getItem() {
			return item;
		}
		public void setItem(String item) {
			this.item = item;
		}
		
		
	}
}
