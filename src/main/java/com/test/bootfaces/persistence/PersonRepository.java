package com.test.bootfaces.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.bootfaces.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
