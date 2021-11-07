package com.ahmadasrori.submission1_belajarfundamentalaplikasiandroid.data

import com.ahmadasrori.submission1_belajarfundamentalaplikasiandroid.model.User
import com.ahmadasrori.submission1_belajarfundamentalaplikasiandroid.model.detail.UserDetail
import com.ahmadasrori.submission1_belajarfundamentalaplikasiandroid.model.search.SearchResponse
import com.ahmadasrori.submission1_belajarfundamentalaplikasiandroid.remote.Api
import io.reactivex.Observable

class Repository(val api: Api) {

    fun searchUser(username: String?): Observable<SearchResponse> {
        return api.searchUser(username)
    }

    fun getFollower(username: String?): Observable<List<User>> {
        return api.getFollower(username)
    }

    fun getFollowing(username: String?): Observable<List<User>> {
        return api.getFollowing(username)
    }

    fun getDetailUser(username: String?): Observable<UserDetail> {
        return api.getDetailUser(username)
    }

}