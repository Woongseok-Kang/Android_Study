package com.woong.samplebroadcastreceiver

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.pedro.library.AutoPermissions


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        AutoPermissions.Companion.loadAllPermissions(this, 101)


    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    fun onDenied(requestCode: Int, permissions: Array<String?>) {
        Toast.makeText(this, "permissions denied : " + permissions.size, Toast.LENGTH_LONG).show()
    }

    fun onGranted(requestCode: Int, permissions: Array<String?>) {
        Toast.makeText(this, "permissions granted : " + permissions.size, Toast.LENGTH_LONG).show()
    }


}