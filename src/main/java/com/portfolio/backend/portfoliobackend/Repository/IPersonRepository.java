package com.portfolio.backend.portfoliobackend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portfolio.backend.portfoliobackend.Entity.Person;

@Repository
public interface IPersonRepository extends JpaRepository<Person, Long> {

}
