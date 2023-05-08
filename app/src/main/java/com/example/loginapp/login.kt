package com.example.loginapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class login : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val usernameEditText = findViewById<EditText>(R.id.usuario)
        val passwordEditText = findViewById<EditText>(R.id.password)
        val loginButton = findViewById<Button>(R.id.login)
        val registerButton = findViewById<Button>(R.id.register)

        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            // Validar datos del usuario y contraseña
            if (username == "Juan Torres" && password == "1234utn") {
                val intent = Intent(this, bienvenida::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Datos Incorrectos", Toast.LENGTH_SHORT).show()
            }
        }

        registerButton.setOnClickListener{
            val intent = Intent(this, registro::class.java)
            startActivity(intent)
        }
    }
}
