package com.test.bootfaces.controller;

import com.test.bootfaces.model.Person;
import com.test.bootfaces.persistence.PersonRepository;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

@Scope(value = "session")
@Component(value = "personEditController")
@ELBeanName(value = "personEditController")
@Join(path = "/person-edit", to = "/person/person-edit-form.jsf")
public class PersonEditController {
	@Autowired
	private PersonRepository personRepository;

	private Person person = new Person();
    private Date today = new Date();

	public String save() {
		try {
			personRepository.save(person);
			person = new Person();
			return "/person/people-list.xhtml?faces-redirect=true";
		} catch (DataIntegrityViolationException e) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Info", "CPF already registered.");
            FacesContext.getCurrentInstance().addMessage(null, message);

			return "/person/person-edit-form.xhtml";
		}
	}

	public Person getPerson() {
		return person;
	}
	
	public void setPerson(Person person) {
		this.person = person;
	}
	
	public Date getMaxDate() {
		return today;
	}
}
