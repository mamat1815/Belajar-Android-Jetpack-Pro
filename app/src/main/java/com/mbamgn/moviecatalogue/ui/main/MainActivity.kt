package com.mbamgn.moviecatalogue.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayoutMediator
import com.mbamgn.moviecatalogue.R

import com.mbamgn.moviecatalogue.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {

            val mainPager = MainViewPager(this@MainActivity)
            vpMain.adapter = mainPager
            TabLayoutMediator(tabsMain, vpMain) { tabsMain, position ->
                tabsMain.text = resources.getString(TAB_TITLES[position])
            }.attach()

            //ToolBar
            tvToolbarTitleMain.text = resources.getString(R.string.app_name)

            //Title
            tvTitleRandom.text = resources.getString(R.string.random_movie)

            //RandomMovieToday
           // randomMovie(viewModel.getRandomMovie())

        }
    }

    /*private fun randomMovie(data: DataEntity) {
        binding.apply {

            tvTitleMain.text = data.title
            Glide.with(this@MainActivity)
                .load(data.img)
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading))
                .error(R.drawable.ic_eror)
                .into(imgMainPoster)

        }
    }

     */

    companion object {
        val TAB_TITLES = intArrayOf(
            R.string.movie,
            R.string.tv_show
        )
    }
}