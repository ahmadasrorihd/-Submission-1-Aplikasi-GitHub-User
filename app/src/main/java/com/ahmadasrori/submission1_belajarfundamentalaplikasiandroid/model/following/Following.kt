package com.ahmadasrori.submission1_belajarfundamentalaplikasiandroid.model.following

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Following(
    @SerializedName("login")
    val login: String?,

    @SerializedName("avatar_url")
    val avatar_url: String?

) : Parcelable

