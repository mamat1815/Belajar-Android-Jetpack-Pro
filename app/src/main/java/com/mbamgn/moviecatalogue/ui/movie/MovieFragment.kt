package com.mbamgn.moviecatalogue.ui.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.mbamgn.moviecatalogue.databinding.FragmentMovieBinding
import com.mbamgn.moviecatalogue.utils.ViewModelFactory

class MovieFragment : Fragment() {

    private lateinit var movieAdapter: MovieAdapter
    private var _binding: FragmentMovieBinding? = null
    private val binding get() = _binding

    private val viewModel by lazy {
        val viewModelFactory = activity?.application?.let {
            ViewModelFactory.getInstance()
        }
        viewModelFactory?.let {
            ViewModelProvider(this,
                it).get(MovieFragmentViewModel::class.java)
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): ConstraintLayout? {
        _binding = FragmentMovieBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory!!)[MovieFragmentViewModel::class.java]
        }

         */



        movieAdapter = MovieAdapter()
        binding?.apply {

            rvMovie.apply {
                adapter = movieAdapter
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

            }
            viewModel?.apply {

                getListMovie().observe(viewLifecycleOwner) {
                    movieAdapter.setMovieData(it)
                }

                getLoad().observe(viewLifecycleOwner) {
                    setLoad(it)
                }

            }

        }

    }

    private fun setLoad(state: Boolean) {
        binding?.pbListMovie?.visibility = if (state) View.VISIBLE else View.INVISIBLE
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}