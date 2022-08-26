package com.example.movieviewingapp.ui.fragment.movieDetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.movieviewingapp.databinding.FragmentMovieDetailBinding
import com.example.movieviewingapp.ui.viewModel.movieDetail.MovieDetailViewModel
import com.example.movieviewingapp.utils.Constants
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieDetailFragment : Fragment() {

    private lateinit var binding: FragmentMovieDetailBinding

    private  val movieDetailViewModel: MovieDetailViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMovieDetailBinding.inflate(inflater, container, false)
        return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setContent()
    }
    private fun setContent(){
        arguments?.let { bundle ->
            Glide.with(requireContext())
                .load("${Constants.URL_IMG}${bundle.getString("background")}")
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(binding.imagenViewBackground)
            Glide.with(requireContext())
                .load("${Constants.URL_IMG}${bundle.getString("poster")}")
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(binding.imagenViewPoster)
            binding.textViewTilte.text = bundle.getString("title")
            binding.textViewRating.text ="${bundle.getFloat("voteAverage")} (${bundle.getFloat("popularity")} Reviews)"
            binding.textViewReleased.text = "Released ${bundle.getString("date")}"
            binding.textViewLanguage.text = "Language ${bundle.getString("language")?.uppercase()}"
            binding.textViewOverview.text = bundle.getString("originalTitle")
            binding.textViewDescription.text = bundle.getString("description")
        }

    }


}