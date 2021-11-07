package com.ahmadasrori.submission1_belajarfundamentalaplikasiandroid.model.detail

import com.google.gson.annotations.SerializedName

class UserDetailResponse {
    @SerializedName("items")
    var list: List<UserDetail>? = null
}