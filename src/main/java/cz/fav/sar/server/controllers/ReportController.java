package cz.fav.sar.server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cz.fav.sar.server.dao.PersonRepository;
import cz.fav.sar.server.dao.ReportRepository;
import cz.fav.sar.server.domain.Person;
import cz.fav.sar.server.domain.Report;

@RestController
public class ReportController {
	
	@Autowired
	ReportRepository reportRepository;
	
	@RequestMapping(value = "/report", method = RequestMethod.GET)
	public Report get(@RequestParam("id") long id) {
		Report r = reportRepository.findOne(id);	// selects person with id 1 from db
		return r;
	}

}
