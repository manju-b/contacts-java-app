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
    
	ContactList ctList;
	
	
    public HelloController() {
    	ctList = new ContactList();
    }


	@RequestMapping("/")
    public String index() {
        return "Greetings from manju!";
    }
    
    
    @RequestMapping(value="/contacts" , method= RequestMethod.GET)
    public Map<String, Contact> getMatchedContactList(@RequestParam(value="firstName", required= false) String firstName) {
    	
    	if(firstName != null) {
    		Map<String, Contact> matchedContactList = new HashMap<String, Contact>();
        	for(Map.Entry<String, Contact> mapEntry: ctList.getList().entrySet()) {
        		String objectValue =mapEntry.getValue().getFirstName();
        		String key = mapEntry.getKey();
        		Contact value = mapEntry.getValue();
        		if(objectValue.equalsIgnoreCase(firstName)) {
        			matchedContactList.put(key, value);
        		}
        	}
        	return matchedContactList;
    	} else {
    		return ctList.getList();
    	}
    	
    }
    
    
    @RequestMapping(value = "/contacts/{phoneNumber}" , method= RequestMethod.DELETE)
    public void deleteContactFromList(@PathVariable("phoneNumber") String CtPhoneNumber) {
    	ctList.deleteContactFromList(CtPhoneNumber);
    }
    
    @RequestMapping(value = "/contacts", method = RequestMethod.POST)
    public Contact creatingAContact(@RequestBody Contact contact) {
    	ctList.addContactToList(contact);
    	return ctList.get(contact.getPhoneNumber());
    	
    }
    
    @RequestMapping(value = "/contacts/{phoneNumber}", method = RequestMethod.PUT)
    public Contact updatingAContact(@PathVariable("phoneNumber") String ctPhoneNumber, @RequestBody Contact contact) {
    	return ctList.update(ctPhoneNumber, contact);
    	
    }
}
