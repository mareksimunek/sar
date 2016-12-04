package cz.fav.sar.server.utils;

import org.springframework.context.ApplicationContext;

import cz.fav.sar.server.dao.ReportRepository;
import cz.fav.sar.server.dao.SystemRepository;
import cz.fav.sar.server.domain.Report;
import cz.fav.sar.server.domain.System;

public class ReportValidator {
	private static ReportValidator singleton;
	
	ApplicationContext ctx;
	
	private ReportValidator(ApplicationContext ctx){
		this.ctx = ctx;
	}
	
	public static void init(ApplicationContext ctx)
	{
		singleton = new ReportValidator(ctx);
	}
	
	public static ReportValidator getReportValidator()
	{
		return singleton;
	}
	
	public boolean validateReport(Report rep) throws Exception
	{
		if(!checkWWWSystem(rep)) return false;
		if(!checkPersonCompany(rep)) return false;
		if(!checkSystem(rep)) return false;
		if(!checkCommission(rep)) return false;
		return true;
	}
	
	public boolean validateUpdate(Report rep) throws Exception
	{
		if(!checkExists(rep)) return false;
		if(!checkWWWSystem(rep)) return false;
		if(!checkPersonCompany(rep)) return false;
		if(!checkSystem(rep)) return false;
		if(!checkCommission(rep)) return false;
		return true;
	}
	
	private boolean checkExists(Report rep) throws Exception
	{
		if(rep.getId() == null) return true;
		else{
			ReportRepository repo = (ReportRepository)ctx.getBean(ReportRepository.class);
			Report report = repo.findOne(rep.getId());
			if(report == null) throw new Exception("Hlášení " + rep.getId() + " neexistuje.");
		}
		return true;
	}
	
	private boolean checkWWWSystem(Report rep) throws Exception
	{
		/*
		 	Kontrola, že hlášení zveřejněné na webu má
			vyplněný systém. Pokud je zaškrtnutý příznak
			PRIZNAK_AN_ZVEREJNIT_WWW a prázdné
			pole SYSTEM, vyhodí výjimku HAP001F-01:
			Nelze mít zaškrtnutý příznak Text hlášení na
			WWW bez systému.
		 */
		// not in our database
		return true;
	}
	
	private boolean checkPersonCompany(Report rep) throws Exception
	{
		/**
		 	Kontrola, že zadaná kontaktní osoba patří do
			zadané firmy. Hledá osobu v seznamu jmen s
			ID ID_ZAKAZNIKA, které je druhu 'F' nebo 'Z' a
			která má jako nadřízenou osobu osobu s ID
			ID_FIRMY_ZAK. Osoba musí mít použití
			povoleno = 'T'
			Pokud takovou osobu nenajde, vyhodí výjimku
			'HAP001F-07: Osoba není v seznamu jmen.
			Buď není založená nebo není podřízená.'; 
		 */
		// not in our database 
		return true;
	}
	
	private boolean checkSystem(Report rep) throws Exception
	{
		if(rep.getSystemId() == null) return true;
		else{
			SystemRepository repo = (SystemRepository)ctx.getBean(SystemRepository.class);
			System system = repo.findOne(rep.getSystemId());
			if(system == null) throw new Exception("Systém " + rep.getSystemId() + " není evidován.");
		}
		return true;
	}
	
	private boolean checkCommission(Report rep) throws Exception
	{
		/**
		 	Kontroluje správné zadání zakázky na hlášení.
			Zakázka musí existovat v tabulce
			CCAG_ZAKAZKA a musí mít povolené použití.
			Pokud zakázka neexistuje, vyhodí funkce
			výjimku 'HAP001F-78: Zadaná zakázka
			neexistuje.' 
		 */
		// not in our database
		return true;
	}
	
	
}
