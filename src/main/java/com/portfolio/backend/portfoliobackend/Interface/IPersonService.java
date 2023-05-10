package com.portfolio.backend.portfoliobackend.Interface;

import java.util.List;

import com.portfolio.backend.portfoliobackend.Entity.Person;

public interface IPersonService {

  public List<Person> getPerson();

  public void savePerson(Person person);

  public void deletePerson(Long id);

  public Person findPersonById(Long id);
}
