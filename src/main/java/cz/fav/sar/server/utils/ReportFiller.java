package cz.fav.sar.server.utils;

import java.util.Calendar;
import java.util.Date;

import org.springframework.context.ApplicationContext;

import cz.fav.sar.server.domain.Report;

public class ReportFiller {
private static ReportFiller singleton;
	
	ApplicationContext ctx;
	
	private ReportFiller(ApplicationContext ctx){
		this.ctx = ctx;
	}
	
	public static void init(ApplicationContext ctx)
	{
		singleton = new ReportFiller(ctx);
	}
	
	public static ReportFiller getReportFiller()
	{
		return singleton;
	}
	
	public void fillFields(Report rep)
	{
		fillImportantCustomer(rep);
		fillGarant(rep);
		fillSolver(rep);
		fillStandardCommission(rep);
		Date now = Calendar.getInstance().getTime();
		rep.setLastChangeDate(now);
		rep.setLastUpdateDate(now);
		rep.setDateOfCreation(now);
		rep.setReportYear((long)Calendar.YEAR);
	}
	
	public void updateFields(Report rep)
	{
		Date now = Calendar.getInstance().getTime();
		rep.setLastChangeDate(now);
		rep.setLastUpdateDate(now);
	}
	
	private void fillImportantCustomer(Report rep)
	{
		/**
		 	Pokud je příznak DULEZITE na hlášení prázdný,
			vyplní jej podle příznaku DULEZITY_ZAKAZNIK
			firmy uvedené na hlášení (ID_FIRMY_ZAK).
			Příznak vyplní také v případě, že hlášení je
			druhu URGENCE 
		 */
		// dont know where is DULEZITE / URGENCE 
	}
	
	private void fillGarant(Report rep)
	{
		/*
		 	Pokud na hlášení není vyplněný Garant, vyplní
			je podle tabulky systémů takto:
			Osoba pro hlášení typu POŽADAVEK - kód
			osoby, která je na systému z hlášení jako
			vedoucí projektu, přednost má osoba uvedená
			jako vedoucí projektu pro zákazníka, pokud
			není uvedená, vezme se pro systém.
			Osoba pro hlášení ostatních typů - kód osoby,
			která je na systému z hlášení jako hlavní
			konzultant, přednost má osoba uvedená jako
			hlavní konzultant pro zákazníka, pokud není
			uvedená, vezme se pro systém.
			Středisko: Středisko garanta z
			ccag_uzivatel_v_oddeleni, které má nastaven
			příznak primární oddělení
		 */
		if(rep.getReportType().equals("POZADAVEK")){
			// not enough info in DB
		}else{
			// not enough info in DB
		}
	}
	
	private void fillSolver(Report rep)
	{
		/*
		 	Pokud na hlášení není vyplněný Řešitel, vyplní
			je podle tabulky systémů takto:
			Osoba - kód osoby, která je na systému z
			hlášení jako hlavní konzultant, přednost má
			osoba uvedená jako hlavní konzultant pro
			zákazníka, pokud není uvedená, vezme se pro
			systém. Středisko: Středisko řešitele z
			ccag_uzivatel_v_oddeleni, které má nastaven
			příznak primární oddělení
		 */
		if(rep.getSolvingUserCode() == null){
			// not enough info in DB
		}
	}
	
	private void fillStandardCommission(Report rep)
	{
		/*
		 	Pokdu je pole zakázka prázdné, vyplní jej
			hodnotou volání funkce System-
			API.getStadndardniZakazka(systém, druh
			hlášení)
		 */
		// Referencing unknown method
	}
}
