package controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import models.Contact;
import services.ContactService;

@RestController()
@RequestMapping("/api/contacts")
public class ContactsRestApi {

	@Autowired
	ContactService contactService;

	@GetMapping
	public List<Contact> getAllContacts() {
		return contactService.getAllContacts();
	}

	@GetMapping("/{id}")
	
	public ResponseEntity<Optional<Contact>> getAContact(@PathVariable("id") int id) {
		Optional<Contact> optional =  contactService.findContactById(id);
		return optional.isPresent() 
				? new ResponseEntity<Optional<Contact>>(optional, HttpStatus.OK) 
						: new ResponseEntity<Optional<Contact>>(optional, HttpStatus.NOT_FOUND);
	}

	@PostMapping
	public ResponseEntity<Contact> insertNewContact(@RequestBody Contact c) {
		contactService.upsert(c);
		return new ResponseEntity<Contact>(c, HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<Contact> updateContact(@RequestBody Contact c) {
		contactService.upsert(c);
		return new ResponseEntity<Contact>(c, HttpStatus.OK);
	}

	@DeleteMapping
	public ResponseEntity<String> deleteContact(@RequestBody Contact c) {
		contactService.deleteContact(c);
		return new ResponseEntity<String>("deleted", HttpStatus.OK);

	}

}
