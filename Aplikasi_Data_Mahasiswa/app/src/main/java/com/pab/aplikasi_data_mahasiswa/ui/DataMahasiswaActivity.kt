package com.pab.aplikasi_data_mahasiswa.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.MaterialToolbar
import com.pab.aplikasi_data_mahasiswa.R
import android.widget.ArrayAdapter
import android.widget.ListView

class DataMahasiswaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_data_mahasiswa)

        val toolbar: MaterialToolbar = findViewById(R.id.toolbar)
        toolbar.setNavigationOnClickListener { finish() }

        val listView: ListView = findViewById(R.id.listMahasiswa)
        val data = listOf(
            "Rina - 2201001",
            "Budi - 2201002",
            "Sari - 2201003",
            "Andi - 2201004",
            "Dewi - 2201005"
        )
        listView.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, data)
    }
}
