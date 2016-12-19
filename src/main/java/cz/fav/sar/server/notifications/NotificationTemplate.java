package cz.fav.sar.server.notifications;

import java.util.List;

import cz.fav.sar.server.notifications.Notificator.NOTIFICATION_TYPE;

public interface NotificationTemplate {
	
	public List<Notification> createNotifications(NOTIFICATION_TYPE type, Object obj);

}
