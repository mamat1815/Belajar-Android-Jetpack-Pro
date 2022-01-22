package com.mbamgn.moviecatalogue.ui.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.mbamgn.moviecatalogue.databinding.FragmentMovieBinding
import com.mbamgn.moviecatalogue.ui.adapter.MovieAdapter

class MovieFragment : Fragment() {

    private lateinit var viewModel: MovieFragmentViewModel
    private lateinit var movieAdapter: MovieAdapter
    private var _binding: FragmentMovieBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): LinearLayout? {
        _binding = FragmentMovieBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[MovieFragmentViewModel::class.java]
        movieAdapter = MovieAdapter()

        binding?.rvMovie?.apply {
            adapter = movieAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }

        viewModel.apply {
            getListMovie()
            listDataItem.observe(viewLifecycleOwner, { data ->
                movieAdapter.setMovieData(data)
            })

        }



    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}