package com.example.lab1ejemplo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnAcceder = findViewById<Button>(R.id.btnAcceder)
        btnAcceder.setOnClickListener {
            val i = Intent(this,AccederActivity::class.java)
            val b = Bundle()
            b.putString("nombre","Teofilo")
            b.putString("apellido","Copa")

            i.putExtras(b)
            startActivity(i)
        }

    }

    fun clickCrearCuenta(v: View?){
        val i = Intent(this,crearcuenta::class.java)
        startActivity(i)
    }



    fun clickRegistrar(v:View){

    }
}