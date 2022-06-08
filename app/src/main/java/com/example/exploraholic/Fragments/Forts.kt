package com.example.exploraholic.Fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.exploraholic.MapScreen.MapWithSearchbar
import com.example.exploraholic.databinding.FragmentFortsBinding

class Forts : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val bind = FragmentFortsBinding.inflate(layoutInflater)

        bind.mapImg1.setOnClickListener {
            val intent = Intent(this@Forts.requireContext(), MapWithSearchbar::class.java)
            startActivity(intent)
        }

        bind.mapImg2.setOnClickListener {
            val intent = Intent(this@Forts.requireContext(), MapWithSearchbar::class.java)
            startActivity(intent)
        }
        // Inflate the layout for this fragment
        return bind.root
    }
}