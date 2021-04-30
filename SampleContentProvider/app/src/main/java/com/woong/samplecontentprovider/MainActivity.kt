package com.woong.samplecontentprovider

import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import com.woong.samplecontentprovider.databinding.ActivityMainBinding

private lateinit var binding : ActivityMainBinding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        var view = binding.root
        setContentView(view)

        val c: Cursor? = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
        null, null, null, null)

        var str = ""
        c?.moveToFirst()
        if (c != null) {
            do{
                var name = c?.getString(c.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME))
                var phoneNumber = c?.getString(c.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))

                str += "이름 : " + name + "폰번호 : " + phoneNumber + "\n"
            }while(c.moveToNext())
        }
        binding.text2.text = str
    }
}

//참고 : https://bitsoul.tistory.com/155