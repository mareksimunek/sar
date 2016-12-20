package cz.fav.sar.server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import cz.fav.sar.server.dao.CommunicationRepository;
import cz.fav.sar.server.domain.Communication;

import java.util.List;

@RestController
public class CommunicationController {
	
	@Autowired
	private CommunicationRepository communicationRepository;
	
	@RequestMapping(value = "/communication/{id}", method = RequestMethod.GET)
	public Communication get(@PathVariable("id") long id) {
		return communicationRepository.findOne(id);
	}

	@RequestMapping(value = "/report/{id}/communications", method = RequestMethod.GET)
	public List<Communication> getReportComm(@PathVariable("id") long id) {
		return communicationRepository.findByReportId(id);
	}

}
