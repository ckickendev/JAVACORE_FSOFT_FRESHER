package fa.training.hashmapdemo.test;

import fa.training.hashmapdemo.HashMapAccessKeyExample;
import fa.training.hashmapdemo.HashMapCreationExample;
import fa.training.hashmapdemo.HashMapIteratorExample;
import fa.training.hashmapdemo.HashMapObtainKeySetExample;
import fa.training.hashmapdemo.HashMapRemoveKeyExample;

public class TestHashMapDemo {
	public static void main(String[] args) {
		HashMapCreationExample hashMapCreation = new HashMapCreationExample();
		HashMapAccessKeyExample hashMapAccess = new HashMapAccessKeyExample();
		HashMapObtainKeySetExample hashMapKeySet = new 
								HashMapObtainKeySetExample();
		HashMapIteratorExample hashMapIterator = new HashMapIteratorExample();
		HashMapRemoveKeyExample hashMapRemove = new HashMapRemoveKeyExample();
		hashMapCreation.createHashMap();
		hashMapCreation.createEmployeeMap();
		hashMapAccess.accessKeys();
		hashMapKeySet.obtainEntryKeySetValues();
		hashMapIterator.iterateHashMap();
		hashMapRemove.removeKeys();
	}

}
