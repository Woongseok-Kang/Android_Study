package com.woong.myapplication

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.util.Log

class MyService : Service() {

    private lateinit var media :MediaPlayer

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }

    override fun onCreate() {
        super.onCreate()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {


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