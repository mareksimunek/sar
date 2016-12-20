package cz.fav.sar.server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import cz.fav.sar.server.dao.ReportRepository;
import cz.fav.sar.server.domain.Report;

@RestController
public class ReportController {
	
	@Autowired
	private ReportRepository reportRepository;
	
	@RequestMapping(value = "/report/{id}", method = RequestMethod.GET)
	public Report get(@PathVariable("id") long id) {
		return reportRepository.findOne(id);
	}

}
