package com.almax.simplebackgroundservice

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import kotlin.concurrent.thread

class BackgroundService : Service() {

    private var isRunning: Boolean = false

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "------service created------")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d(TAG, "------service started------")

        var counter = 0
        isRunning = true

        thread(start = true) {
            while (isRunning && counter < 10) {
                Log.d(TAG, "Counter value: $counter")
                Thread.sleep(2000L)
                counter += 1
            }
            if (counter == 10) {
                Log.d(TAG, "------service finished task execution------")
                stopSelf()
            }
        }

        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "------service stopped------")
        isRunning = false
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
}

const val TAG = "BackgroundServiceTAG"