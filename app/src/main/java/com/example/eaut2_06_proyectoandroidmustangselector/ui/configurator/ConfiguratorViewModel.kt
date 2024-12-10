package com.example.eaut2_06_proyectoandroidmustangselector.ui.configurator

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ConfiguratorViewModel : ViewModel() {

    private val _reservations = MutableLiveData<List<Reservas>>(emptyList())
    val reservations: LiveData<List<Reservas>> = _reservations

    fun addReservas(reservation: Reservas) {
        val updatedList = _reservations.value.orEmpty().toMutableList()
        if (!updatedList.contains(reservation)) {
            updatedList.add(reservation)
            _reservations.value = updatedList
        }
    }

}
