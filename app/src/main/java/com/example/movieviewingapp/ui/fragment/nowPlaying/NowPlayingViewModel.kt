package com.example.movieviewingapp.ui.fragment.nowPlaying

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.movieviewingapp.data.repository.MovieRepository
import com.example.movieviewingapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NowPlayingViewModel @Inject constructor(private val movieRepository: MovieRepository): ViewModel() {

    fun getMovies() = liveData {
        emit(Resource.Loading())
        try {
            emit(
                Resource.Success(movieRepository.getMoviesNowPlaying())
            )
        } catch (e: Exception) {
            emit(Resource.Failure(e))
        }
    }

}