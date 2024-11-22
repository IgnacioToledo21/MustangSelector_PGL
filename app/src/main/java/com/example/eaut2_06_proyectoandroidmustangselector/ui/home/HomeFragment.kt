package com.example.eaut2_06_proyectoandroidmustangselector.ui.home

import android.annotation.SuppressLint
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.eaut2_06_proyectoandroidmustangselector.R
import com.example.eaut2_06_proyectoandroidmustangselector.databinding.FragmentHomeBinding
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var imageSwitcher: ImageView
    private val handler = Handler(Looper.getMainLooper())
    private val imageChangeRunnable = Runnable {
        updateImage()
    }

    private lateinit var preferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Configuración de preferencias del usuario
        preferences = requireActivity().getSharedPreferences("UserPreferences", 0)
        setupButtons()  // Configuración de los botones

        // Configuración del carrusel de imágenes
        imageSwitcher = binding.imageSwitcher
        setupImageCarousel()

        return root
    }

    // Configuración de los botones (Salir, Acerca de y Preferencias)
    private fun setupButtons() {
        // Botón Salir
        binding.exitButton.setOnClickListener {
            requireActivity().finish() // Cierra la aplicación
        }

        // Botón Acerca de
        binding.aboutButton.setOnClickListener {
            showAboutDialog() // Muestra el cuadro de diálogo Acerca de
        }

        // Botón Preferencias
        binding.preferencesButton.setOnClickListener {
            showPreferencesDialog()
        }
    }

    // Configuración del carrusel de imágenes
    private fun setupImageCarousel() {
        // Define una lista de recursos de imágenes
        val imageList = listOf(
            R.drawable.mustangmache,
            R.drawable.mustangecoboost,
            R.drawable.mustangdarkhorse
        )
        homeViewModel.setImages(imageList)

        // Inicia el carrusel
        updateImage()
    }

    // Actualiza la imagen del carrusel
    private fun updateImage() {
        val nextImage = homeViewModel.getNextImage()
        nextImage?.let { imageSwitcher.setImageResource(it) }
        handler.postDelayed(imageChangeRunnable, 10000) // Cambia cada 10 segundos
    }

    // Muestra el cuadro de diálogo Acerca de
    private fun showAboutDialog() {
        AlertDialog.Builder(requireContext())
            .setTitle("Acerca de")
            .setMessage("Nombre App: Mustang Selector\nVersión: 1.0\nDesarrollado por: El Humilde")
            .setPositiveButton("Cerrar", null)
            .create()
            .show()
    }

    // Configura el cuadro de preferencias del tema
    private fun showPreferencesDialog() {
        val dialogView = LayoutInflater.from(context).inflate(R.layout.dialog_preferences, null)

        val radioGroupTheme = dialogView.findViewById<RadioGroup>(R.id.radio_group_theme)
        val radioSystemDefault = dialogView.findViewById<RadioButton>(R.id.radio_system_default)
        val radioLight = dialogView.findViewById<RadioButton>(R.id.radio_light)
        val radioDark = dialogView.findViewById<RadioButton>(R.id.radio_dark)

        // Configurar estado actual de la preferencia
        when (preferences.getString("theme", "system_default")) {
            "system_default" -> radioSystemDefault.isChecked = true
            "light" -> radioLight.isChecked = true
            "dark" -> radioDark.isChecked = true
        }

        val dialog = AlertDialog.Builder(requireContext())
            .setTitle("Elige un tema")
            .setView(dialogView)
            .setPositiveButton("Guardar") { _, _ ->
                val selectedTheme = when (radioGroupTheme.checkedRadioButtonId) {
                    R.id.radio_system_default -> "system_default"
                    R.id.radio_light -> "light"
                    R.id.radio_dark -> "dark"
                    else -> "system_default"
                }
                saveThemePreference(selectedTheme)
            }
            .setNegativeButton("Cancelar", null)
            .create()

        dialog.show()
    }

    // Guarda la preferencia de tema
    private fun saveThemePreference(theme: String) {
        preferences.edit().putString("theme", theme).apply()
        applyTheme(theme)
    }

    // Aplica el tema seleccionado
    private fun applyTheme(theme: String) {
        when (theme) {
            "system_default" -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
            "light" -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            "dark" -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        handler.removeCallbacks(imageChangeRunnable) // Detener el carrusel
    }
}
