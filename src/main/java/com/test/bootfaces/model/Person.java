package com.test.bootfaces.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	private String name;
	
	@Column
	private char sex;
	
	@Column
	private String email;
	
	@Column
	private Date birthdate;

	@Column
	private String naturalness;
	
	@Column
	private String nationality;
	
	@Column
	private String cpf;

	public Person() { }
}
