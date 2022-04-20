package fa.training.streamfilterdemo;

import java.util.HashMap;
import java.util.Map;

public class FilterMapByKeyExample {
	public void filterMapByKey() {
		System.out.println("filterMapByKey() !!!");
 
		Map<String, String> mapCountries = new HashMap<>();
 
		mapCountries.put("de", "Germany");
		mapCountries.put("hu", "Hungary");
		mapCountries.put("sk", "Slovakia");
		mapCountries.put("si", "Slovenia");
		mapCountries.put("so", "Somalia");
		mapCountries.put("us", "United States");
		mapCountries.put("ru", "Russia");
 
		mapCountries.entrySet().stream()
			.filter(map -> map.getKey().startsWith("s"))
			.forEach(m -> System.out.println(m));
	}

}
