package hello;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class HelloController {
    
	Map<String, Contact> contactList;
	
	
    public HelloController() {
    	contactList = new HashMap<String, Contact>();
    	contactList.put("3761520879", new Contact("William", "Smith", "williams123@gmail.com", "3761520879"));
    	contactList.put("2738098078", new Contact("Daniel", "Moore", "daniel.moore@gmail.com", "2738098078"));
    	contactList.put("4920173829", new Contact("David", "Harris", "davidharris90@gmail.com", "4920173829"));
    	contactList.put("2910287352", new Contact("Linda", "Nelson", "linda2004@gmail.com", "2910287352"));
    	contactList.put("4891092648", new Contact("Sarah", "Parker", "sarah.parker12@gmail.com", "4891092648"));
	}


	@RequestMapping("/")
    public String index() {
        return "Greetings from manju!";
    }
    
    
    @RequestMapping(value="/contacts" , method= RequestMethod.GET)
    public Map<String, Contact> getMatchedContactList(@RequestParam(value="firstName", required= false) String firstName) {
    	
    	if(firstName != null) {
    		Map<String, Contact> matchedContactList = new HashMap<String, Contact>();
        	for(Map.Entry<String, Contact> mapEntry: contactList.entrySet()) {
        		String objectValue =mapEntry.getValue().getFirstName();
        		String key = mapEntry.getKey();
        		Contact value = mapEntry.getValue();
        		if(objectValue.equalsIgnoreCase(firstName)) {
        			matchedContactList.put(key, value);
        		}
        	}
        	return matchedContactList;
    	} else {
    		return contactList;
    	}
    	
    }
    
    
    @RequestMapping(value = "/contacts/{phoneNumber}" , method= RequestMethod.DELETE)
    public void deleteContactFromList(@PathVariable("phoneNumber") String CtPhoneNumber) {
    	contactList.remove(CtPhoneNumber);
    }
    
    @RequestMapping(value = "/contacts", method = RequestMethod.POST)
    public Contact creatingAContact(@RequestBody Contact contact) {
    	 contactList.put(contact.getPhoneNumber(), contact);
    	 return contactList.get(contact.getPhoneNumber());
    }
}
