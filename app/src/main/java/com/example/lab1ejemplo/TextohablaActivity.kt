package com.example.lab1ejemplo


import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import org.w3c.dom.Text
import java.util.Locale


class TextohablaActivity : AppCompatActivity() , TextToSpeech.OnInitListener {

    var editTextoLetra:EditText? = null
    var txtSpeach:TextToSpeech? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_textohabla)
        editTextoLetra = findViewById(R.id.editTextoLetra)


        editTextoLetra?.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable) {
                val contador = findViewById<TextView>(R.id.txtNroLetras)
                val tamanoString: String = java.lang.String.valueOf(s.length)
                contador.text = tamanoString
            }

        })

        /*
        editTextoLetra?.addTextChangedListener( object : TextWatcher { //esto es una instancia anonima

            override fun afterTextChanged(s: Editable) {

            }

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
            }
        })*/

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