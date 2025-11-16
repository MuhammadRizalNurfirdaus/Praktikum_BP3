package com.pab.aplikasi_data_mahasiswa

import android.os.Bundle
import android.content.Intent
import androidx.appcompat.app.AlertDialog
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.pab.aplikasi_data_mahasiswa.ui.DataMahasiswaActivity
import com.pab.aplikasi_data_mahasiswa.ui.PengaturanActivity
import com.pab.aplikasi_data_mahasiswa.ui.ProfileActivity

class MainActivity : AppCompatActivity() {
    var btnMenu1: Button? = null
    var btnMenu2: Button? = null
    var btnMenu3: Button? = null
    var btnMenu4: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnMenu1 = findViewById<Button?>(R.id.btnMenu1)
        btnMenu2 = findViewById<Button?>(R.id.btnMenu2)
        btnMenu3 = findViewById<Button?>(R.id.btnMenu3)
        btnMenu4 = findViewById<Button?>(R.id.btnMenu4)

        // Profil
        btnMenu1!!.setOnClickListener(View.OnClickListener { _: View? ->
            startActivity(Intent(this, ProfileActivity::class.java))
        })

        // Data Mahasiswa
        btnMenu2!!.setOnClickListener(View.OnClickListener { _: View? ->
            startActivity(Intent(this, DataMahasiswaActivity::class.java))
        })

        // Pengaturan
        btnMenu3!!.setOnClickListener(View.OnClickListener { _: View? ->
            startActivity(Intent(this, PengaturanActivity::class.java))
        })

        // Logout (konfirmasi lalu keluar)
        btnMenu4!!.setOnClickListener(View.OnClickListener { _: View? ->
            AlertDialog.Builder(this)
                .setTitle("Konfirmasi")
                .setMessage("Yakin ingin logout?")
                .setPositiveButton("Ya") { dialog, _ ->
                    dialog.dismiss()
                    Toast.makeText(this, "Logout berhasil", Toast.LENGTH_SHORT).show()
                    finishAffinity()
                }
                .setNegativeButton("Batal") { dialog, _ -> dialog.dismiss() }
                .show()
        })
    }
}