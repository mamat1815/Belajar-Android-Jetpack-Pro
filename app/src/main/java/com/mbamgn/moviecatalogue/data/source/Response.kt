package com.mbamgn.moviecatalogue.data.source

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataItem(

    @SerializedName("id")
    var id: Int,

    @SerializedName("title")
    var title: String?,

    @SerializedName("poster_path")
    var poster: String?,

    @SerializedName("backdrop_path")
    var backdrop: String?,

    @SerializedName("overview")
    var desc: String?,

    @SerializedName("tagline")
    var tagline: String?,

    @SerializedName("vote_average")
    var rate: Float?,

    @SerializedName("release_date")
    var releaseDate: String?,

    //For TvShow
    @SerializedName("name")
    var name: String?,

    @SerializedName("first_air_date")
    var airDate: String?,

    ) : Parcelable


data class ItemResponse(
    @SerializedName("results")
    var result: List<DataItem>,
)
