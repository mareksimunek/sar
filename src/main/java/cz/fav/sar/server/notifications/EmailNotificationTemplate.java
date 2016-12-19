package cz.fav.sar.server.notifications;

import java.text.DateFormat;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

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
		
		String creatorEmail = getEmailByUserId(report.getCreatorUserCode());
		String garantEmail = getEmailByUserId(report.getGarantUserCode());
		String solvingEmail = getEmailByUserId(report.getSolvingUserCode());

		if (creatorEmail != null) ret.add( createNotificationTo(creatorEmail, creatorEmail, type, report) );
		if (creatorEmail == null) creatorEmail = "(unknown)";
		if (garantEmail != null) ret.add( createNotificationTo(garantEmail, creatorEmail, type, report) );
		if (solvingEmail != null) ret.add( createNotificationTo(solvingEmail, creatorEmail, type, report) );
		
		return ret;
	}
	
	private EmailNotification createNotificationTo(String userEmail, String creatorEmail, NOTIFICATION_TYPE type, Report report) {
		// hardcoded here, but it could be gotten from DB or something
		// done here so it would handle different locales for different users 
		Locale loc = new Locale("en", "US"); 
		
		String text = createText(type, report, creatorEmail, loc);
		String subject = createSubject(type, report, loc);
		
		return new EmailNotification(userEmail, subject, text);
	}
	
	private String createText(NOTIFICATION_TYPE type, Report report, String creator, Locale locale) {
		ResourceBundle resourceBundle = ResourceBundle.getBundle( "EmailNotificationsMessages", locale);
		if (type == NOTIFICATION_TYPE.CREATED) {
			DateFormat dateFormatter;
			dateFormatter = DateFormat.getDateInstance(DateFormat.DEFAULT, locale);
			return MessageFormat.format(
					resourceBundle.getString("CreateEventText"), 
					(report.getId() + " - " + report.getName()), 
					dateFormatter.format(report.getDateOfCreation()), 
					creator, 
					report.getReportText());
		}
		return null;
	}
	
	private String createSubject(NOTIFICATION_TYPE type, Report report, Locale locale) {
		ResourceBundle resourceBundle = ResourceBundle.getBundle( "EmailNotificationsMessages", locale);
		if (type == NOTIFICATION_TYPE.CREATED) {
			return MessageFormat.format(resourceBundle.getString("CreateEventSubject"), report.getId(), report.getName());
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
