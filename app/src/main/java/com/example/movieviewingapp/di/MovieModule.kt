package com.example.movieviewingapp.di

import com.example.movieviewingapp.data.repository.MovieRepository
import com.example.movieviewingapp.data.repository.MovieRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MovieModule {

    @Singleton
    @Provides
    fun provideMovie(movieRepositoryImpl: MovieRepositoryImpl): MovieRepository = movieRepositoryImpl
}