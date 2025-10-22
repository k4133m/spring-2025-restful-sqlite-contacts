package repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import models.Contact;

@Repository
public interface ContactsRepository extends JpaRepository<Contact, Integer> {

}
