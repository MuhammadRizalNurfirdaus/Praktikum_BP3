package com.pab.modul7_recycle_view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pab.modul7_recycle_view.R // Pastikan ini sesuai dengan nama package project Anda

class MainActivity : AppCompatActivity() {

    //Buat variable rvKampus sebagai variabel dari recycle viewer
    private lateinit var rvKampus: RecyclerView
    private val list = ArrayList<Kampus>() // Menggunakan ArrayList dari data class Kampus

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        rvKampus = findViewById(R.id.kampus)
        rvKampus.setHasFixedSize(true)

        list.addAll(getListKampus())
        showRecyclerList()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun getListKampus(): Collection<Kampus> {
        val dataName = resources.getStringArray(R.array.data_kampus)
        val dataLokasi = resources.getStringArray(R.array.data_lokasi)
        val dataSejarah = resources.getStringArray(R.array.data_sejarah_kampus)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listKampus = ArrayList<Kampus>()
        for (i in dataName.indices) {
            val kampus = Kampus(
                dataName[i],
                dataLokasi[i],
                dataSejarah[i],
                dataPhoto.getResourceId(i, -1) // Mengambil resource ID dari TypedArray
            )
            listKampus.add(kampus)
        }
        dataPhoto.recycle() // Penting untuk melepaskan TypedArray
        return listKampus
    }

    private fun showRecyclerList() {
        rvKampus.layoutManager = LinearLayoutManager(this)
        val listKampusAdapter = ListKampusAdapter(list)
        rvKampus.adapter = listKampusAdapter
    }
}