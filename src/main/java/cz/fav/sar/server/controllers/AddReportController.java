package cz.fav.sar.server.controllers;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cz.fav.sar.server.dao.ReportRepository;
import cz.fav.sar.server.domain.Report;
import cz.fav.sar.server.utils.IdGenerator;

@RestController
public class AddReportController {
	
	@Autowired
	private ReportRepository reportRepository;
	
	@RequestMapping(value = "/addreport", method = RequestMethod.PUT, consumes = "application/json")
	public String put(@RequestBody Report report, HttpServletResponse response) {
		// TODO check if valid
		boolean valid = true;
		if(!valid)
		{
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return "report invalid";
		}else{
			// TODO fill missing fields, create notification
			long id = IdGenerator.generateId("GEN_CISLO_HLASENI");
			report.setId(id);
			reportRepository.save(report);
			response.setStatus(HttpServletResponse.SC_ACCEPTED);
			return "success";
		}
	}

}
