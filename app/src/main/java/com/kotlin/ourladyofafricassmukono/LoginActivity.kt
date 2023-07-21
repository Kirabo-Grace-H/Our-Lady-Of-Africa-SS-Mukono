package com.kotlin.ourladyofafricassmukono

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_OurLadyOfAfricaSSMukono)
        setContentView(R.layout.activity_login)
        auth= Firebase.auth


    }

    fun signin(view: View) {
        val email = findViewById<EditText>(R.id.etemail)
        val password = findViewById<EditText>(R.id.etpassword)
        if (TextUtils.isEmpty(email.text.toString()) || TextUtils.isEmpty(password.text.toString())){
            Toast.makeText(this,"Please fill in all the fields", Toast.LENGTH_LONG).show()
        } else{
            auth.signInWithEmailAndPassword(email.text.toString(), password.text.toString()).addOnCompleteListener{
              it->
              if (it.isSuccessful)  {
                  val intent = Intent(this,HomeActivity::class.java)
                  startActivity(intent)
                  finish()
              } else{
                  Toast.makeText(this,"Please enter correct credentials",Toast.LENGTH_LONG).show()
              }
            }
        }

    }

    fun signuplogin(view: View) {
        val intent = Intent(this,SignUpActivity::class.java)
        startActivity(intent)
        finish()
    }
}