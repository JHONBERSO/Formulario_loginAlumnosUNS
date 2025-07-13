package com.example.formulario_login

import com.google.firebase.auth.FirebaseAuth
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        auth = FirebaseAuth.getInstance()
        emailEditText = findViewById(R.id.emailEditText)
        passwordEditText = findViewById(R.id.passwordEditText)
        loginButton = findViewById(R.id.loginButton)

        val registerButton = findViewById<Button>(R.id.registerButton)

        registerButton.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        val textWatcher = object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                val email = emailEditText.text.toString()
                val password = passwordEditText.text.toString()
                val isValid = isValidUNSEmail(email) && isValidPassword(password)

                loginButton.isEnabled = isValid
                loginButton.backgroundTintList = ContextCompat.getColorStateList(
                    this@MainActivity,
                    if (isValid) R.color.primary else R.color.gray_dark


                )
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        }


        emailEditText.addTextChangedListener(textWatcher)
        passwordEditText.addTextChangedListener(textWatcher)


        emailEditText.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                val email = emailEditText.text.toString()
                if (!isValidUNSEmail(email) && email.isNotEmpty()) {
                    emailEditText.error = "Correo no válido (ej: 0202114025@uns.edu.pe)"
                } else {
                    emailEditText.error = null
                }
            }
        }

        passwordEditText.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                val password = passwordEditText.text.toString()
                if (!isValidPassword(password) && password.isNotEmpty()) {
                    passwordEditText.error = "La contraseña debe tener al menos 6 caracteres"
                } else {
                    passwordEditText.error = null
                }
            }
        }

        loginButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Login correcto
                        val intent = Intent(this, BienvenidaActivity::class.java)
                        intent.putExtra("email", email)
                        startActivity(intent)
                        finish()  // Opcional: evita volver con el botón "Atrás"
                    } else {
                        // Login fallido
                        Toast.makeText(this, "Correo o contraseña incorrectos", Toast.LENGTH_SHORT).show()
                    }
                }
        }


    }

    private fun isValidUNSEmail(email: String): Boolean {
        return Regex("^\\d{10}@uns\\.edu\\.pe$").matches(email)
    }

    private fun isValidPassword(password: String): Boolean {
        return password.length >= 6
    }
}
