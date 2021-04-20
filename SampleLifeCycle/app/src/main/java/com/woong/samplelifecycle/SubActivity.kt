package com.woong.samplelifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class SubActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        //Log.d("SubActivity", "onCreate호출")
    }


    override fun onStart() {
        super.onStart()
        Log.d("SubActivity", "onStart호출")
    }

    override fun onResume() {
        super.onResume()
        Log.d("SubActivity", "onResume호출")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("SubActivity", "onRestart호출")
    }

    override fun onPause() {
        super.onPause()
        Log.d("SubActivity", "onPause호출")
    }

    override fun onStop() {
        super.onStop()
        Log.d("SubActivity", "onStop호출")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("SubActivity", "onDestroy호출")
    }
}