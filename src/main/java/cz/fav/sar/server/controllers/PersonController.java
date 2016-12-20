package cz.fav.sar.server.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cz.fav.sar.server.dao.PersonRepository;
import cz.fav.sar.server.domain.Person;

@RestController
public class PersonController {
	
	@Autowired
	private PersonRepository personRepository;
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public Person get(@RequestParam("id") long id) {
		return personRepository.findOne(id);
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<Person> get(@RequestParam("query") String query) {
		return personRepository.findByQuery("%" + query + "%");
	}
	
	@RequestMapping(value = "/users", method = RequestMethod.POST, consumes = "application/json")
	public Iterable<Person> get(@RequestBody Long[] array) {
		return personRepository.findAll(Arrays.asList(array));
	}
}
