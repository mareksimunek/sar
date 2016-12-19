package cz.fav.sar.server.notifications;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cz.fav.sar.server.dao.PersonRepository;
import cz.fav.sar.server.domain.Person;
import cz.fav.sar.server.domain.Report;
import cz.fav.sar.server.notifications.Notificator.NOTIFICATION_TYPE;

@Component
public class EmailNotificationTemplate implements NotificationTemplate {
	
	@Autowired
	private PersonRepository personRepo;
	
	private List<Notification> createEvent(NOTIFICATION_TYPE type, Report report) {
		List<Notification> ret = new ArrayList<>();
		
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

	@Override
	public List<Notification> createNotifications(NOTIFICATION_TYPE type, Object obj) {
		if (type == NOTIFICATION_TYPE.CREATED) {
			if (obj instanceof Report) {
				return createEvent(type, (Report)obj);
			}
			else {
				System.out.println("Other types than 'Report' are not yet implemented");
				return null;
			}
		}
		else {
			System.out.println("Other types than 'CREATED' are not yet implemented");
			return null;
		}
	}

}
