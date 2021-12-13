package com.example.demom04netwroktechnologies

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.demom04netwroktechnologies.databinding.FragmentTechnologyAddBinding
import com.example.demom04netwroktechnologies.databinding.FragmentTechnologyListBinding
import com.example.demom04netwroktechnologies.model.Technology
import com.example.demom04netwroktechnologies.network.SingeltonTechnologyApi
import com.example.demom04netwroktechnologies.network.TechnologyServiice
import com.example.demom04netwroktechnologies.network.request.TechnologyRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnAddTechonology.setOnClickListener {
            binding.etTechName.error = null
            if (validateFields()) {
                sendTechnologyToServer()
            }
        }
    }

    private fun sendTechnologyToServer() {

        val techName = binding.etTechName.text.toString()
        val techDescription = binding.etTechDescription.text.toString()
        val techRequest = TechnologyRequest(techName, techDescription)
        SingeltonTechnologyApi.service.createTechnology(techRequest)
            .enqueue(object : Callback<Any> {
                override fun onResponse(
                    call: Call<Any>,
                    response: Response<Any>
                ) {
                    if (response.isSuccessful) {
                    } else {
                        Toast.makeText(context, "Error en la respuesta", Toast.LENGTH_SHORT).show()
                        val code = response.code()
                        val message = response.message()
                        Log.e("requestData", "error en la respuesta: $code <> $message")
                    }
                }

                override fun onFailure(call: Call<Any>, t: Throwable) {
                    Toast.makeText(context, "Error en la conexion", Toast.LENGTH_SHORT).show()
                    Log.e("requestData", "error", t)
                }
            })

    }

    private fun validateFields(): Boolean {
//        binding.etTechName.error = null
        val techName = binding.etTechName.text.toString()
        val techDescription = binding.etTechDescription.text.toString()

        if (techName.isEmpty()) {
//            binding.etTechName.error = "TechName is empty."
            showError("TechName is empty.")
            return false
        }
        if (techDescription.isEmpty()) {
            showError("TechDescription is empty.")
            return false
        }
        return true
    }

    private fun showError(error: String) {
        Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}