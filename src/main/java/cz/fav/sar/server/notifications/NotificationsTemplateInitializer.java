package cz.fav.sar.server.notifications;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class NotificationsTemplateInitializer {
	
	@Autowired
	private EmailNotificationTemplate template;
	
    @EventListener
    public void handleContextRefresh(ContextRefreshedEvent event) {
		Notificator notificator = Notificator.getInstance();
		notificator.registerTemplate(template);
    }	

}
