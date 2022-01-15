package com.mbamgn.moviecatalogue.ui.detail_movie

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.mbamgn.moviecatalogue.R
import com.mbamgn.moviecatalogue.data.MovieEntity
import com.mbamgn.moviecatalogue.databinding.ActivityDetailMovieBinding

class DetailMovieActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailMovieBinding
    private lateinit var movieId: String

    private val viewModel: DetailMovieViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)

        movieId = intent.getStringExtra(EXTRA_ID).toString()

        binding.apply {


            //ViewModel
            viewModel.apply {
                setDetailMovie(movieId)
                detailData(getDetailMovie())
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

    private fun detailData(detailMovie: MovieEntity?) {
        binding.apply {

            if (detailMovie != null) {
                tvToolbarTitleDetailMovie.text = detailMovie.title
                tvDetailGenreMovie.text = detailMovie.genre
                percentDetailMovie.setProgress(detailMovie.percentage, true)
                tvDetailTitleMovie.text = detailMovie.title
                tvDetailDescMovie.text = detailMovie.desc
                tvDetailTagMovie.text = detailMovie.tag

                Glide.with(this@DetailMovieActivity)
                    .load(detailMovie.img)
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading))
                    .error(R.drawable.ic_eror)
                    .into(imgDetailPosterMovie)

            }

        }
    }

    companion object {
        const val EXTRA_ID = "extra_id"
    }

}