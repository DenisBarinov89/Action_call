package com.example.action_call

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class SecondActivity : AppCompatActivity() {

    private val gotPhoneFromMainActivity: TextView by lazy { findViewById(R.id.tvPhoneNumberFromMainActivity) }
    private val buttonToCall: Button by lazy { findViewById(R.id.btnCall) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        gotPhoneFromMainActivity.text = intent.getStringExtra(INTENT_KEY)
        buttonToCall.setOnClickListener {
            val phoneNumber = gotPhoneFromMainActivity.text
            val callIntent = Intent(Intent.ACTION_CALL)
            intent.setPackage(PACKAGE_TO_CALL)
            callIntent.data = Uri.parse("tel:$phoneNumber")
            startActivity(callIntent)
        }
    }
}
