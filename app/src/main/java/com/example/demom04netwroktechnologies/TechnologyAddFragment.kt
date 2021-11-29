package com.example.demom04netwroktechnologies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.demom04netwroktechnologies.databinding.FragmentTechnologyAddBinding
import com.example.demom04netwroktechnologies.databinding.FragmentTechnologyListBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class TechnologyAddFragment : Fragment() {
    private var _binding: FragmentTechnologyAddBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTechnologyAddBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}