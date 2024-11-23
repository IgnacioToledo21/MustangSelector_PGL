package com.example.eaut2_06_proyectoandroidmustangselector.ui.models

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.eaut2_06_proyectoandroidmustangselector.R

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)  // Asegúrate de tener este layout

        // Obtener los datos del Intent
        val title = intent.getStringExtra("TITLE")
        val description = intent.getStringExtra("DESCRIPTION")
        val price = intent.getStringExtra("PRICE")
        val imageResId = intent.getIntExtra("IMAGE_RES_ID", -1)  // Obtener la imagen por su ID de recurso

        // Asignar valores a los TextViews
        val titleTextView: TextView = findViewById(R.id.textTitle)
        val descriptionTextView: TextView = findViewById(R.id.textDescription)
        val priceTextView: TextView = findViewById(R.id.textPrice)
        val imageModel: ImageView = findViewById(R.id.image_model)

        titleTextView.text = title ?: "Título no disponible"
        descriptionTextView.text = description ?: "Descripción no disponible"
        priceTextView.text = price ?: "Precio no disponible"

        // Asignar la imagen al ImageView
        if (imageResId != -1) {
            imageModel.setImageResource(imageResId)  // Asignamos la imagen correspondiente
        } else {
            imageModel.setImageResource(0) // Dejarlo vacío si no hay imagen
        }
    }
}
