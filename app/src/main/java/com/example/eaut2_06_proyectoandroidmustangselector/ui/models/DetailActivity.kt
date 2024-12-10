package com.example.eaut2_06_proyectoandroidmustangselector.ui.models

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.example.eaut2_06_proyectoandroidmustangselector.MainActivity
import com.example.eaut2_06_proyectoandroidmustangselector.R


class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // Obtener los datos del Intent
        val title = intent.getStringExtra("TITLE")
        val description = intent.getStringExtra("DESCRIPTION")
        val price = intent.getStringExtra("PRICE")
        val imageResId = intent.getIntExtra("IMAGE_RES_ID", -1)
        val characteristics = intent.getStringExtra("CHARACTERISTICS")

        // Configurar los valores en la vista
        findViewById<TextView>(R.id.textTitle).text = title ?: "Título no disponible"
        findViewById<TextView>(R.id.textDescription).text = description ?: "Descripción no disponible"
        findViewById<TextView>(R.id.textPrice).text = price ?: "Precio no disponible"
        findViewById<TextView>(R.id.textCharacteristicsDescription).text = characteristics ?: "Características no disponibles"

        val imageModel: ImageView = findViewById(R.id.image_model)
        if (imageResId != -1) {
            imageModel.setImageResource(imageResId)
        } else {
            imageModel.setImageResource(0)
        }

        val botonComprar: Button = findViewById(R.id.btnComprar)
        botonComprar.setOnClickListener {
            // Crear un Intent para abrir AppointmentActivity
            val intent = Intent(this, AppointmentActivity::class.java)

            // Si necesitas enviar datos a la nueva actividad, puedes hacerlo aquí
            intent.putExtra("EXTRA_MODEL_TITLE", "Título del modelo") // Ejemplo de cómo pasar datos
            startActivity(intent)
        }



    }
}
