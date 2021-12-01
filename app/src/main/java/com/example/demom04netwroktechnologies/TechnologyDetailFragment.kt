package com.example.demom04netwroktechnologies

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import com.example.demom04netwroktechnologies.databinding.FragmentTechnologyDetailBinding
import com.example.demom04netwroktechnologies.databinding.FragmentTechnologyListBinding
import com.example.demom04netwroktechnologies.extension.imageUrl
import com.example.demom04netwroktechnologies.model.Technology
import com.example.demom04netwroktechnologies.network.TechnologyServiice
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TechnologyDetailFragment : Fragment() {
    private var _binding: FragmentTechnologyDetailBinding? = null
    private val binding
        get() = _binding!!
    private  val args : TechnologyDetailFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTechnologyDetailBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Toast.makeText(context, "TechId: ${args.techId}", Toast.LENGTH_SHORT).show()
        binding.tvId.text = args.techId
        //Comprueba que no sea nulo, lo mismo que el if
        args.techId?.let{
            requestData(it)
        }?: showError("TechId Null")
//        if (args.techId != null) {
//            requestData(args.techId!!)
//        } else {
//            showError()
//        }
    }

    private fun showError(error : String) {
        Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
    }

    private fun requestData(techId: String) {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://10.1.200.149:3000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(TechnologyServiice::class.java)
        with(service) {
            getTechnologyById(techId).enqueue(object : Callback<Technology>{
                override fun onResponse(call: Call<Technology>, response: Response<Technology>) {
                   if(response.isSuccessful){
                       populateUI(response.body())
                   }
                }



                override fun onFailure(call: Call<Technology>, t: Throwable) {
                    Log.e("requestData", "error", t)
                    showError("Error en la conexion")
                }

            })
        }
    }
    private fun populateUI(technology: Technology?) {
        technology?.let {
            binding.tvDetailName.text=technology.name
            binding.tvId.text = technology.id
            binding.imageView.imageUrl(technology.imageUrl)
        }?:showError("Error to retrieve technology")
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}