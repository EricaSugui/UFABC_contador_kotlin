package com.du.ufabc.contador

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.du.ufabc.contador.R.id.btnBack

class MainActivity2 : AppCompatActivity() {
    lateinit var buttonBack: Button
    lateinit var textContador2: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)

        buttonBack = findViewById(btnBack)
        textContador2 = findViewById(R.id.txtContador2)
        val contador = intent.getIntExtra("contador", 0)

        val resultado = contador.toString()
        textContador2.text = resultado

        buttonBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            // leva o valor de volta para a MainActivity
            intent.putExtra("contador2", contador)

            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}