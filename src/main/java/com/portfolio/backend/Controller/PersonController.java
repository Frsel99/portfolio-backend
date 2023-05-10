package com.portfolio.backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.backend.Entity.Person;
import com.portfolio.backend.Service.PersonService;

@RestController
@RequestMapping("/person")
@CrossOrigin
public class PersonController {
  @Autowired
  PersonService personService;

  @GetMapping("/")
  public Person getPerson() {
    return personService.findPersonById((long) 1);
  }

  @PostMapping("/")
  public HttpStatus createPerson(@RequestBody Person person) {
    personService.savePerson(person);
    return HttpStatus.CREATED;
  }

  @DeleteMapping("/delete/{id}")
  public HttpStatus deletePerson(@PathVariable Long id) {
    personService.deletePerson(id);
    return HttpStatus.OK;
  }

  @PatchMapping("/update/{id}")
  public Person editPerson(@PathVariable Long id, @RequestBody Person person) {
    person.setId(id);
    personService.savePerson(person);
    return person;
  }
}
