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

class SignUpActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_OurLadyOfAfricaSSMukono)
        setContentView(R.layout.activity_sign_up)
        auth= Firebase.auth
    }

    fun signup(view: View) {
        val email = findViewById<EditText>(R.id.editemail)
        val password = findViewById<EditText>(R.id.editpass)
        if (TextUtils.isEmpty(email.text.toString()) and TextUtils.isEmpty(password.text.toString())){
            Toast.makeText(this,"Please fill in all the fields", Toast.LENGTH_LONG).show()
        } else{
            auth.createUserWithEmailAndPassword(email.text.toString(),password.text.toString()).addOnCompleteListener{
                it->
                if (it.isSuccessful){
                    val intent= Intent(this,HomeActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                }.addOnFailureListener{exception->
                Toast.makeText(applicationContext,exception.localizedMessage,Toast.LENGTH_LONG).show()
            }
        }
    }

    fun loginsign(view: View) {
        val intent = Intent(this,LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}