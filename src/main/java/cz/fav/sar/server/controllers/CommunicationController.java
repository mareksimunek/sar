package cz.fav.sar.server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cz.fav.sar.server.dao.CommunicationRepository;
import cz.fav.sar.server.domain.Communication;

@RestController
public class CommunicationController {
	
	@Autowired
	private CommunicationRepository communicationRepository;
	
	@RequestMapping(value = "/communication", method = RequestMethod.GET)
	public Communication get(@RequestParam("id") long id) {
		return communicationRepository.findOne(id);
	}

}
