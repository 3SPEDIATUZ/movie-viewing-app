package com.example.movieviewingapp.data.repository

import com.example.movieviewingapp.data.remote.api.ApiService
import com.example.movieviewingapp.data.remote.model.MovieResponse
import com.example.movieviewingapp.di.IoDispatcher
import com.example.movieviewingapp.utils.Constants.API_KEY
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : MovieRepository {

    override suspend fun getMoviesPopular(): MovieResponse = withContext(ioDispatcher){
        apiService.popular(API_KEY)
    }

    override suspend fun getMoviesTop(): MovieResponse = withContext(ioDispatcher){
        apiService.topRated(API_KEY)
    }

    override suspend fun getMoviesUpcoming(): MovieResponse = withContext(ioDispatcher){
        apiService.upcoming(API_KEY)
    }

    override suspend fun getMoviesNowPlaying(): MovieResponse = withContext(ioDispatcher){
        apiService.nowPlaying(API_KEY)
    }
}