package services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repos.ContactsRepository;
import models.Contact;

@Service
public class ContactService {

	@Autowired
	ContactsRepository contactsRepository;

	public List<Contact> getAllContacts() {
		return contactsRepository.findAll();
	}
	
	// handles insert and update (no id = insert)
	public Contact upsert(Contact c) {
		return contactsRepository.save(c);
	}
	
	public  Optional<Contact> findContactById(int id) {
		return contactsRepository.findById(id);
	}

	public void deleteContact(Contact c) {
		contactsRepository.delete(c);
	}
	
	
//	public Contact addContact(Contact c) {
//		return contactsRepository.save(c);
//	}
//
//	public Contact updateContact(Contact c) {
//		return contactsRepository.save(c);
//	}
//	
	
}
