package com.example.movieviewingapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.movieviewingapp.data.local.entity.MovieEntity


@Dao
interface MovieDao {

    @Query("SELECT * FROM  movieentity")
    suspend fun getAllMovies(): List<MovieEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovie(movie:MovieEntity)

    @Query("DELETE FROM movieentity")
    suspend fun deleteAllMovies()
}