package br.com.erudio.service;

import br.com.erudio.model.Person;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public Person findById(String id){
        logger.info("Finding one person");
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Alexandre");
        person.setLastName("Tomasi");
        person.setAddress("Cuiaba");
        person.setGender("Masculino");
        return person;
    }

    public List<Person> findAll() throws Exception {
        logger.info("Finding all person");
        List<Person> persons = new ArrayList<>();
        for(int i=0; i< 10; i++){
            Person person = mockPerson(i);
            persons.add(person);
        }
        return persons;
    }
    private Person mockPerson(int i) {

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Alexandre "+i);
        person.setLastName("Last Name"+i);
        person.setAddress("Cuiaba");
        person.setGender("Masculino");
        return person;
    }

    public Person create(Person person) {
        logger.info("Create one person");
        return person;
    }

    public Person update(Person person) {
        logger.info("Update one person");
        return person;
    }

    public void delete(Long id) {
        logger.info("Deletando one person");
    }
}
