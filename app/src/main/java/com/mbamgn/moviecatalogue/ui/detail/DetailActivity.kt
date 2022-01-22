package com.mbamgn.moviecatalogue.ui.detail

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.mbamgn.moviecatalogue.R
import com.mbamgn.moviecatalogue.databinding.ActivityDetailMovieBinding
import com.mbamgn.moviecatalogue.model.DataItem
import kotlin.properties.Delegates


class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailMovieBinding
    private var id by Delegates.notNull<Int>()

    private val viewModel: DetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)

       // id = intent.getIntExtra(EXTRA_ID, id)

        binding.apply {

            //ViewModel
            viewModel.apply {
                getDetailMovie(585083)
                detailMovie.observe(this@DetailActivity, { data->
                    detailData(data)
                })
            }

            //Toolbar
            //ToolBar
            setSupportActionBar(toolbarDetailMovie)
            supportActionBar?.setDisplayShowTitleEnabled(false)
            toolbarDetailMovie.setNavigationOnClickListener {
                onBackPressed()
            }

        }

    }

    private fun detailData(data: DataItem) {
        binding.apply {

            tvToolbarTitleDetailMovie.text = data.title
            //tvDetailGenreMovie.text = data.genre
            percentDetailMovie.setProgress(data.rate!!, true)
            tvDetailTitleMovie.text = data.title
            tvDetailDescMovie.text = data.desc
            tvDetailTagMovie.text = data.tagline

            Glide.with(this@DetailActivity)
                .load("https://image.tmdb.org/t/p/w500${data.poster}")
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading))
                .error(R.drawable.ic_eror)
                .into(imgDetailPosterMovie)
        }

    }


    companion object {
        const val EXTRA_ID = "extra_id"
    }
}

