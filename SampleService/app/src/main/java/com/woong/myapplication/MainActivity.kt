package com.woong.myapplication

import android.app.Notification
import android.app.PendingIntent
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import com.woong.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        binding.btStart.setOnClickListener {
            val intent = Intent(this, MyService::class.java);
            startService(intent);

        }


        binding.btStop.setOnClickListener {
            val intent = Intent(this, MyService::class.java);
            stopService(intent);
        }

        binding.btForestart.setOnClickListener {

            val intent = Intent(this, ForegroundService::class.java)
            ContextCompat.startForegroundService(this, intent)
        }

        binding.btForestop.setOnClickListener {

            val intent = Intent(this, ForegroundService::class.java)
            stopService(intent)

        }
    }
}