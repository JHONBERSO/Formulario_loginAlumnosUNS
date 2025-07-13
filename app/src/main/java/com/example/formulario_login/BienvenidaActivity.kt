package com.example.formulario_login

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class BienvenidaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bienvenida)

        val tvUserName: TextView = findViewById(R.id.tv_user_name)
        val tvUserEmail: TextView = findViewById(R.id.tv_user_email)
        val logoutButton: Button = findViewById(R.id.btn_logout)

        val email = intent.getStringExtra("email") ?: "correo@uns.edu.pe"
        tvUserEmail.text = email
        tvUserName.text = "Alumno UNS"

        logoutButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
    }
}
