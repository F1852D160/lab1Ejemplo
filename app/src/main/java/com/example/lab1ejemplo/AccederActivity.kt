package com.example.lab1ejemplo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class AccederActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_acceder)
        val btnTxtVoz = findViewById<Button>(R.id.btnTxtVoz)
        btnTxtVoz.setOnClickListener {
            val i = Intent(this,TextohablaActivity::class.java)
            startActivity(i)
        }

        val btnSalir = findViewById<Button>(R.id.btnSalir)
        btnSalir.setOnClickListener {
            finish();
            System.exit(0);
        }
    }
}