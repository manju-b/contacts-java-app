package hello;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ContactList {

	Map<String,Contact> listOfContacts;
	
	
	public ContactList() {
		listOfContacts = new HashMap<String, Contact>();
		listOfContacts.put("3761520879", new Contact("William", "Smith", "williams123@gmail.com", "3761520879"));
		listOfContacts.put("2738098078", new Contact("Daniel", "Moore", "daniel.moore@gmail.com", "2738098078"));
		listOfContacts.put("4920173829", new Contact("David", "Harris", "davidharris90@gmail.com", "4920173829"));
		listOfContacts.put("2910287352", new Contact("Linda", "Nelson", "linda2004@gmail.com", "2910287352"));
		listOfContacts.put("4891092648", new Contact("Sarah", "Parker", "sarah.parker12@gmail.com", "4891092648"));
	}



	public ContactList(Map<String, Contact> listOfContacts) {
		this.listOfContacts = listOfContacts;
	}
	
	public Contact get(String key) {
		return listOfContacts.get(key);
	}

	public Map<String, Contact> getList() {
		 return listOfContacts;
	}

	public void addContactToList(Contact ct) {
		listOfContacts.put(ct.getPhoneNumber(), ct);
		
	}
	 public void deleteContactFromList(String ctId) {
		 listOfContacts.remove(ctId);
	 }
	
	public Contact update(String CtId, Contact ct) {
		listOfContacts.put(CtId, ct);
		 return listOfContacts.get(CtId);
	}
}
