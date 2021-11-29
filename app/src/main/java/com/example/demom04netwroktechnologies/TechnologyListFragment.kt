package com.example.demom04netwroktechnologies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.demom04netwroktechnologies.databinding.FragmentTechnologyListBinding
import com.example.demom04netwroktechnologies.model.Technology


class TechnologyListFragment : Fragment() {
    private var _binding: FragmentTechnologyListBinding? = null
    private val binding
        get() = _binding!!
    private val adapter = TechnologyAdpter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTechnologyListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configUI()
        val techList :  MutableList<Technology> = mutableListOf()
        for (i in 1..10){
            val tech = Technology(i.toString(),"Tech $i","Description $i", "a")
            techList.add(tech)
        }
        adapter.submitList(techList)
    }
    private fun configUI(){
        binding.fabAddTech.setOnClickListener {
            val action = TechnologyListFragmentDirections.actionTechnologyListFragmentToTechnologyAddFragment()
            findNavController().navigate(action)
        }
        binding.rvTechnology.layoutManager = GridLayoutManager(context,2)
        binding.rvTechnology.adapter = adapter
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}