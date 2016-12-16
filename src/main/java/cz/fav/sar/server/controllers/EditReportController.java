package cz.fav.sar.server.controllers;

import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import cz.fav.sar.server.dao.ReportRepository;
import cz.fav.sar.server.domain.Report;
import cz.fav.sar.server.utils.EditSolverTextParams;
import cz.fav.sar.server.utils.ReportFiller;
import cz.fav.sar.server.utils.ReportValidator;

@RestController
public class EditReportController {
	
	@Autowired
	private ReportRepository reportRepository;
	
	@RequestMapping(value = "/editreport", method = RequestMethod.PUT, consumes = "application/json")
	public String put(@RequestBody Report report, HttpServletResponse response) {
		boolean valid;
		try {
			ReportValidator validator = ReportValidator.getReportValidator();
			valid = validator.validateUpdate(report);
		} catch (Exception e) {
			// Report is invalid
			e.printStackTrace();
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return "{\n\t'error': \"report invalid\"\n\t'message': \"" + e.getMessage() + "\"\n}";
		}
		if(!valid)
		{
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return "{\n\t'error': \"report invalid\"\n}";
		}else{
			// fills missing fields
			ReportFiller filler = ReportFiller.getReportFiller();
			filler.updateFields(report);
			reportRepository.save(report);
			response.setStatus(HttpServletResponse.SC_OK);
			ObjectMapper mapper = new ObjectMapper();
			try {
				return mapper.writeValueAsString(report);
			} catch (JsonProcessingException e) {
				return "{\n\t'error': \"json conversion error\"\n\t'message': \"" + e.getMessage() + "\"\n}";
			}
		}
	}
	
	@RequestMapping(value = "/editsolvertext", method = RequestMethod.PUT, consumes = "application/json")
	public String editSolverText(@RequestBody EditSolverTextParams params, HttpServletResponse response) {
		Report report = reportRepository.findOne(params.getId());
		if(report == null){
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return "{\n\t'error': \"report id: " + params.getId() + " not found.\"\n}";
		}
		Date now = Calendar.getInstance().getTime();
		report.setSolutionDate(now);
		report.setSolutionText(params.getText());
		reportRepository.save(report);
		// TODO notification to customer
		response.setStatus(HttpServletResponse.SC_OK);
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(report);
		} catch (JsonProcessingException e) {
			return "{\n\t'error': \"json conversion error\"\n\t'message': \"" + e.getMessage() + "\"\n}";
		}
	}


}
