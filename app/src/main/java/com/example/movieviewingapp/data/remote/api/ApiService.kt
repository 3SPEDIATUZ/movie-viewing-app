package com.example.movieviewingapp.data.remote.api

import com.example.movieviewingapp.data.remote.model.MovieResponse
import retrofit2.http.GET

interface ApiService {

    @GET("movie/popular")
    suspend fun popular(): MovieResponse

    @GET("movie/upcoming")
    suspend fun upcoming(): MovieResponse

    @GET("movie/top_rated")
    suspend fun topRated(): MovieResponse

    @GET("movie/now_playing")
    suspend fun nowPlaying(): MovieResponse
}