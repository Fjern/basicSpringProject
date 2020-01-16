package com.github.fjern.projectBase.controller;

import com.github.fjern.projectBase.model.Person;
import com.github.fjern.projectBase.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class PersonController {
    private PersonService service;

    @Autowired
    public PersonController(PersonService service){
        this.service = service;
    }

    @RequestMapping(value = "/person/", method = RequestMethod.GET)
    public ResponseEntity<?> findAll(){
        Iterable<Person> allPeople = service.findAll();
        ResponseEntity<?> responseEntity = new ResponseEntity<>(allPeople, HttpStatus.OK);
        return responseEntity;
    }
    @RequestMapping(value = "/person/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable Long id){
        Person person = service.findById(id);
        ResponseEntity<?> responseEntity = new ResponseEntity<>(person,HttpStatus.OK);
        return responseEntity;
    }

    @RequestMapping(value = "/person/",method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody Person person){
        person = service.create(person);
        ResponseEntity<?> responseEntity = new ResponseEntity<>(person,HttpStatus.CREATED);
        return responseEntity;
    }

    @RequestMapping(value = "/person/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Person person = service.delete(id);
        ResponseEntity<?> responseEntity = new ResponseEntity<>(person, HttpStatus.CREATED);
        return responseEntity;
    }

    @RequestMapping(value = "/person/",method=RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody Person person){
        person = service.update(person);
        ResponseEntity<?> responseEntity = new ResponseEntity<>(person,HttpStatus.OK);
        return responseEntity;
    }

}
