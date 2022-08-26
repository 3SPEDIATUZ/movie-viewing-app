package com.example.movieviewingapp.domain.model


import com.example.movieviewingapp.data.local.entity.MovieEntity
import com.example.movieviewingapp.data.remote.model.MovieModel
import com.example.movieviewingapp.data.remote.model.MovieResponse


//Mapping MovieEntity to MovieModel
fun MovieEntity.movieEntityToMovie(): MovieModel = MovieModel(
    this.identification,
    this.title,
    this.originalTitle,
    this.description,
    this.language,
    this.date,
    this.poster,
    this.background,
    this.video,
    this.popularity,
    this.voteAverage,
    this.voteCount,
    this.adult
)

fun MovieModel.movieModelToMovieEntity(movieType: String) = MovieEntity (
    this.identification,
    this.title,
    this.originalTitle,
    this.description,
    this.language,
    this.language,
    this.poster,
    this.background,
    this.video,
    this.popularity,
    this.voteAverage,
    this.voteCount,
    this.adult,
    movieType = movieType
)

fun Movie.movieEntityToMovie() = MovieModel (
    this.identification,
    this.title,
    this.originalTitle,
    this.description,
    this.language,
    this.language,
    this.poster,
    this.background,
    this.video,
    this.popularity,
    this.voteAverage,
    this.voteCount,
    this.adult,
)

fun List<Movie>.listMovieEntityToListMovie() = map { it.movieEntityToMovie() }

fun List<MovieEntity>.listMovieEntityToMovieList(): MovieResponse {
    val resultList = mutableListOf<MovieModel>()
    this.forEach { movieEntity ->
        resultList.add(movieEntity.movieEntityToMovie())
    }
    return MovieResponse(resultList)
}


