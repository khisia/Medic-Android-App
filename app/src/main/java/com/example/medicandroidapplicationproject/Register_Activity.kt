package com.example.medicandroidapplicationproject

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.medicandroidapplicationproject.LoginActivity
import com.example.medicandroidapplicationproject.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class Register_Activity : AppCompatActivity() {
    lateinit var edtname: EditText
    lateinit var edtemail: EditText
    private lateinit var edtphone: EditText
    private lateinit var edtpassword: EditText
    lateinit var edtConfirmPassword: EditText
    lateinit var mbtnReg: Button
    lateinit var txtloggedIn: TextView
    lateinit var progressDialog:ProgressDialog

    // create Firebase authentication object
    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // View Bindings
        edtname = findViewById(R.id.mTvName)
        edtemail = findViewById(R.id.mTvEmail)
        edtphone = findViewById(R.id.mTvPhone)
        edtpassword = findViewById(R.id.mTvPassword)
        edtConfirmPassword = findViewById(R.id.mTvConfPassword)
        mbtnReg = findViewById(R.id.mBtnReg)
        txtloggedIn = findViewById(R.id.mTvOrLogin)
        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Registering...")
        progressDialog.setMessage("Please wait...")

        // Initialising auth object
        auth = Firebase.auth

        mbtnReg.setOnClickListener {
            signUpUser()
        }

        // switching from signUp Activity to Login Activity
        txtloggedIn.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

    }

    private fun signUpUser() {
        val email = edtemail.text.toString()
        val pass = edtpassword.text.toString()
        val confirmPassword = edtConfirmPassword.text.toString()

        // check pass
        if (email.isBlank() || pass.isBlank() || confirmPassword.isBlank()) {
            Toast.makeText(this, "Email and Password can't be blank", Toast.LENGTH_SHORT).show()
            return
        }

        if (pass != confirmPassword) {
            Toast.makeText(this, "Password and Confirm Password do not match", Toast.LENGTH_SHORT)
                .show()
            return
        }
        // If all credential are correct
        // We call createUserWithEmailAndPassword
        // using auth object and pass the
        // email and pass in it.
        auth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(this) {
            if (it.isSuccessful) {
                Toast.makeText(this, "Your Registration was Successful", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "Registration failed!!!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
