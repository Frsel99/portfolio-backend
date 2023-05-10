package com.portfolio.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfolio.backend.Entity.Person;

@Repository
public interface IPersonRepository extends JpaRepository<Person, Long> {

}
