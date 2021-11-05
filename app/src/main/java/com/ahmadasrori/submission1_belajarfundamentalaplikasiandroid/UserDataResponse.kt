package com.ahmadasrori.submission1_belajarfundamentalaplikasiandroid

import com.google.gson.annotations.SerializedName

class UserDataResponse {
    @SerializedName("users")
    var list: List<UserData>? = null
}