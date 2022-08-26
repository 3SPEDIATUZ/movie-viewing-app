package com.example.movieviewingapp.data.local


import com.example.movieviewingapp.data.local.dao.MovieDao
import com.example.movieviewingapp.data.local.entity.MovieEntity
import com.example.movieviewingapp.data.remote.model.MovieResponse
import com.example.movieviewingapp.domain.model.listMovieEntityToMovieList
import javax.inject.Inject

class MovieLocalDataSource @Inject constructor(private val movieDao: MovieDao) {

    suspend fun saveMovies (movie : MovieEntity){
        return movieDao.saveMovie(movie)
    }

    //Movie Categority
    suspend fun  getUpcomingMoviesRoom(): MovieResponse {
        return movieDao.getAllMovies().filter { it.movieType =="upcoming" }.listMovieEntityToMovieList()
    }

    suspend fun  getTopRatedMoviesRoom(): MovieResponse{
        return movieDao.getAllMovies().filter { it.movieType == "toprated" }.listMovieEntityToMovieList()
    }

    suspend fun  getPopularMoviesRoom(): MovieResponse{
        return movieDao.getAllMovies().filter { it.movieType == "popular" }.listMovieEntityToMovieList()
    }

    suspend fun getNowPlayingMoviesRoom(): MovieResponse{
        return movieDao.getAllMovies().filter { it.movieType == "nowplaying" }.listMovieEntityToMovieList()
    }

}