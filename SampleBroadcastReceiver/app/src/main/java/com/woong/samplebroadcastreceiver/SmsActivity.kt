package com.woong.samplebroadcastreceiver

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.woong.samplebroadcastreceiver.databinding.ActivitySmsBinding

class SmsActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySmsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySmsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.button.setOnClickListener {
            finish()
        }

        val passedIntent: Intent = intent
        processIntent(passedIntent)

    }

    override fun onNewIntent(intent: Intent?) {

        processIntent(intent)
        super.onNewIntent(intent)
    }

    private fun processIntent(intent: Intent?) {

        if (intent != null) {
            val sender = intent.getStringExtra("sender")
            val contents = intent.getStringExtra("contents")
            val receivedDate = intent.getStringExtra("receivedDate")
            binding.editText.setText(sender)
            binding.editText2.setText(contents)
            binding.editText3.setText(receivedDate)
        }
    }
}
