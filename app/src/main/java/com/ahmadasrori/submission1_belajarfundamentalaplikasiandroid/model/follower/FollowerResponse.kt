package com.ahmadasrori.submission1_belajarfundamentalaplikasiandroid.model.follower

import com.google.gson.annotations.SerializedName

class FollowerResponse {
    @SerializedName("items")
    var list: List<Follower>? = null
}