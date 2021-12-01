package com.example.demom04netwroktechnologies.model

import com.google.gson.annotations.SerializedName


data class Technology(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("imageUrl")
    val imageUrl: String? = null
)