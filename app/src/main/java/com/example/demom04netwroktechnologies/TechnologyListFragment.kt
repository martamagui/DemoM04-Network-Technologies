package com.example.demom04netwroktechnologies

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.demom04netwroktechnologies.databinding.FragmentTechnologyListBinding
import com.example.demom04netwroktechnologies.model.Technology
import com.example.demom04netwroktechnologies.network.TechnologyServiice
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class TechnologyListFragment : Fragment() {
    private var _binding: FragmentTechnologyListBinding? = null
    private val binding
        get() = _binding!!
    private val adapter = TechnologyAdpter{
        val action =
            TechnologyListFragmentDirections.actionTechnologyListFragmentToTechnologyDetailFragment(
                it.id
            )
        findNavController().navigate(action)
    }

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
        requestData()
    }

    private fun requestData() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://10.1.204.118:3000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(TechnologyServiice::class.java)
        service.getTechnologies().enqueue(object : Callback<List<Technology>> {
            override fun onResponse(
                call: Call<List<Technology>>,
                response: Response<List<Technology>>
            ) {
                if (response.isSuccessful) {
                    adapter.submitList(response.body())
                } else {
                    Toast.makeText(context, "Error en la respuesta", Toast.LENGTH_SHORT).show()
                    val code = response.code()
                    val message = response.message()
                    Log.e("requestData", "error en la respuesta: $code <> $message")
                }
            }

            override fun onFailure(call: Call<List<Technology>>, t: Throwable) {
                Toast.makeText(context, "Error en la conexion", Toast.LENGTH_SHORT).show()
                Log.e("requestData", "error", t)
            }
        })
    }

    private fun configUI() {
        binding.fabAddTech.setOnClickListener {
            val action =
                TechnologyListFragmentDirections.actionTechnologyListFragmentToTechnologyAddFragment()
            findNavController().navigate(action)
        }
        binding.rvTechnology.layoutManager = GridLayoutManager(context, 2)
        binding.rvTechnology.adapter = adapter
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}