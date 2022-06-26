package com.example.action_call

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private val buttonStartSecondActivity : Button by lazy { findViewById(R.id.bnStartSecondActivity) }
    private val phoneNumberFromUser : EditText by lazy { findViewById(R.id.etPhoneNumber) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonStartSecondActivity.setOnClickListener {
            if (phoneNumberFromUser.text.isNotEmpty()) {
                val intent = Intent(this, SecondActivity::class.java).apply {
                    putExtra(INTENT_KEY, phoneNumberFromUser.editableText.toString())
                }
                startActivity(intent)
            }
        }
    }
}