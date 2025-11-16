package com.pab.halaman_login

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.button.MaterialButton

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val emailField: TextInputEditText = findViewById(R.id.etEmail)
        val passwordField: TextInputEditText = findViewById(R.id.etPassword)
        val btnMasuk: MaterialButton = findViewById(R.id.btnMasuk)
        val btnDaftar: MaterialButton = findViewById(R.id.btnDaftar)

        btnMasuk.setOnClickListener {
            val email = emailField.text?.toString().orEmpty().trim()
            val password = passwordField.text?.toString().orEmpty()
            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Email atau password kosong", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Login ditekan: $email", Toast.LENGTH_SHORT).show()
            }
        }

        btnDaftar.setOnClickListener {
            Toast.makeText(this, "Tombol Daftar ditekan", Toast.LENGTH_SHORT).show()
        }
    }
}
