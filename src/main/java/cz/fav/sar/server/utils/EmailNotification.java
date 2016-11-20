package cz.fav.sar.server.utils;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailNotification implements Notification{

	private static final String from = "cca@example.com";
	private static final String host = "localhost";
	
	private String to;
	private String subject;
	private String body;
		
	public EmailNotification(String to, String subject, String body) {
		this.to = to;
		this.subject = subject;
		this.body = body;
	}

	@Override
	public void send() {
		Properties properties = System.getProperties();
		properties.setProperty("mail.smtp.host", host);
		Session session = Session.getDefaultInstance(properties);
		try {
	         MimeMessage message = new MimeMessage(session);
	         message.setFrom(new InternetAddress(from));
	         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
	         message.setSubject(subject);
	         message.setText(body);
	         Transport.send(message);
		}catch (MessagingException mex) {
			mex.printStackTrace();
			// TODO log ?
		}
	}
}
