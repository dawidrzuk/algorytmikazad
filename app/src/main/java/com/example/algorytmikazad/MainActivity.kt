package com.example.algorytmikazad

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val but = findViewById<Button>(R.id.button);
        val kmp = findViewById<TextView>(R.id.textView)
        val bf = findViewById<TextView>(R.id.textView2)
        val br = findViewById<TextView>(R.id.textView3)
        val rk = findViewById<TextView>(R.id.textView4)
        val wzorzec = findViewById<EditText>(R.id.editTextTextPersonName)
        val dlugosc = findViewById<EditText>(R.id.editTextTextPersonName2)

    }
}