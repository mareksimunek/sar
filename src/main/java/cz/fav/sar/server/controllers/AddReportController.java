package cz.fav.sar.server.controllers;

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
import cz.fav.sar.server.utils.EmailNotification;
import cz.fav.sar.server.utils.IdGenerator;
import cz.fav.sar.server.utils.Notificator;
import cz.fav.sar.server.utils.ReportFiller;
import cz.fav.sar.server.utils.ReportValidator;

@RestController
public class AddReportController {
	
	@Autowired
	private ReportRepository reportRepository;
	
	@RequestMapping(value = "/addreport", method = RequestMethod.PUT, consumes = "application/json")
	public String put(@RequestBody Report report, HttpServletResponse response) {
		boolean valid;
		try {
			ReportValidator validator = ReportValidator.getReportValidator();
			valid = validator.validateReport(report);
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
			filler.fillFields(report);
			// TODO create notification
			//EmailNotification emailNotif = new EmailNotification("to", "subject", "body");
			//Notificator.sendNotification(emailNotif);
			long id = IdGenerator.generateId("GEN_CISLO_HLASENI");
			report.setId(id);
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

}
