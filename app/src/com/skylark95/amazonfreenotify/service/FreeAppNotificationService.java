package com.skylark95.amazonfreenotify.service;

import android.content.Intent;
import android.util.Log;

import com.commonsware.cwac.wakeful.WakefulIntentService;
import com.skylark95.amazonfreenotify.notification.FreeAppNotification;
import com.skylark95.amazonfreenotify.notification.FreeAppNotificationFactory;
import com.skylark95.amazonfreenotify.util.Logger;

public class FreeAppNotificationService extends WakefulIntentService {
	
	private static final String TAG = Logger.getTag(FreeAppNotificationService.class);

	public FreeAppNotificationService() {
		super("FreeAppNotificationService");
	}

	@Override
	protected void doWakefulWork(Intent intent) {
		Log.v(TAG, "Enter - doWakefulWork()");
		FreeAppNotification notification = FreeAppNotificationFactory.build(this);
		notification.show();
		Log.v(TAG, "EXIT - doWakefulWork()");
	}

	

}
