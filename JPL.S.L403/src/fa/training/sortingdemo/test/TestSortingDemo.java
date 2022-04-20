package fa.training.sortingdemo.test;

import fa.training.sortingdemo.ArrayListSortingExample;
import fa.training.sortingdemo.ArraySortingExample;
import fa.training.sortingdemo.SortingComparableExample;
import fa.training.sortingdemo.SortingComparatorExample;

public class TestSortingDemo {
	public static void main(String[] args) {
		ArraySortingExample arraySort = new ArraySortingExample();
		ArrayListSortingExample arrayListSort = new ArrayListSortingExample();
		SortingComparableExample comparableSort = new SortingComparableExample();
		SortingComparatorExample comparatorSort = new SortingComparatorExample();
		arraySort.sortArray();
		arrayListSort.sortArrayList();
		comparableSort.sortElementWithComparable();
		comparatorSort.sortElementComparator();
	}

}
