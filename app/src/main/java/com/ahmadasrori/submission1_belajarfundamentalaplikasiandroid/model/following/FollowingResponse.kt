package com.ahmadasrori.submission1_belajarfundamentalaplikasiandroid.model.following

import com.google.gson.annotations.SerializedName

class FollowingResponse {
    @SerializedName("items")
    var list: List<Following>? = null
}