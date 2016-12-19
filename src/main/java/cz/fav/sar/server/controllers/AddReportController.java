package cz.fav.sar.server.controllers;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import cz.fav.sar.server.dao.ReportRepository;
import cz.fav.sar.server.domain.Report;
import cz.fav.sar.server.notifications.Notificator;
import cz.fav.sar.server.notifications.Notificator.NOTIFICATION_TYPE;
import cz.fav.sar.server.utils.Id;
import cz.fav.sar.server.utils.IdGenerator;
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
			
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			Object principal = authentication.getPrincipal();
			if (principal instanceof String) {
				report.setCreatorUserCode((String)principal);
			}
			
			Id id = IdGenerator.generateId("GEN_CISLO_HLASENI");
			report.setId(id.getId());
			report.setReportNumber(id.number);
			
			System.out.println(report.toString());
			
			try{
				reportRepository.save(report);
				response.setStatus(HttpServletResponse.SC_OK);
				Notificator.getInstance().createAndQueueNotifications(NOTIFICATION_TYPE.CREATED, report);
			}catch(DataIntegrityViolationException e)
			{
				System.out.println(e);
				response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
				return "{\n\t'error': \"report invalid\"\n\t'message': \"" + e.getMessage() + "\"\n}";
			}
			ObjectMapper mapper = new ObjectMapper();
			try {
				return mapper.writeValueAsString(report);
			} catch (JsonProcessingException e) {
				System.out.println(e);
				return "{\n\t'error': \"json conversion error\"\n\t'message': \"" + e.getMessage() + "\"\n}";
			}
		}
	}

}
