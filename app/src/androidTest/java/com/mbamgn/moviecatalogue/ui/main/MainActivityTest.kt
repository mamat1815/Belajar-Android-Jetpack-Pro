package com.mbamgn.moviecatalogue.ui.main


import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.mbamgn.moviecatalogue.R
import com.mbamgn.moviecatalogue.utils.DataDummy
import org.junit.Rule
import org.junit.Test


class MainActivityTest {

    private val dummyMovie = DataDummy.generateDummyMovie()
    //private val dummyTvShow = DataDummy.generateDummyTvShows()

    @get: Rule
    var activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun loadMovie() {
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovie.size))
    }

    @Test
    fun loadDetailMovie() {
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.tv_toolbar_title_detail_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_toolbar_title_detail_movie)).check(matches(withText(dummyMovie[0].title)))
        onView(withId(R.id.img_detail_poster_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_genre_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_genre_movie)).check(matches(withText(dummyMovie[0].genre)))
        onView(withId(R.id.tv_detail_title_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.percent_detail_movie)).check(matches(isDisplayed()))


    }
}