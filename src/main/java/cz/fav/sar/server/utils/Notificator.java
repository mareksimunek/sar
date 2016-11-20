package cz.fav.sar.server.utils;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Notificator extends Thread{

	static BlockingQueue<Notification> notificationQueue = new LinkedBlockingQueue<Notification>();
	
	public static void sendNotification(Notification n)
	{
		try {
			notificationQueue.put(n);
		} catch (InterruptedException e) {
			// TODO log ?
		}
	}
	
	@Override
	public void run() {
		while(true){
			try {
				notificationQueue.take().send();
			} catch (InterruptedException e) {
				// TODO log ?
			}
		}
	}

}
