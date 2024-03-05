package com.example.lab1ejemplo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.util.Locale

class TextohablaActivity : AppCompatActivity() , TextToSpeech.OnInitListener {

    var editTextoLetra:EditText? = null
    var txtSpeach:TextToSpeech? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_textohabla)
        editTextoLetra = findViewById(R.id.editTextoLetra)

        //inicializando text to speach
        txtSpeach = TextToSpeech(this,this)


        val btnHabla = findViewById<Button>(R.id.btnHabla)
        btnHabla.setOnClickListener {
            Toast.makeText(this@TextohablaActivity,"Click en el boton", Toast.LENGTH_SHORT).show()
            var texto: String = editTextoLetra?.text.toString();
            Log.i("VALOR_LAB1_BUTTON", texto)
            txtSpeach!!.speak(texto,TextToSpeech.QUEUE_FLUSH,null, "")
        }
    }

    override fun onInit(status: Int) {
        if(status == TextToSpeech.SUCCESS){

            txtSpeach!!.setLanguage(Locale.getDefault())
            Log.i("VALOR_LAB1","TextToSpeech habilitado")
        }else{
            Log.i("VALOR_LAB1"," TextToSpeech no soportado")
        }
    }


}