package cz.fav.sar.server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cz.fav.sar.server.dao.SystemRepository;
import cz.fav.sar.server.domain.System;

@RestController
public class SystemController {
	
	@Autowired
	private SystemRepository systemRepository;
	
	@RequestMapping(value = "/system", method = RequestMethod.GET)
	public System get(@RequestParam("id") long id) {
		return systemRepository.findOne(id);
	}

}
