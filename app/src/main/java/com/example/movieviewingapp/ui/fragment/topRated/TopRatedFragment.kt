package com.example.movieviewingapp.ui.fragment.topRated

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.example.movieviewingapp.R
import com.example.movieviewingapp.data.remote.model.MovieModel
import com.example.movieviewingapp.databinding.FragmentTopRatedBinding
import com.example.movieviewingapp.ui.adapter.MovieAdapter
import com.example.movieviewingapp.ui.viewModel.topRated.TopRatedViewModel
import com.example.movieviewingapp.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TopRatedFragment : Fragment() , MovieAdapter.OnClickListener{

    private lateinit var binding: FragmentTopRatedBinding
    private lateinit var movieAdapter: MovieAdapter
    private lateinit var navController: NavController
    private val topRatedViewModel: TopRatedViewModel by viewModels ()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTopRatedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAdapter()
        setObserver()
    }

    private fun setAdapter() {
        movieAdapter = MovieAdapter(this)
        binding.recyclerViewMovieTopRated.adapter = movieAdapter
        val layoutManager = GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
        binding.recyclerViewMovieTopRated.layoutManager = layoutManager

    }

    private fun setObserver(){
        topRatedViewModel.getMovies().observe(viewLifecycleOwner, {
            when(it){
                is Resource.Loading ->{
                    binding.linearLayoutProgressTopRated.visibility = View.VISIBLE
                }
                is Resource.Success ->{
                    binding.linearLayoutProgressTopRated.visibility = View.GONE
                    movieAdapter.submitList(it.data.response)
                }
                is Resource.Failure -> {
                    binding.recyclerViewMovieTopRated.visibility = View.GONE
                    Log.e("FetchError", "Error: $it.exception ")
                    Toast.makeText(requireContext(), "Error: ${it.exception}", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        })
    }

    override fun onClick(data: MovieModel) {
        navController = view?.let { Navigation.findNavController(it) }!!
        navController.navigate(
            R.id.movieDetailFragment,
            bundleOf(
                "background" to data.background,
                "language" to data.language,
                "originalTitle" to data.originalTitle,
                "description" to data.description,
                "popularity" to data.popularity,
                "poster" to data.poster,
                "date" to data.date,
                "title" to data.title,
                "voteAverage" to data.voteAverage,
                "voteCount" to data.voteCount,
            )
        )
    }

}