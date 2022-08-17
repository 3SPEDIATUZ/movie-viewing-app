package com.example.movieviewingapp.ui.fragment.topRated

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.movieviewingapp.data.repository.MovieRepository
import com.example.movieviewingapp.utils.Resource
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TopRatedViewModel @Inject constructor(private val movieRepository: MovieRepository): ViewModel(){

    fun getMovies() = liveData {
        emit(Resource.Loading())
        try {
            emit(
                Resource.Success(movieRepository.getMoviesTop())
            )
        } catch (e: Exception) {
            emit(Resource.Failure(e))
        }
    }
}