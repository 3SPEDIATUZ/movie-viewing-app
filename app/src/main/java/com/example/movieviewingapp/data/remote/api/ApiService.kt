package com.example.movieviewingapp.data.remote.api

import com.example.movieviewingapp.data.remote.model.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("movie/popular")
    suspend fun popular(@Query("api_key") key: String): MovieResponse

    @GET("movie/upcoming")
    suspend fun upcoming(@Query("api_key") key: String): MovieResponse

    @GET("movie/top_rated")
    suspend fun topRated(@Query("api_key") key: String): MovieResponse

    @GET("movie/now_playing")
    suspend fun nowPlaying(@Query("api_key") key: String): MovieResponse
}