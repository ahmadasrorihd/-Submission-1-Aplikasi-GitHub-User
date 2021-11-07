package com.ahmadasrori.submission1_belajarfundamentalaplikasiandroid.model.detail

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

data class UserDetail(
    @SerializedName("login")
    val login: String?,

    @SerializedName("avatar_url")
    val avatar_url: String?,

    @SerializedName("name")
    val name: String?,

    @SerializedName("company")
    val company: String?,

    @SerializedName("location")
    val location: String?,

    @SerializedName("followers")
    val follower: String?,

    @SerializedName("following")
    val following: String?,

    @SerializedName("public_repos")
    val public_repos: String?

)

