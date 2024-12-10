package com.example.eaut2_06_proyectoandroidmustangselector.ui.models

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.eaut2_06_proyectoandroidmustangselector.R
import com.example.eaut2_06_proyectoandroidmustangselector.databinding.FragmentModelsBinding

class ModelsFragment : Fragment() {

    private var _binding: FragmentModelsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val modelsViewModel =
            ViewModelProvider(this).get(ModelsViewModel::class.java)

        _binding = FragmentModelsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Configurar el TextView original
        val textView: TextView = binding.textModels
        modelsViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        // Datos RecyclerView
        val exampleModels = listOf(
            Model(R.drawable.mustangmache, "Mustang Mach-E", "SUV eléctrico con gran autonomía.", "$40,000"," SUV eléctrico con motor dual opcional, hasta 480 hp y 634 lb-ft de torque. Acelera de 0-100 km/h en 3.3 segundos (versión GT Performance) y tiene una autonomía de hasta 502 km según versión"),
            Model(R.drawable.mustangecoboost, "Mustang EcoBoost", "Deportivo eficiente y potente.", "$35,000", "El Ford Mustang EcoBoost es una versión más accesible del deportivo, equipada con un motor 2.3L de 4 cilindros turbo que genera 317-330 CV y 475 Nm de par. Ofrece una velocidad máxima cercana a los 250 km/h y acelera de 0 a 100 km/h en aproximadamente 5.5 segundos (varía según configuración). Cuenta con tracción trasera, suspensión confortable y frenos ventilados en ambos ejes, lo que lo hace versátil tanto para el uso diario como para una conducción más deportiva"),
            Model(R.drawable.mustangdarkhorse, "Mustang Dark Horse", "Rendimiento y diseño premium.", "$50,000", " Nuevo modelo orientado a pista, con el motor V8 Coyote de 5.0L ajustado para entregar 500 hp. Incluye transmisión Tremec manual y paquete de manejo avanzado"),
            Model(R.drawable.mustangclassic, "Mustang Clásico", "El ícono de los años 60.", "$30,000", " Enfocado en rendimiento, equipado con un V8 de 5.0L que generaba hasta 444 hp. Diseñado para manejo en pista, aunque su velocidad punta alcanzaba los 260 km/h dependiendo del modelo"),
            Model(R.drawable.mustanggt, "Mustang GT", "Motor V8 para los amantes de la velocidad.", "$45,000", "Motor V8 Coyote de 5.0L con 480 hp y 415 lb-ft de torque. Su velocidad punta ronda los 250 km/h y acelera de 0-100 km/h en unos 4 segundos (manual)"),
            Model(R.drawable.mustangshelby, "Mustang Shelby", "La leyenda de la potencia.", "$55,000", "Motor V8 sobrealimentado de 5.2L, 760 hp y 625 lb-ft de torque. Acelera de 0-100 km/h en 3.5 segundos y supera los 290 km/h")
        )


        // Configuración del RecyclerView
        val recyclerView = binding.recyclerView
        recyclerView.adapter = ModelsAdapter(requireContext(), exampleModels)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
