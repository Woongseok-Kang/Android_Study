package com.woong.myapplication

import android.app.*
import android.content.ComponentName
import android.content.Intent
import android.media.MediaPlayer
import android.os.Build
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat

class ForegroundService : Service() {

    private lateinit var media : MediaPlayer

    val CHANNEL_ID = "FG5153"
    val NOTI_ID = 153

    fun createNotificationChannel(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val serviceChannel = NotificationChannel(CHANNEL_ID, "foreground", NotificationManager.IMPORTANCE_DEFAULT)
            val manager = getSystemService(NotificationManager::class.java)
            manager.createNotificationChannel(serviceChannel)
        }
    }

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }

    override fun onCreate() {
        super.onCreate()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        createNotificationChannel()
        val notification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("음악재생")
            .setSmallIcon(R.mipmap.ic_launcher_round)
            .build()

        startForeground(NOTI_ID, notification)
        media = MediaPlayer.create(this, R.raw.myself)

        media.start()
        Log.d("Myservice", "서비스 시작")

        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        media.stop()
        media.release()
        Log.d("Myservice", "서비스 종료")
    }

}