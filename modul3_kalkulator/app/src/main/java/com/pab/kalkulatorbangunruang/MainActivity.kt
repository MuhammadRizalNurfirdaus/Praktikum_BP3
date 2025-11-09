package com.pab.kalkulatorbangunruang

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
//inisialisasi button yang ada di activity_main.xml 
        val btnPersegi = findViewById<Button>(R.id.btn_persegi)
        val btnSegitiga = findViewById<Button>(R.id.btn_segitiga)
        val btnPersegiPanjang = findViewById<Button>(R.id.btn_persegi_panjang)
        val btnLingkaran = findViewById<Button>(R.id.btn_lingkaran)
        btnPersegi.setOnClickListener {
//intent untuk berpindah activity
            val intent = Intent(this, PersegiActivity::class.java)
            startActivity(intent)
        }
        btnSegitiga.setOnClickListener {
//intent untuk berpindah activity
            val intent = Intent(this, SegitigaActivity::class.java)
            startActivity(intent)
        }
        btnPersegiPanjang.setOnClickListener {
            val intent = Intent(this, com.pab.kalkulatorbangunruang.PersegiPanjangActivity::class.java)
            startActivity(intent)
        }
        btnLingkaran.setOnClickListener {
            val intent = Intent(this, com.pab.kalkulatorbangunruang.LingkaranActivity::class.java)
            startActivity(intent)
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right,
                systemBars.bottom)
            insets
        }
    }
}