package com.mobile.hitungbmi

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etNumber1 = findViewById<EditText>(R.id.etNumber1)
        val etNumber2 = findViewById<EditText>(R.id.etNumber2)
        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val btnSubtract = findViewById<Button>(R.id.btnSubtract)
        val btnMultiply = findViewById<Button>(R.id.btnMultiply)
        val btnDivide = findViewById<Button>(R.id.btnDivide)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        fun getNumbers(): Pair<Float, Float>? {
            val num1 = etNumber1.text.toString()
            val num2 = etNumber2.text.toString()

            if (num1.isEmpty() || num2.isEmpty()) {
                tvResult.text = "Masukkan kedua angka!"
                return null
            }
            return Pair(num1.toFloat(), num2.toFloat())
        }

        btnAdd.setOnClickListener {
            val numbers = getNumbers() ?: return@setOnClickListener
            val result = numbers.first + numbers.second
            tvResult.text = "Hasil: $result"
        }

        btnSubtract.setOnClickListener {
            val numbers = getNumbers() ?: return@setOnClickListener
            val result = numbers.first - numbers.second
            tvResult.text = "Hasil: $result"
        }

        btnMultiply.setOnClickListener {
            val numbers = getNumbers() ?: return@setOnClickListener
            val result = numbers.first * numbers.second
            tvResult.text = "Hasil: $result"
        }

        btnDivide.setOnClickListener {
            val numbers = getNumbers() ?: return@setOnClickListener
            if (numbers.second == 0f) {
                tvResult.text = "Tidak bisa membagi dengan nol!"
                return@setOnClickListener
            }
            val result = numbers.first / numbers.second
            tvResult.text = "Hasil: $result"
        }
    }
}
