package com.example.medicandroidapplicationproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class BookAnAppointment : AppCompatActivity() {
    lateinit var edtfullname:EditText
    lateinit var edtphonenumber:EditText
    lateinit var edtbookingdate:EditText
    lateinit var mbtnsubmit:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_an_appointment)
        edtfullname = findViewById(R.id.mTvBkName)
        edtphonenumber = findViewById(R.id.mTvBkPhone)
        edtbookingdate = findViewById(R.id.mTvBkDate)
        mbtnsubmit = findViewById(R.id.btnSubmit)

        mbtnsubmit.setOnClickListener {  }
    }
}