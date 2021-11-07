package com.ahmadasrori.submission1_belajarfundamentalaplikasiandroid.model.search

import com.google.gson.annotations.SerializedName

class SearchResponse {
    @SerializedName("items")
    var list: List<Search>? = null
}