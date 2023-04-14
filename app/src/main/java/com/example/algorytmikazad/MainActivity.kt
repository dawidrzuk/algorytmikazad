package com.example.algorytmikazad

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random
import kotlin.system.measureTimeMillis

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val but = findViewById<Button>(R.id.button);
        val kmp = findViewById<TextView>(R.id.textView5)
        val bf = findViewById<TextView>(R.id.textView6)
        val br = findViewById<TextView>(R.id.textView7)
        val rk = findViewById<TextView>(R.id.textView8)
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
        fun KMP(wzorzec: String, text: String): Int {
            val n = text.length
            val m = wzorzec.length
            val lps = prefixsufix(wzorzec)
            var i = 0
            var j = 0
            while (i < n) {
                if (text[i] == wzorzec[j]) {
                    i++
                    j++
                }
                if (j == m) {
                    return i - j
                } else if (i < n && text[i] != wzorzec[j]) {
                    if (j != 0) {
                        j = lps[j - 1]
                    } else {
                        i++
                    }
                }
            }
            return -1
        }
        but.setOnClickListener {
            if (dlugosc.text.toString() == "" || wzorzec.text.toString() == ""){
                Toast.makeText(this, "Uzupelnij wszystkie pola", Toast.LENGTH_SHORT).show()
            }
            else{
                val tekst = losowanietekstu(dlugosc.text.toString().toInt())
                var czaskmp = measureTimeMillis {
                    KMP(wzorzec.text.toString(),tekst)
                }
                kmp.text = "$czaskmp ms"
            }
        }

    }

}