package com.pab.tugas_m4

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton
import com.google.android.material.textview.MaterialTextView
import com.pab.tugas_m4.model.User

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.detail_root)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val tvName = findViewById<MaterialTextView>(R.id.tvName)
        val tvEmail = findViewById<MaterialTextView>(R.id.tvEmail)
        val tvAge = findViewById<MaterialTextView>(R.id.tvAge)
        val btnDial = findViewById<MaterialButton>(R.id.btnDial)
        val btnShare = findViewById<MaterialButton>(R.id.btnShare)

        val user: User? = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra("extra_user", User::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra("extra_user")
        }

        if (user != null) {
            tvName.text = getString(R.string.label_name_x, user.name)
            tvEmail.text = getString(R.string.label_email_x, user.email)
            tvAge.text = getString(R.string.label_age_x, user.age)
        } else {
            tvName.text = getString(R.string.label_name_unknown)
            tvEmail.text = getString(R.string.label_email_unknown)
            tvAge.text = getString(R.string.label_age_unknown)
            Toast.makeText(this, R.string.toast_no_user, Toast.LENGTH_SHORT).show()
        }

        btnDial.setOnClickListener {
            val phone = "123456789"
            val dialIntent = Intent(Intent.ACTION_DIAL, "tel:$phone".toUri())
            startActivity(dialIntent)
        }

        btnShare.setOnClickListener {
            val shareText = user?.let {
                getString(R.string.share_user_format, it.name, it.email, it.age)
            } ?: getString(R.string.share_default_text)

            val shareIntent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, shareText)
            }
            startActivity(Intent.createChooser(shareIntent, getString(R.string.share_chooser_title)))
        }
    }
}
