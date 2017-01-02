package cz.fav.sar.server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import cz.fav.sar.server.dao.SystemRepository;
import cz.fav.sar.server.domain.System;

@RestController
public class SystemController {
	
	@Autowired
	private SystemRepository systemRepository;
	
	@RequestMapping(value = "/system/{id}", method = RequestMethod.GET)
	public System get(@PathVariable("id") long id) {
		return systemRepository.findOne(id);
	}

}
