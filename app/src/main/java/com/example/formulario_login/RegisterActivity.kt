package com.example.formulario_login

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    private fun isValidUNSEmail(email: String): Boolean {
        return email.matches(Regex("\\d{10}@uns\\.edu\\.pe"))
    }

    private fun isValidPassword(password: String): Boolean {
        return password.length >= 6
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        auth = FirebaseAuth.getInstance()

        val emailEditText = findViewById<EditText>(R.id.emailEditText)
        val passwordEditText = findViewById<EditText>(R.id.passwordEditText)
        val registerButton = findViewById<Button>(R.id.registerButton)
        val backToLoginButton = findViewById<Button>(R.id.backToLoginButton)

        // Desactivar inicialmente el botón
        registerButton.isEnabled = false
        registerButton.backgroundTintList = ContextCompat.getColorStateList(this, R.color.button_disabled)

        // TextWatcher para validación en tiempo real
        val textWatcher = object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                val email = emailEditText.text.toString()
                val password = passwordEditText.text.toString()

                val isEmailValid = isValidUNSEmail(email)
                val isPasswordValid = isValidPassword(password)
                val isValid = isEmailValid && isPasswordValid

                // Mostrar errores si hay
                if (!isEmailValid && email.isNotEmpty()) {
                    emailEditText.error = "Correo no válido (ej: 0202114025@uns.edu.pe)"
                } else {
                    emailEditText.error = null
                }

                if (!isPasswordValid && password.isNotEmpty()) {
                    passwordEditText.error = "La contraseña debe tener al menos 6 caracteres"
                } else {
                    passwordEditText.error = null
                }

                // Cambiar color y activar botón
                registerButton.isEnabled = isValid
                registerButton.backgroundTintList = ContextCompat.getColorStateList(
                    this@RegisterActivity,
                    if (isValid) R.color.primary_dark else R.color.gray_dark
                )
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        }

        // Asociar TextWatcher a los EditText
        emailEditText.addTextChangedListener(textWatcher)
        passwordEditText.addTextChangedListener(textWatcher)

        // Acción al registrar
        registerButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        val intent = Intent(this, BienvenidaActivity::class.java)
                        intent.putExtra("email", email)
                        startActivity(intent)
                        finish()
                    } else {
                        Toast.makeText(this, "No se pudo registrar: ${task.exception?.message}", Toast.LENGTH_LONG).show()
                    }
                }
        }

        // Acción al volver
        backToLoginButton.setOnClickListener {
            finish() // Vuelve al login
        }
    }
}

