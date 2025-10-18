package com.du.ufabc.contador

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var buttonNext: Button
    private var count: Int = 0
    private lateinit var txtContador: TextView
    private lateinit var btnIncrementar: Button
    private lateinit var btnZerar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        Log.i("lifecycle", "onCreate")
        setContentView(R.layout.activity_main)

        buttonNext = findViewById(R.id.btnNext)
        buttonNext.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
//            passar parâmetro para a nova tela
            intent.putExtra("contador", count)
            startActivity(intent)
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // inicializa os componentes
        txtContador = findViewById(R.id.txtContador)
        // traz o valor do contador2 da MainActivity2 e adiciona a count
        val contador2 = intent.getIntExtra("contador2", 0)
        count += contador2
        txtContador.text = contador2.toString()

        btnIncrementar = findViewById(R.id.btnIncrementar)
        btnZerar = findViewById(R.id.btnZerar)

        // define o evento do botão de incrementar
        btnIncrementar.setOnClickListener {
            count++
            txtContador.text = count.toString()
        }

        // define o evento do botão de zerar
        btnZerar.setOnClickListener {
            count = 0
            txtContador.text = count.toString()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i("lifecycle", "onStart")
    }
    override fun onResume(){
        super.onResume()
        Log.i("lifecycle", "onResume")
    }
    override fun onPause(){
        super.onPause()
        Log.i("lifecycle", "onPause")
    }
    override fun onStop() {
        super.onStop()
        Log.i("lifecycle", "onStop")
    }
    override fun onDestroy() {
        Log.i("lifecycle", "onDestroy")
        super.onDestroy()
    }
}