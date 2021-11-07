package com.ahmadasrori.submission1_belajarfundamentalaplikasiandroid.model.search

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Search(
    @SerializedName("login")
    val login: String?,

    @SerializedName("avatar_url")
    val avatar_url: String?

) : Parcelable

