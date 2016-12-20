package cz.fav.sar.server.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import cz.fav.sar.server.dao.CompanyRepository;
import cz.fav.sar.server.domain.Company;

@RestController
public class CompanyController {
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@RequestMapping(value = "/company/{id}", method = RequestMethod.GET)
	public Company get(@PathVariable("id") long id) {
		return companyRepository.findOne(id);
	}
	
	@RequestMapping(value = "/companies", method = RequestMethod.GET)
	public List<Company> get(@RequestParam("query") String query) {
		return companyRepository.findByQuery("%" + query + "%");
	}
}
