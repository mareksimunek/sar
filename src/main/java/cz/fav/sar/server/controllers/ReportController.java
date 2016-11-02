package cz.fav.sar.server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cz.fav.sar.server.dao.PersonRepository;
import cz.fav.sar.server.domain.Person;

@Controller
public class ReportController {
	@Autowired
	PersonRepository repository;
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public @ResponseBody String get() {
		Person p = repository.findOne(1L);	// selects person with id 1 from db
		//repository.save(new Person());	// inserts new person into db
		return "AAA";
	}

}
