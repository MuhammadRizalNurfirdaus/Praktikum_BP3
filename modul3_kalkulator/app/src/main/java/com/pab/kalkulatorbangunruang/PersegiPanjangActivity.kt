package com.pab.kalkulatorbangunruang

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PersegiPanjangActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_persegi_panjang)

        val edtPanjang = findViewById<EditText>(R.id.edt_panjang)
        val edtLebar = findViewById<EditText>(R.id.edt_lebar)
        val btnHitung = findViewById<Button>(R.id.btn_hitung)
        val hasil = findViewById<TextView>(R.id.hasil)

        btnHitung.setOnClickListener {
            val panjang = edtPanjang.text.toString().toDoubleOrNull() ?: 0.0
            val lebar = edtLebar.text.toString().toDoubleOrNull() ?: 0.0
            val luas = panjang * lebar
            hasil.text = luas.toString()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}

