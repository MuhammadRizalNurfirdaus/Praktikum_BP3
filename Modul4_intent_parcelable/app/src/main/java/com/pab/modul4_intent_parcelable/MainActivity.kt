package com.pab.modul4_intent_parcelable

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btn_pindah_dengan_objek: Button = findViewById(R.id.btn_pindah_objek)
        btn_pindah_dengan_objek.setOnClickListener{
            // Membuat objek Mahasiswa
            val Mahasiswa = Mahasiswa(
                "Dede Husen",
                "dedehusen@uniku.ac.id",
                "215551068",
                25,
                "Kuningan"
            )
            // Memasukkan objek Mahasiswa ke dalam Intent dengan kunci "extra_mahasiswa"
            val pindahDenganObjek = Intent(this@MainActivity, PindahDenganObjek::class.java)
            pindahDenganObjek.putExtra(PindahDenganObjek.EXTRA_MAHASISWA, Mahasiswa)
            startActivity(pindahDenganObjek)

        }

    }
}