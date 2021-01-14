package com.dscreva.intentexamples

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val implecit = findViewById<Button>(R.id.implicit)
        val explecit = findViewById<Button>(R.id.explicit)
        explecit.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
        implecit.setOnClickListener {
            Toast.makeText(this,"This is my example app", Toast.LENGTH_LONG).show()
            val intent = Intent(Intent.ACTION_SEND)
            intent.data = Uri.parse("Email")
            val str_array = arrayOf("shreevallabhas@gmail.com")
            intent.putExtra(Intent.EXTRA_EMAIL, str_array)
            intent.putExtra(Intent.EXTRA_SUBJECT, "This is my test mail")
            intent.putExtra(Intent.EXTRA_TEXT,"This is a testing mail, to check my app functions or not")
            intent.type = "message/rfc822"
            val a = Intent.createChooser(intent, "Launch the mail app")
            startActivity(a)
        }

    }
}