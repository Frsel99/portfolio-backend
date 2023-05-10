package com.portfolio.backend.Interface;

import java.util.List;

import com.portfolio.backend.Entity.Person;

public interface IPersonService {

  public List<Person> getPerson();

  public void savePerson(Person person);

  public void deletePerson(Long id);

  public Person findPersonById(Long id);
}
