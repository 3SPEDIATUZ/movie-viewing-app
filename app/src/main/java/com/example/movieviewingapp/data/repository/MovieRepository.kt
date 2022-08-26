package com.example.movieviewingapp.data.repository

import com.example.movieviewingapp.data.remote.model.MovieResponse

interface MovieRepository {

    suspend fun getMoviesPopular(): MovieResponse

    suspend fun getMoviesTop(): MovieResponse

    suspend fun getMoviesUpcoming(): MovieResponse

    suspend fun getMoviesNowPlaying(): MovieResponse
}