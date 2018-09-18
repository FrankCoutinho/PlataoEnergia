package br.com.plataoenergia.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.plataoenergia.entities.Person;
import br.com.plataoenergia.repositories.PersonRepository;

@RestController
public class PersonController
{
	@Autowired
	PersonRepository repository;
	
	@RequestMapping("/add")
	public void add()
	{
		Person person = new Person();
		person.setId(10);
		person.setFirstname("Frank");
		person.setLastName("Coutinho");
		repository.save(person);
	}
	
	@RequestMapping("/delete")
	public void delete()
	{
		repository.deleteById(10L);
	}
}
