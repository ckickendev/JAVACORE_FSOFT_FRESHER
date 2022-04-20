package fa.training.hashsetdemo.test;

import fa.training.hashsetdemo.HashSetCreationExample;
import fa.training.hashsetdemo.HashSetIterationExample;
import fa.training.hashsetdemo.HashSetRemoveElementExample;
import fa.training.hashsetdemo.HashSetRetrieveElementExample;

public class TestHashSetDemo {
	public static void main(String[] args) {
		HashSetCreationExample hashSetCreation = new HashSetCreationExample();
		HashSetRetrieveElementExample hashSetElements = 
						new HashSetRetrieveElementExample();
		HashSetRemoveElementExample hashSetRemove = 
						new HashSetRemoveElementExample();
		HashSetIterationExample hashSetIterator = 
						new HashSetIterationExample();
		hashSetCreation.createHashSet();
		hashSetElements.retrieveElements();
		System.out.println();
		hashSetRemove.removeElements();
		System.out.println();
		hashSetIterator.hashSetIterator();
	}

}
