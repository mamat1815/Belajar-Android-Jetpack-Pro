package com.mbamgn.moviecatalogue.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import java.nio.channels.FileLock

@Parcelize
data class DataItem(

    @SerializedName("id")
    var id: Int,

    @SerializedName("title")
    var title: String?,

    @SerializedName("name")
    var name: String?,

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


    /*@SerializedName("genres")
    var tagline: String?,

     */


    ) : Parcelable


data class ItemResponse(
    @SerializedName("results")
    var result: List<DataItem>,
)
