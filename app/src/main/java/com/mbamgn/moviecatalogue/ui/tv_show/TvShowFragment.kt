package com.mbamgn.moviecatalogue.ui.tv_show

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.mbamgn.moviecatalogue.databinding.FragmentTvShowBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class TvShowFragment : Fragment() {

    private lateinit var tvShowAdapter: TvShowAdapter
    private var _binding: FragmentTvShowBinding? = null
    private val binding get() = _binding
    private val viewModel : TvShowFragmentViewModel by viewModel()

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

        viewModel.getListTvShow().observe(viewLifecycleOwner, {
            tvShowAdapter.setTvShowData(it)
        })

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}