package com.woong.samplebroadcastreceiver

import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.telephony.SmsMessage
import android.util.Log
import java.text.SimpleDateFormat
import java.util.*


@SuppressLint("SimpleDateFormat")
class SmsReceiver : BroadcastReceiver() {

    val tag :String = "SmsReceiver"
    val format:SimpleDateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")



    override fun onReceive(context: Context, intent: Intent) {
       Log.i(tag, "onReceive() 호출")

        val bundle: Bundle? = intent.extras
        val messages:Array<SmsMessage?>? = parseSmsMessage(bundle)
        if (messages != null && messages.isNotEmpty()) {
            val sender: String? = messages[0]?.originatingAddress
            Log.i(TAG, "SMS sender : $sender")
            val contents: String? = messages[0]?.messageBody
            Log.i(TAG, "SMS contents : $contents")
            val receivedDate = messages[0]?.let { Date(it.timestampMillis) }
            Log.i(TAG, "SMS received date : " + receivedDate.toString())
            sendToActivity(context, sender, contents, receivedDate)
        }
    }

    private fun parseSmsMessage(bundle: Bundle?): Array<SmsMessage?>? {
        val objs = bundle?.get("pdus") as Array<*>?
        val messages = objs?.let { arrayOfNulls<SmsMessage>(it.size) }
        val smsCount: Int = objs!!.size
        for (i in 0 until smsCount) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                val format = bundle?.getString("format")
                messages?.set(i, SmsMessage.createFromPdu(objs!![i] as ByteArray?, format))
            } else {
                messages?.set(i, SmsMessage.createFromPdu(objs!![i] as ByteArray?))
            }
        }

        return messages


    }

    private fun sendToActivity(
        context: Context,
        sender: String?,
        contents: String?,
        receivedDate: Date?
    ){

        val myIntent = Intent(context, SmsActivity::class.java)
        myIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_SINGLE_TOP or Intent.FLAG_ACTIVITY_CLEAR_TOP)
        myIntent.putExtra("sender",sender)
        myIntent.putExtra("contents", contents)
        myIntent.putExtra("receivedDate", format.format(receivedDate))
        context.startActivity(myIntent)

    }
}