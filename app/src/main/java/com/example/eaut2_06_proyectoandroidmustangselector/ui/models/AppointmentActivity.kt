    package com.example.eaut2_06_proyectoandroidmustangselector.ui.models


    import android.app.DatePickerDialog
    import android.app.TimePickerDialog
    import android.content.Intent
    import android.os.Bundle
    import android.widget.Button
    import android.widget.EditText
    import android.widget.Toast
    import androidx.appcompat.app.AppCompatActivity
    import com.example.eaut2_06_proyectoandroidmustangselector.MainActivity
    import com.example.eaut2_06_proyectoandroidmustangselector.R
    import com.example.eaut2_06_proyectoandroidmustangselector.ui.configurator.ConfiguratorViewModel
    import java.util.*

    class AppointmentActivity : AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_appointment)

            val editTextDate: EditText = findViewById(R.id.editTextDate)
            val editTextTime: EditText = findViewById(R.id.editTextTime)
            val editTextBirthDate: EditText = findViewById(R.id.editTextBirthDate)
            val botonConfirmar: Button = findViewById(R.id.btnEnviar)

            val calendar = Calendar.getInstance()

            // Fecha de la cita
            editTextDate.setOnClickListener {
                val datePickerDialog = DatePickerDialog(this, { _, year, month, dayOfMonth ->
                    val selectedDate = "$month/$dayOfMonth/$year"
                    editTextDate.setText(selectedDate)
                }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH))
                datePickerDialog.show()
            }

            // Hora de la cita
            editTextTime.setOnClickListener {
                val timePickerDialog = TimePickerDialog(this, { _, hourOfDay, minute ->
                    val selectedTime = "$hourOfDay:$minute"
                    editTextTime.setText(selectedTime)
                }, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), false)
                timePickerDialog.show()
            }

            // Fecha de nacimiento
            editTextBirthDate.setOnClickListener {
                val datePickerDialog = DatePickerDialog(this, { _, year, month, dayOfMonth ->
                    val selectedBirthDate = "$month/$dayOfMonth/$year"
                    editTextBirthDate.setText(selectedBirthDate)
                }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH))
                datePickerDialog.show()
            }

            // Botón Enviar
            botonConfirmar.setOnClickListener {
                val date = editTextDate.text.toString()
                val time = editTextTime.text.toString()
                val birthDate = editTextBirthDate.text.toString()

                if (date.isNotEmpty() && time.isNotEmpty() && birthDate.isNotEmpty()) {
                    // Crear el intent y pasar los datos
                    val intent = Intent(this, MainActivity::class.java)
                    intent.putExtra("EXTRA_DATE", date)
                    intent.putExtra("EXTRA_TIME", time)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show()
                }
            }

        }
    }
