package com.example.eaut2_06_proyectoandroidmustangselector.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Destacados - Explora nuestros Mustangs destacados"
    }
    val text: LiveData<String> = _text

    val headerTitle = MutableLiveData<String>().apply {
        value = "Mustang Selector"
    }

    val headerSubtitle = MutableLiveData<String>().apply {
        value = "Encuentra tu Mustang ideal"
    }

    val headerDescription = MutableLiveData<String>().apply {
        value = "Descubre nuestra selección de modelos y escoge el que mejor se adapte a ti."
    }

    private val _currentImageIndex = MutableLiveData<Int>().apply {
        value = 0 // Empezamos con la primera imagen
    }
    val currentImageIndex: LiveData<Int> = _currentImageIndex

    private var images = listOf<Int>() // Lista de IDs de imágenes

    fun setImages(imageList: List<Int>) {
        images = imageList
    }

    fun getNextImage(): Int? {
        val currentIndex = _currentImageIndex.value ?: 0
        val nextIndex = (currentIndex + 1) % images.size
        _currentImageIndex.value = nextIndex
        return images[nextIndex]
    }
}

