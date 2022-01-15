package com.mbamgn.moviecatalogue.ui.adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.mbamgn.moviecatalogue.ui.main.MainActivity
import com.mbamgn.moviecatalogue.ui.movie.MovieFragment
import com.mbamgn.moviecatalogue.ui.tv_show.TvShowFragment


class MainViewPager(activity: AppCompatActivity) : FragmentStateAdapter(activity) {
    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = MovieFragment()
            1 -> fragment = TvShowFragment()
        }
        return fragment as Fragment
    }

    override fun getItemCount(): Int = MainActivity.TAB_TITLES.size

}