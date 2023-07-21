package com.kotlin.ourladyofafricassmukono

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_OurLadyOfAfricaSSMukono)
        setContentView(R.layout.activity_main)

        val mainlogin = findViewById<Button>(R.id.loginmain)
        val mainsignup = findViewById<Button>(R.id.signupmain)

        mainlogin.setOnClickListener {
            val i = Intent(this,LoginActivity::class.java)
            startActivity(i)
            finish()
        }
        mainsignup.setOnClickListener {
            val b = Intent(this,SignUpActivity::class.java)
            startActivity(b)
            finish()
        }

    }
}