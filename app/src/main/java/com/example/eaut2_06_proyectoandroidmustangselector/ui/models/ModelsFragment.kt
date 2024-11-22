package com.example.eaut2_06_proyectoandroidmustangselector.ui.models

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.eaut2_06_proyectoandroidmustangselector.databinding.FragmentModelsBinding

class ModelsFragment : Fragment() {

    private var _binding: FragmentModelsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
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

        val textView: TextView = binding.textModels
        modelsViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}