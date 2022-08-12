package com.example.movieviewingapp.data.remote.model

import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("results") val response: List<MovieModel>
)
