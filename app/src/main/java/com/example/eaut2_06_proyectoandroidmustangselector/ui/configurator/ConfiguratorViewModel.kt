package com.example.eaut2_06_proyectoandroidmustangselector.ui.configurator

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ConfiguratorViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Configurator Fragment"
    }
    val text: LiveData<String> = _text
}