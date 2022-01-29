package com.mbamgn.moviecatalogue.ui.tv_show

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.mbamgn.moviecatalogue.databinding.FragmentTvShowBinding
import com.mbamgn.moviecatalogue.utils.ViewModelFactory

class TvShowFragment : Fragment() {

    private lateinit var tvShowAdapter: TvShowAdapter
    private var _binding: FragmentTvShowBinding? = null
    private val binding get() = _binding
    private val viewModel by lazy {
        val viewModelFactory = activity?.application?.let {
            ViewModelFactory.getInstance()
        }
        viewModelFactory?.let {
            ViewModelProvider(this,
                it).get(TvShowFragmentViewModel::class.java)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): ConstraintLayout? {
        _binding = FragmentTvShowBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvShowAdapter = TvShowAdapter()

        binding?.rvTvShow?.apply {
            adapter = tvShowAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }

        viewModel?.apply {
            getListTvShow().observe(viewLifecycleOwner) {
                tvShowAdapter.setTvShowData(it)
            }

            getLoad().observe(viewLifecycleOwner) {
                setLoad(it)
            }
        }

    }

    private fun setLoad(state: Boolean) {
        binding?.pbListTvShow?.visibility = if (state) View.VISIBLE else View.INVISIBLE
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}