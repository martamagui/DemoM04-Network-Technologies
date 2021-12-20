package com.example.demom04netwroktechnologies.network

import com.example.demom04netwroktechnologies.model.Image
import com.example.demom04netwroktechnologies.model.Technology
import com.example.demom04netwroktechnologies.network.request.TechnologyRequest
import retrofit2.Call
import retrofit2.http.*

interface TechnologyServiice {
    @GET("api/technology")
    fun getTechnologies(): Call<List<Technology>>

    @GET("api/technology/{techId}")
    fun getTechnologyById(@Path("techId") techId: String): Call<Technology>

    //Método post para enviar datos
    @POST("api/technology")
    fun createTechnology(@Body technology: TechnologyRequest): Call<Any>

    //Indicamos que es una respuesta vacía porque no devuelve nada
    @DELETE("api/technology/{techId}")
    fun deleteTechnologyById(@Path("techId")techId: String): Call<Void>

    @GET("api/image")
    fun getImages(): Call<List<Image>>
}