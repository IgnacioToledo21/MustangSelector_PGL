package com.example.eaut2_06_proyectoandroidmustangselector.ui.configurator

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.eaut2_06_proyectoandroidmustangselector.R

class ReservationAdapter(private var reservations: List<Reservas>) :
    RecyclerView.Adapter<ReservationAdapter.ReservationViewHolder>() {

    // ViewHolder para gestionar las vistas de cada ítem
    class ReservationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val dateTextView: TextView = itemView.findViewById(R.id.textDate)
        val timeTextView: TextView = itemView.findViewById(R.id.textTime)
        val iconLogo: ImageView = itemView.findViewById(R.id.iconLogo) // Vincula el ImageView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReservationViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_reservation, parent, false)
        return ReservationViewHolder(view)
    }

    override fun onBindViewHolder(holder: ReservationViewHolder, position: Int) {
        val reservation = reservations[position]
        holder.dateTextView.text = reservation.date
        holder.timeTextView.text = reservation.time
        holder.iconLogo.setImageResource(R.drawable.ic_calendar) // Configura el icono
    }

    override fun getItemCount(): Int {
        return reservations.size
    }

    // Método para actualizar la lista de reservas
    fun updateReservations(newReservations: List<Reservas>) {
        reservations = newReservations
        notifyDataSetChanged()
    }
}
