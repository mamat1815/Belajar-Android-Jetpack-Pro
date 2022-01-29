package com.mbamgn.moviecatalogue.utils

import com.mbamgn.moviecatalogue.data.source.DataItem
import com.mbamgn.moviecatalogue.data.source.ItemResponse

object DataDummy {

    fun generateDummyMovie(): List<DataItem> {
        val movie = ArrayList<DataItem>()

        movie.add(DataItem(
            634649,
            "Spider-Man: No Way Home",
            "/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg",
            "/iQFcwSGbZXMkeyKrxbPnwnRo5fl.jpg",
            "Peter Parker is unmasked and no longer able to separate his normal life from the high-stakes of being a super-hero. When he asks for help from Doctor Strange the stakes become even more dangerous, forcing him to discover what it truly means to be Spider-Man.",
            "The Multiverse unleashed.",
            8.5F,
            "2021-12-15",
            null,
            null,
        ))

        movie.add(DataItem(
            524434,
            "Eternals",
            "/bcCBq9N1EMo3daNIjWJ8kYvrQm6.jpg",
            "/qBLEWvJNVsehJkEJqIigPsWyBse.jpg",
            "The Eternals are a team of ancient aliens who have been living on Earth in secret for thousands of years. When an unexpected tragedy forces them out of the shadows, they are forced to reunite against mankind’s most ancient enemy, the Deviants.",
            "In the beginning...",
            7.3F,
            "2021-11-03",
            null,
            null,
        ))
        return movie
    }

    fun generateDummyTvShow(): List<DataItem> {
        val tvShow = ArrayList<DataItem>()

        tvShow.add(DataItem(
            110492,
            null,
            "/hE3LRZAY84fG19a18pzpkZERjTE.jpg",
            "/oKt4J3TFjWirVwBqoHyIvv5IImd.jpg",
            "The continuing story of Peacemaker – a compellingly vainglorious man who believes in peace at any cost, no matter how many people he has to kill to get it – in the aftermath of the events of “The Suicide Squad.”",
            "Give peace a f#cking chance.",
            8.5F,
            null,
            "Peacemaker",
            "2022-01-13",
        ))

        tvShow.add(DataItem(
            85552,
            null,
            "/jtnfNzqZwN4E32FGGxx1YZaBWWf.jpg",
            "/oKt4J3TFjWirVwBqoHyIvv5IImd.jpg",
            "A group of high school students navigate love and friendships in a world of drugs, sex, trauma, and social media.",
            "Remember this feeling.",
            8.5F,
            null,
            "Euphoria",
            "2019-06-16",
        ))
        return tvShow
    }

}