package com.example.demom04netwroktechnologies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.demom04netwroktechnologies.databinding.FragmentTechnologyListBinding


class TechnologyListFragment : Fragment() {
    private var _binding: FragmentTechnologyListBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTechnologyListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}