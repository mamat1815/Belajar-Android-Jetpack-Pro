package com.mbamgn.moviecatalogue.ui.detail

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.mbamgn.moviecatalogue.R
import com.mbamgn.moviecatalogue.data.source.DataItem
import com.mbamgn.moviecatalogue.databinding.ActivityDetailMovieBinding
import com.mbamgn.moviecatalogue.utils.ViewModelFactory

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailMovieBinding
    private lateinit var type: String

    private val viewModel by lazy {
        val viewModelFactory = application.let { ViewModelFactory.getInstance() }
        viewModelFactory?.let {
            ViewModelProvider(this,
                it).get(DetailViewModel::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val id = intent.getIntExtra(EXTRA_ID, 0)
        type = intent.getStringExtra(EXTRA_TYPE)!!

        binding.apply {

            //ViewModel
            viewModel?.apply {
                getDetailData(type, id).observe(this@DetailActivity) { data ->
                    detailData(data)
                }

                getLoad().observe(this@DetailActivity) {
                    setLoad(it)
                }
            }

            //ToolBar
            setSupportActionBar(toolbarDetailMovie)
            supportActionBar?.setDisplayShowTitleEnabled(false)
            toolbarDetailMovie.setNavigationOnClickListener {
                onBackPressed()
            }

        }

    }

    private fun setLoad(state: Boolean) {
        binding.pbDetail.visibility = if (state) View.VISIBLE else View.INVISIBLE
    }

    private fun detailData(data: DataItem) {
        binding.apply {
            val typeData = "movie"
            if (typeData == type) {
                tvDetailTitle.text = data.title
            } else {
                tvDetailTitle.text = data.name
            }

            val percent = data.rate!! * 10
            percentDetail.setProgress(percent, false)

            if (data.desc.isNullOrEmpty()) {
                tvDetailDesc.text = resources.getString(R.string.no_desc)
            } else {
                tvDetailDesc.text = data.desc
            }

            if (data.tagline.isNullOrEmpty()) {
                tvDetailTag.text = resources.getString(R.string.no_tag)
            } else {
                tvDetailTag.text = data.tagline
            }

            Glide.with(this@DetailActivity)
                .load("https://image.tmdb.org/t/p/w500${data.poster}")
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading))
                .error(R.drawable.ic_eror)
                .into(imgDetailPoster)

            Glide.with(this@DetailActivity)
                .load("https://image.tmdb.org/t/p/w500${data.backdrop}")
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading))
                .error(R.drawable.ic_eror)
                .into(bgDetailToolbar)
        }

    }

    companion object {
        const val EXTRA_ID = "extra_id"
        const val EXTRA_TYPE = "extra_type"
    }
}

