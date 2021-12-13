package com.example.demom04netwroktechnologies.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object SingeltonTechnologyApi {
    private val retrofit = Retrofit.Builder()
        .baseUrl("http://192.168.56.1:3000/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val service = retrofit.create(TechnologyServiice::class.java)
}