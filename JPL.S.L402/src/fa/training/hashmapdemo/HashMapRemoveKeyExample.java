package fa.training.hashmapdemo;

import java.util.HashMap;
import java.util.Map;

public class HashMapRemoveKeyExample {
	public void removeKeys() {
		
		System.out.println("removeKeys() !!!");
		
		Map<String, String> husbandWifeMapping = new HashMap<>();
		husbandWifeMapping.put("Jack", "Marie");
		husbandWifeMapping.put("Chris", "Lisa");
		husbandWifeMapping.put("Steve", "Jennifer");
 
		System.out.println("Husband-Wife Mapping : " + husbandWifeMapping);
 
		String husband = "Chris";
		String wife = husbandWifeMapping.remove(husband);
 
		System.out.println("Couple (" + 
					husband + " => " + wife + ") got divorced");
		System.out.println("New Mapping : " +
					husbandWifeMapping);
 
		boolean isRemoved = husbandWifeMapping.remove("Jack", "Linda");
		System.out.println("Did Jack get removed from the mapping? : " + 
									isRemoved);
 
		wife = husbandWifeMapping.remove("David");
		if (wife == null) {
			System.out.println("Looks like David is not married to anyone");
		} else {
			System.out.println("Removed David and his wife from the mapping");
		}
	}

}
