package com.pab.tugas_m4

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.pab.tugas_m4.model.User
import com.pab.tugas_m4.DetailActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val etName = findViewById<TextInputEditText>(R.id.etName)
        val etEmail = findViewById<TextInputEditText>(R.id.etEmail)
        val etAge = findViewById<TextInputEditText>(R.id.etAge)
        val btnSend = findViewById<MaterialButton>(R.id.btnSend)
        val btnOpenWeb = findViewById<MaterialButton>(R.id.btnOpenWeb)

        // Explicit intent to DetailActivity with Parcelable extra
        btnSend.setOnClickListener {
            val name = etName.text?.toString().orEmpty()
            val email = etEmail.text?.toString().orEmpty()
            val age = etAge.text?.toString()?.toIntOrNull() ?: 0
            val user = User(name, email, age)

            val intent = Intent(this@MainActivity, DetailActivity::class.java)
            intent.putExtra("extra_user", user)
            startActivity(intent)
        }

        // Implicit intent to open a web page
        btnOpenWeb.setOnClickListener {
            val url = "https://www.google.com"
            val webIntent = Intent(Intent.ACTION_VIEW, url.toUri())
            startActivity(webIntent)
        }
    }
}