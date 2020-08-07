package com.test.bootfaces.controller;

import com.test.bootfaces.model.Person;
import com.test.bootfaces.persistence.PersonRepository;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

@Scope(value = "session")
@Component(value = "personController")
@ELBeanName(value = "personController")
@Join(path = "/person", to = "/person/person-form.jsf")
public class PersonController {
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

			return "/person/person-form.xhtml";
		}
	}

	public Person getPerson() {
		return person;
	}

	public Date getMaxDate() {
		return today;
	}
}