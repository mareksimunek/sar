package cz.fav.sar.server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cz.fav.sar.server.dao.ReportRepository;
import cz.fav.sar.server.domain.Report;

@RestController
public class ReportController {
	
	@Autowired
	private ReportRepository reportRepository;
	
	@RequestMapping(value = "/report", method = RequestMethod.GET)
	public Report get(@RequestParam("id") long id) {
		return reportRepository.findOne(id);
	}

}
