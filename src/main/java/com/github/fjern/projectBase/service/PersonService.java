package com.github.fjern.projectBase.service;


import com.github.fjern.projectBase.model.Person;
import com.github.fjern.projectBase.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
public class PersonService {
    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    public Iterable<Person> findAll() {
        return personRepository.findAll();
    }

    public Person create(Person person) {
        return personRepository.save(person);
    }

    public Person findById(Long id) {
        return personRepository.findById(id).orElse(new Person());
    }

    public Person delete(Long id) {
        Person personToBeDeleted = this.findById(id);
        personRepository.delete(personToBeDeleted);
        return personToBeDeleted;
    }

    public Person update(Person person) {
        Person personToBeUpdated = this.findById(person.getId());
        personToBeUpdated.setFirstName(person.getFirstName());
        personToBeUpdated.setLastName(person.getLastName());

        return personRepository.save(personToBeUpdated);


    }
}
