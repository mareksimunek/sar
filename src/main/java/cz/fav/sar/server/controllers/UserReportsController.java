package cz.fav.sar.server.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import cz.fav.sar.server.dao.ReportRepository;
import cz.fav.sar.server.domain.Report;

@RestController
public class UserReportsController {
	
	@Autowired
	private ReportRepository reportRepository;
	
	@RequestMapping(value = "/user/{id}/reports", method = RequestMethod.GET)
	public String get(HttpServletRequest request, @PathVariable("id") long id) {
		if(!request.getAttribute("user").equals(id)){
			return "{\n\terror: \"not authorized\"\n}";
		}
		List<Report> reports = reportRepository.findByCustomerId(id);
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(reports);
		} catch (JsonProcessingException e) {
			return "{\n\t'error': \"json conversion error\"\n\t'message': \"" + e.getMessage() + "\"\n}";
		}
	}

	@RequestMapping(value = "/user/{id}/solver-reports", method = RequestMethod.GET)
	public String get2(HttpServletRequest request, @PathVariable("id") long id) {
		if(!request.getAttribute("user").equals(id)){
			return "{\n\terror: \"not authorized\"\n}";
		}
		List<Report> reports = reportRepository.findBySolvingUserCode(""+id);
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(reports);
		} catch (JsonProcessingException e) {
			return "{\n\t'error': \"json conversion error\"\n\t'message': \"" + e.getMessage() + "\"\n}";
		}
	}
}
