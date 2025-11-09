package com.pab.modul3_activity2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class halaman_selanjutnya : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_halaman_selanjutnya)
//inisiasikan button ke variabel
        val btn_pindah: android.widget.Button = findViewById(R.id.btn_pindah_halaman1)
         // aksi ketika button diklik
         btn_pindah.setOnClickListener {
             val intent = android.content.Intent(this, MainActivity::class.java)
             startActivity(intent)
         }
     }
 }
