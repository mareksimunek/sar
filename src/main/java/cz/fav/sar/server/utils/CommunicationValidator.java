package cz.fav.sar.server.utils;

import org.springframework.context.ApplicationContext;

import cz.fav.sar.server.dao.ReportRepository;
import cz.fav.sar.server.domain.Communication;
import cz.fav.sar.server.domain.Report;

public class CommunicationValidator {
	private static CommunicationValidator singleton;
	
	ApplicationContext ctx;
	
	private CommunicationValidator(ApplicationContext ctx){
		this.ctx = ctx;
	}
	
	public static void init(ApplicationContext ctx)
	{
		singleton = new CommunicationValidator(ctx);
	}
	
	public static CommunicationValidator getCommunicationValidator()
	{
		return singleton;
	}
	
	public boolean validateCommunication(Communication comm) throws Exception
	{
		if(!validateReport(comm)) return false;
		return true;
	}
	
	private boolean validateReport(Communication comm) throws Exception
	{
		if(comm.getReportId() == null) return true;
		else{
			ReportRepository repo = (ReportRepository)ctx.getBean(ReportRepository.class);
			Report report = repo.findOne(comm.getReportId());
			if(report == null) throw new Exception("Hlášení " + comm.getReportId() + " není evidováno.");
		}
		return true;
	}
}
