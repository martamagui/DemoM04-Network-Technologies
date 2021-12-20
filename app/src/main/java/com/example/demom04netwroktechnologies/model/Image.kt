package com.example.demom04netwroktechnologies.model


import com.google.gson.annotations.SerializedName

data class Image(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("imageUrl")
    val imageUrl: String
)