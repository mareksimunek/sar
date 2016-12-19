package cz.fav.sar.server.notifications;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.springframework.stereotype.Component;

public class Notificator extends Thread {

	public static enum NOTIFICATION_TYPE {
		CREATED,
		/* MODIFIED, SOLVED  */ }; // to be added later

	private static BlockingQueue<Notification> notificationQueue = new LinkedBlockingQueue<Notification>();
	private static ConcurrentLinkedQueue<NotificationTemplate> templates = new ConcurrentLinkedQueue<NotificationTemplate>();

	private static Notificator inst = new Notificator();

	private Notificator() {};

	public static Notificator getInstance() {
		return inst;
	}

	public void registerTemplate(NotificationTemplate template) {
		templates.add(template);
	}

	public void createAndQueueNotifications(NOTIFICATION_TYPE type, Object obj) {
		templates.forEach(nt -> {
			nt.createNotifications(type, obj).forEach(this::addtoQueue);
		});
	}

	private void addtoQueue(Notification n) {
		try {
			notificationQueue.put(n);
		} catch (InterruptedException e) {
			e.printStackTrace();
			// TODO log ?
		}
	}

	@Override
	public void run() {
		while (true) {
			try {
				notificationQueue.take().send();
			} catch (InterruptedException e) {
				e.printStackTrace();
				// TODO log ?
			}
		}
	}
	
}
