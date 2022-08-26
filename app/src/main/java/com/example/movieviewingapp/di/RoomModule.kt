package com.example.movieviewingapp.di

import android.content.Context
import androidx.room.Room
import com.example.movieviewingapp.data.local.MovieDataBase
import com.example.movieviewingapp.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, MovieDataBase::class.java, Constants.MOVIE_DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideMovieDatabase(movieDatabase: MovieDataBase) = movieDatabase.movieDao()
}