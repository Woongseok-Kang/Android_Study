package com.woong.samplelifecycle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.woong.samplelifecycle.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var mBinding: ActivityMainBinding? = null
    private val binding get() = mBinding!!



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d("MainActivity", "onCreate호출")


        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btIntent.setOnClickListener {
            val intent = Intent(this, SubActivity::class.java)
            startActivity(intent)
        }


    }

    override fun onStart() {
        super.onStart()
        Log.d("MainActivity", "onStart호출")
    }

    override fun onResume() {
        super.onResume()
        Log.d("MainActivity", "onResume호출")
    }

    override fun onPause() {
        super.onPause()
        Log.d("MainActivity", "onPause호출")
    }


    override fun onRestart() {
        super.onRestart()
        Log.d("MainActivity", "onRestart호출")
    }

    override fun onStop() {
        super.onStop()
        Log.d("MainActivity", "onStop호출")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MainActivity", "onDestroy호출")
    }
}

