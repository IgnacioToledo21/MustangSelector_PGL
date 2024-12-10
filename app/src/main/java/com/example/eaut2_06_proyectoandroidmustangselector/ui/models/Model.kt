package com.example.eaut2_06_proyectoandroidmustangselector.ui.models


data class Model(
    val imageResId: Int,
    val title: String,
    val description: String,
    val price: String, // Cambié a String para el precio, puedes usar Double si lo prefieres
    val characteristics: String
)


