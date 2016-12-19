package cz.fav.sar.server.notifications;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import cz.fav.sar.server.utils.MailSettings;

public class EmailNotification implements Notification {

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
		try {
			Properties props = new Properties();

			props.put("mail.transport.protocol", "smtps");
			props.put("mail.smtps.host", MailSettings.SMTP_HOST_NAME);
			props.put("mail.smtps.auth", "true");
			// props.put("mail.smtps.quitwait", "false");

			Session mailSession = Session.getDefaultInstance(props);
			mailSession.setDebug(true);
			Transport transport = mailSession.getTransport();

			MimeMessage message = new MimeMessage(mailSession);
			message.setSubject(subject);
			message.setContent(body, "text/html; charset=UTF-8");

			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

			transport.connect(MailSettings.SMTP_HOST_NAME, MailSettings.SMTP_HOST_PORT, MailSettings.SMTP_AUTH_USER, MailSettings.SMTP_AUTH_PWD);
			transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
			transport.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		/*
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
		*/
	}
}
