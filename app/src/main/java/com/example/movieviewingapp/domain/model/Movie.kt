package com.example.movieviewingapp.domain.model

data class Movie(
    val identification: Long,
    val title: String,
    val originalTitle: String,
    val description: String,
    val language: String,
    val date: String,
    val poster: String,
    val background: String,
    val video: Boolean,
    val popularity: Float,
    val voteAverage: Float,
    val voteCount: Int,
    val adult: Boolean,
    var movieType: String
)


