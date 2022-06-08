package com.example.exploraholic.Fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.exploraholic.MapScreen.MapWithSearchbar
import com.example.exploraholic.databinding.FragmentDamsBinding

class Dams : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val bind = FragmentDamsBinding.inflate(layoutInflater)

        bind.mapImg1.setOnClickListener {
            val intent = Intent(this@Dams.requireContext(), MapWithSearchbar::class.java)
            startActivity(intent)
        }

        bind.mapImg2.setOnClickListener {
            val intent = Intent(this@Dams.requireContext(), MapWithSearchbar::class.java)
            startActivity(intent)
        }
        // Inflate the layout for this fragment
        return bind.root
    }
}