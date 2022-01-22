package com.mbamgn.moviecatalogue.ui.tv_show

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.mbamgn.moviecatalogue.databinding.FragmentTvShowBinding
import com.mbamgn.moviecatalogue.ui.adapter.MovieAdapter
import com.mbamgn.moviecatalogue.ui.adapter.TvShowAdapter

class TvShowFragment : Fragment() {

    private lateinit var viewModel: TvShowFragmentViewModel
    private lateinit var tvShowAdapter: MovieAdapter

    private var _binding: FragmentTvShowBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): LinearLayout? {
        _binding = FragmentTvShowBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[TvShowFragmentViewModel::class.java]
        tvShowAdapter = MovieAdapter()

        binding?.rvTvShow?.apply {
            adapter = tvShowAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }


        viewModel.apply {
            getListTvShow()
            listMovie.observe(viewLifecycleOwner, { data ->
                tvShowAdapter.setMovieData(data)
            })
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}