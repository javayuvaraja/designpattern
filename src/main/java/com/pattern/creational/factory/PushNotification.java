package com.pattern.creational.factory;

public class PushNotification implements Notification{

	@Override
	public void notifyUser() {
		System.out.println("Push Notification");
	}

}
