package com.example.movieviewingapp.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class MovieEntity(

    @PrimaryKey
    val identification: Long,

    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "originalTitle")
    val originalTitle: String,

    @ColumnInfo(name = "description")
    val description: String,

    @ColumnInfo(name = "language")
    val language: String,

    @ColumnInfo(name = "date")
    val date: String,

    @ColumnInfo(name = "poster")
    val poster: String,

    @ColumnInfo(name = "background")
    val background: String,

    @ColumnInfo(name = "video")
    val video: Boolean,

    @ColumnInfo(name = "popularity")
    val popularity: Float,

    @ColumnInfo(name = "voteAverage")
    val voteAverage: Float,

    @ColumnInfo(name = "voteCount")
    val voteCount: Int,

    @ColumnInfo(name = "adult")
    val adult: Boolean,

    @ColumnInfo (name ="movie_type")
    var movieType: String
)