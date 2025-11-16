package com.pab.aplikasi_data_mahasiswa.ui

import android.content.Context
import android.os.Bundle
import android.widget.CompoundButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.switchmaterial.SwitchMaterial
import com.pab.aplikasi_data_mahasiswa.R

class PengaturanActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_pengaturan)

        val toolbar: MaterialToolbar = findViewById(R.id.toolbar)
        val switchNotif: SwitchMaterial = findViewById(R.id.switchNotifikasi)

        toolbar.setNavigationOnClickListener { finish() }

        val prefs = getSharedPreferences("app_settings", Context.MODE_PRIVATE)
        val enabled = prefs.getBoolean("notif_enabled", true)
        switchNotif.isChecked = enabled

        switchNotif.setOnCheckedChangeListener { _: CompoundButton, isChecked: Boolean ->
            prefs.edit().putBoolean("notif_enabled", isChecked).apply()
            Toast.makeText(
                this,
                if (isChecked) "Notifikasi diaktifkan" else "Notifikasi dimatikan",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}
