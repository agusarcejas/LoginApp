package com.example.loginapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class bienvenida : AppCompatActivity() {

    private val options = arrayOf("Android", "IOS")
    private val images = arrayOf(R.drawable.android, R.drawable.ios)

    private lateinit var btnSelect: Button
    private lateinit var imgOption: ImageView
    private lateinit var myCheckbox: CheckBox
    private lateinit var myInput: EditText
    private lateinit var btnSave: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bienvenida)

        btnSelect = findViewById(R.id.plataforma)
        imgOption = findViewById(R.id.itemSelected)
        myCheckbox = findViewById(R.id.otra)
        myInput = findViewById(R.id.preferencia)
        btnSave = findViewById(R.id.saveDatos)

        myInput.visibility = View.GONE

        myCheckbox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                myInput.visibility = View.VISIBLE
            } else {
                myInput.visibility = View.GONE
            }
        }

        btnSave.setOnClickListener{
            Toast.makeText(this, "Se han guardado sus datos correctamente", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, login::class.java)
            startActivity(intent)
        }

        btnSelect.setOnClickListener {
            showOptionsDialog()
        }
    }

    private fun showOptionsDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Selecciona una opción")
        builder.setAdapter(ArrayAdapter(this, android.R.layout.simple_list_item_1, options)) { _ , which ->
            imgOption.setImageResource(images[which])
        }
        builder.show()
    }
}