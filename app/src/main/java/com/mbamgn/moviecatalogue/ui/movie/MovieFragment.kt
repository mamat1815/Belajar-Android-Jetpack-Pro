package com.mbamgn.moviecatalogue.ui.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.mbamgn.moviecatalogue.databinding.FragmentMovieBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieFragment : Fragment() {

    private lateinit var movieAdapter: MovieAdapter
    private var _binding: FragmentMovieBinding? = null
    private val binding get() = _binding
    private val viewModel: MovieFragmentViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): ConstraintLayout? {
        _binding = FragmentMovieBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        movieAdapter = MovieAdapter()
        binding?.rvMovie?.apply {
            adapter = movieAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }

        viewModel.getListMovie().observe(viewLifecycleOwner, {
            movieAdapter.setMovieData(it)
        })

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}