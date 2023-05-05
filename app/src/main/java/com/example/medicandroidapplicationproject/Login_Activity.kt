package com.example.medicandroidapplicationproject

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private lateinit var edtLogEmail:EditText
    lateinit var edtpassword:EditText
    private lateinit var btnlogin:Button
    lateinit var progressDialog:ProgressDialog

    // Creating firebaseAuth object
    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // View Binding
        edtLogEmail = findViewById(R.id.mTvLogEmail)
        edtpassword = findViewById(R.id.mTvLogPassword)
        btnlogin = findViewById(R.id.mBtnLogIn)

        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Signing in...")
        progressDialog.setMessage("Please wait...")
        // initialising Firebase auth object
        auth = FirebaseAuth.getInstance()

        btnlogin.setOnClickListener {
            login()
        }

    }

    private fun login() {
        val email = edtLogEmail.text.toString()
        val pass = edtpassword.text.toString()
        // calling signInWithEmailAndPassword(email, pass)
        // function using Firebase auth object
        // On successful response Display a Toast
        auth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(this) {
            if (it.isSuccessful) {
                Toast.makeText(this, "Successfully LoggedIn", Toast.LENGTH_SHORT).show()
            } else
                Toast.makeText(this, "Log In failed ", Toast.LENGTH_SHORT).show()
        }
    }

}
