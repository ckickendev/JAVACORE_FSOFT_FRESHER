package fa.training.hashmapdemo;

import java.util.HashMap;
import java.util.Map;

public class HashMapAccessKeyExample {
public void accessKeys() {
		
		System.out.println("accessKeys() !!!");
		
		Map<String, String> userCityMapping = new HashMap<>();
 
        System.out.println("is userCityMapping empty? : " + 
							userCityMapping.isEmpty());
 
        userCityMapping.put("John", "New York");
        userCityMapping.put("Rajeev", "Bengaluru");
        userCityMapping.put("Steve", "London");
 
        System.out.println("userCityMapping HashMap : " +
							 userCityMapping);
 
        System.out.println("We have the city information of " + 
							userCityMapping.size() + " users");
 
        String userName = "Steve";
        if(userCityMapping.containsKey(userName)) {
            // Get the value assigned to a given key in the HashMap
            String city = userCityMapping.get(userName);
            System.out.println(userName + " lives in " + city);
        } else {
            System.out.println("City details not found for user " +
									 userName);
        }
 
        if(userCityMapping.containsValue("New York")) {
            System.out.println("There is a user in the userCityMapping who lives in New York");
        } else {
            System.out.println("There is no user in the userCityMapping who lives in New York");
        }
 
 
        userCityMapping.put(userName, "California");
        System.out.println(userName + " moved to a new city " + 
			userCityMapping.get(userName) + ", New userCityMapping : " + 
			userCityMapping);
 
        System.out.println("Lisa's city : " + userCityMapping.get("Lisa"));
	}

}
