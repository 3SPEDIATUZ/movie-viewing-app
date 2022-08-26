package com.example.movieviewingapp.domain


import com.example.movieviewingapp.data.local.MovieLocalDataSource
import com.example.movieviewingapp.data.remote.model.MovieResponse
import com.example.movieviewingapp.data.repository.MovieRepository
import com.example.movieviewingapp.domain.model.movieModelToMovieEntity
import javax.inject.Inject

class MovieUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
    private val movieLocal: MovieLocalDataSource
) {


    suspend fun getUpcomingMovies(): MovieResponse {
        val movies = movieLocal.getUpcomingMoviesRoom()
        if (movies.response.isNullOrEmpty()) {
            movieRepository.getMoviesUpcoming().response.forEach {
                movieLocal.saveMovies(it.movieModelToMovieEntity("upcoming"))
            }
        }
        return movieLocal.getUpcomingMoviesRoom()
    }

    suspend fun getTopRatedMovies(): MovieResponse {
        val movies = movieLocal.getTopRatedMoviesRoom()
        if (movies.response.isNullOrEmpty()) {
            movieRepository.getMoviesTop().response.forEach {
                movieLocal.saveMovies(it.movieModelToMovieEntity("toprated"))
            }
        }
        return movieLocal.getTopRatedMoviesRoom()
    }

    suspend fun getPopularMovies(): MovieResponse {
        val movies = movieLocal.getPopularMoviesRoom()
        if (movies.response.isNullOrEmpty()) {
            movieRepository.getMoviesPopular().response.forEach {
                movieLocal.saveMovies(it.movieModelToMovieEntity("popular"))

            }
        }
        return movieLocal.getPopularMoviesRoom()
    }

    suspend fun getNowPlayingMovies(): MovieResponse {
        val movies = movieLocal.getNowPlayingMoviesRoom()
        if (movies.response.isNullOrEmpty()) {
            movieRepository.getMoviesNowPlaying().response.forEach {
                movieLocal.saveMovies(it.movieModelToMovieEntity("nowplaying"))
            }
        }
        return movieLocal.getPopularMoviesRoom()
    }

}