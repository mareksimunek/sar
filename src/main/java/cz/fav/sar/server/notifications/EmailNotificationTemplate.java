package cz.fav.sar.server.notifications;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cz.fav.sar.server.dao.PersonRepository;
import cz.fav.sar.server.domain.Person;
import cz.fav.sar.server.domain.Report;

@Component
public class EmailNotificationTemplate {
	
	public static enum NOTIFICATION_TYPE { CREATED, /* MODIFIED, SOLVED  */ }; // to be added later
	
	@Autowired
	private PersonRepository personRepo;
	
	public List<EmailNotification> createNotifications(NOTIFICATION_TYPE type, Report report) {
		List<EmailNotification> ret = new ArrayList<>();
		
		String text = createText(type, report);
		String subject = createSubject(type, report);
		
		String creatorEmail = getEmailByUserId(report.getCreatorUserCode());
		String garantEmail = getEmailByUserId(report.getGarantUserCode());
		String solvingEmail = getEmailByUserId(report.getSolvingUserCode());
		
		if (creatorEmail != null) ret.add( new EmailNotification(creatorEmail, subject, text));
		if (garantEmail != null) ret.add( new EmailNotification(garantEmail, subject, text));
		if (solvingEmail != null) ret.add( new EmailNotification(solvingEmail, subject, text));
		
		return ret;
	}
	
	private String createText(NOTIFICATION_TYPE type, Report report) {
		if (type == NOTIFICATION_TYPE.CREATED) {
			return "Text: '" + report.getReportText() + "'";
		}
		return null;
	}
	
	private String createSubject(NOTIFICATION_TYPE type, Report report) {
		if (type == NOTIFICATION_TYPE.CREATED) {
			return "Report '" + report.getName() + "' was created";
		}
		return null;
	}
	
	private String getEmailByUserId(String id) {
		try {
			if (id == null) return null;
			if (id.isEmpty()) return null;
			Long l = Long.parseLong(id);
			
			Person one = personRepo.findOne(l);
			if (one == null) return null;
			
			return one.getEmail();
			
		} catch (NumberFormatException e) {
			System.out.println("Error on finding user with ID '" + id + "'");
			return null;
		}
	}

}
