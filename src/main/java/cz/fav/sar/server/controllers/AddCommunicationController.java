package cz.fav.sar.server.controllers;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import cz.fav.sar.server.dao.CommunicationRepository;
import cz.fav.sar.server.domain.Communication;
import cz.fav.sar.server.utils.CommunicationValidator;

@RestController
public class AddCommunicationController {

	@Autowired
	CommunicationRepository repository;
	
	@RequestMapping(value = "/addcommunication", method = RequestMethod.PUT, consumes = "application/json")
	public String put(@RequestBody Communication comm, HttpServletResponse response) {
		boolean valid;
		try {
			CommunicationValidator validator = CommunicationValidator.getCommunicationValidator();
			valid = validator.validateCommunication(comm);
		} catch (Exception e){ 
			// Communication Invalid 
			e.printStackTrace();
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return "{\n\terror: \"communication invalid\"\n\tmessage: \"" + e.getMessage() + "\"\n}";
		}
		if(!valid)
		{
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return "{\n\terror: \"communication invalid\"\n}";
		}else{

			repository.save(comm);
			response.setStatus(HttpServletResponse.SC_OK);
			ObjectMapper mapper = new ObjectMapper();
			try {
				return mapper.writeValueAsString(comm);
			} catch (JsonProcessingException e) {
				return "{\n\terror: \"json conversion error\"\n\t message: \"" + e.getMessage() + "\"\n}";
			}
		}
	}
}
