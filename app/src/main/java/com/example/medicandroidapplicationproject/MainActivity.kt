package com.example.medicandroidapplicationproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var start:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        start = findViewById(R.id.mBtnStart)

        start.setOnClickListener {
            var   tembea = Intent(this,Register_Activity::class.java)
            startActivity(tembea)
        }
    }
}