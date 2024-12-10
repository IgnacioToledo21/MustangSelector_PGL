package com.example.eaut2_06_proyectoandroidmustangselector.ui.models

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.eaut2_06_proyectoandroidmustangselector.databinding.ItemModelBinding

class ModelsAdapter(
    private val context: Context,
    private val modelsList: List<Model>
) : RecyclerView.Adapter<ModelsAdapter.ModelViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModelViewHolder {
        val binding = ItemModelBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ModelViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ModelViewHolder, position: Int) {
        val model = modelsList[position]
        holder.bind(model)
    }

    override fun getItemCount(): Int = modelsList.size

    inner class ModelViewHolder(private val binding: ItemModelBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(model: Model) {

            // Configurar datos en la vista
            binding.imageModel.setImageResource(model.imageResId)
            binding.textTitle.text = model.title
            binding.textDescription.text = model.description

            // Configurar evento click
            itemView.setOnClickListener {
                val intent = Intent(context, DetailActivity::class.java).apply {
                    putExtra("TITLE", model.title)
                    putExtra("IMAGE_RES_ID", model.imageResId)
                    putExtra("DESCRIPTION", model.description)
                    putExtra("PRICE", model.price)
                    putExtra("CHARACTERISTICS", model.characteristics) // Pasar directamente las características
                }
                context.startActivity(intent)
            }

        }
    }
}
