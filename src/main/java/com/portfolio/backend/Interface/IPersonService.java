package com.portfolio.backend.Interface;

import java.util.List;
import java.util.Optional;

import com.portfolio.backend.Entity.Person;

public interface IPersonService {

  public Optional<Person> getPerson();

  public void savePerson(Person person);

  public void deletePerson(Long id);

  public Person findPersonById(Long id);
}
