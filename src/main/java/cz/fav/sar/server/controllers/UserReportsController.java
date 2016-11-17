package cz.fav.sar.server.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cz.fav.sar.server.dao.ReportRepository;
import cz.fav.sar.server.domain.Report;

@RestController
public class UserReportsController {
	
	@Autowired
	private ReportRepository reportRepository;
	
	@RequestMapping(value = "/userreports", method = RequestMethod.GET)
	public List<Report> get(@RequestParam("id") long id) {
		return reportRepository.findByCustomerId(id);
	}

}
