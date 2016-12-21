package cz.fav.sar.server.controllers;

import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
	
	@RequestMapping(value = "/report", method = RequestMethod.POST, consumes = "application/json")
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
	
	@RequestMapping(value = "/report/{id}/solution", method = RequestMethod.PUT, consumes = "application/json")
	public String editSolverText(HttpServletRequest request,
								 @PathVariable("id") long id, @RequestBody EditSolverTextParams params, HttpServletResponse response) {
		Report report = reportRepository.findOne(id);
		if(report == null){
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return "{\n\t'error': \"report id: " + id + " not found.\"\n}";
		}
		Date now = Calendar.getInstance().getTime();
		report.setSolutionDate(now);
		report.setSolutionText(params.getText());
		report.setDifficulty(params.getDifficulty());
		report.setSolvedUserCode(report.getSolvingUserCode());
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
