package com.test.bootfaces.controller;

import com.test.bootfaces.model.Person;
import com.test.bootfaces.persistence.PersonRepository;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.annotation.RequestAction;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.ocpsoft.rewrite.faces.annotation.Deferred;
import org.ocpsoft.rewrite.faces.annotation.IgnorePostback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Scope (value = "session")
@Component (value = "listPeopleController")
@ELBeanName(value = "listPeopleController")
@Join(path = "/", to = "/person/people-list.jsf")
public class ListPeopleController {
	@Autowired
	private PersonRepository personRepository;

	private List<Person> people;
	@Deferred
	@RequestAction
	@IgnorePostback
	public void loadData() {
		people = personRepository.findAll();
	}

	public List<Person> getPeople() {
		return people;
	}

	public String delete(Person person) {
		personRepository.delete(person.getId());
		loadData();
		return null;
	}
	
	public String edit() {
		return "/person/person-edit-form.xhtml?faces-redirect=true";
	}
}

