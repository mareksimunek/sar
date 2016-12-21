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

		return getReports(request, id, reportRepository.findByCustomerId(id));
	}

	@RequestMapping(value = "/user/{id}/solver-reports", method = RequestMethod.GET)
	public String get2(HttpServletRequest request, @PathVariable("id") long id) {

		return getReports(request, id,reportRepository.findBySolvingUserCode(""+id));
	}

	@RequestMapping(value = "/user/{id}/solver-unresolved-reports", method = RequestMethod.GET)
	public String getSolverUnresolved(HttpServletRequest request, @PathVariable("id") long id) {
		return getReports(request, id, reportRepository.findSolverUnresolvedReports(""+id));
	}

	@RequestMapping(value = "/user/{id}/reports-unresolved", method = RequestMethod.GET)
	public String getUnresolved(HttpServletRequest request, @PathVariable("id") long id) {

		return getReports(request, id, reportRepository.findUnresolvedReports(id));
	}
	@RequestMapping(value = "/user/{id}/reports-resolved", method = RequestMethod.GET)
	public String getResolved(HttpServletRequest request, @PathVariable("id") long id) {

		return getReports(request, id, reportRepository.findResolvedReports(id));
	}

	@RequestMapping(value = "/user/{id}/solver-resolved-reports", method = RequestMethod.GET)
	public String getSolverResolved(HttpServletRequest request, @PathVariable("id") long id) {

		return getReports(request, id, reportRepository.findSolverResolvedReports(""+id));
	}


	public String getReports(HttpServletRequest request,long id, List<Report> reports){
		if(!request.getAttribute("user").equals(id)){
			return "{\n\terror: \"not authorized\"\n}";
		}
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(reports);
		} catch (JsonProcessingException e) {
			return "{\n\t'error': \"json conversion error\"\n\t'message': \"" + e.getMessage() + "\"\n}";
		}

	}


}
