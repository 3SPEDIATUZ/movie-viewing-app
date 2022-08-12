package com.example.movieviewingapp.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.movieviewingapp.R
import com.example.movieviewingapp.data.remote.model.MovieModel
import com.example.movieviewingapp.databinding.ItemMovieBinding
import com.example.movieviewingapp.utils.Constants.URL_IMG

class MovieAdapter (private val onClickListener: OnClickListener): RecyclerView.Adapter<MovieAdapter.MainViewHolder>(){

    private lateinit var context: Context
    private var movieModels: List<MovieModel> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieAdapter.MainViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false)
        return MainViewHolder (view)
    }

    override fun onBindViewHolder(holder: MovieAdapter.MainViewHolder, position: Int) {
        val item = movieModels[position]
        with(holder){
            holder.bind(item)

            Glide.with(context)
                .load("$URL_IMG${item.poster}")
                .fitCenter()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .error(R.drawable.ic_baseline_error_24)
                .into(holder.itemMovieBinding.imagenViewMovie)

            itemMovieBinding.textViewMovie.text = item.title
        }
    }

    override fun getItemCount(): Int = movieModels.size

    fun submitList(item: List<MovieModel>) {
        movieModels = item
        notifyItemInserted(movieModels.size - 1)
    }

    inner class  MainViewHolder (view: View): RecyclerView.ViewHolder(view){
        val itemMovieBinding = ItemMovieBinding.bind(view)
        fun bind(movie: MovieModel){
            itemMovieBinding.root.setOnClickListener {
                onClickListener.onClick(movie)
            }
        }
    }

    interface OnClickListener{
        fun onClick (data : MovieModel)
    }
}