package com.example.exploraholic.Fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.exploraholic.MapScreen.MapWithSearchbar
import com.example.exploraholic.databinding.FragmentHillStationsBinding

class HillStations : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val bind = FragmentHillStationsBinding.inflate(layoutInflater)

        bind.mapImg1.setOnClickListener {
            val intent = Intent(this@HillStations.requireContext(), MapWithSearchbar::class.java)
            startActivity(intent)
        }

        bind.mapImg2.setOnClickListener {
            val intent = Intent(this@HillStations.requireContext(), MapWithSearchbar::class.java)
            startActivity(intent)
        }
        // Inflate the layout for this fragment
        return bind.root
    }
}