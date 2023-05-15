package com.portfolio.backend.Service;

import java.util.List;
import java.util.Optional;

import javax.swing.text.html.Option;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.backend.Entity.Person;
import com.portfolio.backend.Interface.IPersonService;
import com.portfolio.backend.Repository.IPersonRepository;

@Service
public class PersonService implements IPersonService {

  @Autowired
  IPersonRepository personRepository;

  @Override
  public Optional<Person> getPerson() {
    List<Person> persons = personRepository.findAll();
    Optional<Person> firstUser = persons.stream().findFirst();
    return firstUser;
  }

  @Override
  public void savePerson(Person person) {
    personRepository.save(person);
  }

  @Override
  public void deletePerson(Long id) {
    personRepository.deleteById(id);
  }

  @Override
  public Person findPersonById(Long id) {
    return personRepository.findById(id).orElse(null);
  }

}
