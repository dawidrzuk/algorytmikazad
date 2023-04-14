package com.example.algorytmikazad

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val but = findViewById<Button>(R.id.button);
        val kmp = findViewById<TextView>(R.id.textView)
        val bf = findViewById<TextView>(R.id.textView2)
        val br = findViewById<TextView>(R.id.textView3)
        val rk = findViewById<TextView>(R.id.textView4)
        val wzorzec = findViewById<EditText>(R.id.editTextTextPersonName4)
        val dlugosc = findViewById<EditText>(R.id.editTextNumber2)

        fun losowanietekstu(ilosc: Int): String {
            val charPool: List<Char> =
                ('a'..'z') + ('A'..'Z') + ('0'..'9')
            return (1..ilosc)
                .map {
                    Random.nextInt(
                        0,
                        charPool.size
                    )
                }
                .map(charPool::get)
                .joinToString("")
        }
        val tekst = losowanietekstu(dlugosc.text.toString().toInt())
        fun prefixsufix(wzorzec: String): IntArray {
            val m = wzorzec.length
            val lps = IntArray(m)
            var len = 0
            var i = 1
            while (i < m) {
                if (wzorzec[i] == wzorzec[len]) {
                    len++
                    lps[i] = len
                    i++
                } else {
                    if (len != 0) {
                        len = lps[len - 1]
                    } else {
                        lps[i] = 0
                        i++
                    }
                }
            }
            return lps
        }

    }

}