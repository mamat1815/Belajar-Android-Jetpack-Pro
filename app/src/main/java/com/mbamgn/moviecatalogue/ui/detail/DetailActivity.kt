package com.mbamgn.moviecatalogue.ui.detail

import android.os.Bundle
import android.widget.Toast
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
    private lateinit var type: String

    private val viewModel: DetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val id = intent.getIntExtra(EXTRA_ID, 0)
        type = intent.getStringExtra(EXTRA_TYPE)!!

        binding.apply {

            //ViewModel
            viewModel.apply {
                getDetailMovie(type, id)
                detailMovie.observe(this@DetailActivity, { data->
                    detailData(data)
                })

                p.observe(this@DetailActivity, {
                    Toast.makeText(this@DetailActivity, it, Toast.LENGTH_SHORT).show()
                })

            }
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
            val typeData = "movie"
            if (typeData == type) {
                tvDetailTitleMovie.text = data.title
                tvToolbarTitleDetailMovie.text = data.title
            } else {
                tvDetailTitleMovie.text = data.name
                tvToolbarTitleDetailMovie.text = data.name
            }


            //tvDetailGenreMovie.text = data.genre
            val percent = data.rate!! * 10
            percentDetailMovie.setProgress(percent, false)

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
        const val EXTRA_TYPE = "extra_type"
    }
}

