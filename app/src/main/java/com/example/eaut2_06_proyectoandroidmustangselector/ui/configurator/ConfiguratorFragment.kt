package com.example.eaut2_06_proyectoandroidmustangselector.ui.configurator

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.eaut2_06_proyectoandroidmustangselector.databinding.FragmentConfiguratorBinding
import androidx.appcompat.app.AppCompatDelegate
import com.example.eaut2_06_proyectoandroidmustangselector.R

class ConfiguratorFragment : Fragment() {

    private var _binding: FragmentConfiguratorBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout and initialize binding
        _binding = FragmentConfiguratorBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize ViewModel
        val configuratorViewModel =
            ViewModelProvider(this).get(ConfiguratorViewModel::class.java)

        // Get the data from the Intent
        val date = activity?.intent?.getStringExtra("EXTRA_DATE")
        val time = activity?.intent?.getStringExtra("EXTRA_TIME")

        // Log the received data for debugging
        Log.d("ConfiguratorFragment", "Received date: $date, time: $time")

        // Add the reservation if data is not null or empty
        if (!date.isNullOrEmpty() && !time.isNullOrEmpty()) {
            configuratorViewModel.addReservas(Reservas(date, time))
        }

        // Setup RecyclerView with the adapter
        val recyclerView = binding.recyclerView
        val adapter = ReservationAdapter(emptyList())
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)

        // Observe the reservations LiveData
        configuratorViewModel.reservations.observe(viewLifecycleOwner) { reservations ->
            adapter.updateReservations(reservations)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
