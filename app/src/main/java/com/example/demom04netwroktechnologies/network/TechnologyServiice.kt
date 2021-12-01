package com.example.demom04netwroktechnologies.network

import com.example.demom04netwroktechnologies.model.Technology
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface TechnologyServiice {
    @GET("api/technology")
    fun getTechnologies(): Call<List<Technology>>
    @GET("api/technology/{techId}")
    fun getTechnologyById(@Path("techId")techId: String): Call<Technology>
}