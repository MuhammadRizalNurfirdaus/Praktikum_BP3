package com.pab.modul7_recycle_view

import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_KAMPUS = "extra_kampus"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // Enable back button in action bar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Get data from intent
        val kampus = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(EXTRA_KAMPUS, Kampus::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(EXTRA_KAMPUS)
        }

        // Set data to views
        kampus?.let {
            supportActionBar?.title = it.nama

            val imgPhoto: ImageView = findViewById(R.id.img_detail_photo)
            val tvName: TextView = findViewById(R.id.tv_detail_name)
            val tvLokasi: TextView = findViewById(R.id.tv_detail_lokasi)
            val tvSejarah: TextView = findViewById(R.id.tv_detail_sejarah)

            imgPhoto.setImageResource(it.photo)
            tvName.text = it.nama
            tvLokasi.text = it.lokasi
            tvSejarah.text = it.sejarah
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}

