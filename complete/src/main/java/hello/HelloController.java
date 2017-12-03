package hello;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {
    
    @RequestMapping("/")
    public String index() {
        return "Greetings from manju!";
    }
    
    @RequestMapping("/contacts")
    public Map<String, Contact> getContactList() {
    	Map<String, Contact> contactList = new HashMap<String, Contact>();
    	contactList.put("1", new Contact("William", "Smith", "williams123@gmail.com", "3761520879"));
    	contactList.put("2", new Contact("Daniel", "Moore", "daniel.moore@gmail.com", "2738098078"));
    	contactList.put("3", new Contact("David", "Harris", "davidharris90@gmail.com", "4920173829"));
    	contactList.put("4", new Contact("Linda", "Nelson", "linda2004@gmail.com", "2910287352"));
    	contactList.put("5", new Contact("Sarah", "Parker", "sarah.parker12@gmail.com", "4891092648"));
    	return contactList;
    }
    
}
