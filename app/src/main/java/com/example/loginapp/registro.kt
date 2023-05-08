package com.example.loginapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class registro : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        val cancelButton = findViewById<Button>(R.id.cancel)
        val saveButton = findViewById<Button>(R.id.save)


        cancelButton.setOnClickListener{
            val intent = Intent(this, login::class.java)
            startActivity(intent)
        }

        saveButton.setOnClickListener{

            val nameText = findViewById<EditText>(R.id.name)
            val emailText = findViewById<EditText>(R.id.email)
            val passwordText = findViewById<EditText>(R.id.pass)
            val repeatPasswordText = findViewById<EditText>(R.id.rpass)

            if (nameText.text.toString().isNullOrBlank()) {
                Toast.makeText(this, "Debe ingresar un nombre", Toast.LENGTH_SHORT).show()
            }
            else if (emailText.text.toString().isNullOrBlank()) {
                Toast.makeText(this, "Debe ingresar un email", Toast.LENGTH_SHORT).show()
            }
            else if (passwordText.length() < 6) {
                Toast.makeText(this, "Debe ingresar una contraseña con 6 o mas caracteres", Toast.LENGTH_SHORT).show()
            }
            else if (passwordText.text.toString() != repeatPasswordText.text.toString()) {
                Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
            }
            else {
                val intent = Intent(this, login::class.java)
                startActivity(intent)
                Toast.makeText(this, "Se ha registrado correctamente el usuario", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

