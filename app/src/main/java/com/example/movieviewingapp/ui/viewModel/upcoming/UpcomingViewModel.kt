package com.example.movieviewingapp.ui.viewModel.upcoming

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.movieviewingapp.data.repository.MovieRepository
import com.example.movieviewingapp.domain.MovieUseCase
import com.example.movieviewingapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel

import javax.inject.Inject

@HiltViewModel
class UpcomingViewModel @Inject constructor( private val movieUseCase: MovieUseCase): ViewModel() {

    fun getMovies() = liveData {
        emit(Resource.Loading())
        try {
            emit(
                Resource.Success(movieUseCase.getUpcomingMovies())
            )
        } catch (e: Exception) {
            emit(Resource.Failure(e))
        }
    }

}