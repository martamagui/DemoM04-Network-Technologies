package com.example.demom04netwroktechnologies.network.request

import com.google.gson.annotations.SerializedName

data class TechnologyRequest(
    @SerializedName("name")
    val name: String,
    @SerializedName("description")
    val description: String
)
