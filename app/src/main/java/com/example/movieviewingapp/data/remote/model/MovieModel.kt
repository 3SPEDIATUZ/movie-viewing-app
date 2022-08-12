package com.example.movieviewingapp.data.remote.model

import com.google.gson.annotations.SerializedName

data class MovieModel(
    @SerializedName("id") val identification: Long,
    @SerializedName("title") val title: String,
    @SerializedName("original_title") val originalTitle: String,
    @SerializedName("overview") val description: String,
    @SerializedName("original_language") val language: String,
    @SerializedName("release_date") val date: String,
    @SerializedName("poster_path") val poster: String,
    @SerializedName("backdrop_path") val background: String,
    @SerializedName("video")  val video: Boolean,
    @SerializedName("popularity") val popularity: Float,
    @SerializedName("vote_average") val voteAverage: Float,
    @SerializedName("vote_count") val voteCount: Int,
    @SerializedName("adult") val adult: Boolean,
)

