package cz.fav.sar.server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cz.fav.sar.server.dao.CompanyRepository;
import cz.fav.sar.server.domain.Company;

@RestController
public class CompanyController {
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@RequestMapping(value = "/company", method = RequestMethod.GET)
	public Company get(@RequestParam("id") long id) {
		return companyRepository.findOne(id);
	}

}
