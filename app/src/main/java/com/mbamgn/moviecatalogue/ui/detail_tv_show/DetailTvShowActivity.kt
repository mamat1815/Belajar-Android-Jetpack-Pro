package com.mbamgn.moviecatalogue.ui.detail_tv_show

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.mbamgn.moviecatalogue.R
import com.mbamgn.moviecatalogue.data.TvShowEntity
import com.mbamgn.moviecatalogue.databinding.ActivityDetailTvShowBinding

class DetailTvShowActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailTvShowBinding
    private lateinit var tvShowId: String

    private val viewModel: DetailTvShowViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailTvShowBinding.inflate(layoutInflater)
        setContentView(binding.root)

        tvShowId = intent.getStringExtra(EXTRA_ID).toString()

        binding.apply {

            //ViewModel
            viewModel.apply {
                setDetailTvShow(tvShowId)
                detailData(getDetailTvShow())
            }

            //ToolBar
            setSupportActionBar(toolbarDetailTvShow)
            supportActionBar?.setDisplayShowTitleEnabled(false)
            toolbarDetailTvShow.setNavigationOnClickListener {
                onBackPressed()
            }
        }

    }

    private fun detailData(data: TvShowEntity?) {
        binding.apply {
            if (data != null) {

                tvToolbarTitle.text = data.title
                tvDetailGenreTvShow.text = data.genre
                percentDetailTvShow.setProgress(data.percentage, true)
                tvDetailTitleTvShow.text = data.title
                tvDetailDescTvShow.text = data.desc
                tvDetailTagTvShow.text = data.tag

                Glide.with(this@DetailTvShowActivity)
                    .load(data.img)
                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading))
                    .error(R.drawable.ic_eror)
                    .into(imgDetailPosterTvShow)

            }
        }
    }

    companion object {
        const val EXTRA_ID = "extra_id"
    }

}