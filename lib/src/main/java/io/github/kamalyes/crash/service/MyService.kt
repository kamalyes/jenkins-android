package io.github.kamalyes.crash.service;

import android.app.Service
import android.content.Intent
import android.os.IBinder
import io.github.kamalyes.crash.util.NotificationUtil

/**
 * do nothing, just keep app run
 */

const val NOTIFICATION_ID = 444

class MyService : Service() {

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        startForeground(NOTIFICATION_ID, NotificationUtil.createNotification(this))
        return super.onStartCommand(intent, flags, startId)
    }
}