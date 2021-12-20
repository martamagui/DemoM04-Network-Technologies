package com.example.demom04netwroktechnologies

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.demom04netwroktechnologies.databinding.FragmentImageListBinding
import com.example.demom04netwroktechnologies.model.Image
import com.example.demom04netwroktechnologies.model.Technology
import com.example.demom04netwroktechnologies.network.SingeltonTechnologyApi
import com.example.demom04netwroktechnologies.network.TechnologyServiice
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ImageListFragment : Fragment() {
    private var _binding: FragmentImageListBinding? = null
    private val binding
        get() = _binding!!
    private val adapter = ImageAdapter {
        val cm = requireContext().getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clip = ClipData.newPlainText("NetworkTechnologies", it.imageUrl)
        cm.setPrimaryClip(clip)
        Toast.makeText(requireContext(), "Imagen añadida al portapapeles", Toast.LENGTH_SHORT)
            .show()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentImageListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvImages.layoutManager = GridLayoutManager(context, 2)
        binding.rvImages.adapter = adapter
        SingeltonTechnologyApi.service.getImages().enqueue(object : Callback<List<Image>> {
            override fun onResponse(call: Call<List<Image>>, response: Response<List<Image>>) {
                adapter.submitList(response.body())
            }

            override fun onFailure(call: Call<List<Image>>, t: Throwable) {
                Toast.makeText(context, "Error en la conexion", Toast.LENGTH_SHORT).show()
                Log.e("requestData", "error", t)
            }

        })
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}