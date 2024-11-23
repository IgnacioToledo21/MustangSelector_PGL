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
            Model(R.drawable.mustangmache, "Mustang Mach-E", "SUV eléctrico con gran autonomía.", "$40,000"),
            Model(R.drawable.mustangecoboost, "Mustang EcoBoost", "Deportivo eficiente y potente.", "$35,000"),
            Model(R.drawable.mustangdarkhorse, "Mustang Dark Horse", "Rendimiento y diseño premium.", "$50,000"),
            Model(R.drawable.mustangclassic, "Mustang Clásico", "El ícono de los años 60.", "$30,000"),
            Model(R.drawable.mustanggt, "Mustang GT", "Motor V8 para los amantes de la velocidad.", "$45,000"),
            Model(R.drawable.mustangshelby, "Mustang Shelby", "La leyenda de la potencia.", "$55,000")
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
