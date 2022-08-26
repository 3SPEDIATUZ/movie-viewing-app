package com.example.movieviewingapp.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.movieviewingapp.data.local.dao.MovieDao
import com.example.movieviewingapp.data.local.entity.MovieEntity


@Database(entities = [MovieEntity::class], version = 1)
 abstract class MovieDataBase: RoomDatabase() {

     abstract fun movieDao(): MovieDao

     companion object{
         private var INSTANCE: MovieDataBase ?= null

         fun getDatabase(context: Context): MovieDataBase{
             INSTANCE = INSTANCE?: Room.databaseBuilder(
                 context.applicationContext,
                 MovieDataBase::class.java,
                 "movie_table"
             ).build()
             return INSTANCE!!
         }

         fun destroyInstance(){
             INSTANCE = null
         }
     }
}